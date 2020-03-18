<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>学生页面</title>
    <script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
   	<style>
        *{
            margin:0;
            padding:0;
        }
        html,body{
            width:100%;
            height: 100%;
            overflow-y: hidden;
            font-family:Helvetica,Arial,sans-serif;
            text-rendering:optimizeLegibility;
            box-sizing: border-box;
        }
        ul{list-style: none;}
        a{text-decoration: none; color: #000000;}
        header {
            width: 100%;
            background: rgb(255, 255, 255);
            border-bottom: 2px solid #848484;
        }
        header::after{
            content:'';clear:both;display: block;
        }
        header .left-header{
            /* background-color: #fff; */
            padding: 20px;
            float: left;
        }
        header .logo{
            height: 50px;
        }
        header .center-header{
            height:50px;
            padding: 20px;
            padding-left: 380px;
            float:left;
            text-align: center;
            line-height: 50px;
        }
        header span{
            font-size: 1.5rem;
            color: #0d669b;
            /* font-weight: bold; */
        }
        header .right-header{
            height:50px;
            padding: 20px 100px;
            float: right;
            text-align: center;
            line-height: 50px;
        }
        header .right-header .logout{
            font-size: 1rem;
            color: #848484;
            text-decoration: none;
        }

        #menu{
            float: left;
            width: 200px;
            background-color: #393939;
            height: 100%;
        }
        #menu ul{
            color: #999999;
            text-align: center;

        }
        #menu li{
            height: 140px;
            border-bottom: 1px solid #393939;
            border-top: 1px solid #424242;
        }
        #menu li.active{
            color:white;
            background-color: #424242;
        }
        #menu a{
            color: inherit;
            width: 100%;
            height: 100%;
            display: block;
            padding-top: 45px;
            box-sizing: border-box;
        }
        #menu p{
            margin-top: 15px;
        }

        #main {
            overflow: hidden;
            height:calc(100% - 98px);
            width: calc(100% - 200px);
        }
        #main .main-container{
            height: 100%;
            width: 100%;
            overflow: auto;
        }
        #main .main-container #title{
            padding: 15px 0px 0px 20px;
        }
        #main .main-container #title .title-text{
            font-size: 18px;
            color: #333333;
            letter-spacing: 3px;
        }
        #main .main-container #title .course-box{
            margin-top: 20px;
        }
        #main .main-container #title .course-box label{
            float: left;
            line-height: 40px;
            margin-right: 15px;
        }
        #main .main-container #title .course-box #course{
            width: 20%;
            height: 40px;
            border-radius: 5px;
            background-color: #eff2f3;
            padding-left: 15px;
            border: none;
            float: left;
        }
        #main .main-container #title .submit-box{
            margin-left: 20px;
            float: left;
        }
        #main .main-container #title .submit-box button{
            text-align: center;
            line-height: 40px;
            width: 100px;
            border-radius: 5px;
            font-size: 1rem;
            border: none;
            background-color: #0d669b;
            color: white;
            cursor: pointer;
        }
        #title form::after{
            content:'';clear:both;display: block;
        }

        #main #list{
            margin: 40px 20px 20px 20px;
            width: 2200px;
            overflow: hidden;
        }
        #main #list .jilu-table{
            width: 100%;
            overflow: hidden;
            border: 1px solid #848484;
            font-size: 12px;
            border-collapse: collapse;
        }
        #main #list .jilu-table tr{
            height: 32px;
            border-bottom: 1px solid #848484;
        }
        #main #list .jilu-table tr:hover{background-color: #f1f9fc;}
        #main #list .jilu-table th{
            border-right: 1px solid #848484;
            color: #666666;
            font-weight: normal;
            text-align: left;
            text-indent: 12px;
            background-color: #f1f9fc;
        }
        #main #list .jilu-table th .jilu-times{
            width:40px;
        }
        #main #list .jilu-table td{
            text-indent: 12px;
        }
        #main #list .jilu-table td .yes,.no{
            height:20px;
        }
    </style>
</head>

