<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>最新公告</title>
<style>
#noticeContent{
margin-top:10px;
margin-bottom:10px;
width:1000px;
float:left;
}
#content{
position:relative;
padding-top:20px;
margin-top:20px;
height:300px;
border-top-width:2px;
border-top-color:#CDC5BF;
border-bottom-width:2px;
border-bottom-color:#CDC5BF;
border-bottom-style:solid;
border-top-style:solid;
}
#content dl dt{
height:35px;
text-align:center;
}
#content input{
height:20px;
}
</style>
<script type="text/javascript" src="/eduSystem/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#content").load("/eduSystem/loadNotice.do");
})
</script>
<div id="noticeContent">
<span style="font-size:23px;font-family:微软雅黑;">最新公告</span>
<div id="content">

</div>
</div>
