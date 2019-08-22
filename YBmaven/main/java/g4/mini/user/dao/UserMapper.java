package g4.mini.user.dao;

import g4.mini.user.domain.User;

public interface UserMapper {  
	
	// 로그인
	User userLogin(User login);
	
	// 회원가입
	void userJoin(User user);
	
	// 아이디 중복검사
	int idMatching(String id);
	
	// 회원번호 받아 user객체 하나 반환
	User selectOneUser(int userNo);
	
	// 비밀번호 변경
	void passUpdate(User user);
	
	// 회원탈퇴
	void deleteUser(int userNo);
}








