package review.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import session.LoginStatus;
import util.ConnectionFactory;
import util.ConnectionPool;
import util.SqlExecutor;
import vo.Review;

public class ReviewDAO {
	List<Review> list = new ArrayList<>();
	
	
	public List<Review> selectReview() {
		Connection con = null;
		PreparedStatement pstmt = null;
		List<Review> list = new ArrayList<>();
		try {
			con = ConnectionPool.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("  from review_tb");
			sql.append(" where sto_no = ? ");
			sql.append(" order by rev_no desc ");
			int index = 1;
			// 스태틱 클래스 변수에 번호를 입력
			pstmt.setInt(index++, LoginStatus.store.getStoNo());
			pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Review review = new Review();
				review.setStoNo(rs.getInt("sto_no"));
				review.setUserNo(rs.getInt("user_no"));
				review.setRevNo(rs.getInt("rev_no"));
				review.setGpa(rs.getInt("gpa"));
				review.setRevTitle(rs.getString("rev_title"));
				review.setRevContent(rs.getString("rev_content"));
				review.setRevRegdate(rs.getDate("rev_reg_date"));
				
				list.add(review);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		
		return list;
	}
	
	// 리뷰 테이블에 입력 
	public void insertReview(Review rev) {
		try {
			SqlExecutor.update(
					"insert into review_no(sto_no, user_no, rev_no, gpa, rev_title, rev_content) values (?, ?, seq_review_no, ?, ?, ?) ",
					rev.getStoNo(), rev.getUserNo(), rev.getGpa(), rev.getRevTitle(),rev.getRevContent()
			);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
