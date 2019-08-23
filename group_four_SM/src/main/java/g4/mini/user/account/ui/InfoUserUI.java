package g4.mini.user.account.ui;

import g4.mini.main.MainUI;
import g4.mini.session.LoginStatus;
import g4.mini.ui.BaseUI;

public class InfoUserUI extends BaseUI {

	public void service() {
		while (true) {
			switch (menu()) {
			case 1:
				new SelectOneUserUI().service();
				break;
			case 2:
				new UpdateUserUI().service();
				break;
			case 3:
				new DeleteUserUI().service();
				if (LoginStatus.login == null)
					new MainUI().service();
				break;
			case 0:
				return;
			default:
				System.out.println("잘못된 메뉴번호 입니다.");
				System.out.println("다시 입력해주세요.");
			}
		}
	}
	public int menu() {
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("회원 정보");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("1. 내정보 보기");
		System.out.println("2. 비밀번호 변경");
		System.out.println("3. 회원 탈퇴");
		System.out.println("0. 이전 화면");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.print("☞ 메뉴를 선택해주세요 : ");
		return Integer.parseInt(sc.nextLine());
	}

}
