package kr.co.mlec.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.dao.TestMapper2;
import kr.co.mlec.domain.Member;

public class Test2 {
	// 인터페이스 이기 때문에 직접 객체 생성 불가능
	private TestMapper2 mapper;
	
	public Test2() {
		//마이바티스가 실행시 만드는 구현 객체를 얻어오기
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(TestMapper2.class);
	}
	// 데이터를 조회하기 : 하나의 로우를 반환
	private void test01() {
//		Member m = mapper.selectMemberInfo1("member-2");
//		if (m != null) {
//			System.out.println("이름 : " + m.getName());
//			System.out.println("주소 : " + m.getAddr());
//		}
		/*
		Member param = new Member();
		param.setId("member-3");
		param.setName("jsp");
		
		
		Member m = mapper.selectMemberInfo2(param);
		if (m != null) {
			System.out.println("이름 : " + m.getName());
			System.out.println("주소 : " + m.getAddr());
		}
		*/
		System.out.println("이름 : " + mapper.selectMemberInfo3("member-1"));
		System.out.println("전체 회원 수: " + mapper.selectMemberInfo4());
	}
	
	// 여러개의 로우를 결과로 받기
	private void test02() { 
//		List<Member> list = mapper.selectMemberList1();
//		for (Member member : list) {
//			System.out.println("이름 : "+member.getName() + ", 가입일 : " + member.getName());
//		}
		
//		List<String> list = mapper.selectMemberList2();
//		for (String name : list) {
//			System.out.println("이름 : "+ name);
//		}
		List<Member> list = mapper.selectMemberList3();
		for (Member member : list) {
			System.out.println("이름 : "+member.getName() + ", 가입일 : " + member.getName());
		}
	}

	// 회원 등록
//	private void insertMember() {
//		Member param = new Member();
//		param.setId("member-5");
//		param.setName("testtest");
//		param.setEmail("asd123@naver.com");
//		param.setAddr("서울시 마포구");
//		
//		mapper.insertMember(param);
//		
//		System.out.println("데이터가 등록되었습니다");
//		
//		test02();
//	}
	
//	 회원 수정
	private void updateMember()  {
		Member param = new Member();
		param.setId("member-5");
		param.setEmail("asdqqwe123@naver.com");
		param.setAddr("서울시 마포구123");
		
		mapper.updateMember(param);
		
		System.out.println("데이터가 등록되었습니다");
		
		test02();
	}
	
	// 회원 삭제
//	private void deleteMember() {
//		mapper.deleteMember("member-5");
//		System.out.println("삭제 완료 ");
//		test02();
//	}
	
	
	// 동적 쿼리 처리방식
	private void dynamicSearch() {
//		Member param = new Member();
//		param.setAddrs(new String[] {"busan", "seoul", "daejeon"});
//		
//		param.setAddrs2(Arrays.asList(new String[] {"busan", "seoul", "daejeon"}));
//		
//		List<Member> list = mapper.selectMemberIteratorList(param);
//		for (Member member : list) {
//			System.out.println("이름 : " + member.getName() + ", " +
//						       "주소 : " + member.getAddr()					
//			);
//		}
		/*
		System.out.printf("전체 %d명%n", mapper.selectMemberIncludeListCount());
		
		List<Member> list = mapper.selectMemberIncludeList();
		for (Member member : list) {
			System.out.println("이름 : " + member.getName() + ", " +
					"주소 : " + member.getAddr()					
					);
		}
		*/
		/*
		Search param = new Search();
		param.setSearchType("id");
		param.setSearchWord("e");
		List<Member> list = mapper.selectMemberSearchList(param);
		for (Member member : list) {
			System.out.println("이름 : " + member.getName() + ", " +
							   "주소 : " + member.getAddr()					
			);
		}
		*/
		Member param = new Member();
		param.setId("e");
		param.setName("p");
		List<Member> list = mapper.selectMemberInputList(param);
		for (Member member : list) {
			System.out.println("이름 : " + member.getName() + ", " +
					"주소 : " + member.getAddr());
		}
	}
	
	
	public static void main(String[] args) {
		try {
			Test2 t = new Test2();
//			t.test01();  결과값 하나인것 확인
//			t.test02();  결과값 여러개 인것 확인
//			t.insertMember();
//			t.updateMember();
//			t.deleteMember();
			t.dynamicSearch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}










