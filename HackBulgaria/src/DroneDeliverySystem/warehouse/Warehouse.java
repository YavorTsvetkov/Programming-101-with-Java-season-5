package DroneDeliverySystem.warehouse;


import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {
	private Point coordinates;

	/**
	 * keeps information about the products in the warehouse.
	 * key - product id.
	 * value - product and its quantity
	 */
	private Map<Integer, ProductWrapper> products;

	
	public Point getCoordinates() {
		return coordinates;
	}
	
	private void setCoordinates(Point coordinates) {
		this.coordinates = new Point(coordinates);
	}

	private void setProducts(Product[] products, int[] quantities) {
		for (int i = 0; i < products.length; i++) {
			this.addProduct(products[i], quantities[i]);
		}
	}
	
	public Map<Integer, ProductWrapper> getProducts() {
		return this.products;
	} 

	public Warehouse(Product[] products, int[] quantities, Point coordinates) {
		this.products = new HashMap<Integer, ProductWrapper>();
		this.setProducts(products, quantities);
		this.setCoordinates(coordinates);
	}
	
	public Warehouse(Point coordinates) {
		this.products = new HashMap<Integer, ProductWrapper>();
		this.setCoordinates(coordinates);
	}
	
	public void addProduct(Product product, int quantity) {
		if (getProducts().containsKey(product.getId())) {
			getProducts().get(product.getId()).increaseQuantity(quantity);
			
		} else {
			getProducts().put(product.getId(), new ProductWrapper(product, quantity));
		}
	}
	
	public void incrementProductQuantity(int productID, int quantity) {
		if (!getProducts().containsKey(productID)) {
			throw new IllegalArgumentException("There is no such product "
					+ "that corresponds to id " + productID);
		}
		int newQuantity = getProducts().get(productID).getQuantity() + quantity;
		getProducts().get(productID).setQuantity(newQuantity);
	}

}
