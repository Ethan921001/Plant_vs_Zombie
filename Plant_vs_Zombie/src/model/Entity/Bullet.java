package model.Entity;

public class Bullet extends Entity{
	
	
	public Bullet(String name, int row, int col) {
		super (name, row, col);
		set_health(1);
		set_speed(10);
		set_imgsrc("Images/Bullets/bullet.png");
	}
	
	public boolean bullet_hit(Zombie zombie) {
		int bullet_row = this.get_row();
		int zombie_row = zombie.get_row();
		int bullet_x = this.get_x();
		int zombie_x = zombie.get_x();
		
		if (bullet_row == zombie_row && bullet_x >= zombie_x) {
			return true;
		}
		
		return false;
	}
	
	
	
	public void turn_to_die() {
	}
}
