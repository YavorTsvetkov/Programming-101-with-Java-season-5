package DroneDeliverySystem.drones;

public class DroneWrapper {
	private Drone drone;
	private int quantity;
	
	public Drone getDrone() {
		return drone;
	}
	public void setDrone(Drone drone) {
		this.drone = drone;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException("Cannot add negative drone quantity.");
		}
		
		this.quantity = quantity;
	}
	
	public DroneWrapper(Drone drone, int quantity) {
		setDrone(drone);
		setQuantity(quantity);
	}
	
	public void increaseQuantity(int quantity) {
		this.setQuantity(this.getQuantity() + quantity);
	}
}
