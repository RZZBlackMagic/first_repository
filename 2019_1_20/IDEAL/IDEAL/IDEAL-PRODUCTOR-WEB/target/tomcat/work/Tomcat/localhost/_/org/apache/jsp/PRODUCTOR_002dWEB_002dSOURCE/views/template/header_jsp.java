/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-01-20 06:25:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.PRODUCTOR_002dWEB_002dSOURCE.views.template;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<header class=\"am-topbar am-topbar-inverse admin-header\">\r\n");
      out.write("    <div class=\"am-topbar-brand\">\r\n");
      out.write("        <a href=\"javascript:;\" class=\"tpl-logo\">\r\n");
      out.write("            <img src=\"assets/img/logo.png\" alt=\"\">\r\n");
      out.write("        </a>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right\">\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <button class=\"am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only\" data-am-collapse=\"{target: '#topbar-collapse'}\"><span class=\"am-sr-only\">导航切换</span> <span class=\"am-icon-bars\"></span></button>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"am-collapse am-topbar-collapse\" id=\"topbar-collapse\">\r\n");
      out.write("\r\n");
      out.write("        <ul class=\"am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list\">\r\n");
      out.write("            <li class=\"am-dropdown\" data-am-dropdown data-am-dropdown-toggle>\r\n");
      out.write("                <a class=\"am-dropdown-toggle tpl-header-list-link\" href=\"javascript:;\">\r\n");
      out.write("                    <span class=\"am-icon-bell-o\"></span> 提醒 <span class=\"am-badge tpl-badge-success am-round\">5</span></span>\r\n");
      out.write("                </a>\r\n");
      out.write("                <ul class=\"am-dropdown-content tpl-dropdown-content\">\r\n");
      out.write("                    <li class=\"tpl-dropdown-content-external\">\r\n");
      out.write("                        <h3>你有 <span class=\"tpl-color-success\">5</span> 条提醒</h3><a href=\"###\">全部</a></li>\r\n");
      out.write("                    <li class=\"tpl-dropdown-list-bdbc\"><a href=\"#\" class=\"tpl-dropdown-list-fl\"><span class=\"am-icon-btn am-icon-plus tpl-dropdown-ico-btn-size tpl-badge-success\"></span> 【预览模块】移动端 查看时 手机、电脑框隐藏。</a>\r\n");
      out.write("                        <span class=\"tpl-dropdown-list-fr\">3小时前</span>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"tpl-dropdown-list-bdbc\"><a href=\"#\" class=\"tpl-dropdown-list-fl\"><span class=\"am-icon-btn am-icon-check tpl-dropdown-ico-btn-size tpl-badge-danger\"></span> 移动端，导航条下边距处理</a>\r\n");
      out.write("                        <span class=\"tpl-dropdown-list-fr\">15分钟前</span>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"tpl-dropdown-list-bdbc\"><a href=\"#\" class=\"tpl-dropdown-list-fl\"><span class=\"am-icon-btn am-icon-bell-o tpl-dropdown-ico-btn-size tpl-badge-warning\"></span> 追加统计代码</a>\r\n");
      out.write("                        <span class=\"tpl-dropdown-list-fr\">2天前</span>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"am-dropdown\" data-am-dropdown data-am-dropdown-toggle>\r\n");
      out.write("                <a class=\"am-dropdown-toggle tpl-header-list-link\" href=\"javascript:;\">\r\n");
      out.write("                    <span class=\"am-icon-comment-o\"></span> 消息 <span class=\"am-badge tpl-badge-danger am-round\">9</span></span>\r\n");
      out.write("                </a>\r\n");
      out.write("                <ul class=\"am-dropdown-content tpl-dropdown-content\">\r\n");
      out.write("                    <li class=\"tpl-dropdown-content-external\">\r\n");
      out.write("                        <h3>你有 <span class=\"tpl-color-danger\">9</span> 条新消息</h3><a href=\"###\">全部</a></li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#\" class=\"tpl-dropdown-content-message\">\r\n");
      out.write("                                <span class=\"tpl-dropdown-content-photo\">\r\n");
      out.write("                      <img src=\"assets/img/user02.png\" alt=\"\"> </span>\r\n");
      out.write("                            <span class=\"tpl-dropdown-content-subject\">\r\n");
      out.write("                      <span class=\"tpl-dropdown-content-from\"> 禁言小张 </span>\r\n");
      out.write("                                <span class=\"tpl-dropdown-content-time\">10分钟前 </span>\r\n");
      out.write("                                </span>\r\n");
      out.write("                            <span class=\"tpl-dropdown-content-font\"> Amaze UI 的诞生，依托于 GitHub 及其他技术社区上一些优秀的资源；Amaze UI 的成长，则离不开用户的支持。 </span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <a href=\"#\" class=\"tpl-dropdown-content-message\">\r\n");
      out.write("                                <span class=\"tpl-dropdown-content-photo\">\r\n");
      out.write("                      <img src=\"assets/img/user03.png\" alt=\"\"> </span>\r\n");
      out.write("                            <span class=\"tpl-dropdown-content-subject\">\r\n");
      out.write("                      <span class=\"tpl-dropdown-content-from\"> Steam </span>\r\n");
      out.write("                                <span class=\"tpl-dropdown-content-time\">18分钟前</span>\r\n");
      out.write("                                </span>\r\n");
      out.write("                            <span class=\"tpl-dropdown-content-font\"> 为了能最准确的传达所描述的问题， 建议你在反馈时附上演示，方便我们理解。 </span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"am-dropdown\" data-am-dropdown data-am-dropdown-toggle>\r\n");
      out.write("                <a class=\"am-dropdown-toggle tpl-header-list-link\" href=\"javascript:;\">\r\n");
      out.write("                    <span class=\"am-icon-calendar\"></span> 进度 <span class=\"am-badge tpl-badge-primary am-round\">4</span></span>\r\n");
      out.write("                </a>\r\n");
      out.write("                <ul class=\"am-dropdown-content tpl-dropdown-content\">\r\n");
      out.write("                    <li class=\"tpl-dropdown-content-external\">\r\n");
      out.write("                        <h3>你有 <span class=\"tpl-color-primary\">4</span> 个任务进度</h3><a href=\"###\">全部</a></li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"javascript:;\" class=\"tpl-dropdown-content-progress\">\r\n");
      out.write("                                <span class=\"task\">\r\n");
      out.write("                        <span class=\"desc\">Amaze UI 用户中心 v1.2 </span>\r\n");
      out.write("                                <span class=\"percent\">45%</span>\r\n");
      out.write("                                </span>\r\n");
      out.write("                            <span class=\"progress\">\r\n");
      out.write("                        <div class=\"am-progress tpl-progress am-progress-striped\"><div class=\"am-progress-bar am-progress-bar-success\" style=\"width:45%\"></div></div>\r\n");
      out.write("                    </span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"javascript:;\" class=\"tpl-dropdown-content-progress\">\r\n");
      out.write("                                <span class=\"task\">\r\n");
      out.write("                        <span class=\"desc\">新闻内容页 </span>\r\n");
      out.write("                                <span class=\"percent\">30%</span>\r\n");
      out.write("                                </span>\r\n");
      out.write("                            <span class=\"progress\">\r\n");
      out.write("                       <div class=\"am-progress tpl-progress am-progress-striped\"><div class=\"am-progress-bar am-progress-bar-secondary\" style=\"width:30%\"></div></div>\r\n");
      out.write("                    </span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"javascript:;\" class=\"tpl-dropdown-content-progress\">\r\n");
      out.write("                                <span class=\"task\">\r\n");
      out.write("                        <span class=\"desc\">管理中心 </span>\r\n");
      out.write("                                <span class=\"percent\">60%</span>\r\n");
      out.write("                                </span>\r\n");
      out.write("                            <span class=\"progress\">\r\n");
      out.write("                        <div class=\"am-progress tpl-progress am-progress-striped\"><div class=\"am-progress-bar am-progress-bar-warning\" style=\"width:60%\"></div></div>\r\n");
      out.write("                    </span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"am-hide-sm-only\"><a href=\"javascript:;\" id=\"admin-fullscreen\" class=\"tpl-header-list-link\"><span class=\"am-icon-arrows-alt\"></span> <span class=\"admin-fullText\">开启全屏</span></a></li>\r\n");
      out.write("\r\n");
      out.write("            <li class=\"am-dropdown\" data-am-dropdown data-am-dropdown-toggle>\r\n");
      out.write("                <a class=\"am-dropdown-toggle tpl-header-list-link\" href=\"javascript:;\">\r\n");
      out.write("                    <span class=\"tpl-header-list-user-nick\" id=\"user-name-field\">IDEAL</span><span class=\"tpl-header-list-user-ico\"> <img src=\"assets/img/user01.png\"></span>\r\n");
      out.write("                </a>\r\n");
      out.write("                <ul class=\"am-dropdown-content\">\r\n");
      out.write("                    <li><a href=\"#\"><span class=\"am-icon-bell-o\"></span> 资料</a></li>\r\n");
      out.write("                    <li><a href=\"#\"><span class=\"am-icon-cog\"></span> 设置</a></li>\r\n");
      out.write("                    <li><a href=\"#\"><span class=\"am-icon-power-off\"></span> 退出</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li><a href=\"###\" class=\"tpl-header-list-link\"><span class=\"am-icon-sign-out tpl-header-list-ico-out-size\"></span></a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("<script src=\"assets/js/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"assets/js/jquery.cookie.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    $(document).ready(function () {\r\n");
      out.write("        var _ticket = $.cookie(\"IDEAL_TOKEN\");\r\n");
      out.write("        if(!_ticket){\r\n");
      out.write("            return ;\r\n");
      out.write("        }\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            url : \"http://localhost:8088/sso/productor/token/\" + _ticket,\r\n");
      out.write("            dataType : \"jsonp\",\r\n");
      out.write("            type : \"GET\",\r\n");
      out.write("            success : function(data){\r\n");
      out.write("                if(data.status == 200){\r\n");
      out.write("                    var result = JSON.stringify(data); //json对象转成字符串\r\n");
      out.write("                    console.log(data)\r\n");
      out.write("                    $(\"#user-name-field\").text(data.data.username);\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("</script>");
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