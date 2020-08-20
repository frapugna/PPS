package _GUI;

import java.awt.Font;
import java.awt.Rectangle;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DataAccess.DBManager;

public class HighScorePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final Rectangle MENU_RECT = new Rectangle(390, 650, 80, 50);
	final Rectangle TEXT_RECT = new Rectangle (150, 30, 300, 50);
	
	JLabel hsText;
	JFrame parent;
	JButton returnToMenu;
	JLabel[] hsValues;
	
	DBManager db;
	ResultSet rs;
	String retrievingQuery = "SELECT * FROM ScoreTable ORDER BY 2 DESC LIMIT 10;";
	
	public HighScorePanel(JFrame parent) {
		
		super();
		this.parent = parent;
		this.setLayout(null);
		
		hsValues = new JLabel[10];
		
		this.returnToMenu = new JButton("Menu");
		this.add(returnToMenu);
		this.returnToMenu.setBounds(MENU_RECT);
		
		this.hsText = new JLabel("HIGH SCORE");
		this.add(hsText);
		hsText.setFont(new Font("Calibri", Font.BOLD, 50));
		this.hsText.setBounds(TEXT_RECT);
		
		try {
			initLabelVector();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
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
			String text = (cnt + 1) + "      " + user + " : " + score;
			hsValues[cnt] = new JLabel(text);
			
			add(hsValues[cnt]);
			hsValues[cnt].setFont(new Font("Calibri", Font.BOLD, 30));
			hsValues[cnt].setBounds(30, 100 + cnt * 50, 400, 30);
			
			++cnt;
			
		}
	}
}
