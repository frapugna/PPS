package domainClasses;
/*
 * It extends the parent class adding a new attribute, it also provides methods to interact with that
 */
public class RepairPotionData extends AbstractCardData{
	
	int amount;

	public RepairPotionData(String imagePath, String name, int amount) {
		super(imagePath, name);
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}