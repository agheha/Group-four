package store.ui;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import manager.dao.ManagerDAO;
import ui.BaseUI;
import vo.Store;

public class DeleteManagerUI extends BaseUI {
	private ManagerDAO dao;

	public DeleteManagerUI(ManagerDAO dao) {
		this.dao = dao;
	}

	public void service() {
		List<Store> list = dao.selectManager();
		System.out.println("-----------------------------------------");
		System.out.println("가게번호    가게이름     메인메뉴    가격    거리");
		System.out.println("-----------------------------------------");
		while(true) {
			int index = 1;
			Map<Integer, Store> priceStore = new TreeMap<>();
			for (Store b : list) {
				priceStore.put(index, b);
				System.out.printf("%3d %10s %10s %10d %10d\n",
						index++,
						b.getStoName(),
						b.getRstMenu(),
						b.getRstPrice(),
						b.getBitDistance()
				);
			}
			System.out.println("---------------------------");
			int no = getInt("삭제할 번호를 선택하세요 : ");	
			System.out.println("---------------------------");
			
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
			
			int result = dao.deleteManager(user2.getStoNo());
			if (result == 1) {
				System.out.println("게시글이 삭제되었습니다.");
				System.out.println("---------------------------");
				
				return;
			}
			System.out.println("해당 게시물이 존재하지 않습니다.");
		}
	}
}
