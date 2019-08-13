package manager.storeui;

import manager.dao.ManagerStoreDAO;
import manager.ui.BaseUI;
import manager.vo.ManagerStore;

public class ListStoreUI extends BaseUI{
	private ManagerStoreDAO storeDao;

	public ListStoreUI(ManagerStoreDAO storeDao) {
		super();
		this.storeDao = storeDao;
	}
	public void service() {
		
		ManagerStore[] storeList = storeDao.selectStore();
		System.out.println("전체 " + storeList.length + "개");
		System.out.println("=========================================");
		if (storeList.length == 0) {
			System.out.println("스토어 정보가  없습니다.");
			return;
		}
		for (int i = storeList.length - 1 ; i >= 0; i--) {
			ManagerStore store = storeList[i];
			System.out.printf(
					"스토어 번호 : %-3d\n카데고리 : %-4s\n스토어 이름 : %-10s\n스토어 메뉴 : %-10s\n스토어 가격 : %-6s\n스토어 주소 : %-20s\n", 
					store.getStoreNum(), store.getStoreType(), store.getStoreName(), store.getStoreMenu(), store.getStoreprice(),store.getStoreAddr());
		}
	}
}
