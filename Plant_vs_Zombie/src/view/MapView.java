package view;

import java.awt.*;
import java.awt.List;
import java.awt.image.ImageObserver;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Entity.*;

//繪製地圖

public class MapView extends JFrame{
	
	private ArrayList<Entity> entities;
	public MapView(ArrayList<Entity> entities) {
		setSize(1400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		this.entities = entities;
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Image background = new ImageIcon("Images/Backgrounds/background1.png").getImage();
		g.drawImage(background, 0, 0, null);
		
		for(int i=0;i<entities.size();i++) {
			Entity entity = entities.get(i);
			Image img = new ImageIcon(entity.get_imgsrc()).getImage();
			g.drawImage(img, entity.get_x(), entity.get_y(), null);
		}
		
		
	}
	

}
