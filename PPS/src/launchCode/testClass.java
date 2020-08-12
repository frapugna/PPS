package launchCode;

import java.util.Random;

public class testClass {
	
	public testClass() {
		System.out.println("Classe di tommy generata");
	}
	
	public int RNG() {
		Random r = new Random();
		return r.nextInt();
	}
}
