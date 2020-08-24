package _GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * First and only frame of the app
 * Starts with the MainPanel and switches between panels
 * Also listens to MainPanel's buttons and returntomenu buttons of the other panels
 * (Other buttons are handled by their parent component)
 */
public class MainFrame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Frame dimension
	final int FRAME_WIDTH = 1000, FRAME_HEIGHT = 500;
	static final String WINDOW_TITLE = "CardVenture";
	/*
	//Frame attributes
	public JFrame mainFrame;
	public String windowTitle;
	*/
	//Panels handled
	public StartingPanel startingPanel;
	public MainPanel mainPanel;
	public GamePanel gamePanel;
	public CharacterSelectionPanel characterSelectionPanel;
	public HighScorePanel highScorePanel;
	public TutorialPanel tutorialPanel;

	//Constructor, initializes frame and attaches MainPanel
	public MainFrame() {
		super(WINDOW_TITLE);
	
 		this.setSize(this.FRAME_WIDTH, this.FRAME_HEIGHT);
		//
 		initStartingPanel();
		//
	}

	/*
	 * the ActionPerformed method works by discerning which panel is the current ContentPane
	 * it checks which buttons are being pressed and changes panels accordingly
	 * it also adds actionListeners to buttons that aren't in the mainPanel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(this.getContentPane() == mainPanel) {
			
			if(e.getSource() == mainPanel.playButton) {
				characterSelectionPanel = new CharacterSelectionPanel(this);
				changePaneTo(characterSelectionPanel);
			}
			else if(e.getSource() == mainPanel.highScoreButton) {	
				highScorePanel = new HighScorePanel(this);
				
				this.setSize(550, 800);
				
				changePaneTo(highScorePanel);
				highScorePanel.returnToMenu.addActionListener(this);
			}
			else if(e.getSource() == mainPanel.tutorialButton) {
				tutorialPanel = new TutorialPanel(this);
				changePaneTo(tutorialPanel);
				tutorialPanel.returnToMenu.addActionListener(this);
			}
			
		}
		
		else if(this.getContentPane() == highScorePanel) {
			
			if(e.getSource() == highScorePanel.returnToMenu) 
				initMainPanel();
		}
		
		else if(this.getContentPane() == tutorialPanel) {
		
			if(e.getSource() == tutorialPanel.returnToMenu) 
				initMainPanel();
		}
		
	}
	public void initStartingPanel() {
		
		startingPanel = new StartingPanel(this);
		
		this.setSize(1200, 694);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(startingPanel);
		this.setVisible(true);
		
	}
	/*
	 * Method necessary to initialize the main panel because
	 * Swing is a little bitch and doesn't know how to save
	 * a panel state (or it is me that doesn't know how to do it)
	 * (nonetheless it works now)
	 */
	public void initMainPanel() {
		this.getContentPane().removeAll();
		
		mainPanel = new MainPanel(this);
		
		mainPanel.playButton.addActionListener(this);
		mainPanel.highScoreButton.addActionListener(this);
		mainPanel.tutorialButton.addActionListener(this);
		
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(mainPanel);
		this.setVisible(true);
		
	}
	
	/*
	 * Method to set any custom panel as the contentPane 
	 */
	public <T extends JPanel> void changePaneTo(T panel) {
		
		this.getContentPane().removeAll();
		this.setContentPane(panel);
		
		if(panel instanceof GamePanel) 
			this.setSize(720, 660);
		if(panel instanceof CharacterSelectionPanel)
			this.setSize(530, 280);
		
		
		this.setLocationRelativeTo(null);
		this.repaint();
		this.setVisible(true);
		
	}
	
}