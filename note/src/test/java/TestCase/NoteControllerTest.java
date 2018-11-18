package TestCase;

import java.util.UUID;

import org.junit.Test;

import cn.tedu.note.controller.NoteController;
import cn.tedu.note.util.JsonResult;

public class NoteControllerTest extends BaseTest{

	@Test
	public void test() throws Exception{
		NoteController nc = ctx.getBean("noteController", NoteController.class);
		JsonResult js = nc.addNote(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString());
		System.out.println(js);
	}
	@Test
	public void saveBody(){
		String NoteId="f6b3e78c-88d4-418a-bc95-f829e38dd533";
        String NoteBody = "ÄãºÃ";
		NoteController nc = ctx.getBean("noteController", NoteController.class);
		String title= "";
		nc.saveBody(NoteId, NoteBody,title);
		System.out.println(1);
	}
}
