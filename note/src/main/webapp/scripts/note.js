//scripts/note.js 编码一定是utf-8
var SUCCESS = 0;
var ERROR = 1;
$(function(){
	//var UserId = getCookie('UserId');
	//console.log(UserId);
	//网页加载以后立即读取笔记本列表
	console.log("dfa");
	loadNotebooks();
	//绑定笔记本点击事件，单击后注浆笔记本的内容展示到笔记本的区域
	$('#notebook-list').on('click','.notebook',notebooks);
	$('#note-list').on('click','.notebody',notess);
	$('#add_note').click(showAddNoteDialog);
	$('#can').on('click','.close,.cancel',closeDialog);
	$('#save_note').click(saveNoteBody);
	$(document).click(hideNote_menu);
	//startHartbat();
	$('#add_notebook').click(showAddNotebookDialog1);
	$('#trash_button').click(getDeleteNotes);
    //收藏笔记本
	//$('#like_button').click(collectNote);
    $('#second_side_right').on('click','.btn_share',shareNote);
   // $('#first_side_right').find('li').click(editNotebookTitle);
    $('#action_button').click(forbid);
    $('#notebook-list').on('mousedown','.notebook',editNotebookTitle);
    $('#second_side_right').find("li").click(editNoteTitle);
    $('#like_button').click(showCollectNotes);
    $('#upload_note').click(showUploadAlert);
});
//加载上传笔记的对话框
function showUploadAlert(){
	$('#can').load('alert/alert_upload.html',reloadSuccess);
}
function reloadSuccess(){
	$('#upload').click(uploadNote);
}
//上传笔记
function uploadNote(){
	 console.log("可似乎上传笔记");
    	 var file1 = $('#file1')[0].files[0];
    	 console.log("file"+file1.webkitRelativePath);
    	 
    	 var filename = document.getElementById("file1").value;
    	    // 这时的filename不是 importFile 框中的值
    	 console.log("路径："+filename);
    	    
    	 //创建内存中的表单对象
    	 var form = new FormData();
    	 //添加向服务器传输的数据
    	 form.append('uploadFile',file1);
    	 //console.log(form);

    	 $.ajax({
    		 url:'upload.do',
    		 data:form,
    		 type:'POST',
    		 dataType:'json',
    		 contentType:false,
    		 processData:false,
    		 success:function(obj){
    			 console.log(obj)
    			 $('#can').empty();
    		 }
    	 });
     
}
//下载笔记
function download(){
	console.log("开始下载笔记");
	var r = $(this).parent().parent().parent().parent().html();
	console.log(r);
	var noteId = $(this).parent().parent().parent().parent().data("NoteId");
	console.log(noteId);
	var url = "download.do";
	var path = "D:\\demo1\\test";
	var data = {
			path : path,
			noteId : noteId
	};
	$.post(url,data,function(result){
		   console.log(result);
	});
}
function showCollectNotes(){
	var url = "showCollectNotes.do";
	var data ={
			userId:getCookie('UserId')
	};
	$.post(url,data,function(result){
		  //console.log(result.data);
		  var ul = $('#note-list ul');
			ul.empty();
				//遍历那个笔记本，将全部笔记展示在全部笔记的区域
				for(var i=0;i<result.data.length;i++){
					var li = noteTemplate.replace('[note]',result.data[i].cn_share_title);
					var li = $(li);
					li.data('NoteId',result.data[i].cn_note_id);
					li.data('NoteTitle',result.data[i].cn_share_title);
					var l = li.html();
					//console.log(l);
					ul.append(li);
				}
				//定义删除收藏笔记功能
		        $('#second_side_right').on('click','.notebody',addClassForCollectNote);
		        
	});
}
function addClassForCollectNote(){
	$('#second_side_right').find('a').removeClass('checked');
	$(this).find('a').addClass('checked');
	showCollectNoteBody();
}
function showCollectNoteBody(){
	//console.log("加载共享笔记的内容");
	var shareNoteId = $('#second_side_right').find('a[class="checked"]').parent().data("NoteId");
	//console.log(shareNoteId);
	var url = "showShareNote.do";
	var data = {
			NoteId : shareNoteId
	};
	$.post(url,data,function(result){
		//console.log(result);
		//console.log(result.data);
		var body = result.data.cn_share_body;
		var title = result.data.cn_share_title;
		//console.log(body);
		//console.log(title);
		$('#input_note_title').val(title);
		var um = UM.getEditor('myEditor');
		um.setContent(body);
	});
}
function forbid(e){
	 //console.log("禁止");
}
function editNoteTitle(){
	//console.log("笔记早上好");
}
function editNotebookTitle(e){
	 e.preventDefault();

	if(e.which==3){
		//console.log("右键单击事件");
		var title = $(this).text();
		var notebookId = $(this).data('notebookId');
		SetCookie('notebookId',notebookId);
		$('#can').load('alert/alert_rename.html',delayLoad);
		
		
	}
	
	 return false;
}
function delayLoad(){
	var ar = $("#renameNotebook").html();
	//console.log(ar);
    $("#renameNotebook").click(renameNotebookName);
    console.log(3);
}
function renameNotebookName(){
	//console.log(2);
	var title = $('#input_notebook_rename').val();
	//console.log(title);
	var notebookId = getCookie('notebookId');
	//console.log(notebookId);
	var url = "renameNotebook.do";
	var data = {
			title:title,
			notebookId:notebookId
	};
	$.post(url,data,function(result){
		//console.log(result);
		delCookie('notebookId');
		$('#can').empty();
		loadNotebooks();
	});
}


