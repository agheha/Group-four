package g4.mini.store.info.dao;

import java.util.List;

import g4.mini.vo.Review;

public interface StoreInfoMapper {
	List<Review> selectReview(int stoNo);
}
