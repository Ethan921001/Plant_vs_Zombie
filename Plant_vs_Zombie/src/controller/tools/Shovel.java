package controller.tools;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import model.system.PlantFactory;

public class Shovel implements MouseMotionListener, MouseListener{
	
	private PlantFactory plant_factory;
	private String imgsrc ="Images/UI/Shovel.png";
	private int initial_x=130, initial_y=30;
	private int cur_x=130, cur_y=30;
	private int width =76, height=34;
	private int offset_x=45, offset_y=35;
	private boolean draging = false;
	
	public Shovel(PlantFactory plantFactory) {
		this.plant_factory=plantFactory;
	}
	
	public String get_imgsrc() {
		return imgsrc;
	}
	
	public int get_cur_x() {
		return cur_x;
	}
	
	public void set_cur_x(int x) {
		this.cur_x=x;
	}
	
	public int get_cur_y() {
		return cur_y;
	}
	
	public void set_cur_y(int y) {
		this.cur_y=y;
	}
	
	public int get_initial_x() {
		return initial_x;
	}
	
	public void set_initial_x(int x) {
		this.initial_x=x;
	}
	
	public int get_initial_y() {
		return initial_y;
	}
	
	public void set_initial_y(int y) {
		this.initial_y=y;
	}
	
	public void set_draging(boolean draging) {
		this.draging=draging;
	}
	
	public boolean is_draging() {
		return draging;
	}
	
	public void set_imgsrc(String imgsrc) {
		this.imgsrc=imgsrc;
	}
	
	public PlantFactory get_plant_factory() {
		return plant_factory;
	}
	
	public void mousePressed(MouseEvent e) {
		if(this.contains(e.getX(), e.getY())) {
			
			this.draging = true;
		}
	}
	
	public void mouseDragged(MouseEvent e) {
		if(draging) {
			set_cur_x(e.getX()-this.offset_x);
			this.cur_y = e.getY()-this.offset_y;
		}
	}
	public void mouseReleased(MouseEvent e) {
		draging = false;
		plant_factory.delete_plant(cur_x, cur_y);;
		System.out.println("x:"+this.cur_x+" "+"y:"+this.cur_y);
		this.cur_x = this.initial_x;
		this.cur_y = this.initial_y;
		
	}
	
	public void mouseClicked(MouseEvent e) {}
	
	public void mouseEntered(MouseEvent e) {}
	
	public void mouseExited(MouseEvent e) {}
	
	public void mouseMoved(MouseEvent e) {}
	
	public boolean contains(int x, int y) {
		return (x>=this.cur_x && x<=this.cur_x+this.width && y>=this.cur_y+30 && y<=this.cur_y+this.height+50);
	}
	
}
