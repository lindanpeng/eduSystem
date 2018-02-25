package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	 private static final SessionFactory sessionFactory = buildSessionFactory();
    
	    private static SessionFactory buildSessionFactory() {
	        try {
	            // Create the SessionFactory from hibernate.cfg.xml
	            return new AnnotationConfiguration().configure().buildSessionFactory(
				    );//new StandardServiceRegistryBuilder().build()  not found
	        }
	        catch (Throwable ex) {
	            // Make sure you log the exception, as it might be swallowed
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }

	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
}
