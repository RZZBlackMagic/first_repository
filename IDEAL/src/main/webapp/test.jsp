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
						<div class="row">
							<div class="col-lg-3">
								<ul id="tree" style="min-height: 300px;max-height: 550px;overflow-y: auto;" class="ztree"></ul>
							</div>
                            <div class="col-lg-9" id="showTable">
								<div id="toolbar">
									<button onclick="clickPlus()" class="btn btn-default" type="button" style="float: left;border-top-right-radius: 0%;border-bottom-right-radius: 0%;">
										<span class="fa fa-plus" ></span>
									</button>
									<button onclick="clickMinus()" id="remove-category" class="btn btn-default" type="button" style="margin-right: 5px;float: left;border-top-left-radius: 0%;border-bottom-left-radius: 0%;border-left:0;">
										<span class="fa fa-minus"></span>
									</button>
								</div>
                                <table id="table" data-buttons-align="right" data-pid=""></table>
                            </div>
							<div class="col-lg-9" id="showForm">
								<form class="form-horizontal" role="form" onsubmit="clickSubmit()" id="form">
									<legend style="margin-bottom: 30px;">添加商品分类</legend>

									<div class="form-group">
										<label for="pid" class="col-lg-2 control-label">父节点</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" id="pid" placeholder="" readonly="readonly">
										</div>
									</div>
									<div class="form-group">
										<label for="name" class="col-lg-2 control-label">名字</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" id="name" placeholder="请输入分类名称">
										</div>
									</div>
									<div class="form-group">
										<label for="status" class="col-lg-2 control-label">分类状态</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" id="status" placeholder="请确认分类状态 0-未上架 1-已上架 2-已下架">
										</div>
									</div>
									<div class="form-group">
										<label for="sort" class="col-lg-2 control-label">排序优先级</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" id="sort" placeholder="请确认商品分类排序优先级 1-5由高到低 1-最高 5-最低">
										</div>
									</div>
									<div class="form-group" style="margin-bottom: 20px">
										<label for="parent" class="col-lg-2 control-label">是否为父节点</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" id="parent" placeholder="请确认该商品分类是否为父节点 1-是 0-否">
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-offset-2 col-lg-1" >
											<button type="button" class="btn btn-success" onclick="clickSubmit()">确认</button>
										</div>
										<div class="col-lg-1" style="margin-left: 6px;">
											<button type="reset" class="btn btn-default" onclick="clickExit()">返回</button>
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
<script src="assets/scripts/custom-scripts.js"></script>
<script>

    $(function () {
        $("#showForm").hide();
		initTable("#table", "/category/table/select", "/category/table/edit", 1);
		initTree("#tree", "/category/tree/select");
    });

    function initTree(tree, url){
        $.ajax({
            type:"post",
            url: url,
            dataType:"json",
            success:function(res){
                res[0].open = true;
                var setting = {
                    data: {simpleData: {enable: true}},
                    callback:{beforeClick: ztreeBeforeClick}
                };
                $.fn.zTree.init($(tree), setting, res);
            },
            error:function(){}
        });

        function ztreeBeforeClick(event, node){
			$("#table").bootstrapTable('destroy');
			initTable("#table", "/category/table/select", "/category/table/edit", node.id);
        }
	}

	function initTable(table, select_url, edit_url, pid) {
        $(table).data("pid",pid);
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
            pageSize: 10,                       //每页的记录行数（*）
			height: 560,
            pageList: [10, 20],        //可供选择的每页的行数（*）
            showColumns: true,                  //是否显示所有的列
            queryParamsType:'limit',//查询参数组织方式
            queryParams : function (params) {//上传服务器的参数
                return {//如果是在服务器端实现分页，limit、offset这两个参数是必须的
                    pid: pid,
                    limit: params.limit, // 每页显示数量
                    page: (params.offset / params.limit) + 1   //当前页码
                };
            },
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
                        title: '用户名',
                        validate: function (v) {
                            if (!v) return '用户名不能为空';
                        }
                    }
                },
                {
                    field: 'status',
                    title: '分类状态',
                    editable: {
                        type: 'select',
                        title: '分类状态',
                        source:[{value:"0",text:"未上架"},{value:"1",text:"已上架"},{value:"2",text:"已下架"}]
                    }
                },
                {
                    field: 'parent',
                    title: '父节点'
                },
                {
                    field: 'sort',
                    title: '优先级'
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
            onEditableSave: function (field, row) {
                $.ajax({
                    type: "post",
                    url: edit_url,
                    data: row,
                    dataType: 'JSON',
                    success: function (data, status) {
                        $(table).bootstrapTable('refresh',{url : select_url});
                        if (status == "success") {
                            alert('提交数据成功');
                        }
                    },
                    error: function () {
                        alert('编辑失败');
                    },
                    complete: function () {

                    }

                });
            }
        });
    }

    function clickPlus() {
        $("#showTable").hide();
        $("#showForm").show();
		$("#pid").attr("placeholder", $("#table").data("pid"));
    }

    function clickMinus() {
        var rows = $(table).bootstrapTable('getSelections');
        var param = [];
        if (rows.length > 0) {
            $.each(rows, function (i, item) {
                param.push(item.cid)
            });
            $.ajax({
                type: "get",
                url: "/category/delete/" + param.join(","),
                dataType: "JSON",
                success: function (data, status) {
                    console.log(data.msg);
                    if ( status == "success" && data.msg == "OK" ){
                        alert("删除数据成功");
                        initTree("#tree", "/category/tree/select");

                    }else {
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

	function clickSubmit() {
		$.ajax({
			type: "post",
			url: "/category/insert",
			data: {
				pid: $("#table").data("pid"),
				name: $("#name").val(),
				status: $("#status").val(),
				sort: $("#sort").val(),
				parent: $("#parent").val()
			},
			dataType: 'JSON',
			success: function (data, status) {
				if (status == "success") {
					alert('提交数据成功');
					initTree("#tree", "/category/tree/select");
				}
			},
			error: function () {
				alert('提交数据失败');
			},
			complete: function () {

			}

		});
	}

	function clickExit() {
		$("#showTable").show();
		$("#showForm").hide();
		$("#table").bootstrapTable('destroy');
		initTable("#table", "/category/table/select", "/category/table/edit", $("#table").data("pid"));
	}
</script>
</body>

</html>
