<%--
  Created by IntelliJ IDEA.
  User: 任章哲
  Date: 2019/2/21
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN" xml:lang="zh-CN"><head><script type="text/javascript" async="" src="//a.stat.xiaomi.com/js/mstr.js?mid=h%2BYIdQVDeFvKbFhnnR3FJg%3D%3D&amp;device_id=&amp;phpsessid=&amp;mstuid=1550745198165_7153&amp;muuid=&amp;mucid=&amp;sessionId=353908963&amp;step=12&amp;new_visitor=0&amp;mstprevpid=&amp;mstprev_pid_loc=&amp;prevtarget=&amp;lastsource=account.xiaomi.com&amp;timestamp=1550745232089&amp;ref=https%3A%2F%2Fstatic.mi.com%2Fcart%2F%3Fautogo&amp;domain=.mi.com&amp;screen=1920*1080&amp;language=zh-CN&amp;vendor=Google Inc.&amp;platform=Win32&amp;gu=https%253A%252F%252Faccount.xiaomi.com%252Fpass%252Fsns%252Flogin%252Fload%252Ftoken%253Ftoken%253D%257Ctsentoken%253Da0jekh6up%25252fewafmtpzzhzhi%25252bm4r5x4kz%25252fwqvuzpuyjemw6lbaqaaj4kv6wibsgoe7xh3gtgo9jtcas%25252bg3xxjbfuwxd7wx4llemtjysd4tjqshj9nbcga8w6t0p5kkr8h%257Cexpires_in%253D0%257Cstate%253D7b22736964223a226d695f6573686f70222c226c6f63616c65223a227a685f434e222c2263616c6c6261636b223a2268747470732533412532462532466f726465722e6d692e636f6d2532466c6f67696e25324663616c6c6261636b253346666f6c6c6f77757025334468747470732532353341253235324625323532467374617469632e6d692e636f6d253235324663617274253235324625323533466175746f676f2532367369676e2533444d6d59784d4745324e4455305a574d334e4459794d444579596a6c6b4e5451314d4455314d325934595449314e6a64694e6a64694d51253243253243222c226170706964223a22313030323834363531227d&amp;miwd=&amp;edm_task=&amp;masid=&amp;client_id=&amp;pu=https%3A%2F%2Fstatic.mi.com%2Fcart%2F%3Fautogo&amp;rf=0&amp;mutid=&amp;muwd=&amp;domain_id=100&amp;pageid=17a1f380b9d4cd2e&amp;curl=https%3A%2F%2Forder.mi.com%2Fbuy%2Fcheckout%3Fr%3D18082.1550745230&amp;xmv=1550745198165_7153_1550745198165&amp;v=1.0.0&amp;vuuid=SQP05K4JT76PVRTG"></script><script type="text/javascript" async="" src="//s1.mi.com/stat/18/jquery.statData.min.js?d=2019221"></script><script type="text/javascript" async="" src="//s1.mi.com/stat/18/xmst.js"></script>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta charset="UTF-8">
    <title>填写订单信息</title>
    <meta name="viewport" content="width=1226">
    <link rel="shortcut icon" href="//s01.mifile.cn/favicon.ico" type="image/x-icon">
    <link rel="icon" href="//s01.mifile.cn/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="//s01.mifile.cn/css/base.min.css?v2017122601">
    <link rel="stylesheet" type="text/css" href="//s01.mifile.cn/css/checkout.min.css?v=2018020602">
    <script type="text/javascript" src="assets/js/jquery-1.11.0.js" ></script>
    <!--导入bootstrap.js-->
    <script type="text/javascript" src="assets/js/bootstrap.min.js" ></script>
    <script src="https://account.xiaomi.com/pass/userInfoJsonP?userId=0&amp;callback=setLoginInfo_getAccountInfo" type="text/javascript" async=""></script><style id="tsbrowser_video_independent_player_style" type="text/css">                                                            [tsbrowser_force_max_size] {                                                   width: 100% !important;                                                      height: 100% !important;                                                     left: 0px !important;                                                        top: 0px !important;                                                         margin: 0px !important;                                                      padding: 0px !important;                                                   }                                                                            [tsbrowser_force_fixed] {                                                      position: fixed !important;                                                  z-index: 9999 !important;                                                    background: black !important;                                              }                                                                            [tsbrowser_force_hidden] {                                                     opacity: 0 !important;                                                       z-index: 0 !important;                                                     }                                                                            [tsbrowser_hide_scrollbar] {                                                   overflow: hidden !important;                                               }</style></head>
<body>
<div class="site-header site-mini-header">
    <div class="container">
        <div class="header-logo">
            <a class="logo " href="//www.mi.com/index.html" title="小米官网" data-stat-id="ea54c9fed6a874d7" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-ea54c9fed6a874d7', '//www.mi.com/index.html', 'pcpid', '']);"></a>
        </div>
        <div class="header-title" id="J_miniHeaderTitle"><h2>确认订单</h2></div>
        <div class="topbar-info" id="J_userInfo"><span class="user"><a rel="nofollow" class="user-name" href="//my.mi.com/portal" target="_blank"><span class="name">undo.</span><i class="iconfont"></i></a><ul class="user-menu"><li><a rel="nofollow" href="//my.mi.com/portal" target="_blank">个人中心</a></li><li><a rel="nofollow" href="https://order.mi.com/user/comment" target="_blank">评价晒单</a></li><li><a rel="nofollow" href="https://order.mi.com/user/favorite" target="_blank">我的喜欢</a></li><li><a rel="nofollow" href="//account.xiaomi.com/" target="_blank">小米账户</a></li><li><a rel="nofollow" href="https://order.mi.com/site/logout">退出登录</a></li></ul></span><span class="sep">|</span><a rel="nofollow" class="link link-order" href="//static.mi.com/order/" target="_blank">我的订单</a></div>
    </div>
</div>
<!-- .site-mini-header END -->
<script type="text/javascript">
    var checkoutConfig = {
        addressMatch:'common',
        addressMatchVarName: new Function('return ' + 'data'),
        hasPresales:false,
        hasBigTv:false,
        hasAir:false,
        hasScales:false,
        hasWater:false,
        hasWater2:false,
        hasMobile:false,
        hasEboiler:false,
        hasEvent:false,
        hasGiftcard:false,
        totalPrice:1967,
        needPayAmount:1967,
        postage:0,
        postFree:true,
        bcPrice:'150',
        activityDiscountMoney:0.00,//活动优惠
        showCouponBox:0,
        showCaptcha:'0',
        invoice:[{"type":"electron","value":4,"desc":"\u7535\u5b50\u53d1\u7968","checked":true},{"type":"personal","value":1,"desc":"\u7eb8\u8d28\u53d1\u7968","checked":false}],
        quickOrder: '',
        hasBigPro: false,
        onlinePayTips: '支持微信支付、支付宝、银联、财付通、小米钱包等',
        subsidyPrice: 0};
