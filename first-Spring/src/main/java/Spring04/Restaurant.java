package Spring04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("rest")
public class Restaurant {
	
	private waiter wait;
	@Autowired
	public void setWait(@Qualifier("wt")waiter wait){
	    System.out.println("setWait()");
		this.wait=wait;
	}
	public Restaurant() {
		System.out.println("restaurant()");
	}

	
}
