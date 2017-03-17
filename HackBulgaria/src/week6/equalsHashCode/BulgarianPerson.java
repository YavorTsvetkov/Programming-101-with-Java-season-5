package week6.equalsHashCode;

public class BulgarianPerson extends Person {
	private String ucn;
	
	public String getUcn() {
		return ucn;
	}
	
	@Override
	public int hashCode() {
		return getFirstName().hashCode() + getFirstName().hashCode();
	}
	
	
	//A - person              ("Ivan", "Ivanov")
	//B - BulgarianPerson     ("Ivan", "Ivanov", "123456")
	// A.equals(B) - true     ("Ivan", "Ivanov", "000000")
	//B.eqials(A) - true
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		if (this == obj) {
			return true;
		}
		
		
		
		if (obj instanceof BulgarianPerson) {
			BulgarianPerson other = (BulgarianPerson) obj;
			if (this.getFirstName().equals(other.getFirstName()) 
					&& this.getUcn().equals(other.getUcn())) {
				return true;
			}
		}
		
		if (obj instanceof Person) {
			Person other = (Person) obj;
			if (this.getFirstName().equals(other.getFirstName())) {
				return true;
			}
		}
		
		return false;
	}
}
