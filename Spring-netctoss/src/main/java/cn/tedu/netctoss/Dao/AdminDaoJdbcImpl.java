package cn.tedu.netctoss.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import cn.tedu.netctoss.Entity.admin;

/*
 * 持久层实现
 * 
 */
//@Repository("adminDao")
public class AdminDaoJdbcImpl implements AdminDao{

	@Resource(name="ds")
	private DataSource ds;
	public admin fingByAdminCode(String AdminCode) {
		admin a = new admin();
		Connection conn=null;
		try {
			conn = ds.getConnection();
			String sql = "select * from admin_info_rzz where admin_code = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, AdminCode);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				a.setAdmin_id(rs.getInt("admin_id"));
				a.setAdmin_code(rs.getString("admin_code"));
				a.setPassword(rs.getString("password"));
				a.setName(rs.getString("name"));
				a.setTelephone(rs.getString("telephone"));
				a.setEmail(rs.getString("email"));
				a.setEnrolldate(rs.getTimestamp("enrolldate"));
            }
		} catch (SQLException e) {
			// step1 :记日志
			e.printStackTrace();
			/*
			 * step2 :看异常能否恢复,如果不能恢复（比如数据库服务的暂停，网络中段，这样的额异常一般我们称之为系统异常
			 * 则提示用户善后重试，如果能够恢复，则立即恢复）
			 */
			throw new RuntimeException(e);
		}finally{
			if(conn!=null){
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
		return a;
	}

}
