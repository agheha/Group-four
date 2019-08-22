package store.ui;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import manager.dao.ManagerDAO;
import manager.ui.MainUI;
import ui.BaseUI;
import vo.Store;

// 검색되게 하는거
// 랜덤
public class UpdateManagerUI extends BaseUI {
	private Scanner sc = new Scanner(System.in);
	private ManagerDAO dao;

	public UpdateManagerUI(ManagerDAO dao) {
		this.dao = dao;
	}

	public void service() {
		List<Store> list = dao.selectManager();
		while (true) {
			System.out.println("-----------------------------------------");
			System.out.println("가게번호    가게이름     메인메뉴    가격    거리");
			System.out.println("-----------------------------------------");
			int index = 1;
			Map<Integer, Store> priceStore = new TreeMap<>();
			for (Store b : list) {
				priceStore.put(index, b);
				System.out.printf("%3d %10s %10s %10d %10d\n", index++, b.getStoName(), b.getRstMenu(), b.getRstPrice(),
						b.getBitDistance());
			}
			System.out.println("---------------------------");
			System.out.print("수정할 번호를 선택하세요 : ");
			int no = Integer.parseInt(sc.nextLine());

			Set<Integer> keyset = priceStore.keySet();
			Iterator<Integer> keyiterator = keyset.iterator();
			Store user2 = null;
			while (keyiterator.hasNext()) {
				int k = (Integer) keyiterator.next();
				if (k == no) {
					user2 = priceStore.get(k);
					break;
				}
			}
			ManagerDAO dao = new ManagerDAO();
			if (user2 == null) {
				System.out.println("---------------------------");
				System.out.println("입력한 숫자를 다시 확인하세요.");
				System.out.println("---------------------------");
				break;
			}
//		Store user2 = new Store();
//		user2 = dao.selectOneManager(no);

			System.out.println("---------------------------");
			System.out.println("맛집수정");
			System.out.println("---------------------------");

			user2.setStoName(getString("가게이름 : "));
			user2.setRstMenu(getString("대표메뉴 : "));
			user2.setRstPrice(getInt("가격 : "));
			user2.setBitDistance(getInt("거리 : "));
			System.out.println("---------------------------");

//		System.out.println(user2.getStoNo());
			dao.updateManager(user2);

			System.out.println("수정이 완료되었습니다.");
			BaseUI ui = null;
			switch (menu()) {
			case 1:
				ui = new UpdateManagerUI(dao);
				break;
			case 0:
//				ui = new MainUI(dao);
				return;
//				break;
			default:
				System.out.println("잘못된 메뉴번호 입니다.");
				System.out.println("다시 선택해 주세요.");
			}
			if (ui != null)
				ui.service();
			}
		}
	
	private int menu() {
		System.out.println("---------------------------");
		System.out.println("1. 가게수정확인");
		System.out.println("0. 이전화면");
		System.out.println("---------------------------");
		System.out.println("메뉴를 선택해주세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
}
