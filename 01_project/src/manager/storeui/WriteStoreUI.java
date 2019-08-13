package manager.storeui;

import manager.dao.ManagerStoreDAO;
import manager.ui.BaseUI;
import manager.vo.ManagerStore;

public class WriteStoreUI extends BaseUI{
	private ManagerStoreDAO storeDao;

	public WriteStoreUI(ManagerStoreDAO storeDao) {
		super();
		this.storeDao = storeDao;
	}
	
	public void service() {
		ManagerStore store = new ManagerStore();
		store.setStoreType(getString("카데고리를 입력하세요 : "));
		store.setStoreName(getString("스토어 이름을 입력하세요 : "));
		store.setStoreMenu(getString("스토어 메뉴를 입력하세요 : "));
		store.setStoreprice(getString("스토어 가격을 입력하세요 : "));
		store.setStoreAddr(getString("스토어 위치를 입력하세요 : "));
	
		storeDao.insertStore(store);

		System.out.println();
		System.out.println("스토어 정보가 등록되었습니다.");
	}
	
	
}
