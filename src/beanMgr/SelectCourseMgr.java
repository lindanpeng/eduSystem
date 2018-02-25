package beanMgr;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import beans.ClassTime;
import beans.SelectCourse;
import beans.Student;
import util.HibernateUtil;

public class SelectCourseMgr {
	public static void add(SelectCourse course,Set<ClassTime> classTimes) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for(ClassTime classTime:classTimes){
			session.save(classTime);
			course.getClassTimes().add(classTime);
		}
		course.setClassTimes(classTimes);
		session.save(course);
		session.getTransaction().commit();
	}
	public static void del(int  courseid) {

		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		SelectCourse course=(SelectCourse)session.load(SelectCourse.class,courseid); 
		session.createQuery("delete from ClassTime where courseid ="+courseid).executeUpdate();
		session.delete(course);
		session.getTransaction().commit();
	}
	public static SelectCourse find(int courseid) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		SelectCourse course=(SelectCourse)session.get(SelectCourse.class,courseid);
		session.getTransaction().commit();
		return course;
	}
	//TODO
	public static  void updateSurplus(int courseid,int surplus){//线程安全？
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("update SelectCourse  set surplus = ? where courseid =? ");
		query.setInteger(0, surplus);
		query.setInteger(1, courseid);
		query.executeUpdate();
		session.getTransaction().commit();
	}
	public static List<SelectCourse> getList(Map<String,Object> map,int startPos,int size) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria dc=session.createCriteria(SelectCourse.class);
		if(map!=null){
			for (Map.Entry<String,Object> entry : map.entrySet()) {  
			  dc.add(Restrictions.eq(entry.getKey(),entry.getValue()));
			}  
		}
		List<SelectCourse> courses=dc.setFirstResult(startPos).setMaxResults(size).list();
		session.getTransaction().commit();
		Session session2=HibernateUtil.getSessionFactory().getCurrentSession();
		session2.beginTransaction();
		for(SelectCourse course:courses){
			course.setClassTimes(new HashSet((List<ClassTime>)session2.createQuery("from ClassTime t where t.courseid = "+course.getCourseid()).list()));
		}
		session2.getTransaction().commit();
		return courses;
	}
	  public static long getRowsCount(Map<String,Object> map){
			Session session=HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			DetachedCriteria dc=DetachedCriteria.forClass(SelectCourse.class);
			if(map!=null){
				for (Map.Entry<String,Object> entry : map.entrySet()) {  
				  dc.add(Restrictions.eq(entry.getKey(),entry.getValue()));
				}  
			}
			dc.setProjection(Projections.rowCount());
			long count=(long)dc.getExecutableCriteria(session).uniqueResult();
			session.getTransaction().commit();
			return count;
	   }
}
