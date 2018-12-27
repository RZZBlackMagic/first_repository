package utilTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class dbToolTest {
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;

      static{
          Properties p = new Properties();
          try {
			p.load(dbToolTest.class.getClassLoader().getResourceAsStream("dbTest.properties"));
			driver = p.getProperty("driver");
			url = p.getProperty("url");
			user = p.getProperty("user");
			pwd = p.getProperty("pwd");

			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("◊¢≤·«˝∂Ø ß∞‹",e);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("º”‘ÿ ß∞‹",e);
		}
      }
      public static Connection getConnection() throws SQLException{
    	  Connection conn = DriverManager.getConnection(url, user, pwd);
    	  return conn;
      }
      public static void close(Connection conn){
    	  if(conn!=null){
    		  try {
    				conn.close();
    			} catch (SQLException e) {
    				e.printStackTrace();
    				throw new RuntimeException("πÿ±’ ß∞‹",e);
    			}
    	  }
    	
      }
}
