package g4.mini.store.list.dao;

import java.util.List;

import g4.mini.vo.SearchList;
import g4.mini.vo.Store;

public interface StoreListMapper {

	public List<Store> priceList(SearchList search); 
	public List<Store> typeList(String type);
	public List<Store> gpaList();
	public List<Store> distanceList();
	public List<Store> acRevList();
}
