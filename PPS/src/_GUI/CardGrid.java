package _GUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import domainClasses.MainCharacterData;
import domainClasses.MainCharactersList;

public class CardGrid extends JPanel implements MouseListener, MouseMotionListener{

	private static final long serialVersionUID = 1L;

	CharacterCard[][] cardMatrix;
	MainCharacterCard mainCharacter;
	/*
	 * xMain: it is the position of the main character on the x axis
	 * yMain: it is the position of the main character on the y axis
	 */
	int xMain;
	int yMain;

	public CardGrid(MainCharacterCard mainCharacter) {
		super();
		this.setLayout(null);
		
		this.mainCharacter =mainCharacter;
		initCardMatrix();
	}

	private void initCardMatrix() {

		cardMatrix = new CharacterCard[3][3];

		for(int y = 0; y < 3; ++y) {
			for(int x = 0; x < 3; ++x) {
				if(x == 1 && y ==1) {
					initMainCharacterCard();
				}
				else {
					cardMatrix[y][x] = new CharacterCard(x, y);
					cardMatrix[y][x].setLocation(x * CharacterCard.WIDTH, y * CharacterCard.HEIGHT);
					cardMatrix[y][x].setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
					this.add(cardMatrix[y][x]);

					cardMatrix[y][x].addMouseListener(this);
					cardMatrix[y][x].addMouseMotionListener(this);
				}
			}
		}
		setClickableBorder();
	}
	
	/*
	 * This method initially show a option dialog asking the player to choose his class,
	 * then the Main Character is initialized as a normal card, but it is not stored into the cardMatrix(cardMatrix is a CardCharacter matrix
	 * but MainCharacterCard is a different class)
	 */
	private void initMainCharacterCard() {

		//Object[] options = {"Berserker","Warrior","Archer"};
		//int answer = JOptionPane.showOptionDialog(this, "Choose your class!", "Character selection",JOptionPane.YES_NO_CANCEL_OPTION , JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		//MainCharactersList list = new MainCharactersList();
		//MainCharacterData data = list.getChoiceMenu().get(answer);
		xMain = 1;
		yMain = 1;
		//mainCharacter = new MainCharacterCard(xMain, yMain, data);

		this.add(mainCharacter);
		mainCharacter.setLocation(xMain * MainCharacterCard.WIDTH, yMain * MainCharacterCard.HEIGHT);
		mainCharacter.setBorder(BorderFactory.createLineBorder(Color.RED, 5));	
		mainCharacter.addMouseMotionListener(this);
	}
	/*
	 * This methods change to another color clickable cards' borders 
	 */
	private void setClickableBorder() {
		for(int y = 0; y < 3; ++y) {
			for(int x = 0; x < 3; ++x) {
				if(isClickable(x,y))
					cardMatrix[y][x].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
			}
		}
	}

	/*
	 * This method resets the the borders of every Character card in game to the default color 
	 * we will use this method in the updateCardMatrixBorders() method to set the correct status of the matrix's border every time 
	 * it is necessary
	 */
	private void setStandardBorder() {
		for(int y = 0; y < 3; ++y) {
			for(int x = 0; x < 3; ++x) {
				if(x == xMain && y == yMain)
					continue;
				cardMatrix[y][x].setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
			}
		}
	}
	/*
	 * this method update the card matrix border and card colors to the current status of the matrix
	 */
	private void updateCardMatrixBorders() {
		setStandardBorder();
		setClickableBorder();
	}
	/*
	 * this method returns true if a position is clickable, else false
	 */
	private boolean isClickable(int x, int y) {
		if(isLeft(x,y) || isRight(x,y) || isUp(x,y) || isDown(x,y))
			return true;
		else
			return false;
	}
	/*
	 * Those methods return true if a card to the right, left, is upper or is down the main character card
	 * else false
	 */
	private boolean isLeft(int x, int y) {
		if((xMain - 1) >= 0 && x == (xMain - 1) && y == yMain)
			return true;
		else return false;
	}
	private boolean isRight(int x, int y) {
		if((xMain + 1) <= 2 && x == (xMain + 1) && y == yMain)
			return true;
		else 
			return false;
	}
	private boolean isUp(int x, int y) {
		if((yMain - 1) >= 0 && y == (yMain - 1) && x == xMain)
			return true;
		else 
			return false;
	}
	private boolean isDown(int x, int y) {
		if((yMain + 1) < 3 && y == (yMain + 1) && x == xMain)
			return true;
		else
			return false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

		for(int y = 0; y < 3; ++y) {
			for(int x = 0; x < 3; ++x) {
				if(x == xMain && y == yMain)
					continue;
				if(e.getSource() == cardMatrix[y][x]) 
					if(isClickable(x, y))
						cardMatrix[y][x].setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		updateCardMatrixBorders();

	}

	@Override
	public void mouseEntered(MouseEvent e) {

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
		System.out.println("MouseMoved");
		updateCardMatrixBorders();

		for(int y = 0; y < 3; ++y) {
			for(int x = 0; x < 3; ++x) {
				if(x == xMain && y == yMain)
					continue;
				if(e.getSource() == cardMatrix[y][x]) 
					if(isClickable(x, y))
						cardMatrix[y][x].setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
			}
		}

	}


}
