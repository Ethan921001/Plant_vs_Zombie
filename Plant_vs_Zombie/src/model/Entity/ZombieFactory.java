package model.Entity;

import java.util.ArrayList;
import java.util.Random;

import model.system.GameStage;

//生產殭屍
public class ZombieFactory {
	
	private int counter;
	static final int summon_time =50;
	
	public ZombieFactory() {
		this.counter=0;
	}
	
	public void summon_zombie(GameStage stage) {
		if(counter<summon_time) {
			counter++;
		}
		else {
			set_counter(0);
			Random random = new Random();
			int rand_row = random.nextInt(0, 5);
			System.out.println(rand_row);
			Zombie zombie = new Zombie("z", rand_row, 9);
			stage.add_entity(zombie);
			stage.add_zombie(zombie);
		}	
	
	}
	
	public void set_counter(int n) {
		counter=0;
	}
}
