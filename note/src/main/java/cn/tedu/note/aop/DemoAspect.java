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
 * 创建一个切面组件，就是一个普通的JavaBean对象
 * @author asus
 *
 */
@Component
@Aspect
public class DemoAspect {

	//声明该方法在下面这个bean的所有方法之前执行
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
		/*System.out.println("业务方法之前");
		Object val =jp.proceed();
		System.out.println(val);
		System.out.println("业务方法之后");*/
		return null;
	}
}
