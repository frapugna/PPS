package domainClasses;
/*
 * This abstract class add the hp attribute to the parent class, it is a feature shared by the 
 * main character and the villains who are CharacterData's subclasses.
 * It also implements an additional gethp() method
 * 
 */
public abstract class CharacterData extends AbstractCardData{
	/*
	 * hp: the starting hp of the character
	 */
	int hp;
	/*
	 * The only difference with parent's constructor is the parameter hp
	 */
	public CharacterData(String imagePath, String name, int hp) {
		super(imagePath, name);
		this.hp = hp;
	}
	/*
	 * This method returns the starting hp
	 */
	public int gethp() {
		return hp;
	}
		
}
