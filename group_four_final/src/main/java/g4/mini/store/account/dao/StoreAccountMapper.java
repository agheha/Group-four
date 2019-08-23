package g4.mini.store.account.dao;

import g4.mini.vo.Store;
import g4.mini.vo.StoreMenu;

public interface StoreAccountMapper {
	void updateStore(Store sto);
	void deleteStore(int stoNo);
	void insertStoreMenu(StoreMenu menu);
	Store selectOneStore(int no);
	void updateStorePass(Store sto);
	void updateStoreInfo(Store sto);
	Store checkPass(String StoPass);
}
