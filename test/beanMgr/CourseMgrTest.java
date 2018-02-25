package beanMgr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import beans.Course;
import beans.Score;
import net.sf.json.JSONObject;

public class CourseMgrTest {
@Test
public void testFindByStudentid(){
	List<Course> courses=CourseMgr.findByStudentid("012016001");
	for(Course course:courses){
		System.out.println(course.getName());
	}
}
@Test
public void testGetScore(){
	Map<String,Object> map=new HashMap<>();
	map.put("teacherid","022016002");
	List<Course> courses=CourseMgr.getList(map,0,10);
	List<Score> scores=new ArrayList<>();
	for(Course course:courses){
		scores.add(new Score(course));
	}
	JSONObject json=new JSONObject();
	json.put("scores",scores);
	System.out.println(json);
}
@Test
public void getCount(){
	Map<String,Object> map=new HashMap<>();
	map.put("teacherid","022016001");
	System.out.println(CourseMgr.getRowsCount(map));
}
}