</script>

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
                    <div class="address-item J_addressItem " data-address_id="11000000023664816" data-consignee="任章哲" data-tel="135****7190" data-province_id="24" data-province_name="四川" data-city_id="272" data-city_name="成都市" data-district_id="2552" data-district_name="郫县" data-area="2552002" data-area_name="安靖镇" data-address="西南交通大学" data-tag_name="" data-zipcode="611700" data-editable="Y" data-neededit="N">
                        <dl>
                            <dt>
                                <span class="tag"></span>
                                <em class="uname">任章哲</em>
                            </dt>
                            <dd class="utel">
                                135****7190                            </dd>
                            <dd class="uaddress">
                                四川 成都市 郫县 安靖镇<br>
                                西南交通大学                            </dd>
                        </dl>
                        <div class="actions">
                            <a href="javascript:void(0);" class="modify J_addressModify" data-stat-id="c893d143edbb3fec" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-c893d143edbb3fec', 'javascript:void0', 'pcpid', '']);">修改</a>
                        </div>
                    </div>
                    <!-- addresslist end -->
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
                                <img src="//i1.mifile.cn/a1/pms_1535423435.28063593!30x30.jpg" width="30" height="30">
                            </div>
                            <div class="col col-name">

                                <a href="//item.mi.com/1183500002.html" target="_blank" data-stat-id="53e0d9ea86f5de2d" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-53e0d9ea86f5de2d', '//item.mi.com/1183500002.html', 'pcpid', '']);">
                                    米兔遥控小飞机套装                                        </a>

                            </div>

                            <div class="col col-price">
                                468元 x 1                                    </div>
                            <div class="col col-status">
                                &nbsp;
                            </div>
                            <div class="col col-total">
                                468元
                            </div>

                        </li>
                        <li class="clearfix">
                            <div class="col col-img">
                                <img src="//i1.mifile.cn/a1/pms_1537324004.08544830!30x30.jpg" width="30" height="30">
                            </div>
                            <div class="col col-name">

                                <a href="//item.mi.com/1183600012.html" target="_blank" data-stat-id="751d17798fe873e8" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-751d17798fe873e8', '//item.mi.com/1183600012.html', 'pcpid', '']);">
                                    小米8 青春 全网通版 6GB内存 梦幻蓝 64GB                                        </a>

                            </div>

                            <div class="col col-price">
                                1499元 x 1                                    </div>
                            <div class="col col-status">
                                &nbsp;
                            </div>
                            <div class="col col-total">
                                1499元
                            </div>

                        </li>
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
                        <li data-type="shipment" class="J_option selected" data-amount="0" data-value="2">
                            包邮                                                    </li>
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
                            <span class="val">1967元</span>
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
                            <span class="val"><i data-id="J_postageVal">0</i>元</span>
                        </li>
                        <li class="clearfix total-price">
                            <label>应付总额：</label>
                            <span class="val"><em data-id="J_totalPrice">1967</em>元</span>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="section-bar clearfix">
                <div class="fl">
                    <div class="seleced-address hide" id="J_confirmAddress">
                    </div>
                    <div class="big-pro-tip hide J_confirmBigProTip"></div>
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

<!-- <div class="modal fade modal-hide modal-edit-address" id="J_modalEditAddress">
    <div class="modal-body">
        <iframe height="100%" width="100%"  frameborder="0" allowfullscreen=""></iframe>
    </div>
</div> -->

<div class="modal fade modal-hide fade modal-alert" id="J_modalAlert">
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

<div class="address-top-bar address-top-bar-active" id="J_addressTopBar">
    <div class="container">
        <a href="javascript:void(0);" class="btn btn-primary" id="J_addressTopBarBtn" data-stat-id="336acd257ed12157" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-336acd257ed12157', 'javascript:void0', 'pcpid', '']);">选择该收货地址</a>
        <div class="content" id="J_addressTopCon"><span class="uname">任章哲</span><span class="utel">135****7190</span> 四川 成都市 郫县 西南交通大学</div>
    </div>
</div>


<div class="modal modal-warning modal-hide" id="warning-bargain-1463">
    <div class="modal-hd">
        <h2 class="title">温馨提示</h2>
        <a class="close" data-dismiss="modal" href="javascript: void(0);" data-stat-id="7f05d4a8c5beeb64" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-7f05d4a8c5beeb64', 'javascript:void0', 'pcpid', '']);"><i class="iconfont"></i></a>
    </div>
    <div class="modal-bd">
        <p>
            <b>换卡说明：</b>
            <br><br>移动2G / 3G卡升级为移动4G卡
            <br>传统SIM大卡换小米手机适配的micro卡
        </p>
    </div>
</div>

<div class="modal modal-warning modal-hide" id="warning-bargain-1464">
    <div class="modal-hd">
        <h2 class="title">温馨提示</h2>
        <a class="close" data-dismiss="modal" href="javascript: void(0);" data-stat-id="7f05d4a8c5beeb64" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-7f05d4a8c5beeb64', 'javascript:void0', 'pcpid', '']);"><i class="iconfont"></i></a>
    </div>
    <div class="modal-bd">
        <p>
            <b>换卡说明：</b>
            <br><br>移动2G / 3G卡升级为移动4G卡
            <br>传统SIM大卡换小米手机适配的nano卡
        </p>
    </div>
</div>

