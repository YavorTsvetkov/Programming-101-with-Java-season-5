package week10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TypeChecking {

	public static void main(String[] args) {
		Map<String, String[]> funcs = readFunctions();
		String[] composition =  readComp();
		
		String second = composition[1];
		String first = composition[0];
		
		if (funcs.get(second)[1].equals(funcs.get(first)[0])) {
			System.out.println("True");
			

		} else {
			
			System.out.println("False");
		}
	}
	
	public static Map<String, String[]> readFunctions() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of function definitions: ");
		int n = Integer.parseInt(input.nextLine());
		
		Map<String, String[]> func = new HashMap();
		
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
	
	public static String[] readComp() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter function composition: ");
		String[] line = input.nextLine().split(" ");
		
		String[] comp = {line[0], line[2]};
		
		return comp;
	}

}
