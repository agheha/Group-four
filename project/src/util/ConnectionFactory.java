package util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class ConnectionFactory {
	public static Connection getConnection() throws Exception{
		Properties prop = new Properties();
		prop.load(new FileReader("src/util/db.properties"));
		Class.forName(prop.getProperty("driver"));
		return DriverManager.getConnection(
				prop.getProperty("url"),
				prop.getProperty("username"),
				prop.getProperty("password"));
	}
	public static void close(Connection con, PreparedStatement pstmt) {
		try {pstmt.close();	} catch (Exception e) {}
		try {con.close();	} catch (Exception e) {}
	}
	
	public static void main(String[] args) throws Exception{
		// db.properties 파일을 읽기 위해서 클래스 생성
		Properties prop = new Properties();
		// db.properties 인식시키기
		prop.load(new FileReader("src/util/db.properties"));
		// 데이터 추출하기
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}
	public static void close(PreparedStatement pstmt) {
		close(null, pstmt);
	}
}