<div class="modal modal-invoice modal-hide fade" id="J_modalInvoiceInfo">
    <div class="modal-hd">
        <span class="title">发票信息</span>
        <span class="close" data-dismiss="modal"><i class="iconfont"></i></span>
    </div>
    <div class="modal-body">
        <div class="in-section clearfix">
            <label class="tit">发票类型：</label>
            <ul class="J_optionList options options-list  clearfix">
                <li data-type="invoice" data-invoice-type="not_invoice" class="hide J_option">
                    不开发票
                </li>
                <li data-type="invoice" data-invoice-type="personal" class="J_option hide" data-value="1">
                    纸质发票
                </li>
                <li data-type="invoice" data-invoice-type="electron" class="J_option selected" data-value="4">
                    电子发票
                </li>
            </ul>
            <div class="invoice-tip hide invoice-paper-tip" id="J_invoicePaperTip">
                1. 发票不与商品随箱寄出； <br>
                2. 发票将于商品妥投完成7日后单独寄出； <br>
                3. 发票收到后请妥善保存，退货需一同寄回。
            </div>
            <div class="invoice-tip" id="J_invoiceDefaultTip">
                电子发票与纸质发票具有相同法律效力，可作为报销、售后、维权凭证。<br>
                <span>推荐使用电子发票，不怕丢失、更方便、更环保。</span> <br>
                <a href="javascript:void(0);" id="J_showPaperOption" data-stat-id="22119da1941db54e" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-22119da1941db54e', 'javascript:void0', 'pcpid', '']);">选择纸质发票 &gt;</a>
            </div>

            <div class="invoice-tip hide" id="J_onlyEleTip">
                电子发票是税务局认可的有效凭证，其法律效力、基本用途及使用规定同纸质发票。
            </div>
        </div>

        <div id="J_invoceInfoOpionsContent">
            <div class="in-section clearfix" id="J_invoiceTitleSec">
                <label class="tit">发票抬头：</label>
                <ul class="J_optionList options options-list clearfix">
                    <li data-type="invoice-mode" data-invoice-mode="personal" class="J_option selected">
                        个人
                    </li>
                    <li data-type="invoice-mode" data-invoice-mode="company" class="J_option">
                        单位
                    </li>
                </ul>
                <div class="form-section form-section-active form-section-valid">
                    <label class="input-label" for="invoice_title">请输入发票抬头</label>
                    <input class="input-text input-text-big" type="text" id="invoice_title" name="invoice_title" value="个人">
                </div>
            </div>

            <div class="in-section clearfix hide" id="J_invoiceCompanyCode">
                <label class="tit">单位税号：</label>
                <div class="form-section form-section-valid">
                    <label class="input-label" for="invoice_company_code">请填写购买方纳税人识别号或统一社会信用代码</label>
                    <input class="input-text input-text-big" type="text" id="invoice_company_code" name="invoice_company_code" value="">
                    <a href="javascript:void(0);" data-bubble-toggle="invoiceCompanyCodeQa" data-stat-id="1f456df28d12dfe6" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-1f456df28d12dfe6', 'javascript:void0', 'pcpid', '']);"><i class="icon-qa">?</i></a>
                    <div class="qa-detail hide" data-bubble="invoiceCompanyCodeQa">
                        纳税人识别号为营业执照上的统一社会信用代码或税务登记证上的税号，一般为15、17、18、20位数字或大写字母。
                    </div>
                </div>
            </div>

            <div class="in-section clearfix J_eInvoiceMore">
                <label class="tit">收票手机：</label>
                <div class="form-section form-section-active form-section-valid">
                    <label class="input-label" for="einvoice_phone">收票人手机</label>
                    <input class="input-text input-text-big" type="text" id="einvoice_phone" name="einvoice_phone" data-tel="135****7190" value="135****7190" placeholder="电子发票开具后短信告知你（选填）">
                </div>
            </div>

            <div class="in-section clearfix J_eInvoiceMore">
                <label class="tit">收票邮箱：</label>
                <div class="form-section">
                    <label class="input-label" for="einvoice_mail">收票人邮箱</label>
                    <input class="input-text input-text-big" type="text" id="einvoice_mail" name="einvoice_mail" data-email="" value="" placeholder="用于接收电子发票（选填）">
                </div>
            </div>

            <div class="in-section in-section-con clearfix">
                <label class="tit">发票内容：</label>
                购买商品明细
            </div>

            <div class="more">
                <dl>
                    <dt>发票须知：</dt>
                    <dd>1.发票金额为实际支付金额，不包含优惠券、礼品卡等；</dd>
                    <dd>2.电子发票可以在订单完成后，在订单详情中下载和查看；</dd>
                    <dd>3.纸质发票不与商品同时发出，商品妥投完成7日后发出，收到后请妥善保存，如退货需一同寄回。</dd>
                    <dd>4.第三方商品的发票由相关企业单独开具。</dd>
                    <dd>
                        <a href="https://order.mi.com/static/invoice" target="_blank" data-stat-id="dab4109570462a94" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-dab4109570462a94', 'https://order.mi.com/static/invoice', 'pcpid', '']);">发票相关问题 &gt;</a>
                    </dd>
                </dl>
            </div>
        </div>

        <div class="tip" id="J_invoiceInfoSubmitTip"></div>
    </div>
    <div class="modal-footer">
        <a href="javascript:void(0);" class="btn btn-gray" data-dismiss="modal" data-stat-id="aca6a7466c3f3c1f" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-aca6a7466c3f3c1f', 'javascript:void0', 'pcpid', '']);">取消</a>
        <a href="javascript:void(0);" class="btn btn-primary" id="J_invoiceInfoSubmit" data-stat-id="2663a0ca2c98bc0e" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-2663a0ca2c98bc0e', 'javascript:void0', 'pcpid', '']);">保存</a>
    </div>
</div>

<!-- 保险弹窗 -->
<!-- 保险服务购买弹层 -->
<div class="modal fade modal-agreement modal-hide" id="J_modalAgreement">
</div>
<!-- 保险服务购买弹层模板 -->
<%--<script id="J_agreementTmp" type="text/x-dot-template">
    <span class="close" data-dismiss="modal"><i class="iconfont">&#xe602;</i></span>
    <div class="modal-body">
        <h3 class="title">购买服务</h3>
        <div class="con">
            <div class="left">
                {{?it.service_url}}
                <a href="{{=it.service_url}}" target="_blank">
                    <img alt="" src="{{=it.service_image_url}}" width="60" height="60">
                </a>
                {{??}}
                <img alt="" src="{{=it.service_image_url}}" width="60" height="60">
                {{?}}
            </div>
            <div class="right">
                <p class="name"> {{=it.service_short_name}} </p>
                <p class="desc"> {{=it.service_name}}
                    <span class="price">
                    {{?it.act_price}}
                    {{=parseInt(it.act_price)}}元
                        {{?parseInt(it.act_diff) > 0}}
                        <span class="price-diff"> ( 省 {{=parseInt(it.act_diff)}}元 )</span>
                        {{?}}
                    {{??}}
                        {{=parseInt(it.service_price)}}元
                    {{?}}
                    </span>
                </p>
                {{?it.phone_accidentIns}}
                <p class="agreement">
                    <i class="iconfont icon-checkbox J_agreement"><em>√</em></i> 我已阅读
                    {{~it.phone_accidentIns:agreementItem:agreementIndex }}
                    <a href="{{=agreementItem.url}}" target="_blank">{{=agreementItem.desc}}
                        {{?agreementIndex != it.phone_accidentIns.length - 1}}<span>|</span>{{?}}</a>
                    {{~}}
                </p>
                {{?}}
            </div>
        </div>
        <div class="actions">
            <button
                    {{?it.phone_accidentIns}}
                    class="btn btn-primary btn-disabled"
                    {{??}}
                    class="btn btn-primary"
                    {{?}}
                    {{?it.act_id}}
                    data-id="{{=it.service_goods_id}}-0-1-{{=it.act_id}}"
                    {{??}}
                    data-id={{=it.service_goods_id}}
                    {{?}}
                    data-pid="{{=it.parent_item_id}}"
                    data-source="{{=it.source}}">确认购买</button>
        </div>
    </div>

