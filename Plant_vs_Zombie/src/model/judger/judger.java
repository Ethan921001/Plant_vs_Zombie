package model.judger;

import java.util.ArrayList;

// import model.Entity.Plant;
// import model.Entity.Zombie;
import model.Entity.*;

public class judger {
<<<<<<< HEAD
=======
	
	public void dead_judge(ArrayList<Entity> e) {
		for(Entity obj : e) {
			if(obj.get_health() <= 0) obj.set_alive(false);
		}
	}
	
	public void dead_entities(Arraylist<Entity> e) {
		for(Entity obj : e) {
			//
		}
	}
>>>>>>> branch 'master' of https://github.com/Ethan921001/Plant_vs_Zombie.git
	
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
	
	
	
}
