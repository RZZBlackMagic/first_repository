<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">

<head>
    <title>商品分类管理</title>
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
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
    <link rel="stylesheet" type="text/css" href="assets/vendor/ztree/css/metroStyle/metroStyle.css"/>
    <!-- bootstarpeditable相关css -->
    <link href="assets/vendor/bootstrap3-editable/css/bootstrap-editable.css" rel="stylesheet"/>
    <link href="assets/vendor/bootstrap-table/bootstrap-table.css" rel="stylesheet"/>

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
        <div class="main-content">
            <div class="container-fluid">
                <h3 class="page-title">商品分类管理</h3>
                <div class="content">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-2">
                                <div id="left">
                                    <ul id="treeDemo" class="ztree"></ul>
                                </div>
                            </div>

                            <div class="col-md-9" id="right">
                                <div class="card">
                                    <div id="showTable">
                                        <div id="toolbar">
                                            <button id="add-good" class="btn btn-default" type="button"
                                                    style="float: left;border-top-right-radius: 0%;border-bottom-right-radius: 0%;">
                                                <span class="fa fa-plus"></span>
                                            </button>
                                            <button id="remove-good" class="btn btn-default" type="button"
                                                    style="margin-right: 5px;float: left;border-top-left-radius: 0%;border-bottom-left-radius: 0%;border-left:0;">
                                                <span class="fa fa-minus"></span>
                                            </button>
                                        </div>
                                        <table id="table" data-buttons-align="right"></table>

                                    </div>


                                    <div class="col-lg-9 col-md-offset-1" id="showContentForm" style="display:none">
                                        <div class="panel panel-headline" style="min-height: 710px">
                                            <div class="panel-heading">
                                                <h3 class="panel-title">添加商品内容</h3>
                                                <p class="panel-subtitle"></p>
                                            </div>
                                            <div class="panel-body">
                                                <div class="form-group">
                                                    <label for="title" class="form-control-label" >内容标题</label>
                                                    <input id="title" name="title" type="text" class="form-control" placeholder="">
                                                </div>
                                                <div class="form-group">
                                                    <label for="subTitle" class="form-control-label" >价格</label>
                                                    <input id="subTitle" name="subTitle" type="text" class="form-control" placeholder="">
                                                </div>
                                                <div class="form-group">
                                                    <label for="titleDesc" class="form-control-label" >标题描述</label>
                                                    <input id="titleDesc" name="titleDesc" type="text" class="form-control" placeholder="">
                                                </div>
                                                <div class="form-group">
                                                    <label for="url" class="form-control-label" >链接</label>
                                                    <input id="url" name="url" type="text" class="form-control" placeholder="">
                                                </div>
                                                <div class="form-group">
                                                    <label for="pic" class="form-control-label" >图片-默认</label>
                                                    <input id="pic" name="pic" type="text" class="form-control" placeholder="">
                                                </div>
                                                <div class="form-group">
                                                    <label for="pic2" class="form-control-label" >图片-宽屏</label>
                                                    <input id="pic2" name="pic2" type="text" class="form-control" placeholder="">
                                                </div>
                                                <div class="form-group">
                                                    <label for="content" class="form-control-label" >内容</label>
                                                    <textarea id="content" name="content" class="form-control" placeholder=""></textarea>
                                                </div>

                                                <div class="form-group" style="float: right">
                                                    <button type="submit" id="submit1" class="btn btn-success">
                                                        确认
                                                    </button>
                                                    <button type="reset" class="btn btn-primary" onclick="clickExit()">
                                                        返回
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
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
            <p class="copyright">Copyright &copy; 2017.Company name All rights reserved.More Templates <a
                    href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a
                    href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
        </div>
    </footer>
</div>
<div class="modal fade" id="Modal" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true" style="margin-top: 13%;">
    <div class="modal-dialog" style="width: 20%">
        <div class="modal-content">
            <div class="modal-header">

                <h5 class="modal-title" id="myModalLabel">
                    添加内容类别
                </h5>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <input id="content-cat" style="width: 100%;height: 40px;font-size: 30px;">
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-info" data-dismiss="modal" onclick="clickCategorySubmit()">
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
<script src="assets/vendor/ztree/js/jquery.ztree.all.js"></script>
<script src="assets/vendor/bootstrap3-editable/js/bootstrap-editable.js"></script>
<script src="assets/vendor/bootstrap-table/bootstrap-table.min.js"></script>
<script src="assets/vendor/bootstrap-table/bootstrap-table-zh-CN.min.js"></script>
<script src="assets/vendor/bootstrap3-editable/js/bootstrap-table-editable.js"></script>

