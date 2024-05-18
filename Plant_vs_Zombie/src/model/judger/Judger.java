package model.judger;

import java.util.ArrayList;

// import model.Entity.Plant;
// import model.Entity.Zombie;
import model.Entity.*;

public class Judger {
	
	public void dead_judge(ArrayList<Entity> e) {
		for(Entity obj : e) {
			if(obj.get_health() <= 0) obj.set_alive(false);
		}
	}
	
	public void clean_dead_entities(ArrayList<Entity> e, ArrayList<Zombie> zombies, ArrayList<Plant> plants, ArrayList<Bullet> bullets) {
		for(int i = 0; i < e.size(); i++) {
			if(!e.get(i).is_alive()) {
				e.remove(i);
				i--;
			}
		}
		
		for(int i = 0; i < zombies.size(); i++) {
			if(!zombies.get(i).is_alive()) {
				zombies.remove(i);
				i--;
			}
		}
		
		for(int i = 0; i < plants.size(); i++) {
			if(!plants.get(i).is_alive()) {
				plants.remove(i);
				i--;
			}
		}
		
		for(int i = 0; i < bullets.size(); i++) {
			if(!bullets.get(i).is_alive()) {
				bullets.remove(i);
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
					zombie.turn_to_attack();
					plant.set_health(plant.get_health()-1);
				}
			}
		}
	}
	
	public void bullet_hit_zombie(ArrayList<Zombie> zombies, ArrayList<Bullet> bullets) {
		for(int i=0;i<zombies.size();i++) {
			for(int j=0;j<bullets.size();j++) {
				Zombie zombie=zombies.get(i);
				Bullet bullet = bullets.get(j);
				if(bullet.bullet_hit(zombie)) {
					bullet.set_health(bullet.get_health()-1);
					zombie.set_health(zombie.get_health()-1);
				}
			}
		}
	}
	
	
	
}
