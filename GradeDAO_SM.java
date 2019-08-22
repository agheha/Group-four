package map_for_lunch;

public class GradeDAO {

	ObjectArrayList list = new ObjectArrayList();
	
	Store selectOne(int no) {
		for (int i = 0; i < list.size(); i++) {
			Store store = (Store) list.get(i);
			if (store.getStoreNo() == no) {
				return store;
			}
		}
		return null;
	}
	

	void insertGradeReview(int storeNo, int grade, String review) {
		Store store = selectOne(storeNo);
		store.setReview(review);
		store.setStoreGrade(grade);
	}
	
	
}

