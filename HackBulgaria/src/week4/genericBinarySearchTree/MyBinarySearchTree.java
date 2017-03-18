package week4.genericBinarySearchTree;

import jdk.nashorn.internal.runtime.regexp.joni.SearchAlgorithm;

public class MyBinarySearchTree<T extends Comparable<T>> implements
                                                         MyBinarySearchTreeInterface<T> {
	
	private class Node implements Comparable<Node> {
		private T data;
		private Node rightNode;
		private Node leftNode;
		
		public Node(T data) {
			this.data = data;
			this.rightNode = null;
			this.leftNode = null;
		}
		
		public Node(T data, Node rightNode, Node leftNode) {
			this.data = data;
			this.rightNode = rightNode;
			this.leftNode = leftNode;
		}
		
		@Override
		public int hashCode() {
			return data.hashCode();
		}
		
		@Override
		public boolean equals(Object object) {
			if (object == null) {
				return false;
			}
			
			if (this == object) {
				return true;
			}
			
			if (object instanceof MyBinarySearchTree.Node) {
				Node other = (Node)object;
				
				if(this.data.equals(other.data)) {
					return true;
				}
			}
			
			return false;
		}

		@Override
		public int compareTo(MyBinarySearchTree<T>.Node obj) {
			if(this.equals(obj)) {
				return 0;
			}
			
			if (this.data.compareTo(obj.data) > 0) {
				return 1;
			}
			
			if (this.data.compareTo(obj.data) < 0) {
				return -1;
			}
			
			return Integer.MIN_VALUE;
		}
		
		@Override
		public String toString() {
			return (String)this.data;
		}
	}
	
	private Node root;
	
	public MyBinarySearchTree(T data) {
		this.root = new Node(data);
	}
	
	public MyBinarySearchTree() {
		this.root = null;
	}
	
	@Override
	public void insert(T element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element!");
		}
		
		Node newNode = new Node(element);
		
		if (this.root == null) {
			this.root = newNode;

		} else {
			addRecursiveDFS(newNode, this.root);			
		}
	}
	
	/**
	 * Adding new node using BFS
	 * @param newNode - new node to be added
	 * @param currentNode - starting node
	 */
	private void addRecursiveDFS(Node newNode, Node currentNode) {
		if (newNode.compareTo(currentNode) > 0) {
			if (currentNode.rightNode == null) {
				currentNode.rightNode = newNode;
				
			} else {
				addRecursiveDFS(newNode, currentNode.rightNode);
			}
			
		} else if (newNode.compareTo(currentNode) <= 0) {
			if (currentNode.leftNode == null) {
				currentNode.leftNode = newNode;
				
			} else {
				addRecursiveDFS(newNode, currentNode.leftNode);
			}
		}
	}

	@Override
	public T remove(T element) {
		 return null;
	}

	@Override
	public boolean find(T element) {
		if (this.root == null) {
			System.out.println("Initialize the tree!");
			return false;
		}
		
		Node searchedNode = findRecursiveDFS(element, this.root);
		
		if (searchedNode == null) {
			return false;
			
		} else {
			return true;
		}
	}
	
	private Node findRecursiveDFS(T element, Node currentNode) {
		if (element.compareTo(currentNode.data) == 0) {
			return currentNode;
		}
		
		if (element.compareTo(currentNode.data) <= 0) {
			if (currentNode.leftNode != null) {
				return findRecursiveDFS(element, currentNode.leftNode);
				
			}else {
				return null;
			}
			
		} else if (element.compareTo(currentNode.data) > 0) {
			if (currentNode.rightNode != null) {
				return findRecursiveDFS(element, currentNode.rightNode);
				
			} else {
				return null;
			}
		}
		
		return null;
	}
	
	public void print() {
		if (this.root == null) {
			System.out.println("Binary search tree is empty!");
			return;
		}
		
		printRecursiveDFS(this.root);
		//System.out.println(this.root.data);
		//printRecursiveDFS(this.root.rightNode);
	}
	
	private void printRecursiveDFS(Node currentNode) {
		if (currentNode == null) {
			return;
		}
		System.out.println(currentNode.data);
		printRecursiveDFS(currentNode.leftNode);
		printRecursiveDFS(currentNode.rightNode);
	}
	
	private Node findMin(Node currentNode) {
		Node minNode = currentNode;
		
		while (minNode.leftNode != null) {
			minNode = minNode.leftNode;
		}
		
		return minNode;
	}
}
