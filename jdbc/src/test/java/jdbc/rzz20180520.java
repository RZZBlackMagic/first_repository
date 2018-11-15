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
       * ��������108��Ա��
       */
      @Test
      public void test1(){
    	  Connection conn = null;
    	  try {
			conn = dbUtil.getConnection();
			conn.setAutoCommit(false);//ȡ���Զ��ύ
			String sql = "insert into emps values(emps_seq.nextval,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			for(int i=1;i<=108;i++){
				//�����ݴ浽ps�ǡ���������
				ps.setString(1, "������"+i);
				ps.setString(2, "���"+i);
				ps.setInt(3, 0);
				ps.setDate(4,new java.sql.Date(System.currentTimeMillis()));
				ps.setDouble(5, 6666);
				ps.setDouble(6, 8888);
				ps.setInt(7, 2);
				ps.addBatch();//�������ݴ浽ps'��������
				if( i%50==0){
					ps.executeBatch();
					ps.clearBatch();//���ps���ݴ����ݣ��Ա����´θ���
				}
			}
			//Ϊ�˱�������ͷ��������������ύһ��
			ps.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();//�����쳣 �ݻع�
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			dbUtil.close(conn);
		}
    	  
      }
      /**
       * ��Ҫ��ʾ������һ�������ڸ��˲�������һ��Ա��
       * �ص㣺���Ӳ��ź���λ�ȡ���ɲ��ŵ�ID
       */
    @Test
	public void test2(){
	     	Connection conn = null;
	     	//����ҳ�洫��Ĳ�����Ϣ�ǣ�
	     	String dname = "���Բ�";
	     	String loc = "����";
	     	//����ҳ�洫���Ա�������ǣ�
	     	String ename = "�˽�";
	     	String job = "ȡ��";
	     	int mgr = 0;
	     	Date hiredate = new Date(System.currentTimeMillis());
	     	double sal =5000.0;
	     	double comm = 1000.0;
	     	
	     	try {
				conn = dbUtil.getConnection();
				conn.setAutoCommit(false);
				String sql = "insert into depts values (depts_seq.nextval,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql,new String[]{"deptno"});
				//����2��һ�����飬��������ps����Ҫ��������Щ�ֶ�
                ps.setString(1,dname);
                ps.setString(2,loc);
                ps.executeUpdate();
//                ��ps�л�ȡ���ɵ�����
                ResultSet rs = ps.getGeneratedKeys();
                //��������а���һ��һ�С�
                rs.next();
                int deptno = rs.getInt(1);//���ֳ����µĽ����ֻ��ͨ���ֶε���Ż�ȡֵ������д�ֶ���
                
                //����һ��Ա��
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
    	 * ��ҳ��ѯԱ��
    	 */
//    	�������󻹹涨��ÿҳ��ʾʮ�� ��
    	int size = 10;
//    	�����û�Ҫ�õ�����ҳ������
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
     * 1 �ȸ���ĳ��id��ѯһ��Ա��
     * 2 �޸Ĵ�Ա������
     */
    public void test4(){
    	empDao d = new empDao();
    	emp e = d.findById(124);
        if(e!=null){
        	System.out.println(e.getEname());
        	e.setEname("������");
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
			ps.setString(1, "������"+i);
			ps.setString(2, "���"+i);
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
				ps.setString(1, "������"+i);
				ps.setString(2, "����"+i);
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
				ps.setString(1, "������"+i);
				ps.setString(2, "����"+i);
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
			ps.setString(2, "������");
			ps.setString(3, "����");
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
