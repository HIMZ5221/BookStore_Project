package com.ConsoleView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleView {

	public void JumpConsole() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	
	//로그인중 메뉴 ! 간편화 실패 !!
	//일반회원 로그인 | 마스터 로그인
	public void LoginLoading() {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("ssSSS"); 
		Date now1 = new Date();
		String nowTime1 = sdf1.format(now1);
		int Time = Integer.parseInt(nowTime1);
		
		boolean sw = true;
		int count = 0;
		
		
		while(sw) {
			//시간을 원하는  Format형태에 맞춤
			SimpleDateFormat sdf2 = new SimpleDateFormat("ssSSS"); 
			//게속 변경되는 현제 시간 !
			Date now2 = new Date();
			//String 으로 저장!
			String nowTime2 = sdf2.format(now2);
			//문자타입의 현재 시간을 int 타입으로 변환 !
			int dateInt2 = Integer.parseInt(nowTime2);
			
			//기준시간이, 60초를 넘겼다면, 60초를 뺀값으로 계산.
			if(Time > 60000) {
				Time -= 60000;
				dateInt2 -= 60000;
			}
			
			//어떠한 이유로, 기준시간보다 현재시간이 높아지는것을 방지함.
			if(Time < dateInt2) {
				Time = dateInt2;
			}
			
			//테스트용
			if(Time >60000) {
				System.out.println("time 이 60000을 넘겼습니다 !");
				System.out.println(Time);
			}
			if(dateInt2 > 60000) {
				System.out.println("현재시간이 60000을 넘깁니다 ");
				System.out.println(dateInt2);
			}
			
			
			if(Time == dateInt2) {
				//원하는 시간 타임 설정
				Time = Time + 300;
				//점 두개를 위해서.. ! ㅋㅋㅋ
				System.out.print("..");
				count++;
				if(count == 5) {
					sw = false;
				}
				
			}
		}
	}
	
	public void BuyLoading() {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("ssSSS"); 
		Date now1 = new Date();
		String nowTime1 = sdf1.format(now1);
		int Time = Integer.parseInt(nowTime1);
		
		boolean sw = true;
		int count = 0;
		boolean botten = true;
		
		while(sw) {
			//시간을 원하는  Format형태에 맞춤
			SimpleDateFormat sdf2 = new SimpleDateFormat("ssSSS"); 
			//게속 변경되는 현제 시간 !
			Date now2 = new Date();
			//String 으로 저장!
			String nowTime2 = sdf2.format(now2);
			//문자타입의 현재 시간을 int 타입으로 변환 !
			int dateInt2 = Integer.parseInt(nowTime2);
			
			//기준시간이, 60초를 넘겼다면, 60초를 뺀값으로 계산.
			if(Time > 60000) {
				Time -= 60000;
				dateInt2 -= 60000;
			}
			
			//어떠한 이유로, 기준시간보다 현재시간이 높아지는것을 방지함.
			if(Time < dateInt2) {
				Time = dateInt2;
			}
			
			//테스트용
			if(Time >60000) {
				System.out.println("time 이 60000을 넘겼습니다 !");
				System.out.println(Time);
			}
			if(dateInt2 > 60000) {
				System.out.println("현재시간이 60000을 넘깁니다 ");
				System.out.println(dateInt2);
			}
			
			
			if(Time == dateInt2) {
				//원하는 시간 타임 설정
				Time = Time + 500;
				//점 두개를 위해서.. ! ㅋㅋㅋ
				
				if(botten == true) {
					JumpConsole();
					System.out.println("\t\t▨▨▤▤▤▤▤▤▤▤▤▤▤▤▧▧ ");
					System.out.println("\t\t▨☆☆☆☆☆☆☆☆☆☆☆☆☆☆▧  ");
					System.out.println("\t\t▥☆                ☆▥ ");
					System.out.println("\t\t▥☆                ☆▥ ");
					System.out.println("\t\t▥☆    구매완료!!!    ☆▥ ");
					System.out.println("\t\t▥☆                ☆▥ ");
					System.out.println("\t\t▥☆                ☆▥ ");
					System.out.println("\t\t▧☆☆☆☆☆☆☆☆☆☆☆☆☆☆▨  ");
					System.out.println("\t\t▧▧▤▤▤▤▤▤▤▤▤▤▤▤▨▨");
					System.out.println("\n\n");
					botten = false ; 
				}else if(botten == false) {
					
					JumpConsole();
					System.out.println("\t\t▨▨▤▤▤▤▤▤▤▤▤▤▤▤▧▧ ");
					System.out.println("\t\t▧★★★★★★★★★★★★★★▨  ");
					System.out.println("\t\t▥★                ★▥ ");
					System.out.println("\t\t▥★                ★▥ ");
					System.out.println("\t\t▥★    구매완료!!!    ★▥ ");
					System.out.println("\t\t▥★                ★▥ ");
					System.out.println("\t\t▥★                ★▥ ");
					System.out.println("\t\t▧★★★★★★★★★★★★★★▨  ");
					System.out.println("\t\t▧▧▤▤▤▤▤▤▤▤▤▤▤▤▨▨");
					System.out.println("\n\n");
					
					botten = true;
				}
				count++;
				if(count == 10) {
					sw = false;
				}
				
			}
		}
	}
	
	


}
