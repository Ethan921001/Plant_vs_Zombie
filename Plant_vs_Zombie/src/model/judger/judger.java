package model.judger;

import java.util.ArrayList;

// import model.Entity.Plant;
// import model.Entity.Zombie;
import model.Entity.*;

public class judger {
	
	public void dead_judge(ArrayList<Entity> e) {
		for(Entity obj : e) {
			if(obj.get_health() <= 0) obj.set_alive(false);
		}
	}
	
	public void dead_entities(ArrayList<Entity> e) {
		for(int i = 0; i < e.size(); i++) {
			if(!e.get(i).is_alive()) {
				e.remove(i);
				i--;
			}
		}
	}
	
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
