package manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionFactory;
import util.ConnectionPool;
import util.SqlExecutor;
import vo.Store;

public class ManagerDAO {
	public List<Store> selectManager() {
		List<Store> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		// 예외 처리코드
		try {
			System.out.println("Loading...");
			con = ConnectionPool.getConnetion();
			String sql ="select * from store_tb ";
			
			pstmt = con.prepareStatement(sql); // to.String안해줘도됨 문자열만
			
			ResultSet rs = pstmt.executeQuery();  // 끌어오는것 결곽가 여기에있다.
			while(rs.next()) {
				Store user = new Store();
				user.setStoNo(rs.getInt("sto_no"));
				user.setStoName(rs.getString("sto_name"));
				user.setRstMenu(rs.getString("RST_MENU"));
				user.setRstPrice(rs.getInt("Rst_PRICE"));
				user.setBitDistance(rs.getInt("BIT_DISTANCE"));
				
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
	
	
	public Store selectOneManager(int userNo) {
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
			if (rs.next()) {
				tempUser.setStoNo(rs.getInt("STO_NO"));
				tempUser.setStoName(rs.getString("STO_NAME"));
				tempUser.setRstMenu(rs.getString("RST_MENU"));
				tempUser.setRstPrice(rs.getInt("RST_PRICE"));
				tempUser.setBitDistance(rs.getInt("bitDistance"));				
			}
//			System.out.println("111" + tempUser.getStoNo());
			return tempUser;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}
	
	public void updateManager(Store store) {
		try {
			SqlExecutor.update(
				"update store_tb set STO_NAME = ?, RST_MENU = ?, RST_PRICE = ?, BIT_DISTANCE = ? "
				+ "where sto_no = ?", 
				store.getStoName(), 
				store.getRstMenu(), 
				store.getRstPrice(),
				store.getBitDistance(),
				store.getStoNo()
			);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int deleteManager(int no) {
		try {
			return SqlExecutor.update(
					"delete store_tb where sto_no = ?", no
			);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
