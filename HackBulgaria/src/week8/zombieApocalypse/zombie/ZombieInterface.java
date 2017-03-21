package week8.zombieApocalypse.zombie;

public interface ZombieInterface {
	public int getTotalHealth();
	public int getCurrentHealth();
	public void hit(int damage);
	public boolean isDead();
}
