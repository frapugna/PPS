package _GUI;

import java.awt.Rectangle;
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
	
	JFrame parent;
	
	JButton returnToMenu;
	final Rectangle MENU_RECT = new Rectangle(870, 20, 80, 50);
	
	JButton nextSlide; 
	final Rectangle NEXT_RECT = new Rectangle(870, 350, 80, 50);
	
	JButton previousSlide;
	final Rectangle PREVIOUS_RECT = new Rectangle(30, 350, 80, 50);
	
	ImageIcon[] tutorialSlideShow;
	int slideTotalNumber;
	
	JLabel currentSlide;
	final Rectangle SLIDE_RECT = new Rectangle(150, 50, 650, 350);
	
	int currentSlideIndex;
	
	/*
	 * This panel works by using a grid 3x3 and it adds empty
	 * JPanels where it needs an empty space(UGLY)
	 * NEEDS restyle of buttons (with GridBagLayout ;))and resizing of pictures
	 * After that should be complete
	 */
	public TutorialPanel(JFrame parent){
		
		super();
		this.parent = parent;
		this.setLayout(null);
		
		slideTotalNumber = 2;
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
			
			tutorialSlideShow[0] = new ImageIcon("resources/firstSlide.png");
			tutorialSlideShow[1] = new ImageIcon("resources/secondSlide.png");
		
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
	
}