</script>
<script id="J_newAddressTemplate" type="text/x-dot-template">
    <div class="address-item J_addressItem "
         data-address_id="{{=it.address_id}}"
         data-consignee="{{=it.uname}}"
         data-tel="{{=it.phone}}"
         data-province_id="{{=it.province}}"
         data-province_name="{{=it.provinceName}}"
         data-city_id="{{=it.city}}"
         data-city_name="{{=it.cityName}}"
         data-district_id="{{=it.county}}"
         data-district_name="{{=it.countyName}}"
         data-area="{{=it.area}}"
         data-area-name="{{=it.areaName}}"
         data-address="{{=it.address}}"
         data-tag_name="{{=it.tag}}">

        <dl>
            <dt>
                <span class="tag">{{=it.tag}}</span>
                <em class="uname">{{=it.uname}}</em>
            </dt>
            <dd class="utel">{{=it.phone}}</dd>
            <dd class="uaddress">
                {{=it.provinceName}} {{=it.cityName}} {{=it.countyName}} {{=it.areaName}}
                <br>
                {{=it.address}}
            </dd>
        </dl>
        <div class="actions">
            <a href="javascript:void(0);" class="modify J_addressModify">修改</a>
        </div>
    </div>
</script>

<script id="J_checkoutMoneyTemplate" type="text/x-dot-template">
    <ul>
        <li class="clearfix">
            <label>商品件数：</label>
            <span class="val">{{=it.total_count}}件</span>
        </li>
        <li class="clearfix">
            <label>商品总价：</label>
            <span class="val">{{=it.productMoney}}元</span>
        </li>
        {{? it.ecards.ecard_amount && it.ecards.ecard_amount>0}}
        <li class="clearfix">
            <label>券卡支付：</label>
            <span class="val">-{{=it.ecards.ecard_amount}}元</span>
        </li>
        {{? }}
        <li class="clearfix">
            <label>活动优惠：</label>
            <span class="val">-{{=it.activityDiscountMoney}}元</span>
        </li>
        <li class="clearfix">
            <label>优惠券抵扣：</label>
            <span class="val"><i id="J_couponVal">-0</i>元</span>
        </li>

        {{? it.subsidy.sub_amount && it.subsidy.sub_amount>0}}
        <li class="clearfix">
            <label>节能补贴：</label>
            <span class="val">-{{=it.subsidy.sub_amount}}元</span>
        </li>
        {{? }}

        <li class="clearfix">
            <label>运费：</label>
            <span class="val"><i data-id="J_postageVal">{{=it.shipment}}</i>元</span>
        </li>
        <li class="clearfix total-price">
            <label>应付总额：</label>
            <span class="val"><em data-id="J_totalPrice">{{=it.need_pay_amount}}</em>元</span>
        </li>
    </ul>
</script>

<script id="J_checkoutGoodsTemplate" type="text/x-dot-template">
    {{~it.items :value:index}}
    <li class="clearfix">
        <div class="col col-img">
            <img src="{{=value.image_url}}" width="30" height="30">
        </div>
        <div class="col col-name">

            {{? $.inArray("FLOWPACKET",value.tags) >= 0 || it.hasPrepay}}
            {{=value.product_name}}
            {{?? }}
            <a href="{{=MI.GLOBAL_CONFIG.itemSite}}/{{=value.commodity_id}}.html" target="_blank">
                {{=value.product_name}}
            </a>
            {{? }}

            {{? value.showTypeName}}
            <em class="label">{{=value.showTypeName}}</em>
            {{? }}
        </div>
        <div class="col col-price">
            {{?!it.hasPrepay}}
            {{=value.salePrice}}元 x {{=value.num}}
            {{??}}
            &nbsp;
            {{?}}
        </div>
        <div class="col col-status">
            &nbsp;
        </div>
        <div class="col col-total">
            {{?it.hasPrepay}}
            {{=it.prepayInfo.price_title}}
            {{??}}
            {{=value.subtotal}}元
            {{?}}
        </div>
    </li>
    {{~}}
</script>


<!--结算提示 -->
<script id="J_tipGoodsTemplate" type="text/x-dot-template">
    <div class="modal fade modal-hide  modal-tip-goods modal-tip-goods-{{=it.data.items.length}}" id="J_modalTipGoods" >
        <div class="modal-hd">
            <h3 class="title">{{=it.msg}}</h3>
            <a class="close" data-dismiss="modal"  href="javascript: void(0);"><i class="iconfont">&#xe602;</i></a>
        </div>
        <div class="modal-bd">
            {{? it.data.items && it.data.items.length}}
            <ul class="list clearfix" id="J_tipGoodskList">
                {{~it.data.items :itemValue:itemIndex}}
                <li>
                    {{? itemValue.image_url}}
                    <img src="{{=itemValue.image_url}}" width="160" height="160" alt="{{=itemValue.product_name}}">
                    {{? }}
                    <h3>{{=itemValue.product_name}}</h3>
                    <p class="price">{{=itemValue.salePrice}}元</p>
                </li>
                {{~}}
            </ul>
            {{? }}
        </div>
        <div class="modal-ft">
            <a href="//static.mi.com/cart/" class="btn btn-primary" >返回购物车</a>
        </div>
    </div>
</script>

<!-- 购物卡列表 -->
<script id="J_ecardTemplate" type="text/x-dot-template">
    <div class="table-wrapper">
        <ul class="clearfix">
            <li class="col-1">选择</li>
            {{? it.type === 'recycle'}}
            <li class="col-2">券号</li>
            {{?? }}
            <li class="col-2">卡号</li>
            {{? }}
            <li class="col-3">本次使用（元）</li>
            <li class="col-4">余额（元）</li>

            {{? it.type === 'normal'}}
            <li class="col-5">有效期至</li>
            {{? }}
        </ul>
        {{? it.data.length > 5 }}
        <div class="table-scroll">
            {{?? }}
            <div>
                {{? }}
                <table>
                    <tbody>
                    {{~it.data :itemValue:itemIndex}}
                    {{? itemValue.isSel}}
                    <tr class="J_ecardItem selected" data-id="{{=itemValue.card_id}}" data-balance="{{=itemValue.balance}}">
                        {{?? }}
                    <tr class="J_ecardItem" data-id="{{=itemValue.card_id}}" data-balance="{{=itemValue.balance}}">
                        {{? }}
                        <td class="col-1"><i class="iconfont icon-checkbox J_ecardCheckbox">&#x221a;</i></td>
                        <td class="col-2">
                            {{=itemValue.card_id}}
                            {{? itemValue.type === 'phone_ecard' || itemValue.type === 'cash_ecard'}}
                            （{{=itemValue.name}}）
                            {{? }}
                        </td>
                        <td class="col-3 use J_income">0</td>
                        <td class="col-4 J_balance">{{=itemValue.balance}}</td>

                        {{? it.type === 'normal'}}
                        <td class="col-5">{{=itemValue.end_time_format}}</td>
                        {{? }}
                    </tr>
                    {{~}}
                    </tbody>
                </table>
            </div>
        </div>
