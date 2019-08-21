package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import session.LoginStatus;
import user.util.ConnectionFactory;
import user.util.ConnectionPool;
import user.util.SQLExecutor;
import user.vo.User;

public class UserDAO {
	
	
	
	//회원가입
	public void userJoinDAO(User user) {
		try {
			SQLExecutor.update(
					"insert into user_tb(no, user_id, user_pass, user_name, user_birth)"
					+ "values( seq_user_no.nextval, ? , ? , ? , ?)  ",
					user.getUserId(), user.getUserPass(), user.getUserName(), user.getUserBirth()
					);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 회원가입시 아이디 일치여부만 boolean값으로 반환하는 메서드
	public boolean idMatching(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" select * ");
			sql.append("   from user_tb ");
			sql.append("  where user_id in ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println(rs.next());
			// 입력한 아이디에 대한 값이 있을 경우 true를, 없을경우 false를 반환
			return rs.next();
			
			
		} catch (Exception e) {
			
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return false;
	}
	
	// 회원번호를 받아 user객체를 반환하는 메서드
	public User selectOneUser(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" select * ");
			sql.append("   from user_tb ");
			sql.append("  where user_no = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			
			ResultSet rs = pstmt.executeQuery();
			
			 rs.next();
			
			 User user = new User();
			 user.setUserNo(rs.getInt("user_no"));
			 user.setUserId(rs.getString("user_id"));
			 user.setUserPass(rs.getString("user_pass"));
			 user.setUserBirth(rs.getString("user_birth"));
			 return user;
			
		} catch (Exception e) {
			
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}
	
	
	// 비밀번호 변경하는 메서드
	public void passUpdate(int no, String pass) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			SQLExecutor.update(
					"UPDATE user_tb   " + 
					  " SET title = ? " +
				    " WHERE no = ? ",
					no, pass
					);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	// 회원 탈퇴
	public void deleteUser(int no) {
		try {
			SQLExecutor.update(
					"DELETE  from user_tb " +
					       "where no = ?", 
					no
					);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		LoginStatus.login = null;
	}

	}
	

