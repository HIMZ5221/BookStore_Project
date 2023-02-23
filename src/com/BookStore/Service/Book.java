package com.BookStore.Service;

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
	@Override
	public String toString() {
		return "\tISBN : " + bookNumber + "\t책이름 : " + "\""+bookName+"\""
				+ "\t가격 : " + Price + "\t카테고리 : " + type + "\t저자 : " + author + "\t재고 : " + bookStock;
	}
	public String toStringIntroduce() {
		return "\tISBN : " + bookNumber + "\n\t책이름 : " + "\""+bookName+"\""
				+ "\n\t가격 : " + Price + "\n\t카테고리 : " + type + "\n\t저자 : " + author + "\n\t재고 : " + bookStock;
	}
	
		
	
}
