package beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Day {
private int id;
private String day;
@Id
@GeneratedValue
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
public String getDay() {
	return day;
}

public void setDay(String day) {
	this.day = day;
}

}
