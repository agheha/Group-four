package manager.storeui;

import manager.dao.ManagerStoreDAO;
import manager.ui.BaseUI;

public class DeleteStoreUI extends BaseUI{
	private ManagerStoreDAO storeDao;

	public DeleteStoreUI(ManagerStoreDAO storeDao) {
		super();
		this.storeDao = storeDao;
	}
	
	public void service() {
		int no = getInt("삭제할 스토어 번호를 입력하세요 : ");
		int result = storeDao.deleteStore(no);
		if (result == 1) {
			System.out.println();
			System.out.println("스토어 정보가 삭제되었습니다.");
			return;
		}
		System.out.println("해당 스토어는 존재하지 않습니다.");
	
	}
}
