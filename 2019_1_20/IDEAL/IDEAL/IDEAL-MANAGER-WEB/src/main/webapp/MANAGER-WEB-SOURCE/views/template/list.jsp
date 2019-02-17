<%--
  Created by IntelliJ IDEA.
  User: 任章哲
  Date: 2019/1/21
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="sidebar-nav" class="sidebar">
    <div class="sidebar-scroll">
        <nav>
            <ul class="nav">
                <li><a href="commodity_category.html" onclick="addClass()" class=""><i class="lnr lnr-code"></i> <span>商品分类管理</span></a></li>
                <li><a href="content_category.html" onclick="addClass()" class=""><i class="lnr lnr-chart-bars"></i> <span>网站首页内容</span></a></li>
                <li>
                    <a href="#subPages" data-toggle="collapse" onclick="addClass()" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>生产商注册管理</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                    <div id="subPages" class="collapse ">
                        <ul class="nav">
                            <li><a href="productor_regist.html"  onclick="addClass()" class="">注册审批</a></li>
                            <li><a href="productor_lock.html" onclick="addClass()" class="">违章生产商处理</a></li>
                            <li><a href="productor_unlock.html" onclick="addClass()" class="">解除</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </nav>
    </div>
</div>
