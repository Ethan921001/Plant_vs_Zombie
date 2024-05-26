package model.Entity.plant;

public class SunFlower extends Plant{
	public SunFlower(String name, int row, int col) {
		super(name, row, col);
		set_bounding_box_height(71);
		set_bounding_box_width(71);
		set_speed(0);
		set_imgsrc("Images/Plants/SunFlower.gif");
	}
	
	public boolean produce_sunshine() {
		return true;
	}
}
