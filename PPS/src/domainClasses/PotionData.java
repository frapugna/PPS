package domainClasses;
/*
 * It extends the parent class adding a new attribute, it also provides methods to interact with that
 */
public class PotionData extends AbstractCardData{
	
	int hpHealed;
	
	public PotionData(String imagePath, String name, int hpHealed) {
		super(imagePath, name);
		this.hpHealed = hpHealed;
	}

	public int getHpHealed() {
		return hpHealed;
	}

	public void setHpHealed(int hpHealed) {
		this.hpHealed = hpHealed;
	}
}