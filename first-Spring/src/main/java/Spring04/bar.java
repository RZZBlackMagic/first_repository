package Spring04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("b")
public class bar {

	private waiter wt;
	@Autowired
	public bar(@Qualifier("wt")waiter wt) {
        System.out.println("bar()");
		this.wt = wt;
	}
	public bar() {
		System.out.println("bar()");
	}
	@Override
	public String toString() {
		return "bar [wt=" + wt + "]";
	}

	
}
