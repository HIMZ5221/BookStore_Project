package com.BookStore.exe;

import java.util.Scanner;

import com.BookStore.Service.UserService;

public class ExeApp {
	
	UserService us = new UserService();
	Scanner sc = new Scanner(System.in);
	
	String menu = "";
	boolean run = true;
	
	public ExeApp() {
		run();
	}
	
	private void run() {
		System.out.println("\n\n\n\n\n\n\n\n\n");
		while (run) {
			//첫 콘솔 출력 창이다.. 이 while문에서 모든게 반복되어야만 하며, 최후방 콘솔지역임.
			//프로그램 종료는 나중에 생각한다.
			System.out.println("================================================");
			System.out.println("===1.로그인 | 2.회원가입 | 3.관리자로그인 | 4.프로그램종료===");
			System.out.println("================================================");
			menu = sc.nextLine();
			
			switch (menu) {
			case "1" :
				//로그인
				us.login();
				break;
			case "2" :
				//회원가입
				us.SignUp();
				break;
			case "3" : 
				//관리자 로깅!
				us.MasterLogin();
				break;
			case "4" :
				run = false;
				System.out.println("死 프로그램 사망 死");
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
