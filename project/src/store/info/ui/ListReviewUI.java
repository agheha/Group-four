package store.info.ui;

import java.util.List;

import session.StoreSearchStatus;
import store.info.dao.StoreInfoDAO;
import ui.BaseUI;
import vo.Review;

public class ListReviewUI extends BaseUI {
	StoreInfoDAO dao;
	
	public ListReviewUI(StoreInfoDAO dao) {
		this.dao = dao;
	}
	// 리뷰 및 평점보기 UI
	public void service() {
		List<Review> list = dao.selectReview();
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println(StoreSearchStatus.store.getStoName());
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("번호\t아이디\t댓글\t평점");
		System.out.println("-------------------------------------------------------------------------------------");	
		for (Review rev : list) {
			System.out.printf(
					"%-3d\t%-15s\t%-15s\t%3.1f점 ",
					rev.getRevNo(),rev.getUserId(),rev.getRevComment(),rev.getGpa());
			gpaStart(rev.getGpa());
		}
	}
	
}
