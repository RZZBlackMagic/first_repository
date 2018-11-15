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
			 //����ps���󣬲������Զ�����SQL
//			 ps.setString(1, " ");
			 ps.setInt(1, 2);
			 //ps.set����(a,b);aΪ������ţ�bΪa��Ӧ�ģ���ֵ��
			 ps.executeUpdate();
			 //�����ݿⷢ�Ͳ������������ݿ�ִ��SQL������ֵΪ���µ�����
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
