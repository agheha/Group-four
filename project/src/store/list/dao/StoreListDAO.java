package store.list.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionFactory;
import util.ConnectionPool;
import vo.Store;

public class StoreListDAO {
	List<Store> priceList = new ArrayList<>(); 
	List<Store> typeList = new ArrayList<>(); 
	List<Store> gpaList = new ArrayList<>(); 
	List<Store> distanceList = new ArrayList<>(); 
	List<Store> acRevList = new ArrayList<>(); 

	public List<Store> priceList(int startPrice, int endPrice) {
		Connection con = null;
		PreparedStatement pstmt = null;
		// 예외 처리코드
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("  from store_tb ");
			sql.append(" where rst_price between ? and ?");
			sql.append(" order by rst_price ");
			
			pstmt = con.prepareStatement(sql.toString()); 
			int index = 1;
			pstmt.setInt(index++, startPrice);
			pstmt.setInt(index++, endPrice);
			
			ResultSet rs = pstmt.executeQuery();  
			storeInfo(rs, priceList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return priceList;
	}
	
	public List<Store> typeList(String type) {
		Connection con = null;
		PreparedStatement pstmt = null;
		// 예외 처리코드
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("  from store_tb");
			sql.append(" where sto_type = ? ");
			sql.append(" order by sto_type");
			
			pstmt = con.prepareStatement(sql.toString()); 
			int index = 1;
			pstmt.setNString(index, type);
		
			ResultSet rs = pstmt.executeQuery();  
			storeInfo(rs, typeList);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return typeList;
	}
	
	public List<Store> gpaList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		// 예외 처리코드
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("  from store_tb");
			sql.append(" order by sto_gpa");
			pstmt = con.prepareStatement(sql.toString()); 
			ResultSet rs = pstmt.executeQuery();  
			storeInfo(rs, gpaList);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return gpaList;
	}
	
	public List<Store> distanceList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		// 예외 처리코드
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("  from store_tb");
			sql.append(" order by bit_distance");
			pstmt = con.prepareStatement(sql.toString()); 
			ResultSet rs = pstmt.executeQuery();  
			storeInfo(rs, distanceList);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return distanceList;
	}
	
	public List<Store> acRevList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("  from store_tb ");
			sql.append(" order by ACC_RESERVATION ");
			pstmt = con.prepareStatement(sql.toString()); 
			ResultSet rs = pstmt.executeQuery();  
			storeInfo(rs, acRevList);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return acRevList;
	}
	
	public List<Store> storeInfo(ResultSet rs, List<Store> list)throws Exception{
		while(rs.next()) {
			Store sto = new Store();
			sto.setStoNo(rs.getInt("sto_no"));
			sto.setStoId(rs.getString("sto_id"));
			sto.setStoPass(rs.getString("sto_pass"));
			sto.setStoName(rs.getString("sto_name"));
			sto.setRstMenu(rs.getString("RST_MENU"));
			sto.setRstPrice(rs.getInt("Rst_PRICE"));
			sto.setStoType(rs.getString("sto_type"));
			sto.setBitDistance(rs.getInt("bit_distance"));
			sto.setStoGpa(rs.getInt("sto_gpa"));
			sto.setStoAddr(rs.getString("sto_addr"));
			sto.setStoHours(rs.getString("sto_hours"));
			sto.setStoPhoneNumber(rs.getString("sto_phone_number"));
			sto.setStoSeat(rs.getInt("sto_seat"));
			sto.setStoNowSeat(rs.getInt("sto_now_seat"));
			sto.setBitPosition(rs.getInt("bit_position"));
			sto.setAccReservation(rs.getInt("acc_reservation"));
			
			list.add(sto);
		}
		return list;
	}
}
