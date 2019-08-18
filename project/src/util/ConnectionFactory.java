package util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class ConnectionFactory {
	public static Connection getConnection() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileReader("src/User/util/db.properties"));
		
		Class.forName(prop.getProperty("driver"));
		return DriverManager.getConnection(
				prop.getProperty("url"), 
				prop.getProperty("username"),
				prop.getProperty("password")
				);
	}
	
	public static void close(Connection con, PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch(Exception e) {
			
		}
		try {
			con.close();
		} catch (Exception e) {
			
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		close(null, pstmt);
	}
	
	
	 
	
	
}



