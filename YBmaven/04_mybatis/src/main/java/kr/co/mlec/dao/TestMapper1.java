package kr.co.mlec.dao;
import java.util.List;

// 얘는 Test1에서 쓴다.
import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.domain.Member;
import kr.co.mlec.domain.Search;

public class TestMapper1 {  // MyAppSqlConfig의 sqlSession을 사용하는 클래스 . DAO
	private static final String NS = "kr.co.mlec.dao.TestMapper1.";
	
	// myBatis를 사용하기 위해서 sqlSession 객체가 필요함
	
	private static SqlSession session;
	
	public TestMapper1() {
		session = MyAppSqlConfig.getSqlSessionInstance();   // 직접 new하는 것이 아니라 이렇게 얻어온다.
//		System.out.println(session);  // 제대로 만들어졌나 확인
	}
	
	// 반환타입은 mapper의 반환타입, 매개변수는 mapper의 파라미터타입을 보고 만든다.
	public Member selectMemberInfo1(String id) {
//		Member member = session.selectOne("매퍼의 네임스페이스값.select 태그 호출", 매퍼에게 주는 매개변수값);  //selectone은 결과가 하나인것
		Member member = session.selectOne( NS + "selectMemberInfo1", id); 
		return member;
	}
	
	public Member selectMemberInfo2(Member param) {
		return session.selectOne(NS + "selectMemberInfo2", param);  // "kr.co.mlec.dao.TestMapper1.selectMemberInfo2"
	}
	
	
	public String selectMemberInfo3(String id) {   // SQL문이 명확하면 메서드 만들기가 편하다.
		return session.selectOne(NS + "selectMemberInfo3", id);
	}

	public int selectMemberInfo4() {
		return session.selectOne(NS + "selectMemberInfo4");
	}
	
	public List<Member> selectMemberList1(){
		return session.selectList(NS + "selectMemberList1");  // alias를 쓴것
	}
	
	public List<String> selectMemberList2(){  // name값만 담은 list
		return session.selectList(NS + "selectMemberList2");
	}

	public List<Member> selectMemberList3(){  
		return session.selectList(NS + "selectMemberList3");  // resultMap을 쓴 것
	}
	
	public void insertMember(Member param) {
		session.insert(NS + "insertMember", param);
		
		// commit
		session.commit();
	}
	
	public void updateMember(Member param) {
		session.update(NS + "updateMember", param);
	}
	
	public void deleteMember(String id) {
		session.delete(NS + "deleteMember", id);
	}

	public List<Member> selectMemeberIteratorList(Member param) {
		return session.selectList(NS + "selectMemberIteratorList", param);
	}
	
	public List<Member>	selectMemberIncludeList() {
		return session.selectList(NS + "selectMemberIncludeList");
	}
	
	public int selectMemberIncludeListCount() {
		return session.selectOne(NS + "selectMemberIncludeListCount");
	}
	
	public List<Member> selectMemberSearchList(Search param) {
		return session.selectList(NS + "selectMemberSearchList", param);
	}
	
	public List<Member> selectMemberInputList(Member param) {
		return session.selectList(NS + "selectMemberInputList", param);
	}
	
}








