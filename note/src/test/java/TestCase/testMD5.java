package TestCase;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class testMD5 {

	@Test
	public void testMD5() {

		String str = "123456";
		String md5 = DigestUtils.md5Hex(str);
		System.out.println(md5);
		//����ժҪ
		String salt = "��������˰�";
		md5 = DigestUtils.md5Hex(salt+str);
		System.out.println(md5);
	}

}
