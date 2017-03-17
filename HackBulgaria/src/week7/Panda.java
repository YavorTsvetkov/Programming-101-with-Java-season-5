package week7;

import week6.equalsHashCode.Person;

public class Panda implements Comparable<Panda> {
	
	private String name;
	private String email;
	private String gender;
	
	public Panda(String name, String email, String gender) {
		this.name = name;
		
		if (emailIsValid(email)) {
			this.email = email;
			
		} else {
			 throw new IllegalArgumentException("Non valid email!");
		}
		
		this.gender = gender;
	}
	
	private boolean emailIsValid(String email) {
		if (email.contains("@") && email.contains(".") && email.length() > 5) {
			return true;
			
		}
		
		return false;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public int hashCode() {
		return getName().hashCode() + getEmail().hashCode() + getGender().hashCode();
	}
	
	@Override 
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		if (this == obj) {
			return true;
		}
		
		if (this.getClass().equals(obj.getClass())) {
			Panda other = (Panda)obj;
			
			if (this.getName().equals(other.getName()) && 
					this.getEmail().equals(other.getEmail()) &&
					this.getGender().equals(other.getGender())) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isMale() {
		return this.getGender().equalsIgnoreCase("male");
	}
	
	public boolean isFemale() {
		return this.getGender().equalsIgnoreCase("female");
	}

	public int compareTo(Panda arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
