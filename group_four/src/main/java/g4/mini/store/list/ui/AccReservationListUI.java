package g4.mini.store.list.ui;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.store.list.dao.StoreListMapper;
import g4.mini.ui.BaseUI;
import g4.mini.vo.Store;

public class AccReservationListUI extends BaseUI{
	private StoreListMapper mapper;

	public AccReservationListUI() {
		// 마이바티스가 실행시 만드는 구현 객체를 얻어오기
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(StoreListMapper.class);
	}
	public void service() { 
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("누적예약순으로 보기");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("번호\t가게이름\t\t종류\t메인메뉴\t\t가격\t  거리\t 누적예약수\t평점");
		printStroe(new HashMap<Integer, Store>(), mapper.acRevList());
	}
	
}



















