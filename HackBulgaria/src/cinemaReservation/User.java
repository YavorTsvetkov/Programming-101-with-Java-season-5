package cinemaReservation;

public class User {
	
	private String name;
	private String password;
	
	private void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Illegal user name.");
		}
		
		this.name = name;
	}
	
	private void setPassword(String password) {
		if (password == null) {
			throw new IllegalArgumentException("Illegal password.");
		}
		
		this.password = password;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public User(String name, String password) {
		setName(name);
		setPassword(password);
	}
}
