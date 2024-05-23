package model.Cards;

import model.Entity.PlantFactory;

public class WallNutCard extends Card{
	
	private String name="wall_nut";
	private int initial_x=50, initial_y=120;
	private String imgsrc="Images\\Plants\\WallNut.gif";
	
	public WallNutCard(PlantFactory plantFactory) {
		super(plantFactory);
		set_cur_x(50);
		set_cur_y(120);
		set_initial_x(50);
		set_initial_y(120);
		set_imgsrc("Images\\Plants\\WallNut.gif");
		set_name("wall_nut");
	}

}
