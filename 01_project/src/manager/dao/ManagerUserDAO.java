package manager.dao;

import java.util.Arrays;

import manager.vo.ManagerUser;


public class ManagerUserDAO {
	public ManagerUser[] userArr = new ManagerUser[3];
	int userPos = 0;
	int userNo = 0;
	public ManagerUser[] selectUser() {
		return Arrays.copyOf(userArr, userPos);
	}
	public ManagerUser selectOneUser(int no) {
		for (int i = 0 ; i < userPos ; i++) {
			ManagerUser user = userArr[i];
			if (user.getUserNum() != no) continue;
			return user;
		}
		return null;
	}
	public void insertUser(ManagerUser user) {
		if (userArr.length == userPos) {
			userArr = Arrays.copyOf(userArr, userPos += 10);
		}
		
		user.setUserNum(++userNo);
		userArr[userPos++] = user;
	}
	public void UpdateUser(ManagerUser user) {
		for (int i = 0 ; i < userPos ; i++) {
			ManagerUser m = userArr[i];
			if (m.getUserNum() != user.getUserNum()) continue;
			m.setId(user.getId());
			m.setPass(user.getPass());
			m.setName(user.getName());
			m.setBirth(user.getBirth());
			m.setAddr(user.getAddr());
		}
	}
	public int deleteUser(int no) {
		int cnt = userArr.length - (no + 1);
		for (int i = 0 ; i < userPos ; i++) {
			ManagerUser user = userArr[i];
			if (user.getUserNum() != no) continue;
			System.arraycopy(userArr, i + 1, userArr, i, cnt);
			userArr[--userPos] = null;
			return 1;
		}
		return 0;
	}
	
}
