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
import sendSMS.SendMessage;

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
		
		int i = getInt("나간 인원수를 입력해주세요 : ");
		if (store.getStoNowSeat() - i < 0 || i < 0) {
			System.out.println("잘못된 숫자를 입력하셨습니다.");
			return;
		} 
			Store s = new Store();
			s.setStoNowSeat(mapper.nowSeat(storeL.getStoNo()) - i);
			s.setStoNo(storeL.getStoNo());
			mapper.updateStore(s);
		
		int rsvPerson = mapper.selectMinRsvNo(storeL.getStoNo());
		
		if(mapper.selectRsvNo2(storeL.getStoNo()) != 0 &&
				mapper.nowSeat(storeL.getStoNo()) + rsvPerson <= storeL.getStoSeat()) {
			s.setStoNo(storeL.getStoNo());
			s.setStoNowSeat(mapper.nowSeat(storeL.getStoNo()) + rsvPerson);
			s.setAccReservation(storeL.getAccReservation() + rsvPerson);
			mapper.updateSto(s);
			
			SendMessage.PHNo = "01022222222";
			SendMessage.msg = storeL.getStoName() + "에 예약이 완료 되었습니다.";
			new SendMessage().service();
			
			mapper.deleteMember(storeL.getStoNo());
		}
		
		
		
		
	}

}
