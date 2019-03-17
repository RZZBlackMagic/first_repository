<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
    <title>小米商城</title>
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <!--导入font-awesome-->
    <link rel="stylesheet" href="assets/css/font-awesome.min.css"/>
    <!--导入jquery.js-->
    <script type="text/javascript" src="assets/vendor/jquery/jquery.js" ></script>
    <!--导入bootstrap.js-->
    <script type="text/javascript" src="assets/vendor/bootstrap/js/bootstrap.js" ></script>
</head>
<body onload="init()">
<!-- start header -->
<header>
    <div class="top center">
        <div class="left fl">
            <ul>
                <li><a href="http://www.mi.com/" target="_blank">小米商城</a></li>
                <li>|</li>
                <li><a href="">MIUI</a></li>
                <li>|</li>
                <li><a href="">米聊</a></li>
                <li>|</li>
                <li><a href="">游戏</a></li>
                <li>|</li>
                <li><a href="">多看阅读</a></li>
                <li>|</li>
                <li><a href="">云服务</a></li>
                <li>|</li>
                <li><a href="">金融</a></li>
                <li>|</li>
                <li><a href="">小米商城移动版</a></li>
                <li>|</li>
                <li><a href="">问题反馈</a></li>
                <li>|</li>
                <li><a href="">Select Region</a></li>
                <div class="clear"></div>
            </ul>
        </div>
        <div class="right fr">
            <div class="gouwuche fr"><a href="/cart.html">购物车</a></div>
            <div class="fr">
                <ul>
                    <li><a href="./login.html" target="_blank">登录</a></li>
                    <li>|</li>
                    <li><a href="./register.html" target="_blank" >注册</a></li>
                    <li>|</li>
                    <li><a href="">消息通知</a></li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
</header>
<!--end header -->

<!-- start banner_x -->
<div class="banner_x center">
    <a href="/" target="_blank"><div class="logo fl"></div></a>
    <a href=""><div class="ad_top fl"></div></a>
    <div class="nav fl">
        <ul>
            <li><a href="./liebiao.html" target="_blank">小米手机</a></li>
            <li><a href="">红米</a></li>
            <li><a href="">平板·笔记本</a></li>
            <li><a href="">电视</a></li>
            <li><a href="">盒子·影音</a></li>
            <li><a href="">路由器</a></li>
            <li><a href="">智能硬件</a></li>
            <li><a href="">服务</a></li>
            <li><a href="">社区</a></li>
        </ul>
    </div>
    <div class="search fr">
            <div class="text fl">
                <input type="text" id="input" class="shuru"  placeholder="小米6&nbsp;小米MIX现货">
            </div>
            <div class="submit fl">
                <input type="submit" id="searchCom" class="sousuo" value="搜索"/>
            </div>
            <div class="clear"></div>
        <div class="clear"></div>
    </div>
</div>
<!-- end banner_x -->

<!-- start banner_y -->
<div class="banner_y center" >
    <div class="nav">
        <ul>
            <c:forEach items="${slide}" var="item">
                <li class="Li">
                    <a href="">${item.key}</a>
                    <div class="pop" style="display:none">
                        <div class="left fl">
                            <c:forEach items="${item.value}" var="i" begin="0" end="${fn:length(item.value) > 6 ? 5 : fn:length(item.value)}">
                                <div>
                                    <div class="xuangou_left fl">
                                        <a>
                                            <div class="img fl">
                                                <img src="${i.image}">
                                            </div>
                                            <span class="fl">${i.name}</span>
                                            <div class="clear"></div>
                                        </a>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="ctn fl">
                            <c:if test="${fn:length(item.value) > 6}">
                                <c:forEach items="${item.value}" var="i" begin="6" end="${fn:length(item.value) > 12 ? 11 : fn:length(item.value)}">
                                    <div>
                                        <div class="xuangou_left fl">
                                            <a>
                                                <div class="img fl">
                                                    <img src="${i.image}">
                                                </div>
                                                <span class="fl">${i.name}</span>
                                                <div class="clear"></div>
                                            </a>
                                        </div>
                                        <div class="clear"></div>
                                    </div>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div class="right fl">
                            <c:if test="${fn:length(item.value) > 12}">
                                <c:forEach items="${item.value}" var="i" begin="12" end="${fn:length(item.value) > 18 ? 17 : fn:length(item.value)}">
                                    <div>
                                        <div class="xuangou_left fl">
                                            <a>
                                                <div class="img fl">
                                                    <img src="${i.image}">
                                                </div>
                                                <span class="fl">${i.name}</span>
                                                <div class="clear"></div>
                                            </a>
                                        </div>
                                        <div class="clear"></div>
                                    </div>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div class="clear"></div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

