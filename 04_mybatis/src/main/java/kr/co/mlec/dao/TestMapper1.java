package kr.co.mlec.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.domain.Member;
import kr.co.mlec.domain.SearchList;

public class TestMapper1 {
	private static final String NS = "kr.co.mlec.dao.TestMapper1.";
	// myBatis를 사용하기 위해서 SqlSession 객체가 필요하다
	private static SqlSession session;
	public TestMapper1() {
		session = MyAppSqlConfig.getSqlSessionInstance();
//		System.out.println(session); 
	}
	public Member selectMemberInfo1(String id) {
		return session.selectOne(NS + "selectMemberInfo1" , id);
	} 
	public Member selectMemberInfo2(Member param) {
		return session.selectOne(NS + "selectMemberInfo2",param);
	}
	public String selectMemberInfo3(String id) {
		return session.selectOne(NS + "selectMemberInfo3",id);
	}
	public int selectMemberInfo4() {
		return session.selectOne(NS + "selectMemberInfo4");
	}
	public List<Member> selectMemberList1(){
		return session.selectList(NS + "selectMemberList1");
	}
	public List<String> selectMemberList2(){
		return session.selectList(NS + "selectMemberList2");
	}
	public List<Member> selectMemberList3(){
		return session.selectList(NS + "selectMemberList3");
	}
	public void insertMember(Member param) {
		session.insert(NS + "insertMember",param);
		
		session.commit();
	}
	public void updateMember(Member param) {
		session.update(NS + "updateMember", param);
	}
	public void deleteMember(String id) {
		session.delete(NS + "deleteMember", id);
	}
	public List<Member> selectMemberIteratorList(Member param) {
		// TODO Auto-generated method stub
		return session.selectList(NS + "selectMemberIteratorList", param);
	}
	public List<Member> selectMemberIncludeList(){
		return session.selectList(NS + "selectMemberIncludeList");
	}
	public int selectMemberIncludeListCount(){
		return session.selectOne(NS + "selectMemberIncludeListCount");
	}
	public List<Member> selectMemberSearchList(SearchList param){
		return session.selectList(NS + "selectMemberSearchList",param);
	}
	public List<Member> selectMemberInputList(Member param){
		return session.selectList(NS + "selectMemberInputList",param);
	}
}








