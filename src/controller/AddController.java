package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import beanMgr.ContentMgr;
import beanMgr.SelectCourseMgr;
import beanMgr.StudentMgr;
import beanMgr.TeacherMgr;
import beans.ClassTime;
import beans.Content;
import beans.SelectCourse;
import beans.Student;
import beans.Teacher;

@Controller
public class AddController {
	@RequestMapping("/addStudent")
	public void addStudent(Student student, String date, HttpServletResponse response) throws ParseException {
		DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
		Date inrolltime = dF.parse(date);
		student.setStudentid(StudentMgr.generateId());
		student.setInrolltime(inrolltime);
		StudentMgr.add(student);
		// @TODO 异常处理
		String handleResult = "添加学生成功!";
		try {
			response.setHeader("content-type", "text/html;charset=GBK");

			response.setCharacterEncoding("GBK");
			response.getWriter().print(handleResult);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/addCourse")
	public void addCourse(SelectCourse course, String[] days, String[] times, HttpServletResponse response) {
		String handleResult = null;

		if (TeacherMgr.find(course.getTeacherid()) == null) {
			handleResult = "添加课程失败，不存在该名教师！";
		} else {
			Set<ClassTime> classTimes = new HashSet<>();
			for (int i = 0; i < days.length; i++) {
				classTimes.add(new ClassTime(days[i], times[i]));
			}
			course.setSurplus(course.getTotal());
			course.setTeachername(TeacherMgr.find(course.getTeacherid()).getName());
			SelectCourseMgr.add(course, classTimes);
			handleResult = "添加课程成功!";
		}
		try {
			response.setHeader("content-type", "text/html;charset=GBK");

			response.setCharacterEncoding("GBK");
			response.getWriter().print(handleResult);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("addTeacher")
	public void addTeacher(Teacher teacher, String date, HttpServletResponse response) throws ParseException {
		DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = dF.parse(date);
		teacher.setTeacherid(TeacherMgr.generateId());
		teacher.setBirthday(birthday);
		TeacherMgr.add(teacher);
		// @TODO 异常处理
		String handleResult = "添加教师成功!";
		try {
			response.setHeader("content-type", "text/html;charset=GBK");

			response.setCharacterEncoding("GBK");
			response.getWriter().print(handleResult);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
