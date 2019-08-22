package g4.mini.smenu.ui;

import org.apache.ibatis.session.SqlSession;
import g4.mini.smenu.common.db.MyAppSqlConfig;
import g4.mini.smenu.dao.StoreMenuMapper;
import g4.mini.smenu.domain.SMenu;
import g4.mini.smenu.domain.Store;
import g4.mini.smenu.main.ui.indexUI;

public class InsertInfoUI extends BaseUI {
	
//	Store s = StoreLoginStatus.Login;
	
	// 인터페이스이기 떄문에 직접 객체 생성 불가능
	private StoreMenuMapper mapper;
		
	public InsertInfoUI() {
		// 마이바티스가 실행시 만드는 구현 객체를 얻어오기
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		// SqlSession은 뭔가?
		mapper = session.getMapper(StoreMenuMapper.class); // session에 메소드를 얻어올수있다. getMapper 등록된 클래스로 얻어온다.
		// 인터페이스 객체의 클래스를 만들어줘라고 선언한것임...
	}
	
	public void service() {
		SMenu menu = new SMenu();
		System.out.println("---------------------------");
		menu.setMenu(getString("메뉴를 입력하세요 : "));
		menu.setPrice(getInt("가격을 입력하세요 : "));
		menu.setCalorie(getInt("칼로리를 입력하세요 : "));
		System.out.println("---------------------------");
//		menu.setStoNo(s.getStoNo());
		
		mapper.insertSMenu(menu);

		System.out.println();
		System.out.println("게시글이 등록되었습니다.");
		
		System.out.println("----------------------");
	}
	
}
