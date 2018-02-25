<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<title>课程管理</title>
<script type="text/javasript" src="/eduSystem/js/jquery-2.1.1.min.js"></script>
<script>
function addCourse(){
	$("#main").load("publishCourse.jsp");
}
function courselist(){
	$("#main").load("courselist.jsp");
}
</script>
<style>
#left {
	width: 125px;
	float: left; /*设置浮动，实现多列效果，div+Css布局中很重要的*/
	background-color:#E0EEE0;
	height:600px;
}
#main{
margin-left:10px;
float:left;
width:865px;
height:auto;
}
ul, ol {
	list-style:none;
}
#left ul li a{
    text-decoration:none;
	text-align:center;
	margin-top:20px;
	float:left;
	width:125px;
	height:40px;
    font-size:20px;
	position:relative;
	color:#00688B;
}
#left ul li a:hover{
background:#008B8B;
color:#E0EEE0;
}
</style>
<div id="left">
	<ul>
		<li>&nbsp;</li>
		<li><a href="javaScript:addCourse()">发布选课</a></li>
		<li><a href="javaScript:courselist()">查看课程</a></li>
	</ul>
</div>
<div id="main">
</div>