package email;
public class SimpleMail { 
	  //�ʼ��е����� 
	  private String subject; 
	  //�ʼ������ݣ����ģ� 
	  private String content; 
	  //�ɸ�����Ҫ���������ʼ�Ԫ�� 

	  public void setSubject(String subject) { 
	    this.subject = subject; 
	  } 

	  public void setContent(String content) { 
	    this.content = content; 
	  } 

	  public String getSubject() { 
	    return subject; 
	  } 

	  public String getContent() { 
	    return content; 
	  } 
	}