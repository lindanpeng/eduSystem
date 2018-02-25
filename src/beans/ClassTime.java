package beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ClassTime {
private int id;
private String time;
private String day;
private int courseid;
public ClassTime(){
	
}
public ClassTime(String day,String time){
	this.time=time;
	this.day=day;
}
@Id
@GeneratedValue
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public int getCourseid() {
	return courseid;
}
public void setCourseid(int courseid) {
	this.courseid = courseid;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getDay() {
	return day;
}
public void setDay(String day) {
	this.day = day;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((day == null) ? 0 : day.hashCode());
	result = prime * result + ((time == null) ? 0 : time.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ClassTime other = (ClassTime) obj;
	if (day == null) {
		if (other.day != null)
			return false;
	} else if (!day.equals(other.day))
		return false;
	if (time == null) {
		if (other.time != null)
			return false;
	} else if (!time.equals(other.time))
		return false;
	return true;
}
@Override
public String toString() {
	return "{\"time\":\"" + time + "\",\"day\":\"" + day + "\"}";
}

}
