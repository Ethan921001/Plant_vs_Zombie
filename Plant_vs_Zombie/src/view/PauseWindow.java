package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.button.ContinueButton;
import controller.button.ExitButton;
import controller.slider.VolumnSlider;
import model.system.MusicPlayer;

public class PauseWindow extends JFrame{
	
	
	public PauseWindow(MusicPlayer musicPlayer) {
		
		JPanel panel = new JPanel();
		
		JLabel label=new JLabel();
		ImageIcon background = new ImageIcon("Images\\Backgrounds\\PauseWindowBackground.png");
		label.setIcon(background);
		label.setBounds(0, 0, 400, 400);
		panel.add(label,-1);
		
		VolumnSlider volumnSlider =new VolumnSlider(musicPlayer);
		volumnSlider.setBounds(140, 150, 120, 20);
		panel.add(volumnSlider,0);
		
		ContinueButton continueButton =new ContinueButton();
		continueButton.setLocation(140, 200);
		panel.add(continueButton,0);
		
		ExitButton exitButton = new ExitButton();
		exitButton.setLocation(140, 270);
		panel.add(exitButton,0);
		
		setUndecorated(true);
		setContentPane(panel);
		setBounds(500, 120, 400, 400);
		setVisible(false);
		setLayout(null);
	}
	
}
