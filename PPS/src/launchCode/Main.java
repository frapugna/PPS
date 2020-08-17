package launchCode;
import java.awt.EventQueue;
import _GUI.MainFrame;

//Where the magic happens
public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();
			}
		});
	}	
}