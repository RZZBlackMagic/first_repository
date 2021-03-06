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
    <title>填写订单信息</title>
    <link rel="shortcut icon" href="//s01.mifile.cn/favicon.ico" type="image/x-icon">
    <link rel="icon" href="//s01.mifile.cn/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="//s01.mifile.cn/css/base.min.css?v20190118011a">
    <link rel="stylesheet" type="text/css" href="//s01.mifile.cn/css/checkout.min.css?v=2018020602">
    <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
    <script type="text/javascript">
        $(function(){
//				弹出地址填写框
            $("#J_newAddress").click(function(){
                alert("执行了");
                $("#J_modalEditAddress").attr("class","modal modal-hide fade modal-edit-address in");
                $("#J_modalEditAddress").css({
                    "dispaly":"block",
                });
            })
//				点击右上角关闭按钮
            $("modal-header,a").click(function(){
                $("#J_modalEditAddress").attr("class","modal modal-hide fade modal-edit-address");
                $("#J_modalEditAddress").css({
                    "dispaly":"none",
                });
            })
//				点击保存和取消按钮
            $("model-footer").click(function(){
                if($(this).attr("data-state-id")){
                    $("#J_modalEditAddress").attr("class","modal modal-hide fade modal-edit-address");
                    $("#J_modalEditAddress").css({
                        "dispaly":"none",
                    });
                }
            })
            $(".coupon-trigger").click(function(){
                if($("#J_couponBox").attr("class")=="coupon-box hide")
                    $("#J_couponBox").attr("class","coupon-box");
                else
                    $("#J_couponBox").attr("class","coupon-box hide");
            })
            $("#J_useEcard").click(function(){
                if($("#J_ecardBox").attr("class")=="ecard-box hide")
                    $("#J_ecardBox").attr("class","ecard-box");
                else
                    $("#J_ecardBox").attr("class","ecard-box hide");
            })
//				$("body").click(function(){
//					alert("执行了");
//					if($("this").attr("id")=="J_useCoupon"){
//
//					}
//					else{
//						$("#J_couponBox").attr("class","coupon-box hide");
//					}
//
//				})
        })
    </script>
</head>
<body>
<div class="site-header site-mini-header">
    <div class="container">
        <div class="header-logo">
            <a class="logo " href="//www.mi.com/index.html" title="小米官网" data-stat-id="ea54c9fed6a874d7" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-ea54c9fed6a874d7', '//www.mi.com/index.html', 'pcpid', '']);"></a>
        </div>
        <div class="header-title" id="J_miniHeaderTitle"><h2>确认订单</h2></div>
        <div class="topbar-info" id="J_userInfo"><span class="user"><a rel="nofollow" class="user-name" href="//my.mi.com/portal" target="_blank"><span class="name">about you</span><i class="iconfont"></i></a><ul class="user-menu"><li><a rel="nofollow" href="//my.mi.com/portal" target="_blank">个人中心</a></li><li><a rel="nofollow" href="https://order.mi.com/user/comment" target="_blank">评价晒单</a></li><li><a rel="nofollow" href="https://order.mi.com/user/favorite" target="_blank">我的喜欢</a></li><li><a rel="nofollow" href="//account.xiaomi.com/" target="_blank">小米账户</a></li><li><a rel="nofollow" href="https://order.mi.com/site/logout">退出登录</a></li></ul></span><span class="sep">|</span><a rel="nofollow" class="link link-order" href="//static.mi.com/order/" target="_blank">我的订单</a></div>
    </div>
