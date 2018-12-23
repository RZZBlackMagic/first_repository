package Spring04;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("stu1")//ȡ����
@Scope("prototype")//������ ��prototype:����һ�δ���һ��ʵ����singleton:ֻ�ᴴ��һ��ʵ��.ȱʡֵΪ����
@Lazy(true)//�ӳټ��أ�true:ֻ���ڵ���getBean����ʱ���Żᴴ��ʵ����
public class Student {

	public Student() {
		System.out.println("student()");
	}
	@PostConstruct//�ڹ�����֮�󣨾��ǳ�ʼ����
	public void init(){
		System.out.println("init()");
	}
	@PreDestroy//������֮ǰ���ã����ٷ�����
	public void destroy(){
		System.out.println("destroy()");
	}

}
