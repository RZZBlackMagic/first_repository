package Day02;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//import java.util.Date;
import java.util.Scanner;
public class test {

	public static void main(String[] args) throws ParseException {
		System.out.println("�������Լ������գ�");
         Scanner s= new Scanner(System.in);
         String myBri= s.nextLine();
         SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
         Date briDate = sdf.parse(myBri);//��������ת��Ϊ����
         
         long myTime = briDate.getTime();//����֮ǰ������
         System.out.println(myTime);
         
         Date date= new Date();//�����ڵ�ʱ��
         long time = date.getTime();
         System.out.println(time);
         
         long midTime= time-myTime;//������˶�á�
         long day = midTime/(1000*60*60*24);
         System.out.println(day);
         
         
           
         
         Calendar calendar = Calendar.getInstance();//����ȥnew���������Ϳ��ԣ�newҲ�з���
         System.out.println(calendar);//�����Ϊ������
	}

}
