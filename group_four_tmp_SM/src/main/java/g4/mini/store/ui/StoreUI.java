package g4.mini.store.ui;

import java.util.Scanner;

public class StoreUI {
	Scanner sc = new Scanner(System.in);
	
	public void service() {
		while(true) {
			switch(menu()) {
			case 1 : new StoreLoginUI().service(); break;
			case 2 : new StoreJoinUI().service(); break;
			case 3 : return;
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
		System.out.println("가맹점 전용");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입 ");
		System.out.println("3. 이전 돌아가기");
		System.out.println("0. 종료");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.print(" ☞ 메뉴를 선택해주세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
}
