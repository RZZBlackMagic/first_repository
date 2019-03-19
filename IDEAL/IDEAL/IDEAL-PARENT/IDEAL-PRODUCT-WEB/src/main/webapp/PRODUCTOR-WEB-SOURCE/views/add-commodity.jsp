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
                <h3 class="page-title">商品添加</h3>
                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <div class="panel panel-headline" style="min-height: 710px">
                            <div class="panel-heading">
                                <h3 class="panel-title" id="comzh"></h3>
                                <p class="panel-subtitle" id="comen"></p>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label for="title" class="form-control-label" >商品名称</label>
                                    <input id="title" type="text" class="form-control" placeholder="">
                                    <small class="form-text">请填写商品名称10-20字左右。</small>
                                </div>
                                <div class="form-group">
                                    <label for="category" class="form-control-label">选择类目</label>
                                    <input id="category" class="form-control" placeholder="" readonly style="background-color: white" data-toggle="modal" data-target="#Modal2">
                                    <input id="category-hidden" type="hidden">
                                </div>
                                <div class="form-group">
                                    <label class="form-control-label">规格<i class="fa fa-plus-square" style="margin-left: 7px" data-toggle="modal" data-target="#Modal"></i> </label>
                                    <div class="table-responsive">
                                        <table class="table table-hover" style="border: 1px solid #ced4da">
                                            <thead>
                                            <tr>
                                                <th>Type</th>
                                                <th>Value</th>
                                            </tr>
                                            </thead>
                                            <tbody id="spe"></tbody>
                                        </table>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="image" class="form-control-label">商品图片</label>
                                    <input type="file" id="image" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label for="sell-point">商品简介</label>
                                    <textarea id="sell-point" class="form-control" rows="6" placeholder="Enter an introduction to the product..."></textarea>
                                </div>

                                <div class="form-group" style="float: right">
                                    <button type="reset" class="btn btn-primary">
                                        Reset
                                    </button>
                                    <button type="button" class="btn btn-success" id="submit">
                                        Submit
                                    </button>
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
            <p class="copyright">Copyright &copy; 2017.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
        </div>
    </footer>
</div>

<div class="modal fade" id="Modal" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true" style="margin-top: 13%;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <h5 class="modal-title" id="myModalLabel">
                    添加规格
                </h5>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="spek" class="form-control-label">Key</label>
                            <input id="spek" class="form-control">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="spev" class="form-control-label">Value</label>
                            <input id="spev" class="form-control">
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="reset" class="btn btn-info" data-dismiss="modal" id="add-spe">
                    提交
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<div class="modal fade" id="Modal2" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true" style="margin-top: 10%;">
    <div class="modal-dialog" style="width: 25%;">
        <div class="modal-content">
            <div class="modal-header">

                <h5 class="modal-title" >
                    添加规格
                </h5>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-10 col-md-offset-2">
                        <div >
                            <ul id="treeDemo" style="max-height: 300px;overflow-y: auto" class="ztree"></ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
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
<script src="assets/vendor/kindeditor/lang/zh-CN.js"></script>
<script src="assets/vendor/ztree/js/jquery.ztree.all.js"></script>
<script>
    $(function () {
        checkTbodyEmpty();
        $.ajax({
            type:"post",
            url:"/product/tree/category",
            data:{"parentID": 0},
            dataType:"json",
            success:function(res){
                utils.initCatTree(res);
            },
            error:function(){
            }
        });
    });
    $("#add-spe").click(function () {
        if ($("#spek").val() == "" || $("#spev").val() == "") {
            return;
        }else if($("#null")){
            $("#null").remove();
        }
        $("#spe").append("<tr>" + "<td>"+$("#spek").val()+"</td>" + "<td class=\"text-nowrap\">"+$("#spev").val()+"</td>" + "</tr>");
    });
    $("#submit").click(function () {
        var spe_data = "";
        $("#spe").find("tr").each(function(){
            var tdArr = $(this).children();
            var key = tdArr.eq(0)[0].innerHTML;
            var val = tdArr.eq(1)[0].innerHTML;
            spe_data+=key + ":" + val + "/";
        });
        $.ajax({
            type: "post",
            url: "/product/commodity/add",
            data: {
                title: $("#title").val(),
                category: $("#category-hidden").val(),
                image: $("#image").val(),
                sellpoint: $("#sell-point").val(),
                apid: $.session.get('user_id'),
                spe: spe_data
            },
            dataType: 'JSON',
            success: function (data, status) {
            },
            error: function () {
                alert('添加失败');
            }
        });
    });
    function checkTbodyEmpty() {
        if(document.getElementById("spe").childNodes.length == 0){
            $("#spe").append("<tr id='null'>" + "<td>"+"null"+"</td>" + "<td class=\"text-nowrap\">"+"null"+"</td>" + "</tr>");
        }
    }


</script>
</body>

</html>