function shareNote(){
	//console.log("1");
	var url = "shareNote.do";
	var selectedNoteId = $('#second_side_right').find('a[class="checked"]').parent().data("NoteId");
	//console.log(selectedNoteId);
	var data = {
		noteId:selectedNoteId	
	};
	//console.log(data);
    $.getJSON(url,data,function(result){
			console.log(result);
			if(result.message=='请选择正确的笔记！'){
				alert("该笔记已被删除！");
			}else if(result.message=='该笔记已添加至共享笔记'){
				alert('该笔记已经被添加至共享笔记');
			}
		});
	
}
function getDeleteNotes(){
	var url = "showDeleteNote.do";
    $.getJSON(url,function(result){
    	//console.log(result);
    	//console.log(4);
    	showDeleteNotes(result);
    	//console.log(3);
    });
}
function showDeleteNotes(result){
	//console.log(22);
	var ul = $('#note-list ul');
	ul.empty();
	//遍历那个笔记本，将全部笔记展示在全部笔记的区域
	for(var i=0;i<result.data.length;i++){
		//console.log(notes[i]);
		var li = noteTemplate.replace('[note]',result.data[i].cn_note_title);
		var li = $(li);
		li.data('NoteId',result.data[i].cn_note_id);
		li.data('NoteTitle',result.data[i].cn_note_title);
		li.click(loadDealDelNote);
		//li.click(showNote_menu);
		//var i = li.find('button[class="btn_slide_down"]').html()//click(showNote_menu);
		var l = li.html();
		//console.log(i);
		ul.append(li);
	}
	
}

