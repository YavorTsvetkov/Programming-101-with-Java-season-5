package week2.functionCallsExtension.CompCalculator;

import week2.functionCallsExtension.function.Function;
import week2.functionCallsExtension.function.FunctionWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompCalculator {
	
	/**
	 * keeps info about the function
	 * key - function name
	 * value  - function' s argument and body
	 */
	Map<String, FunctionWrapper> functions;
	
	private void addFunction(Function func) {
		String name = func.getName();
		String[] body = func.getBody();
		char unknown = func.getUnknown();
		
		FunctionWrapper wrapper = new FunctionWrapper(unknown, body);
		this.functions.put(name, wrapper);
	}
	
	public CompCalculator(String[] funcs) {
		this.functions = new HashMap<String, FunctionWrapper>();
		for (int i = 0; i < funcs.length; i++) {
			Function func = new Function(funcs[i]);
			addFunction(func);
		}
	}
	
	
	public int calcComposition(String composition, int arg) {
		String[] formula = composition.split(" . ");
		int param = arg;
		
		for (int i = formula.length - 1; i >= 0; i--) {
			String funcName = formula[i];
			param = calcFunction(funcName, param);
		}
		
		return param;
	}
	
	private int calcFunction(String funcName, int argument) {
		String[] funcBody = this.functions.get(funcName).getBody();
		String funcUnknown = Character.toString(this.functions.get(funcName).getUnknown());
		List<Integer> result = new ArrayList<Integer>();
		boolean isAddition = true;
		
		for (int i = 0; i < funcBody.length; i++) {
			int element = Integer.MIN_VALUE;
			if (isFunction(funcBody[i])) {
				String nextFuncName = getFuncName(funcBody[i]);
				if (funcBody[i].contains(funcUnknown)) {
					element = calcFunction(nextFuncName, argument);
					
				} else {
					int param = getParameter(funcBody[i]);
					element = calcFunction(nextFuncName, param);	
				}
				
			} else if (isOperand(funcBody[i])) {
				if (isAddition(funcBody[i])) {
					isAddition = true;
					
				} else {
					isAddition = false;
				}
				
				continue;
				
			} else if (isUnknownVariable(funcBody[i], funcUnknown)) {
				element = argument;
				
				// if is number
			} else {
				element = Integer.parseInt(funcBody[i]);
			}
			
			if (isAddition) {
				result.add(element);
				
			} else {
				result.add(element * -1);
			}
		}
	
		return calcSumOfElements(result); 
	}
	
	private boolean isFunction(String element) {
		int bracketIndex = element.indexOf("(");
		
		if (bracketIndex == -1) {
			return false;
		}
		
		return true;
	}
	
	private String getFuncName(String element) {
		int openBracket = element.indexOf("(");
		return element.substring(0, openBracket);
	}
	
	private int getParameter(String element) {
		int openBracketIndex = element.indexOf("(");
		int closingBracketIndex = element.indexOf(")");
		String number = element.substring(openBracketIndex + 1, closingBracketIndex);
		
		return Integer.parseInt(number);
	}
	
	private boolean isOperand(String token) {
		return token.equals("+") || token.equals("-");
	}
	
	private boolean isAddition(String token) {
		return token.equals("+");
	} 
	
	private boolean isUnknownVariable(String token, String unknown) {
		return token.equals(unknown);
	}
	
	private int calcSumOfElements(List<Integer> func) {
		int sum = 0;
		
		for (int element : func) {
			sum += element;
		}
		
		return sum;
	}
}
