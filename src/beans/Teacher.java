package beans;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Teacher {
private String teacherid;
private String phone;
private String name;
private String college;
private Date birthday;
@Id
public String getTeacherid() {
	return teacherid;
}
public void setTeacherid(String teacherid) {
	this.teacherid = teacherid;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCollege() {
	return college;
}
public void setCollege(String college) {
	this.college = college;
}
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
@Override
public String toString() {
	String date=new SimpleDateFormat("yyyy-MM-dd").format(this.birthday);
	return "{\"teacherid\":\"" + teacherid + "\",\"name\":\"" + name + "\",\"phone\":\"" + phone + "\",\"college\":\"" + college
			+ "\",\"birthday\":\"" + date+"\"}";
}

}
