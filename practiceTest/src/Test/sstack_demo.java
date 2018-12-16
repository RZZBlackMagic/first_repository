package Test;

import java.util.Deque;
import java.util.LinkedList;

public class sstack_demo {

	public static void main(String[] args) {
    Deque<String> stack = new LinkedList<String>();
    stack.push("one");
    stack.push("two");
    stack.push("three");
    stack.push("four");
    System.out.println(stack);
    String str = stack.pop();
    System.out.println(str);
	}

}
