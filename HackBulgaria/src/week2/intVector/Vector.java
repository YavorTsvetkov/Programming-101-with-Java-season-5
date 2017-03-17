package week2.intVector;

public class Vector<T>{
	int size = 0;
	int capacity = 10;
	
	
	T[] arr = (T[])new Object[10];
	
	public Vector() {
		
	}
	
	public Vector(int capacity) {
		this.capacity = capacity;
		arr = (T[])new Object[capacity];
	}	
}
