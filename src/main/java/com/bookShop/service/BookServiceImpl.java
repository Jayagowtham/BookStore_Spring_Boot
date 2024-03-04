package com.bookShop.service;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookShop.model.Book;
import com.bookShop.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepo;

	@Override
	public List<Book> showAllBooks() {
		
		return bookRepo.findAll();
	}
	

	public Book getBookById(int id) {
		return bookRepo.findById(id).get();
	}
	//@Override                                         used for find the data and taking them
	//public Optional<Book> searchBook(int id) 
	//{
	//	return bookRepo.findById(id);
	//}
	
	
	@Override
	public Book addNewBook(Book book) {
		
		return bookRepo.save(book);
	}
	@Override
	public void deleteBook(Integer bok) {
		bookRepo.deleteById(bok);
	
	}
}
