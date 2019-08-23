package g4.mini.store.account.ui;

import java.util.Scanner;

import g4.mini.main.MainUI;
import g4.mini.session.StoreLoginStatus;


public class StoreAccountUI {
	Scanner sc = new Scanner(System.in);
	
	public void service() {
		while(true) {
			switch(menu()) {
			case 1 : new StoreInfoUI().service(); break;
			case 2 : new StoreMenuAddUI().service(); break;
			case 3 : 
				StoreLoginStatus.login = null;
				new MainUI().service(); 
				break;
			case 4 : return;
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
		System.out.println("가게 정보");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("1. 가게 가입정보");
		System.out.println("2. 가게 메뉴등록");
		System.out.println("3. 로그아웃");
		System.out.println("4. 이전 돌아가기");
		System.out.println("0. 종료");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.print(" ☞ 메뉴를 선택해주세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
}
