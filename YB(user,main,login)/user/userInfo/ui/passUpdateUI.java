package user.userInfo.ui;

import session.LoginStatus;
import user.dao.UserDAO;
import user.ui.BaseUI;

public class passUpdateUI extends BaseUI{
		
	private UserDAO dao;
	
	public void service() {
		while(true) {
			System.out.println("------------------------------");
			System.out.println("비밀번호 변경");
			System.out.println("------------------------------");
			System.out.println("변경할 비밀번호를 입력하세요. ");
			String pass = getString("비밀번호 : ");
			String pass2 = getString("비밀번호확인 : ");
			if (!pass.equals(pass2)) {
				System.out.println("비밀번호가 일치하지 않습니다. ");
				System.out.println("다시 입력해주세요. ");
				continue;
			}
			
			// 로그인되어있는 유저의 userNo와 변경할 비밀번호 넘김
			dao.passUpdate(LoginStatus.login.getUserNo(), pass);
			System.out.println("비밀번호 변경이 완료되었습니다.");
			break;
		}
	}
}
