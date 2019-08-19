package store.ui;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import login.vo.User;
import member.dao.MemberDAO;
import ui.BaseUI;
import vo.Store;

public class priceUI extends BaseUI {
	private Scanner sc = new Scanner(System.in);
	private MemberDAO dao;

	public priceUI(MemberDAO dao) {
		this.dao = dao;
	}

	public void service() {
		List<Store> list = dao.selectMember();
		System.out.println("-------------------------------");
		System.out.println("가격순으로 보기");
		System.out.println("-------------------------------");
		System.out.println("가게번호    가게이름     메인메뉴    가격");
		System.out.println("-------------------------------");
		int index = 1;
		Map<Integer, Store> priceStore = new TreeMap<>(); 
		for (Store b : list) {
			priceStore.put(index, b);
			System.out.printf("%3d %10s %10s %10d원\n", 
					index++, 
					b.getStoName(), 
					b.getRstMenu(),
					b.getRstPrice());
		}
		System.out.println("-------------------------------");
		System.out.println("상세보기((상단의)가게번호를 선택해주세요)");
		System.out.println("이전으로 돌아가기 (0번을 선택해주세요)");
		System.out.println("-------------------------------");
		System.out.print("번호를 입력하세요 : ");
		int no = Integer.parseInt(sc.nextLine());

		MemberDAO dao = new MemberDAO();
		User user = new User();
		user = dao.selectOneMember(no);

		System.out.println("-----------------");
		System.out.println("상세보기");
		System.out.println("-----------------");
//		System.out.println(user.getSto_no());
		System.out.println(user.getSto_name());
		System.out.println(user.getRst_Menu());
		System.out.println(user.getRst_price());
		System.out.println("-----------------");
		System.out.println("1. 예약하기");
		System.out.println("2. 리뷰보기");
		System.out.println("3. 평점 및 리뷰쓰기");
		System.out.println("4. 메뉴보기");
		System.out.println("0. 이전으로 돌아가기");
		System.out.println("-----------------");
		System.out.print("번호를 입력하세요 : ");
		int no2 = Integer.parseInt(sc.nextLine());

//		no2 = 1  <<예약하기일때
		/*
		 * if(no2 == 1) { //예약하기 일때 로직 //이런식으로 insert하는거 예약하기 int cnt = dao.insertRes();
		 * 
		 * }
		 */
		if (no2 == 1) {
			// 여기서 보니까 인원수 입력하는게 또있네...
			// 그러면 상세보기에서 가져온 데이터를 예약하기 버튼클릭하면 한번더 뿌려줘야겠어.

			System.out.println("--------------------");
			System.out.println(user.getSto_name() + " " + user.getRst_price() + " " + user.getRst_Menu());
			System.out.println("--------------------");
			System.out.print("인원수 입력 : ");
			int reservationCnt = Integer.parseInt(sc.nextLine());
			user.setReservationCnt(reservationCnt);
			try {
				dao.insertReservation(user);
				System.out.println("정상처리");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		System.out.println("=========================");
//		System.out.println(user.getSto_no());
//		System.out.println(user.getSto_name());
//		System.out.println(user.getRst_Menu());
//		System.out.println(user.getRst_price());
//		System.out.println("=========================");		
	}
}