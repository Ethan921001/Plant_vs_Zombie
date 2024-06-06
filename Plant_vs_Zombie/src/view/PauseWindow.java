package view;

import javax.swing.JFrame;

import controller.button.ContinueButton;
import controller.button.ExitButton;

public class PauseWindow extends JFrame{
	
	public PauseWindow() {
		setBounds(200, 200, 300, 300);
		setVisible(false);
		
		ContinueButton continueButton =new ContinueButton();
		continueButton.setLocation(85, 70);
		add(continueButton);
		
		ExitButton exitButton = new ExitButton();
		exitButton.setLocation(85, 140);
		add(exitButton);
		
		setLayout(null);
	}
	
}
