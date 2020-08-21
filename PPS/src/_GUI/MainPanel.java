package _GUI;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * This is the main panel, it displays a menu where you can select 3 secondary panels
 */
public class MainPanel extends JPanel{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * parent: a reference to the parent frame
	 * playButton, highScoresButton, tutorialButton: the dynamic part of the panel
	 */
	JFrame parent;
	JButton playButton;
	JButton highScoreButton;
	JButton tutorialButton;
	
	Image img;
	String BACKGROUND_PATH = "resources/cardIcons/cardGridBackground2.png";
	
	/*
	 * Constructor which create the panel using a GridBagLayout
	 */
	public MainPanel(JFrame parent) {
		
		super();
		
		this.setBackground();
		
		this.parent = parent;

		this.playButton = new JButton("New Game");
		this.highScoreButton = new JButton("High Score");
		this.tutorialButton = new JButton("Tutorial");
	
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(60, 0, 0, 0);
		gbc.weighty = parent.getHeight();
		gbc.weighty = parent.getWidth();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipadx = 750;	//It is the number of pixels added to the standard width of the JButton
		gbc.ipady = 30;		//It is the number of pixels added to the standard height of the JButton
		gbc.anchor = GridBagConstraints.NORTH;
		this.add(this.playButton, gbc);
		
		gbc.insets = new Insets(0,0,0,0);
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(this.highScoreButton, gbc);
		
		gbc.insets = new Insets(0,0,60,0);
		gbc.anchor = GridBagConstraints.SOUTH;
		this.add(this.tutorialButton, gbc);
		
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
	
}
