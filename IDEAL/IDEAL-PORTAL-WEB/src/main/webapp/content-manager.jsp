<%--
  Created by IntelliJ IDEA.
  User: 任章哲
  Date: 2019/1/15
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Amaze UI Admin index Examples</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="PORTAL-WEB-SOURCE/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="PORTAL-WEB-SOURCE/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="PORTAL-WEB-SOURCE/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="PORTAL-WEB-SOURCE/assets/css/admin.css">
    <link rel="stylesheet" href="PORTAL-WEB-SOURCE/assets/css/app.css">
    <script src="PORTAL-WEB-SOURCE/assets/js/echarts.min.js"></script>
    <!-- ZTREE CSS -->
    <link rel="stylesheet" href="assets/ztree/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="assets/ztree/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="assets/ztree/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="assets/ztree/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="assets/ztree/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="assets/ztree/static/h-ui.admin/css/style.css" />
    <!-- VENDOR CSS -->
    <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/vendor/linearicons/style.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="assets/css/main.css">
    <link rel="stylesheet" type="text/css" href="assets/vendor/ztree/css/metroStyle/metroStyle.css" />

    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
    <!-- BOOTSTRAP TABLE-->
    <link rel="stylesheet" href="assets/vendor/bootstrap-table/bootstrap-table.css">
    <!-- GOOGLE FONTS -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
    <!-- bootstarpeditable相关css -->
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="assets/vendor/bootstrap3-editable/css/bootstrap-editable.css" rel="stylesheet" />
    <link href="assets/vendor/bootstrap-table/bootstrap-table.css" rel="stylesheet" />
</head>

<body data-type="index">


