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
    		 * 打印收入汇总
    		 */
    	}else{
    		if(messageArr[length].equals("c")){
    			/*
    			 * 预定
    			 */
    		}else{
    			/*
    			 * 取消
    			 */
    		}
    	}
    }
    public void book(String[] messageArr) throws ParseException{
    	/*
    	 * 场馆预定
    	 */
    	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		   Date date = sdf.parse(messageArr[1]);
		   System.out.println(date);
		   Calendar calendar = Calendar.getInstance();
		   int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)+1;
		   System.out.println(dayOfWeek);
		   if(dayOfWeek>=1&&dayOfWeek<=5){
			   /*
			    * 周一到周五：
			    * 9:00-12:00 30/hour
			    * 12:00-18:00 50/hour
			    * 18:00-20:00 80/hour
			    * 20:00-22:00 60/hour
			    */
		   }else if(dayOfWeek>=6&&dayOfWeek<=7){
			   /*
			    *  周六到周末：
			    * 9:00-12:00  40/hour
			    * 12:00-18:00 50/hour
			    * 18:00-22:00 60/hour
			    */
		   }
    }
    public void calcel(){
    	/*
    	 *场馆取消
    	 */
    }
    public void huizong(){
    	/*
    	 * 计算场馆总消费
    	 */
    }
    public void Print(){
    	/*
    	 * 打印汇总信息
    	 */
    }
}   
