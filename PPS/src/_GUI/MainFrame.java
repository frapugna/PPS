package _GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MainFrame extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JFrame mainFrame;
	public String windowTitle;
	int frameWidth, frameHeight;
	public MainPanel mainPanel;
	public GamePanel gamePanel;
	public HighScorePanel highScorePanel;
	public TutorialPanel tutorialPanel;

	public MainFrame() {
		
		windowTitle = "Temporary title";
		frameWidth = 1000;
		frameHeight = 500;
		
		mainFrame = new JFrame(windowTitle);
		
 		mainFrame.setSize(this.frameWidth, this.frameHeight);
		
 		initMainPanel();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(mainFrame.getContentPane() == mainPanel) {
				
			if(e.getSource() == mainPanel.playButton) {
				
				gamePanel = new GamePanel(this);
				mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(gamePanel);
				mainFrame.repaint();
				mainFrame.setVisible(true);
				
				gamePanel.returnToMenu.addActionListener(this);
				
			}
			else if(e.getSource() == mainPanel.highScoreButton) {
				
				highScorePanel = new HighScorePanel(this);
				mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(highScorePanel);
				mainFrame.repaint();
				mainFrame.setVisible(true);
				
				highScorePanel.returnToMenu.addActionListener(this);
				
			}
			else if(e.getSource() == mainPanel.tutorialButton) {
				
				tutorialPanel = new TutorialPanel(this);
				mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(tutorialPanel);
				mainFrame.repaint();
				mainFrame.setVisible(true);
				
				tutorialPanel.returnToMenu.addActionListener(this);
				
			}
			
		}
		
		else if(mainFrame.getContentPane() == gamePanel) {
			if(e.getSource() == gamePanel.returnToMenu) 
				initMainPanel();
		}
		
		else if(mainFrame.getContentPane() == highScorePanel) {
			if(e.getSource() == highScorePanel.returnToMenu) 
				initMainPanel();
		}
		
		else if(mainFrame.getContentPane() == tutorialPanel) {
			if(e.getSource() == tutorialPanel.returnToMenu) 
				initMainPanel();
		}
		
	}
		
	public void initMainPanel() {
		
		mainPanel = new MainPanel(mainFrame);
		
		mainPanel.playButton.addActionListener(this);
		mainPanel.highScoreButton.addActionListener(this);
		mainPanel.tutorialButton.addActionListener(this);
		
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setContentPane(mainPanel);
		mainFrame.setVisible(true);
		
	}
	
}
