package g4.mini.reservation.ui;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.reservation.dao.ReservationMapper;
import g4.mini.session.LoginStatus;
import g4.mini.session.StoreLoginStatus;
import g4.mini.session.StoreSearchStatus;
import g4.mini.store.list.ui.StoreListUI;
import g4.mini.ui.BaseUI;
import g4.mini.user.account.ui.UserAccountUI;
import g4.mini.vo.Reservation;
import g4.mini.vo.Store;
import g4.mini.vo.User;

public class UserReservationUI extends BaseUI {

	Store store =  StoreSearchStatus.store; //상세보기에 저장해둔 스토어변수 출력
	Store storeL = StoreLoginStatus.login; //로그인한 가게
	User userL = LoginStatus.login; //로그인한 유저
	
	
	private ReservationMapper mapper;
	
	public UserReservationUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(ReservationMapper.class);
	}
	
	public void service()  {

		Reservation r = new Reservation();
		
		if (mapper.selectRsv(userL.getUserId()) != 0) {
			System.out.println("이미 예약된 정보가 있습니다.");
			return;
		}
		
		int i = getInt("예약하실 인원수를 입력해주세요 : ");
		int nowSeat = store.getStoNowSeat() + i;
		int seat = store.getStoSeat();
		if (nowSeat <= seat && mapper.selectRsvNo(store.getStoNo()) == null) {
			Store s = new Store();
			s.setStoNo(store.getStoNo());
			s.setStoNowSeat(store.getStoNowSeat() + i);
			s.setAccReservation(store.getAccReservation() + i);
			mapper.updateSto(s);
		} else {
			r.setUserId(userL.getUserId());
			r.setStoNo(store.getStoNo());
			r.setRsvPerson(i);
			r.setStoName(mapper.stoName(store.getStoNo()));
			mapper.userRsv(r);
		}
		
		System.out.println("예약 " + i + " 명이 완료 되었습니다.");
		new UserAccountUI().service();
	}

}
