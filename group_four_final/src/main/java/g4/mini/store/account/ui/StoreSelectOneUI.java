package g4.mini.store.account.ui;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.session.StoreLoginStatus;
import g4.mini.store.account.dao.StoreAccountMapper;
import g4.mini.ui.BaseUI;
import g4.mini.vo.Store;

public class StoreSelectOneUI extends BaseUI {
	
	// 현재 로그인 되어있는 가게 정보
	private Store sto = StoreLoginStatus.login;
	
	private StoreAccountMapper mapper;
	
	public StoreSelectOneUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(StoreAccountMapper.class);
	}
	
	public void service() {
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("가게 정보 조회");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("1. 가게이름 : " + sto.getStoName());
		System.out.println("2. 대표메뉴 : " + sto.getRstMenu());
		System.out.println("3. 가격 : " + sto.getRstPrice());
		System.out.println("4. 비트캠프와 거리 : " + sto.getBitDistance());
		System.out.println("5. 주소 : " + sto.getStoAddr());	
		System.out.println("6. 영업시간 : " + sto.getStoHours());		
		System.out.println("7. 전화번호 : " + sto.getStoPhoneNumber());		
		System.out.println("8. 좌석수 : " + sto.getStoSeat());		
		System.out.println("-------------------------------------------------------------------------------------");
	}
}
