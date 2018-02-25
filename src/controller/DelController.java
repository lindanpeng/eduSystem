package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import beanMgr.SelectCourseMgr;
import beanMgr.StudentMgr;
import beanMgr.TeacherMgr;

@Controller
public class DelController {
@RequestMapping("delStudent")
public void delStudent(String studentid){
	StudentMgr.del(studentid);
}
@RequestMapping("delTeacher")
public void delTeacher(String teacherid){
	TeacherMgr.del(teacherid);
}@RequestMapping("delCourse")
public void delCourse(int courseid){
	SelectCourseMgr.del(courseid);
}
}
