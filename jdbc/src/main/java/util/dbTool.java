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
		try {//���أ���ȡ��db.properties(�����ļ�)
			p.load(dbTool.class.getClassLoader().getResourceAsStream("db.properties"));
			//�������Ӳ���,ͨ��key��value
			driver=p.getProperty("driver");
			url=p.getProperty("url");
			user=p.getProperty("user");
			pwd=p.getProperty("pwd");
            //ע������
			try {
				Class.forName(driver);//ע������
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("�Ҳ����������",e);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("����db.propertiesʧ��",e);
		}
	}
	public static Connection getConnection() throws SQLException{//���ﾡ��ȡ���쳣����Ҫtry-catch�����������쳣���������ڵ��õ�ʱ���Ҫȥtry-catch����Ϊ���������������������ص���Ҫ��finally��ִ�У����Ը�����������ѡ��������ˣ����ݿ�������
		//��������
		Connection conn = DriverManager.getConnection(url,user,pwd);
		return conn;
	}
    public static void close(Connection conn){
    	if(conn!=null){
    		try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�ر�����ʧ��",e);
			}
    	}
    }
}
