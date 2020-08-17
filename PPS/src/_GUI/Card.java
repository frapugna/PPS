package _GUI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domainClasses.AbstractCardData;
import domainClasses.Dealer;

public class Card extends JPanel{
	
	static final int WIDTH = 150;
	static final int HEIGHT = 200;
	
	int xCoor;
	int yCoor;
	ImageIcon image;
	AbstractCardData startingData;
	
	public Card(int xCoor, int yCoor) {
		super();
		this.setLayout(null);
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		
		Dealer d = new Dealer();
		startingData = d.drawCard();
		
		this.setSize(WIDTH, HEIGHT);
		this.setBackground(Color.ORANGE);
		
		image = new ImageIcon("dog.jpg");
		JLabel l = new JLabel(image);
		
		add(l);
		
		l.setBounds(5, 5, 140, 140);
	}
	
}
