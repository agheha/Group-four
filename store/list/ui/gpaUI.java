package store.list.ui;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import login.vo.User;
import member.dao.MemberDAO;
import ui.BaseUI;
import vo.Store;

public class gpaUI extends BaseUI {
	private Scanner sc = new Scanner(System.in);
	private MemberDAO dao;

	public gpaUI(MemberDAO dao) {
		this.dao = dao;
	}

	public void service() {
		List<Store> list = dao.selectGpaMember();
		System.out.println("-------------------------------");
		System.out.println("평점순으로 보기");
		System.out.println("-------------------------------");
		System.out.println("평점    가게번호    가게이름    메인메뉴    가격");
		System.out.println("-------------------------------");
		int index = 1;
		Map<Integer, Store> priceStore = new TreeMap<>(); 
		for (Store b : list) {
			priceStore.put(index, b);
			System.out.printf("%5d %3d %10s %10s %10d원\n", 
					b.getStoGpa(),
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

		System.out.println("-------------------------------");
		System.out.println("상세보기");
		System.out.println("-------------------------------");
		System.out.println("평점    가게번호    가게이름    메인메뉴    가격");
		System.out.println("-------------------------------");
		
		// 메뉴테이블에서 나머지 메뉴받아와야함
		Store store = priceStore.get(no);
		System.out.print("    " + store.getStoGpa());
		System.out.print("    " + no);
		System.out.print("    " + store.getStoName());
		System.out.print("    " + store.getRstMenu());
		System.out.println("    " + store.getRstPrice());

	}
}