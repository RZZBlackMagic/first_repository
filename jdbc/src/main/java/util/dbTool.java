package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class dbTool {

	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;
	static{
		Properties p = new Properties();
		try {//加载（读取）db.properties(配置文件)
			p.load(dbTool.class.getClassLoader().getResourceAsStream("db.properties"));
			//加载连接参数,通过key读value
			driver=p.getProperty("driver");
			url=p.getProperty("url");
			user=p.getProperty("user");
			pwd=p.getProperty("pwd");
            //注册驱动
			try {
				Class.forName(driver);//注册驱动
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("找不到这个驱动",e);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("加载db.properties失败",e);
		}
	}
	public static Connection getConnection() throws SQLException{//这里尽量取抛异常，不要try-catch，在这里抛异常，调用者在调用的时候就要去try-catch，因为我嗯这个连接在用完后必须关掉，要在finally中执行，可以给调用者提个醒。以免忘了，数据库会崩溃的
		//创建连接
		Connection conn = DriverManager.getConnection(url,user,pwd);
		return conn;
	}
    public static void close(Connection conn){
    	if(conn!=null){
    		try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭连接失败",e);
			}
    	}
    }
}
