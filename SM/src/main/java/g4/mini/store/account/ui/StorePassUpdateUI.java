package g4.mini.store.account.ui;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.session.StoreLoginStatus;
import g4.mini.store.account.dao.StoreAccountMapper;
import g4.mini.ui.BaseUI;
import g4.mini.vo.Store;

public class StorePassUpdateUI extends BaseUI {
	
	private StoreAccountMapper mapper;
	
	public StorePassUpdateUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(StoreAccountMapper.class);
	} 

	public void service() {
		while(true) {
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("비밀번호 변경");
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("변경할 비밀번호를 입력하세요. ");
			String pass = getString("비밀번호 : ");
			String pass2 = getString("비밀번호확인 : ");
			if (!pass.equals(pass2)) {
				System.out.println("비밀번호가 일치하지 않습니다. ");
				System.out.println("다시 입력해주세요. ");
				continue;
			}
			
			// 현재 로그인되어있는 store 가져온다
			Store sto = StoreLoginStatus.login;
			
			// 비밀번호 바꿔 넣어주고
			sto.setStoPass(pass);
			
			// 데이터베이스에 객체 넘긴다.
			mapper.updateStorePass(sto);
			System.out.println("비밀번호 변경이 완료되었습니다.");
			break;
		}
	}
	
}
