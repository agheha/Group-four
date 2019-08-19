package ui;

import java.util.Scanner;

public abstract class BaseUI {
	protected Scanner sc = new Scanner(System.in);
	
	public abstract void service();
	
	protected String getString(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}
	protected int getInt(String msg) {
		
		return Integer.parseInt(getString(msg));
		
	}
	//상세보기 메뉴 공용으로 사용할 메서드 
	public int menu() {
		System.out.println("------------------------------");
		System.out.println("1.상세보기 (가게번호를 입력해주세요)");
		System.out.println("2.이전 돌아가기");
		System.out.println("0.종료");
		System.out.println("------------------------------");
		return getInt("번호를 입력해주세요 : ");
	}
}
