package DroneDeliverySystem;

import java.awt.Point;
import DroneDeliverySystem.drones.Drone;
import DroneDeliverySystem.drones.DroneManager;
import DroneDeliverySystem.request.RequestManager;
import DroneDeliverySystem.warehouse.Product;
import DroneDeliverySystem.warehouse.Warehouse;
import DroneDeliverySystem.warehouse.WarehouseManager;

public class Initializer {
	private static final Product[] initProducts = {new Product(1, "Keyboard", 0.6),
										           new Product(2, "Table", 6.8),
										           new Product(3, "Car", 1500),
										           new Product(4, "Glass", 0.2)};
	
	private static final int[] initQuantities = {5, 3, 2, 4};
	
	public static RequestManager initRequestManager(){
		WarehouseManager warehouseManager = initWarehouseManager();
		DroneManager droneManager = initDroneManager();
		
		return new RequestManager(droneManager, warehouseManager);
	}
	
	private static WarehouseManager initWarehouseManager() {
		Warehouse firstWarehouse = new Warehouse(initProducts, initQuantities,
				new Point(42, 42));
		Warehouse secondWarehouse = new Warehouse(new Point(420, 420));
		WarehouseManager manager = new WarehouseManager();
		manager.addWarehouse(firstWarehouse);
		manager.addWarehouse(secondWarehouse);
		
		return manager;
	}
	
	private static DroneManager initDroneManager() {	
		Drone chineseDrone = new Drone(1, 1200, 200, 3);
		DroneManager droneM = new DroneManager();
		droneM.addAvailableDrone(chineseDrone, 30);
		
		return droneM;
	}
}
