<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>修改密码</title>
<style>
#findPass{
margin-top:10px;
}
#fp_content{
padding-top:20px;
margin-top:20px;
}
#fp_content dl dt{
height:35px;
text-align:center;
}
#fp_content input{
height:20px;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$("#sub").click(function(){
		if($("#password").val()!=$('input[name="old_password"]').val())
			{
			   alert("输入密码有误！");
			   return;
			}
		if($('input[name="new_password"]').val()!=$('input[name="confirm"]').val()){
			alert("输入密码不一致！");
			return;
		 if($('input[name="new_password"]').val()=="")
		 {
		   alert("密码不能为空！");
		    return;
		 }
		}
		$.post("/eduSystem/changePassword.do",{"password":$('input[name="new_password"]').val()},function(data){
			$("#fp_content").text(data);
		})
	});
});
</script>
<div id="findPass">
<span style="font-size:23px;font-family:微软雅黑;">找回密码</span>
<div id="fp_content" style="border-top-width:2px;border-top-color:#CDC5BF;border-top-style:solid;">
<form action="#" method="post">
<input id="password" type="hidden" value="${user.password}">

<dl>
<dt><span>输入旧密码：<input type="password" name="old_password"></span></dt>
<dt><span>输入新密码：<input type="password" name="new_password"></span></dt>
<dt><span>确认新密码：<input type="password" name="confirm"></span></dt>
<dt><input id="sub" type="button" value="提交" style="width:50px;height:30px"></dt>
</dl>
</form>
</div>
</div>
