package g4.mini.admin.ui;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import g4.mini.admin.dao.AdministratorMapper;
import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.ui.BaseUI;
import g4.mini.vo.User;

public class UserInfoUpdateUI extends BaseUI {

	private AdministratorMapper mapper;

	public UserInfoUpdateUI() {
		SqlSession session =  MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(AdministratorMapper.class);
	}
	
	public void service() {
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("회원번호\t아이디\t이름\t생일\t핸드폰번호\t이메일\t");
		List<User> list = mapper.selectMemberList();
		for (User u : list) {
			System.out.printf("%2d %10s %5s %10s%n", u.getUserNo(), u.getUserId(), u.getUserName(), u.getUserBirth() /*, u.getUserPH, u.getUserEmail*/);
		}
		System.out.println("-------------------------------------------------------------------------------------");
		int userNo = getInt("정보를 수정할 회원번호를 선택하세요 : ");
		User user = mapper.memberSelect(userNo);
		System.out.printf("%d%n%s%n%s%n%s%n", user.getUserNo(), user.getUserId(), user.getUserName(), user.getUserBirth() /*, user.getUserPH, user.getUserEmail*/);
		User u = new User();
		String str = getString("변경할 이름 : ");
		if (str.isEmpty()) {
			u.setUserName(user.getUserName());			
		} else {
			u.setUserName(str);						
		}
		str = getString("변경할 생년월일 : ");
		if (str.isEmpty()) {
			u.setUserBirth(user.getUserBirth());			
		} else {
			u.setUserBirth(str);						
		}
		u.setUserNo(userNo);
		mapper.memberUpdate(u);
		
		
		
		
		
	}

	
}
