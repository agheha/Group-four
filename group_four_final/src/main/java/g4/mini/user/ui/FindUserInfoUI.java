package g4.mini.user.ui;


import g4.mini.ui.BaseUI;

public class FindUserInfoUI extends BaseUI {
	
	public void service() {
		while(true) {
			switch(menu()) {
				case 1: new FindUserIdUI().service(); break;
				case 2: new FindUserPassUI().service(); break;
				case 3: return;
				case 0:
					return;
				default :
					System.out.println("잘못된 메뉴번호 입니다.");
					System.out.println("다시 입력해주세요.");
			}
		}
	}
	
	public int menu() {
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("아이디 / 비밀번호 찾기");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("1. 아이디 찾기");
		System.out.println("2. 비밀번호 찾기");
		System.out.println("3. 이전 화면");
		System.out.println("0. 종료");
		System.out.println("-------------------------------------------------------------------------------------");
		return getInt("☞ 메뉴를 선택해주세요 : ");
	}
}
