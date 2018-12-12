package Day01;
/**
 * 当前类是用来测试文档注释使用的
 * 文档注释只在三个地方使用：
 *  类，常量，方法（静态方法，成员方法，构造方法）
 * @author asus
 *
  * @version 1.204，06/09/06
 * @see   java.lang.StringBuffer
 * @since JDK1.0
 */
public class APIDocDemo {
    /**
     * 为给定用户添加一个问候语
     * @param name  给定用户的名字
     * @return   含有问候语的字符串g
     */
	public static  String sayHello(String name){
		return "你好"+name;
			
	}

}
