package com.BookStore.DAO;

import java.util.ArrayList;
import java.util.List;
import com.BookStore.Service.Book;
import com.BookStore.Service.User;
import com.BookStore.Service.UserService;

public class BookDAO extends DAO {
	//도서 전체조회 그리고 구매까지..
	
	//전체 책 리스트 불러오기
	public List<Book> getBookList(){
		List<Book> bookList = new ArrayList<>();
		Book book = null;
		try {
			conn();
			String sql = "SELECT * FROM BookStore_Books order by book_number";			
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

	//책 구매 메소드, 두개의 객체를 전달 받음
	public int BookBuy(Book book, User user) {
		int result = 0;
		System.out.println(book.getBookNumber());
		System.out.println(user.getUserNumber());
		System.out.println(book.getBookStock());
		try {
			conn();
			String bookSql = "update BookStore_Books set book_stock = book_stock - 1 where book_number = ?";			
			pstmt = conn.prepareStatement(bookSql);
			pstmt.setInt(1, book.getBookNumber());
			result += pstmt.executeUpdate();
			
			String userSql = "update bookstore_users set user_money = ? - ? where user_number = ?";			
			pstmt = conn.prepareStatement(userSql);
			pstmt.setInt(1, user.getUserMoney());
			pstmt.setInt(2, book.getPrice());
			pstmt.setInt(3, user.getUserNumber());
			result += pstmt.executeUpdate();
			
			String oderSql = "INSERT INTO BookStore_UserBookList (user_number, user_name, book_number, book_name, price, BOOK_STOCK, BOOK_TYPE, BOOK_AUTHOR) "
					+ " VALUES (?,?,?,?,?,?,?,?)";			
			pstmt = conn.prepareStatement(oderSql);
			pstmt.setInt(1, user.getUserNumber());
			pstmt.setString(2, user.getUserName());
			pstmt.setInt(3, book.getBookNumber());
			pstmt.setString(4, book.getBookName());
			pstmt.setInt(5, book.getPrice());
			pstmt.setInt(6, book.getBookStock());
			pstmt.setString(7, book.getType());
			pstmt.setString(8, book.getAuthor());
			result += pstmt.executeUpdate();          
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return result;
	}
	
	//책 종류별
	public int TypeBookBuy(Book book, User user) {
		int result = 0;
		System.out.println(book.getBookNumber());
		System.out.println(user.getUserNumber());
		System.out.println(book.getBookStock());
		try {
			conn();
			String bookSql = "update BookStore_Books set book_stock = book_stock - 1 where book_number = ?";			
			pstmt = conn.prepareStatement(bookSql);
			pstmt.setInt(1, book.getBookNumber());
			result += pstmt.executeUpdate();
			
			String userSql = "update bookstore_users set user_money = ? - ? where user_number = ?";			
			pstmt = conn.prepareStatement(userSql);
			pstmt.setInt(1, user.getUserMoney());
			pstmt.setInt(2, book.getPrice());
			pstmt.setInt(3, user.getUserNumber());
			result += pstmt.executeUpdate();
			
			String oderSql = "INSERT INTO BookStore_UserBookList (user_number, user_name, book_number, book_name, price, BOOK_STOCK, BOOK_TYPE, BOOK_AUTHOR) "
					+ " VALUES (?,?,?,?,?,?,?,?)";			
			pstmt = conn.prepareStatement(oderSql);
			pstmt.setInt(1, user.getUserNumber());
			pstmt.setString(2, user.getUserName());
			pstmt.setInt(3, book.getBookNumber());
			pstmt.setString(4, book.getBookName());
			pstmt.setInt(5, book.getPrice());
			pstmt.setInt(6, book.getBookStock());
			pstmt.setString(7, book.getType());
			pstmt.setString(8, book.getAuthor());
			result += pstmt.executeUpdate();
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return result;
	}
	
	//나의 책 조회
	public List<Book> MyBook() {
		List<Book> list = new ArrayList<>();
		Book mem = null;
		try {
			conn();
			String sql = "select b.* from bookstore_users a right outer join BookStore_UserBookList b\r\n"
					+ "on a.user_number = b.user_number\r\n"
					+ "where a.user_number = ? order by oder_date";			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, UserService.userInfo.getUserNumber());
			rs = pstmt.executeQuery();
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				mem = new Book();
				mem.setBookNumber(rs.getInt("book_number"));
				mem.setBookName(rs.getString("book_name"));
				mem.setPrice(rs.getInt("price"));
				mem.setBookStock(rs.getInt("book_stock"));
				mem.setType(rs.getString("book_type"));
				mem.setAuthor(rs.getString("book_author"));
				mem.setOrderDate(rs.getDate("oder_date"));
				
				list.add(mem);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	public List<Book> GroupBookList(){
		List<Book> list = new ArrayList<>();
		Book mem = null;
		try {
			conn();
			String sql = "select book_type FROM BookStore_books group by book_type ";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				mem = new Book();
				mem.setType(rs.getString("book_type"));
				
				list.add(mem);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
		
	}
	
	//카테고리에서 고른 책 리스트보기
	public List<Book> SelectBookList(String type){
		List<Book> bookList = new ArrayList<>();
		Book book = null;
		try {
			conn();
			String sql = "SELECT * FROM BookStore_Books where book_type = ?";			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type);
			rs = pstmt.executeQuery();
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
