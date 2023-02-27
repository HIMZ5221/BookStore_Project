package com.BookStore.MasterMenu;

import java.util.List;
import java.util.Scanner;

import com.BookStore.DAO.BookDAO;
import com.BookStore.DAO.UserDAO;
import com.BookStore.Service.Book;
import com.BookStore.Service.BookListService;
import com.BookStore.Service.User;
import com.BookStore.Service.UserService;

public class MasterMenuPage {
	
	Scanner sc = new Scanner(System.in);
	String menu = "";

	
	
	public void MasterMenu() {
		MasterMenuPage_Service_001 mms = new MasterMenuPage_Service_001();


		boolean run = true;
		System.out.println("\t\t🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞");
		System.out.println("\t\t\t===[ 관리자 ] 전용 페이지===");
		System.out.println("\t\t🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞\n");
		System.out.println(UserService.userInfo.toString());
		System.out.println();
		while (run) {
			//첫 콘솔 출력 창이다.. 이 while문에서 모든게 반복되어야만 하며, 최후방 콘솔지역임.
			//프로그램 종료는 나중에 생각한다.
			System.out.println("\t  ===================================================");
			System.out.println("\t  ===1.유저관리 & 조회 | 2.도서관리 | 3.판매기록 | 0.로그아웃====");
			System.out.println("\t  ===================================================");
			System.out.println("\n이동할 메뉴 번호를 입력하세요 ↓\n\n");
			menu = sc.nextLine();
			
			switch (menu) {
			case "1" :
				UserManagement();
				break;
			case "2" :
				BookManagement();		
				break;
			case "3" : 
				mms.SalesList();
				break;
			case "0" : 
				run = false;
				//로그아웃 전 객체에 등록된 고객데이터 삭제.
				UserService.userInfo = null;
				System.out.println("유저의 객체값은 null 입니다.");
				break;
			}
			
			
		}
	}
	//유저 관리
	public void UserManagement() {
		UserService us = new UserService();
		MasterMenuPage_Service_001 mms = new MasterMenuPage_Service_001();


		boolean run = true;
		
		while (run) {
			//유저조회에 들어올 시, 전체 유저를 한번 보여줌.
			mms.ViewAllUser();
			System.out.println("\t▶※상단 정보는 프로그램에 등록된 전체 유저를 출력합니다.");
			System.out.println("\t   등록 및 수정을 원하면 하단을 참조하세요.\n");
			System.out.println("===================================================");
			System.out.println("===1.유저등록 | 2.유저삭제 | 3.유저검색 & 수정 | 0.뒤로가기====");
			System.out.println("===================================================");
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
				//유저 검색 & 수정
				mms.UserSearch();
				break;
			case "0" : 
				run = false;
				break;
			}
			
			
		}
	}
	
	//검색한 유저의 정보 수정
	public void UserSearchAndEdit(List<User> list) {
		MasterMenuPage_Service_001 mms = new MasterMenuPage_Service_001();

		
		boolean run = true;
		
		System.out.println("수정을 원하는 유저의 번호를 입력하십시오.");
		int select = Integer.parseInt(sc.nextLine());
		//선택된 유저의 고유넘버
		int UNumber = list.get(select-1).getUserNumber();
		//선택된 유저의 이름
		while (run) {
			String UName = list.get(select-1).getUserName();
			System.out.println("\""+UName +"\" 유저의 변경할 항목을 고르세요.");
			System.out.println("=================================================");
			System.out.println("===1.이름 | 2.전화번호 | 3.Email | 4.캐쉬수정 | =======");
			System.out.println("=================================================");
			System.out.println("=================================================");
			System.out.println("===5.나이 | 6.생일(미구현)| 7.가입일(미구현)| 0.뒤로가기====");
			System.out.println("=================================================");
			
			//선택번호 데이터 수집
			menu = sc.nextLine();
			
			switch (menu) {
			case "1" :
				//이름
				System.out.println("변경할 이름을 입력하세요");
				String newName = sc.nextLine();
				boolean change = mms.ChangeDateString("user_name", UNumber, newName);
				//정상적인 이름변경시, 현제 메소드의 임시 객체도 변경.
				//복잡하다 ㅠㅠ
				if (change == true) {
					list.get(select-1).setUserName(newName);
					System.out.println("객체이름까지 변경완료");
				}
				break;
			case "2" :
				//전화번호 비교해야함
				mms.DataTelCompare("USER_TEL", UNumber);
				break;
			case "3" :
				//Email 비교해야함
				mms.DataMailCompare("USER_MAIL", UNumber);
				break;
			case "4" :
				//캐쉬충전
				System.out.println("변경할 캐쉬 데이터를 입력하세요");
				//메소드에 값전달하는곳에서 데이터를 입력하게한다.
				mms.ChangeDataInt("USER_MONEY", Integer.parseInt(sc.nextLine()), UNumber);
				break;
			case "5" :
				//나이
				System.out.println("변경할 나이 데이터를 입력하세요");
				mms.ChangeDataInt("USER_AGE", Integer.parseInt(sc.nextLine()), UNumber);
				break;
			case "6" :
				//생일
				break;
			case "7" :
				//가입일
				break;
			case "0" : 
				run = false;
				break;
			}
			
			
		}
	}
	
	//도서 관리
	public void BookManagement() {
		MasterMenuPage_Service_001 mms = new MasterMenuPage_Service_001();
		
		boolean run = true;
		
		while (run) {
			//유저조회에 들어올 시, 전체 유저를 한번 보여줌.
			mms.getBookList();
			System.out.println("\t▶※상단 정보는 프로그램에 등록된 전체 도서를 출력합니다.");
			System.out.println("\t   등록 및 수정을 원하면 하단을 참조하세요.\n");
			System.out.println("===================================================");
			System.out.println("===1.도서등록 | 2.도서삭제 | 3.도서검색 & 수정 | 0.뒤로가기====");
			System.out.println("===================================================");
			menu = sc.nextLine();
			
			switch (menu) {
			case "1" :
				mms.bookRegistration();
				break;
			case "2" :
				mms.DeleteBook();
				//도서삭제
				break;
			case "3" :
				//도서 검색 & 수정
				mms.BookSearch();
				break;
			case "0" : 
				run = false;
				break;
			}
			
			
		}
	}
	
	//검색한 유저의 정보 수정
	public void BookSearchAndEdit(List<Book> list) {
		MasterMenuPage_Service_001 mms = new MasterMenuPage_Service_001();

		
		boolean run = true;
		
		System.out.println("수정을 원하는 도서의 번호를 입력하십시오.");
		int select = Integer.parseInt(sc.nextLine());
		//선택된 유저의 고유넘버
		int BNumber = list.get(select-1).getBookNumber();
		//선택된 유저의 이름
		while (run) {
			String BName = list.get(select-1).getBookName();
			System.out.println("\""+BName +"\" 의 변경할 항목을 고르세요.");
			System.out.println("========================================");
			System.out.println("=== 1.제목 | 2.수량 | 3.가격 | 4.카테고리 ====");
			System.out.println("========================================");
			System.out.println("=== 5.저자 | 0.뒤로가기 ====================");
			System.out.println("========================================");
			
			//선택번호 데이터 수집
			menu = sc.nextLine();
			
			switch (menu) {
			case "1" :
				//제목
				System.out.println("변경할 [제목]을 입력하세요");
				String newName = sc.nextLine();
				int result = mms.ChangeDataStringToBook("BOOK_NAME", BNumber, newName);
				if(result > 0) {
					list.get(select-1).setBookName(newName);
				}
				
				break;
			case "2" :
				//수량
				System.out.println("변경할 [수량]을 입력하세요");
				System.out.println("현재 수량 : "+list.get(select-1).getBookStock());
				int newStock = Integer.parseInt(sc.nextLine());
				mms.ChangeDataIntToBook("BOOK_STOCK", BNumber ,newStock);
				break;
			case "3" :
				//가격
				System.out.println("변경할 새로운 [금액] 을 입력하세요");
				System.out.println("현재 금액 : "+list.get(select-1).getPrice());
				int newPrice = Integer.parseInt(sc.nextLine());
				mms.ChangeDataIntToBook("BOOK_PRICE", BNumber ,newPrice);
				break;
			case "4" :
				//캐쉬충전
				System.out.println("변경할 새로운 [카테고리] 를 입력하세요");
				System.out.println("현재 카테고리 : "+list.get(select-1).getType());
				String newType = sc.nextLine();
				mms.ChangeDataStringToBook("BOOK_TYPE", BNumber ,newType);
				break;
			case "5" :
				//나이
				System.out.println("변경할 새로운 [저자] 를 입력하세요");
				System.out.println("현재 저자 : "+list.get(select-1).getAuthor());
				String bookAuthor = sc.nextLine();
				mms.ChangeDataStringToBook("BOOK_AUTHOR", BNumber ,bookAuthor);
				break;
			case "0" : 
				run = false;
				break;
			}
			
			
		}
	}
	

	
}
