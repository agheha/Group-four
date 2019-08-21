package kr.co.mlec.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.domain.Member;
import kr.co.mlec.domain.SearchList;

public interface TestMapper2 {

	Member selectMemberInfo1(String id);
	
	Member selectMemberInfo2(Member param); 
	
	String selectMemberInfo3(String id);
	
	int selectMemberInfo4();
	
	List<Member> selectMemberList1();
	
	List<String> selectMemberList2();
	
	List<Member> selectMemberList3();
	
	void insertMember(Member param);
	
	void updateMember(Member param);
	
	void deleteMember(String id) ;
	
	List<Member> selectMemberIteratorList(Member param) ;
	
	List<Member> selectMemberIncludeList();
	
	int selectMemberIncludeListCount();
	
	List<Member> selectMemberSearchList(SearchList param);
	
	List<Member> selectMemberInputList(Member param);
	
}








