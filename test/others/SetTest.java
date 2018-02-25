package others;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import beanMgr.CourseMgr;
import beanMgr.SelectCourseMgr;
import beans.ClassTime;
import beans.Course;
import beans.SelectCourse;

public class SetTest {
	@Test
public void test(){
Set<ClassTime> classtimes=new HashSet<>();
ClassTime c1=new ClassTime("12","12");
ClassTime c2=new ClassTime("12","12");
if(c1.equals(c2))
	System.out.println("yes");
classtimes.add(c1);
System.out.println("added successfully!");
classtimes.add(c2);
System.out.println(classtimes.size());
}
	@Test
	public void SetTest2(){
		int[] courseids={11,12};
		String studentid="012016002";
		List<Course> courses=CourseMgr.findByStudentid(studentid);
		List<Course> newcourses=new ArrayList<>();
		boolean flag=true;
		outer:
		for(int i=0;i<courseids.length;i++){

			SelectCourse scourse=SelectCourseMgr.find(courseids[i]);
			Set<ClassTime> classTimes=scourse.getClassTimes();
			for(Course course:courses){
				Set<ClassTime> cs=SelectCourseMgr.find(course.getCourseid()).getClassTimes();
				if((cs.removeAll(classTimes)))//
				{
					flag=false;
					break outer;
				}
			}
			Course course=new Course();
			course.setCourseid(scourse.getCourseid());
			course.setName(scourse.getName());
			course.setStudentid(studentid);
			course.setTeacherid(scourse.getTeacherid());
			course.setScore(-1);
			newcourses.add(course);
		}
		String handleResult="";
		if(flag)
		{
			for(Course course:newcourses){
				System.out.println(course.getName());
			}
			handleResult="选课成功";
		}
		else
			handleResult="时间冲突!";
       System.out.println(handleResult);
	}
}
