package _GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
	
	JFrame parent;
	JButton playButton;
	JButton highScoreButton;
	JButton tutorialButton;
	Insets insets;
	
	public MainPanel(JFrame parent) {
		
		super();
		
		this.parent = parent;
		
		this.setLayout(null);
		
		this.playButton = new JButton("New Game");
		this.setBounds(20, 20, 20, 10);
		this.add(this.playButton);
		
		this.highScoreButton = new JButton("High Score");
		this.highScoreButton.setLocation(parent.getWidth() / 2, parent.getHeight() / 2);
		this.add(this.highScoreButton);
		
		this.tutorialButton = new JButton("Tutorial");
		this.playButton.setLocation(parent.getWidth() / 2, parent.getHeight() - 30);
		this.add(this.tutorialButton);
		
		
		
	}
	
}
