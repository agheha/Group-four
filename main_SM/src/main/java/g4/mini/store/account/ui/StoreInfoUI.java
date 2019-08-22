package g4.mini.store.account.ui;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.reservation.dao.ReservationMapper;
import g4.mini.reservation.ui.StoreReservationUI;
import g4.mini.select.dao.SelectMapper;
import g4.mini.session.StoreLoginStatus;
import g4.mini.ui.BaseUI;

public class StoreInfoUI extends BaseUI{
	
Scanner sc = new Scanner(System.in);
	
private SelectMapper mapper;

	public StoreInfoUI() {
	SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
	mapper = session.getMapper(SelectMapper.class);
	}

	public void service() {
		while(true) {
			switch(menu()) {
			case 1 : new StoreUpdateUI().service(); break;
			case 2 : new StoreDeleteUI().service(); break;
			case 3 : new StoreReservationUI().service(); break;			
			case 4 : return;
			case 0 : 
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default : 
				System.out.println("번호를 다시 확인해주세요.");
			}
		}
	}
	public int menu() {
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("가게 정보");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("가게이름 : " + StoreLoginStatus.login.getStoName());
		System.out.println("대표메뉴 : " + StoreLoginStatus.login.getRstMenu());
		System.out.println("가격 : " + StoreLoginStatus.login.getRstPrice());
		System.out.println("종류 : " + StoreLoginStatus.login.getStoType());
		System.out.println("비트캠프와 거리 : " + StoreLoginStatus.login.getBitDistance());
		System.out.println("주소 : " + StoreLoginStatus.login.getStoAddr());	
		System.out.println("영업시간 : " + StoreLoginStatus.login.getStoHours());	
		System.out.println("실시간 좌석수 : " + mapper.nowSeat(StoreLoginStatus.login.getStoNo())
							+ " / " + StoreLoginStatus.login.getStoSeat());		
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("1. 정보수정");
		System.out.println("2. 탈퇴 ");
		System.out.println("3. 현재좌석수 수정");		
		System.out.println("4. 이전 돌아가기");
		System.out.println("0. 종료");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.print(" ☞ 메뉴를 선택해주세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
}
