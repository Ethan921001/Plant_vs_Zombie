package model.Entity.plant;

public class TallNut extends WallNut{
	
	public TallNut(String name, int row, int col) {
		super(name, row, col);
		set_bounding_box_height(60);
		set_bounding_box_width(65);
		set_speed(0);
		set_imgsrc("Images/Plants/TallNut.gif");
		setImgsrcCracked1("Images/Plants/TallnutCracked1.gif");
		setImgsrcCracked2("Images/Plants/TallnutCracked2.gif");
		set_max_health(60);
		set_health(60);
		set_y(40+100*row);
	}
}
