package email;
import java.util.ArrayList; 
import java.util.List; 
import org.junit.Test;

import email_lyk.ReadHtmlFile;



public class MailTest { 
  /** 
    * 单发 
    * */ 
 @Test
  public void testSingleSend(){ 
    SimpleMail sm=new SimpleMail(); 
    sm.setSubject("第一封邮件"); 
    String str = ReadHtmlFile.getSource("http://www.baidu.com"); 
    //String str = ReadHtmlFile.readFile("这里填写你需要发送的本地文件路径"); 
    System.out.println(str); 
    sm.setContent(str); 
    SimpleMailSender sms=new SimpleMailSender("str这里填写你的发件箱","这里填写你的发件箱密码"); 
    try { 
      sms.send("这里需要填写接收邮件的邮箱", sm); 
      System.out.println("执行完成！！"); 
    } catch (Exception e) { 
      e.printStackTrace(); 
    } 
  } 
    
    
  /** 
    * 群发 
    *    
    * */ 
 @Test
  public void testMassSend(){ 
    SimpleMail sm=new SimpleMail(); 
    sm.setSubject("第一封邮件"); 
    String str = ReadHtmlFile.getSource("http://www.baidu.com"); 
    //String str = ReadHtmlFile.readFile("这里填写需要发送的本地文件路径"); 
    System.out.println(str); 
    sm.setContent(str); 
    SimpleMailSender sms=new SimpleMailSender("2378801969@qq.com","x2378801969"); 
    List<String> recipients=new ArrayList<String>(); 
    recipients.add("2065643102@qq.com"); 
    recipients.add("这里需要填写接收邮件的邮箱"); 
    recipients.add("这里需要填写接收邮件的邮箱"); 
    recipients.add("这里需要填写接收邮件的邮箱"); 
    try { 
      sms.send(recipients, sm); 
      System.out.println("执行完成！！"); 
    } catch (Exception e) { 
      e.printStackTrace(); 
    } 
  } 
} 
