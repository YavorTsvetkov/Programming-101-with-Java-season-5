package week4;

public interface SetOfStacksInterface<T extends Comparable<T>> {
	public void push(T element);
	
	public T pop();
	
	public T peek();
	
	public void print();

}
