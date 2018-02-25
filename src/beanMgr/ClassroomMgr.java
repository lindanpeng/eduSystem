package beanMgr;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import beans.Classroom;
import util.HibernateUtil;

public class ClassroomMgr {
	public static List<Classroom> getAll(){
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("from Classroom");
		List<Classroom> classrooms=query.list();
		session.getTransaction().commit();
		return classrooms;
	}
}
