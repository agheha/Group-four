package store.ui;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import manager.dao.ManagerDAO;
import ui.BaseUI;
import vo.Store;

public class SelectManagerUI extends BaseUI {
	private Scanner sc = new Scanner(System.in);
	private ManagerDAO dao;

	public SelectManagerUI(ManagerDAO dao) {
		this.dao = dao;
	}

	public void service() {
		List<Store> list = dao.selectManager();
		System.out.println("---------------------------");
		System.out.println("가게번호    가게이름     메인메뉴    가격");
		System.out.println("---------------------------");
		
		int index = 1;
		Map<Integer, Store> priceStore = new TreeMap<>();
		for (Store b : list) {
			priceStore.put(index, b);
			System.out.printf("%3d %10s %10s %10d %20d\n", 
					index++, 
					b.getStoName(), 
					b.getRstMenu(), 
					b.getRstPrice(),
					b.getBitDistance());
		}
		System.out.println("---------------------------");
	}
}
