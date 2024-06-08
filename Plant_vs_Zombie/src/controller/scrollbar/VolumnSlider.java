package controller.scrollbar;

import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.sound.sampled.FloatControl;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.system.MusicPlayer;

public class VolumnSlider extends JSlider{
	
	private MusicPlayer musicPlayer;
	public VolumnSlider(MusicPlayer musicPlayer) {
		
		super(JSlider.HORIZONTAL,-60,6,-30);
		
		this.musicPlayer=musicPlayer;
		addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				musicPlayer.setVolume(getValue());
	
			}
		});
	}
}
