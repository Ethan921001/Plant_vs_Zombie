package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.button.ButtonListener;
import controller.button.StartButton;

public class MenuView extends JFrame{
	
	private Image background;
	private StartButton startButton;
	public MenuView(){
		try {
			background=new ImageIcon("Images/Backgrounds/str_game_background.png").getImage();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//添加開始按鈕
		JPanel panel=new JPanel();
		
		startButton=new StartButton();
		startButton.setLocation(445, 100);
		panel.add(startButton,0);
		
		JLabel jl=new JLabel();
		jl.setIcon(new ImageIcon(background));
		jl.setBounds(0, 0, 900, 600);
		panel.add(jl,-1);

		
		setContentPane(panel);
		setBounds(100, 100, 900, 600);
		setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        

        
	}
	
	public void paint(Graphics g){
		super.paint(g);
		//this.getGraphics().drawImage(background, 0, 0, null);
		
	}
	
}