<div class="sub_banner center">
    <div class="sidebar fl">
        <c:forEach items="${adv.left_adv}" var="item">
            <div class="fl"><a><img src="${item.pic}"></a></div>
        </c:forEach>
        <div class="clear"></div>
    </div>
    <c:forEach items="${adv.right_adv}" var="item">
        <div class="datu fl"><a><img src="${item.pic}"></a></div>
    </c:forEach>
    <div class="clear"></div>
</div>
<!-- end banner -->

<!-- start danpin -->
<c:forEach items="${hot}" var="item">
    <div class="danpin center">
        <div class="biaoti center">${item.key}</div>
        <div class="main center">
            <c:forEach items="${item.value}" var="i">
                <div class="mingxing fl">
                    <div class="sub_mingxing"><a href="${i.url}"><img src="${i.pic}"></a></div>
                    <div class="pinpai"><a href="">${i.title}</a></div>
                    <div class="youhui">${i.titleDesc}</div>
                    <div class="jiage">${i.content}</div>
                </div>
            </c:forEach>
            <div class="clear"></div>
        </div>
    </div>
</c:forEach>

<c:forEach items="${recommend}" var="item" varStatus="status">
    <div class="peijian w">
        <div class="biaoti center">${item.key}</div>
        <div class="main center">
            <div class="content">
                <c:forEach items="${item.value}" var="i" begin="0" end="${fn:length(item.value) > 5 ? 4 : fn:length(item.value)}">
                    <div class="remen com fl">
                        <%--<div class="xinpin"><span style="background:red">享6折</span></div>--%>
                        <div class="tu"><a><img src="${i.pic}"></a></div>
                        <div class="miaoshu"><a href="">${i.title}</a></div>
                        <div class="pingjia">${i.subTitle}</div>
                        <div class="jiage">${i.titleDesc}</div>
                        <div class="piao">
                            <a href="">
                                <span>${i.content}</span>
                            </a>
                        </div>
                    </div>
                </c:forEach>
                <div class="clear"></div>
            </div>
            <c:if test="${fn:length(item.value) > 5}">
            <div class="content">
                <c:forEach items="${item.value}" var="i" begin="5" end="${fn:length(item.value) > 11 ? 10 : fn:length(item.value)}">
                    <div class="remen com fl">
                        <%--<div class="xinpin"><span style="background:#fff"></span></div>--%>
                        <div class="tu"><a><img src="${i.pic}"></a></div>
                        <div class="miaoshu"><a href="">${i.title}</a></div>
                        <div class="pingjia">${i.subTitle}</div>
                        <div class="jiage">${i.titleDesc}</div>
                        <div class="piao">
                            <a href="">
                                <span>${i.content}</span>
                            </a>
                        </div>
                    </div>
                </c:forEach>
                <c:if test="${fn:length(item.value) >= 11}">
                    <div class="remenlast fr">
                        <c:if test="${status.index == 9}">
                            <div class="hongmi"><a href=""><img src="${item.value[9].pic}"></a></div>
                        </c:if>
                        <c:if test="${status.index == 10}">
                            <div class="liulangengduo"><a href=""><img src="${item.value[10].pic}"></a></div>
                        </c:if>
                    </div>
                </c:if>
                <div class="clear"></div>
            </div>
            </c:if>
        </div>
    </div>
</c:forEach>

<footer class="mt20 center">
    <div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
    <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
    <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
</footer>
</body>
<script>
    var i=1;
    var picture = new Array(3);
    var href = new Array(3);
    function init(){
        //轮播图列表
        $.getJSON("/portal/index/getSlidePicture", function(result){
            for(var i=0;i<3;i++){
                picture[i] = result.data[i]["pic"];
                href[i] = result.data[i].url;
            }

            setInterval(transfrom,6000);
        });
        //创建一个定时器
    }
    function transfrom(){
        return changeImage(picture,href);
    }
    function changeImage(picture,href){

        var imgObj = $(".banner_y");
        imgObj.attr('style','background: url('+picture[i-1]+');');
        imgObj.click(function(){
            window.location=(href[i-1]);
        });
        i++;
        if(i >= 4){
            i=1;
        }

    }

    //搜索框
    $('#searchCom').click(function(){
        console.log("点击事件");
    });
    //回车事件
    $(document).keypress(function(e) {
        // 回车键事件
        if(e.which == 13) {
            console.log("回车事件");
        }
    });
    //定义鼠标移动事件
    for(var i=0;i<10;i++){
        $('.banner_y').find('ul').children('li').eq(i).hover(showList,hideList);
    }
    function showList(){
        $(this).find('div[class="pop"]').attr('style',"display: block");
    }
    function hideList(){
        $('.banner_y').find('div[class="pop"]').attr('style',"display: none");
    }

</script>
</html>
