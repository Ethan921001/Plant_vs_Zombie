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
	private Card card;
	private Judger judger;
	public MapView(ArrayList<Zombie> zombies, ArrayList<Plant> plants, ArrayList<Bullet> bullets , Card card, Judger judger) {
		this.zombies=zombies;
		this.plants=plants;
		this.bullets=bullets;
		setSize(1400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		this.card = card;
		this.judger = judger;
		addMouseListener(card);
		addMouseMotionListener(card);
	}
	
	public void paint() {
		super.paint(this.getGraphics());
		
		boolean over = judger.gameover(zombies);
		Image background = new ImageIcon("Images/Backgrounds/background1.png").getImage();
		BufferedImage b = BlurImage(toBufferedImage(background), over);
		this.getGraphics().drawImage(b, 0, 0, null);
		
		ArrayList<Entity> entities =new ArrayList<Entity>();
		entities.addAll(zombies);
		entities.addAll(plants);
		entities.addAll(bullets);
		for(int i=0;i<entities.size();i++) {
			Entity entity = entities.get(i);
			Image img = new ImageIcon(entity.get_imgsrc()).getImage();
			BufferedImage blur_img = BlurImage(toBufferedImage(img), over);
			this.getGraphics().drawImage(blur_img, entity.get_x(), entity.get_y(), null);
		}
		
		//draw card
		Image img = new ImageIcon(card.get_imgsrc()).getImage();
		this.getGraphics().drawImage(img , card.get_cur_x(), card.get_cur_y(), null);
	}
	
	public BufferedImage BlurImage(BufferedImage img, boolean over) {
		if(over) {
			float[] matrix = new float[49];
	        for (int i = 0; i < 49; i++) {
	            matrix[i] = 1.0f / 49.0f;
	        }
	        BufferedImageOp blur_img = new ConvolveOp(new Kernel(7, 7, matrix));
		    return blur_img.filter(img, null);
		}
	    return img;
	}
	
	private BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }
        BufferedImage bimage = new BufferedImage(
            img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        return bimage;
    }

	
	public void gameover_view(boolean over) {
		if(over) {
			Image gameover = new ImageIcon("Images\\Gameover\\gameover.png").getImage();
			this.getGraphics().drawImage(gameover, 300, 100, null);
		}
	}
}
