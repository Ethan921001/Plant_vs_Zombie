package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.button.ExitButton;

public class GameoverWindow extends JFrame{
	public GameoverWindow() {
		JPanel panel = new JPanel();
		
		JLabel label=new JLabel();
		ImageIcon background = new ImageIcon("Images\\Backgrounds\\PauseWindowBackground.png");
		label.setIcon(background);
		label.setBounds(0, 0, 400, 400);
		panel.add(label,-1);
		
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
