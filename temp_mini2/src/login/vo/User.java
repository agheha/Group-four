package login.vo;

public class User { // 테이블이있음 user가있어야함
	
	 // 가게번호 
	 private int sto_no;
	
	 // 가게아이디
	 private String sto_id;
	
	 // 가게비밀번호 
	 private String sto_pass;
	
	 // 가게이름 
	 private String sto_name;
	
	 // 대표메뉴 
	 private String rst_Menu;
	
	 // 대표가격
	 private int rst_price;
	
	 // 가게타입
	 private String sto_type;
	
	 // 거리
	 private String bit_distance;
	 
	 // 가게평점 
	 private String sto_gpa;
	
	 // 가게주소 
	 private int sto_addr;
	
	 // 가게영업시간
	 private String sto_hours;
	
	 // 가게전화번호
	 private String sto_phone_number;
	
	 // 가게좌석수
	 private String sto_seat;	 
	 
	 // 현재좌석수 
	 private int sto_now_seat;
	
	 // 비트캠프위치
	 private String bit_position;
	
	 // 누적예약수
	 private String acc_reservation;

	 //예약인원수
	 private int reservationCnt;
	 
	 
	 
	public int getReservationCnt() {
		return reservationCnt;
	}

	public void setReservationCnt(int reservationCnt) {
		this.reservationCnt = reservationCnt;
	}

	public int getSto_no() {
		return sto_no;
	}

	public void setSto_no(int sto_no) {
		this.sto_no = sto_no;
	}

	public String getSto_id() {
		return sto_id;
	}

	public void setSto_id(String sto_id) {
		this.sto_id = sto_id;
	}

	public String getSto_pass() {
		return sto_pass;
	}

	public void setSto_pass(String sto_pass) {
		this.sto_pass = sto_pass;
	}

	public String getSto_name() {
		return sto_name;
	}

	public void setSto_name(String sto_name) {
		this.sto_name = sto_name;
	}

	public String getRst_Menu() {
		return rst_Menu;
	}

	public void setRst_Menu(String rst_Menu) {
		this.rst_Menu = rst_Menu;
	}

	public int getRst_price() {
		return rst_price;
	}

	public void setRst_price(int rst_price) {
		this.rst_price = rst_price;
	}

	public String getSto_type() {
		return sto_type;
	}

	public void setSto_type(String sto_type) {
		this.sto_type = sto_type;
	}

	public String getBit_distance() {
		return bit_distance;
	}

	public void setBit_distance(String bit_distance) {
		this.bit_distance = bit_distance;
	}

	public String getSto_gpa() {
		return sto_gpa;
	}

	public void setSto_gpa(String sto_gpa) {
		this.sto_gpa = sto_gpa;
	}

	public int getSto_addr() {
		return sto_addr;
	}

	public void setSto_addr(int sto_addr) {
		this.sto_addr = sto_addr;
	}

	public String getSto_hours() {
		return sto_hours;
	}

	public void setSto_hours(String sto_hours) {
		this.sto_hours = sto_hours;
	}

	public String getSto_phone_number() {
		return sto_phone_number;
	}

	public void setSto_phone_number(String sto_phone_number) {
		this.sto_phone_number = sto_phone_number;
	}

	public String getSto_seat() {
		return sto_seat;
	}

	public void setSto_seat(String sto_seat) {
		this.sto_seat = sto_seat;
	}

	public int getSto_now_seat() {
		return sto_now_seat;
	}

	public void setSto_now_seat(int sto_now_seat) {
		this.sto_now_seat = sto_now_seat;
	}

	public String getBit_position() {
		return bit_position;
	}

	public void setBit_position(String bit_position) {
		this.bit_position = bit_position;
	}

	public String getAcc_reservation() {
		return acc_reservation;
	}

	public void setAcc_reservation(String acc_reservation) {
		this.acc_reservation = acc_reservation;
	}

}
