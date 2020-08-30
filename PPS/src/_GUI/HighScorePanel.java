package _GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;

import DataAccess.DBManager;

public class HighScorePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	final Rectangle MENU_RECT = new Rectangle(390, 650, 80, 50);
	final Rectangle TEXT_RECT = new Rectangle (150, 30, 300, 65);
	final Rectangle PAUSE_RECT = new Rectangle(520,5,20,20);

	JLabel hsText;
	MainFrame parent;
	JButton returnToMenu;
	JLabel[] hsValues;
	JButton pause;

	DBManager db;
	ResultSet rs;
	String retrievingQuery = "SELECT * FROM ScoreTable ORDER BY 2 DESC LIMIT 11;";

	Image img;
	String BACKGROUND_PATH = "resources/cardIcons/highScorePanelBackground.jpg";

	public HighScorePanel(MainFrame parent) {

		super();
		this.parent = parent;
		this.setLayout(null);
		setBackground();

		hsValues = new JLabel[10];

		if(parent.isMusicPlaying)
			this.pause = new JButton(null,new ImageIcon(parent.PAUSE_MUSIC_PATH));
		else
			this.pause = new JButton(null,new ImageIcon(parent.PLAY_MUSIC_PATH));
		this.add(pause);
		this.pause.setBounds(PAUSE_RECT);

		this.returnToMenu = new JButton("Menu");
		this.add(returnToMenu);
		this.returnToMenu.setBounds(MENU_RECT);

		this.hsText = new JLabel("HIGH SCORE");
		this.add(hsText);
		hsText.setFont(new Font("Calibri", Font.BOLD, 50));
		this.hsText.setBounds(TEXT_RECT);
		hsText.setForeground(Color.YELLOW);

		try {
			initLabelVector();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	private void initLabelVector() throws ClassNotFoundException, SQLException {

		db = new DBManager(DBManager.JDBCDriverSQLite, DBManager.JDBCURLSQLite);
		rs = db.executeQuery(retrievingQuery);

		int cnt = 0;

		while(rs.next()) {

			int score = rs.getInt(2);
			String user = rs.getString(3);
			if(user.compareTo("null") != 0 && !user.isEmpty()) {
				String text = (cnt + 1) + "      " + user + " : " + score;
				hsValues[cnt] = new JLabel(text);

				add(hsValues[cnt]);
				hsValues[cnt].setFont(new Font("Calibri", Font.BOLD, 30));
				hsValues[cnt].setBounds(30, 100 + cnt * 50, 400, 30);
				hsValues[cnt].setForeground(Color.cyan);
				++cnt;
			}
		}
	}
}