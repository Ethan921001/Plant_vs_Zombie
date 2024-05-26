package model.Entity.zombie;

public class ConeZombie extends Zombie{
	public ConeZombie(String name, int row, int col) {
		
		super( name, row, col);
		set_bounding_box_width(94);
		set_bounding_box_height(144);
		set_y(40+100*row);
		set_speed(-2);
		set_imgsrc("Images/Zombies/coneheadZombie.gif");
		set_health(3);
		set_max_died_time(50);
	}
	
	public void turn_to_attack(){
		if (this.get_health()>=2) {
			set_imgsrc("Images/Zombies/coneheadZombieAttack.gif");
		}
		else {
			set_imgsrc("Images/Zombies/zombie_attack.gif");
			set_y(50+100*this.get_row());
		}
	}
	
	public void turn_to_walk(){
		if (this.get_health()>=2) {
			set_imgsrc("Images/Zombies/coneheadZombie.gif");
		}
		else {
			set_imgsrc("Images/Zombies/zombie.gif");
			set_y(50+100*this.get_row());
		}
	}
}
