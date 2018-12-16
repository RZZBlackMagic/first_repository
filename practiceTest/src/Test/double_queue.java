package Test;

import java.util.Deque;
import java.util.LinkedList;

public class double_queue {

	public static void main(String[] args) {
     Deque<String> deque = new LinkedList();
     deque.offer("one");//队尾添加
     deque.offer("two");
     deque.offer("three");
     deque.offer("four");
     System.out.println(deque);
     
     String str = deque.poll();
     System.out.println(str);//one
     
     str = deque.pollLast();
     System.out.println(str);//four
     
     deque.offerFirst("five");//队首添加
     System.out.println(deque);
	}

}
