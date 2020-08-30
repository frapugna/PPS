package _GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import DataAccess.MusicPlayer;

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

	final String MUSIC_PATH = "resources/BGM.wav";
	final String ICON_PATH = "resources/AppIcon/AppIcon128x128.png";
	final String PLAY_MUSIC_PATH = "resources/AppIcon/playButton.png";
	final String PAUSE_MUSIC_PATH = "resources/AppIcon/pauseMusic.png";
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
	
	//Music management stuffs
	public MusicPlayer musicPlayer;
	public boolean isMusicPlaying;

	//Constructor, initializes frame and attaches MainPanel
	public MainFrame() {
		super(WINDOW_TITLE);

		ImageIcon icon = new ImageIcon(ICON_PATH);
		
		setIconImage(icon.getImage());
		
		this.setSize(this.FRAME_WIDTH, this.FRAME_HEIGHT);
		
		musicPlayer = new MusicPlayer(MUSIC_PATH);
		musicPlayer.start();
		isMusicPlaying = true;
		
		initStartingPanel();
		
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
				highScorePanel.pause.addActionListener(this);
			}
			else if(e.getSource() == mainPanel.tutorialButton) {
				tutorialPanel = new TutorialPanel(this);
				tutorialPanel.pause.addActionListener(this);
				//this.setSize(1280, 800);
				this.setSize(1280, 725);
				
				changePaneTo(tutorialPanel);
				tutorialPanel.returnToMenu.addActionListener(this);
			}
			else if(e.getSource() == mainPanel.pause) {
				this.musicControl();
				if(isMusicPlaying)
					mainPanel.pause.setIcon(new ImageIcon(PAUSE_MUSIC_PATH));
				else
					mainPanel.pause.setIcon(new ImageIcon(PLAY_MUSIC_PATH));
			}

		}

		else if(this.getContentPane() == highScorePanel) {

			if(e.getSource() == highScorePanel.returnToMenu) 
				initMainPanel();
			else if(e.getSource() == highScorePanel.pause) {
				this.musicControl();
				if(isMusicPlaying)
					highScorePanel.pause.setIcon(new ImageIcon(PAUSE_MUSIC_PATH));
				else
					highScorePanel.pause.setIcon(new ImageIcon(PLAY_MUSIC_PATH));
			}
		}

		else if(this.getContentPane() == tutorialPanel) {

			if(e.getSource() == tutorialPanel.returnToMenu) 
				initMainPanel();
			else if(e.getSource() == tutorialPanel.pause) {
				this.musicControl();
				if(isMusicPlaying)
					tutorialPanel.pause.setIcon(new ImageIcon(PAUSE_MUSIC_PATH));
				else
					tutorialPanel.pause.setIcon(new ImageIcon(PLAY_MUSIC_PATH));
			}
		}
		else if(this.getContentPane() == gamePanel) {
			if(e.getSource() == gamePanel.pause) {
				this.musicControl();
				if(isMusicPlaying)
					gamePanel.pause.setIcon(new ImageIcon(PAUSE_MUSIC_PATH));
				else
					gamePanel.pause.setIcon(new ImageIcon(PLAY_MUSIC_PATH));
			}
		}
		else if(this.getContentPane() == characterSelectionPanel) {
			if(e.getSource() == characterSelectionPanel.pause) {
				this.musicControl();
				if(isMusicPlaying)
					characterSelectionPanel.pause.setIcon(new ImageIcon(PAUSE_MUSIC_PATH));
				else
					characterSelectionPanel.pause.setIcon(new ImageIcon(PLAY_MUSIC_PATH));
			}
		}

	}
	/*
	 * This method creates the introductive panel
	 */
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
		mainPanel.pause.addActionListener(this);
		
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
	
	private void musicControl() {
		if(isMusicPlaying) {
			musicPlayer.pause();
			isMusicPlaying = false;
		}
		else {
			musicPlayer.play();
			isMusicPlaying = true;
		}
	}
	

}