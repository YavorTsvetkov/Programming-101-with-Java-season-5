package week8;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Enemy extends Hero {

	private int damage;
	private static List<Enemy> enemies;
	
	static {
		enemies = new ArrayList<Enemy>();
	}
	
	public void setDamage(int damage) {
		if (damage < 0) {
			throw new IllegalArgumentException("Illegal damage");
		}
		
		this.damage = damage;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public List<Enemy> getEnemies() {
		if (enemies == null) {
			throw new NullPointerException("Add enemies.");
		}
		
		return enemies;
	}
	
	public Enemy() {
		
	}
	
	public Enemy(int health, int mana, int damage) {
		setHealth(health);
		setMana(mana);
		setDamage(damage);
	}
	
	public int attack() {
		return getDamage();
	}
	
	public static void addEnemy(Enemy enemy) {
		if (enemy == null) {
			throw new IllegalArgumentException("Cannot add null enemy");
		}
		
		enemies.add(enemy);
	}
	
	public static void addAllEnemies(List<Enemy> horde) {
		if (horde == null) {
			throw new IllegalArgumentException("Illegal horde");
		}
		
		for (Enemy enemy : horde) {
			addEnemy(enemy);
		}
	}
	
	public static void AddAllEnemies(Enemy[] horde) {
		if (horde == null) {
			throw new IllegalArgumentException("Illegal horde");
		}
		
		for (Enemy enemy : horde) {
			addEnemy(enemy);
		}
	}
	
	public static Enemy getRandomEnemy() {
		int min = 0;
		int max = enemies.size();
		int randomNum = ThreadLocalRandom.current().nextInt(min, max);
		
		Enemy randomEnemy = enemies.get(randomNum);
		return randomEnemy;
	}
	
	public static void printEnemies() {
		if (enemies.isEmpty()) {
			System.out.println("Our kingdom has no enemies.");
			return;
		}
		
		System.out.print("Enemies: ");
		
		for (int i = 0; i < enemies.size(); i++) {
			System.out.print(enemies.get(i).getName());
			
			if (i < enemies.size() - 1) {
				System.out.print(", ");
			}
			
			if (i == enemies.size() - 1) {
				System.out.print(".");
			}
			
		}
		
		System.out.println();
	}
}
