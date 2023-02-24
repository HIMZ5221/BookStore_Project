package com.BookStore.MasterMenu;

import java.util.Scanner;

import com.BookStore.Service.UserService;

public class MasterMenuPage {
	
	Scanner sc = new Scanner(System.in);
	String menu = "";
	MasterMenuPage_Service_001 mms = new MasterMenuPage_Service_001();
	
	
	public void MasterMenu() {
		boolean run = true;
		
		while (run) {
			//첫 콘솔 출력 창이다.. 이 while문에서 모든게 반복되어야만 하며, 최후방 콘솔지역임.
			//프로그램 종료는 나중에 생각한다.
			System.out.println("==============================================");
			System.out.println("===1.유저관리 | 2.도서관리 | 3.판매기록 | 4.뒤로가기====");
			System.out.println("==============================================");
			menu = sc.nextLine();
			
			switch (menu) {
			case "1" :
				UserManagement();
				break;
			case "2" :
				
				
				break;
			case "3" : 
				mms.SalesList();
				break;
			case "4" : 
				run = false;
				//로그아웃 전 객체에 등록된 고객데이터 삭제.
				UserService.userInfo = null;
				System.out.println("유저의 객체값은 null 입니다.");
				break;
			}
			
			
		}
	}
	public void UserManagement() {
		UserService us = new UserService();
		
		boolean run = true;
		
		while (run) {
			//유저조회에 들어올 시, 전체 유저를 한번 보여줌.
			mms.ViewAllUser();
			
			System.out.println("=============================================");
			System.out.println("===1.유저등록 | 2.유저삭제 | 3.유저검색 | 4.뒤로가기====");
			System.out.println("=============================================");
			menu = sc.nextLine();
			
			switch (menu) {
			case "1" :
				us.SignUp();
				break;
			case "2" :
				mms.DeleteUser();
				//유저삭제
				break;
			case "3" :
				//유저삭제
				break;
			case "4" : 
				run = false;
				//로그아웃 전 객체에 등록된 고객데이터 삭제.
				UserService.userInfo = null;
				System.out.println("유저의 객체값은 null 입니다.");
				break;
			}
			
			
		}
	}
}
