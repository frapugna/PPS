package domainClasses;
/*
 * It extends the AbstractCardData giving an additional attribute
 */
public class WeaponData {
	int durability;
	
	public WeaponData(int durability) {
		super();
		this.durability = durability;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}
	
}
