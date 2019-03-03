<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">

<head>
    <title>商品SKU管理</title>
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
    <link rel="stylesheet" href="assets/vendor/bootstrap3-editable/css/bootstrap-editable.css">
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
                <h3 class="page-title">商品SKU管理</h3>
                <div class="row">

                    <div class="col-md-12">
                        <div class="panel panel-headline">
                            <div class="panel-body">
                                <div id="toolbar">
                                    <button id="add-sku" class="btn btn-default" type="button" style="float: left;border-top-right-radius: 0%;border-bottom-right-radius: 0%;" data-toggle="modal" data-target="#Modal">
                                        <span class="fa fa-plus" ></span>
                                    </button>
                                    <button id="remove-sku" class="btn btn-default" type="button" style="margin-right: 5px;float: left;border-top-left-radius: 0%;border-bottom-left-radius: 0%;border-left:0;">
                                        <span class="fa fa-minus"></span>
                                    </button>

                                </div>
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
</body>
<div class="modal fade" id="Modal" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true" style="margin-top: 13%;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <h5 class="modal-title" id="myModalLabel">
                    选择规格
                </h5>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-12">
                        <table class="table">
                            <input type="hidden" id="spe-num">
                            <thead>
                            <tr>
                                <th>Type</th>
                                <th>Value</th>
                            </tr>
                            </thead>
                            <form id="form-spe">
                            <tbody id="spe">

                            </tbody>
                            </form>
                        </table>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-info" data-dismiss="modal" id="add-spe" onclick="SubmitSpe()">
                    提交
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<div class="modal fade" id="Modal2" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true" style="margin-top: 5%;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <h5 class="modal-title" id="myModalLabel2">
                    编辑商品图片及详情
                </h5>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-12">
                        <input type="hidden" id="sku_id">
                        <div class="form-group">
                            <label for="image" class="form-control-label">商品图片</label>
                            <input type="file" id="image" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="desc" class="form-control-label">商品详情</label>
                            <textarea name="desc" id="desc" style="width: 100%;height: 330px;visibility: hidden"></textarea>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-info" data-dismiss="modal" id="desc-submit">
                    提交
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
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
<script src="assets/vendor/bootstrap3-editable/js/bootstrap-editable.min.js"></script>
<script src="assets/vendor/bootstrap3-editable/js/bootstrap-table-editable.js"></script>
<script src="assets/vendor/kindeditor/lang/zh-CN.js"></script>
<script src="assets/vendor/ztree/js/jquery.ztree.all.js"></script>
<script>
    $(function () {
        InitTable();
        InitSpeSelects();
        Editor = utils.initEditor($("#desc"),"/pic/upload");
    });
    function SetRowId(obj) {
        $("#sku_id").val(obj.id);
    }


    $("#desc-submit").click(function () {

        Editor.sync();
        $.ajax({
            type: "POST",
            url: "/product/sku/edit_desc",
            data: {
                id: $("#sku_id").val(),
                image: $("#image").val(),
                desc: $("#desc").val()
            },
            dataType: 'JSON',
            success: function (data, status) {
                toastr.success("添加成功");
            }
        })
    });

    function SubmitSpe() {
        var data = "";
        for (var i = 0; i < $("#spe-num").val()-1; i++){
            data += $("select[name=A"+i+"]").attr('id')+":"+$("select[name=A"+i+"]").find("option:selected").attr("id")+";";
        }
        $.ajax({
            type: "post",
            url: "/product/sku/add",
            data: {
                id: utils.GetQueryString('id'),
                data: data
            },
            dataType: 'JSON',
        });

    }
    function InitSpeSelects(){
        $.ajax({
            type: "get",
            url: "/product/spe/selects",
            data: {id: utils.GetQueryString('id')},
            dataType: 'JSON',
            success: function (data, status) {
                var str = "";
                var str1 = data.data.split(";");
                $("#spe-num").val(str1.length);
                for(var i = 0; i < str1.length-1; i++){
                    var str2 = str1[i].split(":");
                    str += "<tr><th>"+str2[1]+"</th><th><select class='form-control' style='margin: 0;border: 0px;padding: 0px' id='"+str2[0]+"' name='"+"A"+i+"'>";
                    var str3 = str2[2].split(",");
                    for (var j = 0; j < str3.length; j++) {
                        var str4 = str3[j].split(".");
                        str += "<option id='"+str4[0]+"'>"+str4[1]+"</optionid>";
                    }
                    str += "</select></th></tr>";
                }
                $("#spe").html(str);
            }
        });
    }
    function InitTable() {
        $("#table").bootstrapTable({
            url: '/product/sku/table',       //请求后台的URL（*）
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
                    page: (params.offset / params.limit) + 1,  //当前页码
                    spu: utils.GetQueryString('id')
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
                    title: 'SKU-ID',
                    sortable: true
                },
                {
                    field: 'image',
                    title: '商品图片'
                },
                {
                    field: 'spe',
                    title: '规格'
                },
                {
                    field: 'price',
                    title: '价格',
                    editable: {
                        type: 'text',
                        title: '价格'
                    }

                },
                {
                    field: 'quantity',
                    title: '货存数量',
                    editable: {
                        type: 'text',
                        title: '货存数量'
                    }
                },
                {
                    field: 'position',
                    title: '发货地点',
                    editable: {
                        type: 'text',
                        title: '发货地点'
                    }
                },
                {
                    field: 'status',
                    title: '状态',
                    editable: {
                        type: 'select',
                        title: '状态',
                        source:[{value: 0,text:"未上架"},{value: 1,text:"已上架"},{value: 2,text:"下架"}]
                    }
                },
                {
                    field: '',
                    title: '操作',
                    align: 'center',
                    formatter: function (value, row) {
                        var result = "";
                        result += "<button class='btn btn-xs' title='编辑图片及商品详情' id='"+row.id+"' data-toggle='modal' data-target='#Modal2' onclick='SetRowId(this);'><span class='glyphicon glyphicon-th-large'></span></button>";
                        return result;
                    }
                }

            ],
            onEditableSave: function (field, row) {
                $.ajax({
                    type: "post",
                    url: "/product/sku/edit",
                    data: row,
                    dataType: 'JSON',
                    success: function (data, status) {
                        $("#table").bootstrapTable('refresh', {url: "/product/sku/table"});
                    },
                    error: function () {
                        toastr.error("编辑失败");
                    }
                });
            }
        });
    }

</script>
</body>

</html>
