package _GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

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
	
	Image img;
	String BACKGROUND_PATH = "resources/cardIcons/cardFront.png";
	
	public Card(int xCoor, int yCoor) {
		super();
		this.setLayout(null);
		
		setBackground();
		
		this.xCoor = xCoor;
		this.yCoor = yCoor;
	
		Dealer d = new Dealer();
		cardType = d.drawCard();
		
		this.setSize(WIDTH, HEIGHT);
		
		
		image = new ImageIcon(cardType.getImagePath());
		JLabel l = new JLabel(image);
		
		add(l);
	
		l.setBounds(5, 5, 140, 140);
	}

	public void setBackground() {
	    img = Toolkit.getDefaultToolkit().createImage(BACKGROUND_PATH);
	    loadImage(img);
	  }

	protected void paintComponent(Graphics g) {
	    setOpaque(false);
	    g.drawImage(img, 0, 0, null);
	    super.paintComponent(g);
	  }
	
	  private void loadImage(Image img) {
	    try {
	      MediaTracker track = new MediaTracker(this);
	      track.addImage(img, 0);
	      track.waitForID(0);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
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