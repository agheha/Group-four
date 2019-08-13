package manager.userui;

import manager.dao.ManagerUserDAO;
import manager.ui.BaseUI;

public class DeleteUserUI extends BaseUI {
private ManagerUserDAO userDao;
	
	public DeleteUserUI(ManagerUserDAO userDao) {
		super();
		this.userDao = userDao;
	}
	
	public void service() {
		int no = getInt("삭제할 회원번호를 입력하세요 : ");
		int result = userDao.deleteUser(no);
		if (result == 1) {
			System.out.println();
			System.out.println("회원정보가 삭제되었습니다.");
			return;
		}
		System.out.println("해당 번호는 존재하지 않습니다.");
	}
}
