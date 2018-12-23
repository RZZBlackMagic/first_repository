package Test;

import org.apache.catalina.Manager;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Collections.ExampleBean;
import Collections.InfoBean;
import Collections.valueBean;
import Spring02.A;
import Spring02.B;
import Spring02.manager;
import Spring03.Car;
import Spring04.Leader;
import Spring04.Restaurant;
import Spring04.Student;
import Spring04.UserBean;
import Spring04.bar;
import basic.MessageService;
import basic.Teacher;

public class TestCase1 {

	@Test
	public void test1(){
		String config = "basic.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		//通过容器获得bean
		Teacher t1 = ac.getBean("teacher",Teacher.class);
		Teacher t2 = ac.getBean("teacher",Teacher.class);
		System.out.println(t1==t2);
	}
	@Test
	//测试初始化方法
	public void test2(){
		String config = "basic.xml";
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(config);
		MessageService ms = ac.getBean("ms1",MessageService.class);
		ac.close();
	}
	@Test
	public void test3(){
		String config = "Spring02.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		A a = ac.getBean("a1",A.class);
		
		a.execute();
	}
	@Test
	public void test4(){
		String config = "Spring02.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		manager man = ac.getBean("man",manager.class);
		System.out.println(man.toString());
	}
	@Test
	public void test5(){
		String config = "Spring03.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		Car c = ac.getBean("car1",Car.class);
		System.out.println(c);
		System.out.println(c.toString());
	}
	@Test 
	public void test6(){
		String config = "Collections.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		System.out.println(ac);
		valueBean vb = ac.getBean("c",valueBean.class);
		System.out.println(vb.toString());
	}
	@Test 
	public void test7(){
		String config = "Collections.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		System.out.println(ac);
		InfoBean vb = ac.getBean("ib1",InfoBean.class);
		System.out.println(vb.toString());
	}
	@Test
	public void test8(){
		String config = "Spring04.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		System.out.println(ac);
		Student s = ac.getBean("stu1",Student.class);
		Student s1 = ac.getBean("stu1",Student.class);
		System.out.println(s==s1);
	}
	@Test
	public void test9(){
		String config = "Spring04.xml";
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(config);
		Student s = ac.getBean("stu1",Student.class);
		System.out.println(s);
		ac.close();
	}
	@Test
	public void test10(){
		String config = "Spring04.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		Restaurant a = ac.getBean("rest",Restaurant.class);
		System.out.println(a);
	}
	@Test
	public void test11(){
		String config = "Spring04.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		bar b = ac.getBean("b",bar.class);
		System.out.println(b);
	}
	@Test
	public void test12(){
		String config = "Spring04.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		Leader l = ac.getBean("l",Leader.class);
		System.out.println(l);
	}
	@Test
	public void test13(){
		String config = "Spring04.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		UserBean l = ac.getBean("user",UserBean.class);
		System.out.println(l);
	}
}
