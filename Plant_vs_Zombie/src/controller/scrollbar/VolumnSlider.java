package controller.scrollbar;

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