<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand">
        <a href="javascript:;" class="tpl-logo">
            <img src="PORTAL-WEB-SOURCE/assets/img/logo.png" alt="">
        </a>
    </div>
    <div class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right">

    </div>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                    <span class="am-icon-bell-o"></span> 提醒 <span class="am-badge tpl-badge-success am-round">5</span></span>
                </a>
                <ul class="am-dropdown-content tpl-dropdown-content">
                    <li class="tpl-dropdown-content-external">
                        <h3>你有 <span class="tpl-color-success">5</span> 条提醒</h3><a href="###">全部</a></li>
                    <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span class="am-icon-btn am-icon-plus tpl-dropdown-ico-btn-size tpl-badge-success"></span> 【预览模块】移动端 查看时 手机、电脑框隐藏。</a>
                        <span class="tpl-dropdown-list-fr">3小时前</span>
                    </li>
                    <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span class="am-icon-btn am-icon-check tpl-dropdown-ico-btn-size tpl-badge-danger"></span> 移动端，导航条下边距处理</a>
                        <span class="tpl-dropdown-list-fr">15分钟前</span>
                    </li>
                    <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span class="am-icon-btn am-icon-bell-o tpl-dropdown-ico-btn-size tpl-badge-warning"></span> 追加统计代码</a>
                        <span class="tpl-dropdown-list-fr">2天前</span>
                    </li>
                </ul>
            </li>
            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                    <span class="am-icon-comment-o"></span> 消息 <span class="am-badge tpl-badge-danger am-round">9</span></span>
                </a>
                <ul class="am-dropdown-content tpl-dropdown-content">
                    <li class="tpl-dropdown-content-external">
                        <h3>你有 <span class="tpl-color-danger">9</span> 条新消息</h3><a href="###">全部</a></li>
                    <li>
                        <a href="#" class="tpl-dropdown-content-message">
                                <span class="tpl-dropdown-content-photo">
                      <img src="PORTAL-WEB-SOURCE/assets/img/user02.png" alt=""> </span>
                            <span class="tpl-dropdown-content-subject">
                      <span class="tpl-dropdown-content-from"> 禁言小张 </span>
                                <span class="tpl-dropdown-content-time">10分钟前 </span>
                                </span>
                            <span class="tpl-dropdown-content-font"> Amaze UI 的诞生，依托于 GitHub 及其他技术社区上一些优秀的资源；Amaze UI 的成长，则离不开用户的支持。 </span>
                        </a>
                        <a href="#" class="tpl-dropdown-content-message">
                                <span class="tpl-dropdown-content-photo">
                      <img src="PORTAL-WEB-SOURCE/assets/img/user03.png" alt=""> </span>
                            <span class="tpl-dropdown-content-subject">
                      <span class="tpl-dropdown-content-from"> Steam </span>
                                <span class="tpl-dropdown-content-time">18分钟前</span>
                                </span>
                            <span class="tpl-dropdown-content-font"> 为了能最准确的传达所描述的问题， 建议你在反馈时附上演示，方便我们理解。 </span>
                        </a>
                    </li>

                </ul>
            </li>
            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                    <span class="am-icon-calendar"></span> 进度 <span class="am-badge tpl-badge-primary am-round">4</span></span>
                </a>
                <ul class="am-dropdown-content tpl-dropdown-content">
                    <li class="tpl-dropdown-content-external">
                        <h3>你有 <span class="tpl-color-primary">4</span> 个任务进度</h3><a href="###">全部</a></li>
                    <li>
                        <a href="javascript:;" class="tpl-dropdown-content-progress">
                                <span class="task">
                        <span class="desc">Amaze UI 用户中心 v1.2 </span>
                                <span class="percent">45%</span>
                                </span>
                            <span class="progress">
                        <div class="am-progress tpl-progress am-progress-striped"><div class="am-progress-bar am-progress-bar-success" style="width:45%"></div></div>
                    </span>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:;" class="tpl-dropdown-content-progress">
                                <span class="task">
                        <span class="desc">新闻内容页 </span>
                                <span class="percent">30%</span>
                                </span>
                            <span class="progress">
                       <div class="am-progress tpl-progress am-progress-striped"><div class="am-progress-bar am-progress-bar-secondary" style="width:30%"></div></div>
                    </span>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:;" class="tpl-dropdown-content-progress">
                                <span class="task">
                        <span class="desc">管理中心 </span>
                                <span class="percent">60%</span>
                                </span>
                            <span class="progress">
                        <div class="am-progress tpl-progress am-progress-striped"><div class="am-progress-bar am-progress-bar-warning" style="width:60%"></div></div>
                    </span>
                        </a>
                    </li>

                </ul>
            </li>
            <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen" class="tpl-header-list-link"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>

            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                    <span class="tpl-header-list-user-nick">禁言小张</span><span class="tpl-header-list-user-ico"> <img src="PORTAL-WEB-SOURCE/assets/img/user01.png"></span>
                </a>
                <ul class="am-dropdown-content">
                    <li><a href="#"><span class="am-icon-bell-o"></span> 资料</a></li>
                    <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
                    <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
                </ul>
            </li>
            <li><a href="###" class="tpl-header-list-link"><span class="am-icon-sign-out tpl-header-list-ico-out-size"></span></a></li>
        </ul>
    </div>
</header>







