package Test;

import java.util.Calendar;
import java.util.Date;

public class calendar {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int day= c.get(Calendar.DAY_OF_MONTH);
		System.out.println("��ǰʱ��Ϊ��"+year+"��"+month+"��"+day+"��");
		
		Date date = c.getTime();
		System.out.println(date);
	}

}
