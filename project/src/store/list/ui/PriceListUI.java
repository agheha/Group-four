package store.list.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import session.LoginStatus;
import session.StoreLoginStatus;
import session.StoreSearchStatus;
import store.info.ui.StoreInfoUI;
import store.list.dao.StoreListDAO;
import ui.BaseUI;
import vo.Store;

public class PriceListUI extends BaseUI{
	private StoreListDAO dao;
//	private String result;
	public PriceListUI(StoreListDAO dao) {
		this.dao = dao;
//		this.result = result;
	}
	public void service() {
		int startPrice = 0;
		int endPrice = 0;
		boolean flag = true;
		// 최소 금액이 최고금액보다 크면 다시 입력
		while (flag) {
			startPrice = getInt("☞ 최소금액을 입력해주세요 : ");
			endPrice = getInt("☞ 최고금액을 입력해주세요  : ");
			if (startPrice < endPrice) {
				flag = false;
			}else System.out.println("최소금액이 최고금액보다 큰값입니다.");
		}
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("가격별 보기");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("번호\t가게이름\t\t종류\t메인메뉴\t\t가격\t  거리\t 누적예약수");
		printStroe(new HashMap<Integer, Store>(), dao.priceList(startPrice, endPrice));
	}
}



