</script>--%>
<div class="site-footer">
    <div class="container">
        <div class="footer-service">
            <ul class="list-service clearfix">
                <li><a rel="nofollow" href="//www.mi.com/static/fast/" target="_blank" data-stat-id="09c7759e04e98528" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-09c7759e04e98528', '//www.mi.com/static/fast/', 'pcpid', '']);"><i class="iconfont"></i>预约维修服务</a></li>
                <li><a rel="nofollow" href="//www.mi.com/service/exchange#back" target="_blank" data-stat-id="5380b4f1f26958ea" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-5380b4f1f26958ea', '//www.mi.com/service/exchange#back', 'pcpid', '']);"><i class="iconfont"></i>7天无理由退货</a></li>
                <li><a rel="nofollow" href="//www.mi.com/service/exchange#back" target="_blank" data-stat-id="0ec4b8aeb89038ef" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-0ec4b8aeb89038ef', '//www.mi.com/service/exchange#back', 'pcpid', '']);"><i class="iconfont"></i>15天免费换货</a></li>
                <li><a rel="nofollow" href="//www.mi.com/service/buy/postage/" target="_blank" data-stat-id="69c6d4a09d1ce277" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-69c6d4a09d1ce277', '//www.mi.com/service/buy/postage/', 'pcpid', '']);"><i class="iconfont"></i>满150元包邮</a></li>
                <li><a rel="nofollow" href="//www.mi.com/static/maintainlocation/" target="_blank" data-stat-id="47663ce91c9b4c6f" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-47663ce91c9b4c6f', '//www.mi.com/static/maintainlocation/', 'pcpid', '']);"><i class="iconfont"></i>520余家售后网点</a></li>
            </ul>
        </div>
        <div class="footer-links clearfix">

            <dl class="col-links col-links-first">
                <dt>帮助中心</dt>

                <dd><a rel="nofollow" href="//www.mi.com/service/account/register/" target="_blank" data-stat-id="cbf879ec5555acc8" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-cbf879ec5555acc8', '//www.mi.com/service/account/register/', 'pcpid', '']);">账户管理</a></dd>

                <dd><a rel="nofollow" href="//www.mi.com/service/buy/buytime/" target="_blank" data-stat-id="cc5e2e04a7468948" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-cc5e2e04a7468948', '//www.mi.com/service/buy/buytime/', 'pcpid', '']);">购物指南</a></dd>

                <dd><a rel="nofollow" href="//www.mi.com/service/order/sendprogress/" target="_blank" data-stat-id="129ad32e2936fa21" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-129ad32e2936fa21', '//www.mi.com/service/order/sendprogress/', 'pcpid', '']);">订单操作</a></dd>

            </dl>

            <dl class="col-links ">
                <dt>服务支持</dt>

                <dd><a rel="nofollow" href="//www.mi.com/service/exchange" target="_blank" data-stat-id="e4e8494b929c27cc" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-e4e8494b929c27cc', '//www.mi.com/service/exchange', 'pcpid', '']);">售后政策</a></dd>

                <dd><a rel="nofollow" href="http://fuwu.mi.com/" target="_blank" data-stat-id="be93301b03ea9d9a" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-be93301b03ea9d9a', 'http://fuwu.mi.com/', 'pcpid', '']);">自助服务</a></dd>

                <dd><a rel="nofollow" href="http://xiazai.mi.com/" target="_blank" data-stat-id="5f33d0eb49c69eea" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-5f33d0eb49c69eea', 'http://xiazai.mi.com/', 'pcpid', '']);">相关下载</a></dd>

            </dl>

            <dl class="col-links ">
                <dt>线下门店</dt>

                <dd><a rel="nofollow" href="//www.mi.com/c/xiaomizhijia/" target="_blank" data-stat-id="e3093a95cf90118a" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-e3093a95cf90118a', '//www.mi.com/c/xiaomizhijia/', 'pcpid', '']);">小米之家</a></dd>

                <dd><a rel="nofollow" href="//www.mi.com/static/maintainlocation/" target="_blank" data-stat-id="426ca0b21055ecce" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-426ca0b21055ecce', '//www.mi.com/static/maintainlocation/', 'pcpid', '']);">服务网点</a></dd>

                <dd><a rel="nofollow" href="//www.mi.com/static/familyLocation/" target="_blank" data-stat-id="7108b7f3b6c08f0e" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-7108b7f3b6c08f0e', '//www.mi.com/static/familyLocation/', 'pcpid', '']);">零售网点</a></dd>

            </dl>

            <dl class="col-links ">
                <dt>关于小米</dt>

                <dd><a rel="nofollow" href="//www.mi.com/about/" target="_blank" data-stat-id="7793e051987d4005" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-7793e051987d4005', '//www.mi.com/about/', 'pcpid', '']);">了解小米</a></dd>

                <dd><a rel="nofollow" href="http://hr.xiaomi.com/" target="_blank" data-stat-id="ef2903728d7fdadf" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-ef2903728d7fdadf', 'http://hr.xiaomi.com/', 'pcpid', '']);">加入小米</a></dd>

                <dd><a rel="nofollow" href="//www.mi.com/about/contact/" target="_blank" data-stat-id="ef5b42063eda339b" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-ef5b42063eda339b', '//www.mi.com/about/contact/', 'pcpid', '']);">联系我们</a></dd>

            </dl>

            <dl class="col-links ">
                <dt>关注我们</dt>

                <dd><a rel="nofollow" href="http://weibo.com/xiaomishangcheng" target="_blank" data-stat-id="c76038c110f7e33f" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-c76038c110f7e33f', 'http://weibo.com/xiaomishangcheng', 'pcpid', '']);">新浪微博</a></dd>

                <dd><a rel="nofollow" href="http://xiaoqu.qq.com/mobile/share/index.html?url=http%3A%2F%2Fxiaoqu.qq.com%2Fmobile%2Fbarindex.html%3Fwebview%3D1%26type%3D%26source%3Dindex%26_lv%3D25741%26sid%3D%26_wv%3D5123%26_bid%3D128%26%23bid%3D10525%26from%3Dwechat" target="_blank" data-stat-id="a3992aa3363de0ff" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-a3992aa3363de0ff', 'http://xiaoqu.qq.com/mobile/share/index.htmlurl=http3A2F2Fxiaoqu.qq.com2Fmobile2Fbarindex.html3Fwebview3D126type3D26source3Dindex26_lv3D2574126sid3D26_wv3D512326_bid3D1282623bid3D1052526from3Dwechat', 'pcpid', '']);">小米部落</a></dd>

                <dd><a rel="nofollow" href="#J_modalWeixin" data-toggle="modal" data-stat-id="d510962f8f7e78df" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-d510962f8f7e78df', '#J_modalWeixin', 'pcpid', '']);">官方微信</a></dd>

            </dl>

            <dl class="col-links ">
                <dt>特色服务</dt>

                <dd><a rel="nofollow" href="//order.mi.com/queue/f2code" target="_blank" data-stat-id="600fe7ff75e6569f" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-600fe7ff75e6569f', '//order.mi.com/queue/f2code', 'pcpid', '']);">F 码通道</a></dd>

                <dd><a rel="nofollow" href="//www.mi.com/giftcode/" target="_blank" data-stat-id="8ecb47b996b7c48e" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-8ecb47b996b7c48e', '//www.mi.com/giftcode/', 'pcpid', '']);">礼物码</a></dd>

                <dd><a rel="nofollow" href="//order.mi.com/misc/checkitem" target="_blank" data-stat-id="e47e9638c6c00023" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-e47e9638c6c00023', '//order.mi.com/misc/checkitem', 'pcpid', '']);">防伪查询</a></dd>

            </dl>

            <div class="col-contact">
                <p class="phone">400-100-5678</p>
                <p>
                    周一至周日 9:00-18:00<br>（仅收市话费）
                </p>
                <a rel="nofollow" class="btn btn-line-primary btn-small" href="//www.mi.com/service/contact/" target="_blank" data-stat-id="6e11a88b65750712" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-6e11a88b65750712', '//www.mi.com/service/contact/', 'pcpid', '']);"><i class="iconfont"></i> 在线客服</a>            </div>
        </div>
    </div>
