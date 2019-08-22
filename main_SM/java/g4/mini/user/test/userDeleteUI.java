package g4.mini.user.test;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.session.LoginStatus;
import g4.mini.ui.BaseUI;
import g4.mini.user.dao.UserMapper;

public class userDeleteUI extends BaseUI{
	private UserMapper mapper;
	
	public userDeleteUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(UserMapper.class);
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
					mapper.deleteUser(LoginStatus.login.getUserNo());
				//	dao.deleteUser(LoginStatus.login.getUserNo());
					LoginStatus.login = null;
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