<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>我的成绩</title>
<style>
#studentlist{
float:left;
margin-top:10px;
width:1000px;
}
table{
width:600px;
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
function showPage(scores){	
	 var text;
	  text="<tr><th>课程名称</th><th>老师姓名</th><th>课程成绩</th></tr>";
	     for(var i=0;i<scores.length;i++)
	    {
	   
	    	text+="<tr><td>"+scores[i].coursename+"</td><td>"+scores[i].teachername+"</td><td>"+scores[i].score+"</td></tr>";
	    } 
	    $("#table").html(text);
	    $("#pageNo").text(pageNo);
	    $("#pageCount").text(pageCount);
	    $("#rowsCount").text(rowsCount);
	}
	function gotoPage(page){
		$.getJSON("/eduSystem/loadMyCourse.do",{"pageNo":page,"coursename":$("#coursename").find("option:selected").val(),"classname":$('input[name="classname"]').val()},function(json){  
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
		gotoPage(1);
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

});
</script>
<div id="studentlist">
	<span style="font-size: 23px; font-family: 微软雅黑;">我的成绩</span>
<div id="sl_content">
	<div id="list_content">
	<table id="table">
	</table>
	</div>
	<div id="page_control">
	<p>
	第<span id="pageNo"></span>页/共<span id="pageCount"></span>页                             总共 <span id="rowsCount"></span>条记录 &nbsp; &nbsp; &nbsp;
	跳转到<input type="text" name="pageNo" style="width:40px">  <input id="goto" type="button" value="go">&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
	&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
	<input type="button" id="top" value="首页">  <input id="pre" type="button" value="上一页">  <input id="next" type="button" value="上一页">  <input id="tail" type="button" value="尾页">&nbsp;&nbsp;&nbsp;&nbsp;
	<input id="edit" type="button" value="编辑"/> <input id="sub" type="button" value="提交"/>
	</p>
   </div>
</div>
</div>