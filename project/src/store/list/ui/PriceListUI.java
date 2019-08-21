package store.list.ui;

import java.util.Map;

import review.ui.ReviewUI;
import session.LoginStatus;
import store.list.dao.StoreListDAO;
import ui.BaseUI;
import vo.Store;

public class PriceListUI extends BaseUI{
	private StoreListDAO dao;
	private String result;
	public PriceListUI(StoreListDAO dao, String result) {
		this.dao = dao;
		this.result = result;
	}
	public void service() {
		Map<Integer, Store> priceList = dao.selectMap(result); 
		System.out.println("-------------------------------");
		System.out.println("가격순으로 보기");
		System.out.println("-------------------------------");
		System.out.println("번호\t가게이름\t메인메뉴\t가격\t평점");
		System.out.println("-------------------------------");
		
		for (int i = 1 ; i <= priceList.size(); i++) {
			Store sto = priceList.get(i);
			System.out.printf("%-3d %-20s %-10s %,-10d원\t",
					i,
					sto.getStoName(), 
					sto.getRstMenu(),
					sto.getRstPrice());
			for (int j = 0 ; j < 5  ; j++ ) {
				String star = "☆";
				if (j < Math.round(sto.getStoGpa())) {
					star = "★";
				}
				System.out.print(star);
			}
			System.out.println();
		}
		// 가게번호 입력시 상세보기 할 가게의 정보가 저장됨
		System.out.println("------------------------------------");
		LoginStatus.store = priceList.get(getInt("가게 번호를 입력해주세요 : "));
		while (true) {
			switch (menu()) {
			case 1 : new ReviewUI().service(); break;
			case 2 : LoginStatus.store = null; return;
			case 0 : 
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default : 
				System.out.println("해당하는 번호를 찾을수 없습니다.");
				System.out.println("번호를 다시입력해주세요.");
			}
		}
	}
}



















