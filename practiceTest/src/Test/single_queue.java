package Test;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;

public class single_queue {

	public static void main(String[] args) {
     Queue<String>  queue = new LinkedList();
     queue.offer("one");
     queue.offer("two");
     queue.offer("three");
     queue.offer("four");
     System.out.println(queue);
     String str = queue.poll();
     System.out.println(str);
     System.out.println(queue);
	}

}
