package controller.button;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ExitButton extends JButton{
	
	public ExitButton() {
		super("");
		setIcon(new ImageIcon("Images\\UI\\ContinueButton.png"));
		addActionListener(new ButtonListener("Gameover"));
		setSize(113, 41);
		setContentAreaFilled(false);
	}
}
