package week2;

import java.util.*;
import week2.polynomial.Polynomial;
import week2.GameOfLife.GameOfLife;


public class Main {

	public static void main(String[] args) {
		MyLinkedListInterface<Integer> list = new MyLinkedList<Integer>();
		
		list.addFirst(1);
		list.addFirst(3);
		list.addFirst(5);
		list.addFirst(7);
		list.addFirst(2);
		list.addFirst(4);
		
		System.out.println(list);
		System.out.println(list.findToLastElement(4));
	}
}
