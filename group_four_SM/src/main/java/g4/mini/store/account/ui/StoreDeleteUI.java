package g4.mini.store.account.ui;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.main.MainUI;
import g4.mini.session.StoreLoginStatus;
import g4.mini.store.account.dao.StoreAccountMapper;
import g4.mini.ui.BaseUI;

public class StoreDeleteUI extends BaseUI {

	private StoreAccountMapper mapper;

	public StoreDeleteUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(StoreAccountMapper.class);
	}

	public void service() {
		while (true) {
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("가게 탈퇴");
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("회원 탈퇴를 이후 더이상 서비스 이용할수 없습니다.");
			System.out.println("탈퇴 하시겠습니까?");
			String input = getString("(탈퇴 Y, 이전 돌아가기 N) : ");
			switch (input) {
			case "Y":
				int stoNo = StoreLoginStatus.login.getStoNo();
				mapper.deleteStore(stoNo);
				StoreLoginStatus.login = null;
				System.out.println("회원 탈퇴 되었습니다.");
				new MainUI().service();
				break;
			case "N":
				return;
			default:
				System.out.println("잘못된 입력입니다.");
				System.out.println("다시 입력해주세요.");
			}
		}
	}

}
