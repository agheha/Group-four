package store.list.ui;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import member.dao.MemberDAO;
import ui.BaseUI;
import vo.Store;

public class distanceUI extends BaseUI{
	private Scanner sc = new Scanner(System.in);
	private MemberDAO dao;

	public distanceUI(MemberDAO dao) {
		this.dao = dao;
	}

	public void service() {
		List<Store> list = dao.selectDistanceMember();
		System.out.println("-------------------------------");
		System.out.println("거리순으로 보기");
		System.out.println("-------------------------------");
		System.out.println("거리    가게번호    가게이름    메인메뉴    가격");
		System.out.println("-------------------------------");
		int index = 1;
		Map<Integer, Store> priceStore = new TreeMap<>(); 
		for (Store b : list) {
			priceStore.put(index, b);
			System.out.printf("%5d %3d %10s %10s %10d원\n", 
					b.getBitDistance(),
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

		System.out.println("-----------------");
		System.out.println("상세보기");
		System.out.println("-----------------");
		
		// 메뉴테이블에서 나머지 메뉴받아와야함
		Store store = priceStore.get(no);
		System.out.print("    " + store.getBitDistance());
		System.out.print("    " + no);
		System.out.print("    " + store.getStoName());
		System.out.print("    " + store.getRstMenu());
		System.out.println("    " + store.getRstPrice());
		System.out.println("-----------------");
		System.out.println("1. 예약하기");
		System.out.println("2. 리뷰보기");
		System.out.println("3. 평점 및 리뷰쓰기");
		System.out.println("4. 메뉴보기");
		System.out.println("0. 이전으로 돌아가기");
		System.out.println("-----------------");
		System.out.print("번호를 입력하세요 : ");
		int no2 = Integer.parseInt(sc.nextLine());
	}
}
