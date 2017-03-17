package DroneDeliverySystem.warehouse;

import java.util.HashMap;
import java.util.Map;

public class WarehouseManager implements WarehouseManagerInterface {
	
	/**
	 * keeps all warehouses.
	 * key - warehouse ID
	 * value - warehouse
	 */
	private Map<Integer, Warehouse> warehouses;

	public Map<Integer, Warehouse> getWarehouses() {
		return warehouses;
	}
	
	public void setWarehouses(Map<Integer, Warehouse> warehouses) {
		this.warehouses = warehouses;
	}
	
	public WarehouseManager() {
		this.warehouses = new HashMap<Integer, Warehouse>();
	}

	public WarehouseManager(Map<Integer, Warehouse> warehousesList) {
		this.setWarehouses(warehousesList);
	}

	public void addWarehouse(Warehouse w) {
		int newID = getWarehouses().size() + 1;
		getWarehouses().put(newID, w);
	}
	
	/**
	 * Searching a product in all warehouses by its ID and desired quantity.
	 * @param id - desired product ID
	 * @param quantity - desired product quantity
	 * @return - product wrapper (product and its quantity) if the product has enough quantity
	 * or null if the product has less quantity than desired.
	 */
	private ProductWrapper searchProductAndQuantity(int id, int quantity) {
		for (Map.Entry<Integer, Warehouse> entry : warehouses.entrySet()) {
			Warehouse currentWarehouse = entry.getValue();
			Map<Integer, ProductWrapper> products = currentWarehouse.getProducts();
			
			if (products.containsKey(id)) {
				if (products.get(id).getQuantity() >= quantity) {
					return products.get(id);
				}
			}
		}
		return null;
	}

	public boolean isProductAvailable(int id, int quantity) {
		ProductWrapper product = searchProductAndQuantity(id, quantity);
		
		if (product == null) {
			return false;
		}
		
		return true;
	}

	public double calcWeightUnit(int id, int quantity) {
		ProductWrapper product = searchProductAndQuantity(id, quantity);
		
		if (product == null) {
			throw new IllegalArgumentException(
					"There is no such product in the warehouses.");
		}
		
		return product.getProduct().getWeight() * quantity;
	}

	public void decreaseProductQuantity(int id, int quantity) {
		ProductWrapper product = searchProductAndQuantity(id, quantity);
		int newQuantity = product.getQuantity() - quantity;
		
		product.setQuantity(newQuantity);
	}

	public Warehouse getContractorWarehouse(int id, int quantity) {
		for (Map.Entry<Integer, Warehouse> entry : warehouses.entrySet()) {
			Warehouse currentWarehouse = entry.getValue();
			Map<Integer, ProductWrapper> products = currentWarehouse.getProducts();
			
			if (products.containsKey(id)) {
				if (products.get(id).getQuantity() >= quantity) {
					return currentWarehouse;
				}
			}
		}	
		
		return null;
	}
	
	public Warehouse retrieveWarehouse(int warehouseID) {
		for (Map.Entry<Integer, Warehouse> warehouse : this.warehouses.entrySet()) {
			if (warehouse.getKey() == warehouseID) {
				return warehouse.getValue();
			}
		}
		
		return null;
	}
			
}
