<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="sidebar-nav" class="sidebar">
    <div class="sidebar-scroll">
        <nav>
            <ul class="nav">
                <li><a href="index.html" class="active"><i class="lnr lnr-home"></i> <span>主页</span></a></li>
                <li>
                    <a href="#commodity-manager" data-toggle="collapse" class="collapsed"><i class="lnr lnr-star"></i> <span>商品信息管理</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                    <div id="commodity-manager" class="collapse ">
                        <ul class="nav">
                            <li><a href="add-commodity.html" class="">商品添加</a></li>
                            <li><a href="manage-spu.html" class="">商品管理</a></li>
                        </ul>
                    </div>
                </li>
                <li>
                    <a href="#merchant-manager" data-toggle="collapse" class="collapsed"><i class="lnr lnr-cloud-download"></i> <span>代理商信息管理</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                    <div id="merchant-manager" class="collapse ">
                        <ul class="nav">
                            <li><a href="manage-merchant-apply.html" class="">代理商审核</a></li>
                            <li><a href="manage-merchant.html" class="">代理商信息管理</a></li>
                            <li><a href="manage-spu.html" class="">代理商-商品管理</a></li>
                        </ul>
                    </div>
                </li>
                <li><a href="icons.html" class=""><i class="lnr lnr-linearicons"></i> <span>Icons</span></a></li>
            </ul>
        </nav>
    </div>
</div>