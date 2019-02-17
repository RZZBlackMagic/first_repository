<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">

<head>
    <title>Tables</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- VENDOR CSS -->
    <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/vendor/linearicons/style.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="assets/css/main.css">
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link rel="stylesheet" href="assets/css/demo.css">
    <!-- GOOGLE FONTS -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
    <link rel="stylesheet" href="assets/vendor/bootstrap-table/bootstrap-table.css">
    <link rel="stylesheet" href="assets/vendor/ztree/css/metroStyle/metroStyle.css">
    <link rel="stylesheet" href="assets/css/custom-css.css">

</head>

<body>
<!-- WRAPPER -->
<div id="wrapper">
    <!-- NAVBAR -->
    <jsp:include page="template/header.jsp"/>
    <!-- END NAVBAR -->
    <!-- LEFT SIDEBAR -->
    <jsp:include page="template/left-sidebar.jsp"/>
    <!-- END LEFT SIDEBAR -->
    <!-- MAIN -->
    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content" style="">
            <div class="container-fluid">
                <h3 class="page-title">商品管理</h3>
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-headline">
                            <div class="panel-body">
                                <form id="formSearch" class="form-horizontal">
                                    <div class="form-group" style="margin-top:15px">
                                        <label class="control-label col-sm-1" for="txt_search_departmentname">部门名称</label>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="txt_search_departmentname">
                                        </div>
                                        <label class="control-label col-sm-1" for="txt_search_statu">状态</label>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="txt_search_statu">
                                        </div>
                                        <div class="col-sm-4" style="text-align:left;">
                                            <button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary">查询</button>
                                        </div>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="panel panel-headline">
                            <div class="panel-body">
                                <div id="toolbar">
                                    <%--<a href="/manager/commodity-add"><button id="add-good" class="btn btn-default" type="button" style="float: left;border-top-right-radius: 0%;border-bottom-right-radius: 0%;">--%>
                                        <%--<span class="glyphicon glyphicon-cog" ></span>--%>
                                    <%--</button></a>--%>
                                    <button id="remove-good" class="btn btn-default" type="button" style="margin-right: 5px;float: left;border-top-left-radius: 0%;border-bottom-left-radius: 0%;border-left:0;">
                                        <span class="fa fa-minus"></span>
                                    </button>

                                </div>
                                <input type="hidden" id="apid">
                                <table id="table" data-buttons-align="right"></table>
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
<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="assets/scripts/klorofil-common.js"></script>
<script src="assets/scripts/custom-scripts.js"></script>
<script src="assets/vendor/kindeditor/kindeditor-all-min.js"></script>
<script src="assets/vendor/bootstrap-table/bootstrap-table.min.js"></script>
<script src="assets/vendor/bootstrap-table/bootstrap-table-zh-CN.min.js"></script>
<script src="assets/vendor/kindeditor/lang/zh-CN.js"></script>
<script src="assets/vendor/ztree/js/jquery.ztree.all.js"></script>
<script>
    $(function () {
        checkLogin();
    });
    function initTable() {
        $("#table").bootstrapTable({
            url: '/productor/commodity/table',       //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            contentType: "application/x-www-form-urlencoded",
            dataType: "json",
            toolbar: '#toolbar',                //工具按钮用哪个容器
            cache: true,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            // // queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 15,                       //每页的记录行数（*）
            pageList: [15, 25, 50, 100],        //可供选择的每页的行数（*）
            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 1,             //最少允许的列数
            // clickToSelect: true,                //是否启用点击选中行
            // height: 550,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            // uniqueId: "no",                     //每一行的唯一标识，一般为主键列
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            queryParamsType:'limit',//查询参数组织方式
            queryParams : function (params) {//上传服务器的参数
                var temp = {//如果是在服务器端实现分页，limit、offset这两个参数是必须的
                    limit : params.limit, // 每页显示数量
                    page: (params.offset / params.limit) + 1,   //当前页码
                    apid: $("#apid").val()
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
                    title: 'SPU-ID',
                    sortable: true
                },
                {
                    field: 'title',
                    title: '商品名称'
                },
                {
                    field: 'category',
                    title: '商品类别'
                },
                {
                    field: 'sellpoint',
                    title: '简介'
                },
                {
                    field: 'image',
                    title: '商品图片'
                },
                {
                    field: 'status',
                    title: '状态',
                    formatter: function (value) {
                        if (value == 1) return "正常";
                        else if (value == 2) return "下架";
                        else return "删除";

                    }
                },
                {
                    field: '',
                    title: '操作',
                    align: 'center',
                    formatter: function (value, row, index) {
                        var result = "";
                        // var pageSize = $('#table').bootstrapTable('getOptions').pageSize;     //通过table的#id 得到每页多少条
                        // var pageNumber = $('#table').bootstrapTable('getOptions').pageNumber; //通过table的#id 得到当前第几页
                        // var number =  pageSize * (pageNumber - 1) + index + 1;    // 返回每条的序号： 每页条数 *（当前页 - 1 ）+ 序号
                        result += "<a href='http://localhost:8082/edit-spu.html?id="+row.id+"' class='btn btn-xs' title='查看'><span class='glyphicon glyphicon-th-large'></span></a>";
                        result += "<a  class='btn btn-xs' title='编辑'><span class='glyphicon glyphicon-cog'></span></a>";

                        return result;
                    }
                }

            ]
        });
    }
    function checkLogin() {
        var _ticket = $.cookie("IDEAL_TOKEN");
        if(!_ticket){
            return ;
        }
        $.ajax({
            url : "http://localhost:8089/sso/productor/token/" + _ticket,
            dataType : "jsonp",
            type : "GET",
            success : function(data){
                $("#apid").val(data.data.id);
                initTable();
            },
            error : function () {
                alert("登陆失败");
            }
        });
    }
</script>
</body>

</html>
