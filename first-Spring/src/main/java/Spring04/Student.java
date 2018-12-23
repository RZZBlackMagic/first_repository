package Spring04;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("stu1")//取别名
@Scope("prototype")//作用域 ：prototype:调用一次创建一个实例。singleton:只会创建一个实例.缺省值为单例
@Lazy(true)//延迟加载，true:只有在调用getBean方法时，才会创建实例。
public class Student {

	public Student() {
		System.out.println("student()");
	}
	@PostConstruct//在构造器之后（就是初始化）
	public void init(){
		System.out.println("init()");
	}
	@PreDestroy//在销毁之前调用（销毁方法）
	public void destroy(){
		System.out.println("destroy()");
	}

}
