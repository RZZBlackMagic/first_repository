package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import util.dbUtil;

public class preparedStatementTest {
      @Test
      public void test1(){
    	  Connection conn = null;
    	  try {
			 conn = dbUtil.getConnection();
			 String sql = "SELECT * FROM EMPS where empno= ?";
			 PreparedStatement ps = conn.prepareStatement(sql);
			 //创建ps对象，并让他自动发送SQL
//			 ps.setString(1, " ");
			 ps.setInt(1, 2);
			 //ps.set类型(a,b);a为？的序号，b为a对应的？的值。
			 ps.executeUpdate();
			 //向数据库发送参数，并让数据库执行SQL，返回值为更新的行数
             ResultSet rs = ps.executeQuery();
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
