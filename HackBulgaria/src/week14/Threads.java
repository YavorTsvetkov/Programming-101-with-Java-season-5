package week14;



public class Threads {
	
	private static class Task implements Runnable {
		
		
		public void run() {
		int counter = 100;
		 while (counter > 0) {
			 counter--;
			 System.out.println("Runnng: " + counter);
		 }
			
		}
		
	}
	
	public static void main(String[] args) {
		Task task = new Task();
		task.run();
		System.out.println("Done");
	}
}
