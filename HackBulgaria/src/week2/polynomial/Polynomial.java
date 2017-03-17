package week2.polynomial;

import java.util.Collections;
import java.util.TreeMap;
import java.util.Map;

public class Polynomial {
	private Map<Integer, Integer> polynomial;

	public Polynomial() {
		this.polynomial = new TreeMap<Integer, Integer>(Collections.reverseOrder());
	}
	
	public Polynomial(Polynomial p) {
		this.polynomial = p.polynomial;
	}
	
	public Polynomial(String line) {
		Polynomial p = fromString(line);
		this.polynomial = p.polynomial;
	}
	
	public static Polynomial fromString(String line) {
		Polynomial p = new Polynomial();
		boolean isPositive = true;
		String[] sequence = line.split(" ");
		for(int i = 0; i < sequence.length; i++) {
			String monomial = sequence[i];
			if(monomial.equals("+")) {
				isPositive = true;
				continue;
			}
			if(monomial.equals("-")) {
				isPositive = false;
				continue;
			}
			int coefficient = findCoefficient(monomial, isPositive);
			int degree = findDegree(monomial);
			p.add(coefficient, degree);
		}
		return p;
	}
	
	public static int findDegree(String monomial) {
		
		if(thereIsToken(monomial, "x")) {
			int xIndex = monomial.indexOf("x");
			if(xIndex == monomial.length() - 1) {
				return 1;
			}
			
			char number = monomial.charAt(monomial.length() - 1);
			return number - '0';
		}
		return 0;
	}
	
	public static int findCoefficient(String monomial, boolean isPositive) {
		int coefficient = Integer.MIN_VALUE;
		if(thereIsToken(monomial, "x")) {
			int xIndex = monomial.indexOf("x");
			if(xIndex == 0) {
				return 1;
			}
			String number = monomial.substring(0, xIndex);
			coefficient = Integer.parseInt(number);
		}
		else {
			coefficient = Integer.parseInt(monomial);
		}
		
		if(!isPositive) {
			return coefficient * -1;
		}
		return coefficient;
	}
		
	public static boolean thereIsToken(String line, String token) {
		int indexOf = line.indexOf(token);
		if(indexOf == -1) {
			return false;
		}
		return true;
	}
	
	public void add(int coefficient, int degree) {
		if(coefficient != 0) {
			if(this.polynomial.containsKey(degree)) {
				this.polynomial.put(degree, this.polynomial.get(degree) + coefficient);
			}
			else{
				this.polynomial.put(degree, coefficient);
			}
			
		}
		else{
			System.out.println("Coefficient must be non - zero!");
		}
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		boolean isFirstMonom = true;
		
		for (Map.Entry<Integer, Integer> pair : this.polynomial.entrySet()) {
			StringBuilder monomial = new StringBuilder();
			int coefficient = pair.getValue();
			int degree = pair.getKey();
			String sign = "+";
			if (coefficient < 0) {
				sign = "-";
			}
			if(isFirstMonom) {
				monomial.append(coefficient);
				isFirstMonom = false;
			}
			else{
				if(coefficient > 0) {
					monomial.append(sign + " " +  coefficient);
				}
				else{
					monomial.append(sign + " " + Math.abs(coefficient));
				}
			}
			
			if(degree > 0) {
				if(degree > 1) {
					monomial.append("x" + "^" + degree + " ");
				}
				else{
					monomial.append("x ");
				}
			}
			result.append(monomial.toString());
		}
		
		return result.toString();
	}
	
	public static Polynomial addition(Polynomial first, Polynomial second) {
		Polynomial result = new Polynomial(second);
		for (Map.Entry<Integer, Integer> pair : first.polynomial.entrySet()) {
			int degree = pair.getKey();
			int coefficient = pair.getValue();
			if(result.polynomial.containsKey(degree)) {
				result.polynomial.put(degree, result.polynomial.get(degree) + coefficient);
			}
			else{
				result.polynomial.put(degree, coefficient);
			}
		}
		
		return result;
	}
	
	public static Polynomial subtract(Polynomial first, Polynomial second) {
		Polynomial result = new Polynomial(first);
		for (Map.Entry<Integer, Integer> pair : second.polynomial.entrySet()) {
			int degree = pair.getKey();
			int coefficient = pair.getValue();
			if(result.polynomial.containsKey(degree)) {
				result.polynomial.put(degree, result.polynomial.get(degree) - coefficient);
			}
			else{
				result.polynomial.put(degree, coefficient);
			}
		}
		
		return result;
	}
	
	public static Polynomial multiplication(Polynomial first, Polynomial second) {
		Polynomial result = new Polynomial();
		for (Map.Entry<Integer, Integer> firstPair : first.polynomial.entrySet()) {
			int firstDegree = firstPair.getKey();
			int firstCoefficient = firstPair.getValue();
			
			for(Map.Entry<Integer, Integer> secondPair : second.polynomial.entrySet()) {
				int secondDegree = secondPair.getKey();
				int secondCoefficient = secondPair.getValue();
				
				int resultDegree = firstDegree + secondDegree;
				int resultCoefficient = firstCoefficient * secondCoefficient;
				if(result.polynomial.containsKey(resultDegree)) {
					result.polynomial.put(resultDegree, result.polynomial.get(resultDegree)
							+ resultCoefficient);
				}
				else{
					result.polynomial.put(resultDegree, resultCoefficient);
				}
			}
		}
		
		return result;
	}
	
	public static Polynomial multiplicateByConst(Polynomial p, int constant){
		Polynomial result = new Polynomial();
		for (Map.Entry<Integer, Integer> pair : p.polynomial.entrySet()) {
			int coefficient = pair.getValue();
			int degree = pair.getKey();
			result.polynomial.put(degree, coefficient * constant);
		}
		
		return result;
	}
	
	public static Polynomial calcDerivative(Polynomial p) {
		Polynomial result = new Polynomial();
		for (Map.Entry<Integer, Integer> pair : p.polynomial.entrySet()) {
			int degree = pair.getKey();
			int coefficient = pair.getValue();
			
			if(degree > 0) {
				int resultCoefficient = coefficient * degree;
				int resultDegree = degree -1;
				result.polynomial.put(resultDegree, resultCoefficient);
			}
		}
		
		return result;
	}
	
	public int evaluate(int argument) {
		int result = 0;
		
		for (Map.Entry<Integer, Integer> entry : this.polynomial.entrySet()) {
			int coefficient = entry.getKey();
			int degree = entry.getValue();
			int element = coefficient * (int)Math.pow(argument, degree);
			result += element;
		}
		
		return result;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		
		if (this == object) {
			return true;
		}
		
		if (this.getClass().equals(object.getClass())) {
			Polynomial other = (Polynomial)object;
			
			if (this.toString().equals(other.toString())) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}
}

