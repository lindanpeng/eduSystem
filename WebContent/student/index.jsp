<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<script type="text/javascript" src="/eduSystem/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
function getCurriculum(){
	$("#main-content").load("curriculum.jsp");
}
function getNotice() {
	$("#main-content").load("../include/noticeContent.jsp");
}
function getInfo(){
$("#main-content").load("info.jsp");
}
function courselist(){
	$("#main-content").load("courselist.jsp");
}
function selectedlist(){
	$("#main-content").load("selectedlist.jsp");
}
function getScore(){
	$("#main-content").load("scorelist.jsp");
}
function findPass(){
$("#main-content").load("findPass.jsp");
}
$(document).ready(function(){
	$(".hover ul li").hover(function(){
		$(this).children("dl").slideDown(300)
	}, function(){
		$(this).children("dl").slideUp(100)
	});
	});
</script>
<link type="text/css" rel="stylesheet" href="../css/header.css"/>
<style type="text/css">
* {
   font-family:微软雅黑,雅黑;
	margin:0;
	padding:0;
}
#container{   
    width:1000px;
     margin:0px auto;
}  
#header{
  position:relative;
  z-index:1;
   width:100%;
   margin:0px auto;
}
#main-content{  
    padding-bottom:200px; /*重要！给footer预留的空间??为什么当内容足够时不会留空间*/
}  
#footer{  
   position:absolute;  
   bottom: 0; /* 关键 */  
   left:0; /* IE下一定要记得 */  
   height:60px;         /* footer的高度一定要是固定值*/  
}  
table{
    font-family: verdana,arial,sans-serif;
    font-size:15px;
    color:#333333;
    border-width: 1px;
    border-color: #666666;
    border-collapse: collapse;
}
 table th{
    border-width: 1px;
    padding: 8px;
    border-style: solid;
    border-color: #666666;
    background-color: #dedede;
}
 table td{
   border-width: 1px;
    padding: 8px;
    border-style: solid;
    border-color: #666666;
    background-color: #ffffff;
}
.Clear{
    clear:both;
}
</style>
</head>
<body>
<div id="container">
<div id="header">
<img src="/eduSystem/images/scau.jpg" name="the_pic" width=1000px  height=137 border="0"/>
  <div class="main_nav hover">
    <ul>
      <li><a href="index.jsp">首页</a>

      </li>
       <li><a href="#">网上选课</a>
         <dl>
           <dd><a href="javaScript:courselist()">可选课表</a></dd>
          <dd><a href="javaScript:selectedlist()">已选课表</a></dd>
        </dl>
      </li>
      <li><a href="#" >信息维护</a>
        <dl>
           <dd><a href="javascript:getInfo()">个人信息</a></dd>
          <dd><a href="javascript:findPass()">修改密码</a></dd>
        </dl>
      </li>
      <li><a href="#">信息查询</a>
        <dl>
          <dd><a href="javascript:getScore()">成绩查询</a></dd>
          <dd><a href="javascript:getCurriculum()">课表查询</a></dd>
        </dl>
      </li>
      <li><a href="javascript:getNotice()">公告栏</a>
       </li>
      <li></li>
      <li></li>
      <li></li>
    </ul>
  </div>
</div>
<div id="main-content">
<%@include file="../include/indexContent.jsp" %>
</div>
 <div class="Clear"><!--如何你上面用到float,下面布局开始前最好清除一下。--></div>
  <div id="footer">
<%@include file="../include/footer.jsp" %>
</div>
</div>
</body>
</html>