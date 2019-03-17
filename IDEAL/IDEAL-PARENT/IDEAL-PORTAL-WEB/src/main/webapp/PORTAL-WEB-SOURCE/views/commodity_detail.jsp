<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>小米MIX 3 - 小米商城</title>
    <link rel="shortcut icon" href="//s01.mifile.cn/favicon.ico" type="image/x-icon"/>
    <link rel="icon" href="//s01.mifile.cn/favicon.ico" type="image/x-icon"/>
    <link rel="search" title="mi.com" href="//s1.mi.com/search.xml?v1.0" type="application/opensearchdescription+xml"/>
    <meta http-equiv="Cache-Control" content="no-transform "/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" href="//s01.mifile.cn/css/base.min.css?v20190118011a">
    <link rel="stylesheet" type="text/css" href="//s01.mifile.cn/css/product/mix3/index.min.css?dc7596"/>
    <link rel="stylesheet" type="text/css" href="//s01.mifile.cn/css/buy/product_buy.min.css?v=2019021901"/>
    <script type="text/javascript" src="assets/vendor/jquery/jquery.js"></script>

</head>
<body>
<div class="site-topbar">
    <div class="container">
        <div class="topbar-nav">
            <a rel="nofollow" href="//www.mi.com/index.html">小米商城</a><span class="sep">|</span>
            <a rel="nofollow" href="https://www.miui.com/" target="_blank">MIUI</a><span class="sep">|</span>
            <a rel="nofollow" href="https://iot.mi.com/index.html">IoT</a><span class="sep">|</span>
            <a rel="nofollow" href="https://i.mi.com/" target="_blank">云服务</a><span class="sep">|</span>
            <a rel="nofollow" href="https://jr.mi.com?from=micom" target="_blank">金融</a><span class="sep">|</span>
            <a rel="nofollow" href="https://youpin.mi.com/" target="_blank">有品</a><span class="sep">|</span>
            <a rel="nofollow" href="https://xiaoai.mi.com/" target="_blank">小爱开放平台</a><span class="sep">|</span>
            <a rel="nofollow" href="https://b.mi.com/?client_id=180100031058&masid=17409.0358"
               target="_blank">政企服务</a><span class="sep">|</span>
            <a rel="nofollow" href="https://www.mi.com/aptitude/list/?id=41" target="_blank">资质证照</a><span
                class="sep">|</span>
            <a rel="nofollow" href="https://www.mi.com/aptitude/list/" target="_blank">协议规则</a><span
                class="sep">|</span>
            <a rel="nofollow" href="//www.mi.com/appdownload/" target="_blank" id="J_downloadapp">下载app</a><span
                class="sep">|</span>
            <a rel="nofollow" href="#J_modal-globalSites" data-toggle="modal">Select Region</a>
        </div>
        <div class="topbar-cart" id="J_miniCartTrigger">
            <a rel="nofollow" class="cart-mini" id="J_miniCartBtn" href="/cart.html"><i class="iconfont">&#xe60c;</i>购物车<span
                    class="cart-mini-num J_cartNum"></span></a>
            <div class="cart-menu" id="J_miniCartMenu">
                <div class="loading">
                    <div class="loader"></div>
                </div>
            </div>
        </div>
        <div class="topbar-info" id="J_userInfo">
            <a rel="nofollow" class="link" href="//order.mi.com/site/login" data-agreement="true"
               data-login="true">登录</a>
            <span class="sep">|</span>
            <a rel="nofollow" class="link" href="https://account.xiaomi.com/pass/register" data-agreement="true"
               data-register="true">注册</a>
        </div>
    </div>
