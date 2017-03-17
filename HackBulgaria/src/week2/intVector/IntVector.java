package week2.intVector;

import java.lang.IndexOutOfBoundsException;


public class IntVector { //implements Iterable<T>{
	private int[] vector;
	private int capacity = 10;
	private int size = 0;
	
	public IntVector() {
		vector = new int[capacity];
	}
	
	public IntVector(int capacity) {
		this.capacity = capacity;
		this.vector = new int[this.capacity];
	}
	
	public void add(int element) {
		if(size < capacity) {
			this.vector[size] = element;
			size++;
		}
		else {
			this.capacity *= 2;
			int[] temp = new int[this.capacity];
			for(int i = 0; i < size; i++) {
				temp[i] = this.vector[i];
			}
			this.vector = temp;
			this.vector[size] = element;
			size++;
		}
		
	}
	
	public void insert(int index, int element) {
		if(index < size) {
			this.vector[index] = element;
			size++;
		}
		else {
			while(this.capacity < index) {
				this.capacity *= 2; 
			}
			int[] temp = new int[this.capacity];
			for(int i = 0; i < size; i++) {
				temp[i] = vector[i];
			}
			temp[index] = element;
			this.vector = temp;
			size = index + 1;
		}
	}
	
	public int get(int index) {
		if(index >= size) {
			throw new IndexOutOfBoundsException();
		}
		return this.vector[index];
	}
	
	public int size() {
		return this.size;
	}
	
	public int sum() {
		int sum = 0;
		for(int i = 0; i < size; i++) {
			sum += this.vector[i];
		}
		
		return sum;
	}
	
	public void addAll(int[] n) {
		for(int i = 0; i < n.length; i ++) {
			add(n[i]);
		}
	}
	
	public int capacity() {
		return this.capacity;
	}
	
	public String toString() {
		String separator = ", ";
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i < this.size; i++) {
			result.append(this.vector[i]);
			if(i < (this.size - 1)) {
				result.append(separator);
			}
		}
		return result.toString();
	}
	
	public int elementIndex(int element) {
		int result = -1;
		for(int i = 0; i < this.size; i++) {
			if(this.vector[i] == element) {
				result = i;
				break;
			}
		}
		
		return result;
	}
	
	public void remove(int element) {
		if(elementIndex(element) > -1) {
			if((this.capacity / 2) > this.size) {
				while((this.capacity / 2) > this.size) {
					this.capacity /= 2;
				}
			}
			
			int[] temp = new int[this.capacity];
			
			for(int i = 0; i < elementIndex(element); i++) {
				temp[i] = vector[i];
			}
			
			for(int i = elementIndex(element) + 1; i < size; i++) {
				temp[i - 1] = vector[i];
			}
			vector = temp;
			size--;
		}
	}

}

