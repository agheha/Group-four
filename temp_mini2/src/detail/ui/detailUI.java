package detail.ui;

import java.util.List;
import java.util.Scanner;

import login.vo.User;
import member.dao.MemberDAO;
import member.ui.JoinMemberUI;
import ui.BaseUI;

public class detailUI extends BaseUI{
	private Scanner sc = new Scanner(System.in);
	private MemberDAO dao;
	
//  public detailUI(User user) {
//    	this.dao = dao;
//	}
	public detailUI(MemberDAO dao) {
		this.dao = dao;
	}
	
    public void service() {
		BaseUI ui = null;
    	switch (menu()) {
    	case 1: break;
    	case 2: break;
    	case 3: break;
    	case 4: break;
    	case 0: ui = new JoinMemberUI(); break;
    	default:
    		System.out.println("잘못된 메뉴번호 입니다.");
    		System.out.println("다시 선택해 주세요.");
    	}
    	if (ui != null) ui.service();	
    }
	public int menu() {
		System.out.println("-----------------");
		System.out.println("상세보기");
		System.out.println("-----------------");
		System.out.println("1. 예약하기");
		System.out.println("2. 리뷰보기");
		System.out.println("3. 평점 및 리뷰쓰기");
		System.out.println("4. 메뉴보기");
		
		System.out.println("0. 이전으로 돌아가기");
		System.out.println("-----------------");
		System.out.print("번호를 입력하세요 : ");
		
		return Integer.parseInt(sc.nextLine());
	}
}
