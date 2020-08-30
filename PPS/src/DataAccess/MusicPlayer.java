package DataAccess;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPlayer {
	long clipTimePosition;
	Clip clip;
	public MusicPlayer(String musicLocation) {
		try {
			File musicPath = new File(musicLocation);
			
			if(musicPath.exists()) {
				System.out.println("file found");
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				clip = AudioSystem.getClip();
				clip.open(audioInput);
			}
			else {
				System.out.println("Can't find the file");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	public void start() {
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	public void pause() {
		clipTimePosition = clip.getMicrosecondPosition();	//Saves the position
		clip.stop();
	}
	public void play() {
		clip.setMicrosecondPosition(clipTimePosition);
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
}
