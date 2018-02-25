package beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Class {
private int classid;
private String name;
private String college;
@Id
public int getClassid() {
	return classid;
}
public void setClassid(int classid) {
	this.classid = classid;
}
public String getCollege() {
	return college;
}
public void setCollege(String college) {
	this.college = college;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
}
