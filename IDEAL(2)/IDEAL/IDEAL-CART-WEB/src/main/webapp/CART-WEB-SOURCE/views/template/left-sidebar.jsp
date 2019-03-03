<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="sidebar-nav" class="sidebar">
    <div class="sidebar-scroll">
        <nav>
            <ul class="nav">
                <li><a href="index.html" class="active"><i class="lnr lnr-home"></i> <span>主页</span></a></li>
                <li>
                    <a href="#commodity-content-manager" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>网站内容管理</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                    <div id="commodity-content-manager" class="collapse ">
                        <ul class="nav">
                            <li><a href="content-category.html" class="">网站首页内容管理</a></li>
                        </ul>
                    </div>
                </li>
                <li>
                    <a href="#product-manager" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>PRODUCTOR管理</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                    <div id="product-manager" class="collapse ">
                        <ul class="nav">
                            <li><a href="productor_regist.html" class="">注册信息审核</a></li>
                            <li><a href="productor_lock.html" class="">违章用户处理</a></li>
                            <li><a href="productor_unlock.html" class="">解除被封用户</a></li>
                        </ul>
                    </div>
                </li>
                <li>
                    <a href="#log" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>MER-PRO关联信息</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                    <div id="log" class="collapse ">
                        <ul class="nav">
                            <li><a href="rela_mer_pro.html" class="">代理商-生产商 签约状态</a></li>
                            <li><a href="rela_mer_pro_com.html" class="">代理商-生产商 商品状态</a></li>
                        </ul>
                    </div>
                </li>
                <li><a href="elements.html" class=""><i class="lnr lnr-code"></i> <span>Elements</span></a></li>
            </ul>
        </nav>
    </div>
</div>