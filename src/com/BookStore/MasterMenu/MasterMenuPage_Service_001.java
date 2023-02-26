package com.BookStore.MasterMenu;

import java.util.List;
import java.util.Scanner;

import com.BookStore.DAO.MasterMenuPage_DAO_001;
import com.BookStore.DAO.UserDAO;
import com.BookStore.Service.Book;
import com.BookStore.Service.User;

public class MasterMenuPage_Service_001 {
	Scanner sc = new Scanner(System.in);
	
	//모든 유저를 출력해주마
	public void ViewAllUser() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		List<User> list = MasterMenuPage_DAO_001.getInstance().ViewAllUser();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("[ "+(i+1)+" ] "+"  ===================================================================\n"+list.get(i).toStringList());
		}
	}
	
	
	//유저 삭제
	public void DeleteUser() {
		
		System.out.println("삭제할 유저의 목록번호를 입력하십시오.");
		//원하는 숫자를 입력하세요 !
		int index = Integer.parseInt(sc.nextLine());
		List<User> list = MasterMenuPage_DAO_001.getInstance().ViewAllUser();
		//DAO한테 삭제를 요청함 !
		System.out.println(index);
		System.out.println(list.size());
		if(index <= list.size()){
			int result = MasterMenuPage_DAO_001.getInstance().DeleteUser(list.get(index-1));			
			if(result >= 0) {
				System.out.println("삭제 성공 !");
			}else {
				System.out.println("삭제 실패 !");
				System.out.println("계정이 이미 없을수 있습니다. 확인후 다시 시도하세요");
			}
		}else {
			System.out.println("항목의 번호를 다시 확인하세요 !");
		}
	}
	
	//유저 검색
	public void UserSearch() {
		MasterMenuPage mp = new MasterMenuPage();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("==========================================================================\n\n");
		System.out.println("        원하는 유저의 [이름, 고유번호, 핸드폰번호, 이메일, ID] 중 키워드를 입력하십시오.");
		System.out.println("        키워드의 중복된 유저들의 데이터가 출력됩니다.\n\n");
		System.out.println("==========================================================================\n\n");
		//데이터 입력받음.
		String searchString = sc.nextLine();
		//문자열이 숫자인경우, int형식으로도 바꿈
		int searchInt = -1;
		//문자열이 숫자가아니면, 오류가뜨지만 catch에서 씹을거임.
		try {
			searchInt = Integer.parseInt(searchString);
		}catch(NumberFormatException e) {
			
		}
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		//검색된 리스트의 배열을 담음
		List<User> list = MasterMenuPage_DAO_001.getInstance().UserSearch(searchString, searchInt);
		System.out.println("값 출력전 콘솔 !");
		
		//검색된 배열을 출력함
		for (int i = 0; i < list.size(); i++) {
			System.out.println("[ "+(i+1)+" ] "+"  ===================================================================\n"+list.get(i).toStringList());
		}
		
		//조회된 list의 index길이가 없으면 데이터없는거임 
		if(list.size() == 0) {
			System.out.println("조회된 데이터가 없습니다!");
		}else {
			//유저의 검색결과가 있으면, 수정하는 곳으로 간다.
			mp.UserSearchAndEdit(list);
		}
		
	}
	
	public void ChangeDataInt(String Type, int UNumber, int newData) {
		int result = MasterMenuPage_DAO_001.getInstance().ChangeDateInt(Type, newData, UNumber);
		if(result > 0) {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("수정완료 !");
			
		}else {
			System.out.println("데이터 수정실패 !");
		}
		 
	}
	
	public boolean ChangeDateString(String Type, int UNumber, String newData) {
		int result = MasterMenuPage_DAO_001.getInstance().ChangeDateString(Type, newData, UNumber);
		if(result > 0) {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("수정완료 !");
			return true;
		}else {
			System.out.println("데이터 수정실패 !");
			return false;
		}
		 
	}
	
	//핸드폰 번호 변경전 데이터 비교
	public void DataTelCompare(String type, int UNumber) {
		System.out.println("변경할 전화번호 데이터를 입력하세요 ↓"); //유니크
		String editData = "";
		
		boolean sw = true;
		
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
					editData=value;
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
		 int result = MasterMenuPage_DAO_001.getInstance().ChangeDateString(type, editData, UNumber);
		 if(result > 0 ) {
			 System.out.println("성공적으로 변경했습니다 ! ");
		 }else {
			 System.out.println("변경을 완료하지 못했습니다 !");
		 }
	}
	
	//메일 변경전 데이터 비교
	public void DataMailCompare(String type, int UNumber) {
		System.out.println("변경할 이메일을 입력하세요 ↓"); //유니크
		String editData = "";
		
		boolean sw = true;
		
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
					editData=value;
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
		 int result = MasterMenuPage_DAO_001.getInstance().ChangeDateString(type, editData, UNumber);
		 if(result > 0 ) {
			 System.out.println("성공적으로 변경했습니다 ! ");
		 }else {
			 System.out.println("변경을 완료하지 못했습니다 !");
		 }
	}
	
	//판매기록 조회
	public void SalesList()	{
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				List<Book> list = MasterMenuPage_DAO_001.getInstance().SalesList();
				for (int i = 0; i < list.size(); i++) {
					System.out.println("[ "+(i+1)+" ] "+"  ===================================================================\n"+list.get(i).toStringSalesList());
				}
	}
	
	
}
