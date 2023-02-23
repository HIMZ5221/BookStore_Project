package com.BookStore.DAO;

import java.util.ArrayList;
import java.util.List;
import com.BookStore.Service.Book;

public class BookDAO extends DAO {
	//도서 전체조회 그리고 구매까지..
	

	public List<Book> getBookList(){
		List<Book> bookList = new ArrayList<>();
		Book book = null;
		try {
			conn();
			String sql = "SELECT * FROM BookStore_Books";			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				book = new Book();
				book.setBookNumber(rs.getInt("book_number"));
				book.setBookName(rs.getString("book_name"));
				book.setBookStock(rs.getInt("book_stock"));
				book.setPrice(rs.getInt("book_price"));
				book.setType(rs.getString("book_type"));
				book.setAuthor(rs.getString("book_author"));
				
				bookList.add(book);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return bookList;
	}	
}