</div>
<div class="page-main">
    <!-- 春节发货公告 -->
    <!-- 春节发货公告 END-->
    <div class="container">
        <div class="checkout-box">
            <div class="section section-address">
                <div class="section-header clearfix">
                    <h3 class="title">收货地址</h3>

                    <div class="more">
                    </div>

                    <div class="mitv-tips hide" style="margin-left: 0;border: none;" id="J_bigproPostTip"></div>


                </div>
                <div class="section-body clearfix" id="J_addressList">
                    <!-- addresslist begin -->
                    <!-- addresslist end -->
                    <div class="address-item J_addressItem  selected" data-address_id="11000000024000900" data-consignee="张晓龙" data-tel="15520798176" data-province_id="24" data-province_name="四川" data-city_id="272" data-city_name="成都市" data-district_id="2552" data-district_name="郫县" data-area="2552013" data-area-name="犀浦镇" data-address="犀安路999号西南交通大学" data-tag_name="">
                        <dl>
                            <dt>
                                <span class="tag"></span>
                                <em class="uname">张晓龙</em>
                            </dt>
                            <dd class="utel">15520798176</dd>
                            <dd class="uaddress"> 四川 成都市 郫县 犀浦镇 <br> 犀安路999号西南交通大学 </dd>
                        </dl>
                        <div class="actions">
                            <a href="javascript:void(0);" class="modify J_addressModify">修改</a>
                        </div>
                    </div>
                    <div class="address-item address-item-new" id="J_newAddress">
                        <i class="iconfont"></i>
                        添加新地址
                    </div>
                </div>
            </div>

            <div class="section section-goods">
                <div class="section-header clearfix">
                    <h3 class="title">商品及优惠券</h3>
                    <div class="more">
                        <a href="//static.mi.com/cart/" data-stat-id="4b8666e26639b521" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-4b8666e26639b521', '//static.mi.com/cart/', 'pcpid', '']);">返回购物车<i class="iconfont"></i></a>
                    </div>
                </div>
                <div class="section-body">
                    <ul class="goods-list" id="J_goodsList">
                        <li class="clearfix">
                            <div class="col col-img">
                                <img src="//i1.mifile.cn/a1/pms_1501236937.96732594!30x30.jpg" width="30" height="30">
                            </div>
                            <div class="col col-name">

                                <a href="//item.mi.com/1173000036.html" target="_blank" data-stat-id="623ad93c5f192c23" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-623ad93c5f192c23', '//item.mi.com/1173000036.html', 'pcpid', '']);">
                                    米粉卡日租卡<em class="label">赠品</em>                                        </a>

                            </div>

                            <div class="col col-price">
                                0元 x 1                                    </div>
                            <div class="col col-status">
                                &nbsp;
                            </div>
                            <div class="col col-total">
                                0元
                            </div>

                        </li>
                        <li class="clearfix">
                            <div class="col col-img">
                                <img src="//i1.mifile.cn/a1/pms_1543562428.18364441!30x30.jpg" width="30" height="30">
                            </div>
                            <div class="col col-name">

                                <a href="//item.mi.com/1184500023.html" target="_blank" data-stat-id="7e07ddec55611fe7" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-7e07ddec55611fe7', '//item.mi.com/1184500023.html', 'pcpid', '']);">
                                    黑鲨游戏手机 Helo 双滑轨保护壳 黑色                                        </a>

                            </div>

                            <div class="col col-price">
                                69元 x 1                                    </div>
                            <div class="col col-status">
                                &nbsp;
                            </div>
                            <div class="col col-total">
                                69元
                            </div>

                        </li>
                        <li class="clearfix">
                            <div class="col col-img">
                                <img src="//i1.mifile.cn/a1/pms_1506679903.87059504!30x30.jpg" width="30" height="30">
                            </div>
                            <div class="col col-name">

                                <a href="//item.mi.com/1173900158.html" target="_blank" data-stat-id="7ba26c794e78ffaa" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-7ba26c794e78ffaa', '//item.mi.com/1173900158.html', 'pcpid', '']);">
                                    米家中性笔专用笔芯 珠光白                                        </a>

                            </div>

                            <div class="col col-price">
                                6.9元 x 1                                    </div>
                            <div class="col col-status">
                                &nbsp;
                            </div>
                            <div class="col col-total">
                                6.9元
                            </div>

                        </li>
                    </ul>
                </div>
            </div>


            <div class="section section-options section-payment clearfix hide">
                <div class="section-header">
                    <h3 class="title">支付方式</h3>
                </div>
                <div class="section-body clearfix">
                    <ul class="J_optionList options ">
                        <li data-type="pay" class="J_option selected" data-value="1">
                            在线支付                            <span>
		                            （支持微信支付、支付宝、银联、财付通、小米钱包等）                            </span>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="section section-options section-shipment clearfix">
                <div class="section-header">
                    <h3 class="title">配送方式</h3>
                </div>
                <div class="section-body clearfix">
                    <ul class="clearfix J_optionList options ">
                        <li data-type="shipment" class="J_option selected" data-amount="10" data-value="2">
                            快递配送（运费 10 元）                                                    </li>
                    </ul>

                    <div class="service-self-tip" id="J_serviceSelfTip" style="display: none;"></div>
                </div>
            </div>

            <div class="section section-options section-time clearfix hide" style="display: block;">
                <div class="section-header">
                    <h3 class="title">配送时间</h3>
                </div>
                <div class="section-body clearfix">
                    <ul class="J_optionList options options-list clearfix">
                        <!-- besttime start -->
                        <li data-type="time" class="J_option selected" data-value="1">
                            不限送货时间：<span>周一至周日</span>                        </li>
                        <li data-type="time" class="J_option " data-value="2">
                            工作日送货：<span>周一至周五</span>                        </li>
                        <li data-type="time" class="J_option " data-value="3">
                            双休日、假日送货：<span>周六至周日</span>                        </li>
                        <!-- besttime end -->
                    </ul>
                </div>
            </div>

            <div class="section section-options section-invoice clearfix">
                <div class="section-header">
                    <h3 class="title">发票</h3>
                </div>
                <div class="section-body clearfix">
                    <div class="invoice-result">
                        <span id="J_invoiceDesc">电子发票</span>
                        <span id="J_invoiceTitle">个人</span>
                        <span>商品明细</span>
                        <a href="#J_modalInvoiceInfo" data-toggle="modal" id="J_invoiceModify" data-stat-id="67efe13c31710c36" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-67efe13c31710c36', '#J_modalInvoiceInfo', 'pcpid', '']);">修改 &gt;</a>
                    </div>
                </div>
            </div>

            <div class="section section-count clearfix">
                <div class="count-actions">
                    <!-- 优惠券 -->
                    <div class="coupon-trigger" id="J_useCoupon">
                        <i class="iconfont icon-plus"></i>使用优惠券
                    </div>
                    <div class="coupon-result hide" id="J_couponResult">
                        <i class="iconfont icon-selected"></i>
                        正在使用：<span class="coupon-title" id="J_couponTitle"></span>
                        <a href="javascript:void(0)" id="J_changeConpon" data-stat-id="73aef02e90ae00b2" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-73aef02e90ae00b2', 'javascript:void0', 'pcpid', '']);">［修改］</a>
                    </div>
                    <div class="coupon-box hide" id="J_couponBox">
                        <ul class="clearfix tab-switch J_tabSwitch">
                            <li>选择优惠券</li>
                            <li>输入优惠券码</li>
                        </ul>
                        <div class="tab-container">
                            <div class="tab-content list-content">
                                <p class="coupon-empty">您暂时没有可用的优惠券</p>
                            </div>
                            <div class="tab-content code-content hide">
                                <div class="form-section">
                                    <label class="input-label" for="coupon_code">请输入优惠券码</label>
                                    <input class="input-text" type="text" id="coupon_code" name="coupon_code">
                                </div>
                                <div class="coupon-confirm">
                                    <a href="javascript:void(0);" class="btn btn-primary" id="J_useCouponCode" data-stat-id="6c554afccd905651" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-6c554afccd905651', 'javascript:void0', 'pcpid', '']);">立即使用</a>
                                    <a href="javascript:void(0);" class="btn btn-gray J_couponCancel" data-stat-id="7afa152eb2616628" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-7afa152eb2616628', 'javascript:void0', 'pcpid', '']);">不使用优惠券</a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- 购物卡 -->
                    <div class="ecard-trigger" id="J_useEcard" data-type="normal"><i class="iconfont icon-plus"></i>使用小米礼品卡</div>
                    <div class="ecard-result hide" id="J_ecardResult">
                        <i class="iconfont icon-selected"></i> 已使用礼品卡 <span id="J_ecardVal"></span>
                        <a href="javascript:void(0);" id="J_ecardModify" data-stat-id="47cd16f8e5331743" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-47cd16f8e5331743', 'javascript:void0', 'pcpid', '']);">［修改］</a>
                    </div>
                    <!-- 现金券 -->
                    <div class="ecard-trigger hide" id="J_useRecycle" data-type="recycle"><i class="iconfont icon-plus"></i>使用现金券</div>
                    <div class="ecard-result hide" id="J_recycleResult">
                        <i class="iconfont icon-selected"></i> 已使用现金券 <span id="J_recycleVal"></span>
                        <a href="javascript:void(0);" id="J_recycleModify" data-stat-id="47cd16f8e5331743" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-47cd16f8e5331743', 'javascript:void0', 'pcpid', '']);">［修改］</a>
                    </div>

                    <div class="ecard-box hide" id="J_ecardBox">
                        <ul class="clearfix tab-switch J_tabSwitch">
                            <li>已绑定的礼品卡</li>
                            <li>输入礼品卡以绑定</li>
                        </ul>
                        <div class="tab-container">
                            <!-- 选卡 -->
                            <div class="tab-content ecard-list">
                                <div class="empty hide" id="J_ecardEmpty">
                                    <p>没有发现可用的礼品卡！</p>
                                    <a href="javascript:void(0);" class="btn btn-gray J_ecardCancel" data-stat-id="19473665e219812c" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-19473665e219812c', 'javascript:void0', 'pcpid', '']);">取消</a>
                                </div>
                                <div class="hide">
                                    <div id="J_ecardList">
                                    </div>
                                    <div class="ecard-info" id="J_ecardInfo"></div>
                                    <div class="btns">
                                        <a href="javascript:void(0);" class="btn btn-primary" id="J_useSelEcard" data-stat-id="467e920a48d3bc3c" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-467e920a48d3bc3c', 'javascript:void0', 'pcpid', '']);">确认以上选择</a>
                                        <a href="javascript:void(0);" class="btn btn-gray J_ecardCancel" data-stat-id="8b51c83ee66ae038" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-8b51c83ee66ae038', 'javascript:void0', 'pcpid', '']);">取消 不使用礼品卡</a>
                                    </div>
                                </div>
                            </div>

                            <!-- 绑卡 -->
                            <div class="tab-content ecard-input hide">
                                <div class="form-section">
                                    <span class="input-title">密码：</span>
                                    <!-- <label class="input-label" for="ecard_password">请输入礼品卡密码</label> -->
                                    <input class="input-text input-card" type="text" id="ecard_password" name="ecard_password" placeholder="请输入礼品卡密码">
                                </div>
                                <div class="form-section clearfix">
                                    <span class="input-title">验证码：</span>
                                    <!-- <label class="input-label" for="ecard_captcha">请输入验证码</label> -->
                                    <input class="input-text input-captcha" type="text" id="ecard_captcha" placeholder="请输入验证码" name="ecard_captcha" data-authurl="//captcha.hd.mi.com/captcha/auth?answer={answer}&amp;service=order.mi.com&amp;_ov=1">
                                    <div class="captcha-img">
                                        <img alt="验证码" title="点击更换验证码" id="J_ecardCaptchaImg">
                                    </div>
                                </div>
                                <div class="form-section form-btns">
                                    <button class="btn btn-primary" id="J_bindEcard">绑定礼品卡</button>
                                    <button class="btn btn-gray J_ecardCancel">取消</button>
                                </div>
                            </div>
                        </div>

                        <div class="recycle-box hide" id="J_recycleBox">
                            <div class="ecard-list recycle-list">
                                <div id="J_recycleList"> <div class="table-wrapper"> <ul class="clearfix"> <li class="col-1">选择</li>  <li class="col-2">券号</li>  <li class="col-3">本次使用（元）</li> <li class="col-4">余额（元）</li>  </ul>  <div>  <table> <tbody>  </tbody> </table> </div> </div></div>
                                <div class="ecard-info" id="J_recycleInfo"></div>
                                <div class="btns">
                                    <a href="javascript:void(0);" class="btn btn-primary" id="J_useSelRecycle" data-stat-id="467e920a48d3bc3c" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-467e920a48d3bc3c', 'javascript:void0', 'pcpid', '']);">确认以上选择</a>
                                    <a href="javascript:void(0);" class="btn btn-gray J_recycleCancel" data-stat-id="2771a3e8b49ad7a2" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-2771a3e8b49ad7a2', 'javascript:void0', 'pcpid', '']);">取消 不使用现金券</a>
                                </div>
                            </div>
                        </div>

                        <div class="sms-box hide" id="J_ecardSmsBox">
                            <div class="title">已向您绑定的手机<span id="J_ecardMobile">（135****6910）</span>发送验证码 <i class="icon-qa" id="J_ecardQa">?</i></div>
                            <div class="form-section clearfix">
                                <label class="input-label" for="ecard_sms">请输入验证码</label>
                                <input class="input-text input-ecard" type="text" id="ecard_sms" name="ecard_sms">
                                <span id="J_smsCountdown" class="countdown hide"><i></i>秒后重新发送</span>
                                <a href="javascript:void(0);" class="repeat hide" id="J_repeatSms" data-stat-id="86ed7b2fd7ca5e28" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-86ed7b2fd7ca5e28', 'javascript:void0', 'pcpid', '']);">重新发送</a>
                            </div>
                            <div class="form-section form-btns">
                                <button class="btn btn-primary" id="J_checkEcardSms">确定</button>
                                <button class="btn btn-gray" id="J_cancelEcardSms">取消</button>
                            </div>
                            <div class="qa-detail hide" id="J_ecardQaDetail">
                                为保证您的资金安全，消费时需通过绑定手机的认证。若您绑定的手机号已变更，可前往小米账号中心修改绑定的手机号，如果原来的手机号已无法使用，可通过申诉的方式更换手机号。<a href="https://account.xiaomi.com/pass/auth/security/home" target="_blank" data-stat-id="0e64fcfb8c3dd045" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-0e64fcfb8c3dd045', 'https://account.xiaomi.com/pass/auth/security/home', 'pcpid', '']);">前往小米账号中心&gt;</a>
                            </div>
                        </div>

                        <div class="loading hide">
                            <div class="loader"></div>
                        </div>
                    </div>

                    <!-- 加价购 -->
                    <div class="raise-buy-box">
                        <ul id="J_raiseBuyList">

                            <!--S 保障计划 产品选择弹框 -->
                            <!--E 保障计划 产品选择弹框 -->
                        </ul>
                    </div>
                </div>

                <div class="money-box" id="J_moneyBox">
                    <ul>
                        <li class="clearfix">
                            <label>商品件数：</label>
                            <span class="val">3件</span>
                        </li>
                        <li class="clearfix">
                            <label>商品总价：</label>
                            <span class="val">75.9元</span>
                        </li>
                        <li class="clearfix">
                            <label>活动优惠：</label>
                            <span class="val">-0元</span>
                        </li>
                        <li class="clearfix">
                            <label>优惠券抵扣：</label>
                            <span class="val"><i id="J_couponVal">-0</i>元</span>
                        </li>
                        <li class="clearfix">
                            <label>运费：</label>
                            <span class="val"><i data-id="J_postageVal">10</i>元</span>
                        </li>
                        <li class="clearfix total-price">
                            <label>应付总额：</label>
                            <span class="val"><em data-id="J_totalPrice">85.9</em>元</span>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="section-bar clearfix">
                <div class="fl">
                    <div class="seleced-address" id="J_confirmAddress">张晓龙 15520798176<br>四川 成都市 郫县 犀安路999号西南交通大学 <a href="javascript:void(0);" class="modify J_modify">修改</a></div>
                    <div class="big-pro-tip J_confirmBigProTip">*米家中性笔专用笔芯 珠光白, 该地区暂时缺货 <a href="https://order.mi.com/misc/subscribe/goods/2173900153" target="_blank">登记到货提醒 &gt;</a></div>
                </div>
                <div class="fr">
                    <a href="javascript:void(0);" class="btn btn-primary" id="J_checkoutToPay" data-stat-id="9dc0c7cf32a1c0ca" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-9dc0c7cf32a1c0ca', 'javascript:void0', 'pcpid', '']);">去结算</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 大家点缺货提示 -->
