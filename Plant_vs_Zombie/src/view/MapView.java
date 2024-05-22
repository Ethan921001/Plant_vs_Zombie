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
import model.Entity.plant.Plant;
import model.Entity.zombie.Zombie;

//繪製地圖

public class MapView extends JFrame{
	
	private ArrayList<Zombie> zombies;
	private ArrayList<Plant> plants;
	private ArrayList<Bullet> bullets;
	private Card card;
	public MapView(ArrayList<Zombie> zombies, ArrayList<Plant> plants, ArrayList<Bullet> bullets , Card card) {
		this.zombies=zombies;
		this.plants=plants;
		this.bullets=bullets;
		setSize(1400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		this.card = card;
		addMouseListener(card);
		addMouseMotionListener(card);
	}
	
	public void paint() {
		super.paint(this.getGraphics());
		
		Image background = new ImageIcon("Images/Backgrounds/background1.png").getImage();
		this.getGraphics().drawImage(background, 0, 0, null);
		
		ArrayList<Entity> entities =new ArrayList<Entity>();
		entities.addAll(zombies);
		entities.addAll(plants);
		entities.addAll(bullets);
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
