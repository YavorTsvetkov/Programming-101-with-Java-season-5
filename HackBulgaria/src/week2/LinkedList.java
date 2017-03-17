package week2;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LinkedList<T> implements Iterable<T> {

	private class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
			this.next = null;
		}
		
		public T getData(){
			return this.data;
		}
		
		public T getNext() {
			return (T)this.next;
		}
	}
	
	Node head;
	public LinkedList (){
		head = null;
	}
	
	public void add(T data) {
		if(head == null) {
			head = new Node<T>(data);
		}
		else{
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(data);
		}
	}
	
	public String toString() {
		String result = "";
		Node temp = head;
		while(temp != null) {
			result += temp.data + ", ";
			temp = temp.next;
		}
		return result;
	}
	public void insertAfter(T after, T data) {
		Node temp = head;
		while(temp.next.data != after) {
			temp = temp.next;
		}
	}
	
	public void addFirst(T element) {
		 this.head = new Node(element);
			
		}
	
	public void addLast(T element) {
		if(this.head == null) addFirst(element);
		   else
		   {
		      Node tmp = head;
		      while(tmp.next != null) tmp = tmp.next;

		      tmp.next = new Node(element);
		   }
	}
	
	

	public void forEach(Consumer<? super T> arg0) {
		// TODO Auto-generated method stub
		
	}
	public class LLIteratror implements Iterator<T> {
		
		private Node cursor;
		
		public LLIteratror() {
			cursor = head;
		}
		

		public void forEachRemaining(Consumer<? super T> arg0) {
			// TODO Auto-generated method stub
			
		}

		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		public T next() {
			// TODO Auto-generated method stub
			T result = (T)cursor.data;
			cursor = cursor.next;
			return result;
		}

		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}	
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public Spliterator<T> spliterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
