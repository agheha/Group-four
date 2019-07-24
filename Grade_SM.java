package map_for_lunch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Grade {

	Scanner sc = new Scanner(System.in);
	
	GradeDAO dao = new GradeDAO();
	
	void selectOne() {
		System.out.println("가게 번호를 선택해주세요.");
		int storeNo = Integer.parseInt(sc.nextLine());
		Store store = dao.selectOne(storeNo);
		if (store == null) {
			System.out.println("가게번호를 다시 선택해주세요.");
			return;
		}
		Store storeVar = new Store();
		System.out.println("평점과 리뷰를 입력해주세요.");
		System.out.print("평점 : ");
		int grade = Integer.parseInt(sc.nextLine());
		System.out.println("리뷰 : ");
		String review = sc.nextLine();
		storeVar.setReview(review);
		storeVar.setStoreGrade(grade);
		
		dao.insertGradeReview(storeNo, grade, review);
		
	}
	
	
	
	public static void main(String[] args) {
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
