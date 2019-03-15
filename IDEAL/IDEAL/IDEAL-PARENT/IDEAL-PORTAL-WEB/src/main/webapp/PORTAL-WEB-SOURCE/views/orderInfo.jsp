<%--
  Created by IntelliJ IDEA.
  User: 任章哲
  Date: 2019/3/6
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>选择在线支付方式</title>
    <link rel="shortcut icon" href="//s01.mifile.cn/favicon.ico" type="image/x-icon">
    <link rel="icon" href="//s01.mifile.cn/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="//s01.mifile.cn/css/base.min.css?v2019022501a">
    <link rel="stylesheet" type="text/css" href="//s01.mifile.cn/css/pay-confirm.min.css?v=2016081101">
    <script type="text/javascript" src="assets/vendor/jquery/jquery.js" ></script>
</head>
<body>
<div class="site-header site-mini-header">
    <div class="container">
        <div class="header-logo">
            <a class="logo " href="//www.mi.com/index.html" title="小米官网" data-stat-id="ea54c9fed6a874d7" onclick="_msq.push(['trackEvent', 'f1542ececd0b6bc5-ea54c9fed6a874d7', '//www.mi.com/index.html', 'pcpid', '']);"></a>
        </div>
        <div class="header-title" id="J_miniHeaderTitle"><h2>支付订单</h2></div>
        <div class="topbar-info" id="J_userInfo"><span class="user"><a rel="nofollow" class="user-name" href="//my.mi.com/portal" target="_blank"><span class="name">about you</span><i class="iconfont"></i></a><ul class="user-menu"><li><a rel="nofollow" href="//my.mi.com/portal" target="_blank">个人中心</a></li><li><a rel="nofollow" href="https://order.mi.com/user/comment" target="_blank">评价晒单</a></li><li><a rel="nofollow" href="https://order.mi.com/user/favorite" target="_blank">我的喜欢</a></li><li><a rel="nofollow" href="//account.xiaomi.com/" target="_blank">小米账户</a></li><li><a rel="nofollow" href="https://order.mi.com/site/logout">退出登录</a></li></ul></span><span class="sep">|</span><a rel="nofollow" class="link link-order" href="//static.mi.com/order/" target="_blank">我的订单</a></div>
    </div>
