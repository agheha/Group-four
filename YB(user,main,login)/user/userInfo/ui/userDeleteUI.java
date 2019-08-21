package user.userInfo.ui;

import session.LoginStatus;
import user.dao.UserDAO;
import user.ui.BaseUI;
import user.vo.User;

public class userDeleteUI extends BaseUI{
	private UserDAO dao;
	
	public userDeleteUI() {
		dao = new UserDAO();
	}
	
	public void service() {
			while(true) {
				System.out.println("------------------------------");
				System.out.println("회원 탈퇴");
				System.out.println("------------------------------");
				System.out.println("회원 탈퇴를 하시면 서비스 이용이 어렵습니다.");
				System.out.println("탈퇴 하시겠습니까?");
				String input = getString("(탈퇴 하시려면 y, 이전화면은 0을 입력하세요.)");
				switch(input) {
				case "y": 
					System.out.println("회원 탈퇴 되었습니다.");
					dao.deleteUser(LoginStatus.login.getUserNo());
					return;
				case "0":
					return;
				default:
					System.out.println("잘못된 입력입니다.");
					System.out.println("다시 입력하세요.");
					continue;
				}
			}
	}
	
}