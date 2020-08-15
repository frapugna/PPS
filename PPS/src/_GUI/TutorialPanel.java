package _GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	
	public TutorialPanel(JFrame parent){
		
		super(new GridLayout(3, 3));
		this.parent = parent;
		
		slideTotalNumber = 2;
		this.tutorialSlideShow = new ImageIcon[slideTotalNumber];
		this.initSlideShow();
		
		this.add(new JPanel()); this.add(new JPanel());
		this.returnToMenu = new JButton("Menu");
		this.add(returnToMenu);
		
		this.add(new JPanel());
		currentSlideIndex = 0;
		this.currentSlide = new JLabel(tutorialSlideShow[currentSlideIndex]);
		this.add(currentSlide);
		
		this.add(new JPanel());
		this.previousSlide = new JButton("<");
		this.add(previousSlide);
		
		this.add(new JPanel());
		this.nextSlide = new JButton(">");
		this.add(nextSlide);
		
		nextSlide.addActionListener(this);
		previousSlide.addActionListener(this);
		
	} 
	
	public void initSlideShow() {
			
			tutorialSlideShow[0] = new ImageIcon("resources/firstSlide.png");
			tutorialSlideShow[1] = new ImageIcon("resources/secondSlide.png");
		
	}

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
