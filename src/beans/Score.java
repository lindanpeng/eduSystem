package beans;

import beanMgr.StudentMgr;
import beanMgr.TeacherMgr;

public class Score {
private int courseid;
private String studentid;
private String studentname;
private String classname;
private String teachername;
private String coursename;
private float  score;
public Score(){
	
}
public Score(Course course){
	this.courseid=course.getCourseid();
	this.studentid=course.getStudentid();
	this.teachername=TeacherMgr.find(course.getTeacherid()).getName();
	this.studentname=StudentMgr.find(course.getStudentid()).getName();
	this.classname=StudentMgr.find(course.getStudentid()).getClassname();
	this.score=course.getScore();
	this.coursename=course.getName();
}

public String getClassname() {
	return classname;
}
public void setClassname(String classname) {
	this.classname = classname;
}
public String getStudentid() {
	return studentid;
}
public void setStudentid(String studentid) {
	this.studentid = studentid;
}
public String getStudentname() {
	return studentname;
}
public void setStudentname(String studentname) {
	this.studentname = studentname;
}
public String getTeachername() {
	return teachername;
}
public void setTeachername(String teachername) {
	this.teachername = teachername;
}
public String getCoursename() {
	return coursename;
}
public void setCoursename(String coursename) {
	this.coursename = coursename;
}
public double getScore() {
	return score;
}
public void setScore(float score) {
	this.score = score;
}
public int getCourseid() {
	return courseid;
}
public void setCourseid(int courseid) {
	this.courseid = courseid;
}

}
