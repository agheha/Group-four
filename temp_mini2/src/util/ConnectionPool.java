package util;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	private static final int INIT_COUNT = 3;
	private static List<Connection> free = new ArrayList<>();
	private static List<Connection> used = new ArrayList<>();
	
	// 연결시키는것은 1번...
	static { // 누군가 이클래스를 쓴다할때 1번만씀
		try {
		for(int i = 0; i < INIT_COUNT; i++) { // / 위에 이니카운터 3이라 3번반복
			free.add(ConnectionFactory.getConnection());
		}
		}catch(Exception e) {
			System.out.println("초기 연결풀 생성 에러 발생");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnetion() throws Exception{
		if(free.isEmpty()) {
			throw new Exception("사용할 수 있는 커넥션이 없습니다.");
		}
//		Connection con = free.get(0);
		Connection con = free.remove(0); // remove는 삭제할때 삭제 대상객체가 됨
//		free.remove(0);
		used.add(con);
		return con;
	}
	
	
	public static void releaseConnection(Connection con) {
		used.remove(con);
		free.add(con);
	}
	
	public static void main(String[] args) {
		try {
			// 10번 커넥션 요청(2초에 1번씩)
			for(int i = 1; i <= 10; i++) {
				Thread.sleep(2000); // 멈춰있다가 다시 재생된다.
				// 커넥션요청 커넥션을 관리해주는친구임
				Connection con = ConnectionPool.getConnetion();
				System.out.println(i + "번째 사용자 요청 : " + con);
				// 커넥션 툴쓸때 반드시 써야할것
				ConnectionPool.releaseConnection(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
