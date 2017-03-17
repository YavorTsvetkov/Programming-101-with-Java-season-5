package cinemaReservation;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User user = new User("root", "a0883200182");
		
		Database db = new Database("Alabala", user);
		//db.createDatabase();
		
		
		MySqlQuery.showMovies();
		
	}

}
