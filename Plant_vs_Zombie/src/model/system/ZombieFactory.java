package model.system;

import java.util.Random;

import model.Entity.zombie.BucketZombie;
import model.Entity.zombie.ConeZombie;
import model.Entity.zombie.Zombie;
//生產殭屍
public class ZombieFactory {
	
	static final int summon_time =50;
	private GameTimer timer;
	private int counter;
	
	public ZombieFactory(GameTimer timer) {
		this.timer=timer;
	}
	
	public void summon_zombie(GameStage stage) {
		counter++;
		if(counter%50==0){
			Random random = new Random();
			int rand_row = random.nextInt(0, 5);
			System.out.println("random row : "+rand_row);
			int rand_zombie = random.nextInt(0,timer.getTime());		
			Zombie zombie;
			if(rand_zombie<=200){
				zombie = new Zombie("Zombie", rand_row, 9);
			}
			else if(rand_zombie<=400) {
				zombie = new ConeZombie("ConeZombie", rand_row, 9);
			}
			else{
				zombie = new BucketZombie("BucketZombie", rand_row, 9);

			}
			stage.add_entity(zombie);
			stage.add_zombie(zombie);
			counter=0;
		}	
	
	}
	
}
