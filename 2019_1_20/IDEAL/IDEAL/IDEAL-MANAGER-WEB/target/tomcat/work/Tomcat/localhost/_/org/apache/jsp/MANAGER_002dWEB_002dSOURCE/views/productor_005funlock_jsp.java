/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-01-23 01:07:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.MANAGER_002dWEB_002dSOURCE.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class productor_005funlock_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Notifications</title>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\">\r\n");
      out.write("    <!-- VENDOR CSS -->\r\n");
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
      out.write("    <!-- bootstarpeditable相关css -->\r\n");
      out.write("    <link href=\"assets/vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <link href=\"assets/vendor/bootstrap3-editable/css/bootstrap-editable.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <link href=\"assets/vendor/bootstrap-table/bootstrap-table.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <!-- VENDOR CSS -->\r\n");
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
      out.write("                <h3 class=\"page-title\">解除被封用户</h3>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"tpl-block\">\r\n");
      out.write("\r\n");
      out.write("                    <div id=\"showTable\">\r\n");
      out.write("                        <div id=\"toolbar\">\r\n");
      out.write("\r\n");
      out.write("                            <button onclick=\"clickMinus()\" id=\"remove-good\" class=\"btn btn-default\" type=\"button\" style=\"margin-right: 5px;float: left;border-top-left-radius: 0%;border-bottom-left-radius: 0%;border-left:0;\">\r\n");
      out.write("                                解除\r\n");
      out.write("                            </button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <table id=\"table\" data-buttons-align=\"right\"></table>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"col-lg-9\" id=\"showForm\" style=\"display:none\">\r\n");
      out.write("                        <form class=\"form-horizontal\" role=\"form\" onsubmit=\"clickSubmit()\" id=\"form\">\r\n");
      out.write("                            <legend style=\"margin-bottom: 30px;\">添加商品</legend>\r\n");
      out.write("                            <ul>\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <div class=\"form-group\" style=\"margin-bottom: 20px\">\r\n");
      out.write("                                        <label for=\"name\" class=\"col-lg-3 control-label\">类别</label>\r\n");
      out.write("                                        <div class=\"col-lg-10\">\r\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" name=\"name\" placeholder=\"请输入商品所属类别\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </li>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <div class=\"col-lg-offset-2 col-lg-4\" >\r\n");
      out.write("                                            <button type=\"button\" class=\"btn btn-success\" onclick=\"clickSubmit()\">确认</button>\r\n");
      out.write("                                            &nbsp&nbsp&nbsp\r\n");
      out.write("                                            <button type=\"reset\" class=\"btn btn-default\" onclick=\"clickExit()\">返回</button>\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
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
      out.write("<script src=\"assets/vendor/jquery/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"assets/vendor/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js\"></script>\r\n");
      out.write("<script src=\"assets/vendor/toastr/toastr.min.js\"></script>\r\n");
      out.write("<script src=\"assets/scripts/klorofil-common.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Javascript -->\r\n");
      out.write("<script src=\"assets/scripts/klorofil-common.js\"></script>\r\n");
      out.write("<script src=\"assets/scripts/custom-scripts.js\"></script>\r\n");
      out.write("<!-- bootstrap-editable相关js -->\r\n");
      out.write("<script src=\"assets/vendor/bootstrap/js/bootstrap.js\"></script>\r\n");
      out.write("<script src=\"assets/vendor/bootstrap3-editable/js/bootstrap-editable.js\"></script>\r\n");
      out.write("<script src=\"assets/vendor/bootstrap-table/bootstrap-table.min.js\"></script>\r\n");
      out.write("<script src=\"assets/vendor/bootstrap-table/bootstrap-table-zh-CN.min.js\"></script>\r\n");
      out.write("<script src=\"assets/vendor/bootstrap3-editable/js/bootstrap-table-editable.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    //console.log(1);\r\n");
      out.write("    $(\"#table\").bootstrapTable('destroy');\r\n");
      out.write("    initTable('/manager/bootstrap/editProductorManager.do');\r\n");
      out.write("    $(\"input[name='btSelectItem']\").parents('.selected').find('td:eq(1)').text();\r\n");
      out.write("\r\n");
      out.write("    //初始化内容分类的table\r\n");
      out.write("    function initTable( edit_url) {\r\n");
      out.write("        //$(table).data(\"id\",id);\r\n");
      out.write("        $(\"#table\").bootstrapTable({\r\n");
      out.write("            url: \"/manager/initTable/clockProductorManager.do\",       //请求后台的URL（*）\r\n");
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
      out.write("                    field: 'id',\r\n");
      out.write("                    title: 'ID',\r\n");
      out.write("                    visible:false\r\n");
      out.write("                },\r\n");
      out.write("                {\r\n");
      out.write("                    field: 'logo',\r\n");
      out.write("                    title: 'logo',\r\n");
      out.write("                },{\r\n");
      out.write("                    field: 'companyZh',\r\n");
      out.write("                    title: '注册公司名字',\r\n");
      out.write("                },{\r\n");
      out.write("                    field: 'phone',\r\n");
      out.write("                    title: '官方电话',\r\n");
      out.write("                },{\r\n");
      out.write("                    field: 'mainbusiness',\r\n");
      out.write("                    title: '主营',\r\n");
      out.write("\r\n");
      out.write("                },{\r\n");
      out.write("                    field: 'type',\r\n");
      out.write("                    title: '类型',\r\n");
      out.write("\r\n");
      out.write("                },{\r\n");
      out.write("                    field: 'turnover',\r\n");
      out.write("                    title: '年营业额',\r\n");
      out.write("\r\n");
      out.write("                },{\r\n");
      out.write("                    field: 'employees',\r\n");
      out.write("                    title: '员工人数',\r\n");
      out.write("\r\n");
      out.write("                },\r\n");
      out.write("                {\r\n");
      out.write("                    field: 'website',\r\n");
      out.write("                    title: '官方网址',\r\n");
      out.write("                },\r\n");
      out.write("                {\r\n");
      out.write("                    field: 'ceo',\r\n");
      out.write("                    title: 'CEO',\r\n");
      out.write("\r\n");
      out.write("                },\r\n");
      out.write("                {\r\n");
      out.write("                    field: 'email',\r\n");
      out.write("                    title: 'email',\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("            ]\r\n");
      out.write("        });\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    //移除商品\r\n");
      out.write("    function clickMinus(){\r\n");
      out.write("        //console.log('removeGood');\r\n");
      out.write("        var rows = $(table).bootstrapTable('getSelections');\r\n");
      out.write("        //console.log(rows);\r\n");
      out.write("\r\n");
      out.write("        //console.log(rows.length);\r\n");
      out.write("        var  id ='';\r\n");
      out.write("        var idArray = new Array();\r\n");
      out.write("        for(var i=0;i<rows.length;i++){\r\n");
      out.write("            id=id+rows[i].id+',';\r\n");
      out.write("            //idArray.push(rows[i].id);\r\n");
      out.write("            //console.log(rows[i].id);\r\n");
      out.write("        }\r\n");
      out.write("        //console.log(id);\r\n");
      out.write("        var data = {\r\n");
      out.write("            'id':id\r\n");
      out.write("        };\r\n");
      out.write("        //console.log(data);\r\n");
      out.write("        var url = '/manager/bootstrap/unClockProductor.do';\r\n");
      out.write("        $.post(url,data,function (result){\r\n");
      out.write("            //console.log(result);\r\n");
      out.write("            window.location.reload();\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
