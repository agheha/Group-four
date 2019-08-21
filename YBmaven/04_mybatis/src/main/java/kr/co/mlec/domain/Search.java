package kr.co.mlec.domain;

public class Search {
	private String searchType;	// 아이디, 이름, 주소
	private String searchWord;	// 사용자가 입력한 검색어, 홍길동
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
}