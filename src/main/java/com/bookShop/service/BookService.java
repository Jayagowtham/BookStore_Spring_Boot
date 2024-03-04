package com.bookShop.service;

import java.util.List;
//import java.util.Optional;

import com.bookShop.model.Book;



public interface BookService {
	
	List<Book> showAllBooks();
//	Optional<Book> searchBook(int id);
	Book getBookById(int id);
	Book addNewBook(Book book);
	void deleteBook(Integer bok);

}
