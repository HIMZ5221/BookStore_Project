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
	
	//객체 생성
	public static MasterMenuPage_DAO_001 getInstance() {
		if(MasterPageDao == null) {
			MasterPageDao = new MasterMenuPage_DAO_001();
		}
		return MasterPageDao;
	}
	
	//모든 유저 보기
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
	
	//유저삭제
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
	
	//유저검색
	public List<User> UserSearch(String searchString, int searchInt){
		List<User> list = new ArrayList<>();
		User mem = null;
		try {
			conn();
			String sql = "select *\r\n"
					+ "from BookStore_Users\r\n"//이름, 고유번호, 핸드폰번호, 이메일, ID
					+ "where INSTR(user_name, ?) > 0 OR INSTR(user_number, ?) > 0 OR INSTR(user_tel, ?) > 0 OR INSTR(user_mail, ?) > 0 OR INSTR(user_id, ?) > 0";
								
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchString);
			pstmt.setInt(2, searchInt);
			pstmt.setString(3, searchString);
			pstmt.setString(4, searchString);
			pstmt.setString(5, searchString);

			rs = pstmt.executeQuery();
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
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
	
	//유저 데이터 변경 입니다 !
	//시간 단축을 위해 int 데이터인 money, age 데이터만 해당하는 메소드
	public int ChangeDateInt(String type, int newDate ,int number) {
		int result = 0;
		
		try {
			conn();
			String sql = "update bookStore_users set "+ type +  " = ? where user_number = ? ";			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, newDate);
			pstmt.setInt(2, number);
			result = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return result;
	}
	
	public int ChangeDateString(String type, String newDate ,int number) {
		int result = 0;
		
		try {
			conn();
			String sql = "update bookStore_users set "+ type +  " = ? where user_number = ? ";			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newDate);
			pstmt.setInt(2, number);
			result = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return result;
	}
	
	//판매기록 조회
	public List<Book> SalesList() {
		List<Book> list = new ArrayList<>();
		Book mem = null;
		try {
			conn();
			String sql = "select * from BookStore_UserBookList";
								
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
				mem.setType(rs.getString("BOOK_TYPE"));
				
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
