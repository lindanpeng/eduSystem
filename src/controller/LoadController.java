package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import beanMgr.ClassMgr;
import beanMgr.ClassroomMgr;
import beanMgr.CollegeMgr;
import beanMgr.ContentMgr;
import beanMgr.CourseMgr;
import beanMgr.DayMgr;
import beanMgr.SelectCourseMgr;
import beanMgr.StudentMgr;
import beanMgr.TeacherMgr;
import beanMgr.TimeMgr;
import beans.Class;
import beans.ClassTime;
import beans.Classroom;
import beans.College;
import beans.Content;
import beans.Course;
import beans.Day;
import beans.Score;
import beans.SelectCourse;
import beans.Student;
import beans.Teacher;
import beans.Time;
import beans.User;
import net.sf.json.JSONObject;
import util.ShowPage;
@Controller
public class LoadController {
private final int size=10;
@RequestMapping("/loadCollege")
public void loadCollege(HttpServletResponse response){
  List<College> colleges=CollegeMgr.getAll();
  Gson gson=new Gson();
  try {
	response.setHeader("content-type","text/html;charset=GBK");//以后这两句都写上，太坑爹了！
	response.setCharacterEncoding("GBK");
	response.getWriter().println(gson.toJson(colleges));
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
@RequestMapping("/loadClass")
public void loadClass(String college,HttpServletResponse response){
	List<Class> classes=null;
	 Gson gson=new Gson();
	if(college!=null&&!college.equals(""))	
	 classes=ClassMgr.findByCollege(college); 
		try {
			  response.setHeader("content-type","text/html;charset=GBK");//以后这两句都写上，太坑爹了！
			  response.setCharacterEncoding("GBK");
			response.getWriter().println(gson.toJson(classes));
		} catch (IOException e) {
			e.printStackTrace();
		}
}
@RequestMapping("/loadStudent")
public void loadStudent(int pageNo,String classname,String college,String studentid,String name,HttpServletResponse response){
	Map<String,Object> map=new HashMap<>();
	
	if(classname!=null&&!classname.equals(""))
	{
		map.put("classname",classname);
	}
   if(college!=null&&!college.equals(""))
		map.put("college",college);
   if(studentid!=null&&!studentid.equals(""))
		map.put("studentid",studentid);
   if(name!=null&&!name.equals(""))
		map.put("name",name);
   int rowsCount=(int)StudentMgr.getRowsCount(map);
	ShowPage showPage=new ShowPage(rowsCount,pageNo,size);
	int maxPage=showPage.getMaxPage();
	int curPage=showPage.getCurPage();
	int startPos=showPage.getStartPos();
	List<Student> students=StudentMgr.getList(map,startPos,size);
	JSONObject json=new JSONObject();
	json.put("pageCount",maxPage);
	json.put("pageNo",curPage);
	json.put("rowsCount",rowsCount);
	json.put("students", students.toString());
	try {
		  response.setHeader("content-type","text/html;charset=GBK");//以后这两句都写上，太坑爹了！
		  response.setCharacterEncoding("GBK");
		response.getWriter().println(json);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
@RequestMapping("/loadTeacher")
public void loadTeacher(int pageNo,Teacher teacher,HttpServletResponse response){
	Map<String,Object> map=new HashMap<>();
   if(teacher.getCollege()!=null&&!teacher.getCollege().equals(""))
		map.put("college",teacher.getCollege());
   if(teacher.getTeacherid()!=null&&!teacher.getTeacherid().equals(""))
		map.put("teacherid",teacher.getTeacherid());
   if(teacher.getName()!=null&&!teacher.getName().equals(""))
		map.put("name",teacher.getName());
   int size=10;
	int rowsCount=(int)TeacherMgr.getRowsCount(map);
	ShowPage showPage=new ShowPage(rowsCount,pageNo,size);
	int maxPage=showPage.getMaxPage();
	int curPage=showPage.getCurPage();
	int startPos=showPage.getStartPos();
	List<Teacher> teachers=TeacherMgr.getList(map,startPos,size);
	JSONObject json=new JSONObject();
	json.put("pageCount",maxPage);
	json.put("pageNo",curPage);
	json.put("rowsCount",rowsCount);
	json.put("teachers", teachers.toString());
	try {
		  response.setHeader("content-type","text/html;charset=GBK");//以后这两句都写上，太坑爹了！
		  response.setCharacterEncoding("GBK");
		response.getWriter().println(json);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
@RequestMapping("/loadInfo")
public void loadInfo(HttpSession session,HttpServletResponse response){
	User user=(User)session.getAttribute("user");
	Object obj=null;
	if(user.getLevel()==3){
		obj=StudentMgr.find(user.getUserid());
	}
	else if(user.getLevel()==2){
		obj=TeacherMgr.find(user.getUserid());
	}
 try {
	  response.setHeader("content-type","text/html;charset=GBK");//以后这两句都写上，太坑爹了！
	  response.setCharacterEncoding("GBK");
		response.getWriter().println(obj);
	} catch (IOException e) {

		e.printStackTrace();
	}
}
@RequestMapping("loadDay")
public void loadDay(HttpServletResponse response){
	List<Day> days=DayMgr.getAll();
	  Gson gson=new Gson();
	  try {
		response.setHeader("content-type","text/html;charset=GBK");//以后这两句都写上，太坑爹了！
		response.setCharacterEncoding("GBK");
		response.getWriter().println(gson.toJson(days));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@RequestMapping("loadTime")
public void loadTime(HttpServletResponse response){
	List<Time> times=TimeMgr.getAll();
	  Gson gson=new Gson();
	  try {
		response.setHeader("content-type","text/html;charset=GBK");//以后这两句都写上，太坑爹了！
		response.setCharacterEncoding("GBK");
		response.getWriter().println(gson.toJson(times));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@RequestMapping("loadClassroom")
public void loadClassroom(HttpServletResponse response){
	List<Classroom> classrooms=ClassroomMgr.getAll();
	  Gson gson=new Gson();
	  try {
		response.setHeader("content-type","text/html;charset=GBK");//以后这两句都写上，太坑爹了！
		response.setCharacterEncoding("GBK");
		response.getWriter().println(gson.toJson(classrooms));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@RequestMapping("loadCourse")//TODO 效率太低？
public void loadCourse(int pageNo,SelectCourse course,HttpServletResponse response,HttpSession session){
	Map<String,Object> map=new HashMap<>();
   if(course.getClassroom()!=null&&!course.getClassroom().equals(""))
		map.put("classroom",course.getClassroom());
   if(course.getName()!=null&&!course.getName().equals(""))
		map.put("name",course.getName());
   if(course.getTeachername()!=null&&!course.getTeachername().equals(""))
 		map.put("teachername",course.getTeachername());
	int rowsCount=(int)SelectCourseMgr.getRowsCount(map);
	ShowPage showPage=new ShowPage(rowsCount,pageNo,size);
	int maxPage=showPage.getMaxPage();
	int curPage=showPage.getCurPage();
	int startPos=showPage.getStartPos();
	List<SelectCourse> courses=SelectCourseMgr.getList(map,startPos,size);
	if(((User)session.getAttribute("user")).getLevel()==3)
	{	String studentid=((User)session.getAttribute("user")).getUserid();
	List<Course> cs=CourseMgr.findByStudentid(studentid);
	for(int i=0;i<courses.size();i++)
	{
		for(Course c:cs){
			if(courses.get(i).getCourseid()==c.getCourseid()){
				courses.remove(i);
				i--;
				rowsCount--;//页面数据显示有误
				break;
			}

		}
	}
	}
	JSONObject json=new JSONObject();
	json.put("pageCount",maxPage);
	json.put("pageNo",curPage);
	json.put("rowsCount",rowsCount);
	json.put("courses", courses);
	try {
		  response.setHeader("content-type","text/html;charset=GBK");//以后这两句都写上，太坑爹了！
		  response.setCharacterEncoding("GBK");
		 response.getWriter().println(json);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
@RequestMapping("loadSelectedCourse")
public void loadSelectedCourse(HttpServletResponse response,HttpSession session){
	String studentid=((User)session.getAttribute("user")).getUserid();
	List<Course> courses=CourseMgr.findByStudentid(studentid);
	List<SelectCourse> selecteds=new ArrayList<>();
	for(Course course:courses){
		selecteds.add(SelectCourseMgr.find(course.getCourseid()));
	}
	JSONObject json=new JSONObject();
	json.put("courses", selecteds);
	try {
		  response.setHeader("content-type","text/html;charset=GBK");//以后这两句都写上，太坑爹了！
		  response.setCharacterEncoding("GBK");
		 response.getWriter().println(json);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
@RequestMapping("/loadClassTime")
public void loadClassTime(HttpSession session,HttpServletResponse response){
	User user=(User)session.getAttribute("user");
	List<Course> courses=CourseMgr.findByStudentid(user.getUserid());
    List<String> names=new ArrayList<>();
    List<String> classTimes=new ArrayList<>();
	for(Course course:courses){
		SelectCourse selectCourse=SelectCourseMgr.find(course.getCourseid());
		Set<ClassTime> classtimes=selectCourse.getClassTimes();
		String name=selectCourse.getName();
          for(ClassTime classtime:classtimes){
        	  classTimes.add(classtime.toString());
        	  names.add(name);
          }
	}
	JSONObject json=new JSONObject();
	json.put("classTimes",classTimes);
	json.put("names",names);
	try {
		  response.setHeader("content-type","text/html;charset=GBK");//以后这两句都写上，太坑爹了！
		  response.setCharacterEncoding("GBK");
		 response.getWriter().println(json);
	} catch (IOException e) {
		e.printStackTrace();
	}
}

@RequestMapping("/loadMyCourse")
public void loadMyCourse(int pageNo,Score score,HttpSession session,HttpServletResponse response){
	Map<String,Object> map=new HashMap<>();
	User user=(User)session.getAttribute("user");
	if(user.getLevel()==2)
	{
		map.put("teacherid",user.getUserid());
		map.put("flag",0);
	}
	else
	{
		map.put("studentid",user.getUserid());
		map.put("flag",1);
	}
	if(score.getCourseid()!=0)
		map.put("courseid",score.getCourseid());
	int rowsCount=(int)CourseMgr.getRowsCount(map);
	ShowPage showPage=new ShowPage(rowsCount,pageNo,size);
	int maxPage=showPage.getMaxPage();
	int curPage=showPage.getCurPage();
	int startPos=showPage.getStartPos();
	List<Course> courses=CourseMgr.getList(map, startPos, size);
	List<Score> scores=new ArrayList<>();
	for(Course course:courses){
		scores.add(new Score(course));
	}
	JSONObject json=new JSONObject();
	json.put("pageCount",maxPage);
	json.put("pageNo",curPage);
	json.put("rowsCount",rowsCount);
	json.put("scores",scores);
	try {
		  response.setHeader("content-type","text/html;charset=GBK");//以后这两句都写上，太坑爹了！
		  response.setCharacterEncoding("GBK");
		 response.getWriter().println(json);
	} catch (IOException e) {
		e.printStackTrace();
}
}
@RequestMapping("/loadMyCourse2")
public void loadMyCourse2(HttpSession session,HttpServletResponse response){
	User user=(User)session.getAttribute("user");
	Map<String,Object> map=new HashMap<>();
	map.put("teacherid",user.getUserid());
	List<SelectCourse> courses=SelectCourseMgr.getList(map, 0, 10);
	JSONObject json=new JSONObject();
	json.put("courses",courses);
	try {
		  response.setHeader("content-type","text/html;charset=GBK");//以后这两句都写上，太坑爹了！
		  response.setCharacterEncoding("GBK");
		 response.getWriter().println(json);
	} catch (IOException e) {
		e.printStackTrace();
}
}
@RequestMapping("/loadNotice")
public void loadNotice(HttpServletResponse response){
	try {
		  response.setHeader("content-type","text/html;charset=GBK");//以后这两句都写上，太坑爹了！
		  response.setCharacterEncoding("GBK");
		 response.getWriter().println(ContentMgr.get());
	} catch (IOException e) {
		e.printStackTrace();
}
}
}