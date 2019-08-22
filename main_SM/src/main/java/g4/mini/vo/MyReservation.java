package g4.mini.vo;

import java.util.Date;

public class MyReservation {

	private String userId;
	private int stoNo;
	private String stoName;
	private Date rsv_date;
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
	public String getStoName() {
		return stoName;
	}
	public void setStoName(String stoName) {
		this.stoName = stoName;
	}
	public Date getRsv_date() {
		return rsv_date;
	}
	public void setRsv_date(Date rsv_date) {
		this.rsv_date = rsv_date;
	}
	
	
}
