package com.BookStore.Service;

import java.sql.Date;

public class Book {
//	BOOK_NUMBER NOT NULL NUMBER(5)    
//	BOOK_NAME   NOT NULL VARCHAR2(38) 
//	BOOK_STOCK           NUMBER(5)    
//	BOOK_PRICE  NOT NULL NUMBER(10)   
//	BOOK_TYPE            VARCHAR2(20) 
//	BOOK_AUTHOR          VARCHAR2(20)
	
	private int bookNumber;
	private	String bookName;
	private int bookStock;
	private int Price;
	private String type;
	private String author;
	private Date orderDate;
	private String synopsis;

	//매출테이블을 활용하기위해 추가하였음..
	private int userNumber;
	private String userName;
	
	



	public int getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookStock() {
		return bookStock;
	}
	public void setBookStock(int bookStock) {
		this.bookStock = bookStock;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	@Override
	public String toString() {
		return "\tISBN : " + bookNumber + "\t책이름 : " + "\""+bookName+"\""
				+ "\t가격 : " + Price + "\t카테고리 : " + type + "\t저자 : " + author + "\t재고 : " + bookStock;
	}
	public String toStringIntroduce() {
		return "\tISBN : " + bookNumber + "\n\t책이름 : " + "\""+bookName+"\""
				+ "\n\t가격 : " + Price + "\n\t카테고리 : " + type + "\n\t저자 : " + author + "\n\t재고 : " + bookStock;
	}
	
	public String toStringSalesList() {
		return "\n\t구매자 : " + userName + "\tISBN : " + bookNumber + "\n\t책이름 : " + "\""+bookName+"\""
				+ "\n\t가격 : " + Price + "\n\t재고 : " + bookStock;
	}
		
	
}
