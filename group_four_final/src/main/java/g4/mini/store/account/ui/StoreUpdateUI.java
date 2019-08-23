package g4.mini.store.account.ui;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.session.StoreLoginStatus;
import g4.mini.store.account.dao.StoreAccountMapper;
import g4.mini.ui.BaseUI;
import g4.mini.vo.Store;

public class StoreUpdateUI extends BaseUI {
	
	private StoreAccountMapper mapper;
	
	public StoreUpdateUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(StoreAccountMapper.class);
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
			
			Store sto = StoreLoginStatus.login;
			sto.setStoPass(pass);
			
			// 로그인되어있는 유저의 userNo와 변경할 비밀번호 넘김
			mapper.updateStore(sto);
		//	dao.passUpdate(user);
			System.out.println("비밀번호 변경이 완료되었습니다.");
			break;
		}
	}
}
