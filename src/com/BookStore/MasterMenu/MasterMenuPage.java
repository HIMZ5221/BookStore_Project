package com.BookStore.MasterMenu;

import java.util.List;
import java.util.Scanner;

import com.BookStore.DAO.UserDAO;
import com.BookStore.Service.User;
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
			System.out.println("===1.유저관리 | 2.도서관리 | 3.판매기록 | 0.로그아웃====");
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
		
		boolean run = true;
		
		while (run) {
			//유저조회에 들어올 시, 전체 유저를 한번 보여줌.
			mms.ViewAllUser();
			
			System.out.println("==========================================================");
			System.out.println("===1.유저등록 | 2.유저삭제 | 3.유저검색 & 수정 | 0.뒤로가기====");
			System.out.println("==========================================================");
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
		UserService us = new UserService();
		
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
	

	
}
