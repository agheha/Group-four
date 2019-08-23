package g4.mini.store.info.ui;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.session.StoreSearchStatus;
import g4.mini.store.info.dao.StoreInfoMapper;
import g4.mini.ui.BaseUI;
import g4.mini.vo.Review;

public class ListReviewUI extends BaseUI {
	private StoreInfoMapper mapper;

	public ListReviewUI() {
		// 마이바티스가 실행시 만드는 구현 객체를 얻어오기
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(StoreInfoMapper.class);
	}
	int stoNo = StoreSearchStatus.store.getStoNo();
	// 리뷰 및 평점보기 UI
	public void service() {
		List<Review> list = mapper.selectReview(stoNo);
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println(StoreSearchStatus.store.getStoName());
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("번호\t아이디\t\t댓글\t\t\t평점");
		System.out.println("-------------------------------------------------------------------------------------");	
		for (Review rev : list) {
			System.out.printf(
					"%-3d\t%-15s\t%-15s\t%3.1f점 ",
					rev.getRevNo(),rev.getUserId(),rev.getRevComment(),rev.getGpa());
			gpaStart(rev.getGpa());
		}
	}
	
}
