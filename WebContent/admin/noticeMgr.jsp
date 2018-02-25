<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>公告管理</title>
<style>
#edit{

}
#main{
width:1000px;
float:left;
margin-bottom:10px;
}
</style>
<script type="text/javascript" src="/eduSystem/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#btn").click(function(){
		$("#main").load("noticeEdit.jsp");
	})
});
</script>
<div id="main">
<div >
<%@include file="../include/noticeContent.jsp"%>
</div > 
<div id="edit">
<p style="text-align:right;"><input  id="btn" type="button" value="编辑公告"></p>
</div>
</div>