<div class="big-pro-tip-pop hide" id="J_popBigProTip"></div>
<!-- 禮品卡提示 S-->
<div class="modal fade modal-hide modal-lipin" id="J_lipinTip">
    <div class="modal-header">
        <h3 class="title">温馨提示</h3>
    </div>
    <div class="modal-body">
        <p>
            为保障您的利益与安全，下单后礼品卡将会被使用，<br>
            且订单信息将不可修改。请确认收货信息：
        </p>
        <ul>
            <li class="clearfix">
                <strong>收&nbsp;&nbsp;货&nbsp;&nbsp;人：</strong>
                <span id="J_lipinUserName"></span>
            </li>
            <li class="clearfix">
                <strong>联系电话：</strong>
                <span id="J_lipinUserPhone"></span>
            </li>
            <li class="clearfix">
                <strong>收货地址：</strong>
                <span id="J_lipinUserAddress"></span>
            </li>
        </ul>
    </div>
    <div class="modal-footer">
        <a href="javascript:void(0);" class="btn btn-primary" id="J_lipinSubmit" data-stat-id="7479e4d461606309" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-7479e4d461606309', 'javascript:void0', 'pcpid', '']);">确认下单</a>
        <a href="javascript:void(0);" class="btn btn-gray" data-dismiss="modal" data-stat-id="6e7ff29eb418a43b" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-6e7ff29eb418a43b', 'javascript:void0', 'pcpid', '']);">返回修改</a>
    </div>
