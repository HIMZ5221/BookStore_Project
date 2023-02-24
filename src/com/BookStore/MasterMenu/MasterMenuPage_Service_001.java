package com.BookStore.MasterMenu;

import java.util.List;
import java.util.Scanner;

import com.BookStore.DAO.MasterMenuPage_DAO_001;
import com.BookStore.Service.Book;
import com.BookStore.Service.User;

public class MasterMenuPage_Service_001 {
	Scanner sc = new Scanner(System.in);
	
	public void ViewAllUser() {
		//모든 유저를 출력해주마
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		List<User> list = MasterMenuPage_DAO_001.getInstance().ViewAllUser();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("[ "+(i+1)+" ] "+"  ===================================================================\n"+list.get(i).toStringList());
		}
	}
	
	public void DeleteUser() {
		//유저 삭제
		System.out.println("삭제할 유저의 목록번호를 입력하십시오.");
		int index = Integer.parseInt(sc.nextLine());
		List<User> list = MasterMenuPage_DAO_001.getInstance().ViewAllUser();
		//DAO한테 삭제를 요청함 !
		int result = MasterMenuPage_DAO_001.getInstance().DeleteUser(list.get(index-1));
		if(result >= 0) {
			System.out.println("삭제 성공 !");
		}else {
			System.out.println("삭제 실패 !");
			System.out.println("계정이 이미 없을수 있습니다. 확인후 다시 시도하세요");
		}
	}
	
	
	//판매기록 조회
	public void SalesList()	{
		//모든 유저를 출력해주마
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				List<Book> list = MasterMenuPage_DAO_001.getInstance().SalesList();
				for (int i = 0; i < list.size(); i++) {
					System.out.println("[ "+(i+1)+" ] "+"  ===================================================================\n"+list.get(i).toString());
				}
	}
}
