package week4;

public interface MyBinaryTreeInterface {
	
	/**
	 * inserts an element at the tree
	 * @param element to insert
	 */
	public void add(int element);
	
	/**
	 * prints the tree
	 * @return string representation of the tree
	 */
	public void print();
	
	/**
	 * searches the element in the tree
	 * @param element - the searched element
	 * @return the searched element
	 */
	public int find(int element);
	
	/**
	 * removes the element from the tree
	 * @param element - the  element to be added
	 */
	public void remove(int element);
	
	
}
