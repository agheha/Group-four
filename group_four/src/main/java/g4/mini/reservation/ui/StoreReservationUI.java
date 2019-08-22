package g4.mini.reservation.ui;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.reservation.dao.ReservationMapper;
import g4.mini.session.LoginStatus;
import g4.mini.session.StoreLoginStatus;
import g4.mini.session.StoreSearchStatus;
import g4.mini.ui.BaseUI;
import g4.mini.vo.Store;
import g4.mini.vo.User;

public class StoreReservationUI extends BaseUI {

	private ReservationMapper mapper;

	Store store =  StoreLoginStatus.login; //상세보기에 저장해둔 스토어변수 출력
	Store storeL = StoreLoginStatus.login; //로그인한 가게
	User userL = LoginStatus.login; //로그인한 유저

	public StoreReservationUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(ReservationMapper.class);
	}

	public void service() {	
		if (store == null) {
			System.out.println("값없음");
			return;
		}
		int i = getInt("나간 인원수를 입력해주세요 : ");
		if (store.getStoNowSeat() - i < 0 || i < 0) {
			System.out.println("잘못된 숫자를 입력하셨습니다.");
			return;
		}
		Store s = new Store();
		s.setStoNowSeat(store.getStoNowSeat() - i);
		s.setStoNo(store.getStoNo());
		mapper.updateStore(s);
			
		if(mapper.selectRsvNo(store.getStoNo()) > 0) {
			int rsvPerson = mapper.selectMinRsvNo(store.getStoNo());
			s.setStoNo(store.getStoNo());
			s.setStoNowSeat(store.getStoNowSeat() + rsvPerson);
			s.setAccReservation(store.getAccReservation() + rsvPerson);
			mapper.updateSto(s);
			
			mapper.deleteMember(store.getStoNo());
		}
		
		
		
		
	}

}
