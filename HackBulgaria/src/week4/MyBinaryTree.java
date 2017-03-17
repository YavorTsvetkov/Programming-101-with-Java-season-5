package week4;

import java.util.Arrays;
import java.util.List;

public class MyBinaryTree implements MyBinaryTreeInterface {
	
	private static class Node {
		private int data;
		private Node left;
		private Node right;
		
		public Node(int data) {
			this.data = data;
			this.right = null;
			this.left = null;
		}
		
		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public static Node build(List<Integer> values) {
			if (values.isEmpty()) {
				return null;
			}
			
			int middle = values.size() / 2;
			
			int value = values.get(middle);
			
			Node left = build(values.subList(0, middle));
			
			Node right = build(values.subList(middle - 1, values.size() ));
			
			return new Node(value, left, right);
		}
		
		public static Node getBuild(List<Integer> values) {
			return build(values);
		}
		
		public void print(String prefix) {
			if (left != null) {
				left.print(prefix + " ");
			}
			
			System.out.print(prefix);
			System.out.println(data);
			if (right != null) {
				right.print(prefix + " ");
			}
		}
		
		public static int size(Node node) {
			if (node == null) {
				return 0;
			}
			
			return 1 + size(node.left) + size(node.left);
		}
		
		public int size() {
			int size = 1;
			if (left != null){
				size += left.size();
			}	
			
			if (right != null) {
				size += right.size();
			}
			
			return size;
		}
		
	}
	
	private Node root;
	
	public MyBinaryTree() {
		this.root = null;
	}
	
	public MyBinaryTree(int element) {
		Node newNode = new Node(element);
		this.root = newNode;
	}

	public void add(int element) {
	
		Node newNode = new Node(element);
		Node currentNode = this.root;
		if (this.root == null) {	
			this.root = newNode;
		}
		else {
			
			while((currentNode.right != null) && (currentNode.right != null)) {
				if(element >= currentNode.data) {
					currentNode = currentNode.right;		
				}
				else {
					currentNode = currentNode.left;
				}
			}
		}
		
		if (element >= currentNode.data) {
			currentNode.right = newNode;
		}
		else {
			currentNode.left = newNode;
		}
		
		
		/*
		if (this.root == null) {
			this.root = new Node(element);
			
		} else {
			addRecursive(element, this.root);
		}
	}
	
	public static void addRecursive(int element,Node currentNode) {
		
		
		if (element >= currentNode.data) {
			if (currentNode.nextBigger == null) {
				currentNode.nextBigger = new Node(element);
				
			} else {
				
			}
			
		} else if (element < currentNode.data) {
			
		}
		*/
	}
	
	public int find(int element) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void remove(int element) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1, 2, 4, 6, 7, 1, 12, 15, 20, 23 );
		Node root = Node.getBuild(values);
		
		
	}

	public void print() {
		// TODO Auto-generated method stub
		
	}

}
