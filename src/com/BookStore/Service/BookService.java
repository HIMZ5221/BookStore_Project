package com.BookStore.Service;

import java.util.List;

import com.BookStore.DAO.BookDAO;

public class BookService {
	BookDAO instance = new BookDAO();
	
	public void getBookList() {
		List<Book> list = instance.getBookList();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("  ↓ 숫자입력");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("[ "+(i+1)+" ] "+list.get(i).toString());
		}
		System.out.println();
	}
}
