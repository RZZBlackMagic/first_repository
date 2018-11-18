package TestCase;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class testMD5 {

	@Test
	public void testMD5() {

		String str = "123456";
		String md5 = DigestUtils.md5Hex(str);
		System.out.println(md5);
		//加盐摘要
		String salt = "今天你丑了啊";
		md5 = DigestUtils.md5Hex(salt+str);
		System.out.println(md5);
	}

}