</div>
<div class="site-info">
    <div class="container">
        <span class="logo ir">小米官网</span>
        <div class="info-text">
            <p>小米旗下网站：<a href="//www.mi.com/index.html" target="_blank" data-stat-id="c02e72740d9d2ed0" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-c02e72740d9d2ed0', '//www.mi.com/index.html', 'pcpid', '']);">小米商城</a><span class="sep">|</span><a href="http://www.miui.com/" target="_blank" data-stat-id="387cbbf7e006d763" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-387cbbf7e006d763', 'http://www.miui.com/', 'pcpid', '']);">MIUI</a><span class="sep">|</span><a href="http://home.mi.com/index.html" target="_blank" data-stat-id="c06a4063d2e4c1a7" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-c06a4063d2e4c1a7', 'http://home.mi.com/index.html', 'pcpid', '']);">米家</a><span class="sep">|</span><a href="http://www.miliao.com/" target="_blank" data-stat-id="8d6bca678173c3fb" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-8d6bca678173c3fb', 'http://www.miliao.com/', 'pcpid', '']);">米聊</a><span class="sep">|</span><a href="http://www.duokan.com/" target="_blank" data-stat-id="583c11e2ed4091bf" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-583c11e2ed4091bf', 'http://www.duokan.com/', 'pcpid', '']);">多看</a><span class="sep">|</span><a href="http://www.miwifi.com/" target="_blank" data-stat-id="ba2bed134a6ed36d" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-ba2bed134a6ed36d', 'http://www.miwifi.com/', 'pcpid', '']);">路由器</a><span class="sep">|</span><a href="//www.mi.com/micard/" target="_blank" data-stat-id="87c8f0c009662c57" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-87c8f0c009662c57', '//www.mi.com/micard/', 'pcpid', '']);">米粉卡</a><span class="sep">|</span><a href="http://xiaomi.tmall.com/" target="_blank" data-stat-id="950917415698a0d6" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-950917415698a0d6', 'http://xiaomi.tmall.com/', 'pcpid', '']);">小米天猫店</a><span class="sep">|</span><a href="http://www.miui.com/res/doc/privacy/cn.html" target="_blank" data-stat-id="18802a622396e215" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-18802a622396e215', 'http://www.miui.com/res/doc/privacy/cn.html', 'pcpid', '']);">隐私政策</a><span class="sep">|</span><a href="https://static.mi.com/feedback/" target="_blank" data-stat-id="d32557eea752e976" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-d32557eea752e976', 'https://static.mi.com/feedback/', 'pcpid', '']);">问题反馈</a><span class="sep">|</span><a href="#J_modal-globalSites" data-toggle="modal" target="_blank" data-stat-id="0a32038c8d247224" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-0a32038c8d247224', '#J_modal-globalSites', 'pcpid', '']);">Select Region</a>            </p>
            <p>©<a href="//www.mi.com/" target="_blank" title="mi.com" data-stat-id="9633c739051c07ae" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-9633c739051c07ae', '//www.mi.com/', 'pcpid', '']);">mi.com</a> 京ICP证110507号 <a href="http://www.miitbeian.gov.cn/" target="_blank" rel="nofollow" data-stat-id="9782c50fb4ba0561" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-9782c50fb4ba0561', 'http://www.miitbeian.gov.cn/', 'pcpid', '']);">京ICP备10046444号</a> <a rel="nofollow" href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=11010802020134" target="_blank" data-stat-id="e9d2688beb41458a" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-e9d2688beb41458a', 'http://www.beian.gov.cn/portal/registerSystemInforecordcode=11010802020134', 'pcpid', '']);">京公网安备11010802020134号 </a><a rel="nofollow" href="//c1.mifile.cn/f/i/2013/cn/jingwangwen.jpg" target="_blank" data-stat-id="5cbd7b49fa457c86" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-5cbd7b49fa457c86', '//c1.mifile.cn/f/i/2013/cn/jingwangwen.jpg', 'pcpid', '']);">京网文[2014]0059-0009号</a>

                <br> 违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</p>
        </div>
        <div class="info-links">
            <a href="//privacy.truste.com/privacy-seal/validation?rid=4fc28a8c-6822-4980-9c4b-9fdc69b94eb8&amp;lang=zh-cn" target="_blank" data-stat-id="d79bd36766f023f0" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-d79bd36766f023f0', '//privacy.truste.com/privacy-seal/validationrid=4fc28a8c-6822-4980-9c4b-9fdc69b94eb8&amp;lang=zh-cn', 'pcpid', '']);"><img src="//i1.mifile.cn/f/i/17/site/truste.png" alt="TRUSTe Privacy Certification"></a>
            <a href="//search.szfw.org/cert/l/CX20120926001783002010" target="_blank" data-stat-id="f0877449bc91038d" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-f0877449bc91038d', '//search.szfw.org/cert/l/CX20120926001783002010', 'pcpid', '']);"><img src="//s01.mifile.cn/i/v-logo-2.png" alt="诚信网站"></a>
            <a href="https://ss.knet.cn/verifyseal.dll?sn=e12033011010015771301369&amp;ct=df&amp;pa=461082" target="_blank" data-stat-id="2173f8773b3dc666" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-2173f8773b3dc666', 'https://ss.knet.cn/verifyseal.dllsn=e12033011010015771301369&amp;ct=df&amp;pa=461082', 'pcpid', '']);"><img src="//s01.mifile.cn/i/v-logo-1.png" alt="可信网站"></a>
            <a href="http://www.315online.com.cn/member/315140007.html" target="_blank" data-stat-id="d2aa5eabb354499e" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-d2aa5eabb354499e', 'http://www.315online.com.cn/member/315140007.html', 'pcpid', '']);"><img src="//s01.mifile.cn/i/v-logo-3.png" alt="网上交易保障中心"></a>
            <a href="https://www.mi.com/service/buy/commitment/" target="_blank" data-stat-id="075070cd3386be85" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-075070cd3386be85', 'https://www.mi.com/service/buy/commitment/', 'pcpid', '']);"><img src="//i8.mifile.cn/b2c-mimall-media/ba10428a4f9495ac310fd0b5e0cf8370.png" alt="诚信经营 放心消费"></a>

        </div>
    </div>
    <div class="slogan ir">探索黑科技，小米为发烧而生</div>
