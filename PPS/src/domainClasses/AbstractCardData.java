package domainClasses;
/*
 * This abstract class give a partial implementation of the CardDataInterface,
 * it adds two methods to get card's name and imagePath
 */
public abstract class AbstractCardData implements CardDataInterface{
	/*
	 * imagePath: the path to find the correct image to display
	 * name: the name assigned to the card
	 */
	String imagePath;
	String name;
	
	public AbstractCardData(String imagePath, String name) {
		super();
		this.imagePath = imagePath;
		this.name = name;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	public String getName() {
		return name;
	}

}
