package _GUI;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	MainFrame parent;
	JButton returnToMenu;
	CardGrid cardGrid;
	JLabel scoreLabel;

	final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	final int SCREEN_HEIGTH = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	final Rectangle MENU_RECT = new Rectangle(490, 500, 200, 100);
	final Rectangle CARD_GRID_RECT = new Rectangle(10, 10, 450, 600);
	final Rectangle SCORE_RECT = new Rectangle(490, 10,200,100);
	
	public GamePanel(MainFrame parent, MainCharacterCard mainCharacter) {
		
		super();
		this.parent = parent;
		
		this.setLayout(null);
		
		returnToMenu = new JButton("Menu");
		returnToMenu.setBounds(MENU_RECT);
		add(returnToMenu);
		returnToMenu.addActionListener(this);
		
		scoreLabel = new JLabel("Score: "+0);
		add(scoreLabel);
		scoreLabel.setBounds(SCORE_RECT);
		
		cardGrid = new CardGrid(this, mainCharacter);

		cardGrid.setBounds(CARD_GRID_RECT);
		cardGrid.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
		add(cardGrid);
		
	}
	
	public JLabel getScoreLabel() {
		return scoreLabel;
	}

	public void setScoreLabel(JLabel scoreLabel) {
		this.scoreLabel = scoreLabel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == returnToMenu) {
			
			int choice = JOptionPane.showConfirmDialog(null, "Go back to main menu?", "Are you sure?", JOptionPane.YES_NO_OPTION);
			
			if(choice == JOptionPane.YES_OPTION) {
				parent.initMainPanel();
			}
		}
	} 	
}
