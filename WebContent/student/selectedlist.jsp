<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>已选课表</title>
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
function showPage(courses){	
	 var text;
	  text="<tr><th>操作</th><th>课程名称</th><th>任课老师</th><th>上课时间</th><th>上课地点</th></tr>";
	     for(var i=0;i<courses.length;i++)
	    {
	    	 var text2="";
	    	 for(var j=0;j<courses[i].classTimes.length;j++)
	    	 {
	    		 text2+=courses[i].classTimes[j].day+"  "+courses[i].classTimes[j].time+"   ";
	    	 }
	       text+="<tr><td>退选(待添加)</td><td>"+courses[i].name+"</td><td>"+courses[i].teachername+"</td><td>"+text2+"</td><td>"+courses[i].classroom+"</td></tr>";
	    } 
	    $("#table").html(text);
	}
	function gotoPage(){
		$.getJSON("/eduSystem/loadSelectedCourse.do",function(json){  
			 pageCount=json.pageCount;
		      pageNo=json.pageNo;
		      rowsCount=json.rowsCount;
			  showPage(json.courses);
			});
	}

$(document).ready(function(){
	gotoPage();
});

</script>
<style>
#courselist{
float:left;/*为什么？为什么？为什么？为什么？*/
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
	<span style="font-size: 23px; font-family: 微软雅黑;">已选课表</span>
<div id="sl_content">
	<div id="list_content">
	<table id="table">
	</table>
	</div>

</div>
</div>