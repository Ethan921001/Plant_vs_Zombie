package controller.button;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StartButton extends JButton{
	
	public StartButton() {
		super("");
		setIcon(new ImageIcon("Images\\UI\\start_button.png"));
		addActionListener(new ButtonListener("Start"));
		setSize(384, 174);
		setContentAreaFilled(false);
	}
	
	
}
