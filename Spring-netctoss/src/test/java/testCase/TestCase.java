package testCase;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Service.LoginService;
import cn.tedu.netctoss.Dao.AdminDao;
import cn.tedu.netctoss.Entity.admin;

public class TestCase {

	@Test
	public void test0() throws SQLException{
		String config = "Springmvc.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		//DataSource是一个接口
		//BasicDataSource是其的一个实现类
		DataSource ds = ac.getBean("ds",DataSource.class);
		System.out.println(1);
		System.out.println(ds.getConnection());
	}
	@Test
	//测试持久层
	public void test2(){
		String config = "Springmvc.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		AdminDao ad = ac.getBean("adminDao",AdminDao.class);
		admin a = ad.fingByAdminCode("caocao");
		System.out.println(a);
	}
	@Test
	public void test3(){
		String config = "Springmvc.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		LoginService ls = ac.getBean("LoginService",LoginService.class);
		admin a = ls.checkLogin("caocao", "123");
		System.out.println(a);
	}
}
