package week10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TypeChecking {

	private static Scanner input;
	
	public static void main(String[] args) {
		Map<String, String[]> funcs = readFunctions();
		String[] composition =  readFunctionComposition();
		
		String innerFunction = composition[1];
		String outerFunction = composition[0];
		
		if (funcs.get(innerFunction)[1].equals(funcs.get(outerFunction)[0])) {
			System.out.println("True");
			

		} else {
			
			System.out.println("False");
		}
	}
	
	/**
	 * Reads functions definitions.
	 * First takes number of functions n as input and then reads function definition n time.
	 * Functions definitions is kept in a map where: 
	 * key - function's name.
	 * value - String array with first element - argument type and 
	 *         and second element result type.
	 * @return Map with functions definitions.
	 */
	public static Map<String, String[]> readFunctions() {
		input = new Scanner(System.in);
		
		System.out.print("Enter the number of function definitions: ");
		int n = Integer.parseInt(input.nextLine());
		
		Map<String, String[]> func = new HashMap<String, String[]>();
		
		System.out.println("Enter function definitions:");
		for (int i = 0; i < n; i++) {
			String[] line = input.nextLine().split(" ");
			String name = line[0];
			String argument = line[2];
			String result = line[4];
			
			String[] args = {argument, result};
			
			func.put(name, args);
		}
		
		System.out.println();
		
		return func;
	}
	
	/**
	 * Reads function composition.
	 * @return String array with first element outer function and
	 *         third element inner function.
	 */
	public static String[] readFunctionComposition() {
		input = new Scanner(System.in);
		
		System.out.print("Enter function composition: ");
		String[] line = input.nextLine().split(" ");
		
		String[] comp = {line[0], line[2]};
		
		return comp;
	}

}
