package model.Cards;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import model.Entity.PlantFactory;
import model.Entity.plant.Plant;

import java.awt.event.MouseEvent;

public class Card implements MouseMotionListener, MouseListener{
	
	private PlantFactory plant_factory;
	private int initial_x=50, initial_y=50;
	private int cur_x=50, cur_y=50;
	private int width =71, height=71;
	private int offset_x=35, offset_y=35;
	private boolean draging = false;
	private String imgsrc="Images\\Plants\\Peashooter1.png";
	
	public Card(PlantFactory plant_factory) {
		this.plant_factory=plant_factory;
	}
	
	public String get_imgsrc() {
		return imgsrc;
	}
	
	public int get_cur_x() {
		return cur_x;
	}
	
	public int get_cur_y() {
		return cur_y;
	}
	
	
	public void mousePressed(MouseEvent e) {
		if(this.contains(e.getX(), e.getY())) {
			
			this.draging = true;
		}
	}
	
	public void mouseDragged(MouseEvent e) {
		if(draging) {
			this.cur_x = e.getX()-this.offset_x;
			this.cur_y = e.getY()-this.offset_y;
		}
	}
	public void mouseReleased(MouseEvent e) {
		draging = false;
		plant_factory.place_plant(cur_x, cur_y);
		System.out.println("x:"+this.cur_x+" "+"y:"+this.cur_y);
		this.cur_x = this.initial_x;
		this.cur_y = this.initial_y;
		
	}
	
	public void mouseClicked(MouseEvent e) {}
	
	public void mouseEntered(MouseEvent e) {}
	
	public void mouseExited(MouseEvent e) {}
	
	public void mouseMoved(MouseEvent e) {}
	
	public boolean contains(int x, int y) {
		return (x>=this.cur_x && x<=this.cur_x+this.width && y>=this.cur_y && y<=this.cur_y+this.height);
	}
}
