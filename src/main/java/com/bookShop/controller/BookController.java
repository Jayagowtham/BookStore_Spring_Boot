package com.bookShop.controller;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookShop.model.Book;
import com.bookShop.model.MyBookList;
import com.bookShop.service.BookService;
import com.bookShop.service.MyBookListService;


@Controller
public class BookController {
	
	@Autowired
 private BookService service;    // changed from  bookservice to service
	
	@Autowired
	private MyBookListService myBookService;
	
	@GetMapping("/")
	public String homePage() 
	{
		return "index";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Book>list=service.showAllBooks();
	//	ModelAndView m= new ModelAndView();                        for these 3 lines you can directly call from return like 
	//	m.setViewName("bookList");
	//	m.addObject("book",list);
		return new ModelAndView("bookList","book",list);
	}
	
	@PostMapping("/add")                  /// this "add" is from book register the th:action- add. so be careful
	public String addBook(@ModelAttribute Book b) {
		service.addNewBook(b);   // in video its save method but for me its addnewbook method
		return "redirect:/available_books";	
	}
	
	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBookList>list=myBookService.showAllBooks();
		model.addAttribute("book",list);
		return "myBooks";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id ) {
		Book b=service.getBookById(id);
		MyBookList mb = new MyBookList(b.getBar_code(), b.getPublisher(), b.getName(), b.getAuthor(), b.getPrice(), b.getType(), b.getStatus());  // for this line to work create constructors and super.constructor fields.
		myBookService.addMyBook(mb);
		return "redirect:/my_books";
	}
	
	
	@GetMapping("/editBook/{id}")
	public String editPage(@PathVariable("id")Integer bok, Model model)
	{
		model.addAttribute("obj", service.getBookById(bok));
		return "bookEdit";
	}
	
	@PostMapping("/edit")                                             // this /edit from html editbook and the th:/edit careful!!!!
	public String editBook(@ModelAttribute("obj") Book book) {
		service.addNewBook(book);
		return "redirect:/available_books";
	}
	
	@GetMapping("/deleteBook/{id}")
	public String deletePage(@PathVariable("id") Integer bok)
	{
		service.deleteBook(bok);
		return "redirect:/available_books";
	}
		
}
	
/*  @GetMapping("/available_books")
	public String viewPage(Model model)
	{
		model.addAttribute("allBooks", bookservice.showAllBooks());
		return "view";
	}
	@GetMapping("/book_register")
	public String addPage(Model model)
	{
		model.addAttribute("obj",new Book());
		return "add";
	}
	
	@PostMapping("/book_register")
	public String addBook(@ModelAttribute("obj") Book book)
	{
		Optional<Book> opt=bookservice.searchBook(book.getBar_code());
		if(opt.isEmpty())
		{
			bookservice.addNewBook(book);
			return "redirect:/view";
		}
		else
		{
			return "redirect:/add?failed";
		}
	}
	@GetMapping("/edit/{id}")                            
	public String editPage(@PathVariable("id")Integer bok, Model model)             // the bok is a new variable created for pojo id 
	{
		model.addAttribute("obj", bookservice.searchBook(bok));
		return "/edit";                                 
	}
	@PostMapping("/edit")
	public String editBike(@ModelAttribute("obj") Book book)           // the Bike bike is converting the variable into local once
	{
		bookservice.addNewBook(book);
		return "redirect:/view";                       // this statement will be same as in controller line 49 becoz only edit is going so new methods
	}
	
	@GetMapping("/delete/{id}")
	public String deletePage(@PathVariable("id") Integer bok)
	{
		bookservice.deleteBook(bok);
		return "redirect:/view";
	}
	
	*/

