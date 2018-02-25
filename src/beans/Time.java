package beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Time {
 private int id;
 private String time;
@Id
@GeneratedValue
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public void setTime(String time) {
	this.time = time;
}
public String getTime() {
	return time;
}
}
