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
	List<? super AbstractCardData> minionList;
	List<? super AbstractCardData> potionList;
	List<? super AbstractCardData> repairPotionList;
	List<? super AbstractCardData> trapList;
	List<? super AbstractCardData> weaponList;
	/*
	 * This collection contains all the good classes
	 */
	HashMap<String, List<? super AbstractCardData>> goodCategoriesMap;
	/*
	 * This collection contains all the evil classes
	 */
	HashMap<String, List<? super AbstractCardData>> evilCategoriesMap;

	int alignements;
	
	public CardDeck() {
		super();
		
		minionList = new ArrayList<AbstractCardData>();
		//add card data here
		minionList.add(new MinionData(null, "Minion", 6));	//DELETE THIS, IT EXISTS JUST FOR EXAMPLE
		minionList.add(new MinionData(null, "Minion2", 4));	//DELETE THIS, IT EXISTS JUST FOR EXAMPLE
		
	
		potionList = new ArrayList<AbstractCardData>();

		//add card data here
		potionList.add(new PotionData(null, "Potion", 12));	//DELETE THIS, IT EXISTS JUST FOR EXAMPLE
		potionList.add(new PotionData(null, "Potion2", 1));	//DELETE THIS, IT EXISTS JUST FOR EXAMPLE
		
		repairPotionList = new ArrayList<AbstractCardData>();
		//add card data here
		repairPotionList.add(new RepairPotionData(null, "Rp", 12));	//DELETE THIS, IT EXISTS JUST FOR EXAMPLE
		repairPotionList.add(new RepairPotionData(null, "Rp2", 6));	//DELETE THIS, IT EXISTS JUST FOR EXAMPLE

		
		trapList = new ArrayList<AbstractCardData>();
		//add card data here
		trapList.add(new TrapData(null, "Trap", 2));	//DELETE THIS, IT EXISTS JUST FOR EXAMPLE
		trapList.add(new TrapData(null, "Trap2", 82));	//DELETE THIS, IT EXISTS JUST FOR EXAMPLE
	
		
		weaponList = new ArrayList<AbstractCardData>();
		//add card data here
		weaponList.add(new WeaponData(null, "Weapon", 4));	//DELETE THIS, IT EXISTS JUST FOR EXAMPLE
		weaponList.add(new WeaponData(null, "Weapon2", 100000));	//DELETE THIS, IT EXISTS JUST FOR EXAMPLE
	
		
		goodCategoriesMap = new HashMap<String, List<? super AbstractCardData>>();
		
		goodCategoriesMap.put("Potion", potionList);
		goodCategoriesMap.put("RepairPotion", repairPotionList);
		goodCategoriesMap.put("Weapon", weaponList);
	
		
		evilCategoriesMap = new HashMap<String, List<? super AbstractCardData>>();
		
		evilCategoriesMap.put("Minion", minionList);
		evilCategoriesMap.put("Trap", trapList);
	
		alignements = 2;
	}

	public int getAlignements() {
		return alignements;
	}

	public HashMap<String, List<? super AbstractCardData>> getGoodCategoriesMap() {
		return goodCategoriesMap;
	}

	public HashMap<String, List<? super AbstractCardData>> getEvilCategoriesMap() {
		return evilCategoriesMap;
	}
}
