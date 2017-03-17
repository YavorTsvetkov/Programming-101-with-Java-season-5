package DroneDeliverySystem.request;

import DroneDeliverySystem.warehouse.*;

import java.awt.Point;
import java.util.Date;
import java.util.Iterator;
import java.util.Queue;

import DroneDeliverySystem.drones.*;
import DroneDeliverySystem.supply.Supply;

public class RequestManager {
	
	private DroneManager droneManager;
	private WarehouseManager warehouseManager;
	
	
	public DroneManager getDroneManager() {
		return droneManager;
	}

	public void setDroneManager(DroneManager droneManager) {
		this.droneManager = droneManager;
	}

	public WarehouseManager getWarehouseManager() {
		return warehouseManager;
	}

	public void setWarehouseManager(WarehouseManager warehouseManager) {
		this.warehouseManager = warehouseManager;
	}

	public RequestManager(DroneManager droneManager, WarehouseManager warehouseManager) {
		this.setDroneManager(droneManager);
		this.setWarehouseManager(warehouseManager);
	}
	
	public void processRequest(Request request) {
		int requestId = request.getId();
		int requestQuantity = request.getQuantity();
		
		double weight = 0;
		int dronesNumber = 0;
		
		if (getWarehouseManager().isProductAvailable(requestId, requestQuantity)) {
			weight = getWarehouseManager().calcWeightUnit(requestId, requestQuantity);
			
		} else {
			System.out.printf("I am sorry, we don' t have enough quantity"
					+ " of product with id %d%n", requestId); 
			return;
		}
		
		if (getDroneManager().areThereAvailableDrones(weight)) {
			dronesNumber = getDroneManager().calcDronesNumber(weight);
			
		} else {
			System.out.printf("I am sorry, we don' t have available drones "
					+ "to deliver product with id %d%n", requestId);
			return;
		}
		
		getWarehouseManager().decreaseProductQuantity(requestId, requestQuantity);
		
		getDroneManager().sendDrones(weight);
		
		String estimatedTime = estimateTime(request);
		
		System.out.printf("Product id %d delivered at %s "
				+ "with %d drone(s).%n", requestId, 
				                         estimatedTime, 
										 dronesNumber);
	}
	
	private String estimateTime(Request request) {
		double distance = calcDistance(request);
		System.out.printf("Distance: %.2f", distance);
		int velocity = 1;
		
		int roundedDistance = (int)Math.ceil(distance);
		int minutes = roundedDistance / velocity;
		Date timestamp = request.getTimestamp();
		
		long timestampSeconds = (long)timestamp.getTime();
		
		long resultTime = timestampSeconds + (minutes * 60)*1000;
		//timestamp.setMinutes(timestamp.getMinutes() + minutes);
		Date date = new Date(resultTime);
		return date.toString();
	}
	
	public double calcDistance(Request request) {
		/**
		int id = request.getId();
		int quantity = request.getQuantity();
		
		Warehouse warehouse = this.warehouseManager.
								   getContractorWarehouse(id, quantity);
		**/
		Warehouse warehouse = warehouseManager.getWarehouses().get(2);
		Point warehouseAddress = warehouse.getCoordinates();
		Point requestAddress = new Point(request.getRowAdress(), request.getColumnAdress());
		
		double deltaRow = warehouseAddress.getY() - requestAddress.getY();
		double deltaColumn = warehouseAddress.getX() - requestAddress.getX();
		double sumOfSquares = deltaRow * deltaRow + deltaColumn * deltaColumn;
		
		double distance = Math.sqrt(sumOfSquares);
		
		return distance;
	}
	
	public void processSupply(Queue<Supply> supplies) {
		for (Supply supply : supplies) {	
			int productID = supply.getProductInfo().getId();
			int quantity = supply.getProductInfo().getQuantity();
			int warehouseID = supply.getWarehouseID();
			Warehouse correspondingWarehouse = this.warehouseManager.
					retrieveWarehouse(warehouseID);
	
			if (correspondingWarehouse == null) {
				throw new IllegalArgumentException("There is no such warehouse with id "
						+ productID);
			}
			
			correspondingWarehouse.incrementProductQuantity(productID, quantity);
			System.out.println("Suppply successed!");
		}
	} 
}
