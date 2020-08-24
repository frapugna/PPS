package _GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domainClasses.AbstractCardData;
import domainClasses.MainCharacterData;

public class MainCharacterCard extends JPanel{

	private static final long serialVersionUID = 1L;
	static final int WIDTH = 150;
	static final int HEIGHT = 200;
	static final int MAX_HP = 20;

	final Rectangle HP_RECT = new Rectangle(35, 165, 40, 30);
	final Rectangle HP_ICON_RECT = new Rectangle(5, 160, 30, 30);
	final String HP_ICON_PATH = "resources/cardIcons/heartIcon.png";

	final Rectangle DURABILITY_RECT = new Rectangle(105, 165, 40, 30);
	final Rectangle DURABILITY_ICON_RECT = new Rectangle(75, 160, 30, 30);
	final String DURABILITY_ICON_PATH = "resources/cardIcons/swordIconResized.png";


	int xCoor;
	int yCoor;
	int hp;
	int weaponDurability;

	ImageIcon image;
	MainCharacterData cardType;

	JLabel hpLabel;
	JLabel hpIcon;

	JLabel durabilityLabel;
	JLabel durabilityIcon;

	Image img;
	String BACKGROUND_PATH = "resources/cardIcons/mainCharacterbground.jpg";

	public MainCharacterCard(int xCoor, int yCoor, MainCharacterData data) {
		super();
		this.setLayout(null);
		this.xCoor = xCoor;
		this.yCoor = yCoor;

		this.setSize(WIDTH, HEIGHT);
		this.setBackground();

		this.cardType = data;

		image = new ImageIcon(cardType.getImagePath()); 	
		JLabel l = new JLabel(image);

		add(l);

		l.setBounds(5, 5, 140, 140);

		hp = cardType.gethp();
		hpLabel = new JLabel(String.format(": "+hp));
		this.add(hpLabel);
		hpLabel.setBounds(HP_RECT);

		hpIcon = new JLabel(new ImageIcon(HP_ICON_PATH));
		this.add(hpIcon);
		hpIcon.setBounds(HP_ICON_RECT);

		weaponDurability = cardType.getWeaponDurability();
		durabilityLabel = new JLabel(String.format(": "+weaponDurability));
		this.add(durabilityLabel);
		durabilityLabel.setBounds(DURABILITY_RECT);

		durabilityIcon = new JLabel(new ImageIcon(DURABILITY_ICON_PATH));
		this.add(durabilityIcon);
		durabilityIcon.setBounds(DURABILITY_ICON_RECT);

		durabilityLabel.setFont(new Font("Calibri",Font.BOLD,20));
		hpLabel.setFont(new Font("Calibri",Font.BOLD,20));
		hpLabel.setForeground(Color.white);
		durabilityLabel.setForeground(Color.white);
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


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public int getWeaponDurability() {
		return weaponDurability;
	}


	public void setWeaponDurability(int weaponDurability) {
		this.weaponDurability = weaponDurability;
	}


	public AbstractCardData getCardType() {
		return cardType;
	}


	public void setCardType(MainCharacterData cardType) {
		this.cardType = cardType;
	}


	public JLabel getHpLabel() {
		return hpLabel;
	}


	public void setHpLabel(JLabel hpLabel) {
		this.hpLabel = hpLabel;
	}


	public JLabel getDurabilityLabel() {
		return durabilityLabel;
	}


	public void setDurabilityLabel(JLabel durabilityLabel) {
		this.durabilityLabel = durabilityLabel;
	}
}