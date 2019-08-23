package g4.mini.user.account.ui;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.session.LoginStatus;
import g4.mini.ui.BaseUI;
import g4.mini.user.account.dao.UserAccountMapper;
import g4.mini.vo.User;

public class UpdateUserUI extends BaseUI{
		
	private UserAccountMapper mapper;
	
	public UpdateUserUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(UserAccountMapper.class);
	}
	
	public void service() {
		while(true) {
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("비밀번호 변경");
			System.out.println("-------------------------------------------------------------------------------------");
			if (mapper.checkPass(getString("☞ 현재 비밀번호를 입력하세요 : ")) == null) {
				System.out.println("비밀번호가 일치하지 않습니다.");
				return;
			}
			String pass = getString("☞ 변경 비밀번호 : ");
			String pass2 = getString("☞ 비밀번호 확인 : ");
			
			if (!pass.equals(pass2)) {
				System.out.println("비밀번호가 일치하지 않습니다. ");
				continue;
			}
			if (pass.equals(LoginStatus.login.getUserPass())) {
				System.out.println("비밀번호가 동일합니다");
				return;
			}
			User user = LoginStatus.login;
			user.setUserPass(pass);
			
			// 로그인되어있는 유저의 userNo와 변경할 비밀번호 넘김
			mapper.passUpdate(user);
			System.out.println("비밀번호 변경이 완료되었습니다.");
			break;
		}
	}
}