</div>
<div class="page-main">
    <div class="container confirm-box">
        <form target="_blank" action="#" id="J_payForm" method="post">
            <div class="section section-order">
                <div class="order-info clearfix">
                    <div class="fl">
                        <h2 class="title">付款成功～</h2>
                        <p class="order-time" id="J_deliverDesc"></p>
                        <p class="order-time">请在<span class="pay-time-tip">48小时0分</span>内完成支付, 超时后将取消订单</p>
                        <p class="post-info" id="J_postInfo">
                                                     </p>
                    </div>
                    <div class="fr">
                        <p class="total">
                            应付总额：<span class="money"><em></em>元</span>
                        </p>
                        <a href="javascript:void(0);" class="show-detail" id="J_showDetail" data-stat-id="db85b2885a2fdc53" >订单详情<i class="iconfont"></i></a>
                    </div>
                </div>
                <i class="iconfont icon-right">√</i>
                <div class="order-detail" style="display: none;">
                    <ul id="order-detail-ul">
                        <li class="clearfix">
                            <div class="label">订单号：</div>
                            <div class="content">
		                                <span class="order-num">
		                                                                  </span>
                            </div>
                        </li>
                        <li class="clearfix">
                            <div class="label">收货信息：</div>
                            <div class="content">
                                                            </div>
                        </li>
                        <li class="clearfix">
                            <div class="label">商品名称：</div>
                            <div class="content">
                                                            </div>
                        </li>
                        <li class="clearfix hide">
                            <div class="label">配送时间：</div>
                            <div class="content">
                                不限送货时间                            </div>
                        </li>
                        <li class="clearfix">
                            <div class="label">发票信息：</div>
                            <div class="content">
                                电子发票 个人                            </div>
                        </li>
                    </ul>
                </div>
            </div>


            <div class="section section-payment">
                <div class="cash-title" id="J_cashTitle">
                    选择以下支付方式付款
                </div>

                <div class="payment-box ">
                    <div class="payment-header clearfix">
                        <h3 class="title">支付平台</h3>
                        <span class="desc"></span>
                    </div>
                    <div class="payment-body">
                        <ul class="clearfix payment-list J_paymentList J_linksign-customize">
                            <li id="J_weixin" data-stat-id="4971b7cf6ccf0faf" onclick="_msq.push(['trackEvent', 'f1542ececd0b6bc5-4971b7cf6ccf0faf', '', 'pcpid', '']);"><img src="//c1.mifile.cn/f/i/16/pay/weixinpay.png" alt="微信支付" style="margin-left: 0;"></li><li class="J_bank" data-stat-id="4971b7cf6ccf0faf" onclick="_msq.push(['trackEvent', 'f1542ececd0b6bc5-4971b7cf6ccf0faf', '', 'pcpid', '']);"><input type="radio" name="payOnlineBank" id="alipay" value="alipay"> <img src="//s01.mifile.cn/i/banklogo/payOnline_zfb.png?ver2015" alt="支付宝" style="margin-left: 0;"></li><li class="J_bank" data-stat-id="4971b7cf6ccf0faf" onclick="_msq.push(['trackEvent', 'f1542ececd0b6bc5-4971b7cf6ccf0faf', '', 'pcpid', '']);"><input type="radio" name="payOnlineBank" id="unionpay" value="unionpay"> <img src="//s01.mifile.cn/i/banklogo/unionpay.png?ver2015" alt="银联" style="margin-left: 0;"></li><li class="J_bank" data-stat-id="4971b7cf6ccf0faf" onclick="_msq.push(['trackEvent', 'f1542ececd0b6bc5-4971b7cf6ccf0faf', '', 'pcpid', '']);"><input type="radio" name="payOnlineBank" id="micash" value="micash"> <img src="//s01.mifile.cn/i/banklogo/micash.png?ver2015" alt="小米钱包" style="margin-left: 0;"></li>                        </ul>
                        <div class="event-desc">
                            <p>小米分期：新用户开通满50减40元</p>                            <a href="//www.mi.com/c/payrule/" class="more" target="_blank" data-stat-id="307ecac152e748b9" onclick="_msq.push(['trackEvent', 'f1542ececd0b6bc5-307ecac152e748b9', '//www.mi.com/c/payrule/', 'pcpid', '']);">了解更多&gt;</a>
                        </div>
                    </div>
                </div>

                <div class="payment-box ">
                    <div class="payment-header clearfix">
                        <h3 class="title">银行借记卡及信用卡</h3>
                    </div>
                    <div class="payment-body">
                        <ul class="clearfix payment-list J_paymentList J_linksign-customize" id="bankCart">
                            <li class="J_bank" data-stat-id="3e7f807e5319a275" ><input type="radio" name="pd_FrpId" id="CMB" value="CMBCHINA-NET-B2C"> <img src="//s01.mifile.cn/i/banklogo/payOnline_zsyh.png?ver2015" alt=""></li>
                            <li class="J_bank" data-stat-id="3e7f807e5319a275" ><input type="radio" name="pd_FrpId" id="ICBCB2C" value="ICBC-NET-B2C"> <img src="//s01.mifile.cn/i/banklogo/payOnline_gsyh.png?ver2015" alt=""></li>
                            <li class="J_bank" data-stat-id="3e7f807e5319a275" ><input type="radio" name="pd_FrpId" id="CCB" value="CCB-NET-B2C"> <img src="//s01.mifile.cn/i/banklogo/payOnline_jsyh.png?ver2015" alt=""></li>
                            <li class="J_bank" data-stat-id="3e7f807e5319a275" ><input type="radio" name="pd_FrpId" id="COMM" value="BOCO-NET-B2C"> <img src="//s01.mifile.cn/i/banklogo/payOnline_jtyh.png?ver2015" alt=""></li>
                            <li class="J_bank" data-stat-id="3e7f807e5319a275" ><input type="radio" name="pd_FrpId" id="ABC" value="ABC-NET-B2C"> <img src="//s01.mifile.cn/i/banklogo/payOnline_nyyh.png?ver2015" alt=""></li>
                            <li class="J_bank" data-stat-id="3e7f807e5319a275" ><input type="radio" name="pd_FrpId" id="BOCB2C" value="BOC-NET-B2C"> <img src="//s01.mifile.cn/i/banklogo/payOnline_zgyh.png?ver2015" alt=""></li>
                            <li class="J_bank" data-stat-id="3e7f807e5319a275" ><input type="radio" name="pd_FrpId" id="PSBC-DEBIT" value="POST-NET-B2C"> <img src="//s01.mifile.cn/i/banklogo/payOnline_youzheng.png?ver2015" alt=""></li>

