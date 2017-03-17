package week4;

import week2.MyLinkedList;

public class MyQueue<T extends Comparable<T>> implements MyQueueInterface<T> {
	
	private MyStackInterface<T> enqueue;
	private MyStackInterface<T> dequeue;
	
	public MyQueue() {
		this.enqueue = new MyLinkedList<T>();
		this.dequeue = new MyLinkedList<T>();
	}

	public void enqueue(T element) {
		this.enqueue.push(element);
	}

	public T dequeue() {
		int end = this.enqueue.getSize();
		
		for (int i = 0; i < end; i++) {
			T token = this.enqueue.pop();
			this.dequeue.push(token);
		}
		
		T result = this.dequeue.pop();
		
		for (int i = 0; i < end; i++) {
			T token = this.dequeue.pop();
			this.enqueue.push(token);
		}
		
		return result;
	}

	public T peek() {
		int end = this.enqueue.getSize();
		
		for (int i = 0; i < end; i++) {
			T token = this.enqueue.pop();
			this.dequeue.push(token);
		}
		
		T result = this.dequeue.peek();
		
		for (int i = 0; i < end; i++) {
			T token = this.dequeue.pop();
			this.enqueue.push(token);
		}
		
		return result;
	}

	public int getSize() {
		return this.enqueue.getSize();
	}

	
}
