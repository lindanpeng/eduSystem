package beanMgr;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import beans.Student;
import util.HibernateUtil;

public class StudentMgr {
	public static String generateId() {		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String studentid=(String)session.createSQLQuery("select studentid from Student order by studentid desc limit 1").uniqueResult();
		session.getTransaction().commit();
		if(studentid==null)
			studentid="012016001";
		else{
			studentid="012016"+String.format("%03d", Integer.parseInt(studentid.substring(6))+1);
		}
		return studentid;//"012016" + String.format("%03d", count + 1);
	}

	public static void add(Student student) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
	}
	public static void del(String studentid) {
		Student student=new Student();
		student.setStudentid(studentid);
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(student);
		session.getTransaction().commit();
	}

	public static void update(Student student) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(student);
		session.getTransaction().commit();
	}
	public static Student find(String studentid) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Student student=(Student)session.get(Student.class,studentid);
		session.getTransaction().commit();
		return student;
	}
//TODO
	public static List<Student> getList(Map<String,Object> map,int startPos,int size) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		DetachedCriteria dc=DetachedCriteria.forClass(Student.class);
		if(map!=null){
			for (Map.Entry<String,Object> entry : map.entrySet()) {  
			  dc.add(Restrictions.eq(entry.getKey(),entry.getValue()));
			  //dc.add(Restrictions.ge(propertyName, value))
			}  
		}
		List<Student> students=dc.getExecutableCriteria(session).setFirstResult(startPos).setMaxResults(size).list();
		session.getTransaction().commit();
		return students;
	}
	  public static long getRowsCount(Map<String,Object> map){
			Session session=HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			DetachedCriteria dc=DetachedCriteria.forClass(Student.class);
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
