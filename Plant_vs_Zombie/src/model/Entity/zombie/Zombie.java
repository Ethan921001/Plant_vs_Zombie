package model.Entity.zombie;

import model.Entity.Entity;
import model.Entity.plant.Plant;

public class Zombie extends Entity{
	
	private int cooldown, cooldown_counter;
	
	public Zombie(String name, int row, int col) {
		
		super( name, row, col);
		setCooldown(5);
		setCooldownCounter(5);
		set_bounding_box_width(91);
		set_bounding_box_height(129);
		set_y(50+100*row);
		set_speed(-2);
		set_imgsrc("Images/Zombies/zombie.gif");
		set_health(5);
		set_max_died_time(50);
	}
	
	public boolean zombie_hit(Plant plant) {

		int x_left=this.get_x();
		int x_right=this.get_x()+this.get_bounding_box_width();
		int zombie_row = this.get_row();
		int plant_x = plant.get_x()+plant.get_bounding_box_width();
		int plant_row = plant.get_row();
		//根據僵屍及植物的x座標及row，去判斷是否有碰撞發生
		if(plant_x>=x_left && plant_x<=x_right && plant_row==zombie_row) {
			return true;
		}
		return false;
	}	
	
	public boolean attackReady(){
		if(cooldown_counter>=cooldown) {
			setCooldownCounter(0);
			return true;
		}
		setCooldownCounter(getCooldownCounter()+1);
		return false;
		
	}
	
	public void turn_to_attack(){
		set_imgsrc("Images/Zombies/zombie_attack.gif");
	}
	
	public void turn_to_walk(){
		set_imgsrc("Images/Zombies/zombie.gif");
	}
	
	public void turn_to_die(){
		set_imgsrc("Images/Zombies/grave.png");
	}
	
	public void setCooldown(int cooldown) {
		this.cooldown=cooldown;
	}
	
	public int getCooldown() {
		return cooldown;
	}
	
	public void setCooldownCounter(int counter) {
		this.cooldown_counter=counter;
	}
	
	public int getCooldownCounter() {
		return cooldown_counter;
	}
}
