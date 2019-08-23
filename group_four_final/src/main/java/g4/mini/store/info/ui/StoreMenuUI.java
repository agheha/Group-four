package g4.mini.store.info.ui;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.session.StoreSearchStatus;
import g4.mini.store.info.dao.StoreInfoMapper;
import g4.mini.ui.BaseUI;
import g4.mini.vo.StoreMenu;

public class StoreMenuUI extends BaseUI{
	
	private StoreInfoMapper mapper;
	int stoNo = StoreSearchStatus.store.getStoNo();
	public StoreMenuUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(StoreInfoMapper.class);
	}
	public void service() {
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("메뉴 상세보기");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("메뉴\t\t가격\t 칼로리");
		System.out.println("-------------------------------------------------------------------------------------");
		List<StoreMenu> list = mapper.selectMenu(stoNo);
		for (StoreMenu menu : list) {
			System.out.printf("%-8s\t%,d\t%4dcal%n",menu.getStoMenu(),menu.getPrice(),menu.getCalorie());
		}
	}
}
