package g4.mini.store.info.ui;

import org.apache.ibatis.session.SqlSession;

import g4.mini.common.db.MyAppSqlConfig;
import g4.mini.session.StoreSearchStatus;
import g4.mini.store.info.dao.StoreInfoMapper;
import g4.mini.ui.BaseUI;
import g4.mini.vo.Review;
import g4.mini.vo.Store;

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
		// gpa가 번호에 포함되지 않으면 와일루프
		while(flag) {
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.print("☞ 평점을 입력해주세요(0 - 5) : ");
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
		Store sto = new Store();
		sto.setStoNo(stoNo);
		sto.setStoGpa(mapper.avgGpa(stoNo));
		mapper.updateStoreGpa(sto);
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("댓글 등록이 완료되었습니다.");
	}
}
