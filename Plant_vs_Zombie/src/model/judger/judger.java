package model.judger;

import java.util.ArrayList;

import model.Entity.Plant;
import model.Entity.Zombie;

public class judger {
	
	//碰撞判定
	public void zombie_hit_plant(ArrayList<Zombie> zombies, ArrayList<Plant> plants) {
		for(int i=0;i<zombies.size();i++) {
			for(int j=0;j<plants.size();j++) {
				Zombie zombie=zombies.get(i);
				Plant plant = plants.get(j);
				if(zombie.zombie_hit(plant)) {
					//zombie attsck, plant hp--
				}
			}
		}
	}
	
	
	
	
>>>>>>> branch 'master' of https://github.com/Ethan921001/Plant_vs_Zombie.git
}
