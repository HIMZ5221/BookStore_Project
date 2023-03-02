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

}
