package g4.mini.user.account.ui;

import java.util.Scanner;

import g4.mini.reservation.ui.CheckReservationUI;
import g4.mini.reservation.ui.UserReservationUI;
import g4.mini.store.list.ui.StoreListUI;

public class UserAccountUI {
	Scanner sc = new Scanner(System.in);

	public void service() {
		while(true) {
			switch(menu()) {
			case 1 : new StoreListUI().service(); break;
			case 2 : new InfoUserUI().service(); break;
			case 3 : new CheckReservationUI().service(); break;
			case 4 : return;
			case 0 : 
				System.out.println("프로그램을 종료합니다. ");
				System.exit(0);
			default:
				System.out.println("잘못된 메뉴번호 입니다.");
				System.out.println("다시 선택해 주세요.");
			}
		}
	}

	private int menu() {
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("비트캠프 점심메뉴에 오신 것을 환영합니다.");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("1. 맛집 보기");
		System.out.println("2. 회원 정보");
		System.out.println("3. 예약 정보확인");	
		System.out.println("4. 이전 돌아가기");	
		System.out.println("0. 종료");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.print("☞ 메뉴 중 처리할 항목을 선택하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
}
