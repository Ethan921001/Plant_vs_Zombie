package view;

import java.awt.*;

import java.awt.List;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.util.*;

import javax.swing.*;
import java.awt.image.*;

import controller.*;
import controller.button.PauseButton;
import controller.card.Card;
import controller.scrollbar.VolumnSlider;
import model.Entity.*;
import model.Entity.plant.*;
import model.Entity.zombie.*;
import model.judger.*;
import model.system.EconomySystem;
import model.system.MusicPlayer;

//繪製地圖

public class MapView extends JFrame implements WindowListener{
	
	private ArrayList<Zombie> zombies;
	private ArrayList<Plant> plants;
	private ArrayList<Bullet> bullets;
	private ArrayList<Entity> entities =new ArrayList<Entity>();
	private ArrayList<Card> cards;
	private Judger judger;
	private EconomySystem economySystem;
	private Image ScreenImage;
	private Image offScreenImage;
    private Shovel shovel;
    private Fertilizer fertilizer;
    private PauseButton pauseButton;
	private MusicPlayer musicPlayer;
	private JPanel panel;
	private JLabel label;
    
	public MapView(ArrayList<Zombie> zombies, ArrayList<Plant> plants, ArrayList<Bullet> bullets , ArrayList<Card> cards, EconomySystem ec, Judger judger, Shovel shovel, Fertilizer fertilizer) {
		this.zombies=zombies;
		this.plants=plants;
		this.bullets=bullets;
		this.cards = cards;
		this.economySystem=ec;
		this.judger=judger;
		this.shovel=shovel;
		this.fertilizer = fertilizer;
		
		add_mouse_listeners_and_motion_isteners();
		
		musicPlayer = new MusicPlayer();
		musicPlayer.setFile("Audio/game.wav");
		addWindowListener(this);
		
		//PauseButton pauseButton =new PauseButton();
		//pauseButton.setLocation(1100, 100);
		//add(pauseButton,0);
		
///	
		panel=new JPanel();
		panel.setBounds(0, 0, 1400, 550);
		
		label=new JLabel();
		label.setBounds(0, 0, 1400, 600);
		panel.add(label,-1);
		
		
		this.pauseButton = new PauseButton();
		pauseButton.setLocation(1200, 40);
		//add(pauseButton);
		panel.add(pauseButton,0);
		
///		
		
		/*
		JPanel panel =new JPanel();
		panel.add(pauseButton,0);
		setContentPane(panel);
		*/
		setContentPane(panel);
		setLayout(null);
		setSize(1400, 650);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(false);
		
		
		
	}
	
	public void paint(Graphics g) {
		
		//super.paint(g);
		//若offScreenImage為空，創建新Image
		if(offScreenImage==null) {
			offScreenImage=this.createImage(1400,600);
			label.setIcon(new ImageIcon(offScreenImage));
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
		//繪製肥料
		Image fertilizer_img = new ImageIcon(fertilizer.get_imgsrc()).getImage();
		gImage.drawImage(fertilizer_img, fertilizer.get_cur_x(), fertilizer.get_cur_y(), null);
		
		//display sunshine icon
		Image sun = new ImageIcon("Images/UI/Sun.png").getImage();
		gImage.drawImage(sun,20,510,null);
		//display amount of sunshine
		int sunshine=economySystem.get_sunshine();
		Font font =new Font("Palatino",Font.BOLD,40);
		gImage.setFont(font);
		gImage.setColor(Color.black);
		gImage.drawString(Integer.toString(sunshine), 90, 565);
		/*
		try {
			this.pauseButton.paint(gImage);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		
		boolean gameover = judger.gameover(zombies);
		//若沒輸，正常繪製遊戲畫面，否則繪製gameover字樣，並模糊遊戲畫面
		if(!gameover) {
			//this.getGraphics().drawImage(offScreenImage,0,0,null);
			//label.getGraphics().drawImage(offScreenImage,0,0,null);
			label.setIcon(new ImageIcon(offScreenImage));
		}
		else {
			BufferedImage blur_img=BlurImage(toBufferedImage(offScreenImage));
			//label.getGraphics().drawImage(blur_img, 0, 0, null);
			gameover_view();
		}
		
		//this.paintComponent(gImage);
		

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
		addMouseListener(fertilizer);
		addMouseMotionListener(fertilizer);
	}
		
	@Override
	public void windowOpened(WindowEvent e) {
		musicPlayer.start();
		//musicPlayer.loop();
	}

	@Override
	public void windowClosing(WindowEvent e) {

		musicPlayer.musicStop();
		GameState.gameover=true;

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void paintComponent(Graphics g) {
	}
	
	public MusicPlayer getMusicPlayer() {
		return musicPlayer;
	}
}
