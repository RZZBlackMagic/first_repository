package Day02;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//import java.util.Date;
import java.util.Scanner;
public class test {

	public static void main(String[] args) throws ParseException {
		System.out.println("请输入自己的生日：");
         Scanner s= new Scanner(System.in);
         String myBri= s.nextLine();
         SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
         Date briDate = sdf.parse(myBri);//出生日期转换为日期
         
         long myTime = briDate.getTime();//出生之前的日期
         System.out.println(myTime);
         
         Date date= new Date();//算现在的时间
         long time = date.getTime();
         System.out.println(time);
         
         long midTime= time-myTime;//算你活了多久。
         long day = midTime/(1000*60*60*24);
         System.out.println(day);
         
         
           
         
         Calendar calendar = Calendar.getInstance();//不用去new对象，这样就可以（new也行烦）
         System.out.println(calendar);//输出的为毫秒数
	}

}
