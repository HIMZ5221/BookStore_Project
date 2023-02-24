package com.BookStore.DAO;

import java.util.ArrayList;
import java.util.List;

import com.BookStore.Service.Book;
import com.BookStore.Service.User;
import com.BookStore.Service.UserService;

public class MasterMenuPage_DAO_001 extends DAO {
	
private static MasterMenuPage_DAO_001 MasterPageDao = null;			
	
	private MasterMenuPage_DAO_001() {
		
	}
	
	public static MasterMenuPage_DAO_001 getInstance() {
		if(MasterPageDao == null) {
			MasterPageDao = new MasterMenuPage_DAO_001();
		}
		return MasterPageDao;
	}
	
	public List<User> ViewAllUser() {
		List<User> list = new ArrayList<User>();
		User mem = null;
		try {
			conn();
			String sql = "select * from bookstore_users";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				mem = new User();
				mem.setUserNumber(rs.getInt("user_number"));
				mem.setUserName(rs.getString("user_name"));
				mem.setUserId(rs.getString("user_id"));
				mem.setUserPw(rs.getString("user_pw"));
				mem.setUserBirth(rs.getString("user_birth"));
				mem.setHiredate(rs.getDate("hiredate")); //유심히 지켜볼것
				mem.setUserTel(rs.getString("user_tel"));
				mem.setUserAge(rs.getInt("user_age"));
				mem.setUserMail(rs.getString("user_mail"));
				mem.setUserMoney(rs.getInt("user_money"));
				
				list.add(mem);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	public int DeleteUser(User user) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE\r\n"
					+ "FROM bookstore_users\r\n"
					+ "WHERE USER_NUMBER = ?";		
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getUserNumber());
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return result;
	}
	
	public List<Book> SalesList() {
		List<Book> list = new ArrayList<>();
		Book mem = null;
		try {
			conn();
			String sql = "select book_number,oder_date, user_number, user_name, book_name, price from BookStore_UserBookList";
								
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, UserService.userInfo.getUserNumber());
//			rs = pstmt.executeQuery();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				mem = new Book();
				mem.setOrderDate(rs.getDate("oder_date"));
				mem.setUserNumber(rs.getInt("user_number"));
				mem.setUserName(rs.getString("user_name"));
				mem.setBookName(rs.getString("book_name"));
				mem.setBookNumber(rs.getInt("book_number"));
				mem.setPrice(rs.getInt("price"));
				
				list.add(mem);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	
	
	
}
