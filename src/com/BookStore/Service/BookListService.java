package com.BookStore.Service;

import java.util.List;
import java.util.Scanner;

import com.BookStore.DAO.BookDAO;
import com.ConsoleView.ConsoleView;

public class BookListService {
	BookDAO instance = new BookDAO();
	Scanner sc = new Scanner(System.in);
	ConsoleView cv = new ConsoleView();
	
	//전체 책 리스트 조회
	//책의 자세한 내용 조회
	//책 구매
	//오늘본 책 객체리스트에 데이터 삽입.
	
	
	//원하는 책 목록과, 리스트만 넣어주면 구매 할 수 있다!!
	public void bookBuy(int intMenu, List<Book> list) {
		
		//menu = sc.nextLine(); //보고싶은 책리스트의 번호를 입력하게됨.
		//int intMenu = Integer.parseInt(menu);

		if(list == null) {
			System.out.println("데이터가 존재하지 않습니다!");
		}
		if(intMenu <= list.size() && intMenu != 0) {
			boolean sw = true;
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			while(sw) {
				//bs -> 현재 클릭한 책의 객체
				Book bs = (list.get(intMenu-1));
				//user : 게속 질질끌고다닌 userInfo의 새로운 변수
				User user = UserService.userInfo;
				//조회한 책을 배열에 넣음 !!!!
				boolean sw2 = true;
				//조회한 책이 이미 조회한 적 있다면, [sw2]를 false로

				for (int i = 0; i < UserService.TodayBookList.size(); i++) {
					if(UserService.TodayBookList.get(i).getBookNumber() == bs.getBookNumber()) {
						sw2 = false;
					}
				}
				//조회한 적 있는 책이라면, 넘어가는 조건문
				if(sw2) {
					UserService.TodayBookList.add(bs);					
				}
				
				System.out.println("보유 캐쉬 : "+ user.getUserMoney()+"\n");
				System.out.println("================================");
				System.out.println(bs.toStringIntroduce());
				System.out.println();
				System.out.println("================================");
				System.out.println("======== 1.구매 | 0.뒤로가기========");
				System.out.println("================================");
				
				switch(sc.nextLine()) {
				
				case "1": 
					//보유머니가 책 가격과 동일하거나 클떄만 실행.
					if(user.getUserMoney() >= bs.getPrice()) {
						
						//재고수량이 0 이상일떄만 실행.
						if(bs.getBookStock() > 0) {
							//구매 DAO로 가즈아~
							//선택한 책 구매
							int result = instance.BookBuy(bs, user);
							
							//반환값이 0 이상이라면.. 구매완료!
							cv.BuyLoading();
							if(result > 0) {
								System.out.println("구매완료!"+result);
								UserService.userInfo.setUserMoney(user.getUserMoney()-bs.getPrice());
								sw = false;
							}else {
								//구매 실패 ! result 반환값이 0 이기에...
								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n구매실패!\n");
							}
							break;
						}else {
							System.out.println("재고가 없습니다!");
						}
						
					}else {
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n잔액이 부족합니다.\n");
					}
					break;
					
				case "0":
					sw = false;
					break;
				default :
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n잘못 입력하셨습니다..\n");
				}
			}
					
			
		}else {
			System.out.println("\n잘못 입력했습니다 !");
		}
//		else if(Integer.parseInt(menu) == 0) {
//			run = false;
//			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
//			break;
//		}else {
//			System.out.println("\n잘못 입력했습니다 !");
//		}
	}
	
	public void getBookList() {

		String menu = "";
		boolean run = true;
		
		
		
		while(run) {
			//전체 책을 불러왔음
			List<Book> list = instance.getBookList();
			
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\t🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖");
			System.out.println("\n\t\t📕📕📕전체 책 조회 서비스📕📕📕\n");
			System.out.println("\t🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖\n");
			System.out.println("  ↓ 숫자입력");
			for (int i = 0; i < list.size(); i++) {
				System.out.println("[ "+(i+1)+" ] "+list.get(i).toString());
			}
			System.out.println("\n보유 캐쉬 : "+ UserService.userInfo.getUserMoney()+"\n");
			System.out.println("============================");
			System.out.println("===[ 숫자 ] 자세히보기 | 0.뒤로가기===");
			System.out.println("============================");
			menu = sc.nextLine(); //보고싶은 책리스트의 번호를 입력하게됨.
			int intMenu = Integer.parseInt(menu);

			if(intMenu >= 1) {
				bookBuy(intMenu, list);
			}else if(intMenu ==0) {
				run = false;
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				break;
			}else {
				System.out.println("\n잘못 입력했습니다 !");
			}			
			
		}
	}

	//오늘본 책 목록
	public void TodayBookSee() {
		boolean run = true;
		String menu = "";
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		while(run) {
			List<Book> list = UserService.TodayBookList;

			System.out.println("\t🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖");
			System.out.println("\t🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖\n");
			System.out.println("  ↓ 숫자입력");
			for (int i = 0; i < list.size(); i++) {
				System.out.println("[ "+(i+1)+" ] "+list.get(i).toString());
			}
			System.out.println("\n보유 캐쉬 : "+ UserService.userInfo.getUserMoney()+"\n");
			System.out.println("============================");
			System.out.println("===[숫자]자세히보기 | 0.뒤로가기===");
			System.out.println("============================");
			menu = sc.nextLine(); //보고싶은 책리스트의 번호를 입력하게됨.
			int intMenu = Integer.parseInt(menu);

			//구매 할래????
			if(intMenu >= 1) {
				bookBuy(intMenu, list);
			}else if(intMenu ==0) {
				run = false;
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				break;
			}else {
				System.out.println("\n잘못 입력했습니다 !");
			}

		}

	}

	//나의 책 조회 구매하는것이 아님 ! 보기만 할것이다
	public void MyBook() {
		String menu = "";
		boolean run = true;
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		while(run) {

			List<Book> list = instance.MyBook();
				for (int i = 0; i < list.size(); i++) {
					System.out.println("[ "+(i+1)+" ] "+list.get(i).toString());
				}
			System.out.println("\n보유 캐쉬 : "+ UserService.userInfo.getUserMoney()+"\n");
			System.out.println("============================");
			System.out.println("===[숫자]자세히보기 | 0.뒤로가기===");
			System.out.println("============================");
			menu = sc.nextLine(); //보고싶은 책리스트의 번호를 입력하게됨.
			int intMenu = Integer.parseInt(menu);
			System.out.println("수정이 필요한 지역 입니다 ! 0을 눌러 돌아가십시오 ! !");

			if(intMenu >= 1) {
				//bookBuy(intMenu, list); 사는것이 아닌. 자세히 보기 필드를 넣으시오

				//bookBuy(intMenu, list);
			}else if(intMenu ==0) {
				run = false;
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				break;
			}else {
				System.out.println("\n잘못 입력했습니다 !");
			}	
		}
		
	}
}

