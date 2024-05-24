package view;

import java.awt.*;

import java.awt.List;
import java.awt.image.ImageObserver;
import java.util.*;

import javax.swing.*;
import java.awt.image.*;

import controller.*;
import model.Entity.*;
import model.Entity.plant.*;
import model.Entity.zombie.*;
import model.judger.*;
import model.system.EconomySystem;

//繪製地圖

public class MapView extends JFrame{
	
	private ArrayList<Zombie> zombies;
	private ArrayList<Plant> plants;
	private ArrayList<Bullet> bullets;
	private ArrayList<Entity> entities =new ArrayList<Entity>();
	private ArrayList<Card> cards;
	private Judger judger;
	private EconomySystem economySystem;
	private Image offScreenImage;

	public MapView(ArrayList<Zombie> zombies, ArrayList<Plant> plants, ArrayList<Bullet> bullets , ArrayList<Card> cards, EconomySystem ec) {
		this.zombies=zombies;
		this.plants=plants;
		this.bullets=bullets;
		this.cards = cards;
		this.economySystem=ec;
		setSize(1400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		add_mouse_listeners_and_motion_isteners();
	}
	
	public void paint() {
		
		if(offScreenImage==null) {
			offScreenImage=this.createImage(1400,600);
		}
		
		Graphics2D gImage=(Graphics2D)offScreenImage.getGraphics();
		Image background = new ImageIcon("Images/Backgrounds/background1.png").getImage();
		gImage.drawImage(background, 0, 0, null);
		//get entities list
		entities.clear();
		entities.addAll(zombies);
		entities.addAll(plants);
		entities.addAll(bullets);
		//draw entities
		for(int i=0;i<entities.size();i++) {
			Entity entity = entities.get(i);
			Image img = new ImageIcon(entity.get_imgsrc()).getImage();
			gImage.drawImage(img, entity.get_x(), entity.get_y(), null);
			//draw bounding box
			//gImage.drawRect(entity.get_x(), entity.get_y(), entity.get_bounding_box_width(), entity.get_bounding_box_height());
			
		}
		
		Image board = new ImageIcon("Images\\Card\\Board.png").getImage();
		gImage.drawImage(board,0,0,null);
		
		//draw cards
		for(int i=0;i<cards.size();i++) {
			Card card = cards.get(i);
			Image img = new ImageIcon(card.get_imgsrc()).getImage();
			gImage.drawImage(img, card.get_cur_x(), card.get_cur_y(), null);
		}
		
		//display amount of sunshine
		Image sun = new ImageIcon("Images/UI/Sun.png").getImage();
		gImage.drawImage(sun,20,490,null);
		
		int sunshine=economySystem.get_sunshine();
		Font font =new Font("Palatino",Font.BOLD,40);
		gImage.setFont(font);
		gImage.setColor(Color.black);
		gImage.drawString(Integer.toString(sunshine), 90, 545);
		
		this.getGraphics().drawImage(offScreenImage,0,0,null);
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
	
	public void gameover_view(boolean gameover) {
		if(gameover) {
			Image gameoverView = new ImageIcon("Images\\Gameover\\gameover.png").getImage();
			this.getGraphics().drawImage(gameoverView, 300, 100, null);
		}
	}
	
	public void add_mouse_listeners_and_motion_isteners() {
		for(Card card:cards) {
			addMouseListener(card);
			addMouseMotionListener(card);
		}
	}
	
}
