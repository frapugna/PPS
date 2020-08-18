package _GUI;


import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domainClasses.AbstractCardData;
import domainClasses.Dealer;
/*
 * This class give a partial implementation of the graphic representation 
 * of a card
 */
public abstract class Card extends JPanel{
	
	private static final long serialVersionUID = 1L;
	static final int WIDTH = 150;
	static final int HEIGHT = 200;
	
	/*
	 * xCoor and yCoor are the position of the card into 
	 * the matrix displayed
	 */
	int xCoor;
	int yCoor;
	
	ImageIcon image;
	AbstractCardData cardType;
	
	public Card(int xCoor, int yCoor) {
		super();
		this.setLayout(null);
		this.xCoor = xCoor;
		this.yCoor = yCoor;
	
		Dealer d = new Dealer();
		cardType = d.drawCard();
		
		this.setSize(WIDTH, HEIGHT);
		this.setBackground(Color.ORANGE);
		
		image = new ImageIcon(cardType.getImagePath());
		JLabel l = new JLabel(image);
		
		add(l);
	
		l.setBounds(5, 5, 140, 140);
	}

	public int getxCoor() {
		return xCoor;
	}

	public void setxCoor(int xCoor) {
		this.xCoor = xCoor;
	}

	public int getyCoor() {
		return yCoor;
	}

	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
	}

	public AbstractCardData getCardType() {
		return cardType;
	}

	public void setCardType(AbstractCardData cardType) {
		this.cardType = cardType;
	}
	
}
