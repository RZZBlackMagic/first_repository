<%--
  Created by IntelliJ IDEA.
  User: 任章哲
  Date: 2019/2/20
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <!--导入 css-->
    <!--<link rel="stylesheet" href="css/bootstrap.min.css" />-->

    <link rel="shortcut icon" href="//s01.mifile.cn/favicon.ico" type="image/x-icon">
    <link rel="icon" href="//s01.mifile.cn/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="//s01.mifile.cn/css/base.min.css?v20190118011a">
    <link rel="stylesheet" type="text/css" href="//s01.mifile.cn/css/cart.min.css?ec0079">

    <!--导入font-awesome-->
    <link rel="stylesheet" href="assets/css/font-awesome.min.css"/>
    <!--导入jquery.js-->
    <script type="text/javascript" href="assets/js/jquery-1.11.0.js" ></script>
    <!--导入bootstrap.js-->
    <script type="text/javascript" href="assets/js/bootstrap.min.js" ></script>

</head>
<body>
<div class="site-header site-mini-header">
    <div class="container">
        <div class="header-logo">
            <a  href="#" style="width:100px"><img src="assets/img/logo_top.png" style="width: 50px;height: 50px;"></a>
        </div>
        <div class="header-title has-more" id="J_minHeaderTitle" style="width: 491px;">
            <h2 style="margin-top: 0px;">我的购物车</h2>
            <p>温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</p>
        </div>
        <div class="topbar-info" id="J_userInfo">
	   				<span class="user">
	   					<!--rel不要跟踪默认连接-->
	   					<a rel="nofollow" class="user-name" href="#" target="_blank">
	   						<span class="name" tabindex="0" hidefocus="true" onfocus="focus()" onblur="focusclose()">about you</span>
	   						<i class="fa fa-angle-down fa-fw " aria-hidden="true"></i>
	   					</a>
	   					<ul class="user-menu" style="display: none;">
			   				<li>
			   					<a rel="nofollow" href="#" target="_blank">个人中心</a>
			   				</li>
			   				<li>
			   					<a rel="nofollow" href="#" target="_blank">评价晒单</a>
			   				</li>
			   				<li>
			   					<a rel="nofollow" href="#" target="_blank">我的喜欢</a>
			   				</li>
			   				<li>
			   					<a rel="nofollow" href="#" target="_blank">小米账户</a>
			   				</li>
			   				<li>
			   					<a rel="nofollow" href="#" target="_blank">退出登录</a>
			   				</li>
			   			</ul>
	   				</span>
            <span class="sep"> | </span>
            <a rel="nofollow" class="link link-order" href="#" target="_blank">我的订单</a>
        </div>
    </div>
