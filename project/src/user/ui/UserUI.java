package user.ui;

import java.util.Scanner;

import ui.BaseUI;
import user.dao.UserDAO;
import vo.User;


public class UserUI {
	
	UserDAO dao = new UserDAO();
	
	Scanner sc = new Scanner(System.in);
	
	// 로그인 상태를 나타내는 변수
	boolean islogin = false;
	
	public void service () {
			System.out.println("-------------------------");
			System.out.println("비트 캠프 점심 메뉴");
			System.out.println("-------------------------");
			BaseUI ui = null;
			while(true) {
				switch(menu()) { // 메뉴에서 입력 숫자를 받아 메서드 실행
				case 1: userLogin(); break;
				case 2: userJoin(); break;
				case 0:	System.exit(0);
				default :
					System.out.println("잘못된 메뉴번호 입니다.");
					System.out.println("다시 선택해 주세요.");
				}
			}
	}

	public int menu() {
		System.out.println("1. 로그인");
		System.out.println("2. 회원 가입");
		System.out.println("0. 종료");
		System.out.println("-------------------------");
		System.out.println("번호를 입력하세요. ");
		return Integer.parseInt(sc.nextLine());
	}

	public void userLogin() {
		System.out.println("-------------------------");
		System.out.println("로그인");
		System.out.println();
		System.out.print("아이디 : ");
		String loginId = sc.nextLine();
		System.out.print("패스워드 : ");
		String loginPass = sc.nextLine();
		System.out.println();
		// loginId와 loginPass 입력값과 데이터베이스의 값을 비교하여 일치시 메인메뉴전환
		
		// 아이디를 틀렸을 때
		System.out.println("-------------------------");
		System.out.println("입력된 아이디를 다시 한 번 확인하여주세요.");
		System.out.println("-------------------------");
		
		// 아이디 확인 후 비밀번호 틀렸을 때
		System.out.println("-------------------------");
		System.out.println("입력된 비밀번호를 다시 한 번 확인하여주세요.");
		System.out.println("-------------------------");
	}

	public void userJoin() {
		while(true) {
			System.out.println("회원가입");
			User u = new User(); // 새로운 멤버인스턴스 생성
			System.out.println();
			System.out.print("1. 아이디 :");
			u.setUserId(sc.nextLine());
			System.out.print("2. 패스워드 :");
			String userPass = sc.nextLine(); 
			u.setUserPass(userPass);
			System.out.print("3. 패스워드 :");
			String userPass2 = sc.nextLine();
			if (userPass != userPass2) { // 비밀번호 불일치시 다시 시작
				System.out.println("비밀번호를 확인하세요.");
				continue;
			}
			System.out.print("4. 이름 :");
			u.setUserName(sc.nextLine());
			System.out.print("5. 생년월일 :");
			u.setUserBirth(sc.nextLine());
			
			//DAO 구현 후 변수 m저장 해야함
			
			break;
			
		}
	}

	public void nonUserLogin() {
		System.out.println("비회원 로그인 되었습니다.");
		System.out.println("비트캠프 점심메뉴에 오신 것을 환영합니다.");
		
		
		
	}
}
