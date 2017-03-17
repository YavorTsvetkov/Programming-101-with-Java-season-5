package DroneDeliverySystem.warehouse;

public interface WarehouseManagerInterface {
	
	/**
	 * checks if a product has enough quantity.
	 * @param id
	 * @param quantity
	 * @return
	 */
	public boolean isProductAvailable(int id, int quantity);
	
	/**
	 * Calculates the weight of a request.
	 * @param id
	 * @param quantity
	 * @return
	 */
	public double calcWeightUnit(int id, int quantity);
	
	public void decreaseProductQuantity(int id, int quantity);
	
	public Warehouse getContractorWarehouse(int id, int quantity);
}
