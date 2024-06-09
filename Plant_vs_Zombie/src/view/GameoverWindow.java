package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.button.ExitButton;
import controller.button.RestartButton;

public class GameoverWindow extends JFrame{
	public GameoverWindow() {
		JPanel panel = new JPanel();
		
		JLabel label=new JLabel();
		ImageIcon background = new ImageIcon("Images\\Backgrounds\\GameoverWindowBackground.png");
		label.setIcon(background);
		label.setBounds(0, 0, 400, 400);
		panel.add(label,-1);
		
		ExitButton exitButton = new ExitButton();
		exitButton.setLocation(140, 270);
		panel.add(exitButton,0);
		
		
		RestartButton restartButton=new RestartButton();
		restartButton.setLocation(140, 200);
		panel.add(restartButton,0);
		
		setUndecorated(true);
		setContentPane(panel);
		setBounds(500, 120, 400, 400);
		setVisible(false);
		setLayout(null);
	}
}
