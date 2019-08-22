package g4.mini.store.dao;

import g4.mini.vo.Store;

public interface StoreMapper {
	// 로그인
	Store storeLogin(Store sto);
	
	// 회원가입
	void storeJoin(Store sto);
	
	// 아이디 중복검사
	int idMatching(String id);
	
	// 회원번호 받아 user객체 하나 반환
	Store selectOneUser(int userNo);
	
	// 비밀번호 변경
	void passUpdate(Store sto);
	
	// 회원탈퇴
	void deleteUser(int userNo);

}
