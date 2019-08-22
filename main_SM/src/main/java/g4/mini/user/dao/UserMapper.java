package g4.mini.user.dao;

import g4.mini.vo.User;

public interface UserMapper {
	// 로그인
	User userLogin(User login);

	// 회원가입
	void userJoin(User user);

	// 아이디 중복검사
	int idMatching(String id);

}
