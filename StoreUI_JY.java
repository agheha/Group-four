/**
 * 가게 정렬
 */
package map_four_lunch;

import java.util.Scanner;
public class StoreUI {
	StoreDAO dao = new StoreDAO();
	Scanner sc = new Scanner(System.in);
	
	// 가격별로 보기
	void Price() {
		System.out.println("-----------------");
		System.out.println("가격별로 보기");
		System.out.println("-----------------");
		
		// 일단 5000원 만듬 임의로
		System.out.print("가격을 입력하세요 : ");
		int no = Integer.parseInt(sc.nextLine());
		
		// 
		if(no == 5000) {
			System.out.println("-----------------");
			System.out.println("5000원 이하 메뉴");
			System.out.println("-----------------");
			
			System.out.println("-----------------");
			System.out.println("가게명    메뉴명    가격");
			System.out.println("-----------------");
			
			System.out.println("홍원      짜장면      5000원");
			System.out.println("청석골   뼈해장국   5000원");
			System.out.println("홍원      짜장면      4500원");
			
			System.out.println("-----------------");
		}
	}
	
	// 종류별로 보기
	void Typemenu() {
		System.out.println("-----------------");
		System.out.println("종류별로 보기");
		System.out.println("-----------------");
		while (true) {
			switch (menu2()) {
			case 1: chinese(); break;
			default:
				System.out.println("잘못된 메뉴번호 입니다.");
				System.out.println("다시 선택해 주세요.");
			}
			return;
		}		
	}
	
	void chinese() {
		System.out.println("-----------------");
		System.out.println("이름  대표메뉴  가격  위치");
		System.out.println("-----------------");
		
		System.out.println("홍원 짜장면 5000원 비트캠프지하");
		System.out.println();
		System.out.println("중화반점 라구짜장 8900원 신촌역");
		System.out.println();
		System.out.println("수저가 차돌박이짬뽕 5000원 비트캠프지하");
		System.out.println();
		System.out.println("홍원 짜장면 5000원 비트캠프지하");
	}
	
	int menu2() {
		System.out.println("1. 중식");
		System.out.println("2. 양식");
		System.out.println("3. 한식");
		System.out.println("4. 일식");
		System.out.println("0. 이전화면");
		System.out.println("-----------------");
		System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
		return Integer.parseInt(sc.nextLine());	
	}
	
	int menu() {
		System.out.println("-----------------");
		System.out.println("1. 가격별로 보기");
		System.out.println("2. 종류별로 보기");
		System.out.println("3. 평점 주기");
		System.out.println("0. 이전 화면");
		System.out.println("-----------------");
		System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
		return Integer.parseInt(sc.nextLine());	
	}
	
	void service() {
		System.out.println("-----------------");
		System.out.println("비트캠프 점심메뉴에 오신걸 환영합니다.");
		System.out.println("-----------------");
		while (true) {
			switch (menu()) {
				case 1: Price(); break;
				case 2: Typemenu(); break;
			default:
				System.out.println("잘못된 메뉴번호 입니다.");
				System.out.println("다시 선택해 주세요.");
			}
			return;
		}		
	}
}