function loadDealDelNote(){
	//console.log("处理回收站笔记");
	$('#can').load('alert/alert_replay.html',dealDelNote);
}
function dealDelNote(){
	var noteId = $('#note-list').find('a[class="checked"]').parent().data('NoteId');
	//console.log(noteId);
	var url = 'list.do';
	var data = {UserId:getCookie('UserId')};
	$.getJSON(url,data,function(result){
		//console.log(result);
		if(result.state==SUCCESS){
			var notebooks = result.data;
			//在下面那个方法中将全部笔记本数据显示到notebook-list区域
			
			for(var i=0;i<notebooks.length;i++){
				var notebook = notebooks[i];
				var options = option.replace('[name]',notebook.cn_notebook_name);
				var options = $(options);
				//console.log(options);
				options.data('NotebookId',notebook.cn_notebook_id);
				$('#replaySelect').append(options);
			}
		}else{
			alert(result.message);
		}
	});
	//var r = $('#modalBasic_3').find('button[class="btn-replay"]').html();//click(replayNote);
	//console.log(r);
    $('.btn-replay').click(replayNote);
}
function replayNote(){
	//console.log("开始恢复笔记");
	var NotebookId = $('#replaySelect option:selected').data('NotebookId');
	//console.log(NotebookId);
	var noteId = $('#note-list').find('a[class="checked"]').parent().data('NoteId');
    //console.log(noteId);
    //先在回收站将该该笔记的信息查出来，将notebookId 改为所选中的笔记本，在将该笔记在删掉。完成后重新加载回收站笔记
    var url = "replayDelNote.do";
    var data = {
    	noteId:noteId,
    	notebookId:NotebookId
    };
    $.post(url,data,function(result){
    	//console.log(result);
    	//移动成功后重新加载回收站
    	$('#can').empty();
    	getDeleteNotes();
    });
}
//添加笔记业务
function addNotebook(){
	//console.log("添加笔啊");
	var title1 = $('#input_notebook').val();
	//console.log('title'+title1);
	var UserId1 = getCookie('UserId');
	//console.log('UserId'+UserId1);
	var url = "addNotebook.do";
	var data={
		title:title1,
		UserId:UserId1
	};
	$.post(url,data,function(result){
		//console.log(result);
		//添加成功，先关闭添加笔记对话框，在重新将笔记展示到笔记本区域
		$('.opacity_bg').hide();
		$('#can').empty();
		loadNotebooks();
	});
	
}
//展示添加笔记本对话框
function showAddNotebookDialog1(){
	//console.log("添加笔记本");
	$('#can').load('alert/alert_notebook.html',function(){
		$('#input_note').focus();
		$('.opacity_bg').show();
		//console.log("hh");
		addNotebookTran();
	});
}
function addNotebookTran(){
	//console.log(2);
	var context = $('#can').find('button[class="create_notebook"]').html();
	//console.log(context);
	$('#can').on('click','.create_notebook',addNotebook);
}
function startHartbat(){
	var url = "/session.do";
	setTimeout(function(){
		$.getJSON(url,function(result){
			console.log(result.message);
		});
	},5000);
}
function moveNote(){
	//console.log(1);
	$('#can').load('alert/alert_move.html',moveNoteTo);
	
}
function moveNoteTo(){
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
		var url = "Notelist.do";
		var NotebookId = $("#first_side_right").find('a[class="checked"]').parent().data('notebookId');
		var data = {
			NotebookId : NotebookId	
		};
		$.getJSON(url,data,function(result){
			if(result.state==SUCCESS){
				var notes = result.data;
				//console.log(notes);
				showNotes(notes);
			}else{
				alert(result.message);
			}
		});
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
    $('#second_side_right').find('button[title="download"]').click(download);
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
		//console.log(result);
		var notebookId = $('#first_side_right').find('a[class="checked"]').parent().data('notebookId');
		var url = 'Notelist.do';
		var data = {NotebookId: notebookId };
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
	});
}
function closeDialog(){
	$('.opacity_bg').hide();
	$('#can').empty();
}
function addNote(){
	//console.log(1);
	var title = $('#input_note').val();
	//console.log(title);
	var url = "addNote.do";
	//var NotebookId = $(document).data('notebookId') ;
	var NotebookId = $('.checked').parent().data('notebookId');
	//console.log(NotebookId);
	var data = {UserID:getCookie('UserId'),
			cn_notebook_id:NotebookId,
			cn_note_title:title
			};
	$.getJSON(url,data,function(result){
		//创建成功，弹出框消失，result是新创建的Note信息
		$('.opacity_bg').hide();
		$('#can').empty();
		//console.log(result);
		//notebooks(result);
		//正确的业务是：用NotebookID将所有的Note查询出来返回到这里，遍历将id和title绑到li上，最后调用showNotes（）
		
		var cn_note_id = result.data.cn_note_id;
		var cn_note_title = result.data.cn_note_title;
		//console.log(cn_note_id);
		//console.log(cn_note_title);
		
		var li = noteTemplate.replace('[note]',data.cn_note_title);
		var li = $(li);
		li.data('NoteId',cn_note_id);
		li.data('NoteTitle',cn_note_title);
        $('.contacts-list').append(li);
		
	});
}
function showAddNoteDialog(){
	$('#can').load('alert/alert_note.html',function(){
		$('#input_note').focus();
		$('.opacity_bg').show();
		$('#can').on('click','.create-note',addNote);
	});
}

