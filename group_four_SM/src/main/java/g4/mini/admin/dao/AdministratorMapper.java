package g4.mini.admin.dao;

import java.util.List;

import g4.mini.vo.Store;
import g4.mini.vo.User;

public interface AdministratorMapper {
	
	List<User> selectMemberList();
	User memberSelect(int userNo);
	void memberUpdate(User u);
	void deleteUser(int userNo);
	List<Store> selectStoreList();
	Store selectOneStore(int stoNo);
	void storeUpdate(Store s);
	void deleteStore(int stoNo);
	
}
