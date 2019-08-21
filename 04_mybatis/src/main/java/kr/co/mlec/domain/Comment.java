package kr.co.mlec.domain;

import java.util.Date;

/**
 * 게시물에 대한 정보를 표현하는 데이터 중심 클래스
 * @author mrson
 */
public class Comment {
	
	private int commentNo;
	
	/** 글 번호 */
	private int no;
	/** 글쓴이 */
	private String writer;
	/** 내용 */
	private String content;
	/** 등록일 */
	private Date regDate;
	public void setNo(/*BoardVO this, */int no) {
		this.no = no;
	}
	public int getNo() {
		return no;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriter() {
		return writer;
	}
	
	/**
	 * 게시글의 내용을 설정한다.
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	@Override
	public String toString() {
		return "Comment [commentNo=" + commentNo + ", no=" + no + ", writer=" + writer + ", content=" + content
				+ ", regDate=" + regDate + "]";
	}
	
}










