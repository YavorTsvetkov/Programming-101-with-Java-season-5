package week10;

import java.util.*;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Map<String, String[]> funcs = readFunctions();
		String[] composition =  readComp();
		
		String second = composition[1];
		String first = composition[0];
		
		if (funcs.get(second)[1].equals(funcs.get(first)[0])) {
			System.out.println("true");
			

		} else {
			
			System.out.println("false");
		}
		
	}
	
	public static Map<String, String[]> readFunctions() {
		Scanner input = new Scanner(System.in);
		
		int n = Integer.parseInt(input.nextLine());
		
		Map<String, String[]> func = new HashMap();
		
		for (int i = 0; i < n; i++) {
			String[] line = input.nextLine().split(" ");
			String name = line[0];
			String argument = line[2];
			String result = line[4];
			
			String[] args = {argument, result};
			
			func.put(name, args);
		}
		
		input.nextLine();
		
		return func;
	}
	
	public static String[] readComp() {
		Scanner input = new Scanner(System.in);
		
		String[] line = input.nextLine().split(" ");
		
		String[] comp = {line[0], line[2]};
		
		return comp;
	}
	
}