</div>
<!--  禮品卡提示 E-->
<div class="modal fade modal-hide fade modal-alert hide" id="J_modalAlert" aria-hidden="true" style="display: none;">
    <div class="modal-bd">
        <div class="text">
            <h3 id="J_alertMsg"></h3>
        </div>
        <div class="actions">
            <button class="btn btn-primary" data-dismiss="modal">确定</button>
        </div>
        <a class="close" data-dismiss="modal" href="javascript: void(0);" data-stat-id="86faab7930e5a48b" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-86faab7930e5a48b', 'javascript:void0', 'pcpid', '']);"><i class="iconfont"></i></a>
    </div>
</div>
<div class="address-top-bar" id="J_addressTopBar">
    <div class="container">
        <a href="javascript:void(0);" class="btn btn-primary" id="J_addressTopBarBtn" data-stat-id="336acd257ed12157" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-336acd257ed12157', 'javascript:void0', 'pcpid', '']);">选择该收货地址</a>
        <div class="content" id="J_addressTopCon">
            <span class="uname">名字</span><span class="utel">名字</span>
        </div>
    </div>
</div>
<div class="modal modal-hide fade modal-edit-address" id="J_modalEditAddress" aria-hidden="false" style="display: block;">
    <div class="modal-header">
        <span class="title">添加收货地址</span>
        <a class="close" data-dismiss="modal" href="javascript: void(0);" data-stat-id="d4b65cafe609c9e2""><i class="iconfont"></i></a>
    </div>
    <div class="modal-body">
        <div class="form-box clearfix">
            <div class="form-section form-name form-section-valid">
                <label class="input-label" for="user_name">姓名</label>
                <input class="input-text J_addressInput" type="text" id="J_addressNameInput" name="user_name" placeholder="收货人姓名">
            </div>
            <div class="form-section form-phone form-section-valid">
                <label class="input-label" for="user_phone">手机号</label>
                <input class="input-text J_addressInput" type="text" id="J_addressPhoneInput" name="user_phone" placeholder="手机号">
            </div>
            <div class="form-section form-four-address form-section-active form-section-valid">
                <input id="J_selectAddressTrigger" class="input-text J_addressInput" type="text" name="four_address" readonly="readonly" value="选择省 / 市 / 区 / 街道" placeholder="选择省 / 市 / 区 / 街道">
                <i class="iconfont"></i>
            </div>
            <div class="form-section form-address-detail form-section-valid">
                <label class="input-label" for="user_adress">详细地址</label>
                <textarea class="input-text J_addressInput" type="text" id="J_addressDetailInput" name="user_adress" placeholder="详细地址，路名或街道名称，门牌号"></textarea>
            </div>
            <div class="form-section form-zipcode form-section-valid">
                <label class="input-label" for="user_zipcode">邮政编码</label>
                <input class="input-text J_addressInput" type="text" id="J_addressZipcodeInput" name="user_zipcode">
            </div>
            <div class="form-section form-tag form-section-valid">
                <label class="input-label" for="user_tag">地址标签</label>
                <input class="input-text J_addressInput" type="text" id="J_addressTagInput" name="user_tag" placeholder="如&quot;家&quot;、&quot;公司&quot;。限5个字内">
            </div>

            <div class="form-section form-tip-msg clearfix" id="J_formTipMsg"></div>
        </div>

        <div class="select-address-wrapper hide" id="J_selectAddressWrapper">
            <span class="select-address-close">x</span>
            <div class="search-address-wrapper J_selectAddressItem" data-type="search" id="J_searchAddressWrapper">
                <div class="search-section">
                    <i class="icon icon-search iconfont"></i>
                    <input class="search-input" id="J_searchAddressInput" type="text" placeholder="输入街道、乡镇、小区或商圈名称" autocomplete="off">
                    <span class="icon icon-del iconfont hide" id="J_searchAddressInputClear">×</span>
                </div>

                <div class="search-example">例如：北京 华润五彩城</div>

                <div class="loading hide"><div class="loader"></div></div>

                <!-- 附近商圈 -->
                <div class="nearby-address hide" id="J_nearbyAddress">
                    <div class="title">附近商圈</div>
                    <ul class="list clearfix"></ul>
                </div>

                <!-- 搜索列表 -->
                <div class="search-address hide" id="J_searchAdress">
                    <ul class="list clearfix"></ul>
                </div>

                <div class="no-result hide" id="J_noSearchResult">
                    没有找到这个地方，<a href="javascript:void(0);" class="J_switchTypeTrigger" data-type="select" data-stat-id="bf4b6022f582f76a" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-bf4b6022f582f76a', 'javascript:void0', 'pcpid', '']);">手动选择&gt;</a>
                </div>
                <div class="switch-type J_switchType">
                    <a href="javascript:void(0);" class="J_switchTypeTrigger" data-type="select" data-stat-id="0adde309879fe52b" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-0adde309879fe52b', 'javascript:void0', 'pcpid', '']);">手动选择地址&gt;</a>
                </div>
            </div>
            <div class="four-address-wrapper hide J_selectAddressItem" data-type="select">
                <div id="J_fourAddressWrapper"> <div class="select-box clearfix" id="J_selectWrapper"> <div class="select-first select-item J_select" data-init-txt="选择省份/自治区">选择省份/自治区</div> <div class="select-item J_select hide" data-init-txt="选择城市/地区"></div> <div class="select-item J_select hide" data-init-txt="选择区县"></div> <div class="select-last select-item J_select hide" data-init-txt="选择配送区域"></div> </div> <div class="options-box"> <ul class="options-list J_optionsWrapper clearfix">  <li class="option J_option" data-value="2" data-txt="北京">北京 </li>  <li class="option J_option" data-value="3" data-txt="天津">天津 </li>  <li class="option J_option" data-value="4" data-txt="河北">河北 </li>  <li class="option J_option" data-value="5" data-txt="山西">山西 </li>  <li class="option J_option" data-value="6" data-txt="内蒙古">内蒙古 </li>  <li class="option J_option" data-value="7" data-txt="辽宁">辽宁 </li>  <li class="option J_option" data-value="8" data-txt="吉林">吉林 </li>  <li class="option J_option" data-value="9" data-txt="黑龙江">黑龙江 </li>  <li class="option J_option" data-value="10" data-txt="上海">上海 </li>  <li class="option J_option" data-value="11" data-txt="江苏">江苏 </li>  <li class="option J_option" data-value="12" data-txt="浙江">浙江 </li>  <li class="option J_option" data-value="13" data-txt="安徽">安徽 </li>  <li class="option J_option" data-value="14" data-txt="福建">福建 </li>  <li class="option J_option" data-value="15" data-txt="江西">江西 </li>  <li class="option J_option" data-value="16" data-txt="山东">山东 </li>  <li class="option J_option" data-value="17" data-txt="河南">河南 </li>  <li class="option J_option" data-value="18" data-txt="湖北">湖北 </li>  <li class="option J_option" data-value="19" data-txt="湖南">湖南 </li>  <li class="option J_option" data-value="20" data-txt="广东">广东 </li>  <li class="option J_option" data-value="21" data-txt="广西">广西 </li>  <li class="option J_option" data-value="22" data-txt="海南">海南 </li>  <li class="option J_option" data-value="23" data-txt="重庆">重庆 </li>  <li class="option J_option" data-value="24" data-txt="四川">四川 </li>  <li class="option J_option" data-value="25" data-txt="贵州">贵州 </li>  <li class="option J_option" data-value="26" data-txt="云南">云南 </li>  <li class="option J_option" data-value="27" data-txt="西藏">西藏 </li>  <li class="option J_option" data-value="28" data-txt="陕西">陕西 </li>  <li class="option J_option" data-value="29" data-txt="甘肃">甘肃 </li>  <li class="option J_option" data-value="30" data-txt="青海">青海 </li>  <li class="option J_option" data-value="31" data-txt="宁夏">宁夏 </li>  <li class="option J_option" data-value="32" data-txt="新疆">新疆 </li>  </ul> <ul class="options-list J_optionsWrapper clearfix hide"></ul> <ul class="options-list J_optionsWrapper clearfix hide"></ul> <ul class="options-list J_optionsWrapper clearfix hide"></ul> </div></div>
                <div class="switch-type">
                    <a href="javascript:void(0);" class="J_switchTypeTrigger" data-type="search" data-stat-id="6c0c16e4a3502fe8" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-6c0c16e4a3502fe8', 'javascript:void0', 'pcpid', '']);"> 搜索地址快速定位&gt;</a>
                </div>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <a href="javascript:void(0);" class="btn btn-primary" id="J_editAddressSave" data-stat-id="2663a0ca2c98bc0e" );">保存</a>
        <a href="#J_modalEditAddress" class="btn btn-gray" data-toggle="modal" data-stat-id="214463e29b606824" );">取消</a>
    </div>
</div>
<div class="model-backdrop fade in" style="width: 100%;height:1702px;">

</div>
</body>
</html>

