package g4.mini.store.ui;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.session.StoreLoginStatus;
import g4.mini.store.account.ui.StoreAccountUI;
import g4.mini.store.dao.StoreMapper;
import g4.mini.ui.BaseUI;
import g4.mini.vo.Store;

public class StoreLoginUI extends BaseUI {
	
	private StoreMapper mapper;
	
	public StoreLoginUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(StoreMapper.class);
	}
	
	public void service() {
		
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("로그인");
		System.out.println();
		String loginId = getString("아이디 : ");
		String loginPass = getString("패스워드 : ");
		System.out.println();
		
		// 입력받은 아이디와 비밀번호를 user객체의 형태로 바꾸어 dao에 넣어준다.
		Store sto = new Store();
		sto.setStoId(loginId);
		sto.setStoPass(loginPass);

		// dao를 통해 일치하는 값을 돌려받았을때의 객체를 login이라 하자.
		Store login = mapper.storeLogin(sto);
		
		if(login != null) {
			System.out.println("로그인이 되었습니다.");
			
			// 로그인관리하는 클래스에 로그인된 객체 담아줌
			StoreLoginStatus.login = login; 
					
			new StoreAccountUI().service();
		}
		
		// 만약 dao를 통해 돌려받은 값이 없을 경우 (로그인정보가 없을 경우)
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("입력된 정보를 확인하여주세요.");
		System.out.println("-------------------------------------------------------------------------------------");
	}
}
