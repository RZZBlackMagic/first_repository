package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class dbUtil{
	
	private static BasicDataSource ds;
	static{
	    //读取参数
		Properties p = new Properties();
		try {
			p.load(dbUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			//读取参数
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String pwd = p.getProperty("pwd");
			String user = p.getProperty("user");
			String initsize = p.getProperty("initsize");
			String maxsize = p.getProperty("maxsize");
			//创建连接池
			ds = new BasicDataSource();
			//设置参数
			ds.setDriverClassName(driver);
			//注协驱动
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(pwd);
			//创建连接
			ds.setInitialSize(new Integer(initsize));
			ds.setMaxActive(new Integer(maxsize));
            //管理连接
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取失败",e);
		}
	}
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	public static void close(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("归还连接失败",e);
		}
	}
	public static void rollback(Connection conn){
		if(conn!=null){
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
