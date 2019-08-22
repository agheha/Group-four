package g4.mini.user.account.ui;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.session.LoginStatus;
import g4.mini.ui.BaseUI;
import g4.mini.user.account.dao.UserAccountMapper;
import g4.mini.vo.User;

public class SelectOneUserUI extends BaseUI{
	private UserAccountMapper mapper;
	
	public SelectOneUserUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(UserAccountMapper.class);
	}
	
	public void service() {
		
		User user = mapper.selectOneUser(LoginStatus.login.getUserNo());
	//	User user = dao.selectOneUser(LoginStatus.login.getUserNo());
		System.out.println("회원번호 : " + user.getUserNo());
		System.out.println("아이디 : " + user.getUserId());
		System.out.println("비밀번호 : " + user.getUserPass());
		System.out.println("생년월일 : " + user.getUserBirth());
		System.out.println("-------------------------------------------------------------------------------------");
	}
}
