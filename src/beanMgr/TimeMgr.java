package beanMgr;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import beans.Time;
import util.HibernateUtil;

public class TimeMgr {
	public static List<Time> getAll(){
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("from Time");
		List<Time> times=query.list();
		session.getTransaction().commit();
		return times;
	}
}
