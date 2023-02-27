package com.BookStore.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.BookStore.DAO.UserDAO;
import com.BookStore.MainMenu.MainMenuPage;
import com.BookStore.MasterMenu.MasterMenuPage;
import com.ConsoleView.ConsoleView;

public class UserService{
	
	public static User userInfo = null;
	public static List<Book> TodayBookList = new ArrayList<>();
	//메인메뉴 페이지는 새로 작성합니다.
	
	Scanner sc = new Scanner(System.in);
	
	//유저 로그인
	public void login() {
		MainMenuPage mainM = new MainMenuPage();
		ConsoleView cv = new ConsoleView();


		User user = null;
		System.out.println("ID를 입력하세요 >");
		String userId = sc.nextLine();
		System.out.println("PW를 입력하세요 >");
		String userPw = sc.nextLine();
		System.out.print("로그인 중.");
		cv.LoginLoading();
		
		//UserDAO 로 만든 객체만 사용 가능하다!!!
		user = UserDAO.getInstance().login(userId);
		//로그인화면 돌아 갈 시, 유저의 객체가 지워지는지 확인할거임. 최종에 뺼겨.
		if(userInfo != null) {
			System.out.println("기존 로그인된 객체가 존재합니다.\n프로그램에 문제가 있으므로, 즉각 관리자에게 문의하십시오.");
		}
		if(user != null) {
			System.out.println("로그인 완료 !");
			//데이터를 불러,필드에 재정의된 비번과, 유저가 직접입력한 비번을 조회.
			if(user.getUserPw().equals(userPw)) {
				cv.JumpConsole();
				System.out.println("\t\t\t로그인에 성공하였습니다 !");
				System.out.println("\t\t\t\""+user.getUserName() + "\" 님 환영합니다.🎉🎉");
				System.out.println("\n\n\n");
				//여기서 user의 정보를 유지할 수 있을듯!
				userInfo = user;
				mainM.MainMenu();
			}else {
				cv.JumpConsole();
				System.out.println("비밀번호가 틀립니다 !!");
			}
		}else {
			cv.JumpConsole();
			System.out.println("없는 계정입니다 ! ");
		}
	}
	
	
	
	//회원가입
	//회원가입
	//회원가입에서는 userDao클래스의 SignUp/SignUpCompare 메소드를 사용한다.
	public void SignUp() {
		ConsoleView cv = new ConsoleView();
		userInfo = null;
		User user = new User();
		boolean sw = false;
		
		System.out.println("이름 | ID | PW | 생일 | 전화번호 | 나이 | 이메일");
		System.out.println("위 정보가 필요합니다 !");
		System.out.println("\n이름을 입력하세용 ↓");
		user.setUserName(sc.nextLine()); 
//==============================================================			
		System.out.println("\n사용할 ID를 입력하쇼 ↓"); //유니크
		String userId = "";
		
		do{
			
			List<User> list = UserDAO.getInstance().SignUpCompare();
			boolean[] swarr = new boolean[list.size()];
			String value = sc.nextLine();
			//동일한 데이터가 존재 할 시, 배열에 true가 들어가게 됨.
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).getUserId().equals(value)) {
					System.out.println("\n이미 존재하는 ID입니다. 다시 입력하세요");
					swarr[i] = true;
				}else {
					swarr[i] = false;
					userId=value;
				}
			}
			sw = false;
			//배열에 true가 없을경우 반복문을 빠져나옴
			for(int i=0; i<swarr.length;i++) {
				if(swarr[i]==true) {
					sw = true;
				}
			}
		}while(sw);
		user.setUserId(userId);
//==============================================================		
		boolean pwsw = true;
		while(pwsw) {
			System.out.println("\n사용할 PW를 입력하세요 ↓");
			String pw1 = sc.nextLine();
			System.out.println("\n비밀번호를 한번 더 입력하세요 ↓");
			String pw2 = sc.nextLine();
			System.out.println(pw1 + pw2);
			if(pw1.equals(pw2)) {
				user.setUserPw(pw1);
				System.out.println("\n비밀번호가 일치합니다 !");
				pwsw = false;
			}else {
				System.out.println("\n비밀번호가 서로 다릅니다 !");
			}
			
		}
