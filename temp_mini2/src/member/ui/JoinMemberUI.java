package member.ui;

import java.util.Scanner;

import login.vo.User;
import member.dao.MemberDAO;
import store.ui.priceUI;
import ui.BaseUI;

public class JoinMemberUI extends BaseUI{
	private Scanner sc = new Scanner(System.in);
	private MemberDAO dao = new MemberDAO();
	
	public int menu() {
		System.out.println("---------------------------");
		System.out.println("가게보기");
		System.out.println("---------------------------");
		System.out.println("1. 가격순");
		System.out.println("2. 평점순");
		System.out.println("3. 타입별");
		System.out.println("4. 거리순");
		System.out.println("5. 누적 예약자 순");
		System.out.println("---------------------------");
		System.out.print("번호를 입력하세요 : ");
		
		return Integer.parseInt(sc.nextLine());
	}

	@Override
	public void service() {
		BaseUI ui = null;
		switch (menu()) {
		case 1: ui = new priceUI(dao); break;
		case 2: break;
		case 3: break;
		case 4: break;
		case 5: break;
		case 0: break;
		default:
			System.out.println("잘못된 메뉴번호 입니다.");
			System.out.println("다시 선택해 주세요.");
		}
		if (ui != null) ui.service();
			
	}
}
