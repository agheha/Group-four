package g4.mini.store.account.ui;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.session.StoreLoginStatus;
import g4.mini.store.account.dao.StoreAccountMapper;
import g4.mini.ui.BaseUI;
import g4.mini.vo.StoreMenu;

public class StoreMenuAddUI extends BaseUI{

	
	private StoreAccountMapper mapper;
		
	public StoreMenuAddUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(StoreAccountMapper.class);
	}
	public void service() {	
		StoreMenu menu = new StoreMenu();
		menu.setStoNo(StoreLoginStatus.login.getStoNo());
		menu.setStoMenu(getString("메뉴를 입력하세요 : "));
		menu.setPrice(getInt("가격을 입력하세요 : "));
		menu.setCalorie(getInt("칼로리를 입력하세요 : "));
		mapper.insertStoreMenu(menu);
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("게시글이 등록되었습니다.");
		System.out.println("-------------------------------------------------------------------------------------");
	}
}
