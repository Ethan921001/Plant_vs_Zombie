package controller.button;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.w3c.dom.events.MouseEvent;

public class PauseButton extends JButton{
	public PauseButton() {
		super("");
		
		setIcon(new ImageIcon("Images\\UI\\PauseButton.png"));
		addActionListener(new ButtonListener("Pause"));
		setSize(70, 65);
		setContentAreaFilled(false);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Image img = new ImageIcon("Images\\UI\\PauseButton.png").getImage();
		g.drawImage(img ,1250,40,null);
	}
	
}
