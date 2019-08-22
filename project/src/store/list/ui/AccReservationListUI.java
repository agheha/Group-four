package store.list.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import session.LoginStatus;
import session.StoreSearchStatus;
import store.info.ui.StoreInfoUI;
import store.list.dao.StoreListDAO;
import ui.BaseUI;
import vo.Store;

public class AccReservationListUI extends BaseUI{
	private StoreListDAO dao;
	public AccReservationListUI(StoreListDAO dao) {
		this.dao = dao;
	}

	public void service() { 
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("예약순으로 보기");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("번호\t가게이름\t\t종류\t메인메뉴\t\t가격\t  거리\t 누적예약수");
		printStroe(new HashMap<Integer, Store>(), dao.acRevList());
	}
	
}



















