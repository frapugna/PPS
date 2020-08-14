package domainClasses;


/*
 * This class adds to the general CharacterData class the weaponDurability attribute, it represents the durability of 
 * hero's starting weapon, it also provides methods to modify this attribute
 */
public class MainCharacterData extends CharacterData{
	
	/*
	 * weaponDurability: it is the initial durability of hero's weapon
	 */
	int weaponDurability;

	public MainCharacterData(String imagePath, String name, int hp, int weaponDurability) {
		super(imagePath, name, hp);
		this.weaponDurability = weaponDurability;
	}

	public int getWeaponDurability() {
		return weaponDurability;
	}
	
	public void setWeaponDurability(int weaponDurability) {
		this.weaponDurability = weaponDurability;
	}
	
	
	
}
