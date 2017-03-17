package week1.anagrams;

import java.util.Scanner;
import week1.anagrams.Sort;

public class Anagrams {
	
	/**
	public static boolean areAnagramsSlow(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}

		boolean areAnagrams = false;
		
		StringBuilder secondWord = new StringBuilder(b.toLowerCase());

		for(int i = 0; i < a.length(); i++) {
			char firstChar = a.charAt(i);

			for(int j = 0; j < secondWord.length(); j++) {
				char secondChar = secondWord.charAt(j);
				if (firstChar == secondChar) {
					secondWord.deleteCharAt(j);
					break;
				}
			}
		}

		if (secondWord.length() == 0) {
			areAnagrams = true;
		}
		
		return areAnagrams;
	}
	**/
	
	/**
	 * Checks if two words are anagrams.
	 * First sorts the words and then checks char by char.
	 * Time complexity - O(nlogn)
	 * Space complexity - O(n) 
	 * @param firstWord
	 * @param secondWord
	 * @return true or false if the words are anagrams or are not
	 */
	public static boolean areAnagrams(String firstWord, String secondWord) {
		if (firstWord.length() != secondWord.length()) {
			return false;
		}
		
		StringBuilder aWord = new StringBuilder(firstWord.toLowerCase());
		StringBuilder bWord = new StringBuilder(secondWord.toLowerCase());
		
		Sort.quickSort(aWord);
		Sort.quickSort(bWord);
	
		for (int i = 0; i < aWord.length(); i++) {
			if (aWord.charAt(i) != bWord.charAt(i)) {
				return false;
			}
		}
		
		return true;
	}
	
	private static Scanner input;

	public static void main(String[] args) {

		input = new Scanner(System.in);
		String[] sequence = input.nextLine().split(" ");
		
		String a = sequence[0];
		String b = sequence[1];

		if (areAnagrams(a, b)) {
			System.out.println("ANAGRAMS");
		}
		else {
			System.out.println("NOT ANAGRAMS");
		}
	}
}
