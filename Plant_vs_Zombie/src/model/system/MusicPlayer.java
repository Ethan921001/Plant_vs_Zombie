package model.system;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;
public class MusicPlayer{
	private Clip clip;
	public void  music_play(){
		
		try {
			File file = new File("Audio/game.wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
	}
}