<%--
                            <li class="J_bank" data-stat-id="3e7f807e5319a275" ><input type="radio" name="pd_FrpId" id="GDB" value="GDB"> <img src="//s01.mifile.cn/i/banklogo/payOnline_gfyh.png?ver2015" alt=""></li>
--%>


                            <li class="J_bank" data-stat-id="3e7f807e5319a275" ><input type="radio" name="pd_FrpId" id="SPDB" value="SPDB-NET-B2C "> <img src="//s01.mifile.cn/i/banklogo/payOnline_pufa.png?ver2015" alt=""></li>

                            <li class="J_bank" data-stat-id="3e7f807e5319a275" ><input type="radio" name="pd_FrpId" id="CEBBANK" value="CEB-NET-B2C"> <img src="//s01.mifile.cn/i/banklogo/payOnline_gdyh.png?ver2015" alt=""></li>
                            <li class="J_bank" data-stat-id="3e7f807e5319a275" ><input type="radio" name="pd_FrpId" id="CIB" value="CIB-NET-B2C "> <img src="//s01.mifile.cn/i/banklogo/payOnline_xyyh.png?ver2015" alt=""></li>
<%--
                            <li class="J_bank " data-stat-id="3e7f807e5319a275" ><input type="radio" name="payOnlineBank" id="CMBC" value="CMBC"> <img src="//s01.mifile.cn/i/banklogo/payOnline_msyh.png?ver2015" alt=""></li>
--%>
                            <li class="J_bank " data-stat-id="3e7f807e5319a275" ><input type="radio" name="pd_FrpId" id="SHBANK" value="SHB-NET-B2C "> <img src="//s01.mifile.cn/i/banklogo/payOnline_shyh.png?ver2015" alt=""></li>
                            <li class="J_bank " data-stat-id="3e7f807e5319a275" ><input type="radio" name="pd_FrpId" id="BJRCB" value="BJRCB-NET-B2C "> <img src="//s01.mifile.cn/i/banklogo/payOnline_bjnsyh.png?ver2015" alt=""></li>
                            <li class="J_bank " data-stat-id="3e7f807e5319a275" ><input type="radio" name="pd_FrpId" id="NBBANK" value="NBCB-NET-B2C "> <img src="//s01.mifile.cn/i/banklogo/payOnline_nbyh.png?ver2015" alt=""></li>
<%--
                            <li class="J_bank " data-stat-id="3e7f807e5319a275" ><input type="radio" name="pd_FrpId" id="HZCBB2C" value="HZCBB2C"> <img src="//s01.mifile.cn/i/banklogo/payOnline_hzyh.png?ver2015" alt=""></li>
--%>
<%--
                            <li class="J_bank " data-stat-id="3e7f807e5319a275" ><input type="radio" name="pd_FrpId" id="SHRCB" value="SHRCB"> <img src="//s01.mifile.cn/i/banklogo/payOnline_shnsyh.png?ver2015" alt=""></li>
--%>
<%--
                            <li class="J_bank " data-stat-id="3e7f807e5319a275" ><input type="radio" name="pd_FrpId" id="FDB" value="FDB"> <img src="//s01.mifile.cn/i/banklogo/payOnline_fcyh.png?ver2015" alt=""></li>
