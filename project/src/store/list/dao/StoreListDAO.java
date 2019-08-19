package store.list.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import util.ConnectionFactory;
import util.ConnectionPool;
import util.SqlExecutor;
import vo.Store;
import vo.User;

public class StoreListDAO {

	public Map<Integer, Store> selectMap(String result) {
		Map<Integer, Store> priceList = new HashMap<>(); 
		int index = 1;
		Connection con = null;
		PreparedStatement pstmt = null;
		// 예외 처리코드
		try {
			System.out.println("Loading...");
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("  from store_tb");
			sql.append(" order by  ?  ");
			
			pstmt = con.prepareStatement(sql.toString()); // to.String안해줘도됨 문자열만
			pstmt.setString(index, result);
			
			ResultSet rs = pstmt.executeQuery();  // 끌어오는것 결곽가 여기에있다.
			while(rs.next()) {
				Store sto = new Store();
				sto.setStoNo(rs.getInt("sto_no"));
				sto.setStoName(rs.getString("sto_name"));
				sto.setRstMenu(rs.getString("RST_MENU"));
				sto.setRstPrice(rs.getInt("Rst_PRICE"));
				sto.setStoGpa(rs.getInt("sto_gpa"));
				
				priceList.put(index++, sto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return priceList;
	}
}
