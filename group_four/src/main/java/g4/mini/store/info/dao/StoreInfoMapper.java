package g4.mini.store.info.dao;

import java.util.List;

import g4.mini.vo.Review;
import g4.mini.vo.Store;
import g4.mini.vo.StoreMenu;

public interface StoreInfoMapper {
	List<Review> selectReview(int stoNo);
	void insertReview(Review rev);
	List<StoreMenu> selectMenu(int stoNo);
	double avgGpa(int stoNo);
	void updateStoreGpa(Store sto);
}
