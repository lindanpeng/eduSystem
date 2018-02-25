package beanMgr;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import beans.Course;
import util.HibernateUtil;

public class CourseMgr {
	public static void add(Course course) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(course);
		session.getTransaction().commit();
	}
	public static void del(int id) {

		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Course course=(Course)session.load(Course.class,id); 
		session.delete(course);
		session.getTransaction().commit();
	}
	//TODO 冗余或是提高效率？
	public static List<Course> findByStudentid(String studentid){
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("from Course where studentid = ?");
		query.setString(0, studentid);
		List<Course> courses=query.list();
		session.getTransaction().commit();
		return courses;
	}
	//TODO 同上
	public static List<Course> findByTeacherid(String teacherid){
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("from Course where teacherid = ?");
		query.setString(0, teacherid);
		List<Course> courses=query.list();
		session.getTransaction().commit();
		return courses;
	}
	public static List<Course> getList(Map<String,Object> map,int startPos,int size) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		DetachedCriteria dc=DetachedCriteria.forClass(Course.class);
		if(map!=null){
			for (Map.Entry<String,Object> entry : map.entrySet()) {  
			  dc.add(Restrictions.eq(entry.getKey(),entry.getValue()));
			}  
		}
		List<Course> courses=dc.getExecutableCriteria(session).setFirstResult(startPos).setMaxResults(size).list();
		session.getTransaction().commit();
		return courses;
	}
	public static void updateScore(int courseid, String teacherid,String studentid,float score) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("update Course set score = ? where teacherid = ? and studentid = ? and courseid = ?");
		query.setFloat(0, score);
		query.setString(1, teacherid);
		query.setString(2, studentid);
		query.setInteger(3, courseid);
		query.executeUpdate();
		session.getTransaction().commit();
	}
	public static void publishScore(String teacherid,int courseid){
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("update Course set flag = 1 where teacherid = ? and courseid =? ");
		query.setString(0,teacherid);
		query.setInteger(1,courseid);
		query.executeUpdate();
		session.getTransaction().commit();
	}
   public static long getRowsCount(Map<String,Object> map){
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		DetachedCriteria dc=DetachedCriteria.forClass(Course.class);
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