//==============================================================
		System.out.println("\n생일을 입력하세요 \n 예시). 19980305 ↓");

		user.setUserBirth(sc.nextLine());
//==============================================================			
		System.out.println("\n전화번호를 입력하세요 \n 기호를 제외한 숫자만 입력하세요 ↓"); //유니크
		String userTel = "";
		
		do{
			
			List<User> list = UserDAO.getInstance().SignUpCompare();
			boolean[] swarr = new boolean[list.size()];
			String value = sc.nextLine();
			//동일한 데이터가 존재 할 시, 배열에 true가 들어가게 됨.
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).getUserTel().equals(value)) {
					System.out.println("\n이미 존재하는 전화번호 입니다. 다시 입력하세요 ↓");
					swarr[i] = true;
				}else {
					swarr[i] = false;
					userTel=value;
				}
			}
			sw = false;
			//배열에 true가 없을경우 반복문을 빠져나옴
			for(int i=0; i<swarr.length;i++) {
				if(swarr[i]==true) {
					sw = true;
				}
			}
		}while(sw);
		user.setUserTel(userTel);
		
//==============================================================			
		System.out.println("\n나이를 입력하세요 ↓");
		user.setUserAge(Integer.parseInt(sc.nextLine()));
//==============================================================	
		System.out.println("\n이메일을 입력하세요 ↓"); //유니크
		String userMail = "";
			
		do{
			
			List<User> list = UserDAO.getInstance().SignUpCompare();
			boolean[] swarr = new boolean[list.size()];
			String value = sc.nextLine();
			//동일한 데이터가 존재 할 시, 배열에 true가 들어가게 됨.
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).getUserMail().equals(value)) {
					System.out.println("\n이미 존재하는 EMAIL 입니다. 다시 입력하세요 ↓");
					swarr[i] = true;
				}else {
					swarr[i] = false;
					userMail=value;
				}
			}
			sw = false;
			//배열에 true가 없을경우 반복문을 빠져나옴
			for(int i=0; i<swarr.length;i++) {
				if(swarr[i]==true) {
					sw = true;
				}
			}
		}while(sw);
		user.setUserMail(userMail);
		
		
		int result = UserDAO.getInstance().SignUp(user);
		
		if(result > 0 ) {
			cv.RegistrationSuccess();
			cv.JumpConsole();
			System.out.println("회원가입 완료 !\n\n");
		}else {
			System.out.println("회원가입 실패");
		}
	} //메소드 끝
		

	//관리자 로그인
	public void MasterLogin() {
		MasterMenuPage masterM = new MasterMenuPage();
		ConsoleView cv = new ConsoleView();


		User user = null;
		System.out.println("ID를 입력하세요 ↓");
		String userId = sc.nextLine();
		System.out.println("PW를 입력하세요 ↓");
		String userPw = sc.nextLine();
		System.out.print("로그인 중.");
		//UserDAO 로 만든 객체만 사용 가능하다!!!
		user = UserDAO.getInstance().MasterLogin();
		cv.LoginLoading();
		if(user.getUserId().equals(userId)) {
			//데이터를 불러,필드에 재정의된 비번과, 유저가 직접입력한 비번을 조회.
			if(user.getUserPw().equals(userPw)) {
				cv.JumpConsole();
				System.out.println("\t\t\t로그인에 성공하였습니다 !");
				System.out.println("\t\t\t\""+user.getUserName() + "\" 님 환영합니다.🎉🎉");
				System.out.println("\n\n\n");
				//여기서 user의 정보를 유지할 수 있을듯!
				userInfo = user;
				
				masterM.MasterMenu();
			}else {
				cv.JumpConsole();
				System.out.println("비밀번호가 틀립니다 !!");
			}
		}else {
			System.out.println("없는 계정입니다 ! ");
		}
	}
	
	//회원탈퇴
	
	
}








































































