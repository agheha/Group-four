package g4.mini.store.account.ui;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.session.StoreLoginStatus;
import g4.mini.store.account.dao.StoreAccountMapper;
import g4.mini.ui.BaseUI;
import g4.mini.vo.Store;

public class StoreNowSeatUI extends BaseUI{
	private StoreAccountMapper mapper;
	
	public StoreNowSeatUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(StoreAccountMapper.class);
	}
	
	public void service() {
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("현재 좌석수 수정");
		System.out.println("-------------------------------------------------------------------------------------");
		int seat = StoreLoginStatus.login.getStoSeat();
		boolean flag = true;
		int nowSeatNum = 0;
		while (flag) {
			System.out.println("현재 좌석수 " + StoreLoginStatus.login.getStoNowSeat());				
			nowSeatNum = getInt("☞ 현재 좌석수를 입력해주세요 : ");
			if (nowSeatNum > seat && nowSeatNum < 0) flag = false;
			else System.out.println("인원수를 확인해주세요. ");
		}
		Store sto = StoreLoginStatus.login;
		sto.setStoNo(StoreLoginStatus.login.getStoNo());
		sto.setStoNowSeat(nowSeatNum);
		mapper.nowSeatStore(sto);
		
	}
}
