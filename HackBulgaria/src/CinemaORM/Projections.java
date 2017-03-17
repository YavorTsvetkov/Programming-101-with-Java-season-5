package CinemaORM;

import java.util.List;
import java.sql.Time;
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Projections {
    private int projectionID;
    private int movieID;
    private String type;
    private Date date;
    private Time time;
    
    private static SessionFactory factory;
    
    static {
    	try {
    		factory = new Configuration()
    				.configure("/reservationResources/hibernate.cfg.xml")
    				.buildSessionFactory();
    		
    	}catch (Throwable ex) { 
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex); 
         }
    	
    }
    

    public int getProjectionID() {
        return projectionID;
    }

    public void setProjectionID(int projectionID) {
        this.projectionID = projectionID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Projections() {

    }

    public Projections(int movieID, String type, Date date, Time time) {
        setMovieID(movieID);
        setType(type);
        setDate(date);
        setTime(time);
    }
    
    public static void addProjection(int movieID,
    		String type,
    		Date date, 
    		Time time) {
    	Session session = factory.openSession();
    	
    	Transaction transaction = null;
    	
    	try {
    		transaction = session.beginTransaction();
    		Projections projection = new Projections(movieID, type, date, time);
    		session.save(projection);
    		transaction.commit();
    		
    	} catch (HibernateException exc) {
    		if (transaction != null) {
    			transaction.rollback();
    		}
    		
    		exc.printStackTrace();
    		
    	} finally {
    		session.close();
    	}
    } 
    
    public static void listProjections() {
    	Session session = factory.openSession();
    	
    	Transaction transaction = null;
    	
    	try {
    		transaction = session.beginTransaction();
    		Query query = session.createQuery("FROM Projections");
    		List results = query.list();
    		Iterator iterator = results.iterator();
    		
    		while (iterator.hasNext()) {
    			Projections projection = (Projections)iterator.next();
    			
    			int movieID = projection.getMovieID();
    			String movieName = retrieveMovieName(movieID);
    			
    			if (movieName == null) {
    				throw new NullPointerException("No such movie.");
    			}
    			
    			String type = projection.getType();
    			String date = projection.getDate().toString();
    			String time = projection.getTime().toString();
    			
    			System.out.printf("[movie: %s]  [type : %s]  [date: %s]  [time: %s]%n",
    					movieName, type, date, time);
    		}
    		
    	} catch (HibernateException exc) {
    		if (transaction != null) {
    			transaction.rollback();
    		}
    		 
    	} finally {
    		session.close();
    	}
    }
    
    private static String retrieveMovieName(int movieID) {
    	
    	Iterator movies = Movies.retrieveMovies();
    	
    	while (movies.hasNext()) {
    		Movies movie = (Movies)movies.next();
    		if (movie.getID() == movieID) {
    			return movie.getName();
    		}
    	}
    	
    	return null;
    }
}
