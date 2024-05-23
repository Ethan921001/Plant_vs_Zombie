package model.Entity.plant;

import model.Entity.Entity;
import model.Entity.zombie.Zombie;

public class Plant extends Entity {
	
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
	
	public boolean shoot() {
		if(this.counter<cooldown) {
			counter++;
			return false;
			
		}
		else {
			this.counter=0;
			return true;
		}
	}
	
	public void turn_to_die() {}
	
}
