package week6.equalsHashCode;

public class Person {
	
	public final String firstName = "Asen";
	public  String secondName;
	public int timeAccessed; // broim kolko pati edin person bil dostapen - ne e nujno da se sravnqva
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getSecondName() {
		return this.secondName;
	}
	
	/*
	@Override
	public int hashCode() {
		return getFirstName().hashCode();
	}
	*/
	
	@Override
	public int hashCode() {
		return firstName.hashCode();
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
			Person other = (Person)obj;
			
			if (this.getFirstName().equals(other.getFirstName()) 
					&& this.getSecondName().equals(other.getSecondName())) {
				return true;
			}
		}
		
		return false;
	}
	
	/*
	// a.equals(a) - true
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		if (this == obj) {
			return true;
		}
		
		/*
		//ako sa ot ednakav klas, kastvame obj kam Person clas
		if (this.getClass().equals(obj.getClass())) {
			Person other = (Person)obj;
			
			//sravnqvame atributite
			//hubavo e pri izvikvane na atributi da polzvame getari
			if (this.getFirstName().equals(other.getFirstName()) && this.secondName.equals(other.secondName)) {
				return true;
			}
		}
		*/
		//BulgarianPerson instanceof Person - true
		// Person instanceof BulgarianPerson - false
		
		//prov dali obj e bulgPerson i sravnqvame
		// prov dali obj e person i sravn
	/*
		if (obj instanceof BulgarianPerson) {
			if (this.getFirstName().equals(other.getFirstName())) {
				return true;
			}
		}
		
		else if (obj instanceof Person) {
			Person other = (Person) obj;
			if (this.getFirstName().equals(other.getFirstName())) {
				return true;
			}
		}
		
		return false;
	}
*/
}
