package others;

import com.google.gson.Gson;

import beanMgr.StudentMgr;
import beans.Student;


public class DateTest {
public static void main(String[] args){
	/*	DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = df.parse("2016-12-02");
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
	Student student=StudentMgr.find("012016001");
	Gson gson=new Gson();
	System.out.println(gson.toJson(student));
	System.out.println(student);	
}
}