</div>
<div class="site-header">
    <div class="container">
        <div class="header-logo">
            <a class="logo ir" href="//www.mi.com/index.html" title="小米官网">小米官网</a>
        </div>
        <div class="headezr-nav">
            <ul class="nav-list J_navMainList clearfix">
                <li id="J_navCategory" class="nav-category">
                    <a class="link-category" href="//list.mi.com"><span class="text">全部商品分类</span></a>
                </li>
                <li class="nav-item">
                    <a class="link" href="javascript: void(0);"><span class="text">小米手机</span><span
                            class="arrow"></span></a>
                </li>
                <li class="nav-item">
                    <a class="link" href="javascript: void(0);"><span class="text">红米</span><span class="arrow"></span></a>
                </li>
                <li class="nav-item">
                    <a class="link" href="javascript: void(0);"><span class="text">电视</span><span class="arrow"></span></a>
                </li>
                <li class="nav-item">
                    <a class="link" href="javascript: void(0);"><span class="text">笔记本</span><span class="arrow"></span></a>
                </li>
                <li class="nav-item">
                    <a class="link" href="javascript: void(0);"><span class="text">家电</span><span class="arrow"></span></a>
                </li>
                <li class="nav-item">
                    <a class="link" href="https://www.mi.com/p/2848.html"><span class="text">新品</span><span
                            class="arrow"></span></a>
                </li>
                <li class="nav-item">
                    <a class="link" href="javascript: void(0);"><span class="text">路由器</span><span class="arrow"></span></a>
                </li>
                <li class="nav-item">
                    <a class="link" href="javascript:void(0);"><span class="text">智能硬件</span><span class="arrow"></span></a>
                </li>
                <li class="nav-item">
                    <a class="link" href="//www.mi.com/service/" target="_blank"><span class="text">服务</span></a>
                </li>
                <li class="nav-item">
                    <a class="link" href="http://www.xiaomi.cn/" target="_blank"><span class="text">社区</span></a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div id="J_proHeader">
    <div class="xm-product-box">
        <div class="nav-bar" id="J_headNav">
            <div class="container J_navSwitch">
                <h2 class="J_proName">${commodity.spu.title}</h2>
                <div class="con">
                    <div class="right">
                        <a href="//www.mi.com/mix3/">概述</a>
                        <span class="separator">|</span>
                        <a href="//www.mi.com/mix3/specs/">参数</a>
                        <span class="separator">|</span>
                        <a href="//www.mi.com/mix3/gallery/">图集</a>
                        <span class="separator">|</span>
                        <a href="//order.mi.com/queue/f2code" target="_blank">F码通道</a>
                        <span class="separator">|</span>
                        <a href="//item.mi.com/comment/10000123.html">用户评价</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="xm-buyBox" id="J_buyBox">
    <div class="box clearfix">
        <div class="login-notic J_notic" style="display: none;">
            <!-- 未登录提示 -->
            <div class="container">
                为方便您购买，请提前登录 <a href="javascript:void(0);" class="J_proLogin" data-stat-id="ff18180e96c5ba2e"
                                onclick="_msq.push(['trackEvent', 'ae2a5d804d0902c3-ff18180e96c5ba2e', 'javascript:void0', 'pcpid', '']);"
                                data-href="//order.mi.com/site/login?redirectUrl=https://item.mi.com/product/10000123.html">立即登录</a>
                <a href="javascript:void(0);" class="iconfont J_proLoginClose"></a>
            </div>
        </div>
        <div class="pro-choose-main container clearfix" id="image-height">
            <div class="pro-view span10">
                <!-- 左侧轮播图 -->
                <div class="J_imgload imgload hide"></div>
                <div id="J_img" class="img-con">
                    <div class="ui-wrapper" style="max-width: 100%;">
                        <div class="ui-viewport"
                             style="width: 100%; overflow: hidden; position: relative; height: 560px;">
                            <div id="J_sliderView" class="sliderWrap" style="width: auto; position: relative;"><img
                                    data-src="${spes.sku.image}" class="slider done"
                                    src="${spes.sku.image}"
                                    style="float: none; list-style: none; position: absolute; width: 560px; z-index: 50; display: block;">
                            </div>
                        </div>
                        <div class="ui-controls ui-has-pager ui-has-controls-direction" style="display: none;">
                            <div class="ui-pager ui-default-pager">
                                <div class="ui-pager-item"><a href="" data-slide-index="0" class="ui-pager-link active">1</a>
                                </div>
                            </div>
                            <div class="ui-controls-direction"><a class="ui-prev disabled" href="">上一张</a><a
                                    class="ui-next disabled" href="">下一张</a></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="pro-info span10">
                <h1 class="pro-title J_proName">
                    <span class="img"></span>
                    <span class="name">${commodity.spu.title}</span>
                </h1>
                <!-- 提示 -->
                <p class="sale-desc" id="J_desc">${commodity.spu.sellpoint}</p>
                <div class="loading J_load hide">
                    <div class="loader"></div>
                </div>
                <!-- 主体 -->
                <div class="J_main">
                    <!-- 经营主题 -->
                    <p class="aftersale-company" id="J_aftersaleCompany" type="1" desc="null">小米自营</p>
                    <!-- 价格 -->
                    <div class="pro-price J_proPrice">
                        <span class="price">${spes.sku.price / 100} </span>
                        <span class="seckill-notic hide"></span>
                    </div>

                    <!-- 分仓地址 -->
                    <div class="J_addressWrap address-wrap">
                        <div class="user-default-address" id="J_userDefaultAddress"><i
                                class="iconfont iconfont-location"></i>
                            <div>
                                <div class="address-info"><span class="item">四川</span><span class="item">成都市</span><span
                                        class="item">锦江区</span><span class="item">成龙路街道</span></div>
                                <span class="switch-choose-regions" id="J_switchChooseRegions"> 修改 </span></div>
                            <div class="product-status soldout" id="J_productStatus"><span class="init">正在加载...</span>
                            </div>
                        </div>
                    </div>
                    <!-- 产品版本 -->
                    <div class="list-wrap" id="J_list">
                        <c:forEach items="${spes.data}" var="t" varStatus="status">
                            <div class="pro-choose pro-choose-col2 J_step">
                                <div class="step-title"> 选择${t.key}</div>
                                <ul class="step-list clearfix" data-index="${status.index}" data-value="">
                                    <c:forEach items="${t.value}" var="i">
                                        <li class="btn btn-biglarge" data-id="${i.id}" data-index="${status.index}"
                                            data-value="${i.value}">
                                            <a href="javascript:void(0);" class="step-name"> ${i.value} </a>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:forEach>
                        <div class="pro-choose list-choose list-choose-small J_service" data-index="0"
                             data-multi="false">
                            <div class="step-title"> 选择小米提供的延长保修 <a
                                    href="https://api.jr.mi.com/activity/accidentIns/?from=mishop&amp;insuranceSku=22609"
                                    target="_blank">了解延长保修 &gt;</a>
                            </div>
                            <ul>
                                <li class="clearfix" data-oriprice="129.00" data-price="129.00" data-name="小米Mix 3故宫版延保"
                                    data-bargain_id="2185000005" data-id="2185000005" data-source="common"><i
                                        class="iconfont icon-checkbox"><em>√</em></i> <img
                                        src="//i1.mifile.cn/a1/pms_1544513381.75098027.jpg?width=50&amp;height=50">
                                    <div><span class="name"> 小米Mix 3故宫版延保   </span>
                                        <p class="desc">小米Mix 3故宫版延保</p>
                                        <p class="agreement"><i class="iconfont icon-checkbox J_read"><em>√</em></i>
                                            我已阅读
                                            <a href="https://api.jr.mi.com/insurance/document/phone_accidentIns.html?insuranceSku=22609&amp;couponFrom=rule"
                                               target="_blank">服务条款<span>|</span></a> <a
                                                    href="https://api.jr.mi.com/insurance/document/phone_accidentIns.html?insuranceSku=22609&amp;couponFrom=question"
                                                    target="_blank">常见问题</a></p>  <span class="price">  129元  </span>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="pro-choose list-choose list-choose-small J_service" data-index="1"
                             data-multi="false">
                            <div class="step-title"> 选择小米提供的意外保护 <a
                                    href="https://api.jr.mi.com/activity/accidentIns/?from=mishop&amp;insuranceSku=22607"
                                    target="_blank">了解意外保护 &gt;</a></div>
                            <ul>
                                <li class="clearfix" data-oriprice="399.00" data-price="399.00" data-name="意外保障服务"
                                    data-bargain_id="2185000003" data-id="2185000003" data-source="common"><i
                                        class="iconfont icon-checkbox"><em>√</em></i> <img
                                        src="//i1.mifile.cn/a1/pms_1544513128.60258716.jpg?width=50&amp;height=50">
                                    <div><span class="name"> 意外保障服务   </span>
                                        <p class="desc">小米MIX3故宫版 意外保障服务</p>
                                        <p class="agreement">
                                            <i class="iconfont icon-checkbox J_read"><em>√</em></i>
                                            我已阅读
                                            <a href="https://api.jr.mi.com/insurance/document/phone_accidentIns.html?insuranceSku=22607&amp;couponFrom=rule"
                                               target="_blank">服务条款<span>|</span></a>
                                            <a href="https://api.jr.mi.com/insurance/document/phone_accidentIns.html?insuranceSku=22607&amp;couponFrom=question"
                                               target="_blank">常见问题</a>
                                        </p>
                                        <span class="price">  399元  </span>
                                    </div>
                                </li>
                                <li class="clearfix" data-oriprice="199.00" data-price="199.00" data-name="碎屏保障服务"
                                    data-bargain_id="2185000004" data-id="2185000004" data-source="common"><i
                                        class="iconfont icon-checkbox"><em>√</em></i> <img
                                        src="//i1.mifile.cn/a1/pms_1544513237.11031355.jpg?width=50&amp;height=50">
                                    <div>
                                        <span class="name"> 碎屏保障服务   </span>
                                        <p class="desc">小米MIX3故宫版 碎屏保障服务</p>
                                        <p class="agreement"><i class="iconfont icon-checkbox J_read"><em>√</em></i>
                                            我已阅读
                                            <a href="https://api.jr.mi.com/insurance/document/phone_accidentIns.html?insuranceSku=22608&amp;couponFrom=rule"
                                               target="_blank">服务条款<span>|</span></a> <a
                                                    href="https://api.jr.mi.com/insurance/document/phone_accidentIns.html?insuranceSku=22608&amp;couponFrom=question"
                                                    target="_blank">常见问题</a>
                                        </p>
                                        <span class="price">  199元  </span>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div id="J_relation"></div>
                    <!-- 已选择的产品 -->
                    <div class="pro-list" id="J_proList">
                        <ul>
                            <li id="commodity_name"></li>
                            <li class="totlePrice" data-name="bigtap"> 总计 ：${spes.sku.price / 100}元</li>
                        </ul>
                    </div>
                    <!-- 购买按钮 -->
                    <ul class="btn-wrap clearfix" id="J_buyBtnBox">
                        <li><a data-sign="disabled" data-type="bigtap" data-tip="" class="btn btn-biglarge btn-primary"
                               href="javascript:void(0);" data-isbigtap="true" data-name="加入购物车" onclick="addToCart()">加入购物车</a>
                        </li>
                        <li><a class="btn-gray btn-like btn-biglarge">立即购买 </a></li>
                    </ul>


                    <div class="pro-policy" id="J_policy">
                        <a href="javascript:void(0);" title=""> <span class="support">  <i class="iconfont"></i>  <em>小米自营</em> </span>
                        </a>
                        <a href="javascript:void(0);" title="由小米发货"> <span class="support">  <i class="iconfont"></i>  <em>小米发货</em> </span>
                        </a>
                        <a href="javascript:void(0);" title=""><span class="support">  <i class="iconfont"></i>  <em>7天无理由退货</em> </span>
                        </a>
                        <a href="javascript:void(0);"
                           title="由小米发货的商品，单笔满150元免运费;由第三方商家发货的商品，免运费;特殊商品需要单独收取运费，具体以实际结算金额为准；优惠券等不能抵扣运费金额;"> <span
                                class="support">  <i class="iconfont"></i>  <em>运费说明</em> </span> </a></div>
                </div>
                <!-- 获取商品失败 -->
                <div class="error hide J_error">
                    <h3>有点小问题，请点击按钮刷新重试</h3>
                    <a href="javascript:void(0)" class="btn btn-primary J_reload" data-stat-id="9b9ab6e736215b75"
                       onclick="_msq.push(['trackEvent', 'ae2a5d804d0902c3-9b9ab6e736215b75', 'javascript:void0', 'pcpid', '']);">刷新</a>
                </div>
            </div>
        </div>
        <!-- 预售流程 -->
        <div class="pro-infomation" id="J_proInfo">
            <div class="pro-book-flow container hide" id="J_bookFlow">
                <span class="book-name">预售流程</span>
                <ul class="clearfix">
                    <li class="item01">
                        <span class="icon icon1"></span>
                        <div>
                            <span class="item-name">1.支付预付款</span>
                            <span class="item-infor"></span>
                        </div>
                    </li>
                    <li class="item02">
                        <span class="icon icon2"></span>
                        <div>
                            <span class="item-name">2.支付尾款 <em>（在我的订单完成）</em></span>
                            <span class="item-infor"></span>
                        </div>
                    </li>
                    <li class="item03">
                        <span class="icon icon3"></span>
                        <div>
                            <span class="item-name">3.商品发货</span>
                            <span class="item-infor"></span>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="infor-con">
                <div class="section is-visible preload">
                    <div class="container">
                        <h3 style="margin-top: 22px;margin-bottom: 22px;">价格说明 </h3>
                        <div class="con">
                            <img data-src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/a482afa34053b1b32ece1023475af7fb.jpeg"
                                 class="slider done"
                                 src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/a482afa34053b1b32ece1023475af7fb.jpeg">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<div class="site-header">
    <div class="container">
        <div class="header-logo">
            <a class="logo ir" href="//www.mi.com/index.html" title="小米官网">小米官网</a>
        </div>
        <div class="headezr-nav">
            <ul class="nav-list J_navMainList clearfix">
                <li id="J_navCategory" class="nav-category">
                    <a class="link-category" href="//list.mi.com"><span class="text">全部商品分类</span></a>
                </li>
                <li class="nav-item">
                    <a class="link" href="javascript: void(0);"><span class="text">小米手机</span><span
                            class="arrow"></span></a>
                </li>
                <li class="nav-item">
                    <a class="link" href="javascript: void(0);"><span class="text">红米</span><span class="arrow"></span></a>
                </li>
                <li class="nav-item">
                    <a class="link" href="javascript: void(0);"><span class="text">电视</span><span class="arrow"></span></a>
                </li>
                <li class="nav-item">
                    <a class="link" href="javascript: void(0);"><span class="text">笔记本</span><span class="arrow"></span></a>
                </li>
                <li class="nav-item">
                    <a class="link" href="javascript: void(0);"><span class="text">家电</span><span class="arrow"></span></a>
                </li>
                <li class="nav-item">
                    <a class="link" href="https://www.mi.com/p/2848.html"><span class="text">新品</span><span
                            class="arrow"></span></a>
                </li>
                <li class="nav-item">
                    <a class="link" href="javascript: void(0);"><span class="text">路由器</span><span class="arrow"></span></a>
                </li>
                <li class="nav-item">
                    <a class="link" href="javascript:void(0);"><span class="text">智能硬件</span><span class="arrow"></span></a>
                </li>
                <li class="nav-item">
                    <a class="link" href="//www.mi.com/service/" target="_blank"><span class="text">服务</span></a>
                </li>
                <li class="nav-item">
                    <a class="link" href="http://www.xiaomi.cn/" target="_blank"><span class="text">社区</span></a>
                </li>
            </ul>
        </div>
        <div class="header-search">
            <form id="J_searchForm" class="search-form clearfix" action="//search.mi.com/search" method="get">
                <label for="search" class="hide">站内搜索</label>
                <input class="search-text" type="search" id="search" name="keyword" autocomplete="off"
                       data-search-config="{'defaultWords':[{'Key':'小米6X','Rst':6},{'Key':'小米MIX&nbsp;2S','Rst':5},{'Key':'黑鲨游戏手机','Rst':3},{'Key':'红米Note&nbsp;5','Rst':6},{'Key':'红米5A','Rst':13},{'Key':'小米电视4C','Rst':5},{'Key':'电视32英寸','Rst':3},{'Key':'笔记本pro','Rst':5},{'Key':'空气净化器','Rst':11},{'Key':'净水器','Rst':8}]}"/>
                <input type="submit" class="search-btn iconfont" value="&#xe616;"/>
                <div class="search-hot-words">
                    <a href="https://www.mi.com/mi9/">小米9</a><a href="https://www.mi.com/mi9se/">小米9 SE</a>
                </div>
            </form>
        </div>
    </div>
