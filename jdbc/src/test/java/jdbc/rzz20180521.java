package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import util.dbUtil;

public class rzz20180521 {
      @Test 
      public void test1(){
    	  Connection conn = null;
    	  try {
			conn = dbUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "select * from emps where empno > ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 4);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("ename"));
				System.out.println(rs.getInt("empno"));
			}
			
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			dbUtil.rollback(conn);
		}finally{
			dbUtil.close(conn);
		}
      }
}
