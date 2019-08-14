package user;

import java.sql.Connection;
import java.sql.PreparedStatement;

import user.util.ConnectionFactory;
import user.util.ConnectionPool;
import user.util.SQLExecutor;

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
			int cnt = SQLExecutor.update(
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
