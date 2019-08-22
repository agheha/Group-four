package map_for_lunch;

import java.util.Scanner;

public class Main {

		Scanner sc = new Scanner(System.in);
		
		DAO dao = new DAO();
		
		int memberInfo() {
			System.out.println("-------------------------");
			System.out.println("1. 내 정보 보기");
			System.out.println("2. 비밀번호 변경");
			System.out.println("3. 회원탈퇴");
			System.out.println("0. 이전화면");
			System.out.println("-------------------------");
			System.out.print("번호를 입력하세요 : ");
			return Integer.parseInt(sc.nextLine());
			//번호입력받음
			//내정보
		}
		while(true) {
			switch(memberInfo()) {
				case 1: myInfo(); break; //내정보보기
				case 2: changePass(); break; //비밀번호 변경
				case 3: withdraw(); break; //회원탈퇴
				case 0: return; //이전화면
			}
			
			
		void myInfo() {
			//본인 아이디에 접근.
			Member member = dao.//아이디에 접근하는 메서드
			
			System.out.println("-------------------------");
			System.out.println("내 정보 보기");
			System.out.println("-------------------------");
			System.out.println("아이디 : " + member.getId());
			System.out.println("비밀번호 : " + member.getPass());
			System.out.println("이름 : " + member.getName());
			System.out.println("생년월일" + member.getBirth());
			System.out.println("-------------------------");
			
		}
		
		void changePass() {
			Member member = dao.id();
					
			System.out.println("-------------------------");
			System.out.println("비밀번호 변경");
			System.out.println("-------------------------");
			System.out.println("변경 전 비밀번호 : ");
			int before = Integer.parseInt(sc.nextLine());
			System.out.println("변경 할 비밀번호 : ");
			int after = Integer.parseInt(sc.nextLine());
			System.out.println("비밀번호 확인 : ");
			int check = Integer.parseInt(sc.nextLine());
			System.out.println("-------------------------");
			if (dao.pass == before && after == check) System.out.println("변경이 완료되었습니다.");
			//입력돼있는 패스워드가 같고 바꿀비밀번호와 체크하는게 같다면
			else if (dao.pass == before && after != check) System.out.println("비밀번호가 다릅니다."); //변경 할 비밀번호가 서로 다를때
			//입력돼있는 패스워드가 같고 바꿀비밀번호와 체크하는게 다르다면
			System.out.println("비밀번호가 틀립니다."); //변경 전 비밀번호를 틀렸을때
			//그외의 상황
		}
			
		void withdraw() {
			Member member = dao.pass();
					
			System.out.println("-------------------------");
			System.out.println("회원탈퇴");
			System.out.println("-------------------------");
			System.out.println("비밀번호 확인 : ");
			System.out.println("-------------------------");
			int check = Integer.parseInt(sc.nextLine());
			//비밀번호 가 맞는지 확인해 줌
			if (dao.pass == check) {
			System.out.println("회원탈퇴처리가 완료되었습니다.");
			return;
			} System.out.println("비밀번호가 틀립니다.");
		}
			
			

			
			
			
			
			
			
			
			
			
			
			
			
			
		
	
	
	
	
}
