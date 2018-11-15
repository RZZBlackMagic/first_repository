package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import DAO.empDao;
import entity.emp;
import util.dbUtil;

public class rzz20180520 {
      /**
       * 批量增加108个员工
       */
      @Test
      public void test1(){
    	  Connection conn = null;
    	  try {
			conn = dbUtil.getConnection();
			conn.setAutoCommit(false);//取消自动提交
			String sql = "insert into emps values(emps_seq.nextval,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			for(int i=1;i<=108;i++){
				//将数据存到ps是、对象里面
				ps.setString(1, "任章哲"+i);
				ps.setString(2, "打劫"+i);
				ps.setInt(3, 0);
				ps.setDate(4,new java.sql.Date(System.currentTimeMillis()));
				ps.setDouble(5, 6666);
				ps.setDouble(6, 8888);
				ps.setInt(7, 2);
				ps.addBatch();//将数据暂存到ps'对象里面
				if( i%50==0){
					ps.executeBatch();
					ps.clearBatch();//清空ps中暂存数据，以便于下次更新
				}
			}
			//为了避免有零头，我们在外面多提交一次
			ps.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();//发现异常 据回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			dbUtil.close(conn);
		}
    	  
      }
      /**
       * 主要演示先增加一个部门在给此部门增加一个员工
       * 重点：增加部门后如何获取生成部门的ID
       */
    @Test
	public void test2(){
	     	Connection conn = null;
	     	//假设页面传入的部门信息是：
	     	String dname = "测试部";
	     	String loc = "杭州";
	     	//假设页面传入的员工数据是：
	     	String ename = "八戒";
	     	String job = "取经";
	     	int mgr = 0;
	     	Date hiredate = new Date(System.currentTimeMillis());
	     	double sal =5000.0;
	     	double comm = 1000.0;
	     	
	     	try {
				conn = dbUtil.getConnection();
				conn.setAutoCommit(false);
				String sql = "insert into depts values (depts_seq.nextval,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql,new String[]{"deptno"});
				//参数2是一个数组，用来告诉ps，需要他返回那些字段
                ps.setString(1,dname);
                ps.setString(2,loc);
                ps.executeUpdate();
//                从ps中获取生成的主键
                ResultSet rs = ps.getGeneratedKeys();
                //结果集当中包含一行一列。
                rs.next();
                int deptno = rs.getInt(1);//这种场景下的结果集只能通过字段的序号获取值，不能写字段名
                
                //增加一个员工
                String SQL="insert into emps values (emps_seq.nextval,?,?,?,?,?,?,?)";
                PreparedStatement PS = conn.prepareStatement(SQL);
                PS.setString(1, ename);
                PS.setString(2, job);
                PS.setInt(3, mgr);
                PS.setDate(4,hiredate);
                PS.setDouble(5, sal);
                PS.setDouble(6, comm);
                PS.setInt(7,deptno );
                PS.executeUpdate();
                conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				dbUtil.close(conn);
			}
	}
    @Test 
    public void test3(){
    	/**
    	 * 分页查询员工
    	 */
//    	假设需求还规定了每页显示十行 ：
    	int size = 10;
//    	假设用户要得到第三页的数据
    	int page =3 ;
    	Connection conn = null;
    	try {
			conn = dbUtil.getConnection();
			String sql = "select * from "
					+ "(select t.*,rownum r "
					+ "from(select * from "
					+ "emps order by empno) "
					+ "t)"
					+ " where r between ? and ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,(page-1)*size+1);
			ps.setInt(2,page*size);
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
    @Test
    /**
     * 1 先根据某个id查询一个员工
     * 2 修改此员工数据
     */
    public void test4(){
    	empDao d = new empDao();
    	emp e = d.findById(124);
        if(e!=null){
        	System.out.println(e.getEname());
        	e.setEname("任先生");
        	d.update(e);
        }
    }
    @Test
    public void test5(){
       Connection conn = null;
       try {
    	   
		conn = dbUtil.getConnection();
		conn.setAutoCommit(false);
		String sql ="insert into emps values(emps_seq.nextval,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		for(int i=0;i<10;i++){
			ps.setString(1, "任章哲"+i);
			ps.setString(2, "打劫"+i);
			ps.setInt(3, 0);
			ps.setDate(4,new java.sql.Date(System.currentTimeMillis()));
			ps.setDouble(5, 6666);
			ps.setDouble(6, 8888);
			ps.setInt(7, 2);
			ps.addBatch();
			if((i+1)%8==0){
				ps.executeBatch();
				ps.clearBatch();
			}
			ps.executeBatch();
			conn.commit();
	    }
       }catch (SQLException e) {
		e.printStackTrace();
		try {
			conn.rollback();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}finally{
		dbUtil.close(conn);
	}
    }
    @Test 
    public void test6(){
    	Connection conn = null;
    	int size = 10;
    	int page =5;
    	try {
			conn = dbUtil.getConnection();
			String sql = "select * from(select t.*,rownum rn from(select * from emps order by empno) t) where empno between ? and ?";
			int start = (page-1)*size+1;
			int end = page*size;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
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
    @Test 
    public void test7(){
    	Connection conn = null;
    	try {
			conn = dbUtil.getConnection();
			String sql = "insert into emps values(emps_seq.nextval,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			conn.setAutoCommit(false);
			for(int i=0;i<10;i++){
				ps.setString(1, "任先生"+i);
				ps.setString(2, "抢劫"+i);
				ps.setInt(3, 0);
				ps.setDate(4,new java.sql.Date(System.currentTimeMillis()));
				ps.setDouble(5, 6666);
				ps.setDouble(6, 8888);
				ps.setInt(7, 2);
				ps.addBatch();
				if((i+1)%8==0){
					ps.executeBatch();
					ps.clearBatch();
				}
				ps.executeBatch();
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			dbUtil.close(conn);
		}
    	
    }
    @Test 
    public void test8(){
    	Connection conn = null;
    	try {
			conn = dbUtil.getConnection();
			String sql = "delete from emps where empno>?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 6);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbUtil.close(conn);
		}
    	
    }
    @Test 
    public void test9(){
    	Connection conn = null;
    	try {
			conn = dbUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "insert into emps values(emps_seq.nextval,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			for( int i=0;i<50;i++){
				ps.setString(1, "任先生"+i);
				ps.setString(2, "抢劫"+i);
				ps.setInt(3, 0);
				ps.setDate(4,new java.sql.Date(System.currentTimeMillis()));
				ps.setDouble(5, 6666);
				ps.setDouble(6, 8888);
				ps.setInt(7, 2);
				ps.addBatch();
				if((i+1)%8==0){
					ps.executeBatch();
					ps.clearBatch();
				}
				ps.executeBatch();
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			dbUtil.close(conn);
		}
    }
    @Test 
    public void test10(){
         empDao d = new empDao();
         int id = 192;
         emp e = d.findById(id);
         System.out.println(e.getEname());
         System.out.println(e.getEmpno());
    }
    @Test 
    public void test11(){
    	Connection conn  = null;
    	try {
			conn = dbUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "delete from emps where empno =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 2);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			dbUtil.rollback(conn);
		}finally{
			dbUtil.close(conn);
		}
    }
    
    @Test
    public void test12(){
    	Connection conn = null;
    	try {
			conn = dbUtil.getConnection();
			String sql = "insert into emps values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 2);
			ps.setString(2, "任先生");
			ps.setString(3, "抢劫");
			ps.setInt(4, 0);
			ps.setDate(5,new java.sql.Date(System.currentTimeMillis()));
			ps.setDouble(6, 6666);
			ps.setDouble(7, 8888);
			ps.setInt(8, 2);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbUtil.close(conn);
		}
    }
    @Test 
    public void test13(){
    	
    }
    
    
    
    
    
    
    
    
    
}
