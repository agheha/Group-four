package kr.co.mlec.domain;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Member {
	private String id;
	private String name;
	private String addr;
	private String email;
	private Date joinDate;
	private String [] addrs;
	private List<String> addrs2;
	
	private Account account;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email= email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id= id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name= name;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String[] getAddrs() {
		return addrs;
	}
	public void setAddrs(String [] addrs) {
		this.addrs = addrs;
	}
	
	public List<String> getAddrs2() {
		return addrs2;
	}
	public void setAddrs2(List<String> addrs2) {
		this.addrs2 = addrs2;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", addr=" + addr + ", email=" + email + ", joinDate=" + joinDate
				+ ", addrs=" + Arrays.toString(addrs) + ", addrs2=" + addrs2 + ", account=" + account + "]";
	}
	
}