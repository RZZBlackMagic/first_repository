package first;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class firstSpring {

	public static void main(String[] args) {
         String config = "applicationContext.xml";
         /*
          * ApplicationContext�ǽӿڣ�
          * ClassPathXmlApplicationContext������ʵ���ࡣ����������·��ȥ����Spring�����ļ�������������
          */
         ApplicationContext ac = new ClassPathXmlApplicationContext(config);
         //��һ��������bean��id���ڶ��������Ƿ������е�class����
         student s = ac.getBean("stu1",student.class);
         System.out.println(s);
         
         Date d = ac.getBean("date1",Date.class);
         System.out.println(d);
         
	}

}
