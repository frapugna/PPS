package DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class HighScoreSaver {

	DBManager db;
	ResultSet rs;
	String userName;
	
	public HighScoreSaver(int score) {
			
		getUserName();
		
		//Enable database connection
		try {
			db = new DBManager(DBManager.JDBCDriverSQLite, DBManager.JDBCURLSQLite);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String query = "INSERT INTO ScoreTable (ID, score, name) VALUES ("
				+ "NULL, " + score + ", " + "\"" + userName + "\""
				+ ");";
		
		//Insert current score
		try {
			db.executeUpdate(query);
		} catch (SQLException e) {
			try {
				db.executeUpdate("CREATE TABLE IF NOT EXISTS ScoreTable ("
						+ "ID INTEGER PRIMARY KEY, "
						+ "score INTEGER, "
						+ "name VARCHAR(20));");
				db.executeUpdate(query);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		/*Print out rows
		try {
			rs = db.executeQuery("SELECT * FROM ScoreTable");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while(rs.next()) {
				score = rs.getInt(2);
				userName = rs.getString(3);
				System.out.println(score + userName);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
			
	}
	
	public void getUserName() {
		userName = JOptionPane.showInputDialog("Save your score as:");
	}
}
