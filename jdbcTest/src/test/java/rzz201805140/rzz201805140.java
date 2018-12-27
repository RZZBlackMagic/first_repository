package rzz201805140;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import utilTest.dbToolTest;

public class rzz201805140 {
	@Test
    public void test1(){
		Connection conn = null;
        try {
			 conn = dbToolTest.getConnection();
			 System.out.println(1);
			 Statement s = conn.createStatement();
			 String Str ="Select * from emps";
             ResultSet rs =  s.executeQuery(Str);
             while(rs.next()){
            	 String ename = rs.getString("ename");
                 int empno = rs.getInt("empno");
                 System.out.println(ename);
    			 System.out.println(empno);
             }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbToolTest.close(conn);
		}
    }
	@Test
	public void test2(){
		Connection conn =null;
		try {
			 conn = dbToolTest.getConnection();
			Statement s = conn.createStatement();
			String str = "Select * from emps";
			ResultSet rs = s.executeQuery(str);
			while(rs.next()){
				String name = rs.getString("ename");
				int empno = rs.getInt("empno");
				System.out.println(name);
				System.out.println(empno);
			}
		} catch (SQLException e) {
			System.out.println("连接失败");
			e.printStackTrace();
		}finally{
			dbToolTest.close(conn);
		}
	}
	@Test
	public void Test3(){
		Connection conn = null;
		try {
			conn=dbToolTest.getConnection();
			Statement s = conn.createStatement();
			String sql = "";
		} catch (SQLException e) {
            System.out.println("连接失败！");
			e.printStackTrace();
		}finally{
			dbToolTest.close(conn);
		}
	}
}
