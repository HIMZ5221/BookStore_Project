package com.BookStore.Service;

import java.util.Scanner;

import com.BookStore.DAO.MainMenuPage_DAO_001;

public class MainMenuPage_Service_001 {
	
	Scanner sc = new Scanner(System.in);
	
	//개인정보 조회 페이지... 로그인중인 userInfo의 필드정보를 출력합시다 실시
	//클래스 만들기가 복잡할듯하여, 비밀번호,tel,mail 변경 기능, 캐쉬충전 기능도 추가합니다.
	public void UserPrivacy() {
		boolean run = true;
		String menu = "";
		
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("           🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞");
		System.out.println("             ===개인정보 페이지===");
		System.out.println("           🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞\n");
		System.out.println(UserService.userInfo.toString());
		System.out.println();
		while (run) {
			System.out.println("=============================================================");
			System.out.println("===1.비밀번호 변경 | 2.tel변경 | 3.Email변경 | 4.캐쉬충전 | 5.뒤로가기===");
			System.out.println("=============================================================");
			System.out.println("이동할 메뉴 번호를 입력하세요 ↓");
			menu = sc.nextLine();
			switch (menu) {
			case "1" :
				//1.비밀번호 변경 2.tel변경 3.mail변경 4.캐시충전 -> Service와 DAO에서 제공
				ChangePw();
				break;
			case "2" :
				//tel변경
				ChangeTel();
				break;
			case "3" : 
				//mail변경
				ChangeEmail();
				break;
			case "4" : 
				//캐시충전
				CashCharging();
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
	
	//비밀번호 변경..
	public void ChangePw() {
		int number = UserService.userInfo.getUserNumber();
		System.out.println("새로운 비밀번호를 입력하세요 !");
		String newPw = sc.nextLine();
		System.out.println("비밀번호를 한번더 입력하세요 !");
		String newPwCheck = sc.nextLine();
		if(newPw.equals(newPwCheck)) {
			int result = MainMenuPage_DAO_001.getInstance().ChangeEmail("user_pw", newPw, number);
			if(result > 0 ) {
				System.out.println("변경완료 !");
				UserService.userInfo.setUserPw(newPw);
			}else {
				System.out.println("변경실패 !");
			}
		}else {
			System.out.println(newPw);
			System.out.println(newPwCheck);
			System.out.println("새로운 비밀번호가 틀렸습니다 !");
		}
	}
	
	//tel 변경...
	public void ChangeTel() {
		int number = UserService.userInfo.getUserNumber();
		System.out.println("현재 전화번호 : \t" + UserService.userInfo.getUserTel());
		System.out.println("변경할 전화번호를 입력하세요 !");
		String newTel = sc.nextLine();
		int result = MainMenuPage_DAO_001.getInstance().ChangeEmail("user_Tel", newTel, number);
		if(result > 0 ) {
			System.out.println("변경완료 !");
			UserService.userInfo.setUserMail(newTel);
		}else {
			System.out.println("변경실패 !");
		}
	}
	
	//mail 변경...
	public void ChangeEmail() {
		int number = UserService.userInfo.getUserNumber();
		System.out.println("현재 EMAIl : \t" + UserService.userInfo.getUserMail());
		System.out.println("변경할 EMAIL을 입력하세요 !");
		String newMail = sc.nextLine();
		int result = MainMenuPage_DAO_001.getInstance().ChangeEmail("user_mail", newMail, number);
		if(result > 0 ) {
			System.out.println("변경완료 !");
			UserService.userInfo.setUserMail(newMail);
		}else {
			System.out.println("변경실패 !");
		}
	}//메소드 끝
	
	//캐시충전..
	public void CashCharging() {
		int number = UserService.userInfo.getUserNumber();
		//현재 보유 캐쉬
		int nowCash = UserService.userInfo.getUserMoney();
		System.out.println("현재 보유캐쉬 : \t" + nowCash+"캐쉬");
		System.out.println("충전할 캐쉬값을 입력하세요 !");
		int plusCash = 0 ;
		boolean sw = true;
		while(sw) {
			int value = Integer.parseInt(sc.nextLine());
			if(value < 10000000) {
				plusCash = value;
				sw = false;
			}else {
				System.out.println("너무많은 값은 입력할 수 없습니다 !");
			}
		}
		
		int result = MainMenuPage_DAO_001.getInstance().CashCharging(plusCash, number);
		
		if(result > 0 ) {
			System.out.println("충전완료 !");
			UserService.userInfo.setUserMoney(nowCash + plusCash);
		}else {
			System.out.println("충전실패 !");
		}
	}//메소드 끝
}