--%>
                            <%--<li class="J_showMore" data-stat-id="1a75d155ddfb7ea6" onclick="_msq.push(['trackEvent', 'f1542ececd0b6bc5-1a75d155ddfb7ea6', '', 'pcpid', '']);">
                            &lt;%&ndash;<span class="text">查看更多</span>
                            <span class="text  hide">收起更多</span>&ndash;%&gt;
                        </li>--%>
                        </ul>
                    </div>
                </div>
                <div class="section-bar clearfix">
                    <div class="fl">
                        <div class="seleced-address hide" id="J_confirmAddress">
                        </div>
                        <div class="big-pro-tip hide J_confirmBigProTip"></div>
                    </div>
                    <div class="fr" >
                        <a href="javascript:void(0);"  class="btn btn-primary" id="J_checkoutToPay" data-stat-id="9dc0c7cf32a1c0ca" >去结算</a>
                    </div>
                </div>

                <div class="payment-box payment-box-last ">
                    <div class="payment-header clearfix">
                        <h3 class="title">快捷支付</h3>
                        <span class="desc">（支持以下各银行信用卡以及部分银行借记卡）</span>
                    </div>
                    <div class="payment-body">
                        <ul class="clearfix payment-list  J_paymentList J_linksign-customize">
                            <li class="J_bank" data-stat-id="beebcefe84431b57" onclick="_msq.push(['trackEvent', 'f1542ececd0b6bc5-beebcefe84431b57', '', 'pcpid', '']);"><input type="radio" name="payOnlineBank" id="CMB-KQ" value="CMB-KQ"> <img src="//s01.mifile.cn/i/banklogo/payOnline_zsyh.png?ver2015" alt=""></li><li class="J_bank" data-stat-id="beebcefe84431b57" onclick="_msq.push(['trackEvent', 'f1542ececd0b6bc5-beebcefe84431b57', '', 'pcpid', '']);"><input type="radio" name="payOnlineBank" id="COMM-KQ" value="COMM-KQ"> <img src="//s01.mifile.cn/i/banklogo/payOnline_jtyh.png?ver2015" alt=""></li><li class="J_bank" data-stat-id="beebcefe84431b57" onclick="_msq.push(['trackEvent', 'f1542ececd0b6bc5-beebcefe84431b57', '', 'pcpid', '']);"><input type="radio" name="payOnlineBank" id="CCB-KQ" value="CCB-KQ"> <img src="//s01.mifile.cn/i/banklogo/payOnline_jsyh.png?ver2015" alt=""></li><li class="J_bank" data-stat-id="beebcefe84431b57" onclick="_msq.push(['trackEvent', 'f1542ececd0b6bc5-beebcefe84431b57', '', 'pcpid', '']);"><input type="radio" name="payOnlineBank" id="ICBCB2C-KQ" value="ICBCB2C-KQ"> <img src="//s01.mifile.cn/i/banklogo/payOnline_gsyh.png?ver2015" alt=""></li><li class="J_bank" data-stat-id="beebcefe84431b57" onclick="_msq.push(['trackEvent', 'f1542ececd0b6bc5-beebcefe84431b57', '', 'pcpid', '']);"><input type="radio" name="payOnlineBank" id="CITIC-KQ" value="CITIC-KQ"> <img src="//s01.mifile.cn/i/banklogo/payOnline_zxyh.png?ver2015" alt=""></li><li class="J_bank" data-stat-id="beebcefe84431b57" onclick="_msq.push(['trackEvent', 'f1542ececd0b6bc5-beebcefe84431b57', '', 'pcpid', '']);"><input type="radio" name="payOnlineBank" id="CEBBANK-KQ" value="CEBBANK-KQ"> <img src="//s01.mifile.cn/i/banklogo/payOnline_gdyh.png?ver2015" alt=""></li><li class="J_bank" data-stat-id="beebcefe84431b57" onclick="_msq.push(['trackEvent', 'f1542ececd0b6bc5-beebcefe84431b57', '', 'pcpid', '']);"><input type="radio" name="payOnlineBank" id="BOCB2C-KQ" value="BOCB2C-KQ"> <img src="//s01.mifile.cn/i/banklogo/payOnline_zgyh.png?ver2015" alt=""></li><li class="J_bank" data-stat-id="beebcefe84431b57" onclick="_msq.push(['trackEvent', 'f1542ececd0b6bc5-beebcefe84431b57', '', 'pcpid', '']);"><input type="radio" name="payOnlineBank" id="SRCB-KQ" value="SRCB-KQ"> <img src="//s01.mifile.cn/i/banklogo/payOnline_shncsyyh.png?ver2015" alt=""></li><li class="J_bank" data-stat-id="beebcefe84431b57" onclick="_msq.push(['trackEvent', 'f1542ececd0b6bc5-beebcefe84431b57', '', 'pcpid', '']);"><input type="radio" name="payOnlineBank" id="JSB-KQ" value="JSB-KQ"> <img src="//s01.mifile.cn/i/banklogo/payOnline_jiangsshuyh.png?ver2015" alt=""></li><li class="J_bank" data-stat-id="beebcefe84431b57" onclick="_msq.push(['trackEvent', 'f1542ececd0b6bc5-beebcefe84431b57', '', 'pcpid', '']);"><input type="radio" name="payOnlineBank" id="CIB-KQ" value="CIB-KQ"> <img src="//s01.mifile.cn/i/banklogo/payOnline_xyyh.png?ver2015" alt=""></li><li class="J_bank" data-stat-id="beebcefe84431b57" onclick="_msq.push(['trackEvent', 'f1542ececd0b6bc5-beebcefe84431b57', '', 'pcpid', '']);"><input type="radio" name="payOnlineBank" id="ABC-KQ" value="ABC-KQ"> <img src="//s01.mifile.cn/i/banklogo/payOnline_nyyh.png?ver2015" alt=""></li><li class="J_bank" data-stat-id="beebcefe84431b57" onclick="_msq.push(['trackEvent', 'f1542ececd0b6bc5-beebcefe84431b57', '', 'pcpid', '']);"><input type="radio" name="payOnlineBank" id="SPABANK-KQ" value="SPABANK-KQ"> <img src="//s01.mifile.cn/i/banklogo/payOnline_payh.png?ver2015" alt=""></li><li class="J_bank" data-stat-id="beebcefe84431b57" onclick="_msq.push(['trackEvent', 'f1542ececd0b6bc5-beebcefe84431b57', '', 'pcpid', '']);"><input type="radio" name="payOnlineBank" id="HXB-KQ" value="HXB-KQ"> <img src="//s01.mifile.cn/i/banklogo/payOnline_hyyh.png?ver2015" alt=""></li><li class="J_bank" data-stat-id="beebcefe84431b57" onclick="_msq.push(['trackEvent', 'f1542ececd0b6bc5-beebcefe84431b57', '', 'pcpid', '']);"><input type="radio" name="payOnlineBank" id="GDB-KQ" value="GDB-KQ"> <img src="//s01.mifile.cn/i/banklogo/payOnline_gfyh.png?ver2015" alt=""></li><li class="J_bank" data-stat-id="beebcefe84431b57" onclick="_msq.push(['trackEvent', 'f1542ececd0b6bc5-beebcefe84431b57', '', 'pcpid', '']);"><input type="radio" name="payOnlineBank" id="BOB-KQ" value="BOB-KQ"> <img src="//s01.mifile.cn/i/banklogo/payOnline_bjyh.png?ver2015" alt=""></li>                        </ul>
                    </div>
                </div>
            </div>
            <div class="section section-installment" id="J_paymentFenqi">
                <div class="payment-box">
                    <div class="payment-header clearfix">
                        <h3 class="title">分期付款</h3>
                        <span class="desc"></span>
                    </div>
                    <div class="payment-body">
                        <ul class="clearfix payment-list J_paymentList J_linksign-customize J_tabSwitch">
                            <li class="J_bank fenqi" data-isinstalment="true" data-stat-id="9c74efccaa92537a" onclick="_msq.push(['trackEvent', 'f1542ececd0b6bc5-9c74efccaa92537a', '', 'pcpid', '']);"><input autocomplete="off" type="radio" name="payOnlineBank" id="mifinanceinstal" value="mifinanceinstal"> <img src="//c1.mifile.cn/f/i/15/pay/mifinanceinstal.png" alt="分期-小米金融	"></li>                        </ul>
                        <div class="tab-container clearfix isinstalment-box">
                            <div class="tab-content  clearfix">
                                <div class="isinstalment-item  clearfix" style="height:150px;">
                                    <div class="item-header">
                                        <h3>79元 × 1期</h3>
                                        <p>
                                            <span style="color: #ff6700">免息，无手续费</span>
                                        </p>
                                    </div>
                                    <br>
                                    <div class="item-footer">
                                        <input type="radio" name="installments" id="installments_cmbinstal_1" value="1">
                                        <a href="javascript:void(0);" data-installid="mifinanceinstal" class="btn J_installmentConfirmBtn" data-stat-id="42a8872dcf10f474" onclick="_msq.push(['trackEvent', 'f1542ececd0b6bc5-42a8872dcf10f474', 'javascript:void0', 'pcpid', '']);">选择该分期方式</a>
                                    </div>
                                </div>

                                <div class="isinstalment-desc">
                                    分期付款说明：<br>
                                    每期还款金额是根据你的订单估算得出的金额，实际支付数额请以小米分期账单为准，小米分期有权决定是否接受您的分期付款申请。
                                </div>
                            </div>
                        </div>
                        <div class="isinstalment-desc" id="J_isinstalmentPublicDesc">
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    $(function(){


        $(".show-detail").click(function(){
            if($(".order-detail").css("display")=="block"){
                $(".order-detail").css("display","none");
            }
            else if($(".order-detail").css("display")=="none"){
                $(".order-detail").css("display","block");
            }
        })

        //得到路径参数
        function getUrlParam() {
            //获取连接地址
            var url = document.location.toString();
            //分隔开连接,用?把传的值取出来
            var arrObj = url.split("?");
            //创建一个空对象
            var result = {};
            //判断连接里面是不是有值,如果有则执行下面操作
            if (arrObj.length > 1) {
                //取出所有传的值
                var arrPara = arrObj[1].split("&");
                var arr;
                for (var i = 0; i < arrPara.length; i++) {

                    arr = arrPara[i].split("=");
                    //把第二个值赋值给第一个值
                    result[arr[0]] = arr[1];

                }
            }
            return result;
        }
        var urlData = getUrlParam();
        var orderId = urlData.orderId;
        var url = "order/getOrderInfo/orderManager.do";
        var data = {
            orderId:orderId
        }
        var params ;

        $.post(url,data,function(result){
            console.log(result);
            params = result.data;
            $('#J_postInfo').html('收货信息：'+ params.name+params.phone+'  &nbsp;&nbsp;\n' +
                params.address+'&nbsp;&nbsp; ');
            $('span[class="order-num"]').text(params.orderId);
            $('span[class="money"]').find('em').text(params.totalFee);
            $('#order-detail-ul').children('li').eq(1).find('div[class="content"]').html(params.address);
            $('#order-detail-ul').children('li').eq(2).find('div[class="content"]').html(params.ComTitle);
        });

        for(var i=0;i<13;i++){
            $('#bankCart').children('li').eq(i).click(addClassForCart);
        }
        function addClassForCart() {
            console.log(2);
            console.log($(this).html())
            if($(this).hasClass('selected')){
                console.log("选中");
                $(this).removeClass('selected');
            }else{
                $('li[class="J_bank selected"]').removeClass('selected');
                $(this).addClass('selected');
                console.log("没选中");
            }
        }
        $('#J_checkoutToPay').click(pay);
        function pay(){
            var pd_FrpId = $('li[class="J_bank selected"]').find('input').attr('value');
            console.log(pd_FrpId);
            var url = "order/payForCommodity/orderManager.do";
            var data= {
                oid:orderId,
                pd_FrpId:pd_FrpId
            };
            $.post(url,data,function (result) {
                console.log(result);
                //window.location.href=result.data;
            });

        }



    })

</script>
</body>
</html>
