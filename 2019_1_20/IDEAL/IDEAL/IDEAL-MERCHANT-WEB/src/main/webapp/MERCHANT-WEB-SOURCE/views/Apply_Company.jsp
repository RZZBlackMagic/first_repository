<%--
  Created by IntelliJ IDEA.
  User: 任章哲
  Date: 2019/1/21
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">

<head>
    <title>Notifications</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

    <!-- bootstarpeditable相关css -->
    <link href="assets/vendor/bootstrap3-editable/css/bootstrap-editable.css" rel="stylesheet" />
    <link href="assets/vendor/bootstrap-table/bootstrap-table.css" rel="stylesheet" />
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

        </div>
        <div class="main-content">
            <div class="container-fluid">
                <h3 class="page-title">代理商申请代理</h3>

                <div class="tpl-block panel-body">

                    <div id="showTable">
                        <div id="toolbar">

                            <button onclick="Apply()" id="remove-good" class="btn btn-default" type="button" style="margin-right: 5px;float: left;border-top-left-radius: 0%;border-bottom-left-radius: 0%;border-left:0;">
                                申请代理公司
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
                                        <label for="name" class="col-lg-3 control-label">类别</label>
                                        <div class="col-lg-10">
                                            <input type="text" class="form-control" name="name" placeholder="请输入商品所属类别">
                                        </div>
                                    </div>
                                </li>



                                <li>
                                    <div class="form-group">
                                        <div class="col-lg-offset-2 col-lg-4" >
                                            <button type="button" class="btn btn-success" onclick="clickSubmit()">确认</button>
                                            &nbsp&nbsp&nbsp
                                            <button type="reset" class="btn btn-default" onclick="clickExit()">返回</button>
                                        </div>

                                    </div>
                                </li>
                            </ul>
                        </form>
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
<script src="assets/scripts/klorofil-common.js"></script>
<script src="assets/scripts/custom-scripts.js"></script>
<!-- bootstrap-editable相关js -->
<script src="assets/vendor/bootstrap/js/bootstrap.js"></script>
<script src="assets/vendor/bootstrap3-editable/js/bootstrap-editable.js"></script>
<script src="assets/vendor/bootstrap-table/bootstrap-table.min.js"></script>
<script src="assets/vendor/bootstrap-table/bootstrap-table-zh-CN.min.js"></script>
<script src="assets/vendor/bootstrap3-editable/js/bootstrap-table-editable.js"></script>


<script>
    //console.log(1);
    $("#table").bootstrapTable('destroy');
    initTable('/manager/bootstrap/editProductorManager.do');
    //console.log(2);
    //$("input[name='btSelectItem']").parents('.selected').find('td:eq(1)').text();
    /*$(document).keyup(function(event){
        if(event.keyCode ==13){
            var company = $('input[class="form-control"]').val();
            console.log(company);
            console.log("回撤事件");
        }
    });

    $('.form-control').on('focus',getFocus);
    $('.form-control').on('blur',missFocus);
    function getFocus(){
        console.log("得到焦点事件");
    }
    function missFocus(){
        var company = $('.form-control').val();
        console.log(company);
        console.log("失去焦点事件" );
    }*/
    //初始化内容分类的table
    function initTable( edit_url) {
        //$(table).data("id",id);
        $("#table").bootstrapTable({
            url: "/merchant/initProductorTable/ApplyMerchant.do",       //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            contentType: "application/x-www-form-urlencoded",
            dataType: "json",
            toolbar: '#toolbar',                //工具按钮用哪个容器
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1, //初始化加载第一页，默认第一页
            search:true,
            pageSize: 15,                       //每页的记录行数（*）
            pageList: [15, 30, 50, 100],        //可供选择的每页的行数（*）
            showColumns: true,                  //是否显示所有的列
            height: 750,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            queryParamsType: 'limit',//查询参数组织方式
            queryParams: function (params) {//上传服务器的参数
                var temp = {//如果是在服务器端实现分页，limit、offset这两个参数是必须的
                    limit: params.limit, // 每页显示数量
                    page: (params.offset / params.limit) + 1, //当前页码
                    search: params.search
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
                    field: 'logo',
                    title: 'logo',
                },
                {
                    field: 'companyzh',
                    title: '公司名字',
                },{
                    field: 'mainbusiness',
                    title: '主营',

                },{
                    field: 'type',
                    title: '类型',

                },{
                    field: 'turnover',
                    title: '年营业额',

                },{
                    field: 'employees',
                    title: '员工人数',

                },
                {
                    field: 'website',
                    title: '官方网址',
                },
                {
                    field: 'ceo',
                    title: 'CEO',

                },{
                    field: 'phone',
                    title: '官方电话',
                },
                {
                    field: 'email',
                    title: 'email',
                }

            ]
        });
    }


    function Apply(){
        var rows = $(table).bootstrapTable('getSelections');
        console.log(rows);
        var url = "/merchant/ApplyCompany/ApplyMerchant.do";
        var merchantId = 2;
        var merchantName = 'renzhangzhe';
        //参数从Session中拿
        var data = {
            merchantId:merchantId,
            merchantName:merchantName,
            productorId:rows[0].id,
            productorName:rows[0].companyzh
        };
        $.post(url,data,function(result){
            console.log(result);
        });
    }









</script>
</body>

</html>

