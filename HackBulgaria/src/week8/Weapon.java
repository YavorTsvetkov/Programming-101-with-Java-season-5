package week8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Weapon {
	private String name;
	private int damage;
	private static List<Weapon> weapons;
	
	static {
		weapons = new ArrayList<Weapon>();
	}
	
	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException(
					"Weapon name cannot be null!");
		}
		
		this.name = name;
	}
	
	public void setDamage(int damage) {
		if (damage < 0) {
			throw new IllegalArgumentException(
					"Weapon damage cannot be less than 0!");
		}
		
		this.damage = damage;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getDamage() {
		
		return this.damage;
	}
	
	public static List<Weapon> getWeapons() {
		if (weapons == null) {
			throw new NullPointerException("Initilize weapons");
		}
		
		return weapons;
	}
	
	public Weapon(String name, int damage) {
		setName(name);
		setDamage(damage);
	}
	
	public String weaponEtiquette() {
		String result = String.format("%s %d damage%n", getName(), getDamage());
		return result;
	}
	
	public static void addWeapon(Weapon weapon) {
		if (weapon == null) {
			throw new IllegalArgumentException("Weapon cannot be null.");
		}
		
		weapons.add(weapon);
	}
	
	public static void addAllWeapon(List<Weapon> arsenal) {
		if (arsenal == null) {
			throw new IllegalArgumentException("Bad arsenal");
		}
		
		for (Weapon weapon : arsenal) {
			addWeapon(weapon);
		}
	}
	
	public static void addAllWeapon(Weapon[] arsenal) {
		if (arsenal == null) {
			throw new IllegalArgumentException("Initilaize arsenal");
		}
		
		for (Weapon weapon : arsenal) {
			addWeapon(weapon);
		}
	}
	
	public static void printWeapons() {
		System.out.print("Weapons: ");
		
		for (int i = 0; i < weapons.size(); i++) {
			System.out.print(weapons.get(i).getName());
			
			if (i < weapons.size() - 1) {
				System.out.print(", ");
			}
			
			if (i == weapons.size() - 1) {
				System.out.print(".");
			}
			
		}
		
		System.out.println();
	}
	
	public static Weapon getRandomWeapon() {
		int min = 0;
		int max = weapons.size();
		int randomNum = ThreadLocalRandom.current().nextInt(min, max);
		
		Weapon randomWeapon = getWeapons().get(randomNum);
		
		return randomWeapon;
	}
}
