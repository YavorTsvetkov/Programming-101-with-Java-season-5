package week2;

import week4.queue.MyQueueInterface;
import week4.stack.MyStackInterface;

public class MyLinkedList<T extends Comparable<T>> implements MyLinkedListInterface<T>, 
															  MyQueueInterface<T>, 
															  MyStackInterface<T> {
	
	private Node head;
	
	//The rightmost element of the list
	private Node tail;
	private int size;
	private T minValue;
	
	private class Node {
		private T data;
		private Node nextNode;
		
		public Node(T data) {
			this.data = data;
			this.nextNode = null;
		}
		
		public Node(T data, Node nextNode) {
			this.data = data;
			this.nextNode = nextNode;
		}
	}
	
	public MyLinkedList(T element) {
		Node newNode = new Node(element, this.head);
		this.head = newNode;
		this.head.nextNode = this.tail;
		this.tail = null;
		this.size = 1;
		this.minValue = this.head.data;
	}
	
	public MyLinkedList() {
		this.head = null;
		//this.head.nextNode = this.tail;
		this.tail = null;
		this.size = 0;
		this.minValue = null;
	}
	
	private void validateIndex(int index) {
		if(index < 0 || (index > this.size - 1)) {
			throw new IndexOutOfBoundsException("The provided index is out of range: " + index);
		}
	}
	
	//Complexity - O(n)
	private Node getNode(int index) {
		Node currentNode = null;
		
		if (index == 0) {
			currentNode = this.head;
		}
		else if (index == this.size -1) {
			currentNode = this.tail;
		}
		else {
			currentNode = this.head;
			for(int i = 0; i < index; i++) {
				if (currentNode.nextNode == null) {
					throw new IndexOutOfBoundsException("The requested index is greater than the size: " + index);
				}
				currentNode = currentNode.nextNode;
			}
		}
		
		return currentNode;
	}
	
	//Complexity - O(1)
	public void addFirst(T newElement) {
		Node newNode = new Node(newElement);
		if (this.head == null) {
			this.head = newNode;
			this.tail = this.head;
			this.minValue = this.head.data;
		}
		else {
		    newNode.nextNode = this.head;
			this.head = newNode;		
			
			if(newElement.compareTo(this.minValue) < 0 ) {
				this.minValue = newElement;
			}
		}
		
		this.size++;
	}

	//Complexity - O(1)
	public void addLast(T newElement) {
		if (this.head == null) {
			addFirst(newElement);
		} 
		else {
		    Node lastNode = new Node(newElement);
		    this.tail.nextNode = lastNode;
		    this.tail = lastNode;
		    if (newElement.compareTo(this.minValue) < 0) {
		    	this.minValue = lastNode.data;
		    }
		    this.size++;
		}
	}
	
	//Complexity - O(n)
	public void add(T newElement, int index) {
		validateIndex(index);
		if (index == 0) {
			addFirst(newElement);
		}
		else if (index == this.size - 1) {
			addLast(newElement);
		}
		else {
			Node prevNode = getNode(index - 1);
			Node nextNode = getNode(index);
			Node newNode = new Node(newElement);
			prevNode.nextNode = newNode;
			newNode.nextNode = nextNode;
			if (newElement.compareTo(this.minValue) < 0) {
				this.minValue = newNode.data;
			}
			this.size++;
		}
	}

	//Complexity - O(1)
	public T getFirst() {
		if(this.head == null) {
			return null;
		}
		
		return this.head.data;
	}

	//Complexity - O(1)
	public T getLast() {
		if (this.head == null) {
			return null;
		}

		return this.tail.data;
	}

	//Complexity - O(n)
	public T get(int index) {
		Node current = getNode(index);
		return current.data;
	}
	
	//Complexity - O(1)
	public int getSize() {
		return this.size;
	}
	
	//Complexity - O(1)
	private void removeFirst() {
		if (this.minValue.compareTo(this.head.data) == 0) {
			if (this.size < 2) {
				this.minValue = null;
			}
			else {
				this.minValue = this.head.nextNode.data;
				Node currentNode = this.head.nextNode.nextNode;
				
				while (currentNode != null) {
					if (currentNode.data.compareTo(this.minValue) < 0) {
						this.minValue = currentNode.data;
					}
					
					currentNode = currentNode.nextNode;
				}
			}
			
		}
		
		this.head = this.head.nextNode;
		this.size--;
	}
	
	//Complexity - O(n)
	private void removeLast() {
		if (this.minValue.compareTo(this.tail.data) == 0) {
			
			this.minValue = this.head.data;
			Node currentNode = this.head.nextNode;
			
			while (currentNode.nextNode != null) {
				if (currentNode.data.compareTo(this.minValue) < 0) {
					this.minValue = currentNode.data;
				}
				
				currentNode = currentNode.nextNode;
			}
		}
		
		this.tail = getNode(this.size - 2);
		this.tail.nextNode = null;
		this.size--;
	}
	
	/**
	 * finds minValue in linked list jumping the node at the specificated index
	 * @param index - the index of the node to be jumped
	 */
	private void findMinValue (int index) {
		this.minValue = this.head.data;
		Node currentNode = this.head.nextNode;
		
		for (int i = 0; i < this.size - 1; i++) {
			if (i == index) {
				continue;
			}
			
			if (currentNode.data.compareTo(this.minValue) < 0) {
				this.minValue = currentNode.data;
			}
			
			currentNode = currentNode.nextNode;
		}
	}
	
	//Complexity - O(n)
	public void remove(int index) {
		validateIndex(index);
		
		if (index == 0) {
			removeFirst();
		}
		else if (index == this.size - 1) {
			removeLast();
		}
		else {
			Node current = getNode(index);
			
			if (current.data.compareTo(this.minValue) == 0) {
				findMinValue(index);
			}
			
			Node prevNode = getNode(index - 1);
			Node nextNode = getNode(index + 1);
			prevNode.nextNode = nextNode;
			this.size--;
		}
	}

	//Complexity - O(n)
	public void addList(MyLinkedListInterface<T> list) {
		
		if (this.minValue.compareTo(list.getMinValue()) > 0) {
			this.minValue = list.getMinValue();		
			}
		
		for (int i = 0; i < list.getSize(); i++) {
			this.tail.nextNode = new Node(list.get(i));
			this.tail = this.tail.nextNode;
		}
		
		this.size += list.getSize();
	}
	
	//Complexity - O(n)
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i < this.size; i++) {
			Node currentNode = this.getNode(i);
			T data = currentNode.data;
			result.append(data.toString());
			if (i < this.size - 1) {
				result.append(", ");
			}
		}
		
		return result.toString();
	}

	//
	public T findToLastElement(int index) {
		validateIndex(index);
		
		int pointer = 1 - index;
		Node result = getNode(pointer);
		Node currentNode = this.head;
		while (currentNode != null) {
			result = getNode(pointer);
			pointer++;
			currentNode = currentNode.nextNode;
		}
		
		return result.data;
	}

	//Complexity - O(n)
	public void deleteElement(int index) {
		validateIndex(index);
		if (index == this.size - 1) {
			removeLast();
		}
		else {
			Node currentIndex = getNode(index);
			currentIndex.data = getNode(index + 1).data;
			currentIndex.nextNode = getNode(index + 2);
			size--;
		}
		
	}
	
	//Complexity - O()
	public void partition(int index) {
		Node previous = getNode(index - 1);
		Node next = getNode(index + 1);
		previous.nextNode = next;		
	}
	
	public T pop() {
		// TODO Auto-generated method stub
		return removeHead();
	}

	private T removeHead() {
		T firstElement = null;
		
		if (this.size > 0) {
			firstElement = head.data;
			if (size == 1) {
				tail = null;
			}
			remove(0);
		}
		
		if (size == 0) {
			tail = null;
		}
		
		return firstElement;
	}

	public void push(T element) {
		addFirst(element);
	}

	
	public void enqueue(T element) {
		addLast(element);
	}
	
	public T dequeue() {
		// TODO Auto-generated method stub
		return removeHead();
	}
	
	/**
	 * peeks head
	 */
	public T peek() {
		T firstElement = null;
		
		if (this.size != 0) {
			firstElement = head.data;
		}
		
		return firstElement;
	}

	public T getMinValue() {
		return this.minValue;
	}

	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		}
		
		return false;
	}

	public void sort() {
		MyStackInterface<T> result = new MyLinkedList<T>();
		
		result.push(this.pop());
		
		while (!this.isEmpty()) {
			T current = this.pop();
			T top = result.peek();
			
			if (current.compareTo(top) <= 0) {
				result.push(current);
			}
			else {
				
				while ((!result.isEmpty()) && (current.compareTo(top) >= 0)) {
					
					this.push(result.pop());
				}
				result.push(current);
			}
		}
		
		int end = result.getSize();
		for (int i = 0; i < end; i++) {
			this.push(result.pop());
		}
	}

	public void printStack() {
		Node currentNode = this.head;
		for (int i = 0; i < this.size; i++) {
			System.out.println(currentNode.data);
			currentNode = currentNode.nextNode;
		}
		
	}
}
	
	