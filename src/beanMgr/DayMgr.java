package beanMgr;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import beans.Day;
import util.HibernateUtil;

public class DayMgr {
	public static List<Day> getAll(){
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("from Day");
		List<Day> days=query.list();
		session.getTransaction().commit();
		return days;
	}
}
