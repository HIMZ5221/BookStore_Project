package com.BookStore.Service;

import java.util.List;
import java.util.Scanner;

import com.BookStore.DAO.BookDAO;

public class BookListService {
	BookDAO instance = new BookDAO();
	Scanner sc = new Scanner(System.in);
	
	
	//전체 책 리스트를 조회할수있고, 구매하는DAO 까지 연결.
	//데이터를 더 넣어 자세히볼수있는 기능을 넣을것.
	//선택한 책 구매
		//여기서부터 시작//선택한 책 구매
	//여기서부터 시작//선택한 책 구매
	//여기서부터 시작//선택한 책 구매
	//여기서부터 시작//선택한 책 구매
	//여기서부터 시작//선택한 책 구매
	//여기서부터 시작//선택한 책 구매
	//여기서부터 시작//선택한 책 구매
	//여기서부터 시작//선택한 책 구매
	//여기서부터 시작
	public void getBookList() {
		boolean run = true;
		String menu = "";
		
		while(run) {
			List<Book> list = instance.getBookList();
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\t🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖");
			System.out.println("\n\t\t📕📕📕전체 책 조회 서비스📕📕📕\n");
			System.out.println("\t🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖🔖\n");
			System.out.println("  ↓ 숫자입력");
			for (int i = 0; i < list.size(); i++) {
				System.out.println("[ "+(i+1)+" ] "+list.get(i).toString());
			}
			System.out.println();
			System.out.println("============================");
			System.out.println("===[숫자]자세히보기 | 0.뒤로가기===");
			System.out.println("============================");
			menu = sc.nextLine();
			int intMenu = Integer.parseInt(menu);

			
			if(intMenu <= list.size() && intMenu != 0) {
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println("================================");
				Book bs = (list.get(Integer.parseInt(menu)-1));
				System.out.println(bs.toStringIntroduce());
				System.out.println();
				System.out.println("================================");
				System.out.println("======== 1.구매 | 0.뒤로가기========");
				System.out.println("================================");
				
				boolean sw = true;
				
				while(sw) {
					switch(sc.nextLine()) {
					case "1": 
						//재고확인
						if(bs.getBookStock() > 0) {
							//구매 DAO로 가즈아~
							//선택한 책 구매
							//여기서부터 시작
							User user = UserService.userInfo;
							int result = instance.BookBuy(bs, user);
							if(result > 0) {
								System.out.println("구매완료!");
								sw = false;
							}else {
								System.out.println("구매실패!");
							}
							break;
						}else {
							System.out.println("재고가 없습니다!");
						}
						
					case "0":
						sw = false;
						break;
					default :
						System.out.println("잘못 입력했습니다.");
					}
				}
						
				
			}else if(Integer.parseInt(menu) == 0) {
				run = false;
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				break;
			}else {
				System.out.println("\n잘못 입력했습니다 !");
			}
			
			
			
		}
	}
}
