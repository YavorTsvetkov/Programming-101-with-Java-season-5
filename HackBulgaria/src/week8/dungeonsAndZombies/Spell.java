package week8.dungeonsAndZombies;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Spell {
	
	//the name of the spell
	private String name;
	
	//damage that the spell cause
	private int damage;
	
	//this is the amount of mana that the spell needs 
	//in order to be executed.
	private int manaCost;
	
	//this is the range of the spell (the square number);
	//the spell can be casted only in straight direction.
	private int castRange;
	
	//all the spells that a hero can learn in the dungeon
	private static List<Spell> spells;
	
	static {
		spells = new ArrayList<Spell>();
	}
	
	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException(
					"Spell' s name cannot be null!");
		}
		
		this.name = name;
	}
	
	public void setDamage(int damage) {
		if (damage < 0) {
			throw new IllegalArgumentException(
					"Spell' s damage cannot be less than zero!");
		}
		
		this.damage = damage;
	}
	
	public void setManaCost(int manaCost) {
		if (manaCost < 0) {
			throw new IllegalArgumentException(
					"Spell' s mana cannot be less than zero!");
		}
		
		this.manaCost = manaCost;
	}
	
	public void setCastRange(int castRange) {
		if (castRange < 0) {
			throw new IllegalArgumentException(
					"Spell' s cast range cannot be less than zero!");
		}
		
		this.castRange = castRange;
	}
	
	public String getName() {
		if (this.name == null) {
			throw new NullPointerException("Initialize spell name");
		}
		return this.name;
	}
	
	public int getDamage() {
		
		return this.damage;
	}
	
	public int getManaCost() {
		return this.manaCost;
	}
	
	public int getCastRange() {
		return this.castRange;
	}
	
	public static List<Spell> getSpells() {
		if (spells == null) {
			throw new IllegalArgumentException("Initialize spells");
		}
		
		return spells;
	}
	
	public Spell(String name, int damage, int manaCost, int castRange) {
		setName(name);
		
		setDamage(damage);
		
		setManaCost(manaCost);
		
		setCastRange(castRange);
	}
	
	public static void addSpell(Spell spell) {
		if (spell == null) {
			throw new IllegalArgumentException("Illegal spell to add");
		}
		
		spells.add(spell);
	}
	
	public static void addAllSpells(List<Spell> wisdom) {
		if (wisdom == null) {
			throw new IllegalArgumentException("Illegal spells to add");
		}
		
		for (Spell spell : wisdom) {
			addSpell(spell);
		}
	}
	
	public static void addAllSpells(Spell[] wisdom) {
		if (wisdom == null) {
			throw new IllegalArgumentException("Illegal spells to add");
		}
		
		for (Spell spell : wisdom) {
			addSpell(spell);
		}

	}
	
	public static void printSpells() {
		if (spells.isEmpty()) {
			System.out.println("Hero has no wisdom! " +
					"Send him to Isengard to Saruman The White");
			return;
		}
		
		System.out.print("Spells: ");
		
		for (int i = 0; i < spells.size(); i++) {
			System.out.print(spells.get(i).getName());
			
			if (i < spells.size() - 1) {
				System.out.print(", ");
			}
			
			if (i == spells.size() - 1) {
				System.out.print(".");
			}
			
		}
		
		System.out.println();
	}
	
	public static Spell getRandomSpell() {
		int min = 0;
		int max = spells.size();
		int randomNum = ThreadLocalRandom.current().nextInt(min, max);
		
		Spell randomSpell = getSpells().get(randomNum);
		
		return randomSpell;
	}
}
