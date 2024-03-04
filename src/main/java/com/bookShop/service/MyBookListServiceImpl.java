package com.bookShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookShop.model.Book;
import com.bookShop.model.MyBookList;
import com.bookShop.repository.MyBookRepository;

@Service
public class MyBookListServiceImpl implements MyBookListService{

	@Autowired
	private MyBookRepository mybookRepo;
	
	@Override
	public MyBookList addMyBook(MyBookList mybook){
		
		return mybookRepo.save(mybook);
	}
	
	public List<MyBookList> showAllBooks() {
		
		return mybookRepo.findAll();
	}
	
	public void deleteBook(Integer bok) {
		mybookRepo.deleteById(bok);
	
	}
	
}
