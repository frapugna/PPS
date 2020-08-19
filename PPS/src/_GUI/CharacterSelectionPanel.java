package _GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domainClasses.MainCharactersList;

public class CharacterSelectionPanel extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	MainFrame parent;
	MainCharactersList charactersList;
	
	JLabel selectionLabel;
	MainCharacterCard berzerker;
	MainCharacterCard warrior;
	MainCharacterCard archer;
	
	
	public CharacterSelectionPanel(MainFrame parent) {
		super();
		this.parent = parent;
		this.setLayout(null);
		
		charactersList = new MainCharactersList();
		
		berzerker = new MainCharacterCard(1, 1, charactersList.choiceMenu.get(0));
		this.add(berzerker);
		berzerker.setLocation(10, 30);
		berzerker.addMouseListener(this);
		
		warrior = new MainCharacterCard(1, 1, charactersList.choiceMenu.get(1));
		this.add(warrior);
		warrior.setLocation(180, 30);
		warrior.addMouseListener(this);
		
		archer = new MainCharacterCard(1, 1, charactersList.choiceMenu.get(2));
		this.add(archer);
		archer.setLocation(350, 30);
		archer.addMouseListener(this);
		
		selectionLabel = new JLabel("Select your character");
		this.add(selectionLabel);
		selectionLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		selectionLabel.setBounds(180, 5, 200, 30);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == berzerker) {
			parent.changePaneTo(new GamePanel(parent, berzerker));
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == berzerker) {
			parent.changePaneTo(new GamePanel(parent, berzerker));
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource() == berzerker) {
			parent.changePaneTo(new GamePanel(parent, new MainCharacterCard(1, 1, charactersList.choiceMenu.get(0))));
		}
		if(e.getSource() == warrior) {
			parent.changePaneTo(new GamePanel(parent, new MainCharacterCard(1, 1, charactersList.choiceMenu.get(1))));
		}
		if(e.getSource() == archer) {
			parent.changePaneTo(new GamePanel(parent, new MainCharacterCard(1, 1, charactersList.choiceMenu.get(2))));
		}
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
