<%--
  Created by IntelliJ IDEA.
  User: 任章哲
  Date: 2019/2/24
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <script type="text/javascript" src="assets/vendor/jquery/jquery.min.js" ></script>
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
            <div class="gouwuche fr"><a href="">购物车</a></div>
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
    <a href="./index.html" target="_blank"><div class="logo fl"></div></a>
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
<div class="banner_y center">
    <div class="nav">
        <ul>
            <li class="Li">
                <a href="">手机    <i class="iconfont"></i>
                </a>
                <div class="pop" style="display:none">
                    <div class="left fl">

                    </div>
                    <div class="ctn fl">

                    </div>
                    <div class="right fl">

                    </div>
                    <div class="clear"></div>
                </div>
            </li>
            <li class="Li">
                <a href="">笔记本</a>
                <div class="pop" style="display: none">
                    <div class="left fl">

                    </div>
                    <div class="ctn fl">

                    </div>
                    <div class="right fl">

                    </div>
                    <div class="clear"></div>
                </div>
            </li>
            <li class="Li">
                <a href="">电视</a>
                <div class="pop" style="display: none">
                    <div class="left fl">

                    </div>
                    <div class="ctn fl">

                    </div>
                    <div class="right fl">

                    </div>
                    <div class="clear"></div>
                </div>
            </li>
            <li class="Li">
                <a href="">智能硬件</a>
                <div class="pop" style="display: none">
                    <div class="left fl">

                    </div>
                    <div class="ctn fl">

                    </div>
                    <div class="right fl">

                    </div>
                    <div class="clear"></div>
                </div>
            </li>
            <li class="Li">
                <a href="">移动电源</a>
                <div class="pop" style="display: none">
                    <div class="left fl">

                    </div>
                    <div class="ctn fl">

                    </div>
                    <div class="right fl">

                    </div>
                    <div class="clear"></div>
                </div>
            </li>
            <li class="Li">
                <a href="">耳机</a>
                <div class="pop" style="display: none">
                    <div class="left fl">

                    </div>
                    <div class="ctn fl">

                    </div>
                    <div class="right fl">

                    </div>
                    <div class="clear"></div>
                </div>
            </li>
            <li class="Li">
                <a href="">保护套</a>
                <div class="pop" style="display: none">
                    <div class="left fl">

                    </div>
                    <div class="ctn fl">

                    </div>
                    <div class="right fl">

                    </div>
                    <div class="clear"></div>
                </div>
            </li>
            <li class="Li">
                <a href="">储存卡</a>
                <div class="pop" style="display: none">
                    <div class="left fl">

                    </div>
                    <div class="ctn fl">

                    </div>
                    <div class="right fl">

                    </div>
                    <div class="clear"></div>
                </div>
            </li>
            <li class="Li">
                <a href="">眼镜</a>
                <div class="pop" style="display: none">
                    <div class="left fl">

                    </div>
                    <div class="ctn fl">

                    </div>

                    <div class="right fl">

                    </div>
                    <div class="clear"></div>
                </div>
            </li>
            <li class="Li">
                <a href="">生活周边</a>
                <div class="pop" style="display: none">
                    <div class="left fl">

                    </div>
                    <div class="ctn fl">

                    </div>
                    <div class="right fl">

                    </div>
                    <div class="clear"></div>
                </div>
            </li>
        </ul>
    </div>
</div>

<div class="sub_banner center">
    <div class="sidebar fl">
        <div class="fl"><a href=""><img src=""></a></div>
        <div class="fl"><a href=""><img src=""></a></div>
        <div class="fl"><a href=""><img src=""></a></div>
        <div class="fl"><a href=""><img src=""></a></div>
        <div class="fl"><a href=""><img src=""></a></div>
        <div class="fl"><a href=""><img src=""></a></div>
        <div class="clear"></div>
    </div>
    <div class="datu fl"><a href=""><img src="" alt=""></a></div><%--src="assets/image/hongmi4x.png"--%>
    <div class="datu fl"><a href=""><img src="" alt=""></a></div><%--src="assets/image/xiaomi5.jpg"--%>
    <div class="datu fr"><a href=""><img src="" alt=""></a></div><%--assets/image/pinghengche.jpg--%>
    <div class="clear"></div>


</div>
<!-- end banner -->
<div class="tlinks">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>

<!-- start danpin -->
<div class="danpin center">
    <div class="biaoti center"></div>
    <div class="main center">

        <div class="clear"></div>
    </div>

