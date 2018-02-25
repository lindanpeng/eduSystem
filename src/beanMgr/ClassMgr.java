package beanMgr;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import beans.Class;
import util.HibernateUtil;
public class ClassMgr {
public static List<Class> getAll(){
	Session session=HibernateUtil.getSessionFactory().getCurrentSession();
	//session.beginTransaction();
	Query query=session.createQuery("from Class");
	List<Class> classes=query.list();
	//session.getTransaction().commit();
	return classes;
}
public static List<Class> findByCollege(String college){
	Session session=HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	Query query=session.createQuery("from Class where college = ? ");
	query.setString(0, college);
	List<Class> classes=query.list();
	session.getTransaction().commit();
	return classes;
}
public static List<Class> getSelectiveData(Map<String,Object> map,int startPos,int size){
	Session session=HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	DetachedCriteria dc=DetachedCriteria.forClass(Class.class);
	if(map!=null){
		for (Map.Entry<String,Object> entry : map.entrySet()) {  
		  dc.add(Restrictions.eq(entry.getKey(),entry.getValue()));
		}  
	}
	List<Class> classes=dc.getExecutableCriteria(session).setFirstResult(startPos).setMaxResults(size).list();
	session.getTransaction().commit();
	return classes;
}
}
