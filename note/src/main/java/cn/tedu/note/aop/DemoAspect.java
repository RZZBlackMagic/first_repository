package cn.tedu.note.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 * ����һ���������������һ����ͨ��JavaBean����
 * @author asus
 *
 */
@Component
@Aspect
public class DemoAspect {

	//�����÷������������bean�����з���֮ǰִ��
	@Before("bean(userService)")
	public void test(){
		//System.out.println("hello world");
	}
	@After("bean(userService)")
	public void test1(){
		//System.out.println(" After");
	}
	@AfterReturning("bean(userService)")
	public void test2(){
		//System.out.println("afterRreturning");
	}
	@AfterThrowing("bean(userService)")
	public void test3(){
		//System.out.println("afterThrowing");
	}

	//@Around("bean(userService)")
	public Object test4(ProceedingJoinPoint jp)throws Throwable{
		/*System.out.println("ҵ�񷽷�֮ǰ");
		Object val =jp.proceed();
		System.out.println(val);
		System.out.println("ҵ�񷽷�֮��");*/
		return null;
	}
}
