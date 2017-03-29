package week2.functionCallsExtension;

import week2.functionCallsExtension.CompCalculator.CompCalculator;

import java.util.Scanner;

public class Main {
	
	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		
		int n = Integer.parseInt(input.nextLine());
		String[] functions = new String[n];
		
		for (int i = 0; i < n; i++) {
			functions[i] = input.nextLine();
		}
		
		String composition = input.nextLine();
		
		int arg = Integer.parseInt(input.nextLine());
		
		
		CompCalculator calculator = new CompCalculator(functions);
		
		int result =  calculator.calcComposition(composition, arg);
		System.out.println(result);
	}
}
