package week8.dungeonsAndZombies;

public class Fight {
	private Hero hero;
	private Enemy enemy;
	private Dungeon dungeon;
	
    public void setHero(Hero hero) {
    	if (hero == null) {
    		throw new IllegalArgumentException("Hero cannot be null.");
    	}
    	
    	this.hero = hero;
    }
    
    public void setEnemy(Enemy enemy) {
    	if (enemy == null) {
    		throw new IllegalArgumentException("Enemy cannot be null.");
    	}
    	
    	this.enemy = enemy;
    }
    
    public void setDungeon(Dungeon dungeon) {
    	if (dungeon == null) {
    		throw new IllegalArgumentException("Dungeon cannot be null");
    	}
    	
    	this.dungeon = dungeon;
    }
    
    public Hero getHero() {
    	if (this.hero == null) {
    		throw new NullPointerException("Initialize hero.");
    	}
    	
    	return this.hero;
    }
    
    public Enemy getEnemy() {
    	if (this.enemy == null) {
    		throw new NullPointerException("Initialize enemy.");
    	}
    	
    	return this.enemy;
    }
    
    public Dungeon getDungeon() {
    	if (this.dungeon == null) {
    		throw new NullPointerException("Initialize dungeon");
    	}
    	
    	return this.dungeon;
    }
	
	public Fight(Hero hero, Enemy enemy) {
		setHero(hero);
		
		setEnemy(enemy);
	}
	
	public void startFight() {
		
		while ((getHero().getHealth() > 0) && (getEnemy().getHealth() > 0)) {
			heroAttack();
			if (getEnemy().getHealth() <= 0) {
				continue;
			}
			
			enemyAttack();
			if (getHero().getHealth() <= 0) {
				continue;
			}
			
		}
		
		if (!getHero().isAlive()) {
			System.out.println("Hero is defeated. Game over!");
			return;
			
		} else if (!getEnemy().isAlive()) {
			System.out.println("Enemy is defeated! Continue to " +
					"search the gate of Moria.");
			
		}
	}
	
	public void heroAttack() {
		String attackBy = getLethalAttack();
		String heroName = getHero().getName();
		
		getEnemy().takeDamage(getHero().attack(attackBy));
		int enemyHealth = getEnemy().getHealth();
		
		if (attackBy.equals("weapon")) {
			String weaponName = getHero().getWeapon().getName();
			int weaponDamage = getHero().getWeapon().getDamage();
			System.out.printf("%s attack with %s and takes " +
					"%d damage.%n",heroName, weaponName, weaponDamage);
			
		} else {
			String spellName = getHero().getSpell().getName();
			int spellDamage = getHero().getSpell().getDamage();
			System.out.printf("%s attack with %s and takes %d damage." +
					"%n",heroName, spellName ,spellDamage);
		}
		
		System.out.printf("Enemy has %d health.%n", enemyHealth);		
	}
	
	/**
	 * decide what to attack with - weapon or spell
	 * depending on what is more damaging
	 * @return
	 */
	private String getLethalAttack() {
		int weaponDamage = getHero().getWeapon().getDamage();
		int spellDamage = getHero().getSpell().getDamage();
		
		if (spellDamage >= weaponDamage) {
			if (getHero().canCast()) {
				
				return "spell";
			}
			
		} else {			
			
			return "weapon";
		}
		
		return "weapon";
	}
	
	public void enemyAttack() {
		String heroName = getHero().getName();
		int heroHealth = getHero().getHealth();
		
		int enemyDamage = getEnemy().getDamage();
		
		getHero().takeDamage(getEnemy().attack());
		System.out.printf("Enemy attack with %d damage.%n", enemyDamage);
		System.out.printf("%s has %d health.%n",heroName, heroHealth);
	}
}
