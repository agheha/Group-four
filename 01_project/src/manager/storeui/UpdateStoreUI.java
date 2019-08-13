package manager.storeui;

import manager.dao.ManagerStoreDAO;
import manager.ui.BaseUI;
import manager.vo.ManagerStore;

public class UpdateStoreUI extends BaseUI{
	
	private ManagerStoreDAO storeDao;

	public UpdateStoreUI(ManagerStoreDAO storeDao) {
		super();
		this.storeDao = storeDao;
	}
	public void service() {
		int no = getInt("수정할 스토어번호를 입력하세요 : ");
		ManagerStore store = storeDao.selectOneStore(no);
		if (store == null) {
			System.out.println("해당 스토어정보가 존재하지 않습니다.");
			return;
		}
		store.setStoreType(getString("카데고리를 입력하세요 : "));
		store.setStoreName(getString("스토어 이름을 입력하세요 : "));
		store.setStoreMenu(getString("스토어 메뉴를 입력하세요 : "));
		store.setStoreprice(getString("스토어 가격을 입력하세요 : "));
		store.setStoreAddr(getString("스토어 위치를 입력하세요 : "));
		
		storeDao.UpdateStore(store);
		
		System.out.println();
		System.out.println("스토어 정보가 수정되었습니다.");	
	}
}	
