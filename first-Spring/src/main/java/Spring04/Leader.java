package Spring04;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("l")
public class Leader {
	@Resource(name="wt")//不写括号的话就是通过byType的方法去寻找。
	private waiter wt;


	public Leader() {
		System.out.println("Leader()");
	}

	@Override
	public String toString() {
		return "Leader [wt=" + wt + "]";
	}
	
}
