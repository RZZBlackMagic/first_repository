package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@RequestMapping("/ary.do")
	@ResponseBody
	//���Զ��Ľ����ؽ����JavaBeanת��Ϊjson�ַ������͵�������ͻ��ˣ��ײ�����Jackson API
	public Object test(){
		String[] ary = {"lhh","xe","xd"};
		return ary;
	}
	
	@RequestMapping("/bean.do")
	@ResponseBody
	//��JavaBean��Ϊ����ֵ��ResponseBodyע�⽫beanת��Ϊjson�ַ������͵�������ͻ���
	public Object bean(){
		return new admin("rzz",8,99.9);
	}
	
	@RequestMapping("/list.do")
	@ResponseBody
	//����ͬһ���͵Ķ������ʱ���Ͱ������ɼ���������
	public List<admin> list(){
		List<admin> l = new ArrayList<admin>();
		l.add(new admin("ee",8,88.8));
		l.add(new admin("ee",8,88.8));
		return l;
	}
	
	@RequestMapping("/map.do")
	@ResponseBody
	//���ض����ͬ���͵Ķ���ʱ���ͷŽ�map����
	public Map map(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("����һ", new admin("ee",8,88.8) );
		map.put("�����", "hah");
		return map;
	}
	
	//Ҳ������list��������map
	
	
	
}
