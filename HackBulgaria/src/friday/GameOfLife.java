package friday;

public class GameOfLife {
	private char[][] matrix;
	private char live = '■';
	private char dead = '□';
	
	public GameOfLife() {
		matrix = new char[20][20];
		for(int row = 0; row < matrix.length; row++) {
			for(int col = 0; col <matrix[row].length; col++ ){
				matrix[row][col] = this.dead;
			}
		}
		
		while(true) {
			char currentElement;
			for(int row = 0; row < matrix.length - 1; 	row++) {
				for(int col = 0; col < matrix[0].length - 1; col++) {
					currentElement = matrix[row][col];
					if(row == 0) {
						
					}
				}
			}
		}
	}
	
	public int rowLength() {
		return matrix.length;
	}
	
	public int colLength() {
		return matrix[0].length;
	}
	
	
}
