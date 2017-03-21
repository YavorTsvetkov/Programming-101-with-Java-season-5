package week8.zombieApocalypse.armoury;

public abstract class ToSmashWeapon implements Weapon {
	protected int damage;
	protected int initialDurability;
	protected int currentDurability;
	protected static final String TYPE = "TO_SMASH";
	
	public ToSmashWeapon(int damage, int initialDurability) {
		this.damage = damage;
		this.initialDurability = initialDurability;
		this.currentDurability = initialDurability;
	}
	
	@Override
	public int getDamage() {
		int damageInflicted = 0;
		
		if ((this.currentDurability - 1) >= (this.initialDurability / 2)) {
			damageInflicted = this.damage;
			
		} else {
			
			if (this.damage > 1) {				
				this.damage--;
			}
			
			damageInflicted = damage;
		}
		
		if (this.currentDurability > 0) {
			this.currentDurability--;			
		}
		
		return damageInflicted;
	}

	@Override
	public int getDurability() {
		return this.currentDurability;
	}

	@Override
	public String getType() {
		return TYPE;
	}
	
}
