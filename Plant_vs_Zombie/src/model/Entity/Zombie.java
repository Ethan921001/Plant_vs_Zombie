package model.Entity;


public class Zombie extends Entity{
	
	public Zombie(String name, int row, int col) {
		
		super( name, row, col);
		set_bounding_box_width(166);
		set_bounding_box_height(144);
		set_y(20+100*row);
		set_speed(-2);
		set_imgsrc("Images/Zombies/zombie.gif");
	}
	
	public boolean zombie_hit(Plant plant) {

		int x_left=this.get_x();
		int x_right=this.get_x()+this.get_bounding_box_width();
		int zombie_row = this.get_row();
		int plant_x = plant.get_x()+plant.get_bounding_box_width();
		int plant_row = plant.get_row();
		if(plant_x>=x_left && plant_x<=x_right && plant_row==zombie_row) {
			return true;
		}
		return false;
	}	
	
	
	
	public void turn_to_attack(){
		set_imgsrc("Images/Zombies/zombie_attack.gif");
	}
	
	public void turn_to_walk(){
		set_imgsrc("Images/Zombies/zombie.gif");
	}
	
	public void turn_to_die(){
		set_imgsrc("Images/Zombies/zombie_died.gif");
	}
}
