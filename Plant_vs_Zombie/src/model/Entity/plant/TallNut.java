package model.Entity.plant;

public class TallNut extends Plant{
	
	public TallNut(String name, int row, int col) {
		super(name, row, col);
		set_bounding_box_height(60);
		set_bounding_box_width(65);
		set_speed(0);
		set_imgsrc("Images/Plants/TallNut.gif");
		set_health(80);
		set_y(40+100*row);
	}
}
