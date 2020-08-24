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
		minionList.add(new MinionData("resources/cardIcons/fireSkull.png", "FireSkull", 2));
		minionList.add(new MinionData("resources/cardIcons/goblin1.png", "Goblin", 3));	
		minionList.add(new MinionData("resources/cardIcons/skeletonResized.png", "Skeleton", 4));
		minionList.add(new MinionData("resources/cardIcons/trollFico1.png", "Troll", 5));	
		
		potionList = new ArrayList<AbstractCardData>();
		//add card data here
		potionList.add(new PotionData("resources/cardIcons/potion2.png", "SmallPotion", 2));
		potionList.add(new PotionData("resources/cardIcons/mediumPotionResized.png", "MediumPotion", 3));	
		potionList.add(new PotionData("resources/cardIcons/rainbowPotion.png", "RainbowPotion", 5));	
		
		repairPotionList = new ArrayList<AbstractCardData>();
		//add card data here
		repairPotionList.add(new RepairPotionData("resources/cardIcons/repairPotion1.png", "BlueMediumRP", 2));
		repairPotionList.add(new RepairPotionData("resources/cardIcons/yellowPotion.png", "BlueMediumRP", 3));
		
		
		trapList = new ArrayList<AbstractCardData>();
		//add card data here
		trapList.add(new TrapData("resources/cardIcons/mimic.png", "Mimic", 6));	
		trapList.add(new TrapData("resources/cardIcons/yellowPotion.png", "Mimic", 2));	
	
		
		weaponList = new ArrayList<AbstractCardData>();
		//add card data here
		weaponList.add(new WeaponData("resources/cardIcons/swordResized.png", "StandardSword", 2));	
		weaponList.add(new WeaponData("resources/cardIcons/laserGunResized.png", "LaserGun", 6));	
		weaponList.add(new WeaponData("resources/cardIcons/goldenShield.png", "GoldenShield", 3));	
	
		
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