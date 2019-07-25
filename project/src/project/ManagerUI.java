package project;

import java.util.Scanner;

public class ManagerUI {
	Scanner sc = new Scanner(System.in);
	ManageruserUI userUI = new ManageruserUI();
	ManagerstoreUI storeUI = new ManagerstoreUI();
	
	void service() {
		while(true) {
			switch (menu()) {
			case 1 : userUI.userSelect(); break;
			case 2 : userUI.userUpdate(); break;
			case 3 : userUI.userDelete(); break;
			case 4 : storeUI.storeSelect(); break;
			case 5 : storeUI.storeInsert(); break;
			case 6 : storeUI.storeUpdate(); break;
			case 7 : storeUI.storeDelete(); break;
			case 0 : exit();
				default :
					System.out.println("해당하는 번호를 찾을수 없습니다.");
					System.out.println("번호를 다시 입력해주세요.");
			}
		}
	}
	
	int menu() {
		System.out.println("=========================================");
		System.out.println("1. 회원 전체 조회");
		System.out.println("2. 회원 수정");
		System.out.println("3. 회원 삭제");
		System.out.println("4. 스토어 전체 조회");
		System.out.println("5. 스토어 추가");
		System.out.println("6. 스토어 수정");
		System.out.println("7. 스토어 삭제");
		System.out.println("0. 종료");
		System.out.println("=========================================");
		System.out.print("메뉴를 선택해 주세요.");
		return Integer.parseInt(sc.nextLine());
	}
	
	void exit() {
		System.exit(0);
	}
}
