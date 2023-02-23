package com.BookStore.MainMenu;

import java.util.Scanner;

import com.BookStore.Service.BookService;
import com.BookStore.Service.UserService;

public class MainBookPage_Servuce_001 {
	
	Scanner sc = new Scanner(System.in);
	BookService bs = new BookService();
	
	//본격적으로 책을 조회하기위한 클래스를 작성한다...
	public void UserPrivacy() {
		boolean run = true;
		int menu = 0;
		
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("      🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞");
		System.out.println("        ===교보문고 Ebook===");
		System.out.println("      🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞\n");
		System.out.println();
		while (run) {
			System.out.print("Login : "+UserService.userInfo.getUserName());
			System.out.println("\tID : "+UserService.userInfo.getUserId());
			System.out.println();
			System.out.println("=============================================================");
			System.out.println("===1.도서 전체조회 | 2.카테고리 분류 | 3.오늘본 목록 | 4. | 5.뒤로가기===");
			System.out.println("=============================================================");
			System.out.println("이동할 메뉴 번호를 입력하세요 ↓");
									//오늘본 목록 -> 리스트 객체를 들고다니자
			menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1 :
				bs.getBookList();
				System.out.println("주문을 위한 페이지.. 1. 구매 2. 뒤로가기");
				break;
			case 2 :
				//tel변경
				break;
			case 3 : 
				//mail변경
				break;
			case 4 : 
				//캐시충전
				break;
				
			case 5 : 
				run = false;
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

				break;
			}
		}
		
	}
	
}
