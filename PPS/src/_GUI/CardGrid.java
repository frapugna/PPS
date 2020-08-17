package _GUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class CardGrid extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	CharacterCard[][] cardMatrix;
	
	public CardGrid() {
		super();
		this.setLayout(null);
		
		initCardMatrix();
	}
	
	private void initCardMatrix() {
		
		cardMatrix = new CharacterCard[3][3];
		
		for(int y = 0; y < 3; ++y) {
			for(int x = 0; x < 3; ++x) {
				
				cardMatrix[y][x] = new CharacterCard(x, y);
				cardMatrix[y][x].setLocation(x * CharacterCard.WIDTH, y * CharacterCard.HEIGHT);
				cardMatrix[y][x].setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
				this.add(cardMatrix[y][x]);
				
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
		
	
}
