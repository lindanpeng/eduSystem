package beanMgr;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import com.google.gson.Gson;

import beans.ClassTime;
import beans.SelectCourse;
import util.HibernateUtil;

public class SelectCourseMgrTest {
	@Test
	public void testAdd(){
		SelectCourse course=new SelectCourse();
		ClassTime classTime1=new ClassTime();
		classTime1.setDay("周一");
		classTime1.setTime("1,2节");
		ClassTime classTime2=new ClassTime();
		classTime2.setDay("周一");
		classTime2.setTime("3,4节");
		Set<ClassTime> classTimes=new HashSet<>();
		classTimes.add(classTime1);
		classTimes.add(classTime2);
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for(ClassTime classTime:classTimes){
			session.save(classTime);
			course.getClassTimes().add(classTime);
		}
		course.setClassroom("第一教学楼");
		course.setClassTimes(classTimes);
		course.setName("数据结构");
		course.setSurplus(100);
		course.setTotal(100);
		course.setTeacherid("022016001");
		session.save(course);
	   session.getTransaction().commit();
	}
	@Test
	public void testDel(){
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		SelectCourse course=(SelectCourse)session.load(SelectCourse.class,6); 
		session.createQuery("delete from ClassTime where courseid ="+course.getCourseid()).executeUpdate();
		session.delete(course);
		session.getTransaction().commit();
	}
	
	@Test
	public void testGet(){
		List<SelectCourse> courses=SelectCourseMgr.getList(null, 0, 10);
		for(SelectCourse course:courses){
			System.out.println(course.getName());
			//System.out.println(course.getClassTimes());
		}
	}
	@Test
	public void testFind(){
		SelectCourse course=SelectCourseMgr.find(11);
		System.out.println(course.getName());
	
	}
	@Test
	public void testUpdate(){
		SelectCourseMgr.updateSurplus(11,100);
	}
}
