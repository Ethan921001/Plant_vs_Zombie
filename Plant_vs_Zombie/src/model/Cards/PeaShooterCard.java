package model.Cards;

import java.awt.event.MouseEvent;

import model.Entity.PlantFactory;

public class PeaShooterCard extends Card{
	
	private String name="pea_shooter";
	private int initial_x=50, initial_y=50;
	private String imgsrc="Images\\Plants\\Peashooter.gif";
	
	public PeaShooterCard(PlantFactory plantFactory) {
		super(plantFactory);
	}
}
