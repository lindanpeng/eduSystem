<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>选课列表</title>
<style>
input[type="checkbox"]{
height:18px;
width:18px;
}
</style>
<script type="text/javascript" src="/eduSystem/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
var pageCount;
var pageNo;
var rowsCount;
function choice(id){
	return "<input type=checkbox value='"+id+"' name='courseids'>";
}
function showPage(courses){	
	 var text;
	  text="<tr><th>选中</th><th>课程名称</th><th>任课老师</th><th>上课时间</th><th>上课地点</th><th>容量</th><th>余量</th></tr>";
	     for(var i=0;i<courses.length;i++)
	    {
	    	 var text2="";
	    	 for(var j=0;j<courses[i].classTimes.length;j++)
	    	 {
	    		 text2+=courses[i].classTimes[j].day+"  "+courses[i].classTimes[j].time+"   ";
	    	 }
	       text+="<tr><td>"+choice(courses[i].courseid)+"</td><td>"+courses[i].name+"</td><td>"+courses[i].teachername+"</td><td>"+text2+"</td><td>"+courses[i].classroom+"</td><td>"+courses[i].total+"</td><td>"+courses[i].surplus+"</td></tr>";
	    } 
	    $("#table").html(text);
	    $("#pageNo").text(pageNo);
	    $("#pageCount").text(pageCount);
	    $("#rowsCount").text(rowsCount);
	}
	function gotoPage(page){
		$.getJSON("/eduSystem/loadCourse.do",{"pageNo":page,"classroom":$("#classroom").find("option:selected").val(),"teachername":$('input[name="teachername"]').val(),"name":$('input[name="name"]').val()},function(json){  
			 pageCount=json.pageCount;
		      pageNo=json.pageNo;
		      rowsCount=json.rowsCount;
			  showPage(json.courses);
			});
	}
$(document).ready(function(){
	$.getJSON("/eduSystem/loadClassroom.do",function(data){  
		var text;
		text="<option value=\"\" selected>请选择</option>";
		for(var i=0;i<data.length;i++){
				text+="<option value="+data[i].name+">"+data[i].name+"</option>";	
			}
			$("#classroom").html(text);
		});
	$("#classroom").change(function(){
		$('input[name="teachername"]').val("");
		$('input[name="name"]').val("");
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
	$("#findbyteachername").click(function(){
		$('input[name="name"]').val("");
		gotoPage(1);
	});
	$("#findbyname").click(function(){
		$('input[name="teachername"]').val("");
		gotoPage(1);
	})
	$("#sub").click(function(){
		if($("input[name='courseids']:checked").length<=0)
			{
			alert("请至少选择一门课程！");
			return;
			}
		var courseids= $("input[name='courseids']:checked").serialize();
		$.post("/eduSystem/selectCourse.do",courseids,function(data){
			alert(data);
			gotoPage(1);
		});
	});
});

</script>
<style>
#courselist{
float:left;/*为什么？为什么？为什么？为什么？*/
  z-index:-1;
}
#sl_content{
height:500px;
position:relative;
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
#search{
background-color:#F2F2F2;
height:80px;

}
table{
width:1000px;
}
#page_control{
position:absolute;
bottom:0;
height:40px;
background-color:#F5F5F5;
width:1000px;
}
</style>
<div id="courselist">
	<span style="font-size: 23px; font-family: 微软雅黑;">可选课表</span>
<div id="sl_content">
	<div id="search">
	<p>上课地点：<select name="classroom" id="classroom"></select></p>
	<p><span>根据老师姓名查询：<input type="text" name="teachername"><input id="findbyteachername" type="button" value="确定" ></span>   <span>根据课程名称查询：<input type="text" name="name"><input id="findbyname" type="button" value="确定" ></span></p>
	</div>
	<div id="list_content">
	<table id="table">
	</table>
	</div>
	<div id="page_control">
	<p>
	第<span id="pageNo"></span>页/共<span id="pageCount"></span>页                             总共 <span id="rowsCount"></span>条记录 &nbsp; &nbsp; &nbsp;
	跳转到<input type="text" name="pageNo" style="width:40px">  <input id="goto" type="button" value="go">&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
	&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
	<input type="button" id="top" value="首页">  <input id="pre" type="button" value="上一页">  <input id="next" type="button" value="上一页">  <input id="tail" type="button" value="尾页">&nbsp;&nbsp;&nbsp;&nbsp;<input id="sub" type="button" value="提交"/>
	</p>
   </div>

</div>
</div>