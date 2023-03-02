package com.BookStore.Service;

import java.sql.Date;

public class Book {
	
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
	public String toString() { //모든 list 출력
		return "\tISBN : " + bookNumber	+ "\t| 가격 : " + Price + "\t카테고리 : "
				+ type +" | " + "\t\t책이름 : " + "\""+bookName+"\"";
	}
//	public String toString() { //모든 list 출력
//		return "\tISBN : " + bookNumber + "\t책이름 : " + "\""+bookName+"\""
//				+ "\t\t| 가격 : " + Price + "\t카테고리 : " + type + "\t저자 : " + author + "\t재고 : " + bookStock;
//	}
	
	
	public String toStringIntroduce() {
		return "\t\tISBN : " + bookNumber + "\n\t\t책이름 : " + "\""+bookName+"\""
				+ "\n\t\t가격 : " + Price + "\n\t\t카테고리 : " + type + "\n\t\t저자 : " + author + "\n\t\t재고 : " + bookStock;
	}
	
	
	public String toStringSalesList() {
		return "\n\t\t구매자 : " + userName + "\t\tISBN : " + bookNumber + "\n\t\t책이름 : " + "\""+bookName+"\""
				+ "\t\t가격 : " + Price + "\n";
	}
		
	
}
