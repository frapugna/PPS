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
	
	public MainFrame() {
		
		windowTitle = "Temporary title";
		frameWidth = 1000;
		frameHeight = 500;
		
		mainFrame = new JFrame(windowTitle);
		
 		mainFrame.setSize(this.frameWidth, this.frameHeight);
		
		mainPanel = new MainPanel(mainFrame);
		
		mainPanel.playButton.addActionListener(this);
		
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setContentPane(mainPanel);
		mainFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == mainPanel.playButton) {
			gamePanel = new GamePanel(this);
			mainFrame.getContentPane().removeAll();
			mainFrame.getContentPane().add(gamePanel);
			mainFrame.repaint();
		}
		
		
	}

}
