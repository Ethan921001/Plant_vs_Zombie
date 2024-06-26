package model.Entity.plant;

import model.Entity.Entity;
import model.Entity.zombie.Zombie;

public class Plant extends Entity {
	
	private int price=100;
	private int counter =0;
	private int cooldown=20;
	
	public Plant(String name, int row, int col)  {
		super(name, row, col);
		set_bounding_box_height(71);
		set_bounding_box_width(71);
		set_speed(0);
		set_imgsrc("Images/Plants/peaShooter.gif");
	}
	
	public boolean plant_hit(Zombie zombie) {
		
		int plant_x_left=this.get_x();
		int plant_x_right=this.get_x()+this.get_bounding_box_width();
		int plant_row=this.get_row();
		int zombie_x = zombie.get_x();
		int zombie_row = zombie.get_row();
		
		if(zombie_x>=plant_x_left && zombie_x<=plant_x_right && zombie_row==plant_row) {
			return true;
		}
		return false;
	}
	
	//默認無法射擊
	public boolean shoot() {
		return false;
	}
	//默認無法產生陽光
	public boolean produce_sunshine() {
		return false;
	}
	
	//植物無死亡動畫
	public void turn_to_die() {}
	
	
	public int get_price() {
		return price;
	}
	
	public void set_price(int price){
		this.price=price;
	}
	
	public int get_cooldown() {
		return cooldown;
	}
	
	public void set_cooldown(int cooldown) {
		this.cooldown = cooldown;
	}
	
	public int get_counter() {
		return counter;
	}
	
	public void set_counter(int count) {
		counter = count;
	}
	public void add_counter() {
		counter++;
	}
	
}

