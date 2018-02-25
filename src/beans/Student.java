package beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	private String studentid;
	private String name;
	private String phone;
	private String college;
	private Date inrolltime;
	private String classname;
    @Id
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public Date getInrolltime() {
		return inrolltime;
	}

	public void setInrolltime(Date inrolltime) {
		this.inrolltime = inrolltime;
	}
    @Column(name="class")
	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}
	@Override
	public String toString() {
		String date=new SimpleDateFormat("yyyy-MM-dd").format(this.inrolltime);
		return "{\"studentid\":\"" + studentid + "\",\"name\":\"" + name + "\",\"phone\":\"" + phone + "\",\"college\":\"" + college
				+ "\",\"inrolltime\":\"" + date + "\",\"classname\":\"" + classname + "\"}";
	}

}