</div>
<!--</div>-->
<script type="text/javascript">

    $(function () {
        initSpeDisplay();
    });

    function initSpeDisplay() {
        var spev = JSON.parse("${spes.default_data}");
        var name_group = $("li[data-index]");
        for (var j = 0; j < name_group.length; j++) {
            if (spev.indexOf($(name_group[j]).data("id")) != -1) {
                $(name_group[j]).attr("class", "btn btn-biglarge active");
                $(name_group[j]).parent().data("value", $(name_group[j]).data("value"))
            }
            else {
                $(name_group[j]).attr("class", "btn btn-biglarge");
            }
        }
        var html_str = "${commodity.spu.title}&nbsp&nbsp&nbsp&nbsp";
        var ul_group = $("ul[data-value]");
        for (var i = 0; i < ul_group.length; i++) {
            html_str += $(ul_group[i]).data("value") + "&nbsp&nbsp&nbsp&nbsp"
        }
        $("#commodity_name").html(html_str + "<span>                 ${spes.sku.price / 100} 元 </span>");
    }

    $("li[data-index]").click(function () {
        $(this).parent().data("value", $(this).data("value").toString());
        var name_group = $("li[data-index=" + $(this).data("index") + "]");
        for (var i = 0; i < name_group.length; i++) {
            if ($(name_group[i]).data("id") == $(this).data("id")) {
                $(name_group[i]).attr("class", "btn btn-biglarge active");
            }
            else {
                $(name_group[i]).attr("class", "btn btn-biglarge");
            }
        }

        var ul_group = $(".btn.btn-biglarge.active");
        var spevs = "";
        for (var i = 0; i < ul_group.length; i++) {
            spevs += $(ul_group[i]).data("id") + ",";
        }
        window.location.href = window.location.href.split("?")[0] + "?spuid=" + getQueryString("spuid") + "&spevs=" + spevs;
    });
    $("li[data-bargain_id]").click(function () {
        var insurance = $("li[data-bargain_id]");
        var i = 0;
        for (i = 0; i < insurance.length; i++) {
            if ($(this).attr("data-bargain_id") == $(insurance[i]).attr("data-bargain_id")) {
                if ($(this).attr("class") == "clearfix")
                    $(this).attr("class", "clearfix active");
                else
                    $(this).attr("class", "clearfix");
            }
            else {
                $(insurance[i]).attr("class", "clearfix");
            }
        }//end for
    })
    $(window).scroll(function () {
        var scrollerHeight = $(this).scrollTop();
        if (scrollerHeight >= 0 && scrollerHeight <= 100) {
            $(".img-con").attr("class", "img-con");
            $(".img-con").css({});
        }
        else if (scrollerHeight > 100 && scrollerHeight < 1000) {
            $(".img-con").attr("class", "img-con fix");
            $(".img-con").css({
                "left": "147.6px",
                "margin-top": "0px",
            });
        }
        else if (scrollerHeight > 1000 && scrollerHeight < $("#image-height").height()) {
            $(".img-con").attr("class", "img-con");
            $(".img-con").css({
                "left": "147.6px",
                "margin-top": "700px",
            });
        }
    });

    function addToCart() {
        var data = {
            id: getQueryString("spuid"),
            title: '${commodity.spu.title}',
            price: '${spes.sku.price }',
            image: '${spes.sku.image}'
        };
        $.post("cart/getCommodityForCart/cartManager", data, function (result) {
            if (result.data == 500) {
                //商品已存在
                toastr.info("商品已存在购物车");
            }
        });

    }

    function getQueryString(name) {
        var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
        var r = window.location.search.substr(1).match(reg);
        if (r != null) {
            return unescape(r[2]);
        }
        return null;
    }
</script>

