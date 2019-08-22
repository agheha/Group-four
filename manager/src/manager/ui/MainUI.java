package manager.ui;

import java.util.Scanner;

import manager.dao.ManagerDAO;
import store.ui.DeleteManagerUI;
import store.ui.SelectManagerUI;
import store.ui.UpdateManagerUI;
import ui.BaseUI;

public class MainUI{
	private Scanner sc = new Scanner(System.in);
	ManagerDAO dao = new ManagerDAO();

	private int menu() {
		System.out.println("1. 맛집수정");
		System.out.println("2. 맛집삭제");
		System.out.println("3. 가게확인");
		System.out.println("0. 이전화면");
		
		System.out.println("---------------------------");
		System.out.print("번호를 입력하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
	
	public void service() {
		System.out.println("---------------------------");
		System.out.println("관리자ID");
		System.out.println("---------------------------");
		while (true) {
			BaseUI ui = null;
			switch (menu()) {
			case 1: ui = new UpdateManagerUI(dao); break;
			case 2: ui = new DeleteManagerUI(dao); break;
			case 3: ui = new SelectManagerUI(dao); break;
			case 0: exit();
			default:
				System.out.println("잘못된 메뉴번호 입니다.");
				System.out.println("다시 선택해 주세요.");
			}
			if (ui != null) ui.service();
		}
	}
	
	void exit() {
		sc.close();
		// 프로세스 종료
		System.out.println("게시판 시스템을 종료합니다.");
		System.exit(0);
	}
	
}
