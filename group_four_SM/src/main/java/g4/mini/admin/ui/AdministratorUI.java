package g4.mini.admin.ui;

import org.apache.ibatis.session.SqlSession;

import g4.mini.admin.dao.AdministratorMapper;
import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.ui.BaseUI;

public class AdministratorUI extends BaseUI {

	private AdministratorMapper mapper;

	public AdministratorUI() {
		SqlSession session =  MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(AdministratorMapper.class);
	}
	
	public void service() {
		while(true) {
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("관리자 권한으로 접속되었습니다");
			System.out.println("-------------------------------------------------------------------------------------");
			switch(menu()) {
			case 1 : new UserInfoUpdateUI().service(); break;
			case 2 : new UserInfoDeleteUI().service(); break;
			case 3 : new UserInfoUpdateUI().service(); break;
			case 4 : new UserInfoDeleteUI().service(); break;
			case 0 : 
				System.out.println("프로그램을 종료합니다. ");
				System.exit(0);
			default:
				System.out.println("잘못된 메뉴번호 입니다.");
				System.out.println("다시 선택해 주세요.");
				System.out.println("-------------------------------------------------------------------------------------");
			}
		}
	}

	private int menu() {
		System.out.println("1. 유저정보 수정");
		System.out.println("2. 유저정보 삭제");
		System.out.println("3. 가맹점정보 수정");	
		System.out.println("4. 가맹점정보 삭제");	
		System.out.println("0. 종료");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.print("☞ 메뉴 중 처리할 항목을 선택하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
}