</div>

<div id="J_modalWeixin" class="modal fade modal-hide modal-weixin" data-width="480" data-height="520">
    <div class="modal-hd">
        <a class="close" data-dismiss="modal" data-stat-id="a0641baa711604bc" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-a0641baa711604bc', '', 'pcpid', '']);"><i class="iconfont"></i></a>
        <span class="title">小米手机官方微信二维码</span>
    </div>
    <div class="modal-bd">
        <img alt="" src="//i1.mifile.cn/f/i/17/site/weixin.jpg" width="680" height="340">
    </div>
</div>
<!-- .modal-weixin END -->
<div class="modal modal-hide modal-bigtap-queue" id="J_bigtapQueue">
    <div class="modal-body">
        <span class="close" data-dismiss="modal" aria-hidden="true">退出排队</span>
        <div class="con">
            <div class="title">正在排队，请稍候喔！</div>
            <div class="queue-tip-box">
                <p class="queue-tip">当前人数较多，请您耐心等待，排队期间请不要关闭页面。</p>
                <p class="queue-tip">时常来官网看看，最新产品和活动信息都会在这里发布。</p>
                <p class="queue-tip">下载小米商城 App 玩玩吧！产品开售信息抢先知道。</p>
                <p class="queue-tip">发现了让你眼前一亮的小米产品，别忘了分享给朋友！</p>
                <p class="queue-tip">产品开售前会有预售信息，关注官网首页就不会错过。</p>
            </div>
        </div>

        <div class="queue-posters">
            <div class="poster poster-3"></div>
            <div class="poster poster-2"></div>
            <div class="poster poster-1"></div>
            <div class="poster poster-4"></div>
            <div class="poster poster-5"></div>
        </div>
    </div>
</div>
<!-- .xm-dm-queue END -->
<div id="J_bigtapError" class="modal modal-hide modal-bigtap-error">
    <span class="close" data-dismiss="modal" aria-hidden="true"><i class="iconfont"></i></span>
    <div class="modal-body">
        <h3>抱歉，网络拥堵无法连接服务器</h3>
        <p class="error-tip">由于访问人数太多导致服务器压力山大，请您稍后再重试。</p>
        <p>
            <a class="btn btn-primary" id="J_bigtapRetry" data-stat-id="cb61bccda6f25a90" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-cb61bccda6f25a90', '', 'pcpid', '']);">重试</a>
        </p>
    </div>
</div>


<div id="J_bigtapModeBox" class="modal fade modal-hide modal-bigtap-mode">
    <span class="close" data-dismiss="modal"><i class="iconfont"></i></span>
    <div class="modal-body">
        <h3 class="title">为防黄牛，请您输入下面的验证码</h3>
        <p class="desc">在防黄牛的路上，我们一直在努力，也知道做的还不够。<br>
            所以，这次劳烦您多输一次验证码，我们一起防黄牛。</p>
        <div class="mode-loading" id="J_bigtapModeLoading">
            <img src="//i1.mifile.cn/f/i/2014/cn/loading.gif" alt="" width="32" height="32">
            <a id="J_bigtapModeReload" class="reload  hide" href="javascript:void(0);" data-stat-id="2de5b45717f3289e" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-2de5b45717f3289e', 'javascript:void0', 'pcpid', '']);">网络错误，点击重新获取验证码！</a>
        </div>
        <div class="mode-action hide" id="J_bigtapModeAction">
            <div class="mode-con" id="J_bigtapModeContent"></div>
            <input type="text" name="bigtapmode" class="input-text" id="J_bigtapModeInput" placeholder="请输入正确的验证码">
            <p class="tip" id="J_bigtapModeTip"></p>
            <a class="btn  btn-gray" id="J_bigtapModeSubmit" data-stat-id="656c3e98016a0d8a" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-656c3e98016a0d8a', '', 'pcpid', '']);">确认</a>
        </div>
    </div>
</div>
<!-- .xm-dm-error END -->
<div id="J_modal-globalSites" class="modal fade modal-hide modal-globalSites" data-width="640">
    <div class="modal-hd">
        <a class="close" data-dismiss="modal" data-stat-id="a0641baa711604bc" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-a0641baa711604bc', '', 'pcpid', '']);"><i class="iconfont"></i></a>
        <span class="title">Select Region</span>
    </div>
    <div class="modal-bd">
        <h3>Welcome to Mi.com</h3>
        <p class="modal-globalSites-tips">Please select your country or region</p>
        <p class="modal-globalSites-links clearfix">
            <a href="//www.mi.com/index.html" data-stat-id="74f611a5becb8ab3" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-74f611a5becb8ab3', '//www.mi.com/index.html', 'pcpid', '']);">Mainland China</a>
            <a href="http://www.mi.com/hk/" data-stat-id="47b3d14243a6979a" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-47b3d14243a6979a', 'http://www.mi.com/hk/', 'pcpid', '']);">Hong Kong</a>
            <a href="http://www.mi.com/tw/" data-stat-id="39be7f7204c18e9b" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-39be7f7204c18e9b', 'http://www.mi.com/tw/', 'pcpid', '']);">Taiwan</a>
            <a href="http://www.mi.com/sg/" data-stat-id="5ee0873c1fb67784" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-5ee0873c1fb67784', 'http://www.mi.com/sg/', 'pcpid', '']);">Singapore</a>
            <a href="http://www.mi.com/my/" data-stat-id="e93c5e33550a344f" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-e93c5e33550a344f', 'http://www.mi.com/my/', 'pcpid', '']);">Malaysia</a>
            <a href="http://www.mi.com/ph/" data-stat-id="e45a28d9ba0d0713" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-e45a28d9ba0d0713', 'http://www.mi.com/ph/', 'pcpid', '']);">Philippines</a>
            <a href="http://www.mi.com/in/" data-stat-id="4914aa83e2235b58" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-4914aa83e2235b58', 'http://www.mi.com/in/', 'pcpid', '']);">India</a>
            <a href="http://www.mi.com/id/" data-stat-id="1037d12663c03979" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-1037d12663c03979', 'http://www.mi.com/id/', 'pcpid', '']);">Indonesia</a>
            <a href="http://www.mi.com/en/" data-stat-id="2b5abd6d146e925a" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-2b5abd6d146e925a', 'http://www.mi.com/en/', 'pcpid', '']);">Global Home</a>
            <a href="http://www.mi.com/mena/" data-stat-id="8fe286560458efa1" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-8fe286560458efa1', 'http://www.mi.com/mena/', 'pcpid', '']);">MENA</a>
            <a href="http://www.mi.com/pl/" data-stat-id="599097ab645a3dee" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-599097ab645a3dee', 'http://www.mi.com/pl/', 'pcpid', '']);">Poland</a>
            <a href="http://www.mi.com/ua/" data-stat-id="562a0a3540bd58a0" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-562a0a3540bd58a0', 'http://www.mi.com/ua/', 'pcpid', '']);">Ukraine</a>
            <a href="http://www.mi.com/ru/" data-stat-id="a8f64f35eccfdc67" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-a8f64f35eccfdc67', 'http://www.mi.com/ru/', 'pcpid', '']);">Russia</a>
            <a href="http://www.mi.com/vn/" data-stat-id="d2f24ed05c04b923" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-d2f24ed05c04b923', 'http://www.mi.com/vn/', 'pcpid', '']);">Vietnam</a>
            <a href="http://www.mi.com/mx/" data-stat-id="0af2c5d87190c841" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-0af2c5d87190c841', 'http://www.mi.com/mx/', 'pcpid', '']);">Mexico</a>
            <a href="http://www.mi.com/kr/" data-stat-id="f0f92536e4022f1c" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-f0f92536e4022f1c', 'http://www.mi.com/kr/', 'pcpid', '']);">Korea</a>
            <a href="http://www.mi.com/eg/" data-stat-id="e974a186941b1b29" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-e974a186941b1b29', 'http://www.mi.com/eg/', 'pcpid', '']);">Egypt</a>
            <a href="http://www.mi.com/th/" data-stat-id="4a40945e55b35c2d" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-4a40945e55b35c2d', 'http://www.mi.com/th/', 'pcpid', '']);">Thailand</a>
            <a href="http://www.mi.com/es/" data-stat-id="c22e48c1e9ab2f2e" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-c22e48c1e9ab2f2e', 'http://www.mi.com/es/', 'pcpid', '']);">Spain</a>
            <a href="http://www.mi.com/us/" data-stat-id="bed3d0d0411856ce" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-bed3d0d0411856ce', 'http://www.mi.com/us/', 'pcpid', '']);">United States</a>
        </p>
    </div>
