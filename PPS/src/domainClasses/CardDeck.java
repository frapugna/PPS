package domainClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
 * This class is structured as a a tree whose nodes are Lists of AbstractCardData
 */
public class CardDeck {
	/*
	 * Those Lists are the leaves of the tree
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

	int alignments;
	
	public CardDeck() {
		super();
		
		minionList = new ArrayList<AbstractCardData>();
		//add card data here
		minionList.add(new MinionData("resources/cardIcons/skeletonResized.png", "Skeleton", 6));	
		
		
	
		potionList = new ArrayList<AbstractCardData>();

		//add card data here
		potionList.add(new PotionData("resources/cardIcons/mediumPotionResized.png", "MediumPotion", 12));	
		
		
		repairPotionList = new ArrayList<AbstractCardData>();
		//add card data here
		repairPotionList.add(new RepairPotionData("resources/cardIcons/repairPotion1.png", "BlueMediumRP", 6));
		

		
		trapList = new ArrayList<AbstractCardData>();
		//add card data here
		trapList.add(new TrapData("resources/cardIcons/mimicResized.png", "Mimic", 6));	
		
	
		
		weaponList = new ArrayList<AbstractCardData>();
		//add card data here
		weaponList.add(new WeaponData("resources/cardIcons/swordResized.png", "StandardSword", 4));	
		weaponList.add(new WeaponData("resources/cardIcons/laserGunResized.png", "LaserGun", 10));	
	
		
		goodCategoriesMap = new HashMap<String, List<? super AbstractCardData>>();
		
		goodCategoriesMap.put("Potion", potionList);
		goodCategoriesMap.put("RepairPotion", repairPotionList);
		goodCategoriesMap.put("Weapon", weaponList);
	
		
		evilCategoriesMap = new HashMap<String, List<? super AbstractCardData>>();
		
		evilCategoriesMap.put("Minion", minionList);
		evilCategoriesMap.put("Trap", trapList);
	
		alignments = 2;
	}

	public int getAlignments() {
		return alignments;
	}

	public HashMap<String, List<? super AbstractCardData>> getGoodCategoriesMap() {
		return goodCategoriesMap;
	}

	public HashMap<String, List<? super AbstractCardData>> getEvilCategoriesMap() {
		return evilCategoriesMap;
	}
}