</div>
<div class="page-main">
    <div class="container">
        <div id="J_cartBox" class="">
            <div class="cart-goods-list">
                <div class="list-head clearfix">
                    <div class="col col-check"><i class="iconfont icon-checkbox" id="J_selectAll">√</i>全选</div>
                    <div class="col col-img">&nbsp;</div>
                    <div class="col col-name">商品名称</div>
                    <div class="col col-price">单价</div>
                    <div class="col col-num">数量</div>
                    <div class="col col-total">小计</div>
                    <div class="col col-action">操作</div>
                </div>
                <div class="list-body" id="J_cartListBody">
                    <div class="item-box">
                        <div class="item-table J_cartGoods" data-info="{ commodity_id:'1161200012', gettype:'buy', itemid:'2161200012_0_buy', num:'4'} ">
                            <div class="item-row clearfix">
                                <div class="col col-check">
                                    <i class="iconfont icon-checkbox icon-checkbox  J_itemCheckbox" data-itemid="2161200012_0_buy" data-status="0">√</i>
                                </div>
                                <div class="col col-img">
                                    <a href="//item.mi.com/1161200012.html" target="_blank" data-stat-id="b3fe5630e5ece9ed" onclick="_msq.push(['trackEvent', '5df97b551662ffe7-b3fe5630e5ece9ed', '//item.mi.com/1161200012.html', 'pcpid', '']);">
                                        <img alt="" src="//i1.mifile.cn/a1/pms_1510291188.31088548!80x80.jpg" width="80" height="80">
                                    </a>
                                </div>
                                <div class="col col-name">
                                    <div class="tags"></div>
                                    <div class="tags"></div>
                                    <h3 class="name">
                                        <a href="//item.mi.com/1161200012.html" target="_blank" data-stat-id="23537ce6324466fd" onclick="_msq.push(['trackEvent', '5df97b551662ffe7-23537ce6324466fd', '//item.mi.com/1161200012.html', 'pcpid', '']);"> 小米USB充电器（4口） 白色 </a>
                                    </h3>
                                </div>
                                <div class="col col-price"> 59元 </div>
                                <div class="col col-num">
                                    <div class="change-goods-num clearfix J_changeGoodsNum">
                                        <a href="#" class="J_minus" onclick="sub()">
                                            <!--<i class="fa fa-minus"></i>-->
                                            <img href="assets/img/sub.png" class="iconfont" style="padding-top: 5px;"/>
                                        </a>
                                        <input tyep="text" name="2161200012_0_buy" value="1" data-num="4" data-buylimit="5" autocomplete="off" class="goods-num J_goodsNum" "="">
                                        <a href="#" class="J_plus">
                                            <!--<i class="fa fa-plus"></i>-->
                                            <img href="assets/img/add.png" class="iconfont"/>
                                        </a>
                                        <div class="msg J_canBuyLimit">还可买 1 件</div>
                                    </div>
                                </div>
                                <div class="col col-total"> 236元 <p class="pre-info">  </p> </div>
                                <div class="col col-action">
                                    <a id="2161200012_0_buy" data-msg="确定删除吗？" href="javascript:void(0);" title="删除" class="del J_delGoods" data-stat-id="163da9c724cdbb9f" onclick="_msq.push(['trackEvent', '5df97b551662ffe7-163da9c724cdbb9f', 'javascript:void0', 'pcpid', '']);">
                                        <i class="fa fa-remove"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--中间空格区域-->
            <div class="raise-buy-box" id="J_raiseBuyBox"> </div>
            <!--结算模块-->
            <div class="cart-bar clearfix" id="J_cartBar">
                <div class="section-left">
                    <a href="//list.mi.com/0" class="back-shopping J_goShoping" data-stat-id="b16361b4c5491b6d" onclick="_msq.push(['trackEvent', '5df97b551662ffe7-b16361b4c5491b6d', '#', 'pcpid', '']);">继续购物</a>
                    <span class="cart-total">共 <i id="J_cartTotalNum">2</i> 件商品，已选择 <i id="J_selTotalNum">2</i> 件</span>
                    <span class="cart-coudan hide" id="J_coudanTip">
		                                                ，还需 <i id="J_postFreeBalance">51.00</i> 元即可免邮费  <a href="javascript:void(0);" id="J_showCoudan" data-stat-id="cfc8337d6cbfdef7" onclick="_msq.push(['trackEvent', '5df97b551662ffe7-cfc8337d6cbfdef7', 'javascript:void0', 'pcpid', '']);">立即凑单</a>
		                    </span>
                </div>
                <span class="activity-money hide">
		                                        活动优惠：减 <i id="J_cartActivityMoney">0</i> 元
		                </span>
                <span class="total-price">
		                                        合计：<em id="J_cartTotalPrice">99</em>元
		                </span>
                <a href="javascript:void(0);" class="btn btn-a btn btn-primary" id="J_goCheckout" data-stat-id="9bd56b7232f4ef1a" onclick="_msq.push(['trackEvent', '5df97b551662ffe7-9bd56b7232f4ef1a', 'javascript:void0', 'pcpid', '']);">去结算</a>

                <div class="no-select-tip hide" id="J_noSelectTip">
                    请勾选需要结算的商品
                    <i class="arrow arrow-a"></i>
                    <i class="arrow arrow-b"></i>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

