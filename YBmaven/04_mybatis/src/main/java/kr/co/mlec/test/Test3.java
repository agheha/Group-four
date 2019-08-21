package kr.co.mlec.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.dao.TestMapper3;
import kr.co.mlec.domain.Board;
import kr.co.mlec.domain.Comment;
import kr.co.mlec.domain.File;

public class Test3 {           
	
	// 인터페이스이기 때문에 직접 객체 생성 불가능
	private TestMapper3 mapper;
	
	public Test3() {
		// 마이바티스가 실행시 만드는 구형 객체를 얻어오기
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance(); 
		mapper = session.getMapper(TestMapper3.class); 
	}
	
	/**
	 * 게시물 등록시 파일 동시등록하기 : selectKey 활용 이해하기
	 */
	private void test01() {
		/*
		// 먼저 필요한 시퀀스 번호를 변수에 담는다.
		int no = mapper.selectBoardNo();
				
		Board board = new Board();
		board.setNo(no);
		board.setTitle("aaa");
		board.setWriter("bbb");
		board.setContent("ccc");
		mapper.insertBoard1(board);
		*/
		
		
		Board board = new Board();
		board.setTitle("aaa");
		board.setWriter("bbb");
		board.setContent("ccc");
		mapper.insertBoard2(board);
		
		File file = new File();
		file.setNo(board.getNo());  //
		file.setFileName("연습.txt");
		file.setFileSize(10000);
		mapper.insertFile(file);
		
		System.out.println("등록되었습니다.");
	}
	
	
	
	
	
	/**
	 * 한 회원의 계정 정보를 같이 조회
	 */
	private void test02() { 
		/*
		List<Member> list = mapper.selectMemberList();
		for (Member m : list) {
			Account account = mapper.selectMemberAccountById(m.getId());
			m.setAccount(account);
		}
		System.out.println(list);
		*/
		
		/*
		List<Member> list = mapper.selectMemberList();
		System.out.println(list);
		*/
	}

	private void test03() { 
		/*
		List<Board> list = mapper.selectBoardList1();
		List<Comment> cList = mapper.selectCommentList1();
		for (Board board : list) {
			System.out.printf(
					"%d\t%s\t%s%n", 
					board.getNo(), board.getTitle(), board.getWriter()
					);
			
			for (Comment c : cList) {
				if (board.getNo() != c.getNo()) continue;
				System.out.printf(
						"\t%s\t%s%n", 
						c.getWriter(), c.getContent()
						);
			}
		}
		*/
		
		
		/*
		// 알맞은 방법 그닥 아니다ㅋ
		List<Board> list = mapper.selectBoardList1();
		for (Board board : list) {
			System.out.printf(
					"%d\t%s\t%s%n", 
					board.getNo(), board.getTitle(), board.getWriter()
					);
			// 게시물 번호에 맞는 commentlist
			board.setCommentList(mapper.selectCommentList2ByNo(board.getNo()));
			
			for (Comment c : board.getCommentList()) {
				System.out.printf(
						"\t%s\t%s%n", 
						c.getWriter(), c.getContent()
						);
			}
		}
		*/
		
		
		List<Board> list = mapper.selectBoardList1();
		for (Board board : list) {
			System.out.printf(
					"%d\t%s\t%s%n", 
					board.getNo(), board.getTitle(), board.getWriter()
					);
			
			for (Comment c : board.getCommentList()) {
				System.out.printf(
						"\t%s\t%s%n", 
						c.getWriter(), c.getContent()
						);
			}
		}
		
		
	}
	
	
	public static void main(String[] args) {
		try {
			Test3 t = new Test3();
//			t.test01();   
//			t.test02();   
			t.test03();   
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}










