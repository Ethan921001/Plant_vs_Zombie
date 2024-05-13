package Game;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game {
	
	private JFrame frame;
	
	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setVisible(true);
	}
	
	public Game() {
		initialize();
	}
	
	public void initialize() {
		
		//視窗
		frame = new JFrame();
		frame.setBounds(100, 100, 1400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		try {
			Icon background = new ImageIcon("Images/Backgrounds/background1.png");					
			JLabel lb_background = new JLabel();
			lb_background.setIcon(background);
			lb_background.setBounds(0,0,background.getIconWidth()-400,background.getIconHeight());
			frame.getContentPane().add(lb_background);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}