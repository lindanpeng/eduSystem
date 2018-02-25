package beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class SelectCourse {
private int courseid;
private String name;
private String teacherid;
private String teachername;
private int total;
private int surplus;
private String classroom;
private Set<ClassTime> classTimes=new HashSet<>();
@Id
@GeneratedValue
public int getCourseid() {
	return courseid;
}
public void setCourseid(int courseid) {
	this.courseid = courseid;
}
@OneToMany
@JoinColumn(name="courseid")
public Set<ClassTime> getClassTimes() {
	return classTimes;
}
public void setClassTimes(Set<ClassTime> classTimes) {
	this.classTimes = classTimes;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTeacherid() {
	return teacherid;
}
public void setTeacherid(String teacherid) {
	this.teacherid = teacherid;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
public int getSurplus() {
	return surplus;
}
public void setSurplus(int surplus) {
	this.surplus = surplus;
}
public String getClassroom() {
	return classroom;
}

public void setClassroom(String classroom) {
	this.classroom = classroom;
}
public String getTeachername() {
	return teachername;
}
public void setTeachername(String teachername) {
	this.teachername = teachername;
}
}
