package week8.zombieApocalypse.initializer;

import week8.zombieApocalypse.armoury.Weapon;
import week8.zombieApocalypse.armoury.weapons.AncientSword;
import week8.zombieApocalypse.armoury.weapons.Axe;
import week8.zombieApocalypse.armoury.weapons.Revolver;
import week8.zombieApocalypse.armoury.weapons.ShotGun;
import week8.zombieApocalypse.zombie.Zombie;

public class Initializer {
	public static Weapon getWeapon(String weapon) {		
		if (weapon.equalsIgnoreCase("Axe")) {
			return new Axe();
		}
		
		if (weapon.equalsIgnoreCase("Sword")) {
			return new AncientSword();
		}
		
		if (weapon.equalsIgnoreCase("Revolver")) {
			return new Revolver();
		}
		
		if (weapon.equalsIgnoreCase("ShotGun") || weapon.equals("Shotgun")) {
			return new ShotGun();
		}
		
		return null;
	}
	
	public static Zombie[] initializeZombies(int number, int health) {
		Zombie[] zombies = new Zombie[number];
		
		for (int i = 0; i < zombies.length; i++) {
			zombies[i] = new Zombie(health);
		}
			
		return zombies;
	}
}
