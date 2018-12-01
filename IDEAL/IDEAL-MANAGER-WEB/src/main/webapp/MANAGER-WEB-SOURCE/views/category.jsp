<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
	<link rel="stylesheet" href="assets/vendor/dataTables/bootstrap-table.css">
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
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="brand">
				<a href="index.html"><img src="assets/img/logo-dark.png" alt="Klorofil Logo" class="img-responsive logo"></a>
			</div>
			<div class="container-fluid">
				<div class="navbar-btn">
					<button type="button" class="btn-toggle-fullwidth"><i class="lnr lnr-arrow-left-circle"></i></button>
				</div>
				<form class="navbar-form navbar-left">
					<div class="input-group">
						<input type="text" value="" class="form-control" placeholder="Search dashboard...">
						<span class="input-group-btn"><button type="button" class="btn btn-primary">Go</button></span>
					</div>
				</form>
				<div class="navbar-btn navbar-btn-right">
					<a class="btn btn-success update-pro" href="#downloads/klorofil-pro-bootstrap-admin-dashboard-template/?utm_source=klorofil&utm_medium=template&utm_campaign=KlorofilPro" title="Upgrade to Pro" target="_blank"><i class="fa fa-rocket"></i> <span>UPGRADE TO PRO</span></a>
				</div>
				<div id="navbar-menu">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle icon-menu" data-toggle="dropdown">
								<i class="lnr lnr-alarm"></i>
								<span class="badge bg-danger">5</span>
							</a>
							<ul class="dropdown-menu notifications">
								<li><a href="#" class="notification-item"><span class="dot bg-warning"></span>System space is almost full</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-danger"></span>You have 9 unfinished tasks</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-success"></span>Monthly report is available</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-warning"></span>Weekly meeting in 1 hour</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-success"></span>Your request has been approved</a></li>
								<li><a href="#" class="more">See all notifications</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="lnr lnr-question-circle"></i> <span>Help</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="#">Basic Use</a></li>
								<li><a href="#">Working With Data</a></li>
								<li><a href="#">Security</a></li>
								<li><a href="#">Troubleshooting</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="assets/img/user.png" class="img-circle" alt="Avatar"> <span>Samuel</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="#"><i class="lnr lnr-user"></i> <span>My Profile</span></a></li>
								<li><a href="#"><i class="lnr lnr-envelope"></i> <span>Message</span></a></li>
								<li><a href="#"><i class="lnr lnr-cog"></i> <span>Settings</span></a></li>
								<li><a href="#"><i class="lnr lnr-exit"></i> <span>Logout</span></a></li>
							</ul>
						</li>
						<!-- <li>
							<a class="update-pro" href="#downloads/klorofil-pro-bootstrap-admin-dashboard-template/?utm_source=klorofil&utm_medium=template&utm_campaign=KlorofilPro" title="Upgrade to Pro" target="_blank"><i class="fa fa-rocket"></i> <span>UPGRADE TO PRO</span></a>
						</li> -->
					</ul>
				</div>
			</div>
		</nav>
		<!-- END NAVBAR -->
		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar">
			<div class="sidebar-scroll">
				<nav>
					<ul class="nav">
						<li><a href="index.html" class=""><i class="lnr lnr-home"></i> <span>Dashboard</span></a></li>
						<li><a href="elements.html" class=""><i class="lnr lnr-code"></i> <span>Elements</span></a></li>
						<li><a href="charts.html" class=""><i class="lnr lnr-chart-bars"></i> <span>Charts</span></a></li>
						<li><a href="panels.html" class=""><i class="lnr lnr-cog"></i> <span>Panels</span></a></li>
						<li><a href="notifications.html" class=""><i class="lnr lnr-alarm"></i> <span>Notifications</span></a></li>
						<li>
							<a href="#subPages" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>Pages</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
							<div id="subPages" class="collapse ">
								<ul class="nav">
									<li><a href="page-profile.html" class="">Profile</a></li>
									<li><a href="page-login.html" class="">Login</a></li>
									<li><a href="page-lockscreen.html" class="">Lockscreen</a></li>
								</ul>
							</div>
						</li>
						<li><a href="tables.html" class=""><i class="lnr lnr-dice"></i> <span>Tables</span></a></li>
						<li><a href="typography.html" class="active"><i class="lnr lnr-text-format"></i> <span>Typography</span></a></li>
						<li><a href="icons.html" class=""><i class="lnr lnr-linearicons"></i> <span>Icons</span></a></li>
					</ul>
				</nav>
			</div>
		</div>
		<!-- END LEFT SIDEBAR -->
		<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
					<h3 class="page-title">分类管理 <span style="font-size:15px">&nbsp;Category Managerment</span></h3>
					<div class="panel panel-headline">
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-2">
										<ul id="tree" style="min-height:500px;overflow-y:auto;max-height: 750px" class="ztree"></ul>
								</div>
								<div class="col-lg-9">
									<div id="toolbar">
										<a href="/manager/commodity-add"><button id="add-good" class="btn btn-default" type="button" style="float: left;border-top-right-radius: 0%;border-bottom-right-radius: 0%;">
											<span class="fa fa-plus" ></span>
										</button></a>
										<button id="remove-good" class="btn btn-default" type="button" style="margin-right: 5px;float: left;border-top-left-radius: 0%;border-bottom-left-radius: 0%;border-left:0;">
											<span class="fa fa-minus"></span>
										</button>
									</div>
									<table id="table"></table>
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
				<p class="copyright">&copy; 2017 <a href="#" target="_blank">Theme I Need</a>. All Rights Reserved. More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
			</div>
		</footer>
	</div>
	<!-- END WRAPPER -->
	<!-- Javascript -->
	<script src="assets/vendor/jquery/jquery.min.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/scripts/klorofil-common.js"></script>
	<script src="assets/vendor/dataTables/bootstrap-table.js"></script>
	<script src="assets/vendor/dataTables/bootstrap-table-zh-CN.js"></script>
	<script src="assets/vendor/ztree/js/jquery.ztree.all.js"></script>
	<script src="assets/scripts/custom-scripts.js"></script>
	<script>
        $(function () {
            $.ajax({
                type:"post",
                url:"/category/tree/all",
                dataType:"json",
                success:function(res){
               		res[0].open = true;
					var setting = {
						data: {simpleData: {enable: true}},
						callback:{beforeClick: ztreeBeforeClick}
					};
					$.fn.zTree.init($("#tree"), setting, res);
                },
                error:function(){}
            });
            initTable(1)
        });
		
        function addCategory() {
			
        }
        
        function ztreeBeforeClick(event, node){
                if(node.isParent == "1"){
                $("#table").bootstrapTable('destroy');
                initTable(node.id);
            }
        }

            function initTable(pid){
                $("#table").bootstrapTable({
                    url: '/category/table/id',       //请求后台的URL（*）
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
                    queryParamsType:'limit',//查询参数组织方式
                queryParams : function (params) {//上传服务器的参数
                    var temp = {//如果是在服务器端实现分页，limit、offset这两个参数是必须的
                        pid: pid,
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
                        title: '分类名称'
                    },
                    {
                        field: 'status',
                        title: '分类状态'
                    },
                    {
                        field: 'sort_order',
                        title: '优先级'
                    },
                    {
                        field: 'created',
                        title: '创建时间'
                    },
                    {
                        field: 'updated',
                        title: '更新时间'
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

                ]
            });
		}
    </script>
</body>

</html>
