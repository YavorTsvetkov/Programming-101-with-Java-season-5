package thursday;

import java.util.*;

public class Function {
	
	private Map<String, String> func;
	private String funcName;
	private String variable;
	private String funcBody;
	
	
	public Function(String line) {
		func = new HashMap<String, String>();
		String[] elements = line.split("=");
		int firstIndex = elements[0].indexOf(" ");
		int secondIndex = elements[0].indexOf(" ", firstIndex + 1);
		this.funcName = line.substring(0, firstIndex);
		this.variable = line.substring(firstIndex + 1, secondIndex);
		this.funcBody = elements[1].trim();
		this.func.put(funcName, funcBody);
	}
	
	public String getFuncName() {
		return this.funcName;
	}
	
	public String getFuncBody() {
		return this.funcBody;
	}
	
	public String getVariable() {
		return this.variable;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(this.funcName);
		result.append(" = ");
		result.append(this.funcBody);
		return result.toString();
	}
	
	/**
	public static int calcFuncBody(Function func, Function[] funcs) {
		
	}
	**/
	
	public int calcFunc(int argument) {
		List<Integer> number = new ArrayList<Integer>();
		String line = this.funcBody.trim();
		boolean isPositive = true;
		for(int i = 0; i < line.length(); i++) {
			if(isVariable(line, i)) {
				number.add(argument);
			}
			else if(isSubtraction(line, i)) {
				isPositive = false;
			}
			else if(isDigit(line, i)) {
				int digit = line.charAt(i) - '0';
				if(isPositive) {
					number.add(digit);
				}
				else{
					number.add(digit * -1);
				}
			}
			/**
			else if**/ 
		}
		int result = calcSum(number);
		return result;
	}
	
	public static int evaluate(String sequence, Function[] funcs, int argument) {
		String[] formula = sequence.split("[\\. ]+");
		int parameter = argument;
		for(int i = formula.length - 1; i >= 0; i--) {
			for(Function func : funcs) {
				if(formula[i].equals(func.getFuncName())) {
					int funcResult = func.calcFunc(parameter);
					parameter = funcResult;
				}
			}
	    }
		return parameter;
	}
	/*
	public boolean funcNameAreEqual(String[] formula, int i) {
		return formula[i].equals(this.funcName);
	}
	*/
	
	public static int calcSum(List<Integer> nums) {
		int sum = 0;
		for(int num : nums) {
			sum += num;
		}
		return sum;
	}
	
	public boolean isVariable(String line, int i) {
		return line.charAt(i) == this.variable.charAt(0);
	}
	
	public boolean isAddition(String line, int i) {
		return line.charAt(i) == '+';
	}
	
	public boolean isSubtraction(String line, int i) {
		return line.charAt(i) == '-';
	}
	
	public boolean isDigit(String line, int i) {
		return Character.isDigit(line.charAt(i));
	}
}

