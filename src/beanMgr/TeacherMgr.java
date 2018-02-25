package beanMgr;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import beans.Student;
import beans.Teacher;
import util.HibernateUtil;

public class TeacherMgr {
	public static String generateId() {		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String teacherid=(String)session.createSQLQuery("select teacherid from Teacher order by teacherid desc limit 1").uniqueResult();
		session.getTransaction().commit();
		if(teacherid==null)
			teacherid="022016001";
		else{
			teacherid="022016"+String.format("%03d", Integer.parseInt(teacherid.substring(6))+1);
		}
		return teacherid;//"012016" + String.format("%03d", count + 1);
	}

	public static void add(Teacher teacher) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(teacher);
		session.getTransaction().commit();
	}
	public static void del(String teacherid) {
		Teacher teacher=new Teacher();
		teacher.setTeacherid(teacherid);
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(teacher);
		session.getTransaction().commit();
	}

	public static void update(Teacher teacher) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(teacher);
		session.getTransaction().commit();
	}
	public static Teacher find(String teacherid) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	    Teacher teacher=(Teacher)session.get(Teacher.class,teacherid);
		session.getTransaction().commit();
		return teacher;
	}
//TODO
	public static List<Teacher> getList(Map<String,Object> map,int startPos,int size) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		DetachedCriteria dc=DetachedCriteria.forClass(Teacher.class);
		if(map!=null){
			for (Map.Entry<String,Object> entry : map.entrySet()) {  
			  dc.add(Restrictions.eq(entry.getKey(),entry.getValue()));
			}  
		}
		List<Teacher> teachers=dc.getExecutableCriteria(session).setFirstResult(startPos).setMaxResults(size).list();
		session.getTransaction().commit();
		return  teachers;
	}
	 public static long getRowsCount(Map<String,Object> map){
			Session session=HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			DetachedCriteria dc=DetachedCriteria.forClass(Teacher.class);
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
