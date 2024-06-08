package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.button.ButtonListener;
import controller.button.StartButton;
import controller.scrollbar.VolumnSlider;
import model.system.MusicPlayer;

public class MenuView extends JFrame implements ComponentListener{
	
	private Image background;
	private StartButton startButton;
	private MusicPlayer menuMusicPlayer;
	public MenuView(){
		try {
			background=new ImageIcon("Images/Backgrounds/str_game_background.png").getImage();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		menuMusicPlayer = new MusicPlayer();
        menuMusicPlayer.setFile("Audio/IntroThemeWAV.wav");
        addComponentListener(this);
		
		//添加開始按鈕
		JPanel panel=new JPanel();
		
		startButton=new StartButton();
		startButton.setLocation(445, 100);
		panel.add(startButton,0);
		
		VolumnSlider volumnSlider = new VolumnSlider(menuMusicPlayer);
		volumnSlider.setBounds(550, 350, 150, 20);
		volumnSlider.setBackground(Color.gray);
		panel.add(volumnSlider);
		
		JLabel jl=new JLabel();
		jl.setIcon(new ImageIcon(background));
		jl.setBounds(0, 0, 900, 600);
		panel.add(jl,-1);

		
		setContentPane(panel);
		setBounds(100, 100, 900, 600);
		setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
	}
	
	public void paint(Graphics g){
		super.paint(g);
		//this.getGraphics().drawImage(background, 0, 0, null);
		
	}
	
	@Override
	public void componentShown(ComponentEvent e) {
		menuMusicPlayer.start();
		menuMusicPlayer.loop();
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		menuMusicPlayer.musicStop();
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public MusicPlayer getMusicPlayer() {
		return musicPlayer;
	}
	
}
