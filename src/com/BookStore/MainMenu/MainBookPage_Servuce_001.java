package com.BookStore.MainMenu;

import java.util.Scanner;

import com.BookStore.Service.BookListService;
import com.BookStore.Service.UserService;

public class MainBookPage_Servuce_001 {
	
	Scanner sc = new Scanner(System.in);
	BookListService bs = new BookListService();
	
	//본격적으로 책을 조회하기위한 클래스를 작성한다...
	public void UserPrivacy() {
		boolean run = true;
		String menu = "";
		
		
		
		while (run) {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\t🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞");
			System.out.println("\n\t\t===교보문고 Ebook===\n");
			System.out.println("\t🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞\n");
			System.out.println();
			System.out.print("Login : "+UserService.userInfo.getUserName());
			System.out.println("\tID : "+UserService.userInfo.getUserId());
			System.out.println();
			System.out.println("====================================================================");
			System.out.println("===1.도서 전체조회 | 2.카테고리 분류 | 3.오늘본 목록 | 4.나의 책 보기 | 5.뒤로가기===");
			System.out.println("====================================================================");
			System.out.println("이동할 메뉴 번호를 입력하세요 ↓");
									//오늘본 목록 -> 리스트 객체를 들고다니자
			menu = sc.nextLine();
			switch (menu) {
			case "1" :
				bs.getBookList();
				break;
			case "2" :
				//카테고리 분류
				break;
			case "3" : 
				//오늘본 목록
				bs.TodayBookSee();
				System.out.println("3번 입력됨.");
				break;
			case "4" : 
				//나의 책 보기
				bs.MyBook();
				break;
				
			case "5" : 
				run = false;
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				break;
			default :
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println("잘못된 입력값 입니다. 다시 입력하세요");
				System.out.println();
				break;
			}
		}
		
	}
	
}
