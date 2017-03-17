package week4;

import week2.MyLinkedList;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyStackInterface<Integer> stack = new MyLinkedList<Integer>();
		MyStackInterface<Integer> secondStack = new MyLinkedList<Integer>();
		
		stack.push(5);
		stack.push(7);
		stack.push(9);
		stack.push(2);
		stack.push(4);
		stack.push(5);
		stack.push(10);
		stack.push(2);
		
		stack.sort();
		stack.printStack();
		
		System.out.println();
		
		System.out.println(stack.getMinValue());
		/*
		while (stack.getSize() > 0) {
			if (stack.getSize() == 0) {
				break;
			}
			System.out.println(stack.getSize());
			System.out.println(stack.peek());
			System.out.println();
			secondStack.push(stack.pop());
		}
		
		while (!stack.isEmpty()) {
			int current = stack.pop();
			
			if (current >= secondStack.peek()) {
				secondStack.push(current);
			}
			else {
				while (current < secondStack.peek() && !secondStack.isEmpty()) {
					stack.push(secondStack.pop());
				}
				
				secondStack.push(current);
			}
		}
		*/		
	}
	
	public static int multiplication(int[] number, int index) {
		if(index < 0 || (index > number.length - 1)){
			throw new IndexOutOfBoundsException();
		}
		int result = 1;
		
		for(int i = 0; i < number.length; i++) {
			if(i == index) {
				continue;
			}
			else{
				result *= number[i];
			}
		}
		
		return result;
	}
	
	public void printFile(String path) {
		//throw checkedException("The file is not present");
	}

}
