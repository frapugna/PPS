package domainClasses;
/*
 * It doesn't add features to CharacterData class, it exists in order to have a better hierarchy 
 * organization, so it is a non-abstract version of the parent class
 */
public class MinionData extends CharacterData{

	public MinionData(String imagePath, String name, int hp) {
		super(imagePath, name, hp);
	}
	
}