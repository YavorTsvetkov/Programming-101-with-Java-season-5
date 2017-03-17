package DroneDeliverySystem;

import java.util.*;

import DroneDeliverySystem.request.Request;
import DroneDeliverySystem.supply.Supply;
import DroneDeliverySystem.request.*;

public class Main {

	public static void main(String[] args) {
		/**
		Queue<Request> requests = Request.readRequest();
		
		RequestManager reqM = Initializer.initRequestManager();
		
		Iterator<Request> iterator = requests.iterator();
		while (iterator.hasNext()) {
			reqM.processRequest(iterator.next());
		}
		
		int availableDronesNum = reqM.getDroneManager().getAvailableDrones().get(1).getQuantity();
		int unavalableDronesNum = reqM.getDroneManager().getUnavailableDrones().get(1).getQuantity();
		
		System.out.printf("Available drones number: %d%n", availableDronesNum);
		System.out.printf("Unavailable drones number: %d", unavalableDronesNum);
	
		
		Queue<Supply> supplies = Supply.readSupply();
		System.out.println(supplies.size());
		**/
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("What would you like to do? Request or supply? "
				+ "For request type 'request' for supply type 'supply'");
		
		String keyWord = input.nextLine();
		
		RequestManager reqM = Initializer.initRequestManager();
		
		if (keyWord.equals("request")) {
			Queue<Request> requests = Request.readRequest();
			
			for (Request request : requests) {
				reqM.processRequest(request);
				
			}
			
			int availableDronesNum = reqM.getDroneManager()
					.getAvailableDrones()
					.get(1).getQuantity();
			int unavalableDronesNum = reqM.getDroneManager()
					.getUnavailableDrones()
					.get(1)
					.getQuantity();
			
			System.out.printf("Available drones number: %d%n", availableDronesNum);
			System.out.printf("Unavailable drones number: %d", unavalableDronesNum);
			
		} else if (keyWord.equals("supply")) {
			Queue<Supply> supplies = Supply.readSupply();
			reqM.processSupply(supplies);
			
		} else {
			System.out.println("Please type 'request' or 'supply'");
		}
	}
}
