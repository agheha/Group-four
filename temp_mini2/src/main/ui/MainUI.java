package main.ui;

import java.util.Scanner;

import member.dao.MemberDAO;
import member.ui.JoinMemberUI;
import ui.BaseUI;

public class MainUI{
	private Scanner sc = new Scanner(System.in);
	MemberDAO dao = new MemberDAO();

	private int menu() {
		System.out.println("---------------------------");
		System.out.println("비트캠프 점심메뉴에 오신걸 환영합니다.");
		System.out.println("---------------------------");
		System.out.println("1. 예약확인");
		System.out.println("2. 가게보기");
		System.out.println("3. 회원정보");
		System.out.println("0. 로그아웃");
		
		System.out.println("---------------------------");
		System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
		return Integer.parseInt(sc.nextLine());
		
	}
	public void service() {
		BaseUI ui = null;
			switch (menu()) {
			case 1: break;
			case 2: ui = new JoinMemberUI(); break;
			case 3: break;
			case 4: break;
			case 5: break;
			case 0: break;
			default:
				System.out.println("잘못된 메뉴번호 입니다.");
				System.out.println("다시 선택해 주세요.");
			}
			if (ui != null) ui.service();
				
	}
}
