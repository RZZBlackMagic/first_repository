package TestCase;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.tedu.note.service.NotebookService;

public class NotebookServiceTest extends BaseTest{

	@Test
	public void test0(){
		String UserId = "03590914-a934-4da9-ba4d-b41799f917d1";
		NotebookService ns = ctx.getBean("notebookService",NotebookService.class);
		List<Map<String,Object>> list = ns.listNotebooks(UserId);
		System.out.println(list);
	}
	@Test
	public void test1(){
		String UserId = "03590914-a934-4da9-ba4d-b41799f917d1";
		NotebookService ns = ctx.getBean("notebookService",NotebookService.class);
		List<Map<String,Object>> list = ns.listNotebooks(UserId);
		System.out.println(list);
	}

}
