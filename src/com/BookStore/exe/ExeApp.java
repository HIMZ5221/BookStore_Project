package com.BookStore.exe;

import java.util.Scanner;

import com.BookStore.Service.UserService;

public class ExeApp {
	
	UserService us = new UserService();
	Scanner sc = new Scanner(System.in);
	
	int menu = 0;
	boolean run = true;
	
	public ExeApp() {
		run();
	}
	
	private void run() {
		while (run) {
			//첫 콘솔 출력 창이다.. 이 while문에서 모든게 반복되어야만 하며, 최후방 콘솔지역임.
			//프로그램 종료는 나중에 생각한다.
			System.out.println("===================================");
			System.out.println("===1.로그인 | 2.회원가입 | 3.관리자로그인===");
			System.out.println("===================================");
			menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1 :
				//로그인
				us.login();
				break;
			case 2 :
				//회원가입
				us.SignUp();
				break;
			case 3 : 
				//관리자 로깅!
				us.MasterLogin();
				break;
			}
			
			
		}
	}
	
	
}
