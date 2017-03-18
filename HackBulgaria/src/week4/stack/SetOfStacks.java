package week4.stack;

import week2.MyLinkedList;
import week2.MyLinkedListInterface;

public class SetOfStacks<T extends Comparable<T>> extends MyLinkedList<T> implements SetOfStacksInterface<T> {

	private MyLinkedList<T> stack;
	private int capacity;
	private int count;
	
	public SetOfStacks() {
		this.stack = new MyLinkedList<T>();
		this.capacity = 5;
		this.count = 0;
	}
	
	public SetOfStacks(T newElement) {
		this.stack.addFirst(newElement);
		this.capacity = 5;
		this.count = stack.getSize();
	}

	public void print() {
		// TODO Auto-generated method stub
		
	}
	
	
}
