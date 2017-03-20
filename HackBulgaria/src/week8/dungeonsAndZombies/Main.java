package week8.dungeonsAndZombies;

import java.util.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Hero aragorn = new Hero("Aragorn", "Strider", 100, 100, 3);
		
		
		Weapon anduril = new Weapon("Anduril", 20);
		Weapon sword = new Weapon("Sword", 15);
		Weapon fist = new Weapon("Fist of destiny",5);
		
		Weapon[] weapons = {anduril, sword, fist};
		
		Weapon.addAllWeapon(weapons);
		
		Spell fireball = new Spell("Fireball", 30, 50, 20);
		Spell bad = new Spell("Very Bad", 40, 60, 30);
		Spell black = new Spell("Black magic", 20, 50, 40);
		
		Spell[] spells = {fireball, bad, black};
		
		Spell.addAllSpells(spells);
		
		
		Enemy sauron = new Enemy(100, 100, 10);
		Enemy saruman = new Enemy(100, 100, 10);
		Enemy gollum = new Enemy(50, 20, 5);
		
		Enemy[] enemies ={sauron, saruman, gollum};
		
		Enemy.AddAllEnemies(enemies);
		

		String[][] map = Dungeon.readMap();
		
		Dungeon dungeon = new Dungeon(map);
		
		dungeon.spawn(aragorn);
		
		aragorn.learn(fireball);
		aragorn.equip(anduril);
		dungeon.printMap();
		
		dungeon.moveHero("right");
		
		dungeon.moveHero("up");
		dungeon.moveHero("DowN");
		
		dungeon.moveHero("down");
		dungeon.moveHero("down");
		dungeon.moveHero("right");
		
		System.out.println(aragorn.getMana());
		
	}
	
}
