package review.dao;

import ui.BaseUI;

public class ReviewDAO extends BaseUI{
	
	public void selectReview() {
		
	}
	
	public void insertReview() {
		double gpa = getInt("평점을 입력해주세요(1점 - 5점) : ");
		String title = getString("리뷰 제목을 입력해주세요 : ");
		String content = getString("리뷰 내용을 입력해주세요 : ");
		
	}

	@Override
	public void service() {
		// TODO Auto-generated method stub
		
	}
}
