package _GUI;

import java.awt.Rectangle;

import javax.swing.JLabel;

import domainClasses.MinionData;
import domainClasses.PotionData;
import domainClasses.RepairPotionData;
import domainClasses.TrapData;
import domainClasses.WeaponData;

public class CharacterCard extends Card{
	
	final Rectangle STATUS_RECT = new Rectangle(5, 160, 70, 30);
	int leftValue;
	JLabel status;
	
	public CharacterCard(int xCoor, int yCoor) {
		super(xCoor, yCoor);
		if(cardType instanceof WeaponData) {
			WeaponData wd = (WeaponData) cardType;
			leftValue = wd.getDurability();
			status = new JLabel(String.format("Uses: "+leftValue));
			this.add(status);
			status.setBounds(STATUS_RECT);
			
		}
		else if(cardType instanceof TrapData) {
			TrapData td = (TrapData) cardType;
			leftValue = td.getDamage();
			status = new JLabel(String.format("Power: "+leftValue));
			this.add(status);
			status.setBounds(STATUS_RECT);
		}
		else if(cardType instanceof RepairPotionData) {
			RepairPotionData rpd = (RepairPotionData) cardType;
			leftValue = rpd.getAmount();
			status = new JLabel(String.format("Amount: "+leftValue));
			this.add(status);
			status.setBounds(STATUS_RECT);
		}
		else if(cardType instanceof PotionData) {
			PotionData pd = (PotionData) cardType;
			leftValue = pd.getHpHealed();
			status = new JLabel(String.format("Healed: "+leftValue));
			this.add(status);
			status.setBounds(STATUS_RECT);
		}
		else{
			MinionData md = (MinionData) cardType;
			leftValue = md.gethp();
			status = new JLabel(String.format("HP: "+leftValue));
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
