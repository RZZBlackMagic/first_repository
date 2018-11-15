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
    	//注冊驱动
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 System.out.println("kaishi连接");
			//创建连接
			 conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","my_oracle");
			 System.out.println("连接成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(conn!=null){
				conn.close();
			}else{
				System.out.println("哈哈");
			}
		}
    }
	/**
	 * 如何读取properties文件
	 * 1）使用java,util.properties类
	 * 2）它本质上就是Map
	 * 3）它专门是用来读取properties文件的
	 */
	@Test
    public void test2(){
		Properties p = new Properties();
		try {
			//使用classLoader从class下读取db.properties
			p.load(rzz20180513.class.getClassLoader().getResourceAsStream("db.properties"));
			String str = p.getProperty("driver");
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	System.out.println(2);
    }
	/**
	 * 测试dbTool.getConnection()
	 * 执行insert语句
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
					      +"'唐僧','经理',0,sysdate,"
			              +"8000.0,2000.0,3)";
			 int rows = s.executeUpdate(sql);//返回增加修改，删除，增加了几行
			 System.out.println(rows);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbTool.close(conn);
		}
		
	}
	/**
	 * 如何执行查询语句
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
			 * 返回resultSet时结果集
			 * 封装了查询到的结果（多行多列）
			 * 采用的是迭代器模式设计而来的
			 * 迭代器通常使用while遍历
			 */
			while(s.next()){//s.next()获取下一行数据
//				      获取该行的每一列的值
//				  s.get类型（字段的序号）
//				  s.get类型（字段的名称）
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
