package g4.mini.user.ui;

import java.util.List;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.ui.BaseUI;
import g4.mini.user.dao.UserMapper;
import g4.mini.vo.Store;
import g4.mini.vo.StoreMenu;


public class RandomMenuUI extends BaseUI {
	
	private UserMapper mapper;
	
	public RandomMenuUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(UserMapper.class);
	}
	
	public void service() {		
		Random r = new Random();
		
		int stoNo = r.nextInt(mapper.selectRandom()) + 1;
		
		List<StoreMenu> list = mapper.selectMenu(stoNo);
	
		Store sto= mapper.selectval(stoNo);
		
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("★ 오늘의 메뉴 ★");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("가게이름 : " + sto.getStoName());
		System.out.println("대표메뉴 : " + sto.getRstMenu());
		System.out.println("가격 : " + sto.getRstPrice() + "원");
		System.out.println("주소 : " + sto.getStoAddr());
		System.out.println("비트캠프와 거리 : " + sto.getBitDistance() + "m");
		System.out.println("");
		System.out.println("메뉴\t\t\t\t\t가격");
		for (StoreMenu menu : list) {
			System.out.printf("%-10s\t\t\t\t%,d원%n",menu.getStoMenu(),menu.getPrice());
		}
		System.out.println("");
		System.out.println("모두 맛점~!!");
	}
}
