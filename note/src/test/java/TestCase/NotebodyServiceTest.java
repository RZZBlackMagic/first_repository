package TestCase;

import org.junit.Test;

import cn.tedu.note.entity.Note;
import cn.tedu.note.service.NotebodyService;
  
public class NotebodyServiceTest extends BaseTest{

	@Test
	public void notebodyServiceTest(){
		String NoteId = "c9250b3e-ed22-432c-960a-175dbc2134d1";
		NotebodyService ns = ctx.getBean("notebodyService", NotebodyService.class);
		Note text = ns.showText(NoteId);
		System.out.println(text);
	}

}
