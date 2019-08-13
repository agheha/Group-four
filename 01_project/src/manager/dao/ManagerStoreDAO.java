package manager.dao;

import java.util.Arrays;

import manager.vo.ManagerStore;

public class ManagerStoreDAO {
	public ManagerStore[] storeArr = new ManagerStore[3];
	int storePos = 0;
	int storeNo = 0;
	
	public ManagerStore[] selectStore() {
		return Arrays.copyOf(storeArr, storePos);
	}
	public ManagerStore selectOneStore(int no) {
		for (int i = 0 ; i < storePos ; i++) {
			ManagerStore store = storeArr[i];
			if (store.getStoreNum() != no) continue;
			return store;
		}
		return null;
	}
	
	public void insertStore(ManagerStore store) {
		if (storeArr.length == storePos) {
			storeArr = Arrays.copyOf(storeArr, storePos += 10);
		}
		
		store.setStoreNum(++storeNo);
		storeArr[storePos++] = store;
	}
	
	public void UpdateStore(ManagerStore store) {
		for (int i = 0 ; i < storePos ; i++) {
			ManagerStore m = storeArr[i];
			if (m.getStoreNum() != store.getStoreNum()) continue;
			m.setStoreType(store.getStoreType());
			m.setStoreType(store.getStoreName());
			m.setStoreMenu(store.getStoreMenu());
			m.setStoreprice(store.getStoreprice());
			m.setStoreAddr(store.getStoreAddr());
		}
	}
	
	public int deleteStore(int no) {
		int cnt = storeArr.length - (no + 1);
		for (int i = 0 ; i < storePos ; i++) {
			ManagerStore store = storeArr[i];
			if (store.getStoreNum() != no) continue;
			System.arraycopy(storeArr, i + 1, storeArr, i, cnt);
			storeArr[--storePos] = null;
			return 1;
			
		}
		return 0;
	}
	
}

