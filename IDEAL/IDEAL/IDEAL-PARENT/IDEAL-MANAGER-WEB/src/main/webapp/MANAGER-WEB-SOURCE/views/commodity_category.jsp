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
                                <div id="left" style="display:inline;width:100%;float:left;">
                                    <ul id="treeDemo" class="ztree"
                                        style="width:100%;left:5px;font-size:10px;color:#000">

                                    </ul>

                                </div>
                            </div>

                            <div class="col-md-10" id="right" style="width:75%;float:left;">
                                <div class="card">
                                    <div id="showTable">
                                        <div id="toolbar">
                                            <a>
                                                <button id="add-good" class="btn btn-default" type="button"
                                                        style="float: left;border-top-right-radius: 0%;border-bottom-right-radius: 0%;" data-toggle="modal" data-target="#Modal">
                                                    <span class="fa fa-plus"></span>
                                                </button>
                                            </a>
                                            <button id="remove-good" class="btn btn-default" type="button"
                                                    style="margin-right: 5px;float: left;border-top-left-radius: 0%;border-bottom-left-radius: 0%;border-left:0;" onclick="removeCommodityCat()">
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
<div class="modal fade" id="Modal" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true" style="margin-top: 5%;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <h5 class="modal-title" id="myModalLabel">
                    添加商品分类
                </h5>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="name" class="form-control-label">分类名称</label>
                            <input type="text" name="name" id="name" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="image" class="form-control-label">商品图片</label>
                            <input type="text" id="image" class="form-control">
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-info" data-dismiss="modal" id="model-submit" onclick="submit()">
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
         initTable('/manager/table/editCommodityCategory', 1);
     });

    function removeCommodityCat() {
        var rows = $(table).bootstrapTable('getSelections');
        var id = '';
        for (var i = 0; i < rows.length; i++) {
            id = id + rows[i].id + ',';
        }
        $.ajax({
            url: "/manager/table/removeCate",
            dataType: 'json',
            type: 'get',
            data: {
                'pid': $(table).data('id'),
                'id': id
            },
            success: function (result) {
                $("#table").bootstrapTable('refresh', {url: "/manager/initTable/commodityCategory"});
                toastr.success("删除成功")
            }
        });
    }

    function submit() {
        $.ajax({
            url: '/manager/table/commodityCat',
            dataType: 'json',
            type: 'get',
            data: {
                'pid': $("#table").data("id"),
                'name': $("#name").val(),
                'image': $("#image").val()
            },
            success: function () {
                $("#table").bootstrapTable('refresh', {url: "/manager/initTable/commodityCategory"});
                toastr.success("添加成功")
            },
            error: function () {
                toastr.error("删除失败")
            }
        });
    }

    $.ajax({
        url: "/manager/ztree/commodityCate",
        dataType: 'json',
        processData: false,
        type: 'get',
        success: function (result) {
            for (var i = 0; i < result.length; i++) {
                if (result[i].pId == 0) {
                    result[i].open = true;
                } else {
                    result[i].open = false;
                }
            }
            var zNodes = result;
            var t = $("#treeDemo");
            $('#left').data()
            //初始化ztree
            t = $.fn.zTree.init(t, setting, zNodes);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        }
    });
    var setting = {

        view: {
            selectedMulti: true, //设置是否能够同时选中多个节点
            showIcon: true,      //设置是否显示节点图标
            showLine: true,      //设置是否显示节点与节点之间的连线
            showTitle: true    //设置是否显示节点的title提示信息
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
                $('#left').data("treeNodeId", treeNode.id);
                //请求后台根据选中的ID去看他是否为子叶节点，是则初始化内容table，不是则初始化内容分类tabl
                $("#table").bootstrapTable('destroy');
                initTable('/manager/table/editCommodityCategory', treeNode.id);
            }

        }


    };

    function initTable(edit_url, id) {
        $(table).data("id", id);
        $("#table").bootstrapTable({
            url: "/manager/initTable/commodityCategory",       //请求后台的URL（*）
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
                    pid: id,
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
                    title: '商品类别',
                    editable: {
                        type: 'text',
                        title: '修改商品类别',
                        placement: 'right',
                        validate: function (v) {
                            if (!v) return '用户名不能为空';
                        }
                    }
                },
                {
                    field: 'frontName',
                    title: '类别描述-WECHAT',
                    editable: {
                        type: 'text',
                        title: '修改商品描述'
                    }
                },
                {
                    field: 'image',
                    title: '图片-WECHAT',
                    formatter: function (index, row) {
                        if (row.image){
                            var image = '<div class="photos">'
                                +'<img alt="image" src="'+row.image+'" style="width: 100px; height: 100px;">'
                                +'</div>';
                            return image;
                        } else {
                            return null;
                        }

                    }
                },
                {
                    field: 'status',
                    title: '状态',
                    editable: {
                        type: 'text',
                        title: '修改状态',
                        placement: 'right',
                        emptytext: "空文本",
                        validate: function (v) {
                            if (!v) return '状态不能为空';
                        },
                        source:[{value: 0,text:"下架"},{value: 1,text:"正常"}]
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
                    url: "/manager/table/editCommodityCategory",
                    data: {
                        'id': row.id,
                        'pid': row.pid,
                        'name': row.name,
                        'frontName': row.frontName,
                        'status': row.status,
                        'sort': row.sort
                    },
                    dataType: 'JSON',
                    success: function () {
                        toastr.success("修改成功");
                        $("#table").bootstrapTable('refresh', {url: "/manager/initTable/commodityCategory"});
                    },
                    error: function () {
                        toastr.error("修改失败")
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

