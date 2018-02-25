package beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {
private int id;
private String teacherid;
private String studentid;
private String name;
private int courseid;
private float score;
private int flag;
@Id
@GeneratedValue
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTeacherid() {
	return teacherid;
}
public void setTeacherid(String teacherid) {
	this.teacherid = teacherid;
}
public String getStudentid() {
	return studentid;
}
public void setStudentid(String studentid) {
	this.studentid = studentid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getCourseid() {
	return courseid;
}
public void setCourseid(int courseid) {
	this.courseid = courseid;
}
public float getScore() {
	return score;
}
public void setScore(float score) {
	this.score = score;
}
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}

}
