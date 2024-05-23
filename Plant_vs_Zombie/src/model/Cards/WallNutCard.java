package model.Cards;

import model.Entity.PlantFactory;

public class WallNutCard extends Card{
	
	
	private int initial_x=50, initial_y=120;
	private String imgsrc="Images\\Plants\\WallNut.gif";
	
	public WallNutCard(PlantFactory plantFactory) {
		super(plantFactory);
	}

}
