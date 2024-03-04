package com.bookShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookShop.service.MyBookListService;

@Controller
public class MyBookListController {

		@Autowired
		private MyBookListService service;
	
		@RequestMapping("/deleteMyList/{id}")
		public String deleteMyList(@PathVariable("id") int id ) {
			service.deleteBook(id);
			return "redirect:/my_books";
		}
}
