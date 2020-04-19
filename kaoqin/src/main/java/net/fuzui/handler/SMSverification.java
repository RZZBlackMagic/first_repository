package net.fuzui.handler;

public class SMSverification {

	public  static void main(String[] args){
		String str1 = "JsonResult [state=200, message=登录成功, data=Teacher [tea_id=1586880846349, tea_phone=15890041836, tea_school=恶魔, tea_academy=恶魔, tea_name=大, tea_nickname=嗯啦啊, tea_sex=男, tea_isAssisance=否, tea_picutre=, tea_bluetooth=88:28:B3:C0:28:22, tea_blu_status=0, tea_password=123456]]";
		String [] str = parseJson(str1);
		for(int i=0;i<str.length;i++){
			System.out.println(str[i]);
		}
	}
	public static String[] parseJson(String message){
		String[] str1 = message.split("state");
		String state = str1[1].substring(1, 4);
		String sheng = str1[1].substring(6);
		String[] string1 = sheng.split(",");
		String message1 = string1[0].split("=")[1];
		int length = 8+message1.length()+2;
		String data = sheng.substring(length).substring(5);
		String[] result = new String[3];
		result[0] = state;
		result[1] = message1;
		result[2] = data;
		return result;
	}
	
}
