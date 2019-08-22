package login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import user.util.ConnectionFactory;
import user.util.ConnectionPool;
import user.vo.User;

public class LoginDAO {
	
	public User userLogin(User u) {
		Connection con = null;
		PreparedStatement pstmt = null;
		User result = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("  from user_tb ");
			sql.append(" where user_id = ? ");
			sql.append("   and user_pass = ? ");
			pstmt = con.prepareStatement(sql.toString());
			
			// ui로부터 넘겨받은 user객체의 아이디와 비번을 쿼리문에 넣어준다.
			pstmt.setString(1, u.getUserId());
			pstmt.setString(2, u.getUserPass());
			
			// 쿼리문을 통해 DB에서 찾아낸 결과를 rs에 담는다.
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// 새 객체에 결과를 차곡차곡 담아준다!
				User login = new User();
				login.setUserNo(rs.getInt("user_no"));
				login.setUserId(rs.getString("user_id"));
				login.setUserPass(rs.getString("user_pass"));
				login.setUserName(rs.getString("user_name"));
				login.setUserBirth(rs.getString("user_birth"));
				result = login;
			} else {
				System.out.println("검색 결과가 없습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return result;
	}
}