function notess(){
	//console.log(1);
	//console.log("展示笔记");
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
	//console.log(notebodys);
	var notebody= notebodys.cn_note_body;
	//console.log(notebodys);
	//console.log(notebody);
	var um = UM.getEditor('myEditor');
	um.setContent(notebody);
	//var title = $(this).data('NoteTitle');
	var title = notebodys.cn_note_title;
	//console.log(title);
	$('#input_note_title').val(title);
	//定义移除笔记事件
	 $('.checked').next().on('click','.btn_move',moveNote);
	//定义删除事件
	 $('.checked').next().on('click','.btn_delete',deleteNote);
}
function deleteNote(){
	//console.log("删除笔记");
	var url = "deleteNote.do";
	var data1= $(this).parent().parent().parent().parent().data('NoteId');
	//console.log(data1);
	var data = {
			NoteId:data1
	}
	var NotebookId = $("#first_side_right").find('a[class="checked"]').parent().data('notebookId');
    //console.log(NotebookId);
	$.post(url,data,function(result){
		//console.log(result);
		//删除成功，重新加载笔记列表
		var url = "Notelist.do";
		var NotebookId = $("#first_side_right").find('a[class="checked"]').parent().data('notebookId');
		var data = {
			NotebookId : NotebookId	
		};
		$.getJSON(url,data,function(result){
			if(result.state==SUCCESS){
				var notes = result.data;
				//console.log(notes);
				showNotes(notes);
			}else{
				alert(result.message);
			}
		});
	});
}
//笔记本项目点击事件处理方法，加载全部笔记
function notebooks(){
	//console.log("开始加载笔记本");
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
	$('#note-list').on('click','.notebody',notess);
	
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
			'<dt><button type="button" class="btn btn-default btn-xs " title="download"><i class="fa fa-times"></i></button></dt>'+
		'</dl>'+
	'</div>'+
    '</li>';
function loadNotebooks(){
	//调用Ajax从服务器获取数据.
	//$.getJSON和$.post的作用和用法都一致。我们习惯上从服务器获取用get，向服务器发送用post。
	console.log(2);
	var url = 'list.do';
	var data = {UserId:getCookie('UserId')};
	//console.log(getCookie('UserId'));
	$.getJSON(url,data,function(result){
		console.log(result);
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
	//console.log("定义展开笔记ben ");
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



 var t = 
	 '<div class="item-box">'+
     '<div class="item-table J_cartGoods" id="item_table" data-info="{ commodity_id:'+'1161200012'+", "+'gettype:'+'buy'+", "+'itemid:'+"'"+'2161200012_0_buy'+"'"+", "+'num:'+"'4'} "+'">'+
	 '<div class="item-row clearfix">'+
         '<div class="col col-check">'+
         '<i class="iconfont icon-checkbox icon-checkbox  J_itemCheckbox" data-itemid="2161200012_0_buy" data-status="0">√</i>'+
         '</div>'+
         '<div class="col col-img">'+
            '<a href="//item.mi.com/1161200012.html" target="_blank" data-stat-id="b3fe5630e5ece9ed" onclick="_msq.push(['+'trackEvent'+","+ ' 5df97b551662ffe7-b3fe5630e5ece9ed'+", "+'//item.mi.com/1161200012.html'+", "+'pcpid'+", "+"'"+"'"+"]);"+'"'+">"+
            '<img alt="" src="//i1.mifile.cn/a1/pms_1510291188.31088548!80x80.jpg" width="80" height="80">'+
          '</a>'+
         '</div>'+
             '<div class="col col-name">'+
             '<div class="tags"></div>'+
         '<div class="tags"></div>'+
           '<h3 class="name">'
           '<a href="//item.mi.com/1161200012.html" target="_blank" data-stat-id="23537ce6324466fd" onclick="_msq.push(['+'trackEvent'+", "+'5df97b551662ffe7-23537ce6324466fd'+", "+'//item.mi.com/1161200012.html'+", "+'pcpid'+", "+"'"+"'"+']);"> 小米USB充电器（4口） 白色 </a>'+
         '</h3>'+
         '</div>'+
         '<div class="col col-price"> 59元 </div>'+
         '<div class="col col-num">'+
             '<div class="change-goods-num clearfix J_changeGoodsNum">'+
             '<a href="#" class="J_minus" onclick="sub()">'+
            '<!--<i class="fa fa-minus"></i>-->'+
             '<img src="assets/img/sub.png" class="iconfont" style="padding-top: 5px;"/>'+
           '</a>'+
        '<input tyep="text" name="2161200012_0_buy" value="1" data-num="4" data-buylimit="5" autocomplete="off" class="goods-num J_goodsNum" "="">'+
        '<a href="#" class="J_plus">'+
            '<!--<i class="fa fa-plus"></i>-->'+
            '<img src="assets/img/add.png" class="iconfont"/>'+
        '</a>'+
        '<div class="msg J_canBuyLimit">还可买 1 件</div>'+
    '</div>'+
    '</div>'+
        '<div class="col col-total"> 236元 <p class="pre-info">  </p> </div>'+
       '<div class="col col-action">'+
       '<a id="2161200012_0_buy" data-msg="确定删除吗？" href="javascript:void(0);" title="删除" class="del J_delGoods" data-stat-id="163da9c724cdbb9f" onclick="_msq.push(['+'trackEvent'+", "+'5df97b551662ffe7-163da9c724cdbb9f'+", "+'javascript:void0'+", "+'pcpid'+", "+"'"+"'"+']);">'+
        '<i class="fa fa-remove"></i>'+
       '</a>'+
       '</div>'+
       '</div>';
	 '</div>'+
	 '</div>';
 
 '<div class="item-box">'+
 ' <div class="item-table J_cartGoods" id="item_table" data-info="{ commodity_id:'+"'"+'1161200012'+"'"+', '+"gettype:"+"'"+"buy"+"'"+", "+"itemid:"+"'"+"2161200012_0_buy"+"'"+", num:"+"'"+"4'"+'} ">'+
     '<div class="item-row clearfix">'+
'         <div class="col col-check">'+
'             <i class="iconfont icon-checkbox icon-checkbox  J_itemCheckbox" data-itemid="2161200012_0_buy" data-status="0">√</i>'+
        ' </div>'+
         '<div class="col col-img">'+
            '<a href="//item.mi.com/1161200012.html" target="_blank" data-stat-id="b3fe5630e5ece9ed" onclick="_msq.push(['+"'"+'trackEvent'+"'"+", "+"'"+'5df97b551662ffe7-b3fe5630e5ece9ed'+"'"+', '+"'"+"//item.mi.com/1161200012.html"+"'"+', '+"'"+"pcpid"+"'"+", "+"''"+"]);"+'"'+'>'+
              '   <img alt="" src="//i1.mifile.cn/a1/pms_1510291188.31088548!80x80.jpg" width="80" height="80">'+
             '</a>'+
         '</div>'+
         '<div class="col col-name">'+
         '    <div class="tags"></div>'+
         '    <div class="tags"></div>'+
          '   <h3 class="name">'+
               '  <a href="//item.mi.com/1161200012.html" target="_blank" data-stat-id="23537ce6324466fd" onclick="_msq.push(['+"'trackEvent', '5df97b551662ffe7-23537ce6324466fd', '//item.mi.com/1161200012.html', 'pcpid', '']);"+'"'+'> 小米USB充电器（4口） 白色 </a>'+
             '</h3>'+
          ' </div>'+
         '<div class="col col-price"> 59元 </div>'+
         '<div class="col col-num">'+
            ' <div class="change-goods-num clearfix J_changeGoodsNum">'+
              '   <a href="#" class="J_minus" onclick="sub()">'+
                  '   <!--<i class="fa fa-minus"></i>-->'+
                  '   <img src="assets/img/sub.png" class="iconfont" style="padding-top: 5px;"/>'+
                 '</a>'+
                 '<input tyep="text" name="2161200012_0_buy" value="1" data-num="4" data-buylimit="5" autocomplete="off" class="goods-num J_goodsNum" "="">'+
                 '<a href="#" class="J_plus">'+
                    ' <!--<i class="fa fa-plus"></i>-->'+
                     '<img src="assets/img/add.png" class="iconfont"/>'+
                 '</a>'+
                 '<div class="msg J_canBuyLimit">还可买 1 件</div>'+
             '</div>'+
        ' </div>'+
         '<div class="col col-total"> 236元 <p class="pre-info">  </p> </div>'+
         '<div class="col col-action">'+
            ' <a id="2161200012_0_buy" data-msg="确定删除吗？" href="javascript:void(0);" title="删除" class="del J_delGoods" data-stat-id="163da9c724cdbb9f" onclick="_msq.push(['+"'trackEvent', '5df97b551662ffe7-163da9c724cdbb9f', 'javascript:void0', 'pcpid', '']);"+'">'+
                ' <i class="fa fa-remove"></i>'+
      '         </a>'+
      '         </div>'+
      '    </div>'+

     '</div>'+
     '</div>';
