package beanMgr;

import org.hibernate.Session;

import beans.Content;
import util.HibernateUtil;

public class ContentMgr {
	public static String get(){
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Content content=(Content)session.get(Content.class,1);
		session.getTransaction().commit();
		return content.getContent();
	}
	public static void save(Content content){
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(content);
		session.getTransaction().commit();
		
	}
}
