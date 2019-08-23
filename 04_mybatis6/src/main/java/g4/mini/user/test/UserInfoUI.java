package g4.mini.user.test;

import g4.mini.main.ui.MainUI;
import g4.mini.session.LoginStatus;
import g4.mini.ui.BaseUI;

public class UserInfoUI extends BaseUI{
	
	public void service() {
		while(true) {
			switch(menu()) {
				case 1: new selectOneUserUI().service(); break;
				case 2: new passUpdateUI().service(); break;
				case 3: 
					new userDeleteUI().service(); 
					if(LoginStatus.login == null) new MainUI().service();
					break;
				case 0:
					return;
				default :
					System.out.println("잘못된 메뉴번호 입니다.");
					System.out.println("다시 입력해주세요.");
			}
		}
	}
	
	
	public int menu() {
		System.out.println("-------------------------");
		System.out.println("회원 정보");
		System.out.println("-------------------------");
		System.out.println("1. 내정보 보기");
		System.out.println("2. 비밀번호 변경");
		System.out.println("3. 회원 탈퇴");
		System.out.println("0. 이전 화면");
		System.out.println("-------------------------");
		return getInt("번호를 입력하세요 : ");
	}

}
