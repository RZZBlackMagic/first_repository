<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">

<head>
    <title>Notifications</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- VENDOR CSS -->
    <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/vendor/linearicons/style.css">
    <link rel="stylesheet" href="assets/vendor/toastr/toastr.min.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="assets/css/main.css">
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link rel="stylesheet" href="assets/css/demo.css">
    <!-- GOOGLE FONTS -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
    <link rel="stylesheet" type="text/css" href="assets/vendor/ztree/css/metroStyle/metroStyle.css" />

    <!-- bootstarpeditable相关css -->
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="assets/vendor/bootstrap3-editable/css/bootstrap-editable.css" rel="stylesheet" />
    <link href="assets/vendor/bootstrap-table/bootstrap-table.css" rel="stylesheet" />
</head>
<body>
<!-- WRAPPER -->
<div id="wrapper">
    <!-- NAVBAR -->
    <jsp:include page="template/nav.jsp"/>
    <!-- END NAVBAR -->
    <!-- LEFT SIDEBAR -->
    <jsp:include page="template/list.jsp"/>
    <!-- END LEFT SIDEBAR -->
    <!-- MAIN -->
    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div class="container-fluid">
                <h3 class="page-title">网站首页内容管理</h3>

                <div class="row">
                    <div class="col-md-2">
                        <div id="left"  style="display:inline;width:100%;border:1px solid #b0c4de;float:left;">
                            <ul id="treeDemo" class="ztree"  style="width:100%;left:5px;font-size:10px;color:#000">

                            </ul>

                        </div>
                    </div>

                    <div class="col-md-10" id="right" style="width:75%;float:left;border:1px solid #b0c4de;">
                        <div class="card">
                            <div id="showTable">
                                <div id="toolbar">
                                    <a><button  id="add-good"  class="btn btn-default" type="button" style="float: left;border-top-right-radius: 0%;border-bottom-right-radius: 0%;">
                                        <span class="fa fa-plus" ></span>
                                    </button></a>
                                    <button  id="remove-good" class="btn btn-default" type="button" style="margin-right: 5px;float: left;border-top-left-radius: 0%;border-bottom-left-radius: 0%;border-left:0;">
                                        <span class="fa fa-minus"></span>
                                    </button>
                                </div>
                                <table id="table" data-buttons-align="right"></table>

                            </div>

                            <div class="col-lg-9" id="showForm" style="display:none">
                                <form class="form-horizontal" role="form" onsubmit="clickSubmit()" id="form">
                                    <legend style="margin-bottom: 30px;">添加商品</legend>
                                    <ul>
                                        <li>
                                            <div class="form-group" style="margin-bottom: 20px">
                                                <label for="name" class="col-lg-3 control-label">内容类别</label>
                                                <div class="col-lg-10">
                                                    <input type="text" class="form-control" name="name" placeholder="请输入内容类别">
                                                </div>
                                            </div>
                                        </li>



                                        <li>
                                            <div class="form-group">
                                                <div class="col-lg-offset-2 col-lg-4" >
                                                    <button type="button" id="submit" class="btn btn-success" >确认</button>
                                                    &nbsp&nbsp&nbsp
                                                    <button type="reset" class="btn btn-default" onclick="clickExit()" >返回</button>
                                                </div>

                                            </div>
                                        </li>
                                    </ul>
                                </form>
                            </div>

                            <div class="col-lg-9" id="showContentForm" style="display:none">
                                <form class="form-horizontal" role="form" onsubmit="clickSubmit()" id="form">
                                    <legend style="margin-bottom: 30px;">添加商品内容</legend>
                                    <ul>
                                        <li>
                                            <div class="form-group" style="margin-bottom: 20px">
                                                <label for="title" class="col-lg-3 control-label">内容标题</label>
                                                <div class="col-lg-10">
                                                    <input type="text" class="form-control" name="title" placeholder="请输入内容标题">
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="form-group" style="margin-bottom: 20px">
                                                <label for="subTitle" class="col-lg-3 control-label">子标题</label>
                                                <div class="col-lg-10">
                                                    <input type="text" class="form-control" name="subTitle" placeholder="请输入子标题">
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="form-group" style="margin-bottom: 20px">
                                                <label for="titleDesc" class="col-lg-3 control-label">标题描述</label>
                                                <div class="col-lg-10">
                                                    <input type="text" class="form-control" name="titleDesc" placeholder="请输入标题描述">
                                                </div>
                                            </div>
                                        </li>

                                        <li>
                                            <div class="form-group" style="margin-bottom: 20px">
                                                <label for="url" class="col-lg-3 control-label">链接</label>
                                                <div class="col-lg-10">
                                                    <input type="text" class="form-control" name="url" placeholder="请输入链接">
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="form-group" style="margin-bottom: 20px">
                                                <label for="pic" class="col-lg-3 control-label">图片1</label>
                                                <div class="col-lg-10">
                                                    <input type="text" class="form-control" name="pic" placeholder="请输入图片1">
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="form-group" style="margin-bottom: 20px">
                                                <label for="pic2" class="col-lg-3 control-label">图片2</label>
                                                <div class="col-lg-10">
                                                    <input type="text" class="form-control" name="pic2" placeholder="请输入图片2">
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="form-group" style="margin-bottom: 20px">
                                                <label for="content" class="col-lg-3 control-label">内容</label>
                                                <div class="col-lg-10">
                                                    <input type="text" class="form-control" name="content" placeholder="请输入内容">
                                                </div>
                                            </div>
                                        </li>

                                        <li>
                                            <div class="form-group">
                                                <div class="col-lg-offset-2 col-lg-4" >
                                                    <button type="button" id="submit1" class="btn btn-success" >确认</button>
                                                    &nbsp&nbsp&nbsp
                                                    <button type="reset" class="btn btn-default" onclick="clickExit()" >返回</button>
                                                </div>

                                            </div>
                                        </li>
                                    </ul>
                                </form>
                            </div>

                        </div>
                    </div>
                </div>


            </div>
        </div>
        <!-- END MAIN CONTENT -->
    </div>
    <!-- END MAIN -->
    <div class="clearfix"></div>
    <footer>
        <div class="container-fluid">
            <p class="copyright">Copyright &copy; 2017.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
        </div>
    </footer>
