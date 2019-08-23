package g4.mini.admin.ui;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import g4.mini.admin.dao.AdministratorMapper;
import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.reservation.ui.CheckReservationUI;
import g4.mini.store.list.ui.StoreListUI;
import g4.mini.ui.BaseUI;
import g4.mini.user.account.ui.InfoUserUI;
import g4.mini.vo.Store;
import g4.mini.vo.User;

public class StoInfoDeleteUI extends BaseUI {

	private AdministratorMapper mapper;

	public StoInfoDeleteUI() {
		SqlSession session =  MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(AdministratorMapper.class);
	}
	
	public void service() {
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("회원번호\t가맹점이름\t타입\t대표메뉴\t가격"
				+ "\t주소\t운영시간\t번호\t좌석수\t누적예약수");
		List<Store> list = mapper.selectStoreList();
		for (Store u : list) {
			System.out.printf("%2d %10s %5s %10s %d %s %s %s %d %d", 
					u.getStoNo(), u.getStoName(), u.getStoType(), 
					u.getRstMenu(), u.getRstPrice(), u.getStoAddr(), 
					u.getStoHours(), u.getStoPhoneNumber(), u.getStoSeat(), 
					u.getAccReservation());
		}
		System.out.println("-------------------------------------------------------------------------------------");
		int stoNo = getInt("삭제할 회원번호를 선택하세요 : ");
		mapper.deleteStore(stoNo);
		
	}

	
}
