package controller.button;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RestartButton extends JButton{
	
	public RestartButton() {
		super("");
		setIcon(new ImageIcon("Images\\UI\\restart_button.png"));
		addActionListener(new ButtonListener("Restart"));
		setSize(384, 174);
		setContentAreaFilled(false);
	}
	
	
}
