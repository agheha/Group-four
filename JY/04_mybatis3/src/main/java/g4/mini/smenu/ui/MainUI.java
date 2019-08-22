package g4.mini.smenu.ui;


public class MainUI extends BaseUI{
	
	private int menu() {
		System.out.println("1. 메뉴추가");
		System.out.println("2. 예약하기");
		System.out.println("3. 가게 정보보기");
		System.out.println("4. 가게 정보변경");
		System.out.println("5. 비밀번호 변경");
		System.out.println("6. 회원탈퇴");
		System.out.println("0. 로그아웃");
		
		System.out.println("---------------------------");
		System.out.print("번호를 입력하세요 : ");
		
		return Integer.parseInt(sc.nextLine());
	}
	
	public void service() {
		System.out.println("---------------------------");
		System.out.println("우리가게 정보");
		System.out.println("---------------------------");
		while (true) {
			BaseUI ui = null;
			switch (menu()) {
			case 1: ui = new InsertInfoUI(); break;
			case 2: 
			case 3: 
			case 0: exit();
			default:
				System.out.println("잘못된 메뉴번호 입니다.");
				System.out.println("다시 선택해 주세요.");
			}
			if (ui != null) ui.service();
		}
	}
	
	void exit() {
		sc.close();
		// 프로세스 종료
		System.out.println("게시판 시스템을 종료합니다.");
		System.exit(0);
	}
}
