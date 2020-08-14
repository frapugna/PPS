package _GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
