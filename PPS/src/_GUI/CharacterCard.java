package _GUI;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import domainClasses.MinionData;
import domainClasses.PotionData;
import domainClasses.RepairPotionData;
import domainClasses.TrapData;
import domainClasses.WeaponData;
/*
 * This is class extends the abstract class "Card" adding a new attribute called "leftValue",
 * it is used to initialize a JLabel and it represents the effect that a card has if it has an interaction with the character,
 * the CardGrid class will use this value only after the use of "instanceof" in order to understand the value's meaning
 */
public class CharacterCard extends Card{
	
	private static final long serialVersionUID = 1L;
	
	final Rectangle STATUS_RECT = new Rectangle(35, 165, 70, 30);
	final Rectangle STATUS_ICON_RECT = new Rectangle(5, 160, 30, 30);
	final String HEART_ICON_PATH = "resources/cardIcons/heartIcon.png";
	final String SWORD_ICON_PATH = "resources/cardIcons/swordIconResized.png";
	final String SKULL_ICON_PATH = "resources/cardIcons/skullIconResized.png";
	final String HEAL_ICON_PATH = "resources/cardIcons/hpUpIconResized.png";
	final String REPAIR_ICON_PATH = "resources/cardIcons/durabilityUpIconResized.png";
	int leftValue;
	JLabel status;
	JLabel statusIcon;
	
	public CharacterCard(int xCoor, int yCoor) {
		super(xCoor, yCoor);
		if(cardType instanceof WeaponData) {
			WeaponData wd = (WeaponData) cardType;
			leftValue = wd.getDurability();
			status = new JLabel(String.format(": "+leftValue));
			this.add(status);
			status.setBounds(STATUS_RECT);
			statusIcon = new JLabel(new ImageIcon(SWORD_ICON_PATH));
			this.add(statusIcon);
			statusIcon.setBounds(STATUS_ICON_RECT);
		}
		else if(cardType instanceof TrapData) {
			TrapData td = (TrapData) cardType;
			leftValue = td.getDamage();
			status = new JLabel(String.format(": "+leftValue));
			this.add(status);
			status.setBounds(STATUS_RECT);
			statusIcon = new JLabel(new ImageIcon(SKULL_ICON_PATH));
			this.add(statusIcon);
			statusIcon.setBounds(STATUS_ICON_RECT);
		}
		else if(cardType instanceof RepairPotionData) {
			RepairPotionData rpd = (RepairPotionData) cardType;
			leftValue = rpd.getAmount();
			status = new JLabel(String.format(": "+leftValue));
			this.add(status);
			status.setBounds(STATUS_RECT);
			statusIcon = new JLabel(new ImageIcon(REPAIR_ICON_PATH));
			this.add(statusIcon);
			statusIcon.setBounds(STATUS_ICON_RECT);
		}
		else if(cardType instanceof PotionData) {
			PotionData pd = (PotionData) cardType;
			leftValue = pd.getHpHealed();
			status = new JLabel(String.format(": "+leftValue));
			this.add(status);
			status.setBounds(STATUS_RECT);
			statusIcon = new JLabel(new ImageIcon(HEAL_ICON_PATH));
			this.add(statusIcon);
			statusIcon.setBounds(STATUS_ICON_RECT);
		}
		else{
			MinionData md = (MinionData) cardType;
			leftValue = md.gethp();
			status = new JLabel(String.format(": "+leftValue));
			this.add(status);
			status.setBounds(STATUS_RECT);
			statusIcon = new JLabel(new ImageIcon(HEART_ICON_PATH));
			this.add(statusIcon);
			statusIcon.setBounds(STATUS_ICON_RECT);
		}
		status.setFont(new Font("Calibri",Font.BOLD,20));
		
	}

	public int getLeftValue() {
		return leftValue;
	}

	public void setLeftValue(int leftValue) {
		this.leftValue = leftValue;
	}

	public JLabel getStatus() {
		return status;
	}

	public void setStatus(JLabel status) {
		this.status = status;
	}
	
}