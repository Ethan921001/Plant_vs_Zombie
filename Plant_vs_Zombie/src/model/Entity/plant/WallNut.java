package model.Entity.plant;

public class WallNut extends Plant {
	
	public WallNut(String name, int row, int col) {
		super(name, row, col);
		set_bounding_box_height(65);
		set_bounding_box_width(73);
		set_speed(0);
		set_imgsrc("Images/Plants/WallNut.gif");
		set_health(50);
	}
}
