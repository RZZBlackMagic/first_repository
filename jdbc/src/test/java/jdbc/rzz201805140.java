package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import util.dbTool;

public class rzz201805140 {
    @Test
    public void DMLtest(){//DMLÓï¾ä
    	Connection conn = null;
    	try {
			conn = dbTool.getConnection();
			Statement s = conn.createStatement();
			System.out.println(100);
			 String sql = "select * from users where username ='tarena' and password = 'a' or'b'='b'";			
			ResultSet  rs = s.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString("username"));
				System.out.println(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbTool.close(conn);
		}
    }
    @Test
    public void DQltest(){
    	Connection conn = null;
    	try {
			conn = dbTool.getConnection();
			Statement s = conn.createStatement();
			String sql = "select * from emps";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString("ename"));
				System.out.println(rs.getInt("empno"));
				System.out.println(rs.getRow());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbTool.close(conn);
		}
    }
}
