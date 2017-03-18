package week4;

import week4.genericBinarySearchTree.MyBinarySearchTree;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
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
		
		MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<Integer>();
		tree.insert(7);
		tree.insert(5);
		tree.insert(10);
		tree.insert(6);
		tree.insert(3);
		tree.insert(8);
		tree.insert(13);
		tree.insert(1);
		tree.insert(7);
		tree.insert(9);
		tree.insert(11);
		tree.insert(14);
		
		tree.print();
		
		System.out.println(tree.find(15));
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
