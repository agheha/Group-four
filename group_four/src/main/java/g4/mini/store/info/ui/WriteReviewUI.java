package g4.mini.store.info.ui;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.session.StoreSearchStatus;
import g4.mini.store.info.dao.StoreInfoMapper;
import g4.mini.ui.BaseUI;
import g4.mini.vo.Review;

public class WriteReviewUI extends BaseUI {
	private StoreInfoMapper mapper;
	int stoNo = StoreSearchStatus.store.getStoNo();
	String userId = "qweqwe123";
	public WriteReviewUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(StoreInfoMapper.class);
	}
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
		rev.setStoNo(stoNo);
		rev.setUserId(userId);
		rev.setGpa(gpa);
		rev.setRevComment(comment);
		mapper.insertReview(rev);
		
		System.out.println("댓글 등록이 안료되었습니다.");
	}
	
}
