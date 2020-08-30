package _GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import DataAccess.HighScoreSaver;
import domainClasses.MinionData;
import domainClasses.PotionData;
import domainClasses.RepairPotionData;
import domainClasses.TrapData;
import domainClasses.WeaponData;

public class CardGrid extends JPanel implements MouseListener, MouseMotionListener, KeyListener{

	private static final long serialVersionUID = 1L;
	final int SPEED = 2;
	
	GamePanel parent;

	CharacterCard[][] cardMatrix;
	MainCharacterCard mainCharacter;
	/*
	 * If true you keep playing
	 */
	boolean isAlive;
	/*
	 * those attribute are used to synchronize the timers used during the cards' animation 
	 */
	boolean isMoveFinished;
	boolean keepMoving;
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

	Image img;
	final String BACKGROUND_PATH = "resources/cardIcons/CDBgroungNew.jpg";
	
	public CardGrid(GamePanel parent, MainCharacterCard mainCharacter) {

		super();
	
		this.parent = parent;
		this.setBackground();
		this.setLayout(null);
		
		isMoveFinished = true;
		score = 0;
		
		this.mainCharacter = mainCharacter;
		
		initCardMatrix();
	
		parent.parent.setFocusable(true);
		parent.parent.addKeyListener(this);
		parent.parent.requestFocusInWindow();
		
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
	  
	private void initCardMatrix() {

		cardMatrix = new CharacterCard[3][3];
		initMainCharacterCard();
		for(int y = 0; y < 3; ++y) {
			for(int x = 0; x < 3; ++x) {
				if(x == 1 && y ==1) {
					continue;
				}
				cardMatrix[y][x] = new CharacterCard(x, y);
				cardMatrix[y][x].setLocation(x * CharacterCard.WIDTH, y * CharacterCard.HEIGHT);
				cardMatrix[y][x].setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
				this.add(cardMatrix[y][x]);
		
				cardMatrix[y][x].addMouseListener(this);
				cardMatrix[y][x].addMouseMotionListener(this);

			}
		}
		this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocus();
		requestFocusInWindow();
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
		if(!isMoveFinished)
			return false;
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
								if(tmpHp <= 0)
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

										cardMatrix[y][x].setLeftValue(0);
										cardMatrix[y][x].getStatus().setText(":"+0);
									}

						}
		return out;
	}
	private void addCard(int x, int y) {
		cardMatrix[y][x] = new CharacterCard(y, x);
		this.add(cardMatrix[y][x]);
		cardMatrix[y][x].setLocation(x * CharacterCard.WIDTH, y * CharacterCard.HEIGHT);
		cardMatrix[y][x].addMouseListener(this);
		cardMatrix[y][x].addMouseMotionListener(this);
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
	//------------------------STARTS MOVE DOWN BLOCK------------------------------------------
	private void moveMainCharacterDownSmoothly(int yEnd, int xStart, int yStart) {

		new Timer(6, new ActionListener() {

			int yPixel = yStart * MainCharacterCard.HEIGHT;

			int xPixel = xStart * MainCharacterCard.WIDTH;
			public void actionPerformed(ActionEvent e) {

				mainCharacter.setLocation(xPixel,yPixel );
				//System.out.println("MovingMainCharacter");
				if(yPixel == yEnd * MainCharacterCard.HEIGHT) {
					if(yStart == 0) {
						isMoveFinished = true;
						addCard(xStart,yStart);
						updateCardMatrixBorders();
					}
					else
						keepMoving = true;
					remove(cardMatrix[yEnd][xStart]);
					((Timer)e.getSource()).stop();
				}
				else
					yPixel += SPEED;
			}
		}).start();	
	}
	private void moveDownCharacterCardSmoothly(int x, int yOld, int yNew, CharacterCard card) {
		new Timer(6, new ActionListener() {
			int yPixel = yOld * CharacterCard.HEIGHT;

			int xPixel = x * CharacterCard.WIDTH;
			public void actionPerformed(ActionEvent e) {
				if(keepMoving == true) {
					card.setLocation(xPixel,yPixel );
					//System.out.println("MovingCharacter");
					if(yPixel == yNew * CharacterCard.HEIGHT) {
						isMoveFinished = true;
						addCard(x,yOld);
						updateCardMatrixBorders();
						((Timer)e.getSource()).stop();
					}
					else
						yPixel += SPEED;
				}
			}
		}).start();	
	}

	private void moveDown(int x, int y) {

		setStandardBorder();

		isMoveFinished = false;
		keepMoving = false;

		moveMainCharacterDownSmoothly(y,xMain,yMain);

		xMain = x;
		yMain = y;

		--y;
		while((y - 1) >= 0) {
			moveDownCharacterCardSmoothly(x, y-1, y, cardMatrix[y-1][x]);
			cardMatrix[y][x] = cardMatrix[y-1][x];
			cardMatrix[y][x].setxCoor(x);
			cardMatrix[y][x].setyCoor(y);
			--y;
		}
	}
	//------------------------------ENDS MOVE DOWN BLOCK--------------------------------------------------
	//------------------------------STARTS MOVE UP BLOCK--------------------------------------------------
	private void moveMainCharacterUpSmoothly(int yEnd, int xStart, int yStart) {

		new Timer(6, new ActionListener() {
			int yPixel = yStart * MainCharacterCard.HEIGHT;

			int xPixel = xStart * MainCharacterCard.WIDTH;
			public void actionPerformed(ActionEvent e) {

				mainCharacter.setBounds(xPixel, yPixel, MainCharacterCard.WIDTH, MainCharacterCard.HEIGHT);
				//mainCharacter.setLocation(xPixel,yPixel );

				//System.out.println("MovingMainCharacter");
				if(yPixel == yEnd * MainCharacterCard.HEIGHT) {
					if(yStart == 2) {
						isMoveFinished = true;
						addCard(xStart,yStart);
						updateCardMatrixBorders();
					}
					else
						keepMoving = true;
					remove(cardMatrix[yEnd][xStart]);
					((Timer)e.getSource()).stop();
				}
				else
					yPixel -= SPEED;
			}
		}).start();	
	}
	private void moveUpCharacterCardSmoothly(int xOld, int yOld, int yNew, CharacterCard card) {
		new Timer(6, new ActionListener() {
			int yPixel = yOld * CharacterCard.HEIGHT;

			int xPixel = xOld * CharacterCard.WIDTH;
			public void actionPerformed(ActionEvent e) {
				if(keepMoving == true) {
					card.setLocation(xPixel,yPixel );
					//System.out.println("MovingCharacter");
					if(yPixel == yNew * CharacterCard.HEIGHT) {
						isMoveFinished = true;
						addCard(xOld,yOld);
						updateCardMatrixBorders();
						((Timer)e.getSource()).stop();
					}
					else
						yPixel -= SPEED;
				}
			}
		}).start();	
	}
	private void moveUp(int x, int y) {
		setStandardBorder();


		isMoveFinished = false;
		keepMoving = false;

		moveMainCharacterUpSmoothly(y,xMain,yMain);

		xMain = x;
		yMain = y;

		++y;
		while((y + 1) <= 2) {
			moveUpCharacterCardSmoothly(x, y+1, y, cardMatrix[y+1][x]);
			cardMatrix[y][x] = cardMatrix[y+1][x];
			cardMatrix[y][x].setxCoor(x);
			cardMatrix[y][x].setyCoor(y);
			++y;
		}
	}
	//------------------------ENDS MOVE UP BLOCK-----------------------------------------
	//------------------------STARTS MOVE LEFT BLOCK-------------------------------------
	private void moveMainCharacterLeftSmoothly(int xEnd, int xStart, int yStart) {

		new Timer(6, new ActionListener() {
			int yPixel = yStart * MainCharacterCard.HEIGHT;

			int xPixel = xStart * MainCharacterCard.WIDTH;
			public void actionPerformed(ActionEvent e) {

				mainCharacter.setLocation(xPixel,yPixel );
				//System.out.println("MovingMainCharacter");
				if(xPixel == xEnd * MainCharacterCard.WIDTH) {
					if(xStart == 2) {
						isMoveFinished = true;
						addCard(xStart,yStart);
						updateCardMatrixBorders();
					}
					else
						keepMoving = true;
					remove(cardMatrix[yStart][xEnd]);
					((Timer)e.getSource()).stop();
				}
				else
					xPixel -= SPEED;
			}
		}).start();	
	}
	private void moveLeftCharacterCardSmoothly(int xOld, int yOld, int xNew, CharacterCard card) {
		new Timer(6, new ActionListener() {
			int yPixel = yOld * CharacterCard.HEIGHT;

			int xPixel = xOld * CharacterCard.WIDTH;
			public void actionPerformed(ActionEvent e) {
				if(keepMoving == true) {
					card.setLocation(xPixel,yPixel );
					//System.out.println("MovingCharacter");
					if(xPixel == xNew * CharacterCard.WIDTH) {
						isMoveFinished = true;
						addCard(xOld,yOld);
						updateCardMatrixBorders();
						((Timer)e.getSource()).stop();
					}
					else
						xPixel -= SPEED;
				}
			}
		}).start();	
	}
	private void moveLeft(int x, int y) {
		setStandardBorder();

		isMoveFinished = false;
		keepMoving = false;

		moveMainCharacterLeftSmoothly(x,xMain,yMain);

		xMain = x;
		yMain = y;

		++x;
		while((x + 1) <= 2) {
			moveLeftCharacterCardSmoothly(x+1, y, x, cardMatrix[y][x+1]);
			cardMatrix[y][x] = cardMatrix[y][x+1];
			cardMatrix[y][x].setxCoor(x);
			cardMatrix[y][x].setyCoor(y);
			++x;
		}
	}
	//----------------------ENDS MOVE LEFT BLOCK---------------------------------------------
	//----------------------STARTS MOVE RIGHT BLOCK------------------------------------------

	private void moveMainCharacterRightSmoothly(int xEnd, int xStart, int yStart) {

		new Timer(6, new ActionListener() {
			int yPixel = yStart * MainCharacterCard.HEIGHT;

			int xPixel = xStart * MainCharacterCard.WIDTH;
			public void actionPerformed(ActionEvent e) {

				mainCharacter.setLocation(xPixel,yPixel );
				//System.out.println("MovingMainCharacter");
				if(xPixel == xEnd * MainCharacterCard.WIDTH) {
					if(xStart == 0) {
						isMoveFinished = true;
						addCard(xStart,yStart);
						updateCardMatrixBorders();
					}
					else
						keepMoving = true;
					remove(cardMatrix[yStart][xEnd]);
					((Timer)e.getSource()).stop();
				}
				else
					xPixel += SPEED;
			}
		}).start();	
	}
	private void moveRightCharacterCardSmoothly(int xOld, int yOld, int xNew, CharacterCard card) {
		new Timer(6, new ActionListener() {
			int yPixel = yOld * CharacterCard.HEIGHT;

			int xPixel = xOld * CharacterCard.WIDTH;
			public void actionPerformed(ActionEvent e) {
				if(keepMoving == true) {
					card.setLocation(xPixel,yPixel );
					//System.out.println("MovingCharacter");
					if(xPixel == xNew * CharacterCard.WIDTH) {
						isMoveFinished = true;
						addCard(xOld,yOld);
						updateCardMatrixBorders();
						((Timer)e.getSource()).stop();
					}
					else
						xPixel += SPEED;
				}
			}
		}).start();	
	}

	private void moveRight(int x, int y) {
		setStandardBorder();

		isMoveFinished = false;
		keepMoving = false;

		moveMainCharacterRightSmoothly(x,xMain,yMain);

		xMain = x;
		yMain = y;

		--x;
		while((x - 1) >= 0) {
			moveRightCharacterCardSmoothly(x-1, y, x, cardMatrix[y][x-1]);
			cardMatrix[y][x] = cardMatrix[y][x-1];
			cardMatrix[y][x].setxCoor(x);
			cardMatrix[y][x].setyCoor(y);
			--x;
		}
	}
	//---------------------------ENDS MOVE RIGHT BLOCK----------------------------------------------
	/*
	 * this method is called after every interaction, it stops the game if your hp are <= 0
	 */
	private void gameOver() {
		if(isAlive == false) {
			parent.parent.removeKeyListener(this);
			JOptionPane.showMessageDialog(this, "GAME OVER");
			new HighScoreSaver(score);
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

	@Override
	public void keyTyped(KeyEvent e) {
		return;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int x = 0;
		int y = 0;
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			y = yMain;
			x = xMain + 1;
		}
		else
			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				y = yMain;
				x = xMain - 1;
			}
			else if(e.getKeyCode()==KeyEvent.VK_UP) {
				y = yMain - 1;
				x = xMain;
			}
			else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				y = yMain + 1;
				x = xMain;
			}
		if(isClickable(x, y))
			cardMatrix[y][x].setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));

	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("KeyReleased");
		int x = 0;
		int y = 0;
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			y = yMain;
			x = xMain + 1;
		}
		else
			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				y = yMain;
				x = xMain - 1;
			}
			else if(e.getKeyCode()==KeyEvent.VK_UP) {
				y = yMain - 1;
				x = xMain;
			}
			else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				y = yMain + 1;
				x = xMain;
			}
		
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