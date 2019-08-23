package g4.mini.store.account.ui;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.session.StoreLoginStatus;
import g4.mini.store.account.dao.StoreAccountMapper;
import g4.mini.ui.BaseUI;
import g4.mini.vo.Store;

public class StoreInfoUpdateUI extends BaseUI {
	
	// 현재 로그인 되어있는 가게 정보
	private Store sto = StoreLoginStatus.login;
	
	private StoreAccountMapper mapper;
	
	public StoreInfoUpdateUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(StoreAccountMapper.class);
	}
	
	public void stoInfoServie() {
		
	}
	
	public void service() {
		while(true) {
			switch(menu()) {
			case 1: 
				sto.setStoName(getString("변경할 이름을 입력하세요 : "));
				break;
			case 2:
				sto.setRstMenu(getString("변경할 대표메뉴를 입력하세요 : "));
				break;
			case 3:
				sto.setRstPrice(getInt("변경할 값을 입력하세요 : "));
				break;
			case 4:
				sto.setBitDistance(getInt("변경할 값을 입력하세요 : "));
				break;
			case 5:
				sto.setStoAddr(getString("변경할 주소를 입력하세요 : "));
				break;
			case 6:
				sto.setStoHours(
						getString("변경할 값을 입력하세요\n ex) 00:00~00:00 : ")
						);
				break;
			case 7:
				sto.setStoPhoneNumber(getString("변경할 전화번호를 입력하세요 : "));
				break;
			case 8:
				sto.setStoSeat(getInt("변경할 좌석수를 입력하세요 : "));
				break;
			case 0: 
				// 이전화면 가면서 가게정보 업데이트 시켜준다.
				mapper.updateStoreInfo(sto);
				
				// 로그인되어있는 객체도 업데이트 정보로 바꿔준다.
				StoreLoginStatus.login = mapper.selectOneStore(sto.getStoNo());
				
				return;
			default:
				System.out.println("잘못된 메뉴번호 입니다.");
				System.out.println("다시 선택해주세요.");
			}
		}
	}
	
	
	public int menu() {
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("가게 정보 수정");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("1. 가게이름 : " + sto.getStoName());
		System.out.println("2. 대표메뉴 : " + sto.getRstMenu());
		System.out.println("3. 가격 : " + sto.getRstPrice());
		System.out.println("4. 비트캠프와 거리 : " + sto.getBitDistance());
		System.out.println("5. 주소 : " + sto.getStoAddr());	
		System.out.println("6. 영업시간 : " + sto.getStoHours());		
		System.out.println("7. 전화번호 : " + sto.getStoPhoneNumber());		
		System.out.println("8. 좌석수 : " + sto.getStoSeat());		
		System.out.println("0. 이전 화면 ");
		System.out.println("-------------------------------------------------------------------------------------");
		return getInt("☞ 수정할 항목의 번호를 입력해주세요 : ");
	}
	
	
	
}
