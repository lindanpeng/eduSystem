package beanMgr;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import beans.College;
import util.HibernateUtil;

public class CollegeMgr {
	public static List<College> getAll(){
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("from College");
		List<College> colleges=query.list();
		session.getTransaction().commit();
		return colleges;
	}

}
