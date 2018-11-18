package TestCase;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.User;

public class UserDaoTest {

	UserDao dao;
	ClassPathXmlApplicationContext ctx;
	@Before
	public void initCtx(){
		ctx = new ClassPathXmlApplicationContext("conf/spring-mvc.xml","conf/spring-mybatis.xml");
		System.out.println(1);
		 dao= ctx.getBean("dao",UserDao.class);
	}
	@Test
	public void test0(){
		String name="demo";

		User user = dao.findUserByName(name);
		System.out.println(user);
		System.out.println(0);
	}
	@Test
	public void testAddUser(){
		String id = UUID.randomUUID().toString();
		String name = "tom";
		String salt = "ΩÒÃÏƒ„≥Û¡À∞°";
		String password = DigestUtils.md5Hex(salt+"123456");
		String token = "";
		String nick ="";
		User user = new User(id,name,password,token,nick);
		dao.addUser(user);
		System.out.println(2);
	}
	
	@Test
	public void testFindUesrBuId(){
		String UserId = "03590914-a934-4da9-ba4d-b41799f917d1";
		User user = dao.findUserById(UserId);
		System.out.println(user);
	}
	
	
	
	
	@After
	public void closeCtx(){
		ctx.close();
	}
}
