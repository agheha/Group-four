package g4.mini.store.list.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.session.LoginStatus;
import g4.mini.session.StoreSearchStatus;
import g4.mini.store.info.ui.StoreInfoUI;
import g4.mini.store.list.dao.StoreListDAO;
import g4.mini.store.list.dao.StoreListMapper;
import g4.mini.ui.BaseUI;
import g4.mini.vo.Store;

public class TypeListUI extends BaseUI{
	
	private String type ; 
	private StoreListMapper mapper;

	public TypeListUI() {
		// 마이바티스가 실행시 만드는 구현 객체를 얻어오기
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(StoreListMapper.class);
	}
	
	public void service() {
		while (true) {
			switch (typeMenu()) {
			case 1 : type = "한식"; type(); break;
			case 2 : type = "중식"; type(); break;
			case 3 : type = "양식"; type(); break;
			case 4 : type = "일식"; type(); break;
			case 5 : type = "패스트푸드"; type(); break;
			case 6 : return;
			case 0 : 
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default : 
				System.out.println("번호를 다시 입력해주세요.");
			}
		}
	}
	public void type() {
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("음식점별 보기");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("번호\t가게이름\t\t종류\t메인메뉴\t\t가격\t  거리\t 누적예약수");
		printStroe(new HashMap<Integer, Store>(), mapper.typeList(type));
	}
	
	public int typeMenu() {
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("1. 한식");
		System.out.println("2. 중식");
		System.out.println("3. 양식");
		System.out.println("4. 일식");
		System.out.println("5. 패스트푸드");
		System.out.println("6. 이전 돌아가기");
		System.out.println("0. 종료");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.print("☞ 메뮤를 선택해주세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
}


















