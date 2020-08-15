package domainClasses;
/*
 * It extends the AbstractCardData giving an additional attribute
 */
public class WeaponData extends AbstractCardData{
	
	int durability;
	
	public WeaponData(String imagePath, String name, int durability) {
		super(imagePath, name);
		this.durability = durability;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}
	
}
