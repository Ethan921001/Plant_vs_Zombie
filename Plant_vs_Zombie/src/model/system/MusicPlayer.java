package model.system;
import java.io.File;

import java.io.IOException;

import javax.sound.sampled.*;
public class MusicPlayer{
	private Clip clip;
	
	public void setFile(String musicFile) {
		try {
			File file = new File(musicFile);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void play(){
		clip.start();
		/*
		try {
			File file = new File("Audio/game.wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}*/
	}
	
	public void stop() {
		if (clip != null && clip.isRunning()) {
			clip.stop();
		}
	}
	
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
}
