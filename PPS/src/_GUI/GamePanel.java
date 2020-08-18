package _GUI;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JFrame parent;
	JButton returnToMenu;
	CardGrid cardGrid;
	
	final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	final int SCREEN_HEIGTH = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	final Rectangle MENU_RECT = new Rectangle(490, 500, 200, 100);
	final Rectangle CARD_GRID_RECT = new Rectangle(10, 10, 450, 600);
	
	public GamePanel(JFrame parent) {
		
		super();
		this.parent = parent;
		
		this.setLayout(null);
		
		returnToMenu = new JButton("Menu");
		returnToMenu.setBounds(MENU_RECT);
		add(returnToMenu);
		
		cardGrid = new CardGrid();
		cardGrid.setBounds(CARD_GRID_RECT);
		cardGrid.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
		add(cardGrid);
		
	} 
	
}
