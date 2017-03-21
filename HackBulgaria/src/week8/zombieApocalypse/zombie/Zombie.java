package week8.zombieApocalypse.zombie;

public class Zombie implements ZombieInterface {
	
	private int totalHealth;
	private int currentHealth;
	
	public Zombie(int health) {
		this.totalHealth = health;
		this.currentHealth = health;
	}

	@Override
	public int getTotalHealth() {
		return this.totalHealth;
	}

	@Override
	public int getCurrentHealth() {
		return this.currentHealth;
	}

	@Override
	public void hit(int damage) {
		if (this.currentHealth - damage <= 0) {
			this.currentHealth = 0;
			
		} else {
			this.currentHealth -= damage;
		}
	}

	@Override
	public boolean isDead() {
		if (this.currentHealth > 0) {
			return false;
		}
		
		return true;
	}
	
	public boolean isAlive() {
		if (this.currentHealth > 0) {
			return true;
		}
		
		return false;
	}

}
