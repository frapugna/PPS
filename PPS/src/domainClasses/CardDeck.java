package domainClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * This class is structered as a a tree whoose nodes are Lists of AbstractCardData
 */

public class CardDeck {
	/*
	 * Thoose Lists are the leeves of the tree
	 */
	List<? extends AbstractCardData> minionList;
	List<? extends AbstractCardData> potionList;
	List<? extends AbstractCardData> repairPotionList;
	List<? extends AbstractCardData> trapList;
	List<? extends AbstractCardData> weaponList;
	
	int weapons;
	int potions;
	int repairPotions;
	int traps;
	int minions;
	/*
	 * This collection contains all the good classes
	 */
	HashMap<String, List<? extends AbstractCardData>> goodCategoriesMap;
	int goodCategories;
	/*
	 * This collection contains all the evil classes
	 */
	HashMap<String, List<? extends AbstractCardData>> evilCategoriesMap;
	int evilCategories;
	/*
	 * This is the top-level HashMap, it is needed to select the cards' alignement by the Dealer class
	 */
	HashMap<String,HashMap<String,List<? extends AbstractCardData>>> alignementMap;
	int alignements;
	
	public CardDeck() {
		super();
		
		minionList = new ArrayList<AbstractCardData>();
		//add card data here
		minions = 0;//after adding other elements increment this
	
		potionList = new ArrayList<AbstractCardData>();
		potions = 0;//after adding other elements increment this
		//add card data here
		
		repairPotionList = new ArrayList<AbstractCardData>();
		//add card data here
		repairPotions = 0;//after adding other elements increment this
		
		trapList = new ArrayList<AbstractCardData>();
		//add card data here
		traps  = 0;	//after adding other elements increment this
		
		weaponList = new ArrayList<AbstractCardData>();
		//add card data here
		weapons = 0;	//after adding other elements increment this
		
		goodCategoriesMap = new HashMap<String, List<? extends AbstractCardData>>();
		
		goodCategoriesMap.put("Potion", potionList);
		goodCategoriesMap.put("RepairPotion", repairPotionList);
		goodCategoriesMap.put("Weapon", weaponList);
		goodCategories = 3;
		
		evilCategoriesMap = new HashMap<String, List<? extends AbstractCardData>>();
		
		evilCategoriesMap.put("Minion", minionList);
		evilCategoriesMap.put("Trap", trapList);
		evilCategories = 2;
		
		alignementMap = new HashMap<String,HashMap<String,List<? extends AbstractCardData>>>();
		
		alignementMap.put("Good", goodCategoriesMap);
		alignementMap.put("Evil", evilCategoriesMap);
		alignements = 2;
	}

	public int getWeapons() {
		return weapons;
	}


	public int getPotions() {
		return potions;
	}



	public int getRepairPotions() {
		return repairPotions;
	}


	public int getTraps() {
		return traps;
	}



	public int getMinions() {
		return minions;
	}



	public int getGoodCategories() {
		return goodCategories;
	}


	public int getEvilCategories() {
		return evilCategories;
	}



	public HashMap<String, HashMap<String, List<? extends AbstractCardData>>> getAlignementMap() {
		return alignementMap;
	}



	public int getAlignements() {
		return alignements;
	}

}
