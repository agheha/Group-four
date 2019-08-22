package g4.mini.user.test;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.session.LoginStatus;
import g4.mini.ui.BaseUI;
import g4.mini.user.dao.UserMapper;
import g4.mini.user.domain.User;

public class selectOneUserUI extends BaseUI{
	private UserMapper mapper;
	
	public selectOneUserUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(UserMapper.class);
	}
	
	public void service() {
		
		User user = mapper.selectOneUser(LoginStatus.login.getUserNo());
	//	User user = dao.selectOneUser(LoginStatus.login.getUserNo());
		System.out.println("회원번호 : " + user.getUserNo());
		System.out.println("아이디 : " + user.getUserId());
		System.out.println("비밀번호 : " + user.getUserPass());
		System.out.println("생년월일 : " + user.getUserBirth());
		System.out.println("-------------------------");
	}
}
