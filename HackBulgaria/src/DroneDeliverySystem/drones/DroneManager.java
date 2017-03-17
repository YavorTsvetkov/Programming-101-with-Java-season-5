package DroneDeliverySystem.drones;

import java.util.HashMap;
import java.util.Map;

public class DroneManager implements DroneManagerInterface{
	
	/**
	 * keeping available drones.
	 * key - drone id.
	 * value - drone and its quantity.
	 */
	private Map<Integer, DroneWrapper> availableDrones;
	
	/**
	 * Keeping unavailable drones.
	 * key - drone id.
	 * value drone and its quantity.
	 */
	private Map<Integer, DroneWrapper> unavailableDrones;
	
	
	public Map<Integer, DroneWrapper> getAvailableDrones() {
		return availableDrones;
	}

	public void setAvailableDrones(Map<Integer, DroneWrapper> drones) {
		this.availableDrones = drones;
	}

	public Map<Integer, DroneWrapper> getUnavailableDrones() {
		return unavailableDrones;
	}

	public void setUnavailableDrones(Map<Integer, DroneWrapper> drones) {
		this.unavailableDrones = drones;
	}
	
	public DroneManager(Map<Integer, DroneWrapper> drones) {
		this.setAvailableDrones(drones);
		this.setUnavailableDrones(new HashMap<Integer, DroneWrapper>());
	}
	
	public DroneManager() {
		this.availableDrones = new HashMap<Integer, DroneWrapper>();
		this.unavailableDrones = new HashMap<Integer, DroneWrapper>();
	}
	
	public void addAvailableDrone(Drone drone, int quantity) {
		if (getAvailableDrones().containsKey(drone.getId())) {
			int newQuantity = getAvailableDrones().get(drone.getId()).getQuantity() 
					+ quantity;
			getAvailableDrones().put(drone.getId(), new DroneWrapper(drone, newQuantity));
			
		} else {
			getAvailableDrones().put(drone.getId(), new DroneWrapper(drone, quantity));
		}
	}
	
	public void addUnavailableDrone(Drone drone, int quantity) {
		if (getUnavailableDrones().containsKey(drone.getId())) {
			int newQuantity = getUnavailableDrones().get(drone.getId()).getQuantity() 
					+ quantity;
			getUnavailableDrones().put(drone.getId(), new DroneWrapper(drone, newQuantity));
			
		} else {
			getUnavailableDrones().put(drone.getId(), new DroneWrapper(drone, quantity));
		}
	}
	
	public Map<Integer, DroneWrapper> getAssignedDrones(double weight) {
		Map<Integer, DroneWrapper> assignedDrones = new HashMap<Integer, DroneWrapper>();
		Map<Integer, DroneWrapper> availableDrones = getAvailableDrones();
		
		for (Map.Entry<Integer, DroneWrapper> entry : availableDrones.entrySet()) {
				
			DroneWrapper thisDrone = entry.getValue();
			int dronesQuantity = thisDrone.getQuantity();
			
			int dronesNumber = (int) Math.ceil(weight / thisDrone.getDrone().getCapacity());
			
			if (dronesNumber <= dronesQuantity) {
				assignedDrones.put(thisDrone.getDrone().getId(), 
						new DroneWrapper(thisDrone.getDrone(), dronesNumber));
				return assignedDrones;
				
			} else {
				assignedDrones.put(thisDrone.getDrone().getId(), 
						new DroneWrapper(thisDrone.getDrone(), dronesQuantity));
			}
			/**
			while (dronesQuantity > 0) {
				if (capacity >= weight) {
					return assignedDrones;
				}
				capacity += thisDrone.getDrone().getCapacity();
				assignedDrones.add(thisDrone.getDrone());
				dronesQuantity--;
			}
			**/
		}
		
		return null;
	}

	public boolean areThereAvailableDrones(double weight) {
		if (getAssignedDrones(weight).isEmpty()) {
			return false;
		}
		
		return true;
	}

	public int calcDronesNumber(double weight) {
		Map<Integer, DroneWrapper> assignedDrones = getAssignedDrones(weight);
		int dronesNumber = 0;
		
		for (Map.Entry<Integer, DroneWrapper> entry : assignedDrones.entrySet()) {
			dronesNumber += entry.getValue().getQuantity();
		}
		
		return dronesNumber;
	}
	/**
	public void decreaseDronsBattery(double distance) {
		int roundedDistance = (int)Math.ceil(distance);
		int battteryDecrement = roundedDistance * 1;
		
	}
	**/
	
	public void sendDrones(double weight) {
		Map<Integer, DroneWrapper> assignedDrones = getAssignedDrones(weight);
		
		for (Map.Entry<Integer, DroneWrapper> entry : assignedDrones.entrySet()) {
			Drone drone = entry.getValue().getDrone();
			int quantity = entry.getValue().getQuantity();
			addAvailableDrone(drone, - quantity);
			addUnavailableDrone(drone, quantity);
		}
	}
}
