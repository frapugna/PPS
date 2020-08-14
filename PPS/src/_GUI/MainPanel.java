package _GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * This is the main panel, it displays a menu where you can select various secondary panels
 */
public class MainPanel extends JPanel{
	/*
	 * parent: a reference to the parent frame
	 * playButton, highScoresButton, tutorialButton: the dynamic part of the panel
	 */
	JFrame parent;
	JButton playButton;
	JButton highScoreButton;
	JButton tutorialButton;
	/*
	 * Constructor which create the panel using a GridBagLayout
	 */
	public MainPanel(JFrame parent) {
		
		super();
		
		this.parent = parent;
		this.playButton = new JButton("New Game");
		this.highScoreButton = new JButton("High Score");
		this.tutorialButton = new JButton("Tutorial");
	
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(60, 0, 0, 0);
		gbc.weighty = parent.getHeight();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 600;
		gbc.fill = gbc.HORIZONTAL;
		gbc.anchor = GridBagConstraints.NORTH;
		this.add(this.playButton, gbc);
		
		gbc.insets = new Insets(0,0,0,0);
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(this.highScoreButton, gbc);
		
		gbc.insets = new Insets(0,0,60,0);
		gbc.anchor = GridBagConstraints.SOUTH;
		this.add(this.tutorialButton, gbc);
		
	}
	
}
