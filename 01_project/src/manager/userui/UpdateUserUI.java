package manager.userui;

import manager.dao.ManagerUserDAO;
import manager.ui.BaseUI;
import manager.vo.ManagerUser;

public class UpdateUserUI extends BaseUI{
	private ManagerUserDAO userDao;
	
	public UpdateUserUI(ManagerUserDAO userDao) {
		super();
		this.userDao = userDao;
	}

	public void service() {
		int no = getInt("수정할 회원번호를 입력하세요 : ");
		ManagerUser user = userDao.selectOneUser(no);
		if (user == null) {
			System.out.println("해당 번호는 존재하지 않습니다.");
			return;
		}
		// 글번호가 존재할때 사용자에게 수정할 내용을 받는다.
		user.setId(getString("아이디를 입력하세요 : "));
		user.setPass(getString("비밀번호를 입력하세요 : "));
		user.setName(getString("이름을 입력하세요 : "));
		user.setBirth(getString("생일을 입력하세요 : "));
		user.setAddr(getString("주소를 입력하세요 : "));
		
		userDao.UpdateUser(user);
		
		System.out.println();
		System.out.println("회원정보가 수정되었습니다.");	
	}
}
