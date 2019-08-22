package map_for_lunch;

import java.util.Random;

public class RandomMenu {

	Random r = new Random();
	//배열에 등록된 가게의 수만큼
	int gacha = r.nextInt(list.size()) + 1;
	Store store = list.get(gacha);
	//배열의 랜덤값으로나온 gacha번째의 값을 추출해서 store변수에 담음
	//DAO쪽에서 구현
	System.out.printf("오늘의 메뉴 : %s", store.getStoreMenu());
	//UI쪽에서 구현
}
