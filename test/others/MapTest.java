package others;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.google.gson.Gson;

import beanMgr.CourseMgr;
import beanMgr.SelectCourseMgr;
import beans.ClassTime;
import beans.Course;
import beans.SelectCourse;
import net.sf.json.JSONObject;

public class MapTest {
@Test
public void test(){
	List<Course> courses=CourseMgr.findByStudentid("012016001");
    List<String> names=new ArrayList<>();
    List<String> classTimes=new ArrayList<>();
	for(Course course:courses){
		SelectCourse selectCourse=SelectCourseMgr.find(course.getCourseid());
		Set<ClassTime> classtimes=selectCourse.getClassTimes();
		String name=selectCourse.getName();
          for(ClassTime classtime:classtimes){
        	  classTimes.add(classtime.toString());
        	  names.add(name);
          }
	}
	JSONObject json=new JSONObject();
	json.put("classTimes",classTimes);
	json.put("names",names);
	System.out.println(json);

}
@Test
public void test2(){
	ClassTime a=new ClassTime();
	a.setDay("ÖÜÒ»");
	a.setTime("1,2½Ú");
	System.out.println(a.toString());
}
}
