package _GUI;

import java.awt.GridLayout;
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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JFrame parent;
	
	JButton returnToMenu;
	JButton nextSlide;
	JButton previousSlide;
	
	ImageIcon[] tutorialSlideShow;
	int slideTotalNumber;
	
	JLabel currentSlide;
	int currentSlideIndex;
	
	/*
	 * This panel works by using a grid 3x3 and it adds empty
	 * JPanels where it needs an empty space(UGLY)
	 * NEEDS restyle of buttons (with GridBagLayout ;))and resizing of pictures
	 * After that should be complete
	 */
	public TutorialPanel(JFrame parent){
		
		super(new GridLayout(3, 3));
		this.parent = parent;
		
		slideTotalNumber = 2;
		this.tutorialSlideShow = new ImageIcon[slideTotalNumber];
		this.initSlideShow();
		
		this.add(new JPanel()); this.add(new JPanel());//(0,0);(0,1)
		this.returnToMenu = new JButton("Menu");
		this.add(returnToMenu);
		
		this.add(new JPanel());//(1,0)
		currentSlideIndex = 0;
		this.currentSlide = new JLabel(tutorialSlideShow[currentSlideIndex]);
		this.add(currentSlide);
		
		this.add(new JPanel());//(1,2)
		this.previousSlide = new JButton("<");
		this.add(previousSlide);
		
		this.add(new JPanel());//(2,1)
		this.nextSlide = new JButton(">");
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
