package g4.mini.admin.ui;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import g4.mini.admin.dao.AdministratorMapper;
import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.session.StoreLoginStatus;
import g4.mini.ui.BaseUI;
import g4.mini.vo.Store;
import g4.mini.vo.User;

public class StoInfoUpdateUI extends BaseUI {

	private AdministratorMapper mapper;

	public StoInfoUpdateUI() {
		SqlSession session =  MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(AdministratorMapper.class);
		
	}
	

	public void service() {
		
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("회원번호\t가맹점이름\t타입\t대표메뉴\t가격"
				+ "\t주소\t운영시간\t번호\t좌석수\t누적예약수");
		List<Store> list = mapper.selectStoreList();
		for (Store u : list) {
			System.out.printf("%2d %10s %5s %10s %d %s %s %s %d %d%n", 
					u.getStoNo(), u.getStoName(), u.getStoType(), 
					u.getRstMenu(), u.getRstPrice(), u.getStoAddr(), 
					u.getStoHours(), u.getStoPhoneNumber(), u.getStoSeat(), 
					u.getAccReservation());
		}
		System.out.println("-------------------------------------------------------------------------------------");
		int choiceNo = getInt("정보를 수정할 회원번호를 선택하세요 : ");
		
		Store sto = mapper.selectOneStore(choiceNo);
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("가게 정보 수정");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("1. 가맹점이름 : " + sto.getStoName());
		System.out.println("2. 대표메뉴 : " + sto.getRstMenu());
		System.out.println("3. 가격 : " + sto.getRstPrice());
		System.out.println("4. 타입 : " + sto.getStoType());
		System.out.println("5. 주소 : " + sto.getStoAddr());	
		System.out.println("6. 영업시간 : " + sto.getStoHours());		
		System.out.println("7. 전화번호 : " + sto.getStoPhoneNumber());		
		System.out.println("8. 총좌석수 : " + sto.getStoSeat());		
		System.out.println("9. 누적예약자수 : " + sto.getAccReservation());	
		System.out.println("-------------------------------------------------------------------------------------");
		
		Store s = new Store();
		String str = getString("변경할 이름 : ");
		if (str.isEmpty()) {
			s.setStoName(sto.getStoName());			
		} else {
			s.setStoName(str);						
		}
		str = getString("변경할 대표메뉴 : ");
		if (str.isEmpty()) {
			s.setRstMenu(sto.getRstMenu());			
		} else {
			s.setRstMenu(str);						
		}
		str = getString("변경할 대표메뉴 가격 : ");
		if (str.isEmpty()) {
			s.setRstPrice(sto.getRstPrice());			
		} else {
			s.setRstPrice(Integer.parseInt(str));						
		}
		str = getString("변경할 타입 : ");
		if (str.isEmpty()) {
			s.setStoType(sto.getStoType());			
		} else {
			s.setStoType(str);						
		}
		str = getString("변경할 주소 : ");
		if (str.isEmpty()) {
			s.setStoAddr(sto.getStoAddr());			
		} else {
			s.setStoAddr(str);						
		}
		str = getString("변경할 영업시간 : ");
		if (str.isEmpty()) {
			s.setStoHours(sto.getStoHours());			
		} else {
			s.setStoHours(str);						
		}
		str = getString("변경할 전화번호 : ");
		if (str.isEmpty()) {
			s.setStoPhoneNumber(sto.getStoPhoneNumber());			
		} else {
			s.setStoPhoneNumber(str);						
		}
		str = getString("변경할 총좌석수 : ");
		if (str.isEmpty()) {
			s.setStoSeat(sto.getStoSeat());			
		} else {
			s.setStoSeat(Integer.parseInt(str));						
		}
		str = getString("변경할 누적예약자수 : ");
		if (str.isEmpty()) {
			s.setAccReservation(sto.getAccReservation());			
		} else {
			s.setAccReservation(Integer.parseInt(str));						
		}
		System.out.println(1);
		s.setStoNo(choiceNo);
		System.out.println(1);
		mapper.storeUpdate(s);
		System.out.println(1);
		
		System.out.println("수정이 완료되었습니다");
		
	}
	
	
}
