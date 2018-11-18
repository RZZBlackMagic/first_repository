package TestCase;

import org.junit.Test;

import cn.tedu.note.controller.NotebodyController;
import cn.tedu.note.util.JsonResult;

public class NotebodyControllerTest extends BaseTest{

	@Test
	public void NoteBodytest(){
		String NoteId = "c9250b3e-ed22-432c-960a-175dbc2134d1";
		NotebodyController nc = ctx.getBean("notebodyController", NotebodyController.class);
		JsonResult text = nc.showTextController(NoteId);
		System.out.println(text);
	}
	

}
