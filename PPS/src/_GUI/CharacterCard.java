package _GUI;

import java.awt.Rectangle;

import javax.swing.JLabel;

import domainClasses.AbstractCardData;
import domainClasses.MinionData;
import domainClasses.PotionData;
import domainClasses.RepairPotionData;
import domainClasses.TrapData;
import domainClasses.WeaponData;
/*
 * This is class extends the abstract class "Card" adding a new attribute called "leftValue",
 * it is used to initialize a JLabel and it represents the effect that a card has if it has an interaction with the character,
 * the CardGrid class will use this value only after the use of "insatnceof" in order to understand the value's meaning
 */
public class CharacterCard extends Card{
	
	private static final long serialVersionUID = 1L;
	
	final Rectangle STATUS_RECT = new Rectangle(5, 160, 70, 30);
	int leftValue;
	JLabel status;
	
	public CharacterCard(int xCoor, int yCoor) {
		super(xCoor, yCoor);
		if(cardType instanceof WeaponData) {
			WeaponData wd = (WeaponData) cardType;
			leftValue = wd.getDurability();
			status = new JLabel(String.format("⚔️: "+leftValue));
			this.add(status);
			status.setBounds(STATUS_RECT);
			
		}
		else if(cardType instanceof TrapData) {
			TrapData td = (TrapData) cardType;
			leftValue = td.getDamage();
			status = new JLabel(String.format("☠️: "+leftValue));
			this.add(status);
			status.setBounds(STATUS_RECT);
		}
		else if(cardType instanceof RepairPotionData) {
			RepairPotionData rpd = (RepairPotionData) cardType;
			leftValue = rpd.getAmount();
			status = new JLabel(String.format("⬆️⚔️: "+leftValue));
			this.add(status);
			status.setBounds(STATUS_RECT);
		}
		else if(cardType instanceof PotionData) {
			PotionData pd = (PotionData) cardType;
			leftValue = pd.getHpHealed();
			status = new JLabel(String.format("⬆️❤️: "+leftValue));
			this.add(status);
			status.setBounds(STATUS_RECT);
		}
		else{
			MinionData md = (MinionData) cardType;
			leftValue = md.gethp();
			status = new JLabel(String.format("❤️: "+leftValue));
			this.add(status);
			status.setBounds(STATUS_RECT);
		}
		
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
