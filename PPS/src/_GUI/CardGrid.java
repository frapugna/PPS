package _GUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import domainClasses.MinionData;
import domainClasses.PotionData;
import domainClasses.RepairPotionData;
import domainClasses.TrapData;
import domainClasses.WeaponData;

public class CardGrid extends JPanel implements MouseListener, MouseMotionListener{

	private static final long serialVersionUID = 1L;

	GamePanel parent;
	
	CharacterCard[][] cardMatrix;
	MainCharacterCard mainCharacter;
	/*
	 * If true you keep playing
	 */
	boolean isAlive;
	/*
	 * xMain: it is the position of the main character on the x axis
	 * yMain: it is the position of the main character on the y axis
	 */
	int xMain;
	int yMain;
	/*
	 * it represents the actual score
	 */
	int score;

	public CardGrid(GamePanel parent, MainCharacterCard mainCharacter) {

		super();
		this.parent = parent;
		this.setLayout(null);
		
		score = 0;
		
		this.mainCharacter = mainCharacter;
		
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

	
		xMain = 1;
		yMain = 1;

		isAlive = true;

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

	/*
	 * This method implements all the interactions between cards of different types
	 * @return: it is a boolean which will be used to decide if the moveCard method has to be called
	 */
	private boolean moveSet(int x, int y) {
		boolean out = true;
		if(cardMatrix[y][x].getCardType() instanceof WeaponData) {
			mainCharacter.setWeaponDurability(cardMatrix[y][x].getLeftValue());
			mainCharacter.getDurabilityLabel().setText(":"+mainCharacter.getWeaponDurability());
		}
		else
			if(cardMatrix[y][x].getCardType() instanceof PotionData) {
				int tmpHp = mainCharacter.getHp();
				tmpHp += cardMatrix[y][x].getLeftValue();

				if(tmpHp > MainCharacterCard.MAX_HP)
					tmpHp = MainCharacterCard.MAX_HP;

				mainCharacter.setHp(tmpHp);
				mainCharacter.getHpLabel().setText(":"+mainCharacter.getHp());
			}
			else
				if(cardMatrix[y][x].getCardType() instanceof RepairPotionData) {

					int tmpDurability = mainCharacter.getWeaponDurability();
					if(tmpDurability > 0) {
						tmpDurability += cardMatrix[y][x].getLeftValue();

						mainCharacter.setWeaponDurability(tmpDurability);
						mainCharacter.getDurabilityLabel().setText(":"+tmpDurability);
					}
				}
				else
					if(cardMatrix[y][x].getCardType() instanceof TrapData) {
						int tmpHp = mainCharacter.getHp();
						int damage =  cardMatrix[y][x].getLeftValue();
						tmpHp -= damage;

						if(tmpHp <= 0) {
							isAlive = false;
						}

						mainCharacter.setHp(tmpHp);
						mainCharacter.getHpLabel().setText(":"+mainCharacter.getHp());
					}
					else
						if(cardMatrix[y][x].getCardType() instanceof MinionData) {
							int tmpDurability = mainCharacter.getWeaponDurability();
							int tmpMinionHp = cardMatrix[y][x].getLeftValue();
							int tmpHp = mainCharacter.getHp();

							if(tmpDurability == 0) {
								tmpHp -= tmpMinionHp;
								if(tmpHp < 0)
									isAlive = false;
								mainCharacter.setHp(tmpHp);
								mainCharacter.getHpLabel().setText(":"+mainCharacter.getHp());

								cardMatrix[y][x].setLeftValue(0);
								cardMatrix[y][x].getStatus().setText(":"+0);
							}
							else
								if(tmpMinionHp > tmpDurability) {
									out = false;
									tmpMinionHp -= tmpDurability;

									cardMatrix[y][x].setLeftValue(tmpMinionHp);
									cardMatrix[y][x].getStatus().setText(":"+tmpMinionHp);

									mainCharacter.setWeaponDurability(0);
									mainCharacter.getDurabilityLabel().setText(":"+mainCharacter.getWeaponDurability());
								}
								else
									if(tmpDurability >= tmpMinionHp) {
										tmpDurability -= tmpMinionHp;
										mainCharacter.setWeaponDurability(tmpDurability);
										mainCharacter.getDurabilityLabel().setText(":"+mainCharacter.getWeaponDurability());
									}

						}
		return out;
	}
	/*
	 * This method moves the main character and the other cards
	 */
	private void moveCard(int x, int y) {
		if(isLeft(x,y))
			moveLeft(x,y);
		else
			if(isRight(x,y))
				moveRight(x,y);
			else
				if(isUp(x, y))
					moveUp(x,y);
				else
					if(isDown(x,y))
						moveDown(x,y);
	}
	private void moveDown(int x, int y) {
		this.remove(cardMatrix[y][x]);
		xMain = x;
		yMain = y;
		mainCharacter.setLocation(xMain * MainCharacterCard.WIDTH, yMain * MainCharacterCard.HEIGHT);
		--y;
		while((y - 1) >= 0) {
			cardMatrix[y][x] = cardMatrix[y-1][x];
			cardMatrix[y][x].setLocation(x * CharacterCard.WIDTH, y * CharacterCard.HEIGHT);
			cardMatrix[y][x].setxCoor(x);
			cardMatrix[y][x].setyCoor(y);
			--y;
		}
		cardMatrix[y][x] = new CharacterCard(y, x);
		this.add(cardMatrix[y][x]);
		cardMatrix[y][x].setLocation(x * CharacterCard.WIDTH, y * CharacterCard.HEIGHT);
		cardMatrix[y][x].addMouseListener(this);
		cardMatrix[y][x].addMouseMotionListener(this);
		
		updateCardMatrixBorders();
	}
	private void moveUp(int x, int y) {
		this.remove(cardMatrix[y][x]);
		xMain = x;
		yMain = y;
		mainCharacter.setLocation(xMain * MainCharacterCard.WIDTH, yMain * MainCharacterCard.HEIGHT);
		++y;
		while((y + 1) <= 2) {
			cardMatrix[y][x] = cardMatrix[y+1][x];
			cardMatrix[y][x].setLocation(x * CharacterCard.WIDTH, y * CharacterCard.HEIGHT);
			cardMatrix[y][x].setxCoor(x);
			cardMatrix[y][x].setyCoor(y);
			++y;
		}
		cardMatrix[y][x] = new CharacterCard(y, x);
		this.add(cardMatrix[y][x]);
		cardMatrix[y][x].setLocation(x * CharacterCard.WIDTH, y * CharacterCard.HEIGHT);
		cardMatrix[y][x].addMouseListener(this);
		cardMatrix[y][x].addMouseMotionListener(this);
		
		updateCardMatrixBorders();
	}
	private void moveLeft(int x, int y) {
		this.remove(cardMatrix[y][x]);
		xMain = x;
		yMain = y;
		mainCharacter.setLocation(xMain * MainCharacterCard.WIDTH, yMain * MainCharacterCard.HEIGHT);
		++x;
		while((x + 1) <= 2) {
			cardMatrix[y][x] = cardMatrix[y][x+1];
			cardMatrix[y][x].setLocation(x * CharacterCard.WIDTH, y * CharacterCard.HEIGHT);
			cardMatrix[y][x].setxCoor(x);
			cardMatrix[y][x].setyCoor(y);
			++x;
		}
		cardMatrix[y][x] = new CharacterCard(y, x);
		this.add(cardMatrix[y][x]);
		cardMatrix[y][x].setLocation(x * CharacterCard.WIDTH, y * CharacterCard.HEIGHT);
		cardMatrix[y][x].addMouseListener(this);
		cardMatrix[y][x].addMouseMotionListener(this);
		
		updateCardMatrixBorders();
	}
	
	private void moveRight(int x, int y) {
		this.remove(cardMatrix[y][x]);
		xMain = x;
		yMain = y;
		mainCharacter.setLocation(xMain * MainCharacterCard.WIDTH, yMain * MainCharacterCard.HEIGHT);
		--x;
		while((x - 1) >= 0) {
			cardMatrix[y][x] = cardMatrix[y][x-1];
			cardMatrix[y][x].setLocation(x * CharacterCard.WIDTH, y * CharacterCard.HEIGHT);
			cardMatrix[y][x].setxCoor(x);
			cardMatrix[y][x].setyCoor(y);
			--x;
		}
		cardMatrix[y][x] = new CharacterCard(y, x);
		this.add(cardMatrix[y][x]);
		cardMatrix[y][x].setLocation(x * CharacterCard.WIDTH, y * CharacterCard.HEIGHT);
		cardMatrix[y][x].addMouseListener(this);
		cardMatrix[y][x].addMouseMotionListener(this);
		
		updateCardMatrixBorders();
		
	}
	
	/*
	 * this method is called after every interaction, it stops the game if your hp are <= 0
	 */
	private void gameOver() {
		if(isAlive == false) {
			JOptionPane.showMessageDialog(this, "GAME OVER");
			parent.parent.initMainPanel();
		}
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
		for(int y = 0; y < 3; ++y) {
			for(int x = 0; x < 3; ++x) {
				if(x == xMain && y == yMain)
					continue;
				if(e.getSource() == cardMatrix[y][x]) 
					if(isClickable(x, y)) {
						boolean isMoveEnabled = moveSet(x,y);
						gameOver();
						if(isMoveEnabled) {
							++score;
							parent.getScoreLabel().setText("Score: "+score);
							moveCard(x,y);
						}
					}

			}
		}
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
