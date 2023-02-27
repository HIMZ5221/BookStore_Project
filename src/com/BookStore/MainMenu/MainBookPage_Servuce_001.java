package com.BookStore.MainMenu;

import java.util.List;
import java.util.Scanner;

import com.BookStore.DAO.BookDAO;
import com.BookStore.Service.Book;
import com.BookStore.Service.BookListService;
import com.BookStore.Service.UserService;
import com.ConsoleView.ConsoleView;

public class MainBookPage_Servuce_001 {
	
	Scanner sc = new Scanner(System.in);
	BookListService bs = new BookListService();
	
	//본격적으로 책을 조회하기위한 클래스를 작성한다...
	public void UserPrivacy() {
		ConsoleView cv = new ConsoleView();
		boolean run = true;
		String menu = "";
		
		
		
		while (run) {
			cv.JumpConsole();
			System.out.println("\t\t🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞");
			System.out.println("\n\t\t\t===교보문고 Ebook===\n");
			System.out.println("\t\t🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞\n");
			System.out.println();
			System.out.print("\t\tLogin : "+UserService.userInfo.getUserName());
			System.out.print("\tID : "+UserService.userInfo.getUserId());
			System.out.println("\tMONEY : "+UserService.userInfo.getUserMoney()+"캐쉬");
			System.out.println();
			System.out.println("\t====================================================================");
			System.out.println("\t===1.도서 전체조회 | 2.카테고리 분류 | 3.오늘본 목록 | 4.나의 책 보기 | 0.뒤로가기===");
			System.out.println("\t====================================================================");
			System.out.println("\n이동할 메뉴 번호를 입력하세요 ↓\n\n");
									//오늘본 목록 -> 리스트 객체를 들고다니자
			menu = sc.nextLine();
			switch (menu) {
			case "1" :
				bs.getBookList();
				break;
			case "2" :
				//카테고리 분류
				Category();
				break;
			case "3" : 
				//오늘본 목록
				bs.TodayBookSee();
				break;
			case "4" : 
				//나의 책 보기
				bs.MyBook();
				break;
				
			case "0" : 
				run = false;
				cv.JumpConsole();
				break;
			default :
				cv.JumpConsole();
				System.out.println("잘못된 입력값 입니다. 다시 입력하세요");
				System.out.println();
				break;
			}
		}

	}
	//카테고리별 분류
	public void Category() {
		ConsoleView cv = new ConsoleView();
		BookDAO instance = new BookDAO();
		
		boolean run = true;
		
		cv.JumpConsole();
		while(run) {
			List<Book> list = instance.GroupBookList();

//			System.out.println("\t🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖");
//			System.out.println("\t\t최근 조회한 책 LIST ");
//			System.out.println("\t🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖\n");
//			System.out.println("  ↓ 숫자입력");
			System.out.println("\n\t\t보유 캐쉬 : "+ UserService.userInfo.getUserMoney()+"\n");
			System.out.print("\t\t=======");
			for (int i = 0; i < list.size(); i++) {
				System.out.print("=========");
			}
			System.out.print("\n\t\t===");
			for (int i = 0; i < list.size(); i++) {
				System.out.print("[ "+(i+1)+" ]"+list.get(i).getType()+", ");
			}
			System.out.print("===\n\t\t=======");
			for (int i = 0; i < list.size(); i++) {
				System.out.print("=========");
			}
			System.out.println("\n\n원하는 책 [번호] 및 뒤로가기 입력 ↓");

			int select = Integer.parseInt(sc.nextLine());
			
			//선택한 종류의 타입이름을 가져옴
			String type = list.get(select-1).getType();
			//type= Ex)과학
			list = instance.SelectBookList(type);
			//list = 타입이 과학인 모든 책
			
			cv.JumpConsole();
							
			for (int i = 0; i < list.size(); i++) {
				System.out.println("[ "+(i+1)+" ] "+list.get(i).toString());
			}
			System.out.println("\t\t=========================");
			System.out.println("\t\t===[ 번호 ] 구매 | 0. 취소===");
			System.out.println("\t\t=========================");
			//구매할 책 번호 입력 하 라 !!
			int selectBuy = Integer.parseInt(sc.nextLine());
			int result = 0;
			//구매 할래????
			if(selectBuy >= 1 && selectBuy <= list.size()) {
				result = instance.TypeBookBuy(list.get(selectBuy-1), UserService.userInfo);
			}else if(selectBuy ==0) {
				run = false;
				cv.JumpConsole();
				break;
			}else {
				System.out.println("\n잘못 입력했습니다 !");
			}
			if(result > 0) {
				cv.BuyLoading();//구매완료
				run = false;
			}else {
				System.out.println("구매에 실패했습니다 ! 잔액을 확인하세요 ");
			}

		}

	}
	
}
