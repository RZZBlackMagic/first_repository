package empDAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DAO implements Serializable {
      public List<emp> findAll(){
    	  emp e1 = new emp();
    	  e1.setName("������");
    	  e1.setStu(2016112225);
    	  e1.setSex("��");
    	  e1.setScore(99);
    	  
    	  emp e2 = new emp();
    	  e2.setName("��һ��");
    	  e2.setStu(2016112224);
    	  e2.setSex("Ů");
    	  e2.setScore(96);
    	  
    	  emp e3 = new emp();
    	  e3.setName("�޺ƶ�");
    	  e3.setStu(2016112223);
    	  e3.setSex("Ů");
    	  e3.setScore(92);
    	  
    	  List<emp> list = new ArrayList<emp>();
    	  list.add(e1);
    	  list.add(e2);
    	  list.add(e3);
    	  return list;
      }
}
