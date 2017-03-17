package DroneDeliverySystem.request;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Request {

	private Date timestamp;
	
	private int rowAdress;
	
	private int columnAdress;
	
	private int id;
	
	private int quantity;
	
	
	public Date getTimestamp() {
		return timestamp;
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
	public int getRowAdress() {
		return rowAdress;
	}
	
	public void setRowAdress(int rowAdress) {
		this.rowAdress = rowAdress;
	}
	
	public int getColumnAdress() {
		return columnAdress;
	}
	
	public void setColumnAdress(int columnAdress) {
		this.columnAdress = columnAdress;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Request(String timestamp, int rowAdress, int colAdress,
				   int id, int quantity) {
		setTimestamp(timestamp);
		setRowAdress(rowAdress);
		setColumnAdress(colAdress);
		setId(id);
		setQuantity(quantity);
	}
	
	public static Queue<Request> readRequest() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter time stamp: ");
		String timestamp = input.nextLine();
		
		
		System.out.print("Enter row: ");
		int row = Integer.parseInt(input.nextLine());
		
		System.out.print("Enter column: ");
		int column = Integer.parseInt(input.nextLine());
		
		System.out.print("Enter the number of deliveries: ");
		int n = Integer.parseInt(input.nextLine());
		
		Queue<Request> requests = new LinkedList<Request>();
		
		for (int i = 0; i < n; i++) {
			System.out.print("Enter product id: ");
			int id = Integer.parseInt(input.nextLine());
			
			System.out.print("Enter product quantity: ");
			int quantity = Integer.parseInt(input.nextLine());
			Request req = new Request(timestamp, row, column, id, quantity);
			
			requests.add(req);
		}
		
		return requests;
	}
}
