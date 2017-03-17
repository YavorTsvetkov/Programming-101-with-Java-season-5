package DroneDeliverySystem.drones;

public interface DroneManagerInterface {
	public boolean areThereAvailableDrones(double weight);
	public int calcDronesNumber(double weight);
	public void sendDrones(double weight);
}
