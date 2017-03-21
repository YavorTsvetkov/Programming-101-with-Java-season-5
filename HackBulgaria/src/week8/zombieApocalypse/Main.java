package week8.zombieApocalypse;

import java.util.Scanner;

import week8.zombieApocalypse.armoury.Weapon;
import week8.zombieApocalypse.game.Game;
import week8.zombieApocalypse.initializer.Initializer;

public class Main {

	private static Scanner input;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		String[] firstLine = input.nextLine().split(" ");
		
		int zombiesNumber = Integer.parseInt(firstLine[0]);
		int zombiesHealth = Integer.parseInt(firstLine[1]);
		
		String secondLine = input.nextLine();
		Weapon weapon = Initializer.getWeapon(secondLine);
		
		Game game = new Game(zombiesNumber, zombiesHealth, weapon);
		
		int result = game.start();
		
		System.out.println(result);
		System.out.println(weapon.getType());
		System.out.println("durability - " + weapon.getDurability());
		System.out.println("damage - " + weapon.getDamage());
		
	}

}
