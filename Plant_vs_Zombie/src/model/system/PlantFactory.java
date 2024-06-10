package model.system;

import java.util.ArrayList;
import model.Entity.plant.*;

public class PlantFactory {

	private Plant[][] plants_arr; 
	private ArrayList<Plant> plants;
	private EconomySystem economySystem;
	private MusicPlayer placeSound;
	
	public PlantFactory(ArrayList<Plant> plants, EconomySystem economySystem) {
		this.plants_arr = new Plant[5][9];
		this.plants=plants;
		this.economySystem=economySystem;
	}
	
	public void place_plant(String name, int x, int y) {
		int col = (x-210)/80;
		int row = (y-50)/100;
		System.out.println("row: "+row+"col: "+col );
		if(row>=0 && row<=4 && col>=0 && col<=8) {
			if(plants_arr[row][col]==null||!plants_arr[row][col].is_alive()) {
				Plant plant;
				switch (name){
					case "pea_shooter": 
						plant = new PeaShooter("pea_shooter", row, col);
						break;
					case "wall_nut": 
						plant = new WallNut("wall_nut", row, col);
						break;
					case "sun_flower":
						plant = new SunFlower("sun_flower", row, col);
						break;
					default:
						plant = new PeaShooter("pea_shooter", row, col);
						break;
				}
				if(economySystem.get_sunshine()>=plant.get_price()) {
					plants_arr[row][col]=plant;
					plants.add(plant);
					economySystem.set_sunshine(economySystem.get_sunshine()-plant.get_price());
					placeSound = new MusicPlayer();
					placeSound.setFile("Audio/placePlantWAV.wav");
					placeSound.start();
					
				}
				
			}
		}
	}
	
	public void delete_plant(int x, int y) {
		int col = (x-210)/80;
		int row = (y-50)/100;
		if(row>=0 && row<=4 && col>=0 && col<=8) {
			if(plants_arr[row][col]!=null && plants_arr[row][col].is_alive()) {
				plants_arr[row][col].set_health(0);
			}
		}
	}
	
	public void upgrade_plant(int x, int y) {
		int col = (x-210)/80;
		int row = (y-50)/100;
		int fertilier_price = 500;
		if(row>=0 && row<=4 && col>=0 && col<=8) {
			if(plants_arr[row][col]!=null && plants_arr[row][col].is_alive()) {
				Plant plant = plants_arr[row][col];
				if(plant.get_name()=="pea_shooter" && economySystem.get_sunshine() >= fertilier_price) {
					economySystem.set_sunshine(economySystem.get_sunshine() - fertilier_price);
					plant.set_health(0);
					Plant new_plant=new GatlingPea("GatlingPea",row,col);
					plants_arr[row][col]=new_plant;
					plants.add(new_plant);
					
					MusicPlayer evolution_sound = new MusicPlayer();
					evolution_sound.setFile("Audio\\evolution.wav");
					evolution_sound.start();
					
				}
				
				if(plant.get_name()=="wall_nut" && economySystem.get_sunshine() >= fertilier_price) {
					economySystem.set_sunshine(economySystem.get_sunshine() - fertilier_price);
					plant.set_health(0);
					Plant new_plant=new TallNut("TallNut",row,col);
					plants_arr[row][col]=new_plant;
					plants.add(new_plant);
					
					MusicPlayer evolution_sound = new MusicPlayer();
					evolution_sound.setFile("Audio\\evolution.wav");
					evolution_sound.start();
				}
				
			}
		}
	}
	
}
