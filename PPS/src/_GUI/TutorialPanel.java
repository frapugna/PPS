package _GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * JComponent in which are 2 JButtons to hover over 
 * a series of images displaying how to play the game
 * Also there is a returnToMenu Button
 */
public class TutorialPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	MainFrame parent;
	
	JButton returnToMenu;
	final Rectangle MENU_RECT = new Rectangle(600, 640, 100, 45);
	
	JButton nextSlide; 
	final Rectangle NEXT_RECT = new Rectangle(1150, 640, 100, 45);
	
	JButton previousSlide;
	final Rectangle PREVIOUS_RECT = new Rectangle(20, 640, 100, 45);
	
	JButton pause;
	final Rectangle PAUSE_RECT = new Rectangle(1250,5,20,20);
	
	ImageIcon[] tutorialSlideShow;
	int slideTotalNumber = 5;
	
	JLabel currentSlide;
	final Rectangle SLIDE_RECT = new Rectangle(0, 0, 1280, 640);
	
	int currentSlideIndex;
	
	Image img;
	String BACKGROUND_PATH = "resources/Tutorial/tutorialBackground.png";
	
	/*
	 * Handles slideShow
	 */
	public TutorialPanel(MainFrame parent){
		
		super();
		this.parent = parent;
		this.setLayout(null);
		this.setBackground();
		
		if(parent.isMusicPlaying)
			this.pause = new JButton(null,new ImageIcon(parent.PAUSE_MUSIC_PATH));
		else
			this.pause = new JButton(null,new ImageIcon(parent.PLAY_MUSIC_PATH));
		this.add(pause);
		this.pause.setBounds(PAUSE_RECT);
		
		this.tutorialSlideShow = new ImageIcon[slideTotalNumber];
		this.initSlideShow();
		
		this.returnToMenu = new JButton("Menu");
		this.returnToMenu.setBounds(MENU_RECT);
		this.add(returnToMenu);
		
		
		currentSlideIndex = 0;
		this.currentSlide = new JLabel(tutorialSlideShow[currentSlideIndex]);
		this.currentSlide.setBounds(SLIDE_RECT);
		this.add(currentSlide);
		
		
		this.previousSlide = new JButton("<");
		this.previousSlide.setBounds(PREVIOUS_RECT);
		this.add(previousSlide);
		

		this.nextSlide = new JButton(">");
		this.nextSlide.setBounds(NEXT_RECT);
		this.add(nextSlide);
		
		nextSlide.addActionListener(this);
		previousSlide.addActionListener(this);
		
	} 
	
	/*
	 *Method to pull all needed resources from folder 
	 */
	public void initSlideShow() {
			
			tutorialSlideShow[0] = new ImageIcon("resources/Tutorial/Diapositiva1.PNG");
			tutorialSlideShow[1] = new ImageIcon("resources/Tutorial/Diapositiva2.PNG");
			tutorialSlideShow[2] = new ImageIcon("resources/Tutorial/Diapositiva3.PNG");
			tutorialSlideShow[3] = new ImageIcon("resources/Tutorial/Diapositiva4.PNG");
			tutorialSlideShow[4] = new ImageIcon("resources/Tutorial/Diapositiva5.PNG");
		
	}

	/*
	 * ActionListeners for the flow buttons
	 * Works by selecting the current image on tutorialSlideShow
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.nextSlide) {
			
			++currentSlideIndex;
			
			if(currentSlideIndex != tutorialSlideShow.length) {
				this.currentSlide.setIcon(tutorialSlideShow[currentSlideIndex]);
				this.currentSlide.setVisible(true);
				this.repaint();
				}
			else 
				returnToMenu.doClick();
			
		}
		
		if(e.getSource() == this.previousSlide) {
			
			--currentSlideIndex;
			
			if(currentSlideIndex != -1) {
				this.currentSlide.setIcon(tutorialSlideShow[currentSlideIndex]);
				this.currentSlide.setVisible(true);
				this.repaint();
				}
			else 
				returnToMenu.doClick();
		}
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
	
}