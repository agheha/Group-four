package review.ui;

import java.util.List;

import review.dao.ReviewDAO;
import ui.BaseUI;
import vo.Review;

public class ListReviewUI extends BaseUI {
	ReviewDAO dao;
	
	public ListReviewUI(ReviewDAO dao) {
		this.dao = dao;
	}
	// 리뷰 보기 UI
	public void service() {
		List<Review> list = dao.selectReview();
		
		for (Review rev : list) {
			System.out.print(rev.getRevContent());
			for (int i = 0 ; i < 5  ; i++ ) {
				String star = "☆";
				if (i > Math.round(rev.getGpa())) {
					star = "★";
				}
				System.out.println(star);
			}
		}
	}
}
