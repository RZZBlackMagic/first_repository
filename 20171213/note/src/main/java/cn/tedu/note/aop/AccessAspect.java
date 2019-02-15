package cn.tedu.note.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AccessAspect {

	@Around("within(cn.tedu.note.*.*ServiceImpl)")
	public Object AllServiceAspect(ProceedingJoinPoint jp)throws Throwable{
		//ҵ�񷽷�֮ǰ
		Long startTime = System.currentTimeMillis();
		
		Object obj = jp.proceed();
		//ҵ�񷽷�֮��
		Long endTime = System.currentTimeMillis();
		Long time = endTime - startTime;
		Signature name = jp.getSignature();
		System.out.println(name+"������ʱ��Ϊ"+time);
		return obj;
	}

}
