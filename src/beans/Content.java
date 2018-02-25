package beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Content {
private int id;
private String content;
@Id
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}

}
