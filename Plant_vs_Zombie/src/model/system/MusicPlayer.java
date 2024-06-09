package model.system;
import java.io.File;

import javax.sound.sampled.*;
public class MusicPlayer extends Thread{
	private Clip clip;
	private FloatControl floatControl;
	public void setFile(String musicFile) {
		try {
			File file = new File(musicFile);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
			floatControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void run(){
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
	
	public void musicStop() {
		if (clip != null && clip.isRunning()) {
			clip.stop();
		}
	}
	
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void loop2(int value) {
		clip.loop(value);
	}
	
	public boolean isPlaying() {
		if (clip.isRunning()) {
			return true;
		}
		else return false;
	}
	
	public boolean isNull() {
		if (clip == null) {
			return true;
		}
		else return false;
	}
	/*
	public void volumeUp() {
		//currentVolume = 6.0f;
		fc.setValue(6.0f);
	}*/
	
	public FloatControl get_floatControl() {
		return floatControl;
	}
	
	public void setVolume(int newVolume) {
		floatControl.setValue((float)newVolume);
	}
}
