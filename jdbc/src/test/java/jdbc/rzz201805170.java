package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import util.dbUtil;

public class rzz201805170 {
  @Test 
  public void test1(){
	  Connection conn = null;
	  try {
		conn = dbUtil.getConnection();
		String sql = "select * from users where username = ? and password = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "tarena");
        ps.setString(2,"a' or 'b' = 'b");
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			System.out.println("登录成功");
		}else{
			System.out.println("登录失败");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		dbUtil.close(conn);
	}
  }
  /**
   * ResultSetMetaData
   */
  @Test
  public void test2(){
      Connection conn = null;
      try {
		conn = dbUtil.getConnection();
		String sql = " select * from emps ";
		Statement smt = conn.createStatement();
		ResultSet rs = smt.executeQuery(sql);
		//获取结果集的元数据。
		ResultSetMetaData rsmd = rs.getMetaData();
		//元数据中封装了结果集的描述信息，并不是具体的数据
		int row = rsmd.getColumnCount();//获取数据的列数
		while(rs.next()){
			String str = rs.getString("ename");
			int id = rs.getInt("empno");
			System.out.println(str);
			System.out.println(id);
		}
		
		
//		System.out.println(row);
//		System.out.println(rsmd.getColumnTypeName(2));//输出第二列的参数类型
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		dbUtil.close(conn);
	}
      
  }
  /**
   * 模拟转账业务
   * 前提：
   *    假设用户已经登录了网银，
   *    并且输入例如收款方的账号和收款的金额
   *    
   *    步骤：
   *       1 查询付款账号，看余额够不够
   *       2 查询收款账号，看账号对不对
   *       3 修改付款金额，金额-N
   *       4 修改收款金额，金额+N
   *       
   *       注意：转账是一个完整的业务，要使用一个连接，保障只有一个事务。
   */
  @Test
  
  public void test3(){
	  //假设用户登录的账号是：
	  String payId = "00001";
	  //假设他输入的收款账号是：
	  String recId = "00002";
	  //假设他输入的转账金额是：
	  double money = 1000.0;
	  Connection conn = null;
	  try {
		conn = dbUtil.getConnection();
//		   1 查询付款账号，看余额够不够
        String sql1 = "select * from accounts where id = ? ";
        PreparedStatement ps1 = conn.prepareStatement(sql1);
        ps1.setString(1, payId);
        ResultSet rs1 = ps1.executeQuery();//得到的数据时我们目标数据的上一行
        rs1.next();//让rs指向目标数据。
        double payMoney = rs1.getDouble("money");
        if(payMoney<money){
        	System.out.println("余额不足！");
        	return;
        }
//               2 查询收款账号，看账号对不对
        String sql2 = "select *from accounts where id = ?";
        PreparedStatement ps2 = conn.prepareStatement(sql2);
        ps2.setString(1, recId);
        ResultSet rs2 = ps2.executeQuery();
        double recMoney = 0; 
        if(!rs2.next()){
        	System.out.println("收款账号错误！");
        	return;
        }else{
        	 recMoney = rs2.getDouble("money");
        }
//               3 修改付款金额，金额-N
        String sql3 = "update accounts set money = ? where id = ?";
        PreparedStatement ps3 = conn.prepareStatement(sql3);
        ps3.setDouble(1, payMoney-money);
        ps3.setString(2, payId);
        ps3.executeUpdate();
//        *       4 修改收款金额，金额+N
        String sql4 = "update accounts set money = ? where id = ?";
        PreparedStatement ps4 = conn.prepareStatement(sql4);
        ps4.setDouble(1, recMoney+money);
        ps4.setString(2, recId);
        ps4.executeUpdate();

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

		conn = dbUtil.getConnection();
		String str = "select * from accounts";
		Statement s = conn.createStatement();

		ResultSet rs = s.executeQuery(str);

		while(rs.next()){

			System.out.println(rs.getDouble("money"));
			System.out.println(rs.getString("id"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		dbUtil.close(conn);
	}
  }
}
