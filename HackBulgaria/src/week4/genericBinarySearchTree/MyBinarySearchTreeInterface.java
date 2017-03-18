package week4.genericBinarySearchTree;

public interface MyBinarySearchTreeInterface<T extends Comparable<T>> {
	public void insert(T element);
	public T remove(T element);
	public boolean find(T element);
}
