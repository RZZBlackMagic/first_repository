package DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entity.emp;
import util.dbUtil;

public class empDao implements Serializable{
	//����һ��Ա��
	public void save(emp e){
	    Connection conn = null;
	    try {
			conn = dbUtil.getConnection();
			String sql = "insert into emps values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getEname());
			ps.setString(2, e.getJob());
			ps.setInt(3, e.getMgr());
			ps.setDate(4, e.getHiredate());
			ps.setDouble(5, e.getSal());
			ps.setDouble(6, e.getComm());
			ps.setInt(7, e.getDeptno());
			ps.setInt(8, e.getEmpno());
			ps.executeUpdate();
			} catch (SQLException e1) {
			e1.printStackTrace();
		}finally{
			dbUtil.close(conn);
		}
	}
//	����ID�޸�Ա��
	public void update(emp e){
		Connection conn = null;
		try {
			conn = dbUtil.getConnection();
			String sql = "update emps set "
					+ "ename = ?,"
					+ "job=?,"
					+ "mgr=?,"
					+ "hiredate=?,"
					+ "sal=?,"
					+ "comm=?,"
					+ "deptno=?"
					+ " where empno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getEname());
			ps.setString(2, e.getJob());
			ps.setInt(3, e.getMgr());
			ps.setDate(4, e.getHiredate());
			ps.setDouble(5, e.getSal());
			ps.setDouble(6, e.getComm());
			ps.setInt(7, e.getDeptno());
			ps.setInt(8, e.getEmpno());
			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new RuntimeException("�޸�Ա����Ϣʧ��",e1);
		}finally{
			dbUtil.close(conn);
		}
	}
//	����IDɾ��һ��Ա��
	public void delete(int id){
		Connection conn = null;
		try {
			conn = dbUtil.getConnection();
			String sql ="detele from emps where empno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbUtil.close(conn);
		}
	}
//	����ID��ѯһ��Ա��
	public emp findById(int id){
		Connection conn = null;
		try {
			conn = dbUtil.getConnection();
			String sql = "select * from emps where empno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = 	ps.executeQuery();
			if(rs.next()){
				emp e1 = new emp();
				e1.setEname(rs.getString("ename"));
				e1.setComm(rs.getDouble("comm"));
				e1.setDeptno(rs.getInt("deptno"));
				e1.setEmpno(rs.getInt("empno"));
				e1.setHiredate(rs.getDate("hiredate"));
				e1.setJob(rs.getString("job"));
				e1.setMgr(rs.getInt("mgr"));
				e1.setSal(rs.getDouble("sal"));
				return e1;
			}
			System.out.println(rs.getString("ename"));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��",e);
		}finally{
			dbUtil.close(conn);
		}
		return null;
	}
//	���ݲ���ID��ѯԱ��
	public List<emp> findByDeptno(int deptno){
		Connection conn = null;
		try {
			conn = dbUtil.getConnection();
			String sql ="select * from emps where deptno =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, deptno);
            emp e1 = new emp();
            ResultSet rs = ps.executeQuery();
			e1.setComm(rs.getDouble("comm"));
			e1.setDeptno(rs.getInt("deptno"));
			e1.setEmpno(rs.getInt("empno"));
			e1.setEname(rs.getString("ename"));
			e1.setHiredate(rs.getDate("hiredate"));
			e1.setJob(rs.getString("job"));
			e1.setMgr(rs.getInt("mgr"));
			e1.setSal(rs.getDouble("sal"));
			List<emp> list = new LinkedList<emp>();
			list.add(e1);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��",e);
		}finally{
			dbUtil.close(conn);
		}
	}
	//��ѯ����Ա��
	public List<emp> findAll(){
		return null;
		
	}

}
