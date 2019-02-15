package cn.tedu.note.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PointcutAspect {

	//@Before("bean(*Service)")
	//@Before("within(cn.tedu.note.service.*ServiceImpl)")
	@Before("execution(* cn.tedu.note.service.UserService.login(..))")
	public void test1(){
		//System.out.println("«–»Îµ„≤‚ ‘");
	}

}
