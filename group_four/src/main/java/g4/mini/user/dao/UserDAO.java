package g4.mini.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import g4.mini.vo.User;
import util.ConnectionFactory;
import util.ConnectionPool;
import util.SqlExecutor;

public class UserDAO {
	
	public void userLoiginDAO() {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select user_no ");
			sql.append("  from user_tb ");
			sql.append(" where user ");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	
	public void userJoinDAO(User user) {
		try {
			int cnt = SqlExecutor.update(
					"insert into member_tb(no, memberId, memberPass, memeberName, memberBirth)"
					+ "values( seq_memeber_no.nextval, ?, ?, ?, ?) ",
					user.getUserId(), user.getUserPass(), user.getUserName(), user.getUserBirth()
					);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void idMatching(String userId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select user_id ");
			sql.append("  from user_tb ");
			sql.append(" where user_id = ? ");
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, userId);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	
}
