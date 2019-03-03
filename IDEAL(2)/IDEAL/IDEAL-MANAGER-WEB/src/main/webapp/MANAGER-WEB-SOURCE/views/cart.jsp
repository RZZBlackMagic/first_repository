<%--
  Created by IntelliJ IDEA.
  User: 任章哲
  Date: 2019/2/20
  Time: 15:57
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
    <script type="text/javascript" src="assets/js/jquery-1.11.0.js" ></script>
    <!--导入bootstrap.js-->
    <script type="text/javascript" src="assets/js/bootstrap.min.js" ></script>

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
                    <div class="col col-check"><button class="iconfont icon-checkbox  J_itemCheckbox" id="J_selectAll" onclick="selectAll()"></button>全选</div>
                    <div class="col col-img">&nbsp;</div>
                    <div class="col col-name">商品名称</div>
                    <div class="col col-price">单价</div>
                    <div class="col col-num">数量</div>
                    <div class="col col-total">小计</div>
                    <div class="col col-action">操作</div>
                </div>
                <div class="list-body" id="J_cartListBody">
                </div>
            </div>
            <!--中间空格区域-->
            <div class="raise-buy-box" id="J_raiseBuyBox"> </div>
            <!--结算模块-->
            <div class="cart-bar clearfix" id="J_cartBar">
                <div class="section-left">
                    <a href="//list.mi.com/0" class="back-shopping J_goShoping" data-stat-id="b16361b4c5491b6d" onclick="_msq.push(['trackEvent', '5df97b551662ffe7-b16361b4c5491b6d', '#', 'pcpid', '']);">继续购物</a>
                    <span class="cart-total">共 <i id="J_cartTotalNum">0</i> 件商品，已选择 <i id="J_selTotalNum">0</i> 件</span>
                    <span class="cart-coudan hide" id="J_coudanTip">
		                                                ，还需 <i id="J_postFreeBalance">51.00</i> 元即可免邮费  <a href="javascript:void(0);" id="J_showCoudan" data-stat-id="cfc8337d6cbfdef7" onclick="_msq.push(['trackEvent', '5df97b551662ffe7-cfc8337d6cbfdef7', 'javascript:void0', 'pcpid', '']);">立即凑单</a>
		                    </span>
                </div>
                <span class="activity-money hide">
		                                        活动优惠：减 <i id="J_cartActivityMoney">0</i> 元
		                </span>
                <span class="total-price">
		                                        合计：<em id="J_cartTotalPrice">0</em>元
		                </span>
                <a  class="btn btn-a btn btn-primary" id="J_goCheckout" data-stat-id="9bd56b7232f4ef1a" onclick="goToPay()">去结算</a>

                <div class="no-select-tip hide" id="J_noSelectTip">
                    请勾选需要结算的商品
                    <i class="arrow arrow-a"></i>
                    <i class="arrow arrow-b"></i>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(function(){
    });
    var resultNum;
    console.log(1);
    //首页添加商品到购物车中时，将商品列表信息存到cookie中，本页面展示商品就从cookie中拿
    var url = "cart/getCartList/cartManager.do";
    var data  = {};
    $.getJSON(url,data,function(result){
        resultNum = result.data.length;
        console.log(result);
        for(var i=0;i<result.data.length;i++){
            var ID = result.data[i].id;
            var TITLE = result.data[i].title;
            var PIC = result.data[i].pic;
            var PRICE = result.data[i].price;
            var NUM = result.data[i].num;
            var ALLPRICE = NUM*PRICE;
            $('#item_table').data("allprice",ALLPRICE);
            var row = t.replace('[TITLE]',TITLE).replace('[NUM]',NUM).replace('PRICE',PRICE).replace('[PIC]',PIC).replace(['ALLPRICE'],ALLPRICE).replace("ID",ID).replace("ALLPRICE1",ALLPRICE).replace("PRICE1",PRICE);
            var row = $(row);
            $('#J_cartListBody').append(row);
            $('#item_table').data('id',ID);
            $('#J_cartTotalNum').text(result.data.length);
            //$('#J_cartListBody').find('button[value="√"]').click(selectCom);//选中商品事件
        }

        $('#J_cartListBody').find('button[value="√"]').click(selectCom);//选中商品事件
        $('#J_cartListBody').find('a[class="J_plus"]').find('img').click(add);//商品个数加一事件
        $('#J_cartListBody').find('a[class="J_minus"]').find('img').click(sub);//商品个数减一事件
        $('.col-action').click(remove);//商品移除事件

    });


    var t = '<div class="item-box" id="ID">'+
        ' <div class="item-table J_cartGoods" id="item_table" data-info="">'+
        '<div class="item-row clearfix">'+
        '         <div class="col col-check">'+
        '             <button  class="iconfont icon-checkbox  J_itemCheckbox" value="√"></button>'+
        ' </div>'+
        '<div class="col col-img">'+
        '<a href="//item.mi.com/1161200012.html" target="_blank" data-stat-id="b3fe5630e5ece9ed" onclick="_msq.push(['+"'"+'trackEvent'+"'"+", "+"'"+'5df97b551662ffe7-b3fe5630e5ece9ed'+"'"+', '+"'"+"//item.mi.com/1161200012.html"+"'"+', '+"'"+"pcpid"+"'"+", "+"''"+"]);"+'"'+'>'+
        '   <img alt="" src="[PIC]" width="80" height="80">'+
        '</a>'+
        '</div>'+
        '<div class="col col-name">'+
        '    <div class="tags"></div>'+
        '    <div class="tags"></div>'+
        '   <h3 class="name">'+
        '  <a href="//item.mi.com/1161200012.html" target="_blank" data-stat-id="23537ce6324466fd" onclick="_msq.push(['+"'trackEvent', '5df97b551662ffe7-23537ce6324466fd', '//item.mi.com/1161200012.html', 'pcpid', '']);"+'"'+'>[TITLE]</a>'+
        '</h3>'+
        ' </div>'+
        '<div class="col col-price" data-info="PRICE"> PRICE1元</div> '+
        '<div class="col col-num">'+
        ' <div class="change-goods-num clearfix J_changeGoodsNum">'+
        '   <a href="#" class="J_minus" >'+
        '   <!--<i class="fa fa-minus"></i>-->'+
        '   <img src="assets/img/sub.png" class="iconfont" style="padding-top: 5px;"/>'+
        '</a>'+
        '<input tyep="text"  name="number" value="[NUM]" data-num="4" data-buylimit="5" autocomplete="off" class="goods-num J_goodsNum" "="">'+
        '<a href="#" class="J_plus" >'+
        ' <!--<i class="fa fa-plus"></i>-->'+
        '<img src="assets/img/add.png" class="iconfont"/>'+
        '</a>'+
        '<div class="msg J_canBuyLimit">还可买 1 件</div>'+
        '</div>'+
        ' </div>'+
        '<div class="col col-total" data-info="ALLPRICE"> ALLPRICE1元 <p class="pre-info">  </p> </div>'+
        '<div class="col col-action">'+
        ' <a id="2161200012_0_buy" data-msg="确定删除吗？" href="javascript:void(0);" title="删除" class="del J_delGoods" data-stat-id="163da9c724cdbb9f" >'+
        ' <i class="fa fa-remove"></i>'+
        '         </a>'+
        '         </div>'+
        '    </div>'+
        '</div>'+
        '</div>';


    function add(){
        //实现加一
        //console.log("加一");
        var num = $(this).parent().parent().find('input[class="goods-num J_goodsNum"]').val();
        num = eval(num) +1;
        $(this).parent().parent().find('input[class="goods-num J_goodsNum"]').val(num);
        //改变当前商品小计
        var price = $(this).parent().parent().parent().parent().children('div').eq(3).attr('data-info');
        var allPrice = num*eval(price);
        $(this).parent().parent().parent().next().attr('data-info',allPrice);
        $(this).parent().parent().parent().next().text(allPrice+'元');
        //改变购物车总费用
        addPrice();
    }
    function sub(){
        //实现减一
        var num = $(this).parent().parent().find('input[class="goods-num J_goodsNum"]').val();
        if(eval(num)==0){
            console.log("还他妈点");
        }else{
            num = eval(num) -1 ;
            $(this).parent().parent().find('input[class="goods-num J_goodsNum"]').val(num);
        }
        //改变当前商品小计
        var price = $(this).parent().parent().parent().parent().children('div').eq(3).attr('data-info');
        var allPrice = num*eval(price);
        $(this).parent().parent().parent().next().attr('data-info',allPrice);
        $(this).parent().parent().parent().next().text(allPrice+'元');
        //console.log("allPrice"+allPrice);
        //改变购物车总费用
        addPrice();
    }
    function selectCom(){
        //console.log("选择商品");
        var HTML = $(this).html();
        console.log(HTML);
        if($(this).hasClass("icon-checkbox-selected")){
            $(this).removeClass("icon-checkbox-selected");
            $('#J_selectAll').removeClass("icon-checkbox-selected");
            $('#J_selTotalNum').text(eval(selectedNum)-1);
            addPrice();
        }else{
            $(this).addClass("icon-checkbox-selected");
            addPrice();
        }
    }
    function selectAll(){
        console.log('全选');
        if($('#J_selectAll').hasClass("icon-checkbox-selected")){
            console.log("去掉");
            $('#J_selectAll').removeClass("icon-checkbox-selected");
            for(var i=0;i<resultNum;i++){
                //取消全选，下面的商品全部取消选中状态
                $('#J_cartListBody').children('div').eq(i).find('button').removeClass("icon-checkbox-selected");
                //console.log(r);
            }
            $('#J_selTotalNum').text(0);
            addPrice();
        }else{
            console.log("选中");
            $('#J_selectAll').addClass("icon-checkbox-selected");
            for(var i=0;i<resultNum;i++){
                $('#J_cartListBody').children('div').eq(i).find('button[class="iconfont icon-checkbox  J_itemCheckbox"]').addClass("icon-checkbox-selected");
            }
            addPrice();
        }


    }
    function addPrice(){
        //console.log(resultNum);
        var total = 0;//目前总价格
        var flag = 0;//选中个数
        for(var i=0;i<resultNum;i++){
            var price = $('#J_cartListBody').children('div').eq(i).find('button[class="iconfont icon-checkbox  J_itemCheckbox icon-checkbox-selected"]').parent().parent().parent().find('div[class="col col-total"]').attr("data-info");
            if(price!=null){
                total = total +eval(price);
                flag = flag +1;
                $('#J_selTotalNum').text(flag);

                //console.log("price:"+total);
            }
        }
        $('#J_cartTotalPrice').text(total);
    }
    function remove(){
        console.log("删除商品");
        var id = $(this).parents('div[class="item-box"]').attr('id');
        console.log(id);
        //根据id去cookie删除商品
        var url = "cart/deleteComFromCookie/cartManager.do";
        var data = {id:id};
        $.post(url,data,function(result){
            console.log(result);
            window.location.reload();
        });
    }
    function goToPay() {
        var allPrice = $('#J_cartTotalPrice').text();
        console.log(allPrice);
        if(eval(allPrice)==0){
            console.log("您还没有选中商品");
        }else {
            console.log("去结算");
        }
        var ID = "";//id字符串
        var NUMBER = "";
        for(var i =0;i<resultNum;i++){
            console.log("单个ID："+$('#J_cartListBody').children('div').eq(i).attr('id'));
            var num = $('#J_cartListBody').children('div').eq(i).find('button[value="√"]').parents().next().next().next().next().children('div').children('input').attr('value');
            if($('#J_cartListBody').children('div').eq(i).find('button[value="√"]').hasClass("icon-checkbox-selected")){
                ID = ID + $('#J_cartListBody').children('div').eq(i).attr('id')+",";
                NUMBER = NUMBER + num + ',';
            }
        }
        console.log("id字符串："+ID);
        console.log("个数字符串："+NUMBER);
        window.location.href = "http://localhost:8081/order.html?idList="+ID+'&numList='+NUMBER;
    }
</script>
</body>
</html>

