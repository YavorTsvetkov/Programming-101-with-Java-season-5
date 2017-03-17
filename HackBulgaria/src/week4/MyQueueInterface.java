package week4;

public interface MyQueueInterface<T extends Comparable <T>> {
	/**
	 * adds an element at the end of the queue
	 * @param element to add
	 */
	public void enqueue(T element);
	
	/**
	 * Removes the first entered element of the queue 
	 * @return the first element entered
	 */
	public T dequeue();
	
	/**
	 * shows the first entered element of the queue
	 * @return the first entered element
	 */
	public T peek();
	
	/**
	 * 
	 * @return the size of the queue
	 */
	public int getSize();
	
}
