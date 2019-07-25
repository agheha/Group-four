package map_for_lunch;

import java.util.Scanner;

public class login {
	
	 

		Scanner sc = new Scanner(System.in);
		
		int loginMenu() {
			System.out.println("1. 가격별로 보기");
			System.out.println("2. 종류별로 보기");
			System.out.println("3. 평점주기");
			System.out.println("0. 이전화면");
			System.out.println("-------------------------");
			System.out.print("번호를 입력하세요 :");
			return Integer.parseInt(sc.nextLine());
		}	
			
		void loginService() {
			System.out.println("-------------------------");
			System.out.println("비트캠프 점심메뉴에 오신 것을 환영합니다.");
			System.out.println("-------------------------");
			while(true) {
				switch (loginMenu()) {
				case 1: priceView(); break;
				case 2: typeView(); break;
				case 3: storeScore(); break;
				case 0: break;
				default:
					System.out.println("잘못된 메뉴번호 입니다.");
					System.out.println("다시 선택해 주세요.");
				}
			}
		}
		
		void priceView() {
			System.out.println("-------------------------");
			System.out.println("가격별 보기");
			System.out.println("-------------------------");
			System.out.print("가격을 입력하세요 : ");
			int price = Integer.parseInt(sc.nextLine());
			
			System.out.println("-------------------------");
			System.out.println(price + "원 이하 메뉴");
			System.out.println("-------------------------");
			
			for (int i = 0; i < storePos, i++) {
				
				if (storeArr[i].setPrice > price) continue;
				
				System.out.printf("%s	%s	%,d원\n", storeArr[i].name, storeArr[i].store);
			}
			
		}
			
			
			
			
			
			
			
		void typeView() {
			System.out.println("-------------------------");
			System.out.println("종류별 보기");
			System.out.println("-------------------------");
			System.out.println("1. 중식");
			System.out.println("2. 양식");
			System.out.println("3. 한식");
			System.out.println("4. 일식");
			System.out.println("0. 이전화면");
			System.out.println("-------------------------");
			System.out.print("번호를 입력하세요 :");
			int foodType = Integer.parseInt(sc.nextLine());
			
			System.out.println("-------------------------");
			System.out.println("이름	대표메뉴	가격	위치");
			System.out.println("-------------------------");
			
		}
			
			
			
			
			
			
			
			
			
			
			
			
		void storeScore() {	
			System.out.println("-------------------------");
			System.out.println("평점 주기");
			System.out.println("-------------------------");
			
			System.out.println("-------------------------");
			System.out.print("평가할 식당을 선택해주세요 : ");
			int store = Integer.parseInt(sc.nextLine());
			
			System.out.println("-------------------------");
			System.out.println("평점을 입력해주세요(5점 만점) : ");
			int score = Integer.parseInt(sc.nextLine());
			
			
			System.out.println("-------------------------");
			System.out.println("회원가입 후 이용해주세요.");
			System.out.println("-------------------------");
		}
			
			
			
public static void main(String[] args) {
	login lg = new login();
	lg.loginService();
}			
	
		
	
}


