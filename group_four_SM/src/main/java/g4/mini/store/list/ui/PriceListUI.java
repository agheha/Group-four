package g4.mini.store.list.ui;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.store.list.dao.StoreListMapper;
import g4.mini.ui.BaseUI;
import g4.mini.vo.SearchList;
import g4.mini.vo.Store;

public class PriceListUI extends BaseUI{
	private StoreListMapper mapper;

	public PriceListUI() {
		// 마이바티스가 실행시 만드는 구현 객체를 얻어오기
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(StoreListMapper.class);
	}

	public void service() {
		int startPrice = 0;
		int endPrice = 0;
		boolean flag = true;
		// 최소 금액이 최고금액보다 크면 다시 입력
		while (flag) {
			startPrice = getInt("☞ 최소금액을 입력해주세요 : ");
			endPrice = getInt("☞ 최고금액을 입력해주세요  : ");
			if (startPrice < endPrice) {
				flag = false;
			}else System.out.println("최소금액이 최고금액보다 큰값입니다.");
		}
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("가격별 보기");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("번호\t가게이름\t\t종류\t메인메뉴\t\t가격\t  거리\t 누적예약수\t평점");
		SearchList search = new SearchList();
		search.setStartPrice(startPrice);
		search.setEndPrice(endPrice);
		printStroe(new HashMap<Integer, Store>(), mapper.priceList(search));
	}
}



















