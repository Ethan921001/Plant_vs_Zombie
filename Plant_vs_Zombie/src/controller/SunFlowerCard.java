package controller;

import model.Entity.PlantFactory;

public class SunFlowerCard extends Card{

	public SunFlowerCard(PlantFactory plantFactory) {
		super(plantFactory);
		set_cur_x(30);
		set_cur_y(310);
		set_initial_x(30);
		set_initial_y(310);
		set_imgsrc("Images/Card/sun_flower_card.png");
		set_name("sun_flower");
	}
}
