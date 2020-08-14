package domainClasses;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

/*
 * This class after the initialization could be use to generate random Generic AbstractCardData instances
 */
public class Dealer {

	CardDeck deck;
	HashMap<String, List<? super AbstractCardData>> selectedMap;
	List<? super AbstractCardData> selectedList;
	Random r;
	String key;
	int lastRnd;
	
	public Dealer() {
		super();
		this.deck = new CardDeck();
	}
	
	/*
	 * Return a random AbstractCardData from the deck
	 */
	public AbstractCardData drawCard() {
		
		AbstractCardData out /*= null*/;
		r = new Random();
		int i = r.nextInt(deck.alignments);
		
		if(i == 0) {
			selectedMap = deck.getGoodCategoriesMap();
			i = r.nextInt(selectedMap.size());
			switch(i) {
			case 0: key = "Potion";
					break;
			case 1: key = "RepairPotion";
					break;
			case 2: key = "Weapon";
					break;
			}
			/*if(i==0) 
				key = "Potion";
			else
				if(i==1)
					key = "RepairPotion";
				else
					if(i==2)
						key = "Weapon";
			Changed to switch-case for readability and optimization; !!!!DELETE after checking if it works			
			*/
		}
		else {
			selectedMap = deck.getEvilCategoriesMap();
			i = r.nextInt(selectedMap.size());
			switch(i) {
			case 0: key = "Minion";
					break;
			case 1: key = "Trap";
					break;
			}
			/*
			if(i==0)
				key = "Minion";
			else
				if(i==1)
					key = "Trap";
			Same as above*/
		}
		
		selectedList = selectedMap.get(key);
		i = r.nextInt(selectedList.size());
		out = (AbstractCardData) selectedList.get(i);
		return out;
		
	}

}







