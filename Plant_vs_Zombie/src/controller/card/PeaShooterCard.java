package controller.card;

import java.awt.event.MouseEvent;

import model.Entity.PlantFactory;

public class PeaShooterCard extends Card{
	
	
	public PeaShooterCard(PlantFactory plantFactory) {
		super(plantFactory);
		set_cur_x(30);
		set_cur_y(50);
		set_initial_x(30);
		set_initial_y(50);
		set_imgsrc("Images/Card/pea_shooter_card.png");
		set_name("pea_shooter");
	}
}
