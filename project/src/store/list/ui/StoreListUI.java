package store.list.ui;

import java.util.Scanner;

import store.list.dao.StoreListDAO;

public class StoreListUI {
	
	Scanner sc = new Scanner(System.in);
	StoreListDAO dao = new StoreListDAO();
	String result = null;
	
	public void service() {
		while(true) {
			switch (menu()) {
			case 1 : 
				result = "rst_price";
				new PriceListUI(dao,result).service(); break; 
			case 2 : 
				result = "sto_type";
				new PriceListUI(dao,result).service(); break; 
			case 3 : 
				result = "sto_gpa";
				new PriceListUI(dao,result).service(); break; 
			case 4 : 
				result = "bit_distance";
				new DistanceListUI(dao,result).service(); break; 
			case 5 : 
				result = "ACC_RESERVATION";
				new PriceListUI(dao,result).service(); break; 
			case 6 : return;
			case 0 :
				System.exit(0);
				System.out.println("프로그램을 종료합니다.");
			default : 
				System.out.println("번호를 확인해주세요.");
			}
		}
	}
	public int menu() {
		System.out.println("----------------------------------------------");
		System.out.println("가게보기");
		System.out.println("----------------------------------------------");
		System.out.println("1. 가격별 보기");
		System.out.println("2. 음식점별 보기 ");
		System.out.println("3. 평점별 보기");
		System.out.println("4. 거리순 보기");
		System.out.println("5. 예약순 보기");
		System.out.println("6. 이전 돌아가기");
		System.out.println("0. 종료");
		System.out.println("----------------------------------------------");
		System.out.print("메뉴를 선택해주세요 : ");
		return Integer.parseInt(sc.nextLine());
		
	}
	
	public static void main(String[] args) {
		new StoreListUI().service();
	}
}

