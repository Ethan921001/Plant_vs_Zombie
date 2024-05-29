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
    private Shovel shovel;
	
	public MapView(ArrayList<Zombie> zombies, ArrayList<Plant> plants, ArrayList<Bullet> bullets , ArrayList<Card> cards, EconomySystem ec, Judger judger, Shovel shovel) {
		this.zombies=zombies;
		this.plants=plants;
		this.bullets=bullets;
		this.cards = cards;
		this.economySystem=ec;
		this.judger=judger;
		this.shovel=shovel;
		setSize(1400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		add_mouse_listeners_and_motion_isteners();
	}
	
	public void paint() {
		
		//若offScreenImage為空，創建新Image
		if(offScreenImage==null) {
			offScreenImage=this.createImage(1400,600);
		}
		
		//用於在offScreenImage上繪製新場景
		Graphics2D gImage=(Graphics2D)offScreenImage.getGraphics();
		
		//繪製背景
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
		
		//繪製卡牌面板
		Image board = new ImageIcon("Images\\Card\\Board.png").getImage();
		gImage.drawImage(board,0,0,null);
		
		//draw cards
		for(int i=0;i<cards.size();i++) {
			Card card = cards.get(i);
			Image img = new ImageIcon(card.get_imgsrc()).getImage();
			gImage.drawImage(img, card.get_cur_x(), card.get_cur_y(), null);
		}	
		
		
		Image shovel_back = new ImageIcon("Images\\UI\\ShovelBack.png").getImage();
		gImage.drawImage(shovel_back,130,30,null);
		//繪製鏟子
		Image shovel_img = new ImageIcon(shovel.get_imgsrc()).getImage();
		gImage.drawImage(shovel_img, shovel.get_cur_x(), shovel.get_cur_y(), null);
		
		//display sunshine icon
		Image sun = new ImageIcon("Images/UI/Sun.png").getImage();
		gImage.drawImage(sun,20,510,null);
		//display amount of sunshine
		int sunshine=economySystem.get_sunshine();
		Font font =new Font("Palatino",Font.BOLD,40);
		gImage.setFont(font);
		gImage.setColor(Color.black);
		gImage.drawString(Integer.toString(sunshine), 90, 565);
		
		
		
		
		
		
		boolean gameover = judger.gameover(zombies);
		//若沒輸，正常繪製遊戲畫面，否則繪製gameover字樣，並模糊遊戲畫面
		if(!gameover) {
			this.getGraphics().drawImage(offScreenImage,0,0,null);
		}
		else {
			BufferedImage blur_img=BlurImage(toBufferedImage(offScreenImage));
			this.getGraphics().drawImage(blur_img, 0, 0, null);
			gameover_view();
		}
		

	}
	
	//將圖片模糊
	public BufferedImage BlurImage(BufferedImage img) {
		float[] matrix = new float[49];
        for (int i = 0; i < 49; i++) {
            matrix[i] = 1.0f / 49.0f;
        }
        BufferedImageOp blur_img = new ConvolveOp(new Kernel(7, 7, matrix));
	    return blur_img.filter(img, null);
	}
	
	//繪製gameover字樣
	public void gameover_view() {
		Image gameoverView = new ImageIcon("Images\\Gameover\\gameover.png").getImage();
		this.getGraphics().drawImage(gameoverView, 300, 100, null);
	}
	
	//將img轉為BufferedImage
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

	//將cards內的mouselistener加入Jframe
	public void add_mouse_listeners_and_motion_isteners() {
		for(Card card:cards) {
			addMouseListener(card);
			addMouseMotionListener(card);
		}
		addMouseListener(shovel);
		addMouseMotionListener(shovel);
	}
	
}
