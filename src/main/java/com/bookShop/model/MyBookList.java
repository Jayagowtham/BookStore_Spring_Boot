package com.bookShop.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="mybook")
public class MyBookList {
	@Id
	private Integer bar_code;
	private String publisher;
	private String name;
	private String author;
	private Integer price;
	private String type;
	private String status;
	
	
	public MyBookList(Integer bar_code, String publisher, String name, String author, Integer price, String type,
			String status) {
		super();
		this.bar_code = bar_code;
		this.publisher = publisher;
		this.name = name;
		this.author = author;
		this.price = price;
		this.type = type;
		this.status = status;
	}
	
	
	public MyBookList() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getBar_code() {
		return bar_code;
	}
	public void setBar_code(Integer bar_code) {
		this.bar_code = bar_code;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
