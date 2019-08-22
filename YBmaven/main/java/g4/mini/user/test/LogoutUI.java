package g4.mini.user.test;

import g4.mini.session.LoginStatus;
import g4.mini.ui.BaseUI;

public class LogoutUI extends BaseUI {
	public void service() {
		LoginStatus.login = null;
		System.out.println("로그아웃 되었습니다.");		
	}
}
