package g4.mini.user.test;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.main.ui.MainUI;
import g4.mini.session.LoginStatus;
import g4.mini.ui.BaseUI;
import g4.mini.user.dao.UserMapper;

public class findUserInfoUI extends BaseUI {
	
	public void service() {
		while(true) {
			switch(menu()) {
				case 1: new findUserIdUI().service(); break;
				case 2: new findUserPassUI().service(); break;
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
		System.out.println("아이디 / 비밀번호 찾기");
		System.out.println("-------------------------");
		System.out.println("1. 아이디 찾기");
		System.out.println("2. 비밀번호 찾기");
		System.out.println("0. 이전 화면");
		System.out.println("-------------------------");
		return getInt("번호를 입력하세요 : ");
	}

}
