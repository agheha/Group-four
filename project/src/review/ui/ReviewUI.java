package review.ui;

import java.util.Scanner;

import review.dao.ReviewDAO;
import session.LoginStatus;

public class ReviewUI {
	Scanner sc = new Scanner(System.in);
	public void service() {
		while(true) {
			switch(menu()) {
			case 1 : new ReviewDAO().selectReview(); break; // 가게 리뷰검색
			case 2 : new ReviewDAO().insertReview(); break; // 가게 리뷰등록
			case 3 : break;
			case 4 : LoginStatus.store = null; return;
			}
			
		}
	}
	public int menu() {
		// 서비스 메뉴 실행시 보여지는 메뉴
		System.out.println("--------------------------------");
		// 사용자가 입력한 번호에 해당하는 가게 정보를 담아준것을 사용 
		System.out.println("가게이름 : " + LoginStatus.store.getStoName()); // 상세보기 넘어오기전 스태틱 클래스 변수에 담긴것을 불러 사용한다
		System.out.println("가게주소 : " + LoginStatus.store.getStoAddr());
		System.out.println("--------------------------------");
		System.out.println("1. 리뷰 보기");
		System.out.println("2. 리뷰 쓰기");
		System.out.println("3. 예약 하기");
		System.out.println("4. 이전으로 돌아가기");
		System.out.println("0. 종료");
		System.out.println("--------------------------------");
		System.out.print("메뉴를 선택해 주세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
}
