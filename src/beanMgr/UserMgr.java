package beanMgr;

import org.hibernate.Query;
import org.hibernate.Session;

import beans.User;
import util.HibernateUtil;

public class UserMgr {
	public static User find(String userid){
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		User user= (User)session.get(User.class,userid);
		session.getTransaction().commit();
		return user;
	}
	public static void changePw(String userid,String password){
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("update User set password = ? where userid = ? ");
		query.setString(0, password);
		query.setString(1, userid);
		query.executeUpdate();
		session.getTransaction().commit();
	}
}