<div class="tpl-page-container tpl-page-header-fixed">


    <div class="tpl-left-nav tpl-left-nav-hover">
        <div class="tpl-left-nav-title">
            Amaze UI 列表
        </div>
        <div class="tpl-left-nav-list">
            <ul class="tpl-left-nav-menu">
                <li class="tpl-left-nav-item">
                    <a href="index.jsp" class="nav-link active">
                        <i class="am-icon-home"></i>
                        <span>首页</span>
                    </a>
                </li>
                <li class="tpl-left-nav-item">
                    <a href="chart.jsp" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-bar-chart"></i>
                        <span>数据表</span>
                        <i class="tpl-left-nav-content tpl-badge-danger">
                            12
                        </i>
                    </a>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-table"></i>
                        <span>表格</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu">
                        <li>
                            <a href="table-font-list.jsp">
                                <i class="am-icon-angle-right"></i>
                                <span>文字表格</span>
                                <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                            </a>

                            <a href="table-images-list.jsp">
                                <i class="am-icon-angle-right"></i>
                                <span>图片表格</span>
                                <i class="tpl-left-nav-content tpl-badge-success">
                                    18
                                </i>

                                <a href="form-news.jsp">
                                    <i class="am-icon-angle-right"></i>
                                    <span>消息列表</span>
                                    <i class="tpl-left-nav-content tpl-badge-primary">
                                        5
                                    </i>


                                    <a href="form-news-list.jsp">
                                        <i class="am-icon-angle-right"></i>
                                        <span>文字列表</span>

                                    </a>
                        </li>
                    </ul>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-wpforms"></i>
                        <span>表单</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu" >
                        <li>
                            <a href="form-amazeui.jsp">
                                <i class="am-icon-angle-right"></i>
                                <span>Amaze UI 表单</span>
                                <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                            </a>

                            <a href="form-line.jsp">
                                <i class="am-icon-angle-right"></i>
                                <span>线条表单</span>
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list active">
                        <i class="am-icon-table"></i>
                        <span>网站内容管理</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu" style="display: block;">
                        <li>


                            <a href="content-category-manager.jsp">
                                <i class="am-icon-angle-right"></i>
                                <span>内容分类管理</span>
                                <i class="tpl-left-nav-content tpl-badge-success">
                                    18
                                </i>

                                <a href="content-manager.jsp" class="active">
                                    <i class="am-icon-angle-right"></i>
                                    <span>内容管理</span>
                                    <i class="tpl-left-nav-content tpl-badge-primary">
                                        5
                                    </i>


                        </li>
                    </ul>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="login.jsp" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-key"></i>
                        <span>登录</span>

                    </a>
                </li>
            </ul>
        </div>
    </div>


    <div class="tpl-content-wrapper">
        <div class="tpl-content-page-title">
            内容管理
        </div>
        <ol class="am-breadcrumb">
            <li><a href="index.html" class="am-icon-home">首页</a></li>
            <li><a href="#">网页内容管理</a></li>
            <li class="am-active">内容管理</li>
        </ol>
        <div class="tpl-portlet-components" style="width:100%;">
            <div id="left" style="display:inline;width:25%;float:left;border-left:1px solid #b0c4de;border-top:1px solid #b0c4de;border-bottom:1px solid #b0c4de;">

                <ul id="treeDemo" class="ztree" style="left:5px;font-size:10px;color:#000">

                </ul>

            </div>

            <div id="right" style="width:75%;float:left;border:1px solid #b0c4de;">
                <div id="toolbar">
                    <a><button onclick="clickPlus()" id="add-good" class="btn btn-default" type="button" style="float: left;border-top-right-radius: 0%;border-bottom-right-radius: 0%;">
                        <span class="fa fa-plus" ></span>
                    </button></a>
                    <button onclick="clickMinus()" id="remove-good" class="btn btn-default" type="button" style="margin-right: 5px;float: left;border-top-left-radius: 0%;border-bottom-left-radius: 0%;border-left:0;">
                        <span class="fa fa-minus"></span>
                    </button>
                </div>
                <table id="table" data-buttons-align="right"></table>
            </div>

        </div>

    </div>


</div>

<!-- Javascript -->

<!-- bootstrap-editable相关js -->


<script src="PORTAL-WEB-SOURCE/assets/js/jquery.min.js"></script>
<script src="PORTAL-WEB-SOURCE/assets/js/amazeui.min.js"></script>
<script src="PORTAL-WEB-SOURCE/assets/js/iscroll.js"></script>
<script src="PORTAL-WEB-SOURCE/assets/js/app.js"></script>
<script src="PORTAL-WEB-SOURCE/assets/js/echarts.min.js"></script>
<script src="PORTAL-WEB-SOURCE/assets/vendor/ztree/js/jquery.ztree.all.js"></script>
<script src="assets/scripts/klorofil-common.js"></script>
<script src="assets/scripts/custom-scripts.js"></script>
<script src="PORTAL-WEB-SOURCE/assets/vendor/bootstrap/js/bootstrap.js"></script>
<script src="PORTAL-WEB-SOURCE/assets/vendor/bootstrap3-editable/js/bootstrap-editable.js"></script>
<script src="PORTAL-WEB-SOURCE/assets/vendor/bootstrap-table/bootstrap-table.min.js"></script>
<script src="PORTAL-WEB-SOURCE/assets/vendor/bootstrap-table/bootstrap-table-zh-CN.min.js"></script>
<script src="assets/vendor/bootstrap3-editable/js/bootstrap-table-editable.js"></script>

