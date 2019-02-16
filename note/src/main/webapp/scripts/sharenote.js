$(function(){
	console.log("加载活动页面")
	loadShareNotes();
	$('#first_action').on('click','.notebook',addClasses);
	$('#like_button').click(collectNote);
});
function collectNote(){
	var url = "collectNote.do";
	var shareId = $('#first_action').find('a[class="checked"]').parent().data('shareNotebookId');
	console.log(shareId);
	var data = {
		  	shareId:shareId,
		  	userId:getCookie('UserId')
	};
	$.post(url,data,function(result){
		console.log(result);
		//alert("收藏成功！");
		
	});
}
function addClasses(){
	$('#first_action').find('a').removeClass('checked');
	$(this).find('a').addClass('checked');
	//console.log(r);
	showShareNoteBody();
}
function showShareNoteBody(){
	 var shareId =$('#first_action').find('a[class="checked"]').parent().data('shareNotebookId');
	 var url = "showShareNoteBody.do";
	 var data = {
		   	 shareId:shareId
	 };
	 $.post(url,data,function(result){
		     console.log(result) 
		     $("#title_content").text(result.data.cn_share_title);
		     var r = $("#title_content").text();
             console.log(r);
		     $('#note_content').text(result.data.cn_share_body);
		     var n =$('#note_content').text();
		     console.log(n);
	 });
}
var shareNotebookTemplate = '<li class="online notebook">'+
'<a  class="">'+
'<i class="fa fa-book" title="online" rel="tooltip-bottom">'+
'</i> [name]</a></li>';


function loadShareNotes(){
	console.log("加载共享笔记");
	var url = "listShareNote.do";
	var data= {
        			
	};
	$.post(url,data,function(result){
		  //console.log(result);
		  for(var i=0;i<result.data.length;i++){
			//创建li元素
			  //console.log(1);
			  console.log(result.data[i]);
			  //console.log(result.data.length);
			  
			    var shareNotebookTitle = result.data[i].cn_share_title;
				var li = shareNotebookTemplate.replace('[name]',shareNotebookTitle);
				var li = $(li);
				console.log(result.data[i].cn_share_id);
				//将notebook.id绑定到li
				li.data('shareNotebookId',result.data[i].cn_share_id);
			    $('#first_action').find('.contacts-list').append(li);
		  }
		  
		
	});
}