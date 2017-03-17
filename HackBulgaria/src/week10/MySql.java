package week10;

import java.sql.*;

public class MySql {

	private static final String dbURL = "jdbc:mysql://localhost/firma?useSSl=false";
	private static final String user = "root";
	private static final String pass = "a0883200182";
	
	static final String[] names = {"Ivo", "Gogo", "Zdravka", "Goshka", "Grisho"};
	
	static final String[] emails = {"ivo@pandamail.com",
											"gogo@pandamail.com",
											"zdravka@pandaemial.com",
											"goshka@pandaemial.com",
											"petar@pandaemail.com"};
	
	static final String[] genders = {"m", "m", "f", "f", "f"}; 
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection conn = DriverManager.getConnection(dbURL, user, pass);
			String query = "INSERT INTO clients" +
					"(name, age)" + 
					"VALUES (?, ?)";
			PreparedStatement stmt = conn.prepareStatement(query);
			for (int i = 0; i < names.length; i++) {
				stmt.setString(1, names[i]);
				stmt.setInt(2, i);
				int rows = stmt.executeUpdate();
				System.out.printf("rows affected %d%n%n", rows);
			}
			
			
			
			
			
			query = "SELECT * FROM clients";
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				System.out.printf("name: %s age: %d%n", name, age);
			}
			
			
		} catch (SQLException e) {
			
		}
		
	}
	
	
}
