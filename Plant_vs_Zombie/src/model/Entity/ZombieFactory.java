package model.Entity;

import java.util.ArrayList;
import java.util.Random;

import model.Entity.zombie.BucketZombie;
import model.Entity.zombie.ConeZombie;
import model.Entity.zombie.Zombie;
import model.system.GameStage;

//生產殭屍
public class ZombieFactory {
	
	private int counter;
	static final int summon_time =50;
	
	public ZombieFactory() {
		this.counter=0;
	}
	
	public void summon_zombie(GameStage stage) {
		counter++;
		
		if(counter%50==0){
			set_counter(0);
			Random random = new Random();
			int rand_row = random.nextInt(0, 5);
			System.out.println("random row : "+rand_row);
			int rand_zombie = random.nextInt(0,3);
			System.out.println("random zombie : "+rand_zombie);
			Zombie zombie = new Zombie("Zombie", rand_row, 9);
			/*
			switch (rand_zombie) {
				case 0 :
					zombie = new Zombie("Zombie", rand_row, 9);
					break;
				case 1 :
					zombie = new BucketZombie("BucketZombie", rand_row, 9);
					break;
				case 2 :
					zombie = new ConeZombie("ConeZombie", rand_row, 9);
					break;
				default :
					zombie = new Zombie("Zombie", rand_row, 9);
					break;
			}*/
			stage.add_entity(zombie);
			stage.add_zombie(zombie);
		}	
	
	}
	
	public void set_counter(int n) {
		counter=0;
	}
}
