package friday;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		/*
		char[][] matrix = new char[5][5];
		char live = '■';
		char dead = '□';
		
		for(int row = 0; row < matrix.length; row++) {
			for(int col = 0; col <matrix[row].length; col++ ){
				matrix[row][col] = dead;
			}
		}
		
		for(int row = 1; row < matrix.length; row++) {
			for(int col = 1; col <matrix[row].length; col++ ){
				if(row == 0) {
					if(col == 0) {
						char current = matrix[row][col];
						char next = matrix[row][col + 1];
					}
					else if(col > 0 && col < matrix[0].length) {
						
					}
					else{
						
					}
				}
				
			}
		}
		*/
		
		System.out.println(10 % 11);
	}
	
	public static void printGame(char[][] matrix){
		for(int row = 0; row < matrix.length; row++) {
			for(int col = 0; col <matrix[row].length; col++ ){
				System.out.print(matrix[row][col]);
			}
			System.out.println();
		}
	}

}
