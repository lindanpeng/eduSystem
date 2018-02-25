package beans;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class User {
private String userid;
private String name;
private String password;
private int level;
@Id
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + level;
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((userid == null) ? 0 : userid.hashCode());
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
	User other = (User) obj;
	if (level != other.level)
		return false;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if (userid == null) {
		if (other.userid != null)
			return false;
	} else if (!userid.equals(other.userid))
		return false;
	return true;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getLevel() {
	return level;
}
public void setLevel(int level) {
	this.level = level;
}
}
