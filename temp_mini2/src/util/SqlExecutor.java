package util;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SqlExecutor {
	public static int update(String sql, Object ...args) throws Exception{
		// 달리지는거? 1.sql문 2.값이 달라짐
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnetion();			
			pstmt = con.prepareStatement(sql);
			int index = 1;
			for(Object arg : args) {
				pstmt.setObject(index++, arg);				
			}
			// 결과값에 대한처리
			return pstmt.executeUpdate();	
		}finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}
}
