package week2.GameOfLife;

import java.util.*;

public class GameOfLife {
	
	public static void main(String[] args) {
		List<List<Integer>> coords = readCoordinates();
		GameOfLife game = new GameOfLife(coords);
		
		game.start();
	}
	
	public static List<List<Integer>> readCoordinates() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter coordinates:");
		
		int n = Integer.parseInt(input.nextLine());
		List<List<Integer>> coords = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < n; i++) {
			String[] line = input.nextLine().split(" ");
			
			int xCoord = Integer.parseInt(line[0]);
			int yCord = Integer.parseInt(line[1]);
			List<Integer> point = new ArrayList<Integer>();
			
			point.add(xCoord);
			point.add(yCord);
			
			coords.add(point);
		}
		
		return coords;
		
	}
	
	private int[][] currentMatrix;
	
	//keeping the row and the column of the current cell
	private int currentRow;
	private int currentCol;
	
	private int matrixDegree = 20;
	
	private final char alive = 9632;
	private final char dead = 9633;
	

	private void setCurrentMatrix(int[][] matrix) {
		for (int row = 0; row < currentMatrix.length; row++) {
			for (int col = 0; col < this.currentMatrix[0].length; col++) {
				this.currentMatrix[row][col] = matrix[row][col];
			}
		}
		
	}
	
	public GameOfLife(List<List<Integer>> coords) {
		this.currentMatrix = new int[matrixDegree][matrixDegree];
		
		//setting current matrix 
		for (int i = 0; i < coords.size(); i++) {
			int row = coords.get(i).get(0);
			int col = coords.get(i).get(1);
			
			this.currentMatrix[row - 1][col - 1] = 1;
		}
	}
	
	public void start() {
		while (true) {
			this.print();
			makeNextGeneration();
			
			try{
				Thread.sleep(700);
				
			} catch(Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
			//clear the console
			for(int j = 0; j < 1000; j++)
			{
			    System.out.println("\b");
			}
		}
	}
	
	public void makeNextGeneration() {
		int[][] futureMatrix = new int[this.matrixDegree][this.matrixDegree];
		
		for (int row = 0; row < this.currentMatrix.length; row++) {
			this.currentRow = row;
			
			for (int col = 0; col < this.currentMatrix[0].length; col++) {
				this.currentCol = col;
				
				//sum of neighbours cells
				int sum = calcSumOfNeighbours(row, col);
				
				//if current cell is alive
				if (this.currentMatrix[row][col] == 1) {
					
					if (sum == 2 || sum == 3) {
						//cell lives
						futureMatrix[row][col] = 1;
					}
					
				//if current cell is dead	
				} else {
					if (sum == 3) {
						futureMatrix[row][col] = 1;
					}
				}
			}
		}
		
		this.setCurrentMatrix(futureMatrix); 
	}
	
	private int calcSumOfNeighbours(int row, int col) {
		int[][]matrix = this.currentMatrix;
		
		if (isTopLeftCell(row, col)) {
			return calcSum(0, 1, 0, 1);
			
		} else if (isTopRightCell(row, col)) {
			return calcSum(0, 1, matrix[0].length - 2, matrix[0].length - 1);
			
		} else if (isLowerLeftCell(row, col)) {
			return calcSum(matrix.length - 2, matrix.length - 1, 0, 1);
			
		} else if (isLowerRightCell(row, col)) {
			return calcSum(matrix.length - 2, matrix.length - 1, 
						  matrix[0].length - 2, matrix[0].length - 1);
			
		} else if (isUpperBoundCell(row, col)) {
			return calcSum(0, 1, col - 1, col + 1);
			
		} else if (isLowerBoundCell(row, col)) {
			return calcSum(matrix.length - 2, matrix.length - 1,
						   col - 1, col + 1);
			
		} else if (isLeftBoundCell(row, col)) {
			return calcSum(row  - 1, row + 1, 0, 1);
			
		} else if (isRightBoundCell(row, col)) {
			return calcSum(row - 1, row + 1, 
							matrix[0].length - 2, matrix[0].length - 1);
			
		//if is middle cell
		} else {
			return calcSum(row - 1, row + 1, col - 1, col + 1);
		}
	}
	
	private int calcSum(int startRow,
						int endRow,
						int startCol,
						int endCol) {
		
		int[][] matrix = this.currentMatrix;
		int sum = 0;
		
		for (int row = startRow; row <= endRow; row++) {
			for (int col = startCol; col <= endCol; col++) {
				if (row == this.currentRow && col == this.currentCol) {
					continue;
				}
				
				sum += matrix[row][col];
			}
		}
		
		return sum;
	}	
	private boolean isUpperBoundCell(int row, int col) {
		return row == 0 &&(col > 0 &&
						   col < this.currentMatrix[0].length - 1);
	}
	
	private boolean isLowerBoundCell(int row, int col) {
		return row == this.currentMatrix.length - 1 &&
				(col > 0 &&
				 col < this.currentMatrix[0].length - 1);
	}
	
	private boolean isLeftBoundCell(int row, int col) {
		return (row > 0 && 
				row < this.currentMatrix.length - 1) &&
				col == 0 ;
	}
	
	private boolean isRightBoundCell(int row, int col) {
		return (row > 0 && 
				row < this.currentMatrix.length - 1) &&
				col == this.currentMatrix[0].length - 1;
	}
	
	private boolean isTopLeftCell(int row, int col) {
		return col == 0 && row == 0;
	}
	
	private boolean isTopRightCell(int row, int col) {
		return col == this.currentMatrix[0].length - 1 &&
				row == 0;
	}
	
	private boolean isLowerLeftCell(int row, int col) {
		return col == 0 &&
				row == this.currentMatrix.length - 1;
	}
	
	private boolean isLowerRightCell(int row, int col) {
		return col == this.currentMatrix[0].length - 1 &&
				row == this.currentMatrix.length - 1;
	}
	
	public void print() {
		int[][] matrix = this.currentMatrix;
		
		for(int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				int element = matrix[row][col];
				
				if (element == 1) {
					System.out.print(alive + " ");
					
				} else {
					System.out.print(dead + " ");
				}
				
			}
			
			System.out.println();
		}
	}
}
