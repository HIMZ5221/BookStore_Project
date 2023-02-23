package com.BookStore.DAO;

import java.util.ArrayList;
import java.util.List;
import com.BookStore.Service.Book;
import com.BookStore.Service.User;

public class BookDAO extends DAO {
	//도서 전체조회 그리고 구매까지..
	
	//전체 책 리스트 불러오기
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
	
	//선택한 책 구매
		//여기서부터 시작//선택한 책 구매
	//여기서부터 시작//선택한 책 구매
	//여기서부터 시작//선택한 책 구매
	//여기서부터 시작//선택한 책 구매
	//여기서부터 시작//선택한 책 구매
	//여기서부터 시작//선택한 책 구매
	//여기서부터 시작//선택한 책 구매
	//여기서부터 시작//선택한 책 구매
	//여기서부터 시작//선택한 책 구매
	//여기서부터 시작
	
	
	public int BookBuy(Book book, User user) {
		int result = 0;
		try {
			conn();
			String sql = "update bookStore_users set user_money = user_money+? where user_number = ?";			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book.getPrice());
			pstmt.setInt(2, user.getUserMoney());
			result = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return result;
	}
	
	
}
