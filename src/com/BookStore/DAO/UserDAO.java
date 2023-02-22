package com.BookStore.DAO;

import java.util.ArrayList;
import java.util.List;

import com.BookStore.Service.User;

public class UserDAO extends DAO{

	private static UserDAO userDao = null;
	
	
	private UserDAO() {
		
	}
	
	public static UserDAO getInstance() {
		if(userDao == null) {
			userDao = new UserDAO();
		}
		return userDao;
	}
	
	
	//로그인
	public User login(String id) {
		User mem = null;
		try {
			conn();
			String sql = "SELECT * FROM bookStore_users WHERE user_id = ?";			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			
			if(rs.next()) {
				mem = new User();
				mem.setUserId(rs.getString("user_id"));
				mem.setUserPw(rs.getString("user_pw"));
				mem.setUserName(rs.getString("user_name"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return mem;
	}
	//회원가입
	public int SignUp(User user) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO bookStore_users (user_number, user_name, user_id, user_pw,\r\n"
					+ "    user_birth, user_tel, user_age, user_mail)\r\n"
					+ "    VALUES (bookStore_users_seq.NEXTVAL,?, ?, ?, ?, ?, ?, ?)";		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserId());
			pstmt.setString(3, user.getUserPw());
			pstmt.setString(4, user.getUserBirth());
			pstmt.setString(5, user.getUserTel());
			pstmt.setInt(6, user.getUserAge());
			pstmt.setString(7, user.getUserMail());
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return result;
		
		
	}
	
	//회원가입 시 중복데이터 비교메소드
	public List<User> SignUpCompare() {
		List<User> list = new ArrayList<>();
		User mem = null;
		try {
			conn();
			String sql = "SELECT * FROM bookStore_users";			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				mem = new User();
				mem.setUserId(rs.getString("user_id"));
				mem.setUserTel(rs.getString("user_tel"));
				mem.setUserMail(rs.getString("user_mail"));
				
				list.add(mem);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//마스터로그인
	public User MasterLogin() {
		User mem = null;
		try {
			conn();
			String sql = "SELECT user_id,user_pw,user_name FROM bookStore_users WHERE user_id = 'himz5221'";			
			stmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);

			
			if(rs.next()) {
				mem = new User();
				mem.setUserId(rs.getString("user_id"));
				mem.setUserPw(rs.getString("user_pw"));
				mem.setUserName(rs.getString("user_name"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return mem;
	}
	
}
