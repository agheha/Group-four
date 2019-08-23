package g4.mini.store.account.ui;

import java.util.Scanner;

import g4.mini.reservation.ui.StoreReservationUI;
import g4.mini.session.StoreLoginStatus;
import g4.mini.ui.BaseUI;

public class StoreAccountUI extends BaseUI{
	
Scanner sc = new Scanner(System.in);
	
	public void service() {
		while(true) {
			switch(menu()) {
			case 1 : 
				new StoreSelectOneUI().service(); break;
			case 2 : new StorePassUpdateUI().service(); break;
			case 3 : new StoreInfoUpdateUI().service(); break;
			case 4 : new StoreDeleteUI().service(); break;
			case 5 : new StoreReservationUI().service(); break;			
			case 6 : return;
			case 0 : 
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default : 
				System.out.println("번호를 다시 확인해주세요.");
			}
		}
	}
	public int menu() {
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("가게 정보 수정");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("1. 가게 정보 조회");
		System.out.println("2. 비밀번호 변경");
		System.out.println("3. 상세정보 수정");
		System.out.println("4. 탈퇴 ");
		System.out.println("5. 현재좌석수 수정");		
		System.out.println("6. 이전 돌아가기");
		System.out.println("0. 종료");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.print(" ☞ 메뉴를 선택해주세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
}
