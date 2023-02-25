package com.BookStore.DAO;

import java.util.Scanner;


public class MainMenuPage_DAO_001 extends DAO{

	Scanner sc = new Scanner(System.in);
	private static MainMenuPage_DAO_001 MainPageDao = null;			
	
	private MainMenuPage_DAO_001() {
		
	}
	
	public static MainMenuPage_DAO_001 getInstance() {
		if(MainPageDao == null) {
			MainPageDao = new MainMenuPage_DAO_001();
		}
		return MainPageDao;
	}
	
	
	//유저 데이터 변경 입니다 !
	public int ChangeEmail(String type, String newDate ,int number) {
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
	
	
	//캐시충전...
	public int CashCharging(int plusCash, int number) {
	int result = 0;
			try {
				conn();
				String sql = "update bookStore_users set user_money = user_money+? where user_number = ?";			
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, plusCash);
				pstmt.setInt(2, number);
				result = pstmt.executeUpdate();
	
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				disconn();
			}
			
			return result;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//왜만든겨? ㅋㅋㅋㅋㅋㅋㅋ18
	//상장폐지..
//	public User UserPrivacy() {
//		//이거 잘 쓰라잉!!
//		int number = UserService.userInfo.getUserNumber();
//		User mem = null;
//		try {
//			conn();
//			String sql = "SELECT * FROM bookStore_users WHERE user_number = ?";			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, number);
//			rs = pstmt.executeQuery();
//
//			
//			if(rs.next()) {
//				mem = new User();
//				mem.setUserNumber(rs.getInt("user_number"));
//				mem.setUserName(rs.getString("user_name"));
//				mem.setUserId(rs.getString("user_id"));
//				mem.setUserPw(rs.getString("user_pw"));
//				mem.setUserBirth(rs.getString("user_birth"));
//				mem.setHiredate(rs.getDate("hiredate")); //유심히 지켜볼것
//				mem.setUserTel(rs.getString("user_tel"));
//				mem.setUserAge(rs.getInt("user_age"));
//				mem.setUserMail(rs.getString("user_mail"));
//				mem.setUserMoney(rs.getInt("user_money"));
//				
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			disconn();
//		}
//		
//		return mem;
//		
//	}	
	
	
	
	
}
