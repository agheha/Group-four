package vo;

import java.util.Date;

public class Review {
	private String userId ;
	private int stoNo;
	private int revNo;
	private double gpa;
	private String revComment ;
	private Date revRegdate;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public String getRevComment() {
		return revComment;
	}
	public void setRevComment(String revComment) {
		this.revComment = revComment;
	}
	public Date getRevRegdate() {
		return revRegdate;
	}
	public void setRevRegdate(Date revRegdate) {
		this.revRegdate = revRegdate;
	}
	
	
	
	
	
}