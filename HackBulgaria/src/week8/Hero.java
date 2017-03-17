package week8;

import java.util.ArrayList;
import java.util.List;

/**
 * Modeling a hero.
 * He has name, title, health, mana, mana regeneration rate.
 * @author yavor
 *
 */
public class Hero {
	private String name;
	private String title;
	
	//keeps current health
	private int health;
	
	//keeps max health
	private int maxHealth;
	
	//keeps current mana
	private int mana;
	
	//keeps max amount of mana
	private int maxMana;
	
	//The amount of regeneration of the mana
	private int manaRegenRate;
	
	//the weapon, used from the hero to attack
	private Weapon weapon;
	
	//list of learned spells.
	//The hero can use only the last learned spell;
	private List<Spell> learnedSpells;
	
	//The spell used from the hero to attack
	private Spell spell;
	
	
	
	public String getName() {
		return this.name;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getMaxHealth() {
		return this.maxHealth;
	}
	
	public int getMana() {
		return this.mana;
	}
	
	public int getMaxMana() {
		return this.maxMana;
	}
	
	public int getManaRegenRate() {
		return this.manaRegenRate;
	}
	
	public Weapon getWeapon() {
		return this.weapon;
	}
	
	public List<Spell> getLearnedSpells() {
		if (this.learnedSpells == null) {
			throw new NullPointerException("Learned spells problem.");
		}
		
		return this.learnedSpells;
	}
	
	public Spell getSpell() {
		if (this.spell == null) {
			throw new NullPointerException("Initilize hero spell.");
		}
		
		return this.spell;
	}
	
	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Illegal hero name - " + name);
		}
		
		this.name = name;
	}
	
	public void setTitle(String title) {
		if (title == null) {
			throw new IllegalArgumentException("Illegal hero title - " + title);
		}
		
		this.title = title;
	}
	
	public void setHealth(int health) {
		if (health <= 0) {
			throw new IllegalArgumentException(
					"Hero' s health has to be greater than 0!");
		}
		
		this.health = health;
	}
	
	public void setMana(int mana) {
		if (mana < 0) {
			throw new IllegalArgumentException(
					"Hero' s mana has to be equal or greater than 0!");
		}
		
		this.mana = mana;
	}
	
	public void setManaRegenRate(int manaRegenRate) {
		if (manaRegenRate <= 0) {
			throw new IllegalArgumentException(
					"Mana regeneration rate has to be greater than 0!");
		}
		
		this.manaRegenRate = manaRegenRate;
	}
	
	public void setSpell(Spell spell) {
		if (spell == null) {
			throw new IllegalArgumentException("Spell cannot be null");
		}
		
		this.spell = spell;
	}
	
	public Hero() {
		
	}
	
	public Hero(String name, String title, int health, int mana, int manaRegenRate) {
		setName(name);
		setTitle(title);
		
		setHealth(health);
		this.maxHealth = health;
		
		setMana(mana);
		this.maxMana = mana;
		
		setManaRegenRate(manaRegenRate);
		
		this.learnedSpells = new ArrayList<Spell>();
	}
	
	/**
	 * 
	 * @return a string with information about hero' s
	 * identity.
	 */
	public String knownAs() {
		String result = String.format("%s the %s", getName(), getTitle());
		return result;
	}
	
	/**
	 * checks current state of the hero.
	 * @return true if the hero is alive,
	 * or false if not.
	 */
	public boolean isAlive() {
		if (getHealth() <= 0) {
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * checks if the hero has enough mana for casting any spell.
	 * @return true if he can cast or false if he can't.
	 */
	public boolean canCast() {
		
		if (hasEnoughMana()) {
			
			return true;
		}
		
		return false;
	}
	
	private boolean hasEnoughMana() {
		return getMana() >= getSpell().getManaCost();
	}
	
	/**
	 * when the hero takes damage
	 * his health points are reduced with damage points.
	 * @param damage - points to reduce his health
	 */
	public void takeDamage(int damage) {
		this.health -= damage;
		
		//heros' s health cannot be lower than 0
		if (this.health < 0) {
			this.health = 0;
		}
	}
	
	/**
	 * hero can heals.
	 * His health is increased with the healing points.
	 * @param healingPoints - the amount of points to increase his
	 * health.
	 */
	public void takeHealing(int healingPoints) {
		if (healingPoints < 0) {
			throw new IllegalArgumentException(
					"Healing points have to be greater than or equals to zero!");
		}
		
		this.health += healingPoints;
		
		//hero' s health cannot be higher than the maximum health
		if (this.health > this.maxHealth) {
			this.health = this.maxHealth;
		}
	}
	
	public void takeMana(int manaPoints) {
		if (manaPoints < 0) {
			throw new IllegalArgumentException(
					"Mana points have to be greater than or equlas to zero!");
		}
		
		this.mana += manaPoints;
		
		if (this.mana > this.maxMana) {
			this.mana = this.maxMana;
		}
	}
	
	public void equip(Weapon weapon) {
		if (weapon == null) {
			throw new IllegalArgumentException(
					"The weapon cannot be null!");
		}
		
		this.weapon = weapon;
	}
	
	public void learn(Spell spell) {
		if (spell == null) {
			throw new IllegalArgumentException(
					"The spell cannot be null!");
		}
		
		//adding the new spell in the head of hero
		this.learnedSpells.add(spell);
		
		//the hero can use only the last learned spell
		this.spell = this.learnedSpells.get(this.learnedSpells.size() - 1);
	}
	
	private boolean IsNotWeaponOrSpell(String item) {
		return (!item.equalsIgnoreCase("weapon") && !item.equalsIgnoreCase("spell"));
	}
	
	private int attackWithWeapon() {
		if (this.weapon == null) {
			return 0;
		}
		
		return this.weapon.getDamage();
	}
	
	private int attackWithSpell() {
		if (this.spell == null) {
			return 0;
		}
		
		if (canCast()) {
			
			setMana(getMana() - getSpell().getManaCost());
			return this.spell.getDamage();
		}
		return 0;
	}
	
	/**
	 * Simulates the attack of the hero.
	 * A hero can attack with a weapon or a spell.
	 * If he doesn' t have a weapon or a spell to attack with, he inflict 0 damage. 
	 * @param item - weapon or spell to attack with.
	 * @return the damage inflict by his attack.
	 */
	public int attack(String item) {
		if (IsNotWeaponOrSpell(item)) {
			throw new IllegalArgumentException(
					"The hero can attack only with weapon or spell");
		}
		
		if (item.equalsIgnoreCase("weapon")) {
			return attackWithWeapon();
		}
		
		if (item.equalsIgnoreCase("spell")) {
			return attackWithSpell();
		}
		
		return Integer.MAX_VALUE;
	}
	
	
}
