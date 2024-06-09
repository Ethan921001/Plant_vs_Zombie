package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.button.ExitButton;
import controller.button.RestartButton;



public class GameoverWindow extends JFrame{
	
	private JButton button;
	
	public GameoverWindow() {
		JPanel panel = new JPanel();
		
		JLabel label=new JLabel();
		ImageIcon background = new ImageIcon("Images\\Backgrounds\\GameoverWindowBackground.png");
		label.setIcon(background);
		label.setBounds(0, 0, 400, 400);
		panel.add(label,-1);
		/*
		JLabel label2 = new JLabel("400");
		label2.setBackground(Color.white);
		label2.setBounds(140, 100, 100, 100);
		panel.add(label2,0);
		*/
		
		button=new JButton("0");
		button.setBackground(Color.white);
		button.setBounds(160,120, 60, 40);
		button.setFocusPainted(false);
		button.setEnabled(false);
		panel.add(button,0);
		
		
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
	
	public void showScore(int score) {
		button.setText(Integer.toString(score));
	}
}
