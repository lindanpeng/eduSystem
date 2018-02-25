<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>个人课表</title>
<script type="text/javascript">
var days=new Array("周一","周二","周三","周四","周五");
var times=new Array("1,2节","3,4节","5,6节","7,8节","9,10节","11,12节","11,12,13节");
function printTimetable(data){
   var table="<tr><th>星期一</th><th>星期二</th><th>星期三</th><th>星期四</th><th>星期五</th></tr>";
   var names=data.names;
   var classTimes=data.classTimes;
   var flag;
	for(var i=0;i<times.length;i++){
		table+="<tr>";
		for(var j=0;j<days.length;j++)
			{
			 flag=0;
			 for( var k=0;k<names.length;k++)
				 {
       
				   if(classTimes[k].time==times[i]&&classTimes[k].day==days[j])
					   {
					     flag=1;
					     table+="<td>"+names[k]+"<br>"+classTimes[k].time+"</td>";
					     break;
					   }
				 }
			 if(flag==0)
				 table+="<td></td>";
			}
		table+="</tr>";
	}
	$("#table").html(table);
}
$(document).ready(function(){
	$.getJSON("/eduSystem/loadClassTime.do",function(data){
		printTimetable(data);
	})
})
</script>
<style>
#curriculum{
margin-top:10px;
}
#content{
padding-top:20px;
margin-top:20px;
}
#curriculum{
float:left;
}
table{
width:1000px;
text-align:center;
}
table tr td{
height:60px;
width:200px;
}
table tr th{
height:30px;
}
</style>
<div id="curriculum">
<span style="font-size:23px;font-family:微软雅黑;">个人课表</span>
<div id="content" style="border-top-width:2px;border-top-color:#CDC5BF;border-top-style:solid;">
<table id="table">

</table>
</div>
</div>