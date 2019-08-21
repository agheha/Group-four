package kr.co.mlec.domain;

import java.util.Date;

public class Account {
	private String id;
	private int money;
	private Date openDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", money=" + money + ", openDate=" + openDate + "]";
	}
	
}
