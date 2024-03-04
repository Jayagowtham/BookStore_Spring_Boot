package com.bookShop.service;

import java.util.List;

import com.bookShop.model.Book;
import com.bookShop.model.MyBookList;

public interface MyBookListService {

	
	MyBookList addMyBook(MyBookList mybook);
	List<MyBookList> showAllBooks();
	void deleteBook(Integer bok);
}
