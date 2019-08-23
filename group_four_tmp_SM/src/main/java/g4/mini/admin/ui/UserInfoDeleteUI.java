package g4.mini.admin.ui;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import g4.mini.admin.dao.AdministratorMapper;
import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.reservation.ui.CheckReservationUI;
import g4.mini.store.list.ui.StoreListUI;
import g4.mini.ui.BaseUI;
import g4.mini.user.account.ui.InfoUserUI;
import g4.mini.vo.User;

public class UserInfoDeleteUI extends BaseUI {

	private AdministratorMapper mapper;

	public UserInfoDeleteUI() {
		SqlSession session =  MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(AdministratorMapper.class);
	}
	
	public void service() {
		
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("회원번호\t아이디\t이름\t생일\t핸드폰번호\t이메일\t");
		List<User> list = mapper.selectMemberList();
		for (User u : list) {
			System.out.printf("%2d %10s %5s %10s%n", u.getUserNo(), u.getUserId(), u.getUserName(), u.getUserBirth() /*, u.getUserPH, u.getUserEmail*/);
		}
		System.out.println("-------------------------------------------------------------------------------------");
		int userNo = getInt("삭제할 회원번호를 선택하세요 : ");
		mapper.deleteUser(userNo);
		
	}

	
}
