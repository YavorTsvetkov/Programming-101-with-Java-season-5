package week8.zombieApocalypse.armoury;

public abstract class ToShootWeapon implements Weapon {
	protected int damage;
	protected int bullets;
	protected static final String TYPE = "TO_SHOOT";
	
	public ToShootWeapon(int damage, int bullets) {
		this.damage = damage;
		this.bullets = bullets;
	}
	
	@Override
	public int getDamage() {
		if (this.bullets > 0) {
			this.bullets--;
			return this.damage;
			
		} else {
			return 1;
		}
	}

	@Override
	public int getDurability() {
		return this.bullets;
	}

	@Override
	public String getType() {
		return TYPE;
	}

}
