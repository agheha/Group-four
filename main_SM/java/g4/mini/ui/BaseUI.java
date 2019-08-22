package g4.mini.ui;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import g4.mini.session.StoreSearchStatus;
import g4.mini.store.info.ui.StoreInfoUI;
import g4.mini.vo.Store;

public abstract class BaseUI {
	protected Scanner sc = new Scanner(System.in);
	
	public abstract void service();
	
	protected String getString(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}
	protected int getInt(String msg) {
		
		return Integer.parseInt(getString(msg));
		
	}
	
	public void printStroe(Map<Integer, Store> map, List<Store> list) {
		int index = 1;
		for (Store sto : list) {
			map.put(index, sto);			
			System.out.printf("%-4d\t%-9s\t%-5s\t%-7s\t%,5d원\t%5dm\t%2d석\t\t%2.1f\n",
					index++, 
					sto.getStoName(), 
					sto.getStoType(),
					sto.getRstMenu(),
					sto.getRstPrice(),
					sto.getBitDistance(),
					sto.getAccReservation(),
					sto.getStoGpa()
			);
		}
		System.out.println("-------------------------------------------------------------------------------------");
		while(true) {
			int choice = getInt("☞ 가게 번호를 입력해주세요(0. 이전 돌아가기) : ");
			StoreSearchStatus.store = map.get(choice);
			if (StoreSearchStatus.store != null) new StoreInfoUI().service(); 
			if (choice == 0) {
				list.clear();
				return;				
			}System.out.println("해당하는 가게번호를 찾을수 없습니다.");
		}
	}
	
	public void gpaStart(double stoGpa) {
		for (int i = 0 ; i < 5  ; i++ ) {
			String star = "☆";
			if (i < Math.round(stoGpa)) {
				star = "★";
			}
			System.out.print(star);
		}
		System.out.println();
	} 
}
