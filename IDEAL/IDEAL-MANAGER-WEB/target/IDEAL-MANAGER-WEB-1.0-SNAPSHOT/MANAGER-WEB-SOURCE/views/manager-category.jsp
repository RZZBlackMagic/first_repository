<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">

<head>
    <title>IDEAL - 品牌管理</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- VENDOR CSS -->
    <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/vendor/linearicons/style.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="assets/css/main.css">
    <!-- BOOTSTRAP TABLE-->
    <link rel="stylesheet" href="assets/vendor/bootstrap-table/bootstrap-table.css">
    <!-- BOOTSTRAP EDIT -->
    <link rel="stylesheet" href="assets/vendor/bootstrap3-editable/css/bootstrap-editable.css">
    <!-- ZTREE -->
    <link rel="stylesheet" href="assets/vendor/ztree/css/metroStyle/metroStyle.css">
    <!-- FOR CUSTOM CSS -->

    <!-- GOOGLE FONTS -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
</head>

<body>
<!-- WRAPPER -->
<div id="wrapper">
    <jsp:include page="template/head.jsp"/>
    <!-- MAIN -->
    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div class="container-fluid">
                <h3 class="page-title">分类管理 <span style="font-size:15px">&nbsp;Category Managerment</span></h3>
                <div class="panel panel-headline">
                    <div class="panel-body">
                        <div class="row" id="page">
                            <div class="col-lg-3">
                                <ul id="tree" style="overflow-y: auto;"
                                    class="ztree"></ul>
                            </div>
                            <div class="col-lg-9" id="showTable">
                                <div id="toolbar">
                                    <button onclick="clickPlus()" class="btn btn-default" type="button"
                                            style="float: left;border-top-right-radius: 0%;border-bottom-right-radius: 0%;">
                                        <span class="fa fa-plus"></span>
                                    </button>
                                    <button onclick="clickMinus()" id="remove-category" class="btn btn-default"
                                            type="button"
                                            style="margin-right: 5px;float: left;border-top-left-radius: 0%;border-bottom-left-radius: 0%;border-left:0;">
                                        <span class="fa fa-minus"></span>
                                    </button>
                                </div>
                                <table id="table" data-buttons-align="right" data-pid="1"></table>
                            </div>
                            <div class="col-lg-9" id="showForm">
                                <form class="form-horizontal" role="form" id="form" style="min-height: 540px">
                                    <legend style="margin-bottom: 30px;">添加商品分类</legend>

                                    <div class="form-group">
                                        <label for="pid" class="col-lg-2 control-label">父节点</label>
                                        <div class="col-lg-6">
                                            <input type="text" class="form-control" name="pid" id="pid" placeholder=""
                                                   readonly="readonly">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="name" class="col-lg-2 control-label">名字</label>
                                        <div class="col-lg-6">
                                            <input type="text" class="form-control" name="name" id="name"
                                                   placeholder="请输入分类名称" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="status" class="col-lg-2 control-label">分类状态</label>
                                        <div class="col-lg-6">
                                            <input type="text" class="form-control" name="status" id="status"
                                                   placeholder="请确认分类状态 0-未上架 1-已上架 2-已下架" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="sort" class="col-lg-2 control-label">排序优先级</label>
                                        <div class="col-lg-6">
                                            <input type="text" class="form-control" name="sort" id="sort"
                                                   placeholder="请确认商品分类排序优先级 1-5由高到低 1-最高 5-最低" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-offset-2 col-lg-1">
                                            <button type="submit" class="btn btn-success">确认</button>
                                        </div>
                                        <div class="col-lg-1" style="margin-left: 6px;">
                                            <button type="reset" class="btn btn-default" onclick="clickExit()">返回
                                            </button>
                                        </div>
                                    </div>
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
</div>
<!-- END WRAPPER -->
<!-- Javascript -->
<script src="assets/vendor/jquery/jquery.min.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="assets/scripts/klorofil-common.js"></script>
<script src="assets/vendor/bootstrap-table/bootstrap-table.min.js"></script>
<script src="assets/vendor/bootstrap3-editable/js/bootstrap-editable.min.js"></script>
<script src="assets/vendor/bootstrap3-editable/js/bootstrap-table-editable.js"></script>
<script src="assets/vendor/bootstrap-table/bootstrap-table-zh-CN.min.js"></script>
<script src="assets/vendor/ztree/js/jquery.ztree.all.js"></script>
<script src="assets/vendor/jquery/jquery.validate.js"></script>
<script src="assets/vendor/jquery/messages_zh.js"></script>
<script src="assets/scripts/custom-scripts.js"></script>
<script>
    /**
     * 刷新zTree
     */
    function refreshTree() {
        const params = {
            tree: "#tree",
            select_url: "/category/tree/select",
            setting: {
                data: {simpleData: {enable: true}},
                callback: {
                    beforeClick: function (event, node) {
                        $("#table").bootstrapTable('destroy');
                        initTable("#table", "/category/table/select", "/category/table/edit", node.id);
                    }
                }
            },

        };
        IDEAL.initTree(params.tree, params.select_url, params.setting);
    }

    /**
     * 刷新Table
     */
    function refreshTable() {
        $("#table").bootstrapTable('destroy');
        initTable("#table", "/category/table/select", "/category/table/edit", $("#table").data("pid"));
    }

    /**
     * 初始化Table
     * @param table table对应id
     * @param select_url 查询Table接口
     * @param edit_url 编辑Table接口
     * @param pid 父类id
     */
    function initTable(table, select_url, edit_url, pid) {
        $(table).data("pid", pid);
        $(table).bootstrapTable({
            url: select_url,       //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            contentType: "application/x-www-form-urlencoded",
            dataType: "json",
            toolbar: '#toolbar',                //工具按钮用哪个容器
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 15,                       //每页的记录行数（*）
            pageList: [15, 30],        //可供选择的每页的行数（*）
            showColumns: true,                  //是否显示所有的列
            queryParamsType: 'limit',//查询参数组织方式
            showRefresh: true,
            search: true,
            clickToSelect: true,
            columns: [
                {
                    checkbox: true
                },
                {
                    field: 'name',
                    title: '分类名称',
                    editable: {
                        type: 'text',
                        title: '分类名称',
                        validate: function (value) { //字段验证
                            if (!$.trim(value)) {
                                return '分类名称不能为空';
                            }
                        }
                    }
                },
                {
                    field: 'status',
                    title: '分类状态',
                    editable: {
                        type: 'select',
                        title: '分类状态',
                        source: [{value: "0", text: "未上架"}, {value: "1", text: "已上架"}, {value: "2", text: "已下架"}],
                        validate: function (value) { //字段验证
                            if (!$.trim(value)) {
                                return '分类状态不能为空';
                            }
                        }
                    }
                },
                {
                    field: 'parent',
                    title: '父节点'
                },
                {
                    field: 'sort',
                    title: '优先级',
                    editable: {
                        type: 'text',
                        title: '排序优先级',
                        validate: function (v) {
                            if (!v) return '排序优先级不能为空';
                        }
                    }
                },
                {
                    field: 'created',
                    title: '创建时间'
                },
                {
                    field: 'updated',
                    title: '更新时间'
                }
            ],
            queryParams: function (params) {//上传服务器的参数
                return {//如果是在服务器端实现分页，limit、offset这两个参数是必须的
                    pid: pid,
                    limit: params.limit, // 每页显示数量
                    page: (params.offset / params.limit) + 1   //当前页码
                };
            },
            onEditableSave: function (field, row) {
                $.ajax({
                    type: "post",
                    url: edit_url,
                    data: row,
                    dataType: 'JSON',
                    success: function (data, status) {
                        $(table).bootstrapTable('refresh', {url: select_url});
                    },
                    error: function () {
                        alert('编辑失败');
                    }
                });
            }
        });
    }


    $(function () {

        //让Table和Ztree根据屏幕大小显示
        $("#page").height($(window).height() * 0.78);
        $("#tree").css( { "max-height": $(window).height() * 0.78 } );
        //隐藏表单
        $("#showForm").hide();
        //初始化Table 节点为1
        refreshTable();
        //初始化zTree
        refreshTree();
        //初始化Validate提示
        $("#form").validate({
            rules: {
                name: {
                    required: true,
                    success: function () {
                        //对输入对的数据 input 框变绿
                        $("#form").closest("form").find("input[name='name']").css({"border-color": "green"});
                        $("#form").closest("form").find("#error-name").remove()
                    }
                },
                status: {
                    required: true,
                    digits: true,
                    range: [0, 2],
                    success: function () {
                        //对输入对的数据 input 框变绿
                        $("#form").closest("form").find("input[name='status']").css({"border-color": "green"});
                        $("#form").closest("form").find("#error-status").remove();
                    }
                },
                sort: {
                    required: true,
                    digits: true,
                    range: [1, 5],
                    success: function () {
                        //对输入对的数据 input 框变绿
                        $("#form").closest("form").find("input[name='sort']").css({"border-color": "green"});
                        $("#form").closest("form").find("#error-sort").remove();
                    }
                }
            },
            submitHandler: function () {
                clickSubmit()
            },
            errorPlacement: function (error, element) {
                //去除之前添加的样式
                element.closest("form").find("#error-" + element.attr("id") + "").remove();
                //重新添加错误样式
                element.closest("form").find("input[name='" + element.attr("id") + "']").css({"border-color": "crimson"}).after("<div style='color: crimson;text-align: left'" + "id='error-" + element.attr('id') + "'" + ">" + error[0].innerText + "</div>");
            },
            errorElement: "span"
        });
    });

    /**
     * 点击 +号 添加商品分类
     */
    function clickPlus() {
        //Table隐藏 表单显示 为table表明pid
        $("#showTable").hide();
        $("#showForm").show();
        $("#pid").attr("placeholder", $("#table").data("pid"));
    }

    /**
     * 点击 -号 删除商品分类
     */
    function clickMinus() {
        //获取选中row的对象
        var rows = $(table).bootstrapTable('getSelections');
        var param = [];
        //如果获取到 请求
        if (rows.length > 0) {
            $.each(rows, function (i, item) {
                param.push(item.cid)
            });
            $.ajax({
                type: "get",
                url: "/category/delete/" + param.join(","),
                dataType: "JSON",
                success: function (data, status) {
                    if (status == "success" && data.msg == "OK") {
                        alert("删除数据成功");
                        //刷新zTree Table
                        refreshTree();
                        refreshTable();
                    } else {
                        alert(data.msg)
                    }
                },
                error: function () {
                    alert('删除数据失败');
                }
            })
        } else {
            alert("请至少选中一行");
        }
    }

    /**
     * 点击提交事件
     */
    function clickSubmit() {
        $.ajax({
            type: "post",
            url: "/category/insert",
            data: {
                pid: $("#table").data("pid"),
                name: $("#name").val(),
                status: $("#status").val(),
                sort: $("#sort").val()
            },
            dataType: 'JSON',
            success: function (data, status) {
                if (status == "success") {
                    alert('提交数据成功');
                    refreshTree();
                }
            },
            error: function () {
                alert('提交数据失败');
            }

        });
    }

    function clickExit() {
        //显示 Table 隐藏 Form
        $("#showTable").show();
        $("#showForm").hide();
        //刷新表单
        refreshTable();
        //删除所有(警告-正确)样式
        const form = $("#form").closest("form");
        form.find("input").css({"border-color": "#eaeaea"});
        form.find("#error-name").remove();
        form.find("#error-status").remove();
        form.find("#error-sort").remove();
    }


</script>
</body>

</html>
