package g4.mini.user.test;

import java.util.Random;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.ui.BaseUI;
import g4.mini.user.dao.UserMapper;
import g4.mini.vo.Store;

public class RandomUI extends BaseUI {
	private UserMapper mapper;
	
	public RandomUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(UserMapper.class);
	}
	
	public void service() {
		System.out.println("--------------------------");
		System.out.println("★오늘의 메뉴★");
		System.out.println("--------------------------");
		
		Random r = new Random();
		// qwe 가게의 넘버...
		int qwe = r.nextInt(mapper.selectRandom()) + 1;
		
//		String a = mapper.selectRandom2(qwe);
		Store a = mapper.selectval(qwe);
		
		System.out.println("가게이름 : " + a.getStoName());
		System.out.println("가게메뉴 : " + a.getRstMenu());
		System.out.println("가격 : " + a.getRstPrice());
		System.out.println("거리 : " + a.getBitDistance());
//		
//		Store sto = mapper.selectval(qwe);
	
		
		System.out.println("--------------------------");
		System.out.println("점심 맛있게 드세욧~!");
	}
}
