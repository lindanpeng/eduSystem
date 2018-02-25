<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<title>公告管理</title>
<script type="text/javascript" src="/eduSystem/CKeditor/ckeditor.js"></script>
<script type="text/javascript" src="/eduSystem/js/jquery-2.1.1.min.js"></script>
<script>
$(document).ready(function(){
	$.get("/eduSystem/loadNotice.do",function(data){
		CKEDITOR.instances.notice.setData(data);
	})
	$("#sub").click(function(){
		var text=CKEDITOR.instances.notice.getData();
		$.post("/eduSystem/saveNotice.do",{"notice":text},function(data){
			alert(data);
			location.href="index.jsp";
		})
	});
	
});
</script>
<div id="main">
<textarea name="notice" style="width:300px;height:200px;"></textarea>
<script type="text/javascript">CKEDITOR.replace("notice");</script>
<br>
<input id="sub" type="button" value="提交">
</div>