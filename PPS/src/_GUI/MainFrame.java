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
	
	public MainFrame() {
		
		windowTitle = "Temporary title";
		frameWidth = 1000;
		frameHeight = 500;
		mainFrame = new JFrame(windowTitle);
		
		mainFrame.setSize(this.frameWidth, this.frameHeight);
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.add(new MainPanel(mainFrame));
		mainFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
