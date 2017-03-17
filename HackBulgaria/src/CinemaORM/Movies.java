package CinemaORM;

import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class Movies {
	private int ID;
	private String name;
	private double rating;
	
	private static SessionFactory factory;
	
	static {
		try {
			factory = new Configuration().
					configure("/reservationResources/hibernate.cfg.xml").
					buildSessionFactory();
			
		} catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	}
	
	
	public void setID(int ID) {
		this.ID = ID;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setRating(double rating) {

		this.rating = rating;
	}

	public int getID() {
		return this.ID;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getRating() {
		return this.rating;			
	}
	
	public Movies(){
		
	}	
	
	public Movies(String name, double rating) {
		setName(name);
		setRating(rating);
	}
	
	public static void addMovie(String name, double rating) {
		
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Movies blockbuster = new Movies(name, rating);
			session.save(blockbuster);
			tx.commit();
			
		} catch (HibernateException exc) {
			if (tx != null) {
				tx.rollback();
				exc.printStackTrace();
			}
			
		} finally {
			session.close();
		}
	}
	
	public static Iterator retrieveMovies() {
		Session session = factory.openSession();
		
		Transaction transaction = null;
		
		Iterator iterator = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM Movies");
			
			@SuppressWarnings("deprecation")
			List movies = query.list();
			iterator = movies.iterator();
			
			transaction.commit();
			
		} catch (HibernateException exc) {
			if (transaction != null) {
				transaction.rollback();
			}
			
			exc.printStackTrace();
			
		} finally {
			session.close();
		}
		
		return iterator;
	}
	
	public static void listMovies() {
		Iterator iterator = retrieveMovies();
		
		while (iterator.hasNext()) {
			Movies movie = (Movies)iterator.next();
			
			String name = movie.getName();
			double rating = movie.getRating();
			
			System.out.printf("[name: %s]  [rating: %.1f]%n", name, rating);
		}
	}
}
