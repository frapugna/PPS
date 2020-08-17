package _GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domainClasses.AbstractCardData;
import domainClasses.Dealer;

public abstract class Card extends JPanel{
	
	static final int WIDTH = 150;
	static final int HEIGHT = 200;
	
	
	int xCoor;
	int yCoor;
	
	ImageIcon image;
	AbstractCardData cardType;
	
	/**
	 * @param xCoor
	 * @param yCoor
	 */
	public Card(int xCoor, int yCoor) {
		super();
		this.setLayout(null);
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		
		Dealer d = new Dealer();
		cardType = d.drawCard();
		
		this.setSize(WIDTH, HEIGHT);
		this.setBackground(Color.ORANGE);
		
		image = new ImageIcon("dog.jpg");
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