</div>
<!-- END WRAPPER -->
<!-- Javascript -->
<script src="assets/vendor/jquery/jquery.min.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="assets/vendor/toastr/toastr.min.js"></script>
<script src="assets/scripts/klorofil-common.js"></script>



<!-- Javascript -->
<script src="assets/vendor/ztree/js/jquery.ztree.all.js"></script>
<script src="assets/scripts/klorofil-common.js"></script>
<script src="assets/scripts/custom-scripts.js"></script>
<!-- bootstrap-editable相关js -->
<script src="assets/vendor/bootstrap/js/bootstrap.js"></script>
<script src="assets/vendor/bootstrap3-editable/js/bootstrap-editable.js"></script>
<script src="assets/vendor/bootstrap-table/bootstrap-table.min.js"></script>
<script src="assets/vendor/bootstrap-table/bootstrap-table-zh-CN.min.js"></script>
<script src="assets/vendor/bootstrap3-editable/js/bootstrap-table-editable.js"></script>

<!-- bootstrap-editable相关js -->
<script>

    //console.log(1);
    var url='/portal/ztree/content_category.do';
    $.ajax({
        url:url,
        dataType:'json',
        processData: false,
        type:'get',
        success:function(result){
            //console.log(result);
            //console.log('您现在访问的是：'+url);
            var zNodes=result.data;
            var t = $("#treeDemo");
            //初始化ztree
            t = $.fn.zTree.init(t, setting, zNodes);
        },
        error:function(XMLHttpRequest, textStatus, errorThrown) {
            //.log('fail');
        }});

    var setting= {

        view: {
            selectedMulti: true, //设置是否能够同时选中多个节点
            showIcon: true,      //设置是否显示节点图标
            showLine: true,      //设置是否显示节点与节点之间的连线
            showTitle: true,     //设置是否显示节点的title提示信息

        },

        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "pId",
                rootPId: ""
            }
        },

        callback: {
            //点击Ztree内容执行事件
            beforeClick: function (treeId, treeNode) {
                //console.log(3);
                //console.log(treeNode);
                //请求后台根据选中的ID去看他是否为子叶节点，是则初始化内容table，不是则初始化内容分类table
                var url = "/portal/ContentCategory/isParent.do";
                var data = {
                    id:treeNode.id
                };
                $('#left').data("treeNodeId",treeNode.id);
                //console.log(data);
                $.post(url,data,function(result){
                    //console.log(result);
                    //console.log(result.data);
                    if(result.data==0){
                        //不是子叶节点，初始化内容table
                        $("#table").bootstrapTable('destroy');
                        initContentTable('/portal/content/editContent.do',treeNode.id);
                        // $('#add-good').click(clickPlusContent());
                        $('#submit1').unbind();
                        $('#remove-good').unbind();
                        $('#add-good').unbind();

                        $('#add-good').bind('click',clickContentPlus);
                        $('#submit1').bind('click',clickContentSubmit);
                        $('#remove-good').bind('click',clickMinusContent);
                    }
                    if(result.data==1){
                        //是子叶节点，初始化内容分类table
                        $("#table").bootstrapTable('destroy');
                        initTable('/portal/bootstrap/editContentCategory.do',treeNode.id);
                        $('#remove-good').unbind();
                        $('#submit').unbind();
                        $('#add-good').unbind();

                        $('#add-good').bind('click',clickCategoryPlus)
                        $('#submit').bind('click',clickCategorySubmit);
                        $('#remove-good').bind('click',clickMinusCategory);

                    }
                });

            },

        }
        /*edit:{
            enable:true,
            showRenameBtn:true,
            showRemoveBtn:true,
            removeTitle:"删除",
            renameTitle:"修改"
        }*/


    }
    //添加商品内容
    function clickContentSubmit(){
        var category_id = $(table).data('id');
        //console.log(category_id);
        //console.log('添加商品内容');
        var url = "/protal/content/addContent.do";
        var data = {
            'categoryId':category_id,
            'title':$("input[name='title']").val(),
            'subTitle':$("input[name='subTitle']").val(),
            'titleDesc':$("input[name='titleDesc']").val(),
            'url':$("input[name='url']").val(),
            'pic':$("input[name='pic']").val(),
            'pic2':$("input[name='pic2']").val(),
            'content':$("input[name='content']").val()
        }
        //console.log(data);
        $.post(url,data,function(result){
            //console.log(result);
            $('input').val("");
            clickExit();
            //console.log('移除商品'+$('#left').data('treeNodeId'));
            $("#table").bootstrapTable('destroy');
            initContentTable('/portal/content/editContent.do',$('#left').data('treeNodeId'));
        });

    }
    //移除商品内容
    function clickMinusContent() {
        var category_id = $(table).data('id');
        //console.log(category_id);
        //console.log('移除商品内容');
        var rows = $(table).bootstrapTable('getSelections');
        //console.log(rows[0].id);
        var  id ='';
        for(var i=0;i<rows.length;i++){
            id=id+rows[i].id+',';
        }
        //console.log(id);
        var url = '/protal/bootstrap/deleteContent.do';
        var data = {
            id:id
        };
        $.post(url,data,function(result){
            //console.log('         '+$('#left').data('treeNodeId'));
            $("#table").bootstrapTable('destroy');
            initContentTable('/portal/content/editContent.do',$('#left').data('treeNodeId'));
            //页面局部刷新
        });
    }


    //添加商品分类
    function clickCategoryPlus(){
        $('#showContentForm').hide();
        $("#showTable").hide();
        $("#showForm").show();

    }
    function clickContentPlus(){
        $("#showTable").hide();
        $("#showForm").hide();
        $('#showContentForm').show();
    }
    //移除商品分类
    function clickMinusCategory(){
        //console.log('移除商品分类');
        var rows = $(table).bootstrapTable('getSelections');
        //console.log(rows[0].id);
        var  id ='';
        for(var i=0;i<rows.length;i++){
            id=id+rows[i].id+',';
        }
        //console.log(id);
        var name  = $("input[name='btSelectItem']").parents('.selected').find('td:eq(1)').text();
        //console.log(name);
        var url = '/portal/bootstrap/removeContentCategory.do';
        var data = {
            'id':id,
            'name':name
        };
        //console.log(data);
        $.post(url,data,function(result){
            $("#table").bootstrapTable('destroy');
            initTable('/portal/bootstrap/editContentCategory.do',$('#left').data('treeNodeId'));
            //console.log(result);
        });

    }
    function clickCategorySubmit(){
        //console.log('添加商品分类');
        //console.log($("#form").find('.form-control[name="name"]').val());
        //console.log($(table).data("id"));
        var name = $("#form").find('.form-control[name="name"]').val()
        var id = $(table).data("id");//新增节点的父节点
        //console.log(id+name);
        //$("#cid").attr("placeholder", $("#table").data("category_id"));
        var  data={
            "name":name,
            "id":id
        };
        var url = '/portal/bootstrap/addContentCategory.do';
        //console.log(data);
        $.post(url,data,function(result){
            //console.log(result);
            //console.log("成功");
            $('input').val("");
            clickExit();
            $("#table").bootstrapTable('destroy');
            initTable('/portal/bootstrap/editContentCategory.do',$('#left').data('treeNodeId'));
        });
    }


    function clickExit(){
        $("#showTable").show();
        $('#showContentForm').hide();
        $("#showForm").hide();
    }




    //初始化内容分类的table
    function initTable( edit_url,id) {
        $(table).data("id",id);
        $("#table").bootstrapTable({
            url: "/portal/initTable/contentCategory.do",       //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            contentType: "application/x-www-form-urlencoded",
            dataType: "json",
            toolbar: '#toolbar',                //工具按钮用哪个容器
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 15,                       //每页的记录行数（*）
            pageList: [15, 30, 50, 100],        //可供选择的每页的行数（*）
            showColumns: true,                  //是否显示所有的列
            height: 750,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            queryParamsType: 'limit',//查询参数组织方式
            queryParams: function (params) {//上传服务器的参数
                var temp = {//如果是在服务器端实现分页，limit、offset这两个参数是必须的
                    id: id,
                    limit: params.limit, // 每页显示数量
                    page: (params.offset / params.limit) + 1   //当前页码
                };
                return temp;
            },
            columns: [
                {
                    checkbox: true, // 显示一个勾选框
                    align: 'center' // 居中显示
                },
                {
                    field: 'name',
                    title: '商品内容分类名字',
                    editable: {
                        type: 'text',
                        title: '修改商品内容分类名字',
                        placement: 'right',
                        emptytext: "空文本",
                        validate: function(v) {
                            if (!v) return '用户名不能为空';
                        }
                    }
                },
                {
                    field: 'created',
                    title: '创建时间',
                    formatter: function (value, row, index) {
                        return changeDateFormat(value);
                    }

                },
                {
                    field: 'id',
                    title: 'ID',
                    visible:false
                },
                {
                    field: 'updated',
                    title: '更新时间',
                    formatter: function (value, row, index) {
                        return changeDateFormat(value);
                    }
                },
                {
                    field: '',
                    title: '操作',
                    align: 'center',
                    formatter: function () {
                        var result = "";
                        result += "<a href='javascript:;' class='btn btn-xs' title='编辑'><span class='glyphicon glyphicon-cog'></span></a>";
                        return result;
                    }
                }

            ],
            onEditableSave: function ( field, row ) {
                //console.log(9);
                //console.log(field);
                //console.log(row);
                $.ajax({
                    type: "post",
                    url: edit_url,
                    data:{
                        'id':row.id,
                        'parentId':row.parentId,
                        'name':row.name,
                        'status':row.status,
                        'sortOrder':row.sortOrder,
                        'isParent':row.isParent,
                        'created':row.created,
                        'updated':row.updated

                    },
                    dataType: 'JSON',
                    success: function (result) {
                        ///console.log('您现在访问的是：'+edit_url);
                        /* $("#table").bootstrapTable('refresh',cid);
                        if (status == "success") {
                            alert('提交数据成功');
                        } */
                    },
                    error: function () {
                        //console.log('失败您现在访问的是：'+edit_url);
                        date = {
                            'id':row.id,
                            'parent_id':row.parent_id,
                            'name':row.name,
                            'status':row.status,
                            'sort_order':row.sort_order,
                            'is_parent':row.is_parent,
                            'created':row.created,
                            'updated':row.updated
                        }
                        //console.log('编辑失败');
                        //console.log(row);
                        //console.log(date);
                        //console.log(field);
                    },
                    complete: function () {

                    }

                });
            }
        });
    }




    //初始化内容table
    function initContentTable( edit_url,id) {
        $(table).data("id",id);
        $("#table").bootstrapTable({
            url: "/portal/initTable/content.do",       //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            contentType: "application/x-www-form-urlencoded",
            dataType: "json",
            toolbar: '#toolbar',                //工具按钮用哪个容器
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 15,                       //每页的记录行数（*）
            pageList: [15, 30, 50, 100],        //可供选择的每页的行数（*）
            showColumns: true,                  //是否显示所有的列
            height: 750,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            queryParamsType: 'limit',//查询参数组织方式
            queryParams: function (params) {//上传服务器的参数
                var temp = {//如果是在服务器端实现分页，limit、offset这两个参数是必须的
                    id: id,
                    limit: params.limit, // 每页显示数量
                    page: (params.offset / params.limit) + 1   //当前页码
                };
                return temp;
            },
            columns: [
                {
                    checkbox: true, // 显示一个勾选框
                    align: 'center' // 居中显示
                },
                {
                    field: 'id',
                    title: 'ID',
                    visible:false
                },
                {
                    field: 'title',
                    title: '内容标题',
                    editable: {
                        type: 'text',
                        title: '修改内容标题',
                        placement: 'right',
                        emptytext: "空文本",
                        validate: function(v) {
                            if (!v) return '用户名不能为空';
                        }
                    }
                },
                {
                    field: 'subTitle',
                    title: '子标题',
                    editable: {
                        type: 'text',
                        title: '修改子标题',
                        placement: 'right',
                        emptytext: "空文本",
                        validate: function(v) {
                            if (!v) return '用户名不能为空';
                        }
                    }
                },
                {
                    field: 'titleDesc',
                    title: '具体内容',
                    visible:false,
                    editable: {
                        type: 'text',
                        title: '修改内容',
                        placement: 'right',
                        emptytext: "空文本",
                        validate: function(v) {
                            if (!v) return '用户名不能为空';
                        }
                    }
                },
                {
                    field: 'url',
                    title: '内容链接',
                    editable: {
                        type: 'text',
                        title: '修改内容链接',
                        placement: 'right',
                        emptytext: "空文本",
                        validate: function(v) {
                            if (!v) return '用户名不能为空';
                        }
                    }
                },
                {
                    field: 'pic',
                    title: '照片1',
                    editable: {
                        type: 'text',
                        title: '上传照片1',
                        placement: 'right',
                        emptytext: "空文本",
                        validate: function(v) {
                            if (!v) return '用户名不能为空';
                        }
                    }
                },
                {
                    field: 'pic2',
                    title: '照片2',
                    editable: {
                        type: 'text',
                        title: '上传照片2',
                        placement: 'right',
                        emptytext: "空文本",
                        validate: function(v) {
                            if (!v) return '用户名不能为空';
                        }
                    }
                },
                {
                    field: 'content',
                    title: '具体内容',
                    visible:false,
                    editable: {
                        type: 'text',
                        title: '修改内容',
                        placement: 'right',
                        emptytext: "空文本",
                        validate: function(v) {
                            if (!v) return '用户名不能为空';
                        }
                    }
                },
                {
                    field: 'created',
                    title: '创建时间',
                    formatter: function (value, row, index) {
                        return changeDateFormat(value);
                    }

                },
                {
                    field: 'updated',
                    title: '更新时间',
                    formatter: function (value, row, index) {
                        return changeDateFormat(value);
                    }
                },
                {
                    field: '',
                    title: '操作',
                    align: 'center',
                    formatter: function () {
                        var result = "";
                        result += "<a href='javascript:;' class='btn btn-xs' title='编辑'><span class='glyphicon glyphicon-cog'></span></a>";
                        return result;
                    }
                }

            ],
            onEditableSave: function ( field, row ) {
                //console.log(9);
                //console.log(field);
                //console.log(row);
                $.ajax({
                    type: "post",
                    url: edit_url,
                    data:{
                        'id':row.id,
                        'categoryId':row.categoryId,
                        'title':row.title,
                        'subTitle':row.subTitle,
                        'titleDesc':row.titleDesc,
                        'url':row.url,
                        'pic':row.pic,
                        'pic2':row.pic2,
                        'created':row.created,
                        'updated':row.updated,
                        'content':row.content

                    },
                    dataType: 'JSON',
                    success: function (result) {
                        //console.log('您现在访问的是：'+edit_url);
                        /* $("#table").bootstrapTable('refresh',cid);
                        if (status == "success") {
                            alert('提交数据成功');
                        } */
                    },
                    error: function () {
                        //console.log('失败您现在访问的是：'+edit_url);
                        date = {
                            'id':row.id,
                            'categoryId':row.categoryId,
                            'title':row.title,
                            'subTitle':row.subTitle,
                            'titleDesc':row.titleDesc,
                            'url':row.url,
                            'pic':row.pic,
                            'pic2':row.pic2,
                            'created':row.created,
                            'updated':row.updated,
                            'content':row.content
                        }
                        //console.log('编辑失败');
                        //console.log(row);
                        //console.log(date);
                       // console.log(field);
                    },
                    complete: function () {

                    }

                });
            }
        });
    }



    function changeDateFormat(cellval) {
        if (cellval != null) {
            var date = new Date(parseInt(cellval));
            var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
            var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();

            var hh24 = date.getHours();
            var mi = date.getMinutes();
            var ss = date.getSeconds();

            return date.getFullYear() + "-" + month + "-" + currentDate+" "+ hh24 +":"+mi+":"+ss;
        }
    }




</script>
</body>

</html>
