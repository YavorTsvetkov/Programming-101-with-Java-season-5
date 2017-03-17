package DroneDeliverySystem.warehouse;

public class ProductWrapper {
	Product product;
	int quantity;
	
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		if (product == null) {
			throw new IllegalArgumentException("Product cannot be null. you are"
					+ "trying to set a product with a null value!");
		}
		
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		if (quantity < 0) {
			System.out.printf("Product with id %d is expiered.", getProduct().getId());
		}
		
		this.quantity = quantity;
	}
	
	
	public ProductWrapper(Product p, int q){
		this.product = p;
		this.quantity = q;
	}
	void increaseQuantity(int q){
		this.quantity += q;
	}
}
