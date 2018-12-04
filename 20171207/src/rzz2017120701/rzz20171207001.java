package rzz2017120701;
import java.util.Scanner;
public class rzz20171207001 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		/*System.out.println("请输入年份：");
		int year=scan.nextInt();
		boolean b1=(year%4==0&&year%100==0)||(year%400==0);
		String str=b1?year+"是闰年":year+"不是闰年";
		System.out.println(str);
	    System.out.println("heloword");
		System.out.println("请输入一个年龄：");
		int age=scan.nextInt();
		
		if(age>18&&age<50)
		{
			System.out.println("YES");
		}
		else
		{System.out.println("NO");
		
		}
		System.out.println("请输入商品单价：");
		double price=scan.nextInt();
		System.out.println("请输入购买商品数量");
		double number=scan.nextInt();
		double mon;
		mon=number*price;
		if(900>mon&&mon>500){
			mon=mon*0.8;
		}
		else if(mon<500){
			mon=mon*0.9;
		}
		else if(mon>1000){
			mon=mon*0.7;
		}
		System.out.println("应支付"+mon);
		System.out.println("实际支付:");
		double Amon=scan.nextInt();
		double s=Amon-mon;
		System.out.println("应找零"+s);
		
		System.out.println("请从控制台输入两个整数：（用空格隔开）");
		int a=scan.nextInt();
		int b=scan.nextInt();
		if(a>b){
			System.out.print(a);
			System.out.println( b);
		}
		else if(a<b){
			System.out.print(b);
			System.out.println( a);
		}
		else if(a==b){
			System.out.println("两数相等");
		}
		System.out.println("请输入年份：");
		int year=scan.nextInt();
		System.out.println("请输入月份：");
		int month=scan.nextInt();
		if((year%4==0&&year%100!=0)||(year%400==0)){
			switch(month){
			     case 1:
				       System.out.println(year+"年"+month+"月有"+31+"天");
				       break;
			     case 2:
				       System.out.println(year+"年"+month+"月有"+29+"天");
				       break;
			     case 3:
				       System.out.println(year+"年"+month+"月有"+31+"天");
				       break;
			     case 4:
				       System.out.println(year+"年"+month+"月有"+30+"天");
				       break;
			     case 5:
				       System.out.println(year+"年"+month+"月有"+31+"天");
				       break;
			     case 6:
				       System.out.println(year+"年"+month+"月有"+30+"天");
				       break;
			     case 7:
				       System.out.println(year+"年"+month+"月有"+31+"天");
				       break;
			     case 8:
				       System.out.println(year+"年"+month+"月有"+30+"天");
				       break;
			     case 9:
				       System.out.println(year+"年"+month+"月有"+30+"天");
				       break;
			     case 10:
				       System.out.println(year+"年"+month+"月有"+31+"天");
				       break;
			     case 11:
				       System.out.println(year+"年"+month+"月有"+30+"天");
				       break;
			     case 12:
				       System.out.println(year+"年"+month+"月有"+31+"天");
				       break;
			     }
		}
		else{
		   switch(month){
		
		      case 1:
			        System.out.println(year+"年"+month+"月有"+31+"天");
			        break;
		      case 2:
		         	System.out.println(year+"年"+month+"月有"+28+"天");
		         	break;
		      case 3:
			        System.out.println(year+"年"+month+"月有"+31+"天");
			        break;
		      case 4:
			         System.out.println(year+"年"+month+"月有"+30+"天");
			         break;
		      case 5:
		         	System.out.println(year+"年"+month+"月有"+31+"天");
		         	break;
		      case 6:
		        	System.out.println(year+"年"+month+"月有"+30+"天");
		        	break;
		      case 7:
		         	System.out.println(year+"年"+month+"月有"+31+"天");
		         	break;
		      case 8:
		         	System.out.println(year+"年"+month+"月有"+30+"天");
		         	break;
		      case 9:
		        	System.out.println(year+"年"+month+"月有"+30+"天");
		        	break;
		      case 10:
		         	System.out.println(year+"年"+month+"月有"+31+"天");
		         	break;
		      case 11:
			        System.out.println(year+"年"+month+"月有"+30+"天");
			        break;
		      case 12:
		        	System.out.println(year+"年"+month+"月有"+31+"天");
		        	break;
		
		      }
	    }
	}
}*/
		System.out.println("请输入三个数依次为：");
		int a=scan.nextInt();
		int b=scan.nextInt();
		int c=scan.nextInt();
		int flag;
		flag=a;
		if(a<b){
			flag=b;
			if(b<c){
				flag=c;
			}
		}
		else if(a<c){
			flag=c;
			if(c<b){
				flag=b;
			}
		}
		else{
			flag=a;
		}
		System.out.println(flag);
	}
}
		
      
	
			
				
			
		
	

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
		
		
		
		
			
		
		
		
			

	


