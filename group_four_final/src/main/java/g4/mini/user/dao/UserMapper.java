package g4.mini.user.dao;


import java.util.List;

import g4.mini.vo.Store;
import g4.mini.vo.StoreMenu;
import g4.mini.vo.User;

public interface UserMapper {
	// 로그인
	User userLogin(User login);

	// 회원가입
	void userJoin(User user);

	// 아이디 중복검사
	int idMatching(String id);

	// 랜덤값담기
	int selectRandom();
	
	Store selectval(int stoNo);
	//랜덤뽑은 가게 메뉴들
	List<StoreMenu> selectMenu(int stoNo);
	
	// 관리자 체크
	int adminCheck(User user);
}
