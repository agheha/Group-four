package kr.co.mlec.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.dao.TestMapper2;
import kr.co.mlec.domain.Member;

public class Test2 {           
	
	// 인터페이스이기 때문에 직접 객체 생성 불가능
	private TestMapper2 mapper;
	
	public Test2() {
		// 마이바티스가 실행시 만드는 구형 객체를 얻어오기
		// mapper에 대한 구현체가 getmapper인데, 그것을 쓰기위해 SqlSession을 가져온다.
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance(); 
		mapper = session.getMapper(TestMapper2.class); // 환경설정때 로딩한 클래스를 기준으로 인터페이스클래스를 마이바티스에게 대신 만들어달라하는 것
	}
	
	// 데이터를 조회하기 : 하나의 로우를 반환
	private void test01() {
		/*
		Member m = mapper.selectMemberInfo1("member-2"); //dao에 있던거
		if(m != null) {
			System.out.println("이름 : " + m.getName());
			System.out.println("주소 : " + m.getAddr());
		}
		*/
		
		/*
		Member param = new Member();
		param.setId("member-3");
		param.setName("jsp");
		
		Member m = mapper.selectMemberInfo2(param); //dao에 있던거
		if(m != null) {
			System.out.println("이름 : " + m.getName());
			System.out.println("주소 : " + m.getAddr());
		}
		*/
		
		
//		System.out.println("이름 : " + mapper.selectMemberInfo3("member-1"));
		
		
		System.out.println("전체 회원 수 : " + mapper.selectMemberInfo4());
		
	}
	
	// 여러개의 로우를 결과로 받기
	private void test02() { 
		/*
		List<Member> list = mapper.selectMemberList1();
		for(Member m : list) {
			System.out.println("이름 : " + m.getName() + ", 가입일 : " + m.getJoinDate());
		}
		*/
		
		/*
		List<String> list = mapper.selectMemberList2();
		for(String name : list) {
			System.out.println("이름 : " + name);
		}
		*/
		
		List<Member> list = mapper.selectMemberList3();
		for(Member m : list) {
			System.out.println("이름 : " + m.getName() + ", 가입일 : " + m.getJoinDate());
		}
		
	}

	// 회원 등록
	private void insertMember() {
		Member param = new Member();
		param.setId("member-5");
		param.setName("황민현");
		param.setEmail("optimusHwang@m.net");
		param.setAddr("러브리");
		
		mapper.insertMember(param);
	
		System.out.println("데이터가 등록되었습니다.");	
		
		// 위에꺼 실행이 되나 목록확인해보기
		test02();
	}
	
	// 회원 수정
	private void updateMember()  {
		Member param = new Member();
		param.setId("member-5");
		param.setEmail("optimusHwang@m.com");
		param.setAddr("러브동");
		
		mapper.updateMember(param);
	
		System.out.println("데이터가 수정되었습니다.");	
		
		// 위에꺼 실행이 되나 목록확인해보기
		test02();
	}
	
	// 회원 삭제
	private void deleteMember() {
		
		mapper.deleteMember("member-5");
		System.out.println("데이터가 삭제되었습니다.");	
		
		// 위에꺼 실행이 되나 목록확인해보기
		test02();
	}
	
	// 동적 쿼리 처리방식
	private void dynamicSearch() {
		/*
		Member param = new Member();
		param.setAddrs(new String[] {"busan", "seoul", "daejeon"});
		
		
//		Arrays.asList(a) 배열받아 리스트로 반환
		param.setAddrs2(Arrays.asList(new String[] {"busan", "seoul", "daejeon"}));
	
		List<Member> list = mapper.selectMemberIteratorList(param);
		for (Member member : list) {
			System.out.println("이름 : " + member.getName() + ", " +
		                       "주소 : " + member.getAddr());
		}
		 */
		
		
		/*
		System.out.printf("전체%d명%n", mapper.selectMemberIncludeListCount());
		
		List<Member> list = mapper.selectMemberIncludeList();
		for (Member member : list) {
			System.out.println("이름 : " + member.getName() + ", " +
		                       "주소 : " + member.getAddr());
		}
		*/
		
		
		/*
		Search param = new Search();
		param.setSearchType("id");
		param.setSearchType("name");
		param.setSearchType("addr");
		param.setSearchWord("g");
		List<Member> list = mapper.selectMemberSearchList(param);
		for (Member member : list) {
			System.out.println("이름 : " + member.getName() + ", " +
		                       "주소 : " + member.getAddr());
		}
		*/
		Member param = new Member();
		param.setId("e");
//		param.setName("p");
		List<Member> list = mapper.selectMemberInputList(param);
		for (Member member : list) {
			System.out.println("이름 : " + member.getName() + ", " +
		                       "주소 : " + member.getAddr());
		}
		
		
	}
	
	
	public static void main(String[] args) {
		try {
			Test2 t = new Test2();
//			t.test01();   // 결과값이 하나인 것(로우가하나) 테스트
//			t.test02();   // 결과값이 여러개인 것 테스트
//			t.insertMember();
//			t.updateMember();
//			t.deleteMember();
			t.dynamicSearch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}










