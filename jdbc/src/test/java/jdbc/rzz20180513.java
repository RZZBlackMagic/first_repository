package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;

import util.dbTool;

public class rzz20180513 {
	@Test
    public void test1() throws  SQLException{
    	System.out.println(1);
    	Connection conn = null;
    	//ע������
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 System.out.println("kaishi����");
			//��������
			 conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","my_oracle");
			 System.out.println("���ӳɹ�");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(conn!=null){
				conn.close();
			}else{
				System.out.println("����");
			}
		}
    }
	/**
	 * ��ζ�ȡproperties�ļ�
	 * 1��ʹ��java,util.properties��
	 * 2���������Ͼ���Map
	 * 3����ר����������ȡproperties�ļ���
	 */
	@Test
    public void test2(){
		Properties p = new Properties();
		try {
			//ʹ��classLoader��class�¶�ȡdb.properties
			p.load(rzz20180513.class.getClassLoader().getResourceAsStream("db.properties"));
			String str = p.getProperty("driver");
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	System.out.println(2);
    }
	/**
	 * ����dbTool.getConnection()
	 * ִ��insert���
	 */
	@Test
	public void test3(){
		Connection conn = null;
		try {
			 conn = dbTool.getConnection();
			 System.out.println(conn);
			 Statement s = conn.createStatement();
			 //SQL
			 String sql = "insert into emps values("
			              +"emps_seq.nextval,"
					      +"'��ɮ','����',0,sysdate,"
			              +"8000.0,2000.0,3)";
			 int rows = s.executeUpdate(sql);//���������޸ģ�ɾ���������˼���
			 System.out.println(rows);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbTool.close(conn);
		}
		
	}
	/**
	 * ���ִ�в�ѯ���
	 */
	@Test
	public void test4(){
		Connection conn = null;
		try {
			conn = dbTool.getConnection();
			Statement stm = conn.createStatement();
			String str = "SELECT * FROM EMPS";
			ResultSet s = stm.executeQuery(str);
			/**
			 * ����resultSetʱ�����
			 * ��װ�˲�ѯ���Ľ�������ж��У�
			 * ���õ��ǵ�����ģʽ��ƶ�����
			 * ������ͨ��ʹ��while����
			 */
			while(s.next()){//s.next()��ȡ��һ������
//				      ��ȡ���е�ÿһ�е�ֵ
//				  s.get���ͣ��ֶε���ţ�
//				  s.get���ͣ��ֶε����ƣ�
				System.out.println(s.getInt("empno"));
				System.out.println(s.getString("ename"));
			}
			System.out.println(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbTool.close(conn);
		}
	}
}
