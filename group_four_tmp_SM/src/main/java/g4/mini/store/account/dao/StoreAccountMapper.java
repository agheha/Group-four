package g4.mini.store.account.dao;

import g4.mini.vo.Store;
import g4.mini.vo.StoreMenu;

public interface StoreAccountMapper {
	void updateStore(Store sto);
	void deleteStore(int stoNo);
	void nowSeatStore(Store sto);
	void insertStoreMenu(StoreMenu menu);
}
