package DroneDeliverySystem.drones;

public class Drone implements Comparable<Drone> {
	private int id;
	private int battery;
	private double capacity;
	private int chargingRate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBattery() {
		return battery;
	}
	public void setBattery(int battery) {
		this.battery = battery;
	}
	public double getCapacity() {
		return capacity;
	}
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	public int getChargingRate() {
		return chargingRate;
	}
	public void setChargingRate(int chargingRate) {
		this.chargingRate = chargingRate;
	}
	
	
	public Drone(int id, int battery, double capacity, int chargingRate) {
		this.setId(id);
		this.setBattery(battery);
		this.setCapacity(capacity);
		this.setChargingRate(chargingRate);
	}
	
	@Override
	public int hashCode() {
		return getId() + getBattery() + (int)getCapacity() + getChargingRate();
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		
		if (object == this) {
			return true;
		}
		
		if (object.getClass().equals(this.getClass())) {
			Drone other = (Drone)object;
			
			if (this.getId() == other.getId() && this.getBattery() == other.getBattery()&&
					this.getCapacity() == other.getCapacity() && 
					this.getChargingRate() == other.getChargingRate()) {
				return true;
			}
		}
		
		return false;
	}
	
	public int compareTo(Drone o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
