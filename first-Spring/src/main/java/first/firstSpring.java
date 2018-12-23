package first;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class firstSpring {

	public static void main(String[] args) {
         String config = "applicationContext.xml";
         /*
          * ApplicationContext是接口，
          * ClassPathXmlApplicationContext是他的实现类。该类会根据类路径去查找Spring配置文件，启动容器。
          */
         ApplicationContext ac = new ClassPathXmlApplicationContext(config);
         //第一个参数是bean的id，第二个参数是方法区中的class对象
         student s = ac.getBean("stu1",student.class);
         System.out.println(s);
         
         Date d = ac.getBean("date1",Date.class);
         System.out.println(d);
         
	}

}