</div>
<!-- .modal-globalSites END -->



<script src="//s01.mifile.cn/js/base.min.js?v2017122601"></script>

<%--
<script>
    (function() {
        MI.namespace('GLOBAL_CONFIG');
        MI.GLOBAL_CONFIG = {
            orderSite: 'https://order.mi.com',
            wwwSite: '//www.mi.com',
            cartSite: '//cart.mi.com',
            itemSite: '//item.mi.com',
            assetsSite: '//s01.mifile.cn',
            listSite: '//list.mi.com',
            searchSite: '//search.mi.com',
            mySite: '//my.mi.com',
            damiaoSite: 'https://tp.hd.mi.com/',
            damiaoGoodsId:[],
            logoutUrl: 'https://order.mi.com/site/logout',
            staticSite: '//static.mi.com',
            quickLoginUrl: 'https://account.xiaomi.com/pass/static/login.html'
        };
        MI.setLoginInfo.orderUrl = MI.GLOBAL_CONFIG.orderSite + '/user/order';
        MI.setLoginInfo.logoutUrl = MI.GLOBAL_CONFIG.logoutUrl;
        MI.setLoginInfo.init(MI.GLOBAL_CONFIG);
        MI.miniCart.init();
        //MI.updateMiniCart();
    })();
</script>



<script>
    var _msq = _msq || [];
    _msq.push(['setDomainId', 100]);
    _msq.push(['trackPageView']);
    (function() {
        var ms = document.createElement('script');
        ms.type = 'text/javascript';
        ms.async = true;
        ms.src = '//s1.mi.com/stat/18/xmst.js';
        var s = document.getElementsByTagName('script')[0];
        s.parentNode.insertBefore(ms, s);
    })();
</script>
--%>
<script type="text/javascript" src="//s01.mifile.cn/js/checkout.min.js?v=2019012501"></script>



<div id="J_agreeModal" class="modal fade modal-agree in modal-hide"> <div class="modal-hd"> <a class="close J_close" data-dismiss="modal" data-stat-id="a0641baa711604bc" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-a0641baa711604bc', '', 'pcpid', '']);"><i class="iconfont"></i></a> <h3>小米商城协议更新</h3> </div> <div class="modal-body"> <div class="desc"></div> <div class="con">  </div>  </div>  <div class="modal-ft"> <div class="actions"> <button class="btn btn-line-gray J_close" data-dismiss="modal">不同意</button> <button class="btn btn-primary J_sure">同意</button> </div> </div></div>	        <div class="modal modal-hide fade modal-edit-address" id="J_modalEditAddress">
    <div class="modal-header">
        <span class="title">添加收货地址</span>
        <a class="close" data-dismiss="modal" href="javascript: void(0);" data-stat-id="d4b65cafe609c9e2" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-d4b65cafe609c9e2', 'javascript:void0', 'pcpid', '']);"><i class="iconfont"></i></a>
    </div>
    <div class="modal-body">
        <div class="form-box clearfix">
            <div class="form-section form-name form-section-valid">
                <label class="input-label" for="user_name">姓名</label>
                <input class="input-text J_addressInput" type="text" id="J_addressNameInput" name="user_name" placeholder="收货人姓名">
            </div>
            <div class="form-section form-phone form-section-valid">
                <label class="input-label" for="user_phone">手机号</label>
                <input class="input-text J_addressInput" type="text" id="J_addressPhoneInput" name="user_phone" placeholder="11位手机号">
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
        <a href="javascript:void(0);" class="btn btn-primary" id="J_editAddressSave" data-stat-id="2663a0ca2c98bc0e" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-2663a0ca2c98bc0e', 'javascript:void0', 'pcpid', '']);">保存</a>
        <a href="#J_modalEditAddress" class="btn btn-gray" data-toggle="modal" data-stat-id="214463e29b606824" onclick="_msq.push(['trackEvent', '17a1f380b9d4cd2e-214463e29b606824', '#J_modalEditAddress', 'pcpid', '']);">取消</a>
    </div>
</div><iframe name="MiPROXY_hd" src="//i.huodong.mi.com/user/proxy/stop/1" style="width: 0px; height: 0px; border: 0px; overflow: hidden; position: absolute; top: -1000px;">

</iframe>
<script>
    console.log(1);
    $('#J_addressTopBar').hide();
    $('#J_newAddress').click(addNewAddress);
    function addNewAddress(){
        console.log(2);
        $('#J_modalEditAddress').addClass('in');
        $('.form-box').children('div').eq(0).addClass('form-section-valid');
        $('#J_modalEditAddress').attr('aria-hidden',false);
        $('#J_modalEditAddress').attr('style','display: block;');
    }
</script>
</body>
</html>