<script>
    console.log(1);
    var url='/portal/ztree/content_category.do';
    $.ajax({
        url:url,
        dataType:'json',
        processData: false,
        type:'get',
        success:function(result){
            console.log(result);
            console.log('您现在访问的是：'+url);
            var zNodes=result.data;
            var t = $("#treeDemo");
            //初始化ztree
            t = $.fn.zTree.init(t, setting, zNodes);
        },
        error:function(XMLHttpRequest, textStatus, errorThrown) {
            console.log('fail');
        }});

    var setting= {
        check: {
            enable: true,
            chkStyle: "checkbox"//显示 checkbox 选择框，默认checkbox可选择值radio
        },
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
        edit:{
            enable:true,
            editNameSelectAll:true,

        },
        callback: {
            //点击Ztree内容执行事件
            beforeClick: function (treeId, treeNode) {
                console.log(2);
                console.log(treeNode);
                var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                /*if (treeNode.isParent) {
                    zTree.expandNode(treeNode);
                    return false;
                } else {
                    //demoIframe.attr("src",treeNode.file + ".html");
                    return true;
                }*/
                $("#table").bootstrapTable('destroy');
                initTable('/portal/bootstrap/editContentCategory.do',treeNode.id);
            },
            //树复选框选中事件
            onCheck: zTreeOnCheck,
            onRename:ztreeOnRename,
        },
        edit:{
            enable:true,
            showRenameBtn:true,
            showRemoveBtn:true,
            removeTitle:"删除",
            renameTitle:"修改"
        }


    }
    function ztreeOnRename(){
        console.log(2);
    }

    //复选框选中执行事件
    function zTreeOnCheck(event, treeId, treeNode){
        console.log(1);
        //列表初始化
        //Table = XINER.initManagerLogoTable("#table");
        var treeObj=$.fn.zTree.getZTreeObj("treeDemo"),
            nodes=treeObj.getCheckedNodes(true),
            name="",
            cid="";
        for(var i=0;i<nodes.length;i++){
            //name+=nodes[i].name + "; ";
            cid+=nodes[i].id + ",";
            console.log("节点id:"+nodes[i].id); //获取选中节点的值
        }
        console.log(cid);
        //先将选中的子节点信息拿到，去查询内容内分信息表该节点是否为子叶节点，如果是，在table区域展开其内容
        var url = '';
        var data = {
             'id':id
        };
        $.getJSONP(url,data,function(result){
            if(result.data.isParent==0){
                //等于0说明是子叶节点
                //$("#table").bootstrapTable('destroy');
                //initTable('/portal/bootstrap/editContent.do',cid);
            }else{
                //不是子叶节点
            }
        });
        //加载table

    }


    //初始化table
    function initTable( edit_url,id) {
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
                    title: '具体内容',
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
                    field: 'titleDesc',
                    title: '具体内容',
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
                        console.log('您现在访问的是：'+edit_url);
                        /* $("#table").bootstrapTable('refresh',cid);
                        if (status == "success") {
                            alert('提交数据成功');
                        } */
                    },
                    error: function () {
                        console.log('失败您现在访问的是：'+edit_url);
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
                        console.log('编辑失败');
                        console.log(row);
                        console.log(date);
                        console.log(field);
                    },
                    complete: function () {

                    }

                });
            }
        });
    }


</script>
</body>

</html>
