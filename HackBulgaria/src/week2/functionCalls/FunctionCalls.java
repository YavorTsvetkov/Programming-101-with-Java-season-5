package week2.functionCalls;

import java.util.Scanner;

public class FunctionCalls {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter composition: ");
		String composition = input.nextLine();
		
		System.out.print("Enter argument: ");
		int x = Integer.parseInt(input.nextLine());
		
		int result = calcComposition(composition, x);
		
		System.out.println(result);
	}
	
	public static int f1(int x) {
		return f2(x) + f3(x);
	}
	
	public static int f2(int x) {
		return 2 * x;
	}
	
	public static int f3(int x) {
		return x + 1;
	}
	
	public static int f4(int x) {
		return 2 * f1(x);
	}
	
	public static int calcComposition(String line, int x) {
		int arg = x;
		String[] composition = line.split(" . ");
		
		for (int i = composition.length - 1; i >=0; i--) {
			if (composition[i].equals("f1")) {
				arg = f1(arg);
				
			} else if (composition[i].equals("f2")) {
				arg = f2(arg);
				
			} else if (composition[i].equals("f3")) {
				arg = f3(arg);
			
			} else if (composition[i].equals("f4")) {
				arg = f4(arg);
			}
		}
		
		return arg;
	}
}
