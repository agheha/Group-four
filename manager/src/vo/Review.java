package vo;

import java.util.Date;

public class Review {
	private int userNo ;
	private int stoNo;
	private int revNo;
	private int gpa;
	private String revTitle;
	private String revContent ;
	private Date revRegdate;
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getStoNo() {
		return stoNo;
	}
	public void setStoNo(int stoNo) {
		this.stoNo = stoNo;
	}
	public int getRevNo() {
		return revNo;
	}
	public void setRevNo(int revNo) {
		this.revNo = revNo;
	}
	public int getGpa() {
		return gpa;
	}
	public void setGpa(int gpa) {
		this.gpa = gpa;
	}
	public String getRevTitle() {
		return revTitle;
	}
	public void setRevTitle(String revTitle) {
		this.revTitle = revTitle;
	}
	public String getRevContent() {
		return revContent;
	}
	public void setRevContent(String revContent) {
		this.revContent = revContent;
	}
	public Date getRevRegdate() {
		return revRegdate;
	}
	public void setRevRegdate(Date revRegdate) {
		this.revRegdate = revRegdate;
	}
	
	
	
	
	
}