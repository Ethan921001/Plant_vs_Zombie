package controller;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton{
	private Image background;
	private int width;
	private int height;
	private double angle;
	
	public Image getImage() {
		return this.background;
	}
	
	public void set_width(int width) {
		this.width = width;
	}
	
	public void set_height(int height) {
		this.height = height;
	}
	
	public void set_angle(double angle) {
		this.angle = angle;
	}
	
	public int get_width() {
		return this.width;
	}
	
	public int get_height() {
		return this.height;
	}
	
	public double get_angle() {
		return angle;
	}
	
	public Image set_image(Image image) {
		return this.background;
	}
	
	public Button(Button button) {
		super(button.getText());
		this.background = button.getImage();
		this.width = button.width;
		this.height = button.height;
		this.angle = button.angle;
		
		setContentAreaFilled(false);
		setBorderPainted(false);
		setOpaque(false);
	}
	
	public Button(String image, String name,int width, int height, double angle) {
		super(name);
		this.width = width;
		this.height = height;
		this.angle = Math.toRadians(angle);
		
		ImageIcon icon = new ImageIcon(image);
		this.background = icon.getImage();
		
		setVisible(true);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setOpaque(false);
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		
		int cx = width/2;
		int cy = height/2;
		
		g2d.rotate(angle,cx,cy);
		g2d.drawImage(background, 0, 0, width, height, this);
		g2d.rotate(-angle,cx,cy);
		
		super.paintComponent(g2d);
		g2d.dispose();	
	}
	
}
