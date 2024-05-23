package view;

import java.awt.*;
import java.awt.List;
import java.awt.image.ImageObserver;
import java.util.*;


import javax.swing.*;
import java.awt.image.*;

import model.Cards.Card;
import model.Entity.*;
import model.Entity.plant.Plant;
import model.Entity.zombie.Zombie;
import model.judger.*;
//繪製地圖

public class MapView extends JFrame{
	
	private ArrayList<Zombie> zombies;
	private ArrayList<Plant> plants;
	private ArrayList<Bullet> bullets;
	private ArrayList<Card> cards;
	private Judger judger;
<<<<<<< HEAD
	public MapView(ArrayList<Zombie> zombies, ArrayList<Plant> plants, ArrayList<Bullet> bullets , ArrayList<Card> cards) {
=======
	public MapView(ArrayList<Zombie> zombies, ArrayList<Plant> plants, ArrayList<Bullet> bullets , Card card, Judger judger) {
>>>>>>> branch 'master' of https://github.com/Ethan921001/Plant_vs_Zombie.git
		this.zombies=zombies;
		this.plants=plants;
		this.bullets=bullets;
		setSize(1400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
<<<<<<< HEAD
		this.cards = cards;
		add_mouse_listeners_and_motion_isteners();
=======
		this.card = card;
		this.judger = judger;
		addMouseListener(card);
		addMouseMotionListener(card);
>>>>>>> branch 'master' of https://github.com/Ethan921001/Plant_vs_Zombie.git
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
		for(int i=0;i<cards.size();i++) {
			Card card = cards.get(i);
			Image img = new ImageIcon(card.get_imgsrc()).getImage();
			this.getGraphics().drawImage(img, card.get_cur_x(), card.get_cur_y(), null);
		}
		//gameover_view();
	}
	
	public BufferedImage BlurImage(BufferedImage img) {
		float[] matrix = {
	            1/9f, 1/9f, 1/9f,
	            1/9f, 1/9f, 1/9f,
	            1/9f, 1/9f, 1/9f
	    };
	    BufferedImageOp blur_img = new ConvolveOp(new Kernel(3, 3, matrix));
	    return blur_img.filter(img, null);
	}
	
	public void gameover_view() {
		if(judger.gameover(zombies)) {
			Image gameover = new ImageIcon("Images\\Gameover\\gameover.png").getImage();
			this.getGraphics().drawImage(gameover, 300, 100, null);
		}
	}
	
	public void add_mouse_listeners_and_motion_isteners() {
		for(Card card:cards) {
			addMouseListener(card);
			addMouseMotionListener(card);
		}
	}
	
}
