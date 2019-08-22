package util;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	private static final int INIT_COUNT = 3;
	private static List<Connection> free = new ArrayList<>();
	private static List<Connection> used = new ArrayList<>();
	
	static {
		try {
			for (int i = 0 ; i < INIT_COUNT ; i++) {
				free.add(ConnectionFactory.getConnection());
			}

		} catch (Exception e) {
			System.out.println("초기 연결풀 생성 에러 발생");
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection() throws Exception{
		if (free.isEmpty()) {
			throw new Exception("사용할수 있는 커넥션이 없습니다.");
		} 
		Connection con = free.remove(0);
		used.add(con);
		return con;
	}
	
	public static void releaseConnection(Connection con) {
		used.remove(con);
		free.add(con);
	}
	
	public static void main(String[] args) {
		try {
			for (int i = 1 ; i <= 10; i++) {
				Thread.sleep(2000);
				Connection con = ConnectionPool.getConnection();
				System.out.println(i + "번째 사용자요청 : " + con);
				ConnectionPool.releaseConnection(con);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
