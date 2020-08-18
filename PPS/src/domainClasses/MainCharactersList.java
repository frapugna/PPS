package domainClasses;

import java.util.ArrayList;
import java.util.List;

public class MainCharactersList {
	
	public List<MainCharacterData> choiceMenu;
	
	public MainCharactersList() {
		
		choiceMenu = new ArrayList<MainCharacterData>();
		
		choiceMenu.add(new MainCharacterData("resources/cardIcons/warriorResized.png", "Maryo", 15, 5));
		choiceMenu.add(new MainCharacterData("resources/cardIcons/assassinResized.jpg", "Ugo", 10, 10));
		choiceMenu.add(new MainCharacterData("resources/cardIcons/archerResized.jpg", "Myrko", 4, 16));
	}

	public List<MainCharacterData> getChoiceMenu() {
		return choiceMenu;
	}

	public void setChoiceMenu(List<MainCharacterData> choiceMenu) {
		this.choiceMenu = choiceMenu;
	}
}
