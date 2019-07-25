package project;

import java.util.Scanner;


public class ManagerstoreUI {
	Scanner sc = new Scanner(System.in);
	ManagerstoreDAO storeDao = new ManagerstoreDAO();
	
	public void storeSelect() {
		
		Managerstore[] storeList = storeDao.selectStore();
		System.out.println("전체 " + storeList.length + "개");
		System.out.println("=========================================");
		if (storeList.length == 0) {
			System.out.println("스토어 정보가  없습니다.");
			return;
		}
		for (int i = storeList.length - 1 ; i >= 0; i--) {
			Managerstore store = storeList[i];
			System.out.printf(
					"스토어 번호 : %-3d\n카데고리 : %-4s\n스토어 이름 : %-10s\n스토어 메뉴 : %-10s\n스토어 가격 : %-6s\n스토어 주소 : %-20s\n", 
					store.getStoreNum(), store.getStoreType(), store.getStoreName(), store.getStoreMenu(), store.getStoreprice(),store.getStoreAddr());
		}
		System.out.println("=========================================");		
		}

	public void storeInsert() {
		Managerstore store = new Managerstore();
		System.out.print("카데고리를 입력하세요 : ");
		store.setStoreType(sc.nextLine());
		System.out.print("스토어 이름을 입력하세요 : ");
		store.setStoreName(sc.nextLine());
		System.out.print("스토어 메뉴를 입력하세요 : ");
		store.setStoreMenu(sc.nextLine());
		System.out.print("스토어 가격을 입력하세요 : ");
		store.setStoreprice(sc.nextLine());
		System.out.print("스토어 위치를 입력하세요 : ");
		store.setStoreAddr(sc.nextLine());
		
		
		storeDao.insertStore(store);

		System.out.println();
		System.out.println("스토어 정보가 등록되었습니다.");
	}
	
	public void storeUpdate() {
		System.out.print("수정할 스토어번호를 입력하세요 : ");
		int no = Integer.parseInt(sc.nextLine());
		Managerstore store = storeDao.selectOneStore(no);
		if (store == null) {
			System.out.println("해당 스토어정보가 존재하지 않습니다.");
			return;
		}
		System.out.print("카데고리를 입력하세요 : ");
		store.setStoreType(sc.nextLine());
		System.out.print("스토어 이름을 입력하세요 : ");
		store.setStoreName(sc.nextLine());
		System.out.print("스토어 메뉴를 입력하세요 : ");
		store.setStoreMenu(sc.nextLine());
		System.out.print("스토어 가격을 입력하세요 : ");
		store.setStoreprice(sc.nextLine());
		System.out.print("스토어 위치를 입력하세요 : ");
		store.setStoreAddr(sc.nextLine());
		
		storeDao.UpdateStore(store);
		
		System.out.println();
		System.out.println("스토어 정보가 수정되었습니다.");	
	}
	
	public void storeDelete() {
		System.out.print("삭제할 스토어 번호를 입력하세요 : ");
		int no = Integer.parseInt(sc.nextLine());
		int result = storeDao.deleteStore(no);
		if (result == 1) {
			System.out.println();
			System.out.println("스토어 정보가 삭제되었습니다.");
			return;
		}
		System.out.println("해당 스토어는 존재하지 않습니다.");
	
	}
}
