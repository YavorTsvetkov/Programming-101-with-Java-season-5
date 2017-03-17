package DroneDeliverySystem.supply;

import java.awt.Point;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Supply {

	private int warehouseID;
	private Date timestamp;
	private ProductWrapper productInfo; 
	private Point deliveryAddress;
	private int quantity;
	
	public int getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(int warehouseID) {
		this.warehouseID = warehouseID;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public ProductWrapper getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductWrapper productInfo) {
		this.productInfo = productInfo;
	}

	public Point getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Point deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public void setTimestamp(String timestamp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = null;
		try {
			date = sdf.parse(timestamp);
			
		} catch (ParseException exc) {
			exc.getMessage();
		}
		
		this.timestamp = date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Supply(int warehouseID, String timestamp, ProductWrapper productInfo) {
		this.warehouseID = warehouseID;
		setTimestamp(timestamp);
		this.productInfo = productInfo;
	}
	
	public static Queue<Supply> readSupply() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter supply:");
		Queue<Supply> supplies = new LinkedList<Supply>();
		
		String[] line = input.nextLine().split(" ");
		
		int warehouseID = Integer.parseInt(line[1]);
		String dateAndTime = String.format("%s %s", line[2], line[3]);
		
		//calculating how much supplies we have. Every product has 2 elements
		//We don' t need first 4 elements.
		int n = (line.length - 4) / 2;
		
		int startIndex = 4;
		
		for (int i = 0; i < n; i++) {
			ProductWrapper productInfo = readProductInfo(line, startIndex);
			Supply supply = new Supply(warehouseID, dateAndTime, productInfo);

			supplies.add(supply);
			startIndex += 2;
		}
		
		return supplies;
	}
	
	private static ProductWrapper readProductInfo(String[] line, int startIndex) {
		int productID = Integer.parseInt(line[startIndex]);
		int productQuantity = Integer.parseInt(line[startIndex + 1]);
		ProductWrapper productInfo = new ProductWrapper(productID, productQuantity);
		
		return productInfo;
	}
	
}
