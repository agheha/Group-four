package g4.mini.store.info.ui;

import java.util.Scanner;

import g4.mini.reservation.ui.ReservationUI;
import g4.mini.session.StoreSearchStatus;
import g4.mini.store.info.dao.StoreInfoDAO;
import g4.mini.store.list.ui.StoreListUI;

public class StoreInfoUI {
	Scanner sc = new Scanner(System.in);
	StoreInfoDAO dao = new StoreInfoDAO();
	public void service() {
		while(true) {
			switch(menu()) {
			case 1 : new ListReviewUI().service(); break; 
			case 2 : new WriteReviewUI().service(); break;
			case 3 : new ReservationUI().service(); break;
			case 4 : new StoreMenuUI().service(); break; 
			case 5 : 
				StoreSearchStatus.store = null; 
				new StoreListUI().service();
			case 0 : 
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default : 
				System.out.println("번호를 다시 확인해주세요.");
			}
			
		}
	}
	public int menu() {
		// 서비스 메뉴 실행시 보여지는 메뉴
		System.out.println("-------------------------------------------------------------------------------------");
		// 사용자가 입력한 번호에 해당하는 가게 정보를 담아준것을 사용 
		System.out.println("가게이름 : " + StoreSearchStatus.store.getStoName());
		System.out.println("대표메뉴 : " + StoreSearchStatus.store.getRstMenu());
		System.out.println("가격 : " + StoreSearchStatus.store.getRstPrice());
		System.out.println("종류 : " + StoreSearchStatus.store.getStoType());
		System.out.println("거리 : " + StoreSearchStatus.store.getBitDistance());
		System.out.println("주소 : " + StoreSearchStatus.store.getStoAddr());	
		System.out.println("영업시간 : " + StoreSearchStatus.store.getStoHours());		
		System.out.println("좌석수 : " + StoreSearchStatus.store.getStoSeat());		
		System.out.println("실시간 좌석수 : " + StoreSearchStatus.store.getStoNowSeat());		
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("1. 리뷰 및 평점보기");
		System.out.println("2. 리뷰 쓰기");
		System.out.println("3. 예약 하기");
		System.out.println("4. 메뉴 상세보기");		
		System.out.println("5. 이전으로 돌아가기");
		System.out.println("0. 종료");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.print("☞ 메뉴를 선택해 주세요 : ");
		return Integer.parseInt(sc.nextLine());
		
	}
	
}
