//scripts/note.js 编码一定是utf-8
var SUCCESS = 0;
var ERROR = 1;
$(function(){
	//var UserId = getCookie('UserId');
	//console.log(UserId);
	//网页加载以后立即读取笔记本列表
	console.log(1);
	loadNotebooks();
	//绑定笔记本点击事件，单击后注浆笔记本的内容展示到笔记本的区域
	$('#notebook-list').on('click','.notebook',notebooks);
	$('#note-list').on('click','.notebody',notes);
	$('#add_note').click(showAddNotebookDialog);
	$('#can').on('click','.create-note',addNote);
	$('#can').on('click','.close,.cancel',closeDialog);
	$('#save_note').click(saveNoteBody);
	$(document).click(hideNote_menu);
	
});

function moveNote(){
	//console.log(1);
	$('#can').load('alert/alert_move.html');
	var url = 'list.do';
	var data = {UserId:getCookie('UserId')};
	$.getJSON(url,data,function(result){
		if(result.state==SUCCESS){
			var notebooks = result.data;
			//在下面那个方法中将全部笔记本数据显示到notebook-list区域
			addOption(notebooks);
		}else{
			alert(result.message);
		}
	});
}
function addOption(notebooks){
	for(var i=0;i<notebooks.length;i++){
		var notebook = notebooks[i];
		var options = option.replace('[name]',notebook.cn_notebook_name);
		var options = $(options);
		options.data('NotebookId',notebook.cn_notebook_id);
		$('#moveSelect').append(options);
	}
	$('.move-note').click(updateNotebookId);
}
var option =     '<option value="none" id="[id]">[name]</option>';
function updateNotebookId(){
	//console.log(1);
	var url="updateNotebookId.do";
	var NotebookId1 = $('#moveSelect option:selected').data('NotebookId');
	var NoteId1 = $('#note-list .checked').parent().data('NoteId');
	//console.log(NotebookId1);
	//console.log(NoteId1);
	var data = {
			NoteId : NoteId1,
			NotebookId : NotebookId1
	};
	$.post(url,data,function(result){
		$('#can').empty();
	});
}
function hideNote_menu(){
		$('.note_menu').hide();
}
function showNote_menu(){
	//将除自己外的其他元素都设置为hide
	//将所有的惨淡都收起来，在显示点击的那个
	//hide放啊是异步的，调用之后的等一会才会收起来，完成之后再去调用function函数
	//$('.note_menu').hide();
	
	$(this).parent('.checked').next().show();
	return false;
	
}
function saveNoteBody(){
	var url='saveBody.do';
	var cn_note_body=$('#myEditor p').html();
	var cn_note_id = $('#note-list .checked').parent().data('NoteId');
	var cn_note_title=$('#input_note_title').val();
	
	var data = {
		NoteId:cn_note_id,
	    NoteBody:cn_note_body,
	    title:cn_note_title
	};
	$.post(url,data,function(result){
		console.log(result);
	});
}
function closeDialog(){
	$('.opacity_bg').hide();
	$('#can').empty();
}
function addNote(){
	//console.log(1);
	var title = $('#input_notebook').val();
	//console.log(title);
	var url = "addNote.do";
	//var NotebookId = $(document).data('notebookId') ;
	var NotebookId = $('.checked').parent().data('notebookId');
	console.log(NotebookId);
	var data = {UserID:getCookie('UserId'),
			cn_notebook_id:NotebookId,
			cn_note_title:title};
	$.getJSON(url,data,function(result){
		//创建成功，弹出框消失，result是新创建的Note信息
		$('.opacity_bg').hide();
		$('#can').empty();
		console.log(result);
		var li = noteTemplate.replace('[note]',data.cn_note_title);
		var li = $(li);
		li.data('NoteId',notes[i].cn_note_id);
		li.data('NoteTitle',notes[i].cn_note_title);
        $('.contacts-list').append(li);
	});
}
function showAddNotebookDialog(){
	$('#can').load('alert/alert_note.html',function(){
		$('#input_note').focus();
		$('.opacity_bg').show();
	});
}

