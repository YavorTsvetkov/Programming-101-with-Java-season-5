package week7;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String[] names = {"Ivo", "Gogo", "Zdravka", "Goshka", "Petar"};
		
		final String[] emails = {"ivo@pandamail.com",
												"gogo@pandamail.com",
												"zdravka@pandaemial.com",
												"goshka@pandaemial.com",
												"petar@pandaemail.com"};
		
		final String[] genders = {"m", "m", "f", "f", "f"}; 
		
		MySQLPanda db = new MySQLPanda();
		
		for (int i = 0; i < names.length; i++) {
			db.insert(names[i], emails[i], genders[i]);
		}
		
		
		
		db.printResultSet();

		
		/**
		Panda ivo = new Panda("Ivo", "ivo@pandamail.com", "male");
		Panda gogo = new Panda("Gogo", "gogo@pandamail.com", "male");
		Panda zdravka = new Panda("Zdravka", "zdravka@pandamail.com", "female");
		Panda goshka = new Panda("Goshka", "goshka@pandaemail.com", "female");
		Panda petar = new Panda("Petar", "petar@pandaemail.com", "male");
		
		PandaSocialNetwork pandaFacebook = new PandaSocialNetwork();
		
		pandaFacebook.addPanda(ivo);
		pandaFacebook.addPanda(gogo);
		pandaFacebook.addPanda(zdravka);
		pandaFacebook.addPanda(goshka);
		pandaFacebook.addPanda(petar);
		
		pandaFacebook.makeFriends(zdravka, goshka);
		pandaFacebook.makeFriends(ivo, gogo);
		pandaFacebook.makeFriends(gogo, zdravka);
		
		//System.out.println(pandaFacebook.areFriends(goshka, zdravka));
		//System.out.println(pandaFacebook.areFriends(ivo, goshka));
		
		System.out.println(pandaFacebook.areConnected(ivo, petar));
		**/
	}

}
