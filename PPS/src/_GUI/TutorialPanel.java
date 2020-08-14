package _GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * JComponent in which are 2 JButtons to hover over 
 * a series of images displaying how to play the game
 * Also there is a returnToMenu Button
 */
public class TutorialPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JFrame parent;
	JButton returnToMenu;

	public TutorialPanel(JFrame parent) {
		
		super();
		this.parent = parent;
		
		this.returnToMenu = new JButton("Menu");
		this.add(returnToMenu);
		
	} 
	
}
