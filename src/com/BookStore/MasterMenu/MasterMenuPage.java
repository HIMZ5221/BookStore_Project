package com.BookStore.MasterMenu;

import java.util.Scanner;

import com.BookStore.Service.UserService;

public class MasterMenuPage {
	
	Scanner sc = new Scanner(System.in);
	int menu = 0;
	
	
	
	public void MasterMenu() {
		boolean run = true;
		
		while (run) {
			//첫 콘솔 출력 창이다.. 이 while문에서 모든게 반복되어야만 하며, 최후방 콘솔지역임.
			//프로그램 종료는 나중에 생각한다.
			System.out.println("==========================================================");
			System.out.println("===1.유저조회 | 2.도서등록 | 3.도서삭재 | 4.주문목록조회 | 5.뒤로가기====");
			System.out.println("==========================================================");
			menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1 :
				
				break;
			case 2 :
				
				
				break;
			case 3 : 
				
				break;
			case 4 : 
				run = false;
				//로그아웃 전 객체에 등록된 고객데이터 삭제.
				UserService.userInfo = null;
				System.out.println("유저의 객체값은 null 입니다.");
				break;
			}
			
			
		}
	}
}
