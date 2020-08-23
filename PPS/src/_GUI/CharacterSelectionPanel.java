package _GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domainClasses.MainCharactersList;

public class CharacterSelectionPanel extends JPanel implements MouseListener, MouseMotionListener{

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
	
	Image img;
	String BACKGROUND_PATH = "resources/cardIcons/characterSelectionBackGround.jpg";
	
	public CharacterSelectionPanel(MainFrame parent) {
		super();
		this.parent = parent;
		this.setLayout(null);
		setBackground();
		
		charactersList = new MainCharactersList();
		
		berzerker = new MainCharacterCard(1, 1, charactersList.choiceMenu.get(0));
		this.add(berzerker);
		berzerker.setLocation(10, 30);
		berzerker.addMouseListener(this);
		berzerker.addMouseMotionListener(this);
		
		warrior = new MainCharacterCard(1, 1, charactersList.choiceMenu.get(1));
		this.add(warrior);
		warrior.setLocation(180, 30);
		warrior.addMouseListener(this);
		warrior.addMouseMotionListener(this);
		
		archer = new MainCharacterCard(1, 1, charactersList.choiceMenu.get(2));
		this.add(archer);
		archer.setLocation(350, 30);
		archer.addMouseListener(this);
		archer.addMouseMotionListener(this);
		
		selectionLabel = new JLabel("Select your character");
		this.add(selectionLabel);
		selectionLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		selectionLabel.setBounds(180, 5, 200, 30);
		selectionLabel.setForeground(Color.white);
		
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
	  
	@Override
	public void mouseClicked(MouseEvent e) {
		return;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == berzerker) {
			berzerker.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
		}
		if(e.getSource() == warrior) {
			warrior.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
		}
		if(e.getSource() == archer) {
			archer.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
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
		return;
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		return;
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		return;
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		updateCharacterBorders();
		
		if(e.getSource() == berzerker)
			berzerker.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
		if(e.getSource() == warrior)
			warrior.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
		if(e.getSource() == archer)
			archer.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
		
	}

	private void updateCharacterBorders() {
		berzerker.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		warrior.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		archer.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
	}
}
