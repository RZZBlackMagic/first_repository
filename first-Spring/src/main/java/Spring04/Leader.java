package Spring04;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("l")
public class Leader {
	@Resource(name="wt")//��д���ŵĻ�����ͨ��byType�ķ���ȥѰ�ҡ�
	private waiter wt;


	public Leader() {
		System.out.println("Leader()");
	}

	@Override
	public String toString() {
		return "Leader [wt=" + wt + "]";
	}
	
}
