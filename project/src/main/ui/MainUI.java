package main.ui;

import java.util.Scanner;

import user.ui.UserUI;

public class MainUI {
	private Scanner sc = new Scanner(System.in);
	
	//최초 메인화면 메뉴 선택
	public void service() {
		while (true) {
			switch(menu()) {
			case 1 : new UserUI().service(); break;
			case 2 : break;
			case 3 : break;
			case 0 : 
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
			default : 
				System.out.println("번호를 확인해주세요");
			}
		}
	}
	
	private int menu() {
		System.out.println("------------------------------");
		System.out.println("선물추천 프로그램");
		System.out.println("------------------------------");
		System.out.println("------------------------------");
		System.out.println("1. 사용자");
		System.out.println("2. 가맹점");
		System.out.println("3. 관리자");
		System.out.println("0. 종료");
		System.out.println("------------------------------");
		System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
		return Integer.parseInt(sc.nextLine());
		
	}
}
