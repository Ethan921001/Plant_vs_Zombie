package test;

import javax.swing.*;
import java.awt.*;
import java.security.PublicKey;


public class test extends JPanel{
	public static void main(String[] args) {
		
		GifTest gif1 = new GifTest("Images/Plants/peaShooter.gif");
		GifTest gif2 = new GifTest("Images/Zombies/zombie.gif");
		
		JFrame jf = new JFrame();
		jf.setBounds(100, 100, 800, 600);
		JLabel jl = new JLabel(gif1.get_icon());
		JLabel j2 = new JLabel(gif2.get_icon());
		Icon background = new ImageIcon("Images/Backgrounds/background1.png");					
		JLabel lb_background = new JLabel();
		jl.setBounds(270, 270, gif1.get_icon().getIconWidth(), gif1.get_icon().getIconHeight());
		j2.setBounds(800, 200, gif2.get_icon().getIconWidth(), gif2.get_icon().getIconHeight());
		jf.add(jl);
		jf.add(j2);
		jf.add(lb_background);
		lb_background.setIcon(background);
		lb_background.setBounds(0,0,background.getIconWidth()-400,background.getIconHeight());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		for(int i= 0 ; i<=100; i++) {
			
			j2.setBounds(j2.getX()-5, 200, gif2.get_icon().getIconWidth(), gif2.get_icon().getIconHeight());
			try {
				Thread.sleep(500);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
		}
		
		j2.setIcon(new ImageIcon("Images/Zombies/zombie_attack.gif"));
	}
	
	
}
