package week8.zombieApocalypse.armoury;

public abstract class ToShootWeapon implements WeaponInterface {
	protected int damage;
	protected int bullets;
	protected static final String TYPE = "TO_SHOOT";
	
	public ToShootWeapon(int damage, int bullets) {
		this.damage = damage;
		this.bullets = bullets;
	}
	
	@Override
	public int getDamage() {
		int damageInflicted = 0;
		
		if (this.bullets > 0) {
			damageInflicted = this.damage;
			this.bullets--;
			
		} else {
			damageInflicted = 1;
		}
		
		return damageInflicted;
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
