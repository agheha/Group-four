package store.info.ui;

import session.StoreSearchStatus;
import store.info.dao.StoreInfoDAO;
import ui.BaseUI;
import vo.Review;

public class WriteReviewUI extends BaseUI {
	StoreInfoDAO dao;
	
	public WriteReviewUI(StoreInfoDAO dao) {
		this.dao = dao;
	}
	// 리뷰 쓰기 UI
	public void service() {
		boolean flag = true;
		double gpa = 0;
		while(flag) {
			System.out.print("☞ 번호를 입력해주세요 : ");
			gpa = Double.parseDouble(sc.nextLine());
			if (gpa < 0 && gpa > 5) continue;
			else flag = false;
		}
		String comment = getString("☞ 리뷰 제목을 입력해주세요 : ");
		Review rev = new Review();
		rev.setGpa(gpa);
		rev.setRevComment(comment);
		dao.gpaAvg(StoreSearchStatus.store.getStoNo(),gpa);
		dao.insertReview(rev);
		System.out.println("댓글 등록이 안료되었습니다.");
	}
	
}
