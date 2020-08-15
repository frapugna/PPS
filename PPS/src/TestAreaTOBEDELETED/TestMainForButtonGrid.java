package TestAreaTOBEDELETED;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestMainForButtonGrid extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("TestGrid");
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(313, 335);//necessita di qualche pixel in più perchè i bottoni hanno xgap e ygap
		
		JPanel panel = new JPanel();
		MyButton[][] buttonMatrix = new MyButton[3][3]; //y poi x !!!!!, il diagramma cartesiano è invertito!
		MyListener myListener = new MyListener(panel, frame, buttonMatrix, 1, 1);
		
		initGrid(panel, buttonMatrix, myListener);
		
		frame.setContentPane(panel);
		frame.setVisible(true);
			
		initGame(buttonMatrix, panel, frame);//sono tutti riferimenti statici perchè non avevo voglia di creare un'altra classe
	}
	
	public static void initGrid(JPanel panel, MyButton[][] buttonMatrix, MyListener myListener) {
		
		panel.setLayout(null);
		panel.setSize(300, 300);
		
		for(int y = 0; y < 3; ++y) {
			for(int x = 0; x < 3; ++x) {
				
				buttonMatrix[y][x] = new MyButton( String.format("(" + x + "," + y + ")"), x, y);
				buttonMatrix[y][x].setBounds( x*100, y*100, 100, 100);
				buttonMatrix[y][x].addActionListener(myListener);
				panel.add(buttonMatrix[y][x]);
			}
			
		}
		
	}
	
	public static void initGame(MyButton[][] buttonMatrix, JPanel panel, JFrame frame) {
		
		buttonMatrix[1][1].setBorder(BorderFactory.createLineBorder(Color.RED, 5));//THICK
		
		buttonMatrix[0][1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));//sopra
		buttonMatrix[1][0].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));//sinistra
		buttonMatrix[2][1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));//sotto
		buttonMatrix[1][2].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));//destra
		
		buttonMatrix[0][0].setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		buttonMatrix[0][2].setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		buttonMatrix[2][2].setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		buttonMatrix[2][0].setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		
		
	}

}
