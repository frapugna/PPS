package _GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
	
	JFrame parent;
	JButton playButton;
	JButton highScoreButton;
	JButton tutorialButton;
	
	public MainPanel(JFrame parent) {
		
		super();
		
		this.parent = parent;
		this.playButton = new JButton("New Game");
		this.highScoreButton = new JButton("High Score");
		this.tutorialButton = new JButton("Tutorial");
		
		this.add(this.playButton);
		this.add(this.highScoreButton);
		this.add(this.tutorialButton);
		
	}
	
}