function notes(){
	//console.log(1);
	var url = 'showText.do';
	var data = {NoteId:$(this).data('NoteId')};
	
	$(this).parent().find('a').removeClass('checked');
	$(this).find('a').addClass('checked');
	$.getJSON(url,data,function(result){
		//console.log(result);
		var notebodys = result.data;
		//console.log(notebodys);
		showNoteBody(notebodys);
	});
}


function showNoteBody(notebodys){
	var notebody= notebodys.cn_note_body;
	//console.log(notebodys);
	//console.log(notebody);
	var um = UM.getEditor('myEditor');
	um.setContent(notebody);
	//var title = $(this).data('NoteTitle');
	var title = notebodys.cn_note_title;
	//console.log(title);
	$('#input_note_title').val(title);
	
	 $('.checked').next().on('click','.btn_move',moveNote);
	
}
//笔记本项目点击事件处理方法，加载全部笔记
function notebooks(){
	$(this).parent().find('a').removeClass('checked');
	$(this).find('a').addClass('checked');
	var url = 'Notelist.do';
	var data = {NotebookId: $(this).data('notebookId') };
	//console.log(data);
	$.getJSON(url,data,function(result){
		if(result.state==SUCCESS){
			var notes = result.data;
			//console.log(notes);
			showNotes(notes);
		}else{
			alert(result.message);
		}
	});
}
//将笔记列表信息显示到屏幕上
function showNotes(notes){
	//console.log(notes);
	//将每个笔记对象显示到ul区域
	//创建li对象
	var ul = $('#note-list ul');
	ul.empty();
	//遍历那个笔记本，将全部笔记展示在全部笔记的区域
	for(var i=0;i<notes.length;i++){
		//console.log(notes[i]);
		var li = noteTemplate.replace('[note]',notes[i].cn_note_title);
		var li = $(li);
		li.data('NoteId',notes[i].cn_note_id);
		li.data('NoteTitle',notes[i].cn_note_title);
		var l = li.html();
		//console.log(l);
		ul.append(li);
	}
	$('#note-list .btn_slide_down').click(showNote_menu);
}
 var noteTemplate = 
	' <li class="online notebody">'+
	'<a  class="">'+
		'<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> [note]<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>'+
	'</a>'+
	'<div class="note_menu" tabindex="-1">'+
		'<dl>'+
			'<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>'+
			'<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>'+
			'<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>'+
		'</dl>'+
	'</div>'+
    '</li>';
function loadNotebooks(){
	//调用Ajax从服务器获取数据.
	//$.getJSON和$.post的作用和用法都一致。我们习惯上从服务器获取用get，向服务器发送用post。
	//console.log(2);
	var url = 'list.do';
	var data = {UserId:getCookie('UserId')};
	$.getJSON(url,data,function(result){
		if(result.state==SUCCESS){
			var notebooks = result.data;
			//在下面那个方法中将全部笔记本数据显示到notebook-list区域
			showNotebooks(notebooks);
		}else{
			alert(result.message);
		}
	});
}
function showNotebooks(notebooks){
	//找到显示笔记本列表的区域
	var ul = $('#notebook-list ul');
	ul.empty();
	//遍历notebooks数组，将为每个对象创建一个li元素，添加到ul元素中
	for(var i=0;i<notebooks.length;i++){
		var notebook = notebooks[i];
		//创建li元素
		var li = notebookTemplate.replace('[name]',notebook.cn_notebook_name);
		var li = $(li);
		//将notebook.id绑定到li
		li.data('notebookId',notebook.cn_notebook_id);
		
		ul.append(li); 
	}
}
var notebookTemplate = '<li class="online notebook">'+
	                   '<a  class="">'+
                       '<i class="fa fa-book" title="online" rel="tooltip-bottom">'+
                       '</i> [name]</a></li>';

