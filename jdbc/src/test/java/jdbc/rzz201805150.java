package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import util.dbUtil;

public class rzz201805150 {
	/**
	 * ≤‚ ‘db.Util∑Ω∑®
	 * 
	 */
     @Test
     public void test1(){
    	 Connection conn = null;
    	 try {
			conn = dbUtil.getConnection();
			System.out.println(conn);
			Statement smt = conn.createStatement();
			String str = "SELECT * FROM EMPS";
			ResultSet rs = smt.executeQuery(str);
			while(rs.next()){
			     System.out.println(rs.getString("ename"));
			     System.out.println(rs.getInt("empno"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbUtil.close(conn);
		}
    	 
     }
}
