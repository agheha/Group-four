package g4.mini.store.info.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import g4.mini.session.LoginStatus;
import g4.mini.session.StoreSearchStatus;
import g4.mini.vo.Review;
import g4.mini.vo.StoreMenu;

public class StoreInfoDAO {
	List<StoreMenu> menuList = new ArrayList<>();
	List<Review> revList = new ArrayList<>();
	
	int storeNo = StoreSearchStatus.store.getStoNo();
	public int showMenuList;
	
	
	public List<Review> selectReview() {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("  from review_tb ");
			sql.append(" where sto_no = ? ");
			sql.append(" order by rev_no ");
			
			pstmt = con.prepareStatement(sql.toString());
			int index = 1;
			pstmt.setInt(index++, storeNo);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Review review = new Review();
				review.setRevNo(rs.getInt("rev_no"));
				review.setUserId(rs.getString("user_id"));
				review.setGpa(rs.getDouble("gpa"));
				review.setRevComment(rs.getString("rev_comment"));
				review.setRevRegdate(rs.getDate("rev_reg_date"));
				
				revList.add(review);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		
		return revList;
	}
	
	// 리뷰 테이블에 입력 
	public void insertReview(Review rev) {
		String userId = LoginStatus.login.getUserId();
		try {
			SqlExecutor.update(
					"insert into review_no(sto_no, user_no, rev_no, gpa, rev_content) "
					+ "values (?, ?, seq_review_no.nextval, ?, ?) ",
					storeNo, userId, rev.getGpa(), rev.getRevComment()
			);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	public void updateReview(double gpa) {
		try {
			SqlExecutor.update(
					"update store_tb set STO_GPA = ? where sto_no = ? ",
					gpa, storeNo
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void gpaAvg(int storeNo, double gpa){

		int count = 1;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select sto_gpa ");
			sql.append("  from review_tb ");
			sql.append(" where sto_no = ? ");
			pstmt = con.prepareStatement(sql.toString());
			int index = 1;
			pstmt.setInt(index++, storeNo);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				gpa += rs.getDouble("gpa");
				count++;
			}
			updateReview(gpa/count);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	public List<StoreMenu> selectMenu(){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("");
			sql.append("");
			sql.append("");
			
			pstmt = con.prepareStatement(sql.toString());
			int index = 1;
			pstmt.setInt(index, storeNo);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				StoreMenu m = new StoreMenu();
				m.setStoNo(rs.getInt("sto_no"));
				m.setStoMenu(rs.getString("menu"));
				m.setstoMenu(r
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menuList;
	}
}

