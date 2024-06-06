package view;

import javax.swing.JFrame;

import controller.button.ContinueButton;

public class PauseWindow extends JFrame{
	
	public PauseWindow() {
		setBounds(200, 200, 300, 300);
		setVisible(false);
		
		ContinueButton continueButton =new ContinueButton();
		continueButton.setLocation(100, 100);
		add(continueButton);
		
		setLayout(null);
	}
	
}