<body>
    <header>
        <div class="left-header">
            <img src="<%=basePath%>/images/logo01.jpg" class="logo" >
        </div>
        <div class="center-header">
            <span>统</span>
            <span>计</span>
            <span>空</span>
            <span>间</span>
        </div>
        <div class="right-header">
            <a href="/mongod/index" class="logout">退出</a>
        </div>
    </header>

    <aside id="menu">
        <ul>
            <li class="active">    
                <a href="#">
                    <p>考勤统计</p>
                </a>
            </li>
        </ul>
        
    </aside>

    <div id="main">
        <section class="main-container">
            <section id="title">
                <div class="title-text">
                    <h2>考勤记录信息列表</h2>
                </div>
                <!-- <form action="#" method="post">
                    <div class="course-box">
                        <label for="course">选择课程:</label>
                        <select name="course" id="course">
                            <option value="all" selected>所有课程</option>
                            <option value="course_1">课程1</option>
                        </select>
                    </div>
                    <div class="submit-box">
                        <button type="submit">确定</button>
                    </div>
                </form> -->
            </section>
            <section id="list">
                <table class="jilu-table">
                    <thead>
                        <tr>
                            <th width="170">课程</th>
                            <th width="130">老师</th>
                            <th class="jilu-times">1</th>
                            <th class="jilu-times">2</th>
                            <th class="jilu-times">3</th>
                            <th class="jilu-times">4</th>
                            <th class="jilu-times">5</th>
                            <th class="jilu-times">6</th>
                            <th class="jilu-times">7</th>
                            <th class="jilu-times">8</th>
                            <th class="jilu-times">9</th>
                            <th class="jilu-times">10</th>
                            <th class="jilu-times">11</th>
                            <th class="jilu-times">12</th>
                            <th class="jilu-times">13</th>
                            <th class="jilu-times">14</th>
                            <th class="jilu-times">15</th>
                            <th class="jilu-times">16</th>
                            <th class="jilu-times">17</th>
                            <th class="jilu-times">18</th>
                            <th class="jilu-times">19</th>
                            <th class="jilu-times">20</th>
                            <th class="jilu-times">21</th>
                            <th class="jilu-times">22</th>
                            <th class="jilu-times">23</th>
                            <th class="jilu-times">24</th>
                            <th class="jilu-times">25</th>
                            <th class="jilu-times">26</th>
                            <th class="jilu-times">27</th>
                            <th class="jilu-times">28</th>
                            <th class="jilu-times">29</th>
                            <th class="jilu-times">30</th>
                            <th class="jilu-times">31</th>
                            <th class="jilu-times">32</th>
                            <th class="jilu-times">33</th>
                            <th class="jilu-times">34</th>
                            <th class="jilu-times">35</th>
                            <th class="jilu-times">36</th>
                            <th class="jilu-times">37</th>
                            <th class="jilu-times">38</th>
                            <th class="jilu-times">39</th>
                            <th class="jilu-times">40</th>
                            <th class="jilu-times">41</th>
                            <th class="jilu-times">42</th>
                            <th class="jilu-times">43</th>
                            <th class="jilu-times">44</th>
                            <th class="jilu-times">45</th>
                            <th class="jilu-times">46</th>
                            <th class="jilu-times">47</th>
                            <th class="jilu-times">48</th>
                            <th class="jilu-times">49</th>
                            <th class="jilu-times">50</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach items="${requestScope.attendance1Info}" var="attendance1">
	                        <tr>
	                            <td>${attendance1.coursename}</td>
	                            <td>${attendance1.teachername}</td>
	                            <c:forEach items="${attendance1.statelist}" var="state">
	                            	<c:if test="${state=='已签到'}">
	                            		<td><img src="<%=basePath%>/images/icon.png" class="yes"></td>
									</c:if>
									<c:if test="${state=='未签到'}">
	                            		<td><img src="<%=basePath%>/images/icon1.png" class="no"></td>
									</c:if>
	                            </c:forEach> 
	                        </tr>
                   		 </c:forEach>   
                    </tbody>
                </table>
            </section>
        </section>

    </div>
</body>
</html>