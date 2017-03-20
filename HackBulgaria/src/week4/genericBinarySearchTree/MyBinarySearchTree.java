package week4.genericBinarySearchTree;

import jdk.nashorn.internal.runtime.regexp.joni.SearchAlgorithm;

public class MyBinarySearchTree<T extends Comparable<T>> implements
                                                         MyBinarySearchTreeInterface<T> {
	
	private static class Node<T> {
		private T data;
		private Node<T> rightNode;
		private Node<T> leftNode;
		
		public Node(T data) {
			this.data = data;
			this.rightNode = null;
			this.leftNode = null;
		}
		
		public Node(T data, Node<T> rightNode, Node<T> leftNode) {
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
				Node<T> other = (Node<T>)object;
				
				if(this.data.equals(other.data)) {
					return true;
				}
			}
			
			return false;
		}
	}
	
	private Node<T> root;
	
	public MyBinarySearchTree(T data) {
		this.root = new Node<T>(data);
	}
	
	public MyBinarySearchTree() {
		this.root = null;
	}
	
	public void buildFromArray(T[] arr) {
		for (T el : arr) {
			this.insert(el);
		}
	}
	
	@Override
	public void insert(T element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element!");
		}
		
		Node<T> newNode = new Node<T>(element);
		
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
	private void addRecursiveDFS(Node<T> newNode, Node<T> currentNode) {
		if (newNode.data.compareTo(currentNode.data) > 0) {
			if (currentNode.rightNode == null) {
				currentNode.rightNode = newNode;
				
			} else {
				addRecursiveDFS(newNode, currentNode.rightNode);
			}
			
		} else if (newNode.data.compareTo(currentNode.data) <= 0) {
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
	
	private Node<T> findMin(Node<T> currentNode) {
		Node<T> minNode = currentNode;
		
		while (minNode.leftNode != null) {
			minNode = minNode.leftNode;
		}
		
		return minNode;
	}

	@Override
	public boolean find(T element) {
		if (this.root == null) {
			System.out.println("Initialize the tree!");
			return false;
		}
		
		Node<T> searchedNode = findRecursiveDFS(element, this.root);
		
		if (searchedNode == null) {
			return false;
			
		} else {
			return true;
		}
	}
	
	private Node<T> findRecursiveDFS(T element, Node<T> currentNode) {
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
	
	public static<T extends Comparable<T>> void sort(T[] arr) {
		MyBinarySearchTree<T> tree = new MyBinarySearchTree<T>();
		
		tree.buildFromArray(arr);
		
		DFSSwap(tree, arr, tree.root);
		index = 0;
	}
	
	private static int index = 0;
	
	private static <T extends Comparable<T>> void DFSSwap(MyBinarySearchTree<T> tree, 
														  T[] arr,
														  Node<T> root) {
		if (root == null) {
			return;
		}
		
		DFSSwap(tree, arr, root.leftNode);
		arr[index] = root.data;
		index++;
		DFSSwap(tree, arr, root.rightNode);
	}
	
	public static <T extends Comparable<T>> boolean areEquals(MyBinarySearchTree<T> firstTree,
														      MyBinarySearchTree<T> secondTree) {
		if (firstTree.root == null && secondTree.root == null) {
			return false;
		}
		
		return DFSCompare(firstTree.root, secondTree.root);
	}
	
	private static <T extends Comparable<T>> boolean DFSCompare(Node<T> firstNode, 
																Node<T> secondNode) {
		if ((firstNode == null) && (secondNode == null)) {
			return true;			
		}
		
		return (firstNode.data.equals(secondNode.data)
				&& DFSCompare(firstNode.leftNode, secondNode.leftNode)
				&& DFSCompare(firstNode.rightNode, secondNode.rightNode));
}
	
	public void print() {
		if (this.root == null) {
			System.out.println("Binary search tree is empty!");
			return;
		}
		
		printRecursiveDFS(this.root);
		System.out.println();
	}
	
	private void printRecursiveDFS(Node<T> currentNode) {
		if (currentNode == null) {
			return;
		}
		
		printRecursiveDFS(currentNode.leftNode);
		System.out.print(currentNode.data + " ");
		printRecursiveDFS(currentNode.rightNode);
	}
	
}
