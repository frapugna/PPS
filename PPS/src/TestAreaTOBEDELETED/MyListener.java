package TestAreaTOBEDELETED;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyListener implements ActionListener{

	JPanel panelParent;
	JFrame frameParent;
	MyButton[][] buttonMatrix;
	int currX, currY;
	int actualX, actualY, actualXOtherButton, actualYOtherButton;
	int xSpeed, ySpeed, xSpeedOtherButton, ySpeedOtherButton;
	Timer timer;

	public MyListener(JPanel panelParent, JFrame frameParent, MyButton[][] buttonMatrix, int currX, int currY) {
		this.panelParent = panelParent;
		this.frameParent = frameParent;
		this.buttonMatrix = buttonMatrix;
		this.currX = currX;
		this.currY = currY;
	}






	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Bottone sopra
		if(e.getSource() == buttonMatrix[currY - 1][currX]) {
			goUp();
		}
		//Bottone a destra
		if(e.getSource() == buttonMatrix[currY][currX + 1]) {
			goRight();
		}
		//Bottone sotto
		if(e.getSource() == buttonMatrix[currY + 1][currX]) {
			goDown();
		}
		//Bottone a sinistra
		if(e.getSource() == buttonMatrix[currY][currX - 1]) {
			System.out.println("starting animation");
			goLeft();
			System.out.println("animation ended");
		}
		
	}

	private void goLeft(){
		
		actualX = currX * 100;
		actualY = currY * 100;
		xSpeed = -1;
		ySpeed = 0;
		
		actualXOtherButton = (currX - 1) * 100;
		actualYOtherButton = currY * 100;
		xSpeedOtherButton = xSpeed * -1;
		ySpeedOtherButton = 0;
		
		/*timer = new Timer(1000 / 20, new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if(actualX > (currX - 1) * 100) {
					 
					 actualX += xSpeed;
					 actualY += ySpeed;
					 buttonMatrix[currY][currX].setLocation(actualX, actualY);
					 
					 actualXOtherButton += xSpeedOtherButton;
					 actualYOtherButton += ySpeedOtherButton;
					 buttonMatrix[currY][currX - 1].setLocation(actualXOtherButton, actualYOtherButton);
					
				 } 
				 else {
					 timer.removeActionListener(this);
					 panelParent.setFocusable(true);
				 }
			 }
		});
		
		timer.setRepeats(true);
		timer.start();*/
		
		while(actualX > (currX - 1) * 100) {
			
			 actualX += xSpeed;
			 actualY += ySpeed;
			 
			 panelParent.remove(buttonMatrix[currY][currX]);
			 buttonMatrix[currY][currX].setLocation(actualX, actualY);
			 panelParent.add(buttonMatrix[currY][currX]);
			 
			 
			 actualXOtherButton += xSpeedOtherButton;
			 actualYOtherButton += ySpeedOtherButton;
			 
			 panelParent.remove(buttonMatrix[currY][currX - 1]);
			 buttonMatrix[currY][currX - 1].setLocation(actualXOtherButton, actualYOtherButton);
			 panelParent.add(buttonMatrix[currY][currX - 1]);
			 
			 panelParent.repaint();
			 
			 try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}






	private void goDown() {
		// TODO Auto-generated method stub
		
	}






	private void goRight() {
		// TODO Auto-generated method stub
		
	}






	private void goUp() {
		// TODO Auto-generated method stub
		
	}
	
	public void repaintBorders() {
		
		
	}

}