package domainClasses;
/*
 * It extends the parent class adding a new attribute, it also provides methods to interact with that
 */
public class TrapData extends AbstractCardData{
	
	int damage;

	public TrapData(String imagePath, String name, int damage) {
		super(imagePath, name);
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
}