package project;

import java.util.Arrays;


public class ManageruserDAO {
	public Manageruser[] userArr = new Manageruser[3];
	int userPos = 0;
	int userNo = 0;
	public Manageruser[] selectUser() {
		return Arrays.copyOf(userArr, userPos);
	}
	public Manageruser selectOneUser(int no) {
		for (int i = 0 ; i < userPos ; i++) {
			Manageruser user = userArr[i];
			if (user.getUserNum() != no) continue;
			return user;
		}
		return null;
	}
	public void insertUser(Manageruser user) {
		if (userArr.length == userPos) {
			userArr = Arrays.copyOf(userArr, userPos += 10);
		}
		
		user.setUserNum(++userNo);
		userArr[userPos++] = user;
	}
	public void UpdateUser(Manageruser user) {
		for (int i = 0 ; i < userPos ; i++) {
			Manageruser m = userArr[i];
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
			Manageruser user = userArr[i];
			if (user.getUserNum() != no) continue;
			System.arraycopy(userArr, i + 1, userArr, i, cnt);
			userArr[--userPos] = null;
			return 1;
		}
		return 0;
	}
	
}
