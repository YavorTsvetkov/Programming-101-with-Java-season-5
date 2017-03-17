package thursday;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String number = input.nextLine();
		int num = Integer.parseInt(number);
		Function[] funcs = new Function[num];
		for(int i = 0; i < num; i++) {
			String line = input.nextLine();
			Function func = new Function(line);
			funcs[i] = func;
		}
		String sequence = input.nextLine();
		String param = input.nextLine();
		int parameter = Integer.parseInt(param);
		
		int result = Function.evaluate(sequence, funcs, parameter);
		
		System.out.println(result);
		
 	}
	/*
	public static int evaluate(String[] sequence, Function[] funcs) {
		for(int i = sequence.length - 1; i >= 0; i++) {
			for(Function func : funcs) {
				if(func.getFuncName().equals(sequence[i])) {
					
				}
			}
		}
	}
	*/
	
	
	 static int f2(int num) {
		return 2 * num;
	}
	
	public static int f3(int num) {
		return num + 1;
	}
	
	public static int f1(int num) {
		int result = f2(num) + f3(num);
		return result;
	}
	
	public static int f4(int num) {
		return 2 * f1(num);
	}
	
	public static int evaluate(String line, int number) {
		String[] formula = line.split("[\\. ]+");
		int parameter = number;
		for(int i = formula.length - 1; i >= 0; i--) {
			int func = 0;
			if(formula[i].equals("f1")) {
				func = f1(parameter);
				parameter = func;
			}
			else if(formula[i].equals("f2")) {
				func = f2(parameter);
				parameter = func;
			}
			else if(formula[i].equals("f3")) {
				func = f3(parameter);
				parameter = func;
			}
			else if(formula[i].equals("f4")) {
				func = f4(parameter);
				parameter = func;
			}
		}
		
		return parameter;
	}

}
