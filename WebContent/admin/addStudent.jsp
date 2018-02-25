<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>添加学生</title>
<style>
#add_teacher {
	margin-top: 10px;
}

#as_content {
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
			 text+="<option value="+data[i].name+">"+data[i].name+"</option>";	
			}
			$("#college").html(text);
			$.getJSON("/eduSystem/loadClass.do",{"college":$("#college").find("option:selected").val()},function(data){
				var text;
				for(var i=0;i<data.length;i++){
					 text+="<option value="+data[i].name+">"+data[i].name+"</option>";
					}
					$("#class").html(text);
				});
		});
	
$("#college").change(function(){
	$.getJSON("/eduSystem/loadClass.do",{"college":$("#college").find("option:selected").val()},function(data){  
		var text;
		for(var i=0;i<data.length;i++){
			 text+="<option value="+data[i].name+">"+data[i].name+"</option>";
			}
			$("#class").html(text);
		});
});
	$("#sub").click(function(){
	if($('input[name="name"]').val()=="")
		{
		  alert("请输入姓名!");
		  return ;
		}
	$.ajax({  
	    type:"post",  
	    url:"/eduSystem/addStudent.do",  
	    data:$("#form1").serialize(),
	    global:false,   
        success:function(data){
        	$("#as_content").text(data);
        }
	});
});
});
</script>
<div id="add_student">
	<span style="font-size: 23px; font-family: 微软雅黑;">添加学生</span>
	<div id="as_content">
	<form action="/eduSystem/addstudent.do" method="post" id="form1">
		<table id="table1">
			<tr>
				<td>学生名称：</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>入学日期：</td>
				<td><input type="date" name="date"></td>
			</tr>
		    <tr><td>所属学院：</td><td><select name="college" id="college"></select></td></tr>
		     <tr><td>所属班级：</td><td><select name="classname" id="class"></select></td></tr>
		    <tr><td>电话号码：</td>
		    <td><input type="text" name="phone"></td>
		    </tr>
		</table>
		 <input type="button" id="sub" value="提交" style="width:40px;height:20px;">
		</form>
	</div>
</div>