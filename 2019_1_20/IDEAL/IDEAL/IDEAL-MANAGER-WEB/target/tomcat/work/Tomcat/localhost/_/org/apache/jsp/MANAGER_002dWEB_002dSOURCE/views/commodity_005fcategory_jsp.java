/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-01-23 01:03:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.MANAGER_002dWEB_002dSOURCE.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class commodity_005fcategory_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Notifications</title>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\">\r\n");
      out.write("    <!-- VENDOR CSS -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/vendor/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/vendor/font-awesome/css/font-awesome.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/vendor/linearicons/style.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/vendor/toastr/toastr.min.css\">\r\n");
      out.write("    <!-- MAIN CSS -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/main.css\">\r\n");
      out.write("    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/demo.css\">\r\n");
      out.write("    <!-- GOOGLE FONTS -->\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- ICONS -->\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"assets/img/apple-icon.png\">\r\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" sizes=\"96x96\" href=\"assets/img/favicon.png\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"assets/vendor/ztree/css/metroStyle/metroStyle.css\" />\r\n");
      out.write("    <!-- bootstarpeditable相关css -->\r\n");
      out.write("    <link href=\"assets/vendor/bootstrap3-editable/css/bootstrap-editable.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <link href=\"assets/vendor/bootstrap-table/bootstrap-table.css\" rel=\"stylesheet\" />\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<!-- WRAPPER -->\r\n");
      out.write("<div id=\"wrapper\">\r\n");
      out.write("    <!-- NAVBAR -->\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "template/nav.jsp", out, false);
      out.write("\r\n");
      out.write("    <!-- END NAVBAR -->\r\n");
      out.write("    <!-- LEFT SIDEBAR -->\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "template/list.jsp", out, false);
      out.write("\r\n");
      out.write("    <!-- END LEFT SIDEBAR -->\r\n");
      out.write("    <!-- MAIN -->\r\n");
      out.write("    <div class=\"main\">\r\n");
      out.write("        <!-- MAIN CONTENT -->\r\n");
      out.write("        <div class=\"main-content\">\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("                <h3 class=\"page-title\">商品分类管理</h3>\r\n");
      out.write("                <div class=\"content\">\r\n");
      out.write("                    <div class=\"container-fluid\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-2\">\r\n");
      out.write("                                <div id=\"left\"  style=\"display:inline;width:100%;border:1px solid #b0c4de;float:left;\">\r\n");
      out.write("                                    <ul id=\"treeDemo\" class=\"ztree\"  style=\"width:100%;left:5px;font-size:10px;color:#000\">\r\n");
      out.write("\r\n");
      out.write("                                    </ul>\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"col-md-10\" id=\"right\" style=\"width:75%;float:left;border:1px solid #b0c4de;\">\r\n");
      out.write("                                <div class=\"card\">\r\n");
      out.write("                                    <div id=\"showTable\">\r\n");
      out.write("                                        <div id=\"toolbar\">\r\n");
      out.write("                                            <a><button  id=\"add-good\"  class=\"btn btn-default\" type=\"button\" style=\"float: left;border-top-right-radius: 0%;border-bottom-right-radius: 0%;\">\r\n");
      out.write("                                                <span class=\"fa fa-plus\" ></span>\r\n");
      out.write("                                            </button></a>\r\n");
      out.write("                                            <button  id=\"remove-good\" class=\"btn btn-default\" type=\"button\" style=\"margin-right: 5px;float: left;border-top-left-radius: 0%;border-bottom-left-radius: 0%;border-left:0;\">\r\n");
      out.write("                                                <span class=\"fa fa-minus\"></span>\r\n");
      out.write("                                            </button>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <table id=\"table\" data-buttons-align=\"right\"></table>\r\n");
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-lg-9\" id=\"showForm\" style=\"display:none\">\r\n");
      out.write("                                        <form class=\"form-horizontal\" role=\"form\" onsubmit=\"clickSubmit()\" id=\"form\">\r\n");
      out.write("                                            <legend style=\"margin-bottom: 30px;\">添加商品分类</legend>\r\n");
      out.write("                                            <ul>\r\n");
      out.write("                                                <li>\r\n");
      out.write("                                                    <div class=\"form-group\" style=\"margin-bottom: 20px\">\r\n");
      out.write("                                                        <label for=\"title\" class=\"col-lg-3 control-label\">分类名称</label>\r\n");
      out.write("                                                        <div class=\"col-lg-10\">\r\n");
      out.write("                                                            <input type=\"text\" class=\"form-control\" name=\"title\" placeholder=\"请输入商品所属类别\">\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                </li>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                                <li>\r\n");
      out.write("                                                    <div class=\"form-group\">\r\n");
      out.write("                                                        <div class=\"col-lg-offset-2 col-lg-4\" >\r\n");
      out.write("                                                            <button type=\"button\" id=\"submit1\" class=\"btn btn-success\" >确认</button>\r\n");
      out.write("                                                            &nbsp&nbsp&nbsp\r\n");
      out.write("                                                            <button type=\"reset\" class=\"btn btn-default\" onclick=\"clickExit()\" >返回</button>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                </li>\r\n");
      out.write("                                            </ul>\r\n");
      out.write("                                        </form>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- END MAIN CONTENT -->\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- END MAIN -->\r\n");
      out.write("    <div class=\"clearfix\"></div>\r\n");
      out.write("    <footer>\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("            <p class=\"copyright\">Copyright &copy; 2017.Company name All rights reserved.More Templates <a href=\"http://www.cssmoban.com/\" target=\"_blank\" title=\"模板之家\">模板之家</a> - Collect from <a href=\"http://www.cssmoban.com/\" title=\"网页模板\" target=\"_blank\">网页模板</a></p>\r\n");
      out.write("        </div>\r\n");
      out.write("    </footer>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- END WRAPPER -->\r\n");
      out.write("<!-- Javascript -->\r\n");
      out.write("<script src=\"assets/vendor/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"assets/vendor/jquery/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"assets/vendor/popper.js/popper.min.js\"></script>\r\n");
      out.write("<script src=\"assets/vendor/chart.js/chart.min.js\"></script>\r\n");
      out.write("<script src=\"assets/js/carbon.js\"></script>\r\n");
      out.write("<script src=\"assets/js/demo.js\"></script>\r\n");
      out.write("<script src=\"assets/vendor/ztree/js/jquery.ztree.all.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"assets/vendor/bootstrap/js/bootstrap.js\"></script>\r\n");
      out.write("<script src=\"assets/vendor/bootstrap3-editable/js/bootstrap-editable.js\"></script>\r\n");
      out.write("<script src=\"assets/vendor/bootstrap-table/bootstrap-table.min.js\"></script>\r\n");
      out.write("<script src=\"assets/vendor/bootstrap-table/bootstrap-table-zh-CN.min.js\"></script>\r\n");
      out.write("<script src=\"assets/vendor/bootstrap3-editable/js/bootstrap-table-editable.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    var url = \"/manager/ztree/commodityCate.do\";\r\n");
      out.write("    $('#showForm').hide();\r\n");
      out.write("    $('#remove-good').click(removeCommodityCat);\r\n");
      out.write("    $('#add-good').click(addCommodityCat);\r\n");
      out.write("    $('#submit1').click(submit);\r\n");
      out.write("    function addCommodityCat(){\r\n");
      out.write("        $('#showForm').show();\r\n");
      out.write("        $('#showTable').hide();\r\n");
      out.write("    }\r\n");
      out.write("    function removeCommodityCat(){\r\n");
      out.write("        var rows = $(table).bootstrapTable('getSelections');\r\n");
      out.write("        var  id ='';\r\n");
      out.write("        for(var i=0;i<rows.length;i++){\r\n");
      out.write("            id=id+rows[i].id+',';\r\n");
      out.write("        }\r\n");
      out.write("        //console.log(id);\r\n");
      out.write("        var url = \"/manager/bootstrap/removeCate.do\";\r\n");
      out.write("        var data = {\r\n");
      out.write("            'pid':$(table).data('id'),\r\n");
      out.write("            'id' : id\r\n");
      out.write("        };\r\n");
      out.write("        $.post( url,data,function(result){\r\n");
      out.write("            //console.log(result);\r\n");
      out.write("            $(\"#table\").bootstrapTable('destroy');\r\n");
      out.write("            initTable('/portal/content/editContent.do',$('#left').data('treeNodeId'));\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("    function submit(){\r\n");
      out.write("        var name = $('#showForm').find('input[name=\"title\"]').val();\r\n");
      out.write("        var pid = $(table).data(\"id\");\r\n");
      out.write("        //console.log(name);\r\n");
      out.write("        console.log(pid);\r\n");
      out.write("        var url = '/manager/bootstrap/commodityCat.do';\r\n");
      out.write("        var data = {\r\n");
      out.write("            'pid':pid,\r\n");
      out.write("            'name':name\r\n");
      out.write("        };\r\n");
      out.write("        $.post(url,data,function(result){\r\n");
      out.write("            console.log(result);\r\n");
      out.write("            $('input').val(\"\");\r\n");
      out.write("            clickExit();\r\n");
      out.write("            $(\"#table\").bootstrapTable('destroy');\r\n");
      out.write("            initTable('/portal/content/editContent.do',$('#left').data('treeNodeId'));\r\n");
      out.write("        });\r\n");
      out.write("    }\r\n");
      out.write("    function clickExit(){\r\n");
      out.write("        $('#showTable').show();\r\n");
      out.write("        $('#showForm').hide();\r\n");
      out.write("    }\r\n");
      out.write("    $.ajax({\r\n");
      out.write("        url:url,\r\n");
      out.write("        dataType:'json',\r\n");
      out.write("        processData: false,\r\n");
      out.write("        type:'get',\r\n");
      out.write("        success:function(result){\r\n");
      out.write("            //console.log(result);\r\n");
      out.write("            //console.log('您现在访问的是：'+url);\r\n");
      out.write("            //console.log(result[0].pId);\r\n");
      out.write("            for(var i=0;i<result.length;i++){\r\n");
      out.write("                if(result[i].pId==0){\r\n");
      out.write("                    result[i].open = true;\r\n");
      out.write("                }else{\r\n");
      out.write("                    result[i].open = false;\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("            var zNodes=result;\r\n");
      out.write("            var t = $(\"#treeDemo\");\r\n");
      out.write("            $('#left').data()\r\n");
      out.write("            //初始化ztree\r\n");
      out.write("\r\n");
      out.write("            t = $.fn.zTree.init(t, setting, zNodes);\r\n");
      out.write("            //console.log(2);\r\n");
      out.write("        },\r\n");
      out.write("        error:function(XMLHttpRequest, textStatus, errorThrown) {\r\n");
      out.write("            console.log('fail');\r\n");
      out.write("        }});\r\n");
      out.write("    var setting= {\r\n");
      out.write("\r\n");
      out.write("        view: {\r\n");
      out.write("            selectedMulti: true, //设置是否能够同时选中多个节点\r\n");
      out.write("            showIcon: true,      //设置是否显示节点图标\r\n");
      out.write("            showLine: true,      //设置是否显示节点与节点之间的连线\r\n");
      out.write("            showTitle: true,     //设置是否显示节点的title提示信息\r\n");
      out.write("        },\r\n");
      out.write("\r\n");
      out.write("        data: {\r\n");
      out.write("            simpleData: {\r\n");
      out.write("                enable: true,\r\n");
      out.write("                idKey: \"id\",\r\n");
      out.write("                pIdKey: \"pId\",\r\n");
      out.write("                rootPId: \"\"\r\n");
      out.write("            }\r\n");
      out.write("        },\r\n");
      out.write("        callback: {\r\n");
      out.write("            //点击Ztree内容执行事件\r\n");
      out.write("            beforeClick: function (treeId, treeNode) {\r\n");
      out.write("                //console.log(3);\r\n");
      out.write("                console.log(treeNode.id);\r\n");
      out.write("                $('#left').data(\"treeNodeId\",treeNode.id);\r\n");
      out.write("                //请求后台根据选中的ID去看他是否为子叶节点，是则初始化内容table，不是则初始化内容分类tabl\r\n");
      out.write("                $(\"#table\").bootstrapTable('destroy');\r\n");
      out.write("                initTable('/manager/bootstrap/editCommodityCategory.do',treeNode.id);\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            },\r\n");
      out.write("\r\n");
      out.write("        },\r\n");
      out.write("        edit:{\r\n");
      out.write("            enable:true,\r\n");
      out.write("            showRenameBtn:true,\r\n");
      out.write("            showRemoveBtn:true,\r\n");
      out.write("            removeTitle:\"删除\",\r\n");
      out.write("            renameTitle:\"修改\"\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function initTable( edit_url,id) {\r\n");
      out.write("        $(table).data(\"id\",id);\r\n");
      out.write("        $(\"#table\").bootstrapTable({\r\n");
      out.write("            url: \"/manager/initTable/commodityCategory.do\",       //请求后台的URL（*）\r\n");
      out.write("            method: 'get',                      //请求方式（*）\r\n");
      out.write("            contentType: \"application/x-www-form-urlencoded\",\r\n");
      out.write("            dataType: \"json\",\r\n");
      out.write("            toolbar: '#toolbar',                //工具按钮用哪个容器\r\n");
      out.write("            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）\r\n");
      out.write("            pagination: true,                   //是否显示分页（*）\r\n");
      out.write("            sortable: true,                     //是否启用排序\r\n");
      out.write("            sortOrder: \"asc\",                   //排序方式\r\n");
      out.write("            sidePagination: \"server\",           //分页方式：client客户端分页，server服务端分页（*）\r\n");
      out.write("            pageNumber: 1,                       //初始化加载第一页，默认第一页\r\n");
      out.write("            pageSize: 15,                       //每页的记录行数（*）\r\n");
      out.write("            pageList: [15, 30, 50, 100],        //可供选择的每页的行数（*）\r\n");
      out.write("            showColumns: true,                  //是否显示所有的列\r\n");
      out.write("            height: 750,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度\r\n");
      out.write("            queryParamsType: 'limit',//查询参数组织方式\r\n");
      out.write("            queryParams: function (params) {//上传服务器的参数\r\n");
      out.write("                var temp = {//如果是在服务器端实现分页，limit、offset这两个参数是必须的\r\n");
      out.write("                    pid: id,\r\n");
      out.write("                    limit: params.limit, // 每页显示数量\r\n");
      out.write("                    page: (params.offset / params.limit) + 1   //当前页码\r\n");
      out.write("                };\r\n");
      out.write("                return temp;\r\n");
      out.write("            },\r\n");
      out.write("            columns: [\r\n");
      out.write("                {\r\n");
      out.write("                    checkbox: true, // 显示一个勾选框\r\n");
      out.write("                    align: 'center' // 居中显示\r\n");
      out.write("                },\r\n");
      out.write("                {\r\n");
      out.write("                    field: 'name',\r\n");
      out.write("                    title: '商品类别',\r\n");
      out.write("                    editable: {\r\n");
      out.write("                        type: 'text',\r\n");
      out.write("                        title: '修改商品类别',\r\n");
      out.write("                        placement: 'right',\r\n");
      out.write("                        emptytext: \"空文本\",\r\n");
      out.write("                        validate: function(v) {\r\n");
      out.write("                            if (!v) return '用户名不能为空';\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                },\r\n");
      out.write("                {\r\n");
      out.write("                    field: 'id',\r\n");
      out.write("                    title: 'ID',\r\n");
      out.write("                    visible:false\r\n");
      out.write("                },\r\n");
      out.write("                {\r\n");
      out.write("                    field: 'status',\r\n");
      out.write("                    title: '状态',\r\n");
      out.write("                    editable: {\r\n");
      out.write("                        type: 'text',\r\n");
      out.write("                        title: '修改状态',\r\n");
      out.write("                        placement: 'right',\r\n");
      out.write("                        emptytext: \"空文本\",\r\n");
      out.write("                        validate: function(v) {\r\n");
      out.write("                            if (!v) return '用户名不能为空';\r\n");
      out.write("                        },\r\n");
      out.write("                        formatter:function(value, row, index){\r\n");
      out.write("                            if(value==0){\r\n");
      out.write("                                console.log(\"xiajia\");\r\n");
      out.write("                            return '<a href=\"javascript:void(0)\" data-name=\"status\" data-pk=\"undefined\" data-value=\"0\" class=\"editable editable-click\">正常</a>';\r\n");
      out.write("                            }else{\r\n");
      out.write("                                return '<a href=\"javascript:void(0)\" data-name=\"status\" data-pk=\"undefined\" data-value=\"0\" class=\"editable editable-click\">下架</a>';\r\n");
      out.write("                            }\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                },\r\n");
      out.write("                {\r\n");
      out.write("                    field: 'created',\r\n");
      out.write("                    title: '创建时间',\r\n");
      out.write("                    formatter: function (value, row, index) {\r\n");
      out.write("                        return changeDateFormat(value);\r\n");
      out.write("                    }\r\n");
      out.write("\r\n");
      out.write("                },\r\n");
      out.write("                {\r\n");
      out.write("                    field: 'id',\r\n");
      out.write("                    title: 'ID',\r\n");
      out.write("                    visible:false\r\n");
      out.write("                },\r\n");
      out.write("                {\r\n");
      out.write("                    field: 'updated',\r\n");
      out.write("                    title: '更新时间',\r\n");
      out.write("                    formatter: function (value, row, index) {\r\n");
      out.write("                        return changeDateFormat(value);\r\n");
      out.write("                    }\r\n");
      out.write("                },\r\n");
      out.write("                {\r\n");
      out.write("                    field: '',\r\n");
      out.write("                    title: '操作',\r\n");
      out.write("                    align: 'center',\r\n");
      out.write("                    formatter: function () {\r\n");
      out.write("                        var result = \"\";\r\n");
      out.write("                        result += \"<a href='javascript:;' class='btn btn-xs' title='编辑'><span class='glyphicon glyphicon-cog'></span></a>\";\r\n");
      out.write("                        return result;\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("            ],\r\n");
      out.write("            onEditableSave: function ( field, row ) {\r\n");
      out.write("                //console.log(9);\r\n");
      out.write("                //console.log(field);\r\n");
      out.write("                console.log(row);\r\n");
      out.write("                $.ajax({\r\n");
      out.write("                    type: \"post\",\r\n");
      out.write("                    url: edit_url,\r\n");
      out.write("                    data:{\r\n");
      out.write("                        'id':row.id,\r\n");
      out.write("                        'pId':row.pid,\r\n");
      out.write("                        'name':row.name,\r\n");
      out.write("                        'status':row.status,\r\n");
      out.write("                        'sort':row.sort,\r\n");
      out.write("                        'isparent':row.isparent,\r\n");
      out.write("                        'created':row.created,\r\n");
      out.write("                        'updated':row.updated\r\n");
      out.write("\r\n");
      out.write("                    },\r\n");
      out.write("                    dataType: 'JSON',\r\n");
      out.write("                    success: function (result) {\r\n");
      out.write("                        //console.log('您现在访问的是：'+edit_url);\r\n");
      out.write("                        /* $(\"#table\").bootstrapTable('refresh',cid);\r\n");
      out.write("                        if (status == \"success\") {\r\n");
      out.write("                            alert('提交数据成功');\r\n");
      out.write("                        } */\r\n");
      out.write("                    },\r\n");
      out.write("                    error: function () {\r\n");
      out.write("                        //console.log('失败您现在访问的是：'+edit_url);\r\n");
      out.write("                        date = {\r\n");
      out.write("                            'id':row.id,\r\n");
      out.write("                            'pId':row.pid,\r\n");
      out.write("                            'name':row.name,\r\n");
      out.write("                            'status':row.status,\r\n");
      out.write("                            'sort':row.sort,\r\n");
      out.write("                            'isparent':row.isparent,\r\n");
      out.write("                            'created':row.created,\r\n");
      out.write("                            'updated':row.updated\r\n");
      out.write("                        }\r\n");
      out.write("                        //console.log('编辑失败');\r\n");
      out.write("                        //console.log(row);\r\n");
      out.write("                        //console.log(date);\r\n");
      out.write("                        //console.log(field);\r\n");
      out.write("                    },\r\n");
      out.write("                    complete: function () {\r\n");
      out.write("\r\n");
      out.write("                    }\r\n");
      out.write("\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    function changeDateFormat(cellval) {\r\n");
      out.write("        if (cellval != null) {\r\n");
      out.write("            var date = new Date(parseInt(cellval));\r\n");
      out.write("            var month = date.getMonth() + 1 < 10 ? \"0\" + (date.getMonth() + 1) : date.getMonth() + 1;\r\n");
      out.write("            var currentDate = date.getDate() < 10 ? \"0\" + date.getDate() : date.getDate();\r\n");
      out.write("\r\n");
      out.write("            var hh24 = date.getHours();\r\n");
      out.write("            var mi = date.getMinutes();\r\n");
      out.write("            var ss = date.getSeconds();\r\n");
      out.write("\r\n");
      out.write("            return date.getFullYear() + \"-\" + month + \"-\" + currentDate+\" \"+ hh24 +\":\"+mi+\":\"+ss;\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
