package week2;

public interface MyLinkedListInterface<T extends Comparable<T>>{
	
	public void addFirst(T newElement);
	public void addLast(T newElement);
	public void add(T newElement, int index);
	public T getFirst();
	public T getLast();
	public T get(int index);
	public int getSize();
	public void remove(int index);
	public void addList(MyLinkedListInterface<T> list);
	public String toString();
	public T findToLastElement(int index);
	public void deleteElement(int index);
	public void partition(int index);
	public T getMinValue();
}