package com.BookStore.MainMenu;

import java.util.Scanner;

import com.BookStore.Service.MainMenuPage_Service_001;
import com.BookStore.Service.UserService;


public class MainMenuPage {

		Scanner sc = new Scanner(System.in);
		
		MainMenuPage_Service_001 mainMS = new MainMenuPage_Service_001();
		MainBookPage_Servuce_001 mainBP = new MainBookPage_Servuce_001();
		
		//일반회원이 로그인했을떄 보는 창임.
		public void MainMenu() {
			boolean run = true;
			String menu = "";
			
			while (run) {
				//첫 콘솔 출력 창이다.. 이 while문에서 모든게 반복되어야만 하며, 최후방 콘솔지역임.
				//유저객체에 등록된 데이터는 로그아웃으로 삭제한다..
				System.out.println("메인 페이지 입니다. 원하는 서비스를 선택하세요. \n\n");
				System.out.print("Login : "+UserService.userInfo.getUserName());
				System.out.println("\tID : "+UserService.userInfo.getUserId());
				System.out.println();
				System.out.println("====================================================");
				System.out.println("===1.개인정보 조회 | 2.교보문고 입장 | 3.중고장터 | 0.로그아웃===");
				System.out.println("====================================================");
				System.out.println("이동할 메뉴 번호를 입력하세요 ↓");
				menu = sc.nextLine();
				
				switch (menu) {
				case "1" :
					//개인정보 누를시, 현재 개인정보 상태출력 -> Service에서 제공
					mainMS.UserPrivacy();
					break;
				case "2" :
					//2.도서조회
					mainBP.UserPrivacy();
					break;
				case "3" : 
					//3.중고장터
					
					break;
				case "0" : 
					//4.로그아웃
					run = false;
					//로그아웃 전 객체에 등록된 고객데이터 삭제.
					UserService.userInfo = null;
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("유저의 객체값이 null 로 변경되었습니다 !!!!!!!!");
					System.out.println("다시 로그인 해주세요");
					break;
					
					//작동 제대로 안하는듯.. 나중에 다시 보장...
				default :
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("잘못된 입력값 입니다. 다시 입력하세요");
					System.out.println();
					break;
				}
			}
		}//메소드 끝
		
		
		
		
		
	}


