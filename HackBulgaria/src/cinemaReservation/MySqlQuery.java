package cinemaReservation;

import java.sql.*;

public class MySqlQuery {
	private static final String dbURL = "jdbc:mysql://localhost/Cinema?useSSl=false";
	private static final String user = "root";
	private static final String pass = "a0883200182";
	
	public static void showMovies() {
		try {
			
			ResultSet result = getOrderedMovies();
			System.out.println("Movies ordered by rating in descending order:");
			
			while (result.next()) {
				String movie = result.getString("name");
				System.out.printf("%s%n", movie);
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
	}
	
	private static ResultSet getOrderedMovies() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet result = null;
		try {
			 conn = getConnection();
			 String statement = "SELECT name FROM Movies " +
			 					"ORDER BY rating DESC";
			 stmt = conn.createStatement();
			 result = stmt.executeQuery(statement);
			 
		 } catch (SQLException e) {
			 e.getMessage();
		 }
		
		return result;
	}
	
	private static Connection getConnection() {
		Connection conn = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.getMessage();
		}
		
		try{
			conn = DriverManager.getConnection(dbURL, user, pass);
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
		return conn;
	}
}
