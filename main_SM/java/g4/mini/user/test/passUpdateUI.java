package g4.mini.user.test;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.session.LoginStatus;
import g4.mini.ui.BaseUI;
import g4.mini.user.dao.UserMapper;
import g4.mini.vo.User;

public class passUpdateUI extends BaseUI{
		
	private UserMapper mapper;
	
	public passUpdateUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(UserMapper.class);
	}
	
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
			
			User user = LoginStatus.login;
			user.setUserPass(pass);
			
			// 로그인되어있는 유저의 userNo와 변경할 비밀번호 넘김
			mapper.passUpdate(user);
		//	dao.passUpdate(user);
			System.out.println("비밀번호 변경이 완료되었습니다.");
			break;
		}
	}
}
