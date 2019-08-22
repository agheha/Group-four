package login.ui;

import session.LoginStatus;
import user.ui.BaseUI;

public class LogoutUI extends BaseUI {
	public void service() {
		LoginStatus.login = null;
		System.out.println("로그아웃 되었습니다.");		
	}
}
