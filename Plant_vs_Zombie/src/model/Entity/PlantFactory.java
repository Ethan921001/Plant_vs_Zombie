package model.Entity;

import java.util.ArrayList;

public class PlantFactory {

	private Plant[][] plants_arr; 
	private ArrayList<Plant> plants;
	private ArrayList<Entity> entities;
	public PlantFactory(ArrayList<Plant> plants, ArrayList<Entity> entities) {
		this.plants_arr = new Plant[5][9];
		this.plants=plants;
		this.entities=entities;
	}
	
	public void place_plant(int x, int y) {
		int col = (x-250)/82;
		int row = (y-90)/100;
		System.out.println("row: "+row+"col: "+col );
		if(row>=0 && row<=4 && col>=0 && col<=8) {
			if(plants_arr[row][col]==null) {
				Plant plant = new Plant("plant", row, col);
				plants_arr[row][col]=plant;
				entities.add(plant);
				plants.add(plant);
			}
		}
	}
}
