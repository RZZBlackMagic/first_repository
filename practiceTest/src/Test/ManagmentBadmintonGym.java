package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ManagmentBadmintonGym {

	public static void main(String[] args) {
		ManagmentBadmintonGym mbg = new ManagmentBadmintonGym();
		mbg.start();
	}
    public void start(){
    	Scanner scan = new Scanner(System.in);
    	String  message = scan.nextLine();
    	String messageArr[] = message.split(" ");
    	int length = messageArr.length;
    	if(message.equals(" ")){
    		/*
    		 * ��ӡ�������
    		 */
    	}else{
    		if(messageArr[length].equals("c")){
    			/*
    			 * Ԥ��
    			 */
    		}else{
    			/*
    			 * ȡ��
    			 */
    		}
    	}
    }
    public void book(String[] messageArr) throws ParseException{
    	/*
    	 * ����Ԥ��
    	 */
    	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		   Date date = sdf.parse(messageArr[1]);
		   System.out.println(date);
		   Calendar calendar = Calendar.getInstance();
		   int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)+1;
		   System.out.println(dayOfWeek);
		   if(dayOfWeek>=1&&dayOfWeek<=5){
			   /*
			    * ��һ�����壺
			    * 9:00-12:00 30/hour
			    * 12:00-18:00 50/hour
			    * 18:00-20:00 80/hour
			    * 20:00-22:00 60/hour
			    */
		   }else if(dayOfWeek>=6&&dayOfWeek<=7){
			   /*
			    *  ��������ĩ��
			    * 9:00-12:00  40/hour
			    * 12:00-18:00 50/hour
			    * 18:00-22:00 60/hour
			    */
		   }
    }
    public void calcel(){
    	/*
    	 *����ȡ��
    	 */
    }
    public void huizong(){
    	/*
    	 * ���㳡��������
    	 */
    }
    public void Print(){
    	/*
    	 * ��ӡ������Ϣ
    	 */
    }
}   
