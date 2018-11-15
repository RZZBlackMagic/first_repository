package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import util.dbUtil;

public class rzz201808030 {
   @Test
   /*
    * 查询语句演示，用Statement对象执行查询语句
    */
   public void test(){
	  Connection conn = null;
	  try {
		conn=dbUtil.getConnection();
		Statement smt = conn.createStatement();
		String sql = "select * from emps";
		ResultSet rs = smt.executeQuery(sql);
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
   @Test
   /*
    * 利用preparedStatement对象执行查询语句
    */
   public void test1(){
	   Connection conn = null;
	   try {
		conn = dbUtil.getConnection();
		String sql ="select * from emps where empno>?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,3);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("ename"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		dbUtil.close(conn);
	}
   }
   @Test
   public void test2(){
      Connection conn = null;
      try {
		conn=dbUtil.getConnection();
		String sql = "update emps set ename =? where empno = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,"任章哲");
		ps.setInt(2,2);
		int row =ps.executeUpdate();
		System.out.println(row);
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		dbUtil.close(conn);
	}
   }
   @Test
   public void test4(){
	   Connection conn = null;
	   try {
		conn=dbUtil.getConnection();
		String sql = "select * from emps";
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		while(rs.next()){
			System.out.println(rs.getString("ename"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		dbUtil.close(conn);
	}
   }
   @Test
   public void test5(){
	   Connection conn = null;
	   try {
		conn = dbUtil.getConnection();
		conn.setAutoCommit(false);
		String  sql = "insert into emps values(emps_seq.nextval,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		for( int i=0;i<108;i++){
			ps.setString(1,"张哲"+i);
			ps.setString(2,"领导"+i);
			ps.setInt(3,1);
			ps.setDate(4,new java.sql.Date(System.currentTimeMillis()));
			ps.setDouble(5,5000.0);
			ps.setDouble(6,3000.0);
			ps.setInt(7,1);
			ps.addBatch();
			if(i%50==0){
				ps.executeBatch();
				ps.clearBatch();//清空ps中暂存数据，以便于下次更新	
			}
		}
		ps.executeBatch();
		conn.commit();
	} catch (SQLException e) {
		e.printStackTrace();
		dbUtil.rollback(conn);
	}finally{
		dbUtil.close(conn);
	}
   }
   @Test
   public void test3(){
	   Connection conn = null;
	   try {
		conn=dbUtil.getConnection();
		String sql = "select * from emps";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getInt("empno")+"  "+rs.getString("ename")+"  "+rs.getString("job")+"  "+rs.getInt("MGR")+"  "+rs.getDate("hiredate")+"  "+rs.getDouble("sal")+"  "+rs.getDouble("comm")+"  "+rs.getInt("deptno"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		dbUtil.close(conn);
	}
	   
   }
}






