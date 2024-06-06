package model.Entity.plant;

public class GatlingPea extends PeaShooter{
	
	
	public GatlingPea(String name, int row, int col) {
		super(name, row, col);
		set_bounding_box_height(71);
		set_bounding_box_width(71);
		set_speed(0);
		set_cooldown(10);
		set_imgsrc("Images\\Plants\\GatlingPea.gif");
	}
	
	@Override
	public boolean shoot() {
		if(this.get_counter()<this.get_cooldown()) {
			this.add_counter();
			return false;
		}
		else {
			this.set_counter(0);;
			return true;
		}
	}
}
