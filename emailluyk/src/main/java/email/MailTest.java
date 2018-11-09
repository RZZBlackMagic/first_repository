package email;
import java.util.ArrayList; 
import java.util.List; 
import org.junit.Test;

import email_lyk.ReadHtmlFile;



public class MailTest { 
  /** 
    * ���� 
    * */ 
 @Test
  public void testSingleSend(){ 
    SimpleMail sm=new SimpleMail(); 
    sm.setSubject("��һ���ʼ�"); 
    String str = ReadHtmlFile.getSource("http://www.baidu.com"); 
    //String str = ReadHtmlFile.readFile("������д����Ҫ���͵ı����ļ�·��"); 
    System.out.println(str); 
    sm.setContent(str); 
    SimpleMailSender sms=new SimpleMailSender("str������д��ķ�����","������д��ķ���������"); 
    try { 
      sms.send("������Ҫ��д�����ʼ�������", sm); 
      System.out.println("ִ����ɣ���"); 
    } catch (Exception e) { 
      e.printStackTrace(); 
    } 
  } 
    
    
  /** 
    * Ⱥ�� 
    *    
    * */ 
 @Test
  public void testMassSend(){ 
    SimpleMail sm=new SimpleMail(); 
    sm.setSubject("��һ���ʼ�"); 
    String str = ReadHtmlFile.getSource("http://www.baidu.com"); 
    //String str = ReadHtmlFile.readFile("������д��Ҫ���͵ı����ļ�·��"); 
    System.out.println(str); 
    sm.setContent(str); 
    SimpleMailSender sms=new SimpleMailSender("2378801969@qq.com","x2378801969"); 
    List<String> recipients=new ArrayList<String>(); 
    recipients.add("2065643102@qq.com"); 
    recipients.add("������Ҫ��д�����ʼ�������"); 
    recipients.add("������Ҫ��д�����ʼ�������"); 
    recipients.add("������Ҫ��д�����ʼ�������"); 
    try { 
      sms.send(recipients, sm); 
      System.out.println("ִ����ɣ���"); 
    } catch (Exception e) { 
      e.printStackTrace(); 
    } 
  } 
} 
