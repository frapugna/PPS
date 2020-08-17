package domainClasses;

import java.util.ArrayList;
import java.util.List;

public class MainCharactersList {
	
	List<MainCharacterData> choiceMenu;
	
	public MainCharactersList() {
		
		choiceMenu = new ArrayList<MainCharacterData>();
		
		choiceMenu.add(new MainCharacterData("resources//warrior.png", "Maryo", 15, 2));;
		
	}

	public List<MainCharacterData> getChoiceMenu() {
		return choiceMenu;
	}

	public void setChoiceMenu(List<MainCharacterData> choiceMenu) {
		this.choiceMenu = choiceMenu;
	}
}