</div>
<div class="peijian w">
    <div class="biaoti center">配件</div>
    <div class="main center">
        <div class="content">
            <div class="remen fl"><a href=""><img src="" height="300px" width="234px"></a><%--assets/image/peijian1.jpg--%>
            </div>
            <div class="remen com fl">
                <div class="xinpin"><span></span></div>
                <div class="tu"><a href=""><img src=""></a></div>
                <div class="miaoshu"><a href=""></a></div>
                <div class="pingjia"></div>
                <div class="jiage"></div>
                <div class="piao">
                    <a href="">
                        <span></span>
                    </a>
                </div>
            </div>
            <div class="remen com fl">
                <div class="xinpin"><span style="background:#fff"></span></div>
                <div class="tu"><a href=""><img src=""></a></div>
                <div class="miaoshu"><a href="">  </a></div>
                <div class="pingjia"></div>
                <div class="jiage"></div>
            </div>
            <div class="remen com fl">
                <div class="xinpin"><span style="background:red">享6折</span></div>
                <div class="tu"><a href=""><img src=""></a></div>
                <div class="miaoshu"><a href="">  </a></div>
                <div class="pingjia"></div>
                <div class="jiage"></div>
                <div class="piao">
                    <a href="">
                        <span></span>
                        <span>最新评价</span>
                    </a>
                </div>
            </div>
            <div class="remen com fl">
                <div class="xinpin"><span style="background:#fff"></span></div>
                <div class="tu"><a href=""><img src=""></a></div>
                <div class="miaoshu"><a href=""></a></div>
                <div class="pingjia"></div>
                <div class="jiage"></div>
                <div class="piao">
                    <a href="">
                        <span></span>
                    </a>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="content">
            <div class="remen fl"><a href=""><img src="" height="300px" width="234px"></a><%--assets/image/peijian6.png--%>
            </div>
            <div class="remen com fl">
                <div class="xinpin"><span style="background:#fff"></span></div>
                <div class="tu"><a href=""><img src=""></a></div>
                <div class="miaoshu"><a href=""></a></div>
                <div class="pingjia"></div>
                <div class="jiage"></div>
                <div class="piao">
                    <a href="">
                        <span></span>
                    </a>
                </div>
            </div>
            <div class="remen com fl">
                <div class="xinpin"><span style="background:#fff"></span></div>
                <div class="tu"><a href=""><img src=""></a></div>
                <div class="miaoshu"><a href=""></a></div>
                <div class="pingjia"></div>
                <div class="jiage"></div>
            </div>
            <div class="remen com fl">
                <div class="xinpin"><span style="background:#fff"></span></div>
                <div class="tu"><a href=""><img src=""></a></div>
                <div class="miaoshu"><a href=""> </a></div>
                <div class="pingjia"></div>
                <div class="jiage"></div>
            </div>
            <div class="remenlast fr">
                <div class="hongmi"><a href=""><img src="" alt=""></a></div>
                <div class="liulangengduo"><a href=""><img src="" alt=""></a></div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
<footer class="mt20 center">
    <div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
    <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
    <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
