package controller.card;

import model.system.PlantFactory;

public class WallNutCard extends Card{
	
	
	public WallNutCard(PlantFactory plantFactory) {
		super(plantFactory);
		set_cur_x(30);
		set_cur_y(180);
		set_initial_x(30);
		set_initial_y(180);
		set_imgsrc("Images\\Card\\wall_nut_card.png");
		set_name("wall_nut");
	}

}
