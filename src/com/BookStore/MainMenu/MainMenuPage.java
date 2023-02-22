package com.BookStore.MainMenu;

import java.util.Scanner;

import com.BookStore.Service.UserService;


public class MainMenuPage {

		Scanner sc = new Scanner(System.in);
		int menu = 0;
		boolean run = true;
		
		//일반회원이 로그인했을떄 보는 창임.
		public void MainMenu() {
			while (run) {
				//첫 콘솔 출력 창이다.. 이 while문에서 모든게 반복되어야만 하며, 최후방 콘솔지역임.
				//프로그램 종료는 나중에 생각한다.
				System.out.println("===================================");
				System.out.println("===1.개인정보 | 2.도서조회 | 3.중고장터 | 4.로그아웃====");
				System.out.println("===================================");
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


