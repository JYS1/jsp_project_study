package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	
	public static Connection getConnection() {
		Connection conn = null;
		
		
		
		Properties p = new Properties();
		
		try {
			p.load(new FileInputStream("c:/lib/dbinfo.txt"));
			
			String driver = p.getProperty("_driver");
			String url = p.getProperty("_url");
			String user = p.getProperty("_user");
			String password = p.getProperty("_password");
			
			
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url,user,password);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
	public static void close(Connection conn, Statement st , ResultSet rs) {	// 반납할곳
		
		try {
			if(rs != null) rs.close();
			if(st != null) st.close();
			if(conn != null) conn.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
