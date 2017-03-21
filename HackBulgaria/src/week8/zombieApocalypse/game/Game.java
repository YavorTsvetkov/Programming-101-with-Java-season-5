package week8.zombieApocalypse.game;

import week8.zombieApocalypse.armoury.Weapon;
import week8.zombieApocalypse.initializer.Initializer;
import week8.zombieApocalypse.zombie.Zombie;

public class Game {
	private Zombie[] zombies;
	private Weapon weapon;
	
	public Game(int zombiesNumber, int zombiesHealth, Weapon weapon) {
		zombies = Initializer.initializeZombies(zombiesNumber, zombiesHealth);
		this.weapon = weapon;
		
	}
	
	public int start() {
		int hitsNum = 0;
		
		for (Zombie zombie : this.zombies) {
			while (zombie.isAlive()) {
				zombie.hit(this.weapon.getDamage());
				hitsNum++;
			}
		}
		
		return hitsNum;
	}
}
