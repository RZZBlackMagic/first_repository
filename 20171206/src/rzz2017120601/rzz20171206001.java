package rzz2017120601;
import java.util.Scanner; 
public class rzz20171206001 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("��������ݣ�");
		int year=scan.nextInt();
		boolean flag=(year%4==0&&year%100!=0)||year%400==0;
		String str=flag?year+"������":year+"��������";
				
		System.out.println(str);

	}

}
