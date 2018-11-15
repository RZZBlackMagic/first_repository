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
			System.out.println("��¼�ɹ�");
		}else{
			System.out.println("��¼ʧ��");
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
		//��ȡ�������Ԫ���ݡ�
		ResultSetMetaData rsmd = rs.getMetaData();
		//Ԫ�����з�װ�˽������������Ϣ�������Ǿ��������
		int row = rsmd.getColumnCount();//��ȡ���ݵ�����
		while(rs.next()){
			String str = rs.getString("ename");
			int id = rs.getInt("empno");
			System.out.println(str);
			System.out.println(id);
		}
		
		
//		System.out.println(row);
//		System.out.println(rsmd.getColumnTypeName(2));//����ڶ��еĲ�������
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		dbUtil.close(conn);
	}
      
  }
  /**
   * ģ��ת��ҵ��
   * ǰ�᣺
   *    �����û��Ѿ���¼��������
   *    �������������տ���˺ź��տ�Ľ��
   *    
   *    ���裺
   *       1 ��ѯ�����˺ţ���������
   *       2 ��ѯ�տ��˺ţ����˺ŶԲ���
   *       3 �޸ĸ�������-N
   *       4 �޸��տ�����+N
   *       
   *       ע�⣺ת����һ��������ҵ��Ҫʹ��һ�����ӣ�����ֻ��һ������
   */
  @Test
  
  public void test3(){
	  //�����û���¼���˺��ǣ�
	  String payId = "00001";
	  //������������տ��˺��ǣ�
	  String recId = "00002";
	  //�����������ת�˽���ǣ�
	  double money = 1000.0;
	  Connection conn = null;
	  try {
		conn = dbUtil.getConnection();
//		   1 ��ѯ�����˺ţ���������
        String sql1 = "select * from accounts where id = ? ";
        PreparedStatement ps1 = conn.prepareStatement(sql1);
        ps1.setString(1, payId);
        ResultSet rs1 = ps1.executeQuery();//�õ�������ʱ����Ŀ�����ݵ���һ��
        rs1.next();//��rsָ��Ŀ�����ݡ�
        double payMoney = rs1.getDouble("money");
        if(payMoney<money){
        	System.out.println("���㣡");
        	return;
        }
//               2 ��ѯ�տ��˺ţ����˺ŶԲ���
        String sql2 = "select *from accounts where id = ?";
        PreparedStatement ps2 = conn.prepareStatement(sql2);
        ps2.setString(1, recId);
        ResultSet rs2 = ps2.executeQuery();
        double recMoney = 0; 
        if(!rs2.next()){
        	System.out.println("�տ��˺Ŵ���");
        	return;
        }else{
        	 recMoney = rs2.getDouble("money");
        }
//               3 �޸ĸ�������-N
        String sql3 = "update accounts set money = ? where id = ?";
        PreparedStatement ps3 = conn.prepareStatement(sql3);
        ps3.setDouble(1, payMoney-money);
        ps3.setString(2, payId);
        ps3.executeUpdate();
//        *       4 �޸��տ�����+N
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
