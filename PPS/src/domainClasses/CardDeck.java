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
		minionList.add(new MinionData("resources/cardIcons/imp.png", "Imp", 1));
		minionList.add(new MinionData("resources/cardIcons/fireSkull.png", "FireSkull", 2));
		minionList.add(new MinionData("resources/cardIcons/goblin1.png", "Goblin", 3));	
		minionList.add(new MinionData("resources/cardIcons/werewolf.png", "werewolf", 4));
		minionList.add(new MinionData("resources/cardIcons/trollFico1.png", "Troll", 5));	
		minionList.add(new MinionData("resources/cardIcons/lucertolone.png", "Lucertolone", 6));
		minionList.add(new MinionData("resources/cardIcons/polipoTauro.png", "PolipoTauro", 7));
		minionList.add(new MinionData("resources/cardIcons/dragoToro.png", "DragoToro", 8));
		minionList.add(new MinionData("resources/cardIcons/dragonRider.png", "Idra", 9));
		minionList.add(new MinionData("resources/cardIcons/idra.png", "Idra", 10));
		
		potionList = new ArrayList<AbstractCardData>();
		//add card data here
		potionList.add(new PotionData("resources/cardIcons/basicRedPotion.png", "SmallPotion", 2));
		potionList.add(new PotionData("resources/cardIcons/mediumPotionResized.png", "MediumPotion", 3));
		potionList.add(new PotionData("resources/cardIcons/primaticRedPotion.png", "prismaticRedPotion", 4));
		potionList.add(new PotionData("resources/cardIcons/redPotttttion.png", "Redpotttttion", 5));
		potionList.add(new PotionData("resources/cardIcons/rainbowPotion.png", "RainbowPotion", 6));	
		
		repairPotionList = new ArrayList<AbstractCardData>();
		//add card data here
		repairPotionList.add(new RepairPotionData("resources/cardIcons/repairPotion1.png", "BlueMediumRP", 2));
		repairPotionList.add(new RepairPotionData("resources/cardIcons/PotionRPP.png", "RPPPPP", 3));
		repairPotionList.add(new RepairPotionData("resources/cardIcons/yellowPotion.png", "BlueMediumRP", 4));
		repairPotionList.add(new RepairPotionData("resources/cardIcons/rp4.png", "rp4", 5));
		repairPotionList.add(new RepairPotionData("resources/cardIcons/presentRP.png", "rp6", 6));
		
		trapList = new ArrayList<AbstractCardData>();
		//add card data here
		trapList.add(new TrapData("resources/cardIcons/banana.png", "banana", 1));
		trapList.add(new TrapData("resources/cardIcons/yellowPotion.png", "fakePotion", 2));	
		trapList.add(new TrapData("resources/cardIcons/greenPoisonPoton.png", "poisonGreenPotion", 3));	
		trapList.add(new TrapData("resources/cardIcons/skullPotion.png", "skullPotion", 4));
		trapList.add(new TrapData("resources/cardIcons/spikeTrap.png", "spikeTrap", 5));
		trapList.add(new TrapData("resources/cardIcons/mimic.png", "Mimic", 6));	
		
	
		
		weaponList = new ArrayList<AbstractCardData>();
		//add card data here
		weaponList.add(new WeaponData("resources/cardIcons/GostWoodSword.png", "AlmostAWoodSword", 3));	
		weaponList.add(new WeaponData("resources/cardIcons/swordResized.png", "StandardSword", 4));	
		weaponList.add(new WeaponData("resources/cardIcons/almostNewGoldenSword.png", "SpadaQuasiNuova", 5));
		weaponList.add(new WeaponData("resources/cardIcons/shuriken.png", "Shuriken", 6));
		weaponList.add(new WeaponData("resources/cardIcons/goldenShield.png", "GoldenShield", 7));	
		weaponList.add(new WeaponData("resources/cardIcons/whiteBow.png", "whiteBow", 8));	
		weaponList.add(new WeaponData("resources/cardIcons/dualQualcosa.png", "DualQualcosa", 9));
		weaponList.add(new WeaponData("resources/cardIcons/SnowSword.png", "SnowSword", 10));
		weaponList.add(new WeaponData("resources/cardIcons/fireSword.png", "FireSword", 11));
		weaponList.add(new WeaponData("resources/cardIcons/laserGunResized.png", "LaserGun", 12));
		
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