</footer>
</body>
<script>
    var i=1;

    function init(){
        //创建一个定时器
        setInterval(changeImage,3000);
    }

    function changeImage(){
        //获取图片元
        var imgObj = $(".banner_y");
        imgObj.css("background","url(assets/image/"+i+".jpg)");
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
    var children = '<div>'+
    '<div class="xuangou_left fl">'+
        '<a href="">'+
        '<div class="img fl"><img src="Src" alt=""></div>'+
        '<span class="fl">Name</span>'+
        '<div class="clear"></div>'+
        '</a>'+
        '</div>'+
    '<div class="clear"></div>'+
        '</div>';

    function showList(){
        $(this).find('div[class="pop"]').attr('style',"display: block");
        var thiss = $(this);
        //加载分类的子分类
        var url = "/product/index/getMainCategory";
        var data =  {
           pid:$(this).data('id')
        };
        $.getJSON(url,data,function(result){
            $('.banner_y').find('div[class="left fl"]').empty();
            $('.banner_y').find('div[class="ctn fl"]').empty();
            $('.banner_y').find('div[class="right fl"]').empty();

            for(var i=0;i<result.data.length;i++){
                  if(i<6){
                      //加载到<div class="left fl">底下
                      var childrens = children.replace('Src',result.data[i].image).replace('Name',result.data[i].name);
                      var li = $(childrens);
                      thiss.find('div[class="left fl"]').append(li);
                  }
                  if(i<12&&i>5){
                      //加载到<div class="ctn fl">底下
                      var childrens = children.replace('Src',result.data[i].image).replace('Name',result.data[i].name);
                      var li = $(childrens);
                      thiss.find('div[class="ctn fl"]').append(li);
                  }
                  if(i>11&&i<18){
                      //加载到<div class="right fl">底下
                      var childrens = children.replace('Src',result.data[i].image).replace('Name',result.data[i].name);
                      var li = $(childrens);
                      thiss.find('div[class="right fl"]').append(li);
                  }
                  if(i>=18){
                      //加载不下
                  }
              }
        });
    }
    function hideList(){
        $('.banner_y').find('div[class="pop"]').attr('style',"display: none");
    }
    //获取分类列表
    var url = "/product/index/getMainCategory";
    var data = {
       pid:1
    };
    $.getJSON(url,data,function(result){
        for(var i=0;i<result.data.length;i++){
            //console.log(result.data[i].id);
            $('.banner_y').find('li').eq(i).data('id',result.data[i].id);
            $('.banner_y').find('li').eq(i).children('a').eq(0).text(result.data[i].name);
        }
    });

    //category_id=8:加载轮播图下面的图片
    //category_id=32:加载6个黑色框
    //category_id=33:加载小米明星单品
    //category_id=34:加载配件的8个商品
    //category_id=35:加载配件的2个广告图
    //获取轮播图
    var url ="/product/index/getSlidePicture";
    var data ={
        category_id:8
    }
    $.getJSON(url,data,function(result){
        for(var i=0;i<result.data.length;i++){
            $('.sub_banner').children('div').eq(i+1).find('img').attr('src',result.data[i].pic);
            $('.sub_banner').children('div').eq(i+1).find('a').attr('href',result.data[i].url);
        }
        //console.log(result);
    });
    //获取轮播图左边广告
    var data = {
        category_id:32
    };
    $.getJSON(url,data,function(result){
        for(var i=0;i<result.data.length;i++){
            $('.sub_banner').children('div').eq(0).children('div').eq(i).find('img').attr('src',result.data[i].pic);
            $('.sub_banner').children('div').eq(0).children('div').eq(i).find('a').attr('href',result.data[i].url);
        }

    });
    //获取配件的2个广告图
    var data ={
        category_id:35
    };
    $.getJSON(url,data,function(result){
        for(var i=0;i<result.data.length;i++){
            $('.peijian').find('div[class="main center"]').children('div').eq(i).children('div').eq(0).find('img').attr('src',result.data[i].pic);
            $('.peijian').find('div[class="main center"]').children('div').eq(i).children('div').eq(0).find('a').attr('href',result.data[i].url);
        }

    });
    //获取配件的7个商品列表
    var data = {
        category_id:34
    };
    $.getJSON(url,data,function(result){

        for(var i=0;i<result.data.length;i++){
            $('.peijian').find('div[class="remen com fl"]').eq(i).find('img').attr('src',result.data[i].pic);
            $('.peijian').find('div[class="remen com fl"]').eq(i).find('a').attr('href',result.data[i].url);
            $('.peijian').find('div[class="remen com fl"]').eq(i).find('div[class="miaoshu"]').find('a').text(result.data[i].title);
            $('.peijian').find('div[class="remen com fl"]').eq(i).find('div[class="pingjia"]').text(result.data[i].subTitle);
            $('.peijian').find('div[class="remen com fl"]').eq(i).find('div[class="jiage"]').text(result.data[i].titleDesc);
            $('.peijian').find('div[class="remen com fl"]').eq(i).find('div[class="piao"]').children('a').find('span').eq(0).text(result.data[i].content);

        }
    })
    //加载网页浏览更多
    var data ={
        category_id:36
    };
    $.getJSON(url,data,function(result){
        for(var i=0;i<result.data.length;i++){
            $('.peijian').find('div[class="remenlast fr"]').children('div').eq(i).find('img').attr('src',result.data[i].pic);
            $('.peijian').find('div[class="remenlast fr"]').children('div').eq(i).find('a').attr('href',result.data[i].url);
        }
        //console.log(result);
    });
    //加载列表一
    var data = {
        category_id:33
    };
    $.getJSON(url,data,function(result){
        $('.danpin').children().eq(0).text(result.data[0].titleDesc);
        for(var i=0;i<result.data.length;i++){
            var r = t.replace("TitleDesc",result.data[i].titleDesc).replace("Title",result.data[i].title).replace("SubTitle",result.data[i].subTitle).replace("Content",result.data[i].content).replace("SRC",result.data[i].pic);
            var temple = $(r);
            $('.danpin').find('.main').append(temple);
        }
    });


    var t =
        '<div class="mingxing fl">'+
        '<div class="sub_mingxing"><a href=""><img src="SRC" alt=""></a></div>'+
    '<div class="pinpai"><a href="">Title</a></div>'+
    '<div class="youhui">SubTitle</div>'+
    '<div class="jiage">Content</div>'+
    '</div>';


</script>
</html>
