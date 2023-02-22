package com.BookStore.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.BookStore.DAO.UserDAO;

public class UserService {
	
	public static User userInfo = null;
	
	Scanner sc = new Scanner(System.in);
	
	public void login() {
		User user = null;
		System.out.println("ID를 입력하세요 >");
		String userId = sc.nextLine();
		System.out.println("PW를 입력하세요 >");
		String userPw = sc.nextLine();
		
		//UserDAO 로 만든 객체만 사용 가능하다!!!
		user = UserDAO.getInstance().login(userId);

		if(user != null) {
			//데이터를 불러,필드에 재정의된 비번과, 유저가 직접입력한 비번을 조회.
			if(user.getUserPw().equals(userPw)) {
				System.out.println("\n\n\n\n\n\n\n\n");
				System.out.println("로그인에 성공하였습니다 !");
				System.out.println(user.getUserName() + "님 환영합니다.🎉🎉");
				System.out.println("\n\n\n");
				//여기서 user의 정보를 유지할 수 있을듯!
				userInfo = user;
				
			}else {
				System.out.println("비밀번호가 틀립니다 !!");
			}
		}else {
			System.out.println("없는 계정입니다 ! ");
		}
	}
	
	
	
	//회원가입
	//회원가입 생일데이터 넣는거 실패. 시간나면 할것.
	//회원가입에서는 userDao클래스의 SignUp/SignUpCompare 메소드를 사용한다.
	public void SignUp() {
		userInfo = null;
		User user = new User();
		boolean sw = false;
		System.out.println("이름 | ID | PW | 생일 | 전화번호 | 나이 | 이메일");
		System.out.println("위 정보가 필요합니다 !");
		System.out.println("이름을 입력하세용 >");
		user.setUserName(sc.nextLine()); 
//==============================================================			
		System.out.println("사용할 ID를 입력하쇼 >"); //유니크
		String userId = "";
		
		do{
			
			List<User> list = UserDAO.getInstance().SignUpCompare();
			boolean[] swarr = new boolean[list.size()];
			String value = sc.nextLine();
			//동일한 데이터가 존재 할 시, 배열에 true가 들어가게 됨.
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).getUserId().equals(value)) {
					System.out.println("이미 존재하는 ID입니다. 다시 입력하세요");
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
		System.out.println("사용할 PW를 입력하쇼>");
		user.setUserPw(sc.nextLine());
//==============================================================
		System.out.println("생일을 입력하세요 \n 예시). 19980305 >");

		user.setUserBirth(sc.nextLine());
//==============================================================			
		System.out.println("전화번호를 입력하세요 \n 기호를 제외한 숫자만 입력하세요 >"); //유니크
		String userTel = "";
		
		do{
			
			List<User> list = UserDAO.getInstance().SignUpCompare();
			boolean[] swarr = new boolean[list.size()];
			String value = sc.nextLine();
			//동일한 데이터가 존재 할 시, 배열에 true가 들어가게 됨.
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).getUserTel().equals(value)) {
					System.out.println("이미 존재하는 전화번호 입니다. 다시 입력하세요");
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
		System.out.println("나이를 입력하세요 >");
		user.setUserAge(Integer.parseInt(sc.nextLine()));
//==============================================================	
		System.out.println("이메일을 입력하세요 >"); //유니크
		String userMail = "";
			
		do{
			
			List<User> list = UserDAO.getInstance().SignUpCompare();
			boolean[] swarr = new boolean[list.size()];
			String value = sc.nextLine();
			//동일한 데이터가 존재 할 시, 배열에 true가 들어가게 됨.
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).getUserMail().equals(value)) {
					System.out.println("이미 존재하는 EMAIL 입니다. 다시 입력하세요");
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
			System.out.println("사원 입력 완료");
		}else {
			System.out.println("사원 입력 실패");
		}
	} //메소드 끝
		

	//관리자 로그인
	public void MasterLogin() {
		User user = null;
		System.out.println("ID를 입력하세요 >");
		String userId = sc.nextLine();
		System.out.println("PW를 입력하세요 >");
		String userPw = sc.nextLine();
		
		//UserDAO 로 만든 객체만 사용 가능하다!!!
		user = UserDAO.getInstance().MasterLogin();

		if(user != null) {
			//데이터를 불러,필드에 재정의된 비번과, 유저가 직접입력한 비번을 조회.
			if(user.getUserPw().equals(userPw)) {
				System.out.println("\n\n\n\n\n\n\n\n");
				System.out.println("로그인에 성공하였습니다 !");
				System.out.println(user.getUserName() + "님 환영합니다.🎉🎉");
				System.out.println("\n\n\n");
				//여기서 user의 정보를 유지할 수 있을듯!
				userInfo = user;
				
			}else {
				System.out.println("비밀번호가 틀립니다 !!");
			}
		}else {
			System.out.println("없는 계정입니다 ! ");
		}
	}
	
	//회원탈퇴
	
	
}








































































