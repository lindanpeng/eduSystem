package beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class College {
private int collegeid;
private String name;
@Id
@GeneratedValue
public int getCollegeid() {
	return collegeid;
}
public void setCollegeid(int collegeid) {
	this.collegeid = collegeid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + collegeid;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
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
	College other = (College) obj;
	if (collegeid != other.collegeid)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}

}
