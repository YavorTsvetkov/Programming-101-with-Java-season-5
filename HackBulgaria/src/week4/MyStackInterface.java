package week4;

/**
 * Stack interface
 * @author yavor
 *
 * @param <T> should implements Comparable interface
 */
public interface MyStackInterface<T extends Comparable<T>>  {
	/**
	 * adds an element at top of the stack
	 * @param element to add
	 */
	public void push(T element);
	
	/**Removes the elements on top of the stack
	 * 
	 * @return the element of top of the stack
	 */
	public T pop();
	
	/**
	 * 
	 * @return return the element at top of the stack
	 */
	public T peek();
	
	/**
	 * 
	 * @return the size of the stack
	 */
	public int getSize();
	
	/**
	 * finds minValue in a stack
	 * @return minValue
	 */
	public T getMinValue(); 
	
	/**
	 * check if the stack is empty
	 * @return true if is empty, false if contains elements
	 */
	public boolean isEmpty();
	
	/**
	 * sorts a stack in ascending order
	 */
	public void sort();
	
	/**
	 * prints the stack
	 */
	public void printStack();
}
