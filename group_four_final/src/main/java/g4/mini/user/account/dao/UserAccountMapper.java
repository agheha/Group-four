package g4.mini.user.account.dao;

import g4.mini.vo.User;

public interface UserAccountMapper {
	// 비밀번호 확인 
	User checkPass(String msg);
	
	// 비밀번호 변경
	void passUpdate(User user);

	// 회원탈퇴
	void deleteUser(int userNo);
	
	// 회원번호 받아 user객체 하나 반환
	User selectOneUser(int userNo);
	
	// 아이디 찾기
	User findUserId(User user);
		
	// 비밀번호 찾기
	User findUserPass(User user);
}
