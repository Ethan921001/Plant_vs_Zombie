package controller.button;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ContinueButton extends JButton{
	
	public ContinueButton() {
		super("");
		setIcon(new ImageIcon("Images\\UI\\ContinueButton.png"));
		addActionListener(new ButtonListener("Continue"));
		setSize(113, 41);
		setContentAreaFilled(false);
	}
		
	
	
}
