package manager.userui;

import manager.dao.ManagerUserDAO;
import manager.ui.BaseUI;
import manager.vo.ManagerUser;

public class ListUserUI extends BaseUI {
private ManagerUserDAO userDao;
	
	public ListUserUI(ManagerUserDAO userDao) {
		super();
		this.userDao = userDao;
	}
	
	public void service() {
		ManagerUser[] userList = userDao.selectUser();
		
		System.out.println("전체 " + userList.length + "명");
		System.out.println("=========================================");
		if (userList.length == 0) {
			System.out.println("회원 정보가 존재하지 않습니다.");
			return;
		}
		for (int i = userList.length - 1 ; i >= 0; i--) {
			ManagerUser user = userList[i];
			System.out.printf(
					"회원번호 : %-3d\n아이디 : %-15s\n비밀번호 : %-10s\n이름 : %-5s\n생년월일 : %-6s\n주소 : %-20s\n", 
					user.getUserNum(), user.getId(), user.getPass(), user.getName(),user.getBirth(),user.getAddr());
		}
	}
}
