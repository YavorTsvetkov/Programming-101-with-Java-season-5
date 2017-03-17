package cinemaReservation;

import java.sql.*;

public class Database {
	private String name;
	private final String url = "jdbc:mysql://localhost:3306/";
	private User user;
	
	private void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Illegal database name."); 
		}
		
		this.name = name;
	}
	
	private void setUser(User user) {
		if (user == null) {
			throw new IllegalArgumentException("Illegal user."); 
		}
		
		this.user = user;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public Database(String name, User user) {
		this.setName(name);
		this.setUser(user);
	}
	
	public void createDatabase() {
		System.out.println("Estabilishing connection...");
		Connection conn = getConnection();
		
		System.out.println("Executing query...");
		createQuery(conn);
		System.out.println("Database created successfully.");
	}
	
	private Connection getConnection() {
		String user = getUser().getName();
		String pass = getUser().getPassword();
		String url = getUrl();
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			e.getMessage();
		}
		
		try {
			
			conn = DriverManager.getConnection(url, user, pass);
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
		return conn;
	}
	
	private void createQuery(Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			String query = "CREATE DATABASE " + getName();
			boolean status = stmt.execute(query);
			
		} catch (SQLException e) {
			e.getMessage();
		}
	}
}
