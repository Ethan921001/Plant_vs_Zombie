package view;

import java.awt.*;
import java.awt.List;
import java.awt.image.ImageObserver;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Cards.Card;
import model.Entity.*;

//繪製地圖

public class MapView extends JFrame{
	
	private ArrayList<Entity> entities;
	private Card card;
	public MapView(ArrayList<Entity> entities, Card card) {
		setSize(1400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		this.entities = entities;
		this.card = card;
		addMouseListener(card);
		addMouseMotionListener(card);
	}
	
	public void paint() {
		super.paint(this.getGraphics());
		
		Image background = new ImageIcon("Images/Backgrounds/background1.png").getImage();
		this.getGraphics().drawImage(background, 0, 0, null);
		
		for(int i=0;i<entities.size();i++) {
			Entity entity = entities.get(i);
			Image img = new ImageIcon(entity.get_imgsrc()).getImage();
			this.getGraphics().drawImage(img, entity.get_x(), entity.get_y(), null);
		}
		
		//draw card
		Image img = new ImageIcon(card.get_imgsrc()).getImage();
		this.getGraphics().drawImage(img , card.get_cur_x(), card.get_cur_y(), null);
		
	}
	

}
