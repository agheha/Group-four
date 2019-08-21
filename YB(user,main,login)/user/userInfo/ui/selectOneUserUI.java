package user.userInfo.ui;

import login.dao.LoginDAO;
import session.LoginStatus;
import user.dao.UserDAO;
import user.ui.BaseUI;
import user.vo.User;

public class selectOneUserUI extends BaseUI{
	private UserDAO dao;
	
	public selectOneUserUI() {
		dao = new UserDAO();
	}
	
	public void service() {
		User user = dao.selectOneUser(LoginStatus.login.getUserNo());
		System.out.println("회원번호 : " + user.getUserNo());
		System.out.println("아이디 : " + user.getUserId());
		System.out.println("비밀번호 : " + user.getUserPass());
		System.out.println("생년월일 : " + user.getUserBirth());
		System.out.println("-------------------------");
	}
}
