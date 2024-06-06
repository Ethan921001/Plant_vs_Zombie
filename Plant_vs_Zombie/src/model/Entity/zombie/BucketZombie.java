package model.Entity.zombie;

public class BucketZombie extends Zombie{
	public BucketZombie(String name, int row, int col) {
		
		super( name, row, col);
		set_bounding_box_width(102);
		set_bounding_box_height(144);
		set_y(40+100*row);
		set_speed(-2);
		set_imgsrc("Images/Zombies/bucketheadZombie.gif");
		set_health(15);
		set_max_died_time(50);
	}
	
	public void turn_to_attack(){
		if (this.get_health()>=5) {
			set_imgsrc("Images/Zombies/bucketheadZombieAttack.gif");
		}
		else {
			set_imgsrc("Images/Zombies/zombie_attack.gif");
			set_y(54+100*this.get_row());
		}
	}
	
	public void turn_to_walk(){
		if (this.get_health()>=5) {
			set_imgsrc("Images/Zombies/bucketheadZombie.gif");
		}
		else {
			set_imgsrc("Images/Zombies/zombie.gif");
			set_y(54+100*this.get_row());
		}
	}
}
