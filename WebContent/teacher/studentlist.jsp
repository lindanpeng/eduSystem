<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>学生列表</title>
<style>
#studentlist{
float:left;
margin-top:10px;
width:1000px;
}
#sl_content{
position:relative;
height:500px;
padding-top:10px;
margin-top:10px;
border-top-width:2px;
border-top-style:solid;
border-top-color:#CDC5BF;
}
p{
padding-top:5px;
height:30px;
}
input{
width:50px;
}
#search{
background-color:#F2F2F2;
height:80px;

}
#page_control{
position:absolute;
bottom:0;
height:40px;
background-color:#F5F5F5;
width:1000px;
}
</style>
<script type="text/javascript">
var pageCount;
var pageNo;
var rowsCount;
var flag=true;
function editScore(score){
	var text="<input class='scores'name='scores' type=text value='"+score+"' disabled='disabled'>";
	return text;
}
function showPage(scores){	
	 var text;
	  text="<tr><th>课程名称</th><th>学生学号</th><th>学生姓名</th><th>学生班级</th><th>课程成绩</th></tr>";
	  var hiddenid="";
	     for(var i=0;i<scores.length;i++)
	    {
	    	 hiddenid+="<input name='studentids' type=hidden value='"+scores[i].studentid+"'>";
	    	text+="<tr><td>"+scores[i].coursename+"</td><td>"+scores[i].studentid+"</td><td>"+scores[i].studentname+"</td><td>"+scores[i].classname+"</td><td>"+editScore(scores[i].score)+"</td></tr>";
	    } 
	    $("#hidden").html(hiddenid);
	    $("#table").html(text);
	    $("#pageNo").text(pageNo);
	    $("#pageCount").text(pageCount);
	    $("#rowsCount").text(rowsCount);
	}
	function gotoPage(page){
		$.getJSON("/eduSystem/loadMyCourse.do",{"pageNo":page,"courseid":$("#coursename").find("option:selected").val(),"classname":$('input[name="classname"]').val()},function(json){  
			 pageCount=json.pageCount;
		      pageNo=json.pageNo;
		      rowsCount=json.rowsCount;
			  showPage(json.scores);
			});
	}
$(document).ready(function(){

	$.getJSON("/eduSystem/loadMyCourse2.do",function(data){  
		var courses=data.courses;
		var text="";
		for(var i=0;i<courses.length;i++){
				text+="<option value="+courses[i].courseid+">"+courses[i].name+"</option>";	
			}
			$("#coursename").html(text);
		});
	$("#coursename").change(function(){
		if(!flag){
		if(confirm("确定要保存成绩吗？"))
		{
		var scores= $("input[name='scores']").serialize();
		var studentids=$("input[name='studentids']").serialize();
		 $.get("/eduSystem/editScore.do",scores+"&"+studentids+"&courseid="+$("#coursename").find("option:selected").val(),function(data){
			alert(data);
		}) 
		}
		$('input.scores').attr("disabled",true); 
		$("input#edit").val("编辑");
		flag=!flag;
		}
		
		gotoPage(1);
	});
	$(".pageControl").change(function(){
		if(!flag){
			if(confirm("确定要保存成绩吗？"))
			{
			var scores= $("input[name='scores']").serialize();
			var studentids=$("input[name='studentids']").serialize();
			 $.get("/eduSystem/editScore.do",scores+"&"+studentids+"&courseid="+$("#coursename").find("option:selected").val(),function(data){
				alert(data);
			}) 
			}
			$('input.scores').attr("disabled",true); 
			$("input#edit").val("编辑");
			flag=!flag;
		}
	});
	gotoPage(1);
	$("#next").click(function(){
		gotoPage(pageNo+1);
	});
	$("#pre").click(function(){
		gotoPage(pageNo-1);
	});
	$("#top").click(function(){
	   gotoPage(1);
	});
	$("#tail").click(function(){
	   gotoPage(pageCount);
	});
	$("#goto").click(function(){
		gotoPage($('input[name="pageNo"]').val())
	});
	$("#edit").click(function(){	
		if(flag)
		{
			$("input.scores").removeAttr("disabled");
			$("input#edit").val("保存");
		}
		else
		{
			if(confirm("确定要保存成绩吗？"))
			{
			var scores= $("input[name='scores']").serialize();
			var studentids=$("input[name='studentids']").serialize();
			 $.get("/eduSystem/editScore.do",scores+"&"+studentids+"&courseid="+$("#coursename").find("option:selected").val(),function(data){
				alert(data);
			}) 
			}
			$('input.scores').attr("disabled",true); 
			$("input#edit").val("编辑");
		}
		flag=!flag;
	});
	$("#sub").click(function(){
	 if(confirm("提交后该课程所有学生的成绩将不可修改，请确认是否提交！"))
		 {
		 $.post("/eduSystem/publishScore.do?&courseid="+$("#coursename").find("option:selected").val(),function(data){
				alert(data);
				gotoPage(1);
			});
			gotoPage(1);
		 }
	});
});
</script>
<div id="studentlist">
	<span style="font-size: 23px; font-family: 微软雅黑;">管理学生成绩</span>
<div id="sl_content">
	<div id="search">
		<p>课程名称：<select name="courseid" id="coursename"></select> 学生班级:<select name="classname" id="classname"></select></p>
	</div>
	<div id="list_content">
	<div id="hidden">
	
	</div>
	<table id="table">
	</table>
	</div>
	<div id="page_control">
	<p>
	第<span id="pageNo"></span>页/共<span id="pageCount"></span>页                             总共 <span id="rowsCount"></span>条记录 &nbsp; &nbsp; &nbsp;
	跳转到<input  type="text" name="pageNo" style="width:40px">  <input class="pageControl" id="goto" type="button" value="go">&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
	&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
	<input class="pageControl" type="button" id="top" value="首页">  <input class="pageControl" id="pre" type="button" value="上一页">  <input class="pageControl" id="next" type="button" value="上一页">  <input class="pageControl" id="tail" type="button" value="尾页">&nbsp;&nbsp;&nbsp;&nbsp;
	<input class="pageControl" id="edit" type="button" value="编辑"/> <input id="sub" type="button" value="提交"/>
	</p>
   </div>
</div>
</div>