<script>

    $(function () {
        initTable("/portal/table/updateContentCategory", 1);
        $('#add-cat').editable({
            type: "text",                //编辑框的类型。支持text|textarea|select|date|checklist等
            title: "添加内容分类",              //编辑框的标题
            disabled: false,             //是否禁用编辑
            mode: "inline",              //编辑框的模式：支持popup和inline两种模式，默认是popup
            validate: function (value) { //字段验证
                if (!$.trim(value)) {
                    return '不能为空';
                }
            }
        });
    });

    var url = '/portal/ztree/contentCategory';
    $.ajax({
        url: url,
        dataType: 'json',
        processData: false,
        type: 'get',
        success: function (result) {
            for (var i = 0; i < result.data.length; i++) {
                if (result.data[i].isParent) result.data[i].open = true;
            }
            $.fn.zTree.init($("#treeDemo"), setting, result.data);
        }
    });

    var setting = {

        view: {
            selectedMulti: true, //设置是否能够同时选中多个节点
            showIcon: true,      //设置是否显示节点图标
            showLine: true,      //设置是否显示节点与节点之间的连线
            showTitle: true      //设置是否显示节点的title提示信息
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
                //请求后台根据选中的ID去看他是否为子叶节点，是则初始化内容table，不是则初始化内容分类table
                if (treeNode.isParent) {
                    //是子叶节点，初始化内容分类table
                    $("#table").bootstrapTable('destroy');
                    initTable('/portal/table/updateContentCategory', treeNode.id);
                    $('#remove-good').unbind();
                    $('#submit').unbind();
                    $('#add-good').unbind();

                    $('#add-good').bind('click', clickCategoryPlus)
                    $('#submit').bind('click', clickCategorySubmit);
                    $('#remove-good').bind('click', clickMinusCategory);
                } else {
                    //不是子叶节点，初始化内容table
                    $("#table").bootstrapTable('destroy');
                    initContentTable('/portal/content/editContent', treeNode.id);
                    $('#submit1').unbind();
                    $('#remove-good').unbind();
                    $('#add-good').unbind();

                    $('#add-good').bind('click', clickContentPlus);
                    $('#submit1').bind('click', clickContentSubmit);
                    $('#remove-good').bind('click', clickMinusContent);
                }
                $('#left').data("treeNodeId", treeNode.id);
            }
        }
    };

    //添加商品内容
    function clickContentSubmit() {
        var url = "/portal/content/addContent";
        var data = {
            'categoryId': $(table).data('id'),
            'title': $("#title").val(),
            'subTitle': $("#subTitle").val(),
            'titleDesc': $("#titleDesc").val(),
            'url': $("#url").val(),
            'pic': $("#pic").val(),
            'pic2': $("#pic2").val(),
            'content': $("#content").val()
        };
        if (!$(table).data('id')||!$("#title").val()||!$("#subTitle").val()||!$("#titleDesc").val()||!$("#url").val()||!$("#pic").val()||!$("#pic2").val()||!$("#content").val()) {
            toastr.info("请填写全部字段后再提交");
            return;
        }
        $.post(url, data, function (result) {
            $('input').val("");
            clickExit();
            $("#table").bootstrapTable('destroy');
            initContentTable('/portal/content/updateContent', $('#left').data('treeNodeId'));
            toastr.success("添加成功");
        });

    }

    //移除商品内容
    function clickMinusContent() {
        var rows = $(table).bootstrapTable('getSelections');
        var id = '';
        for (var i = 0; i < rows.length; i++) {
            id = id + rows[i].id + ',';
        }
        var url = '/portal/content/deleteContent';
        var data = {
            id: id
        };
        $.post(url, data, function () {
            $("#table").bootstrapTable('destroy');
            initContentTable('/portal/content/updateContent', $('#left').data('treeNodeId'));
            //页面局部刷新
            toastr.success("删除成功");
        });
    }


    //添加商品分类
    function clickCategoryPlus() {
        $('#showContentForm').hide();
        $("#Modal").modal('show');
    }

    function clickContentPlus() {
        $("#showTable").hide();
        $("#showForm").hide();
        $('#showContentForm').show();
    }

    //移除商品分类
    function clickMinusCategory() {
        var rows = $(table).bootstrapTable('getSelections');
        var id = '';
        for (var i = 0; i < rows.length; i++) {
            id = id + rows[i].id + ',';
        }
        var name = $("input[name='btSelectItem']").parents('.selected').find('td:eq(1)').text();
        var url = '/portal/table/deleteContentCategory';
        var data = {
            'id': id,
            'name': name
        };
        $.post(url, data, function () {
            $("#table").bootstrapTable('destroy');
            initTable('/portal/table/updateContentCategory', $('#left').data('treeNodeId'));
        });

    }

    function clickCategorySubmit() {
        var data = {
            "name": $("#content-cat").val(),
            "id": $(table).data("id")
        };
        var url = '/portal/table/addContentCategory';
        $.post(url, data, function (result) {
            $('input').val("");
            clickExit();
            $("#table").bootstrapTable('destroy');
            initTable('/portal/table/updateContentCategory', $('#left').data('treeNodeId'));
        });
    }


    function clickExit() {
        $("#showTable").show();
        $('#showContentForm').hide();
    }


    //初始化内容分类的table
    function initTable(edit_url, id) {
        $(table).data("id", id);
        $("#table").bootstrapTable({
            url: "/portal/table/contentCategory",       //请求后台的URL（*）
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
            showRefresh: true,                  //是否显示刷新按钮
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
                    visible: false
                },
                {
                    field: 'name',
                    title: '商品内容分类名字',
                    editable: {
                        type: 'text',
                        title: '修改商品内容分类名字',
                        placement: 'right',
                        emptytext: "空文本",
                        validate: function (v) {
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
            onEditableSave: function (field, row) {
                $.ajax({
                    type: "post",
                    url: edit_url,
                    data: {
                        'id': row.id,
                        'parentId': row.parentId,
                        'name': row.name,
                        'status': row.status,
                        'sortOrder': row.sortOrder,
                        'isParent': row.isParent
                    },
                    dataType: 'JSON',
                    success: function (result) {
                        toastr.success("修改成功");
                    }
                });
            }
        });
    }


    //初始化内容table
    function initContentTable(edit_url, id) {
        $(table).data("id", id);
        $("#table").bootstrapTable({
            url: "/portal/table/content",       //请求后台的URL（*）
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
            showRefresh: true,                  //是否显示刷新按钮
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
                    visible: false
                },
                {
                    field: 'title',
                    title: '内容标题',
                    editable: {
                        type: 'text',
                        title: '修改内容标题',
                        placement: 'right'
                    }
                },
                {
                    field: 'subTitle',
                    title: '子标题',
                    editable: {
                        type: 'text',
                        title: '修改子标题',
                        placement: 'right',
                        emptytext: "空文本"
                    }
                },
                {
                    field: 'titleDesc',
                    title: '价格',
                    visible: false,
                    editable: {
                        type: 'text',
                        title: '修改价格',
                        placement: 'right'
                    }
                },
                {
                    field: 'url',
                    title: '内容链接',
                    editable: {
                        type: 'text',
                        title: '修改内容链接',
                        placement: 'right'
                    },
                    formatter: function (value, row, index) {
                       /* if (row.url.length > 20)
                            return row.url.slice(0, 20) + "....";
                        else
                            return row.url*/
                       return value;
                    }
                },
                {
                    field: 'pic',
                    title: '图片-默认',
                    formatter: function (index, row) {
                        var image = '<div class="photos">'
                            +'<img alt="image" src="'+row.pic+'" style="width: 180px; height: 100px;">'
                            +'</div>';
                        return image;
                    }
                },
                {
                    field: 'pic2',
                    title: '图片-宽屏',
                    formatter: function (index, row) {
                        var image = '<div class="photos">'
                            +'<img alt="image" src="'+row.pic+'" style="width: 180px; height: 100px;">'
                            +'</div>';
                        return image;
                    }

                },
                {
                    field: 'content',
                    title: '具体内容',
                    editable: {
                        type: 'textarea',
                        title: '修改内容',
                        placement: 'right'
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
                }

            ],
            onEditableSave: function (field, row) {
                $.ajax({
                    type: "post",
                    url: edit_url,
                    data: {
                        'id': row.id,
                        'categoryId': row.categoryId,
                        'title': row.title,
                        'subTitle': row.subTitle,
                        'titleDesc': row.titleDesc,
                        'url': row.url,
                        'content': row.content
                    },
                    dataType: 'JSON',
                    success: function () {
                        toastr.success("修改成功");
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

            return date.getFullYear() + "-" + month + "-" + currentDate + " " + hh24 + ":" + mi + ":" + ss;
        }
    }



</script>
</body>

</html>

