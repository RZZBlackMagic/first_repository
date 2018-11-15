package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class dbUtil{
	
	private static BasicDataSource ds;
	static{
	    //��ȡ����
		Properties p = new Properties();
		try {
			p.load(dbUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			//��ȡ����
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String pwd = p.getProperty("pwd");
			String user = p.getProperty("user");
			String initsize = p.getProperty("initsize");
			String maxsize = p.getProperty("maxsize");
			//�������ӳ�
			ds = new BasicDataSource();
			//���ò���
			ds.setDriverClassName(driver);
			//עЭ����
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(pwd);
			//��������
			ds.setInitialSize(new Integer(initsize));
			ds.setMaxActive(new Integer(maxsize));
            //��������
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("��ȡʧ��",e);
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
			throw new RuntimeException("�黹����ʧ��",e);
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
