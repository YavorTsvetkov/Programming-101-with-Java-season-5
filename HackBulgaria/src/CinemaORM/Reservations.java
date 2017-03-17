package CinemaORM;

public class Reservations {
	private int ID;
	private String userName;
	private int projectionID;
	private int row;
	private int col;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getProjectionID() {
		return projectionID;
	}
	public void setProjectionID(int projectionID) {
		this.projectionID = projectionID;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	
	public Reservations() {
		
	}
	
	public Reservations(String userName, int projectionID, int row, int col) {
		setUserName(userName);
		setProjectionID(projectionID);
		this.setRow(row);
		this.setCol(col);
	}
}
