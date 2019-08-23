package g4.mini.user.account.ui;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.main.MainUI;
import g4.mini.session.LoginStatus;
import g4.mini.session.StoreLoginStatus;
import g4.mini.ui.BaseUI;
import g4.mini.user.account.dao.UserAccountMapper;
public class DeleteUserUI extends BaseUI{
	private UserAccountMapper mapper;
	
	public DeleteUserUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(UserAccountMapper.class);
	}
	
	public void service() {
			while(true) {
				System.out.println("-------------------------------------------------------------------------------------");
				System.out.println("회원 탈퇴");
				System.out.println("-------------------------------------------------------------------------------------");
				System.out.println("회원 탈퇴를 이후 더이상 서비스 이용할수 없습니다.");
				System.out.println("탈퇴 하시겠습니까?");
				String input = getString("☞ 탈퇴 Y, 이전 돌아가기 N : ");
				switch (input) {
				case "Y":
					int userNo = LoginStatus.login.getUserNo();
					mapper.deleteUser(userNo);
					StoreLoginStatus.login = null;
					System.out.println("회원 탈퇴 되었습니다.");
					System.out.println("이용해주셔서 감사합니다.");
					new MainUI().service();
					break;
				case "N": return;
				default:
					System.out.println("잘못된 입력입니다.");
					System.out.println("다시 입력해주세요.");
				}
			}
	}
	
}