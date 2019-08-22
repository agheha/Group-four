package g4.mini.reservation.ui;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.reservation.dao.RsvMapper;
import g4.mini.session.LoginStatus;
import g4.mini.session.StoreLoginStatus;
import g4.mini.session.StoreSearchStatus;
import g4.mini.ui.BaseUI;
import g4.mini.vo.Reservation;
import g4.mini.vo.Store;
import g4.mini.vo.User;

public class CheckRsvUI extends BaseUI {

	private RsvMapper mapper;

	Store store =  StoreSearchStatus.store; //상세보기에 저장해둔 스토어변수 출력
	Store storeL = StoreLoginStatus.Login; //로그인한 가게
	User userL = LoginStatus.login; //로그인한 유저
	
	public CheckRsvUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(RsvMapper.class);
	}

	public void service() {
		
		if (mapper.selectRsv(userL.getUserId()) == 0) {
			System.out.println("예약된 정보가 없습니다.");
		} else {
			int stoNo = mapper.selectStoNo(userL.getUserId());
			
			System.out.println("가게이름\t예약인원\t대기번호");
			System.out.println("-------------------------------");
			Reservation r = mapper.getRsv(userL.getUserId());
			System.out.println(r.getStoName() + "  " + r.getRsvPerson() + "  " + mapper.rsvCount(stoNo));
			
			String str = getString("예약을 취소 하시겠습니까?(Y/N)");
			if(str.toUpperCase().equals("Y")) {
				mapper.cancelRsv(userL.getUserId());
				System.out.println("취소가 완료되었습니다.");
			}
		}		
		
		
		
	}
}
