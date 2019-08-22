package g4.mini.vo;

import java.sql.Date;

public class Reservation {

	private String userId; // 유저아이디
	private int stoNo; // 가게번호
	private int rsvPerson; // 예약인원
	private int rsvNo; // 대기번호
	private Date rsvDate; // 예약날짜
	private String stoName; //스토어이름
	
	
	
	public int getRsvNo() {
		return rsvNo;
	}
	public void setRsvNo(int rsvNo) {
		this.rsvNo = rsvNo;
	}
	public String getStoName() {
		return stoName;
	}
	public void setStoName(String stoName) {
		this.stoName = stoName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getResNo() {
		return rsvNo;
	}
	public void setResNo(int resNo) {
		this.rsvNo = resNo;
	}
	public int getStoNo() {
		return stoNo;
	}
	public void setStoNo(int stoNo) {
		this.stoNo = stoNo;
	}
	public int getRsvPerson() {
		return rsvPerson;
	}
	public void setRsvPerson(int rsvPerson) {
		this.rsvPerson = rsvPerson;
	}
	public Date getRsvDate() {
		return rsvDate;
	}
	public void setRsvDate(Date rsvDate) {
		this.rsvDate = rsvDate;
	}

	
	
	
	
}
