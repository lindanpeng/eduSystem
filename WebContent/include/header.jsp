<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<head>
<style type="text/css">
* {
	margin:0;
	padding:0;
}
ul, ol {
	list-style:none;
}
a img {
	border:none;
}
#header {
	width:1000px;
	margin:2px auto;
}
.main_nav {
	width:100%;
	height:30px;
}
.main_nav ul li {
	float:left;
	width:125px;
	height:30px;
    font-size:15px;
    background:#66ccFF;
	position:relative;
}
.main_nav ul li a {
	display:block;
	height:30px;
	line-height:30px;
	text-align:center;
	background:#66ccFF;
	color:#FFFFFF;
	text-decoration:none;
}
.main_nav ul li dl {
	position:absolute;
	left:0;
	top:30px;
	width:125px;
	display:none;
}
.main_nav ul li dl dd {
	height:31px;
}
.main_nav ul li dl dd a {
	display:block;
	height:30px;
	line-height:30px;
	text-align:center;
	color:#FFFFFF;
	background:#66ccff;
	border-bottom:1px solid #66ccff;
}
.main_nav ul li dl dd a:hover{background:#00CCFF;color:#FFFFBB;}
.click {
	margin-top:200px;
}
</style>
</head>
<div id="header">
<img src="/eduSystem/images/scau.jpg" name="the_pic" width=1000px  height=137 border="0"/>
  <div class="main_nav hover">
    <ul>
      <li><a href="#">首页</a>

      </li>
       <li><a href="#">网上选课</a>
     
      </li>
      <li><a href="#" >信息维护</a>
        <dl>
           <dd><a href="#">个人信息修改</a></dd>
          <dd><a href="#">修改密码</a></dd>
        </dl>
      </li>
      <li><a href="#">信息查询</a>
        <dl>
          <dd><a href="#">成绩查询</a></dd>
          <dd><a href="#">课表查询</a></dd>
        </dl>
      </li>
      <li><a href="#">公告栏</a>
       </li>
      <li></li>
      <li></li>
      <li></li>
    </ul>
  </div>
</div>
<script type="text/javascript" src="/eduSystem/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
$(".hover ul li").hover(function(){
	$(this).children("dl").slideDown(300)
}, function(){
	$(this).children("dl").slideUp(100)
});
</script>