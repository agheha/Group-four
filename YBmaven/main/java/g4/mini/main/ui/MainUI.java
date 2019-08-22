package g4.mini.main.ui;

import java.util.Scanner;
import login.ui.LoginUI;
import login.ui.LogoutUI;
import session.LoginStatus;
import user.ui.BaseUI;
import user.ui.UserJoinUI;
import user.userInfo.ui.UserInfoUI;

public class MainUI {
	private Scanner sc = new Scanner(System.in);
	
	private int menu() {
		System.out.println("------------------------------");
		System.out.println("비트캠프 점심메뉴에 오신 것을 환영합니다.");
		System.out.println("------------------------------");
		if(LoginStatus.login != null) {
			System.out.println("1. ★오늘의 메뉴★");
			System.out.println("2. 맛집 보기");
			System.out.println("3. 회원 정보");
			System.out.println("0. 로그 아웃");
		}else {
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("0. 종료");
		}
		System.out.println("------------------------------");
		System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
		
		
	private BaseUI loginMenu() {
			while(true) {
				switch (menu()) {
				case 1: break;
				case 2: break;
				case 3: return new UserInfoUI(); 
				case 0: return new LogoutUI(); 
				default:
					System.out.println("잘못된 메뉴번호 입니다.");
					System.out.println("다시 선택해 주세요.");
				}
			}
		}		
	
	private BaseUI beforeloginMenu() {
		while(true) {
			switch(menu()) {
			case 1: return new LoginUI(); 
			case 2: return new UserJoinUI();
			case 0:
				System.out.println("프로그램을 종료합니다. ");
				System.exit(0);
			default:
				System.out.println("잘못된 메뉴번호 입니다.");
				System.out.println("다시 선택해 주세요.");
			}
		}
	}
	
	
	
	public void service() {
		BaseUI ui = null;
		while(true) {
			if(LoginStatus.login != null) {
				ui = loginMenu();
			}else {
				ui = beforeloginMenu();
			}
			ui.service();
		}
	}
	
	
	

	
	
	
}
