package week7;

import java.sql.*;


public class MySQLPanda {
	
	private static final String DB_URL = "jdbc:mysql://localhost/pandaSocialNetwork?useSSL=false";
	private static final String user = "root";
	private static final String pass = "a0883200182";
	
	
	private Connection connection;
	private Statement statement;
	private PreparedStatement prepStatement;
	private ResultSet resultSet;
	
	private static void getDriver() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException exc) {
			exc.getMessage();
		}
	}
	
	private void setupConnection() {
		getDriver();
		
		try {
			this.connection = DriverManager.getConnection(DB_URL, user, pass);
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	
	public void insert(String name, String email, String gender) {
		setupConnection();
		try {
			String insert = "INSERT INTO pandas" +
					"(name, email, gender)" + 
					"VALUES (?, ?, ?)";
			
			this.prepStatement = this.connection.prepareStatement(insert);
			this.prepStatement.setString(1, name);
			this.prepStatement.setString(2, email);
			this.prepStatement.setString(3, gender);
			
			int rows = this.prepStatement.executeUpdate();
			
			System.out.printf("%d rows affected%n", rows);
			
		} catch (Exception e) {
			e.getMessage();
		}
			
	}
	
	public void printResultSet() {
		try {
			String select = "SELECT * FROM pandas";
			this.statement = this.connection.createStatement();
			this.resultSet = this.statement.executeQuery(select);
			
			while (this.resultSet.next()) {
				String name = this.resultSet.getString("name");
				String email = this.resultSet.getString("email");
				String gender = this.resultSet.getString("gender");
				
				System.out.printf("name: %s, email: %s, gender: %s%n",name, email, gender);
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
