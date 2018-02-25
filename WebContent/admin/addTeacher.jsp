<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>添加教师</title>
<style>
#add_teacher {
	margin-top: 10px;
}

#at_content {
    margin-left:auto;
    padding-top:20px;
    margin-top:20px;
	text-align:center;
	border-top-width: 2px;
	border-top-color: #CDC5BF;
	border-top-style: solid;
}
</style>
<script type="text/javascript" src="/eduSystem/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$.getJSON("/eduSystem/loadCollege.do",function(data){  
		var text;
		for(var i=0;i<data.length;i++){
			if(i==0){
				text+="<option value="+data[i].name+">"+data[i].name+"</option>";	
			}
			else
			 text+="<option value="+data[i].name+">"+data[i].name+"</option>";	
			}
			$("#college").html(text);
		});
	

	$("#sub").click(function(){
	if($('input[name="name"]').val()=="")
		{
		  alert("请输入姓名!");
		  return ;
		}
	if($('input[name="phone"]').val()=="")
		{
		  alert("请输入电话号码！");
		  return;
		}
	if($('input[name="date"]').val()=="")
	{
	  alert("请输入生日日期！");
	  return;
	}
	$.ajax({  
	    type:"post",  
	    url:"/eduSystem/addTeacher.do",
	    data:$("#form2").serialize(),
	    global:false,   
        success:function(data){
        	$("#at_content").text(data);
        }
	});
});
});
</script>
<div id="add_teacher">
	<span style="font-size: 23px; font-family: 微软雅黑;">添加教师</span>
	<div id="at_content">
	<form action="/eduSystem/addTeacher.do" method="post"  id="form2">
		<table id="table1">
			<tr>
				<td>教师名称：</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>生日日期：</td>
				<td><input type="date" name="date"></td>
			</tr>
		    <tr><td>所属学院：</td><td><select name="college" id="college"></select></td></tr>
		    <tr><td>电话号码：</td>
		    <td><input type="text" name="phone"></td>
		    </tr>
		</table>
		 <input type="button" id="sub" value="提交" style="width:40px;height:20px;">
		</form>
	</div>
</div>