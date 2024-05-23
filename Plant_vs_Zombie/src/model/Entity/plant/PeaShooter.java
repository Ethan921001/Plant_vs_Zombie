package model.Entity.plant;

public class PeaShooter extends Plant{
	
	public PeaShooter(String name, int row, int col) {
		super(name, row, col);
		set_bounding_box_height(71);
		set_bounding_box_width(71);
		set_speed(0);
		set_imgsrc("Images/Plants/peaShooter.gif");
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
	
	
	
}
