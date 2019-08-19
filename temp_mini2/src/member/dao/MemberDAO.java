package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import login.vo.User;
import util.ConnectionFactory;
import util.ConnectionPool;
import util.SqlExecutor;
import vo.Store;

public class MemberDAO {
	public void insertReservation(User user) throws Exception {
			try {
				SqlExecutor.update(
					"insert into RESERVATION_TB(USER_NO, STO_NO, RSV_PERSON, RSV_DATE) values ('123456789', ?, ?, SYSDATE)", 
					user.getSto_no(), user.getReservationCnt()
				);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	public Store selectOneMember(int userNo) {
		List<Store> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		// 예외 처리코드
		try {
			con = ConnectionPool.getConnetion();
			String sql ="select * from store_tb where sto_no = ? ";
			
			pstmt = con.prepareStatement(sql); // to.String안해줘도됨 문자열만
			pstmt.setInt(1, userNo);
			ResultSet rs = pstmt.executeQuery();  // 끌어오는것 결곽가 여기에있다.
			
			Store tempUser = new Store();
			while(rs.next()) {
				tempUser.setStoNo(rs.getInt("STO_NO"));
				tempUser.setStoName(rs.getString("STO_NAME"));
				tempUser.setRstMenu(rs.getString("RST_MENU"));
				tempUser.setRstPrice(rs.getInt("RST_PRICE"));
			}
			return tempUser;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}
	
	public List<Store> selectMember() {
		List<Store> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		// 예외 처리코드
		try {
			System.out.println("Loading...");
			con = ConnectionPool.getConnetion();
			String sql ="select * from store_tb order by Rst_PRICE desc";
			
			pstmt = con.prepareStatement(sql); // to.String안해줘도됨 문자열만
			
			ResultSet rs = pstmt.executeQuery();  // 끌어오는것 결곽가 여기에있다.
			while(rs.next()) {
				Store user = new Store();
				user.setStoNo(rs.getInt("sto_no"));
				user.setStoName(rs.getString("sto_name"));
				user.setRstMenu(rs.getString("RST_MENU"));
				user.setRstPrice(rs.getInt("Rst_PRICE"));
				
				list.add(user);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}
	
	
	/*
	 * public int insertRes() { int cnt = 0; Connection con = null;
	 * PreparedStatement pstmt = null; // 예외 처리코드 try { con =
	 * ConnectionPool.getConnetion(); String sql
	 * ="select * from store_tb order by Rst_PRICE desc";
	 * 
	 * pstmt = con.prepareStatement(sql); // to.String안해줘도됨 문자열만 ResultSet rs =
	 * pstmt.executeUpdate(); // 끌어오는것 결곽가 여기에있다. return cnt; } catch (Exception e)
	 * { e.printStackTrace(); }finally { ConnectionFactory.close(pstmt);
	 * ConnectionPool.releaseConnection(con); } return null; }
	 */
	
}
