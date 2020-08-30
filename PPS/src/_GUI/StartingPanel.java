package _GUI;

import java.awt.Font;


import java.awt.Rectangle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartingPanel extends JPanel implements MouseListener{
	
	private static final long serialVersionUID = 1L;

	final Rectangle START_RECT = new Rectangle(425, 235, 800, 100);
	final Rectangle BACKGROUND_RECT = new Rectangle(0, 0, 1200, 694);
	
	MainFrame parent;
	
	JLabel start;
	
	String BACKGROUND_PATH = "resources/cardIcons/startingPanelBackground.jpg";
	ImageIcon backGround = new ImageIcon(BACKGROUND_PATH);
	
	JLabel bGround;
	public StartingPanel(MainFrame parent) {
		super();
		this.parent = parent;
		this.setLayout(null);
		
		start = new JLabel("CLICK ANYWHERE TO START");
		start.setFont(new Font("Calibri", Font.BOLD, 30));
		this.add(start);
		start.setBounds(START_RECT);
	
		bGround = new JLabel(backGround);
		this.add(bGround);
		bGround.setBounds(BACKGROUND_RECT);
		this.addMouseListener(this);
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		return;
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.remove(start);
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		parent.initMainPanel();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		return;
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		return;
		
	}
}
