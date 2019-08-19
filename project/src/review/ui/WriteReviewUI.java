package review.ui;

import review.dao.ReviewDAO;
import ui.BaseUI;

public class WriteReviewUI extends BaseUI {
	ReviewDAO dao;
	
	public WriteReviewUI(ReviewDAO dao) {
		this.dao = dao;
	}
	// 리뷰 쓰기 UI
	public void service() {
		double gpa = getInt("평점을 입력해주세요 : ");
		String title = getString("리뷰 제목을 입력해주세요 : ");
		String content = getString("리뷰 제목을 입력해주세요 : ");
	}
}
