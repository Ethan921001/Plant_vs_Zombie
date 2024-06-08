package model.judger;

import java.util.ArrayList;

// import model.Entity.Plant;
// import model.Entity.Zombie;
import model.Entity.*;
import model.Entity.plant.Plant;
import model.Entity.zombie.Zombie;
import model.system.EconomySystem;
import model.system.MusicPlayer;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class Judger {
	
	private ArrayList<Entity> entities;
	//private Clip attackClip,shootClip;
	private MusicPlayer attackSound,hitSound;
	//private AudioInputStream audioStream;
	
	public Judger() {
		//attackSound = new MusicPlayer();
		//attackSound.setFile("Audio/chompWAV.wav");
		//hitSound = new MusicPlayer();
		//hitSound.setFile("Audio/hitWAV.wav");
		
		/*
		try {
			audioStream = AudioSystem.getAudioInputStream(new File("Audio/chompWAV.wav"));
			attackClip = AudioSystem.getClip();
			attackClip.open(audioStream);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		
	}
	
	public void set_entities(ArrayList<Zombie> zombies, ArrayList<Plant> plants, ArrayList<Bullet> bullets) {
		entities.clear();
		entities.addAll(zombies);
		entities.addAll(plants);
		entities.addAll(bullets);
	}

	public void clean_dead_entities(ArrayList<Zombie> zombies, ArrayList<Plant> plants, ArrayList<Bullet> bullets) {
		for(int i = 0; i < zombies.size(); i++) {
			Zombie zombie =zombies.get(i);
			if(!zombie.is_alive() && zombie.died_time_out()) {
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
			boolean hit = false;
			Zombie zombie=zombies.get(i);
			for(int j=0;j<plants.size();j++) {
				Plant plant = plants.get(j);
				if(zombie.zombie_hit(plant)) {
					hit=true;
					if(zombie.attackReady()) {
						plant.set_health(plant.get_health()-1);
						attackSound = new MusicPlayer();
						//attackSound.setFile("Audio/chomp1.wav");
						attackSound.setFile("Audio/bite_2.wav");
						attackSound.start();	
					}		
				}
			}
			if(hit) {
				zombie.turn_to_attack();
			}
			else if(zombie.is_alive()){
				zombie.turn_to_walk();
				zombie.move();
			}
			
		}
	}
	
	public void bullet_hit_zombie(ArrayList<Zombie> zombies, ArrayList<Bullet> bullets) {
		for(int i=0;i<bullets.size();i++) {
			Bullet bullet = bullets.get(i);
			bullet.move();
			for(int j=0;j<zombies.size();j++) {
				Zombie zombie=zombies.get(j);
				if(bullet.bullet_hit(zombie) && zombie.is_alive()) {
					
					//new MusicPlayer().start();
					hitSound=new MusicPlayer();
					hitSound.setFile("Audio/hit.wav");
					hitSound.start();
					/*
					if (hit) {
						//hitSound.play();
						
					}
					if (hitSound.isAlive()) {
						System.out.println("is alive");
					}
					else {
						System.out.println("not alive");
					}*/
					//hitSound.play();
					bullet.set_health(bullet.get_health()-1);
					zombie.set_health(zombie.get_health()-1);
				}/*
				else if (hitSound.isplaying()){
					hitSound.stop();
				}*/
					
			}
		}
	}
	
	public void plant_shoot(ArrayList<Plant> plants, ArrayList<Bullet> bullets) {
		for(Plant plant : plants) {
			if(plant.shoot()) {
				Bullet bullet = new Bullet("bullet", plant.get_row(), plant.get_col());
				bullets.add(bullet);
			}
		}
	}
	//擁有生產陽光能力的植物生產陽光
	public void plant_produce_sunshine(ArrayList<Plant> plants, EconomySystem economySystem) {
		for(Plant plant:plants) {
			if(plant.produce_sunshine()) {
				economySystem.add_sunshine();
			}
		}
	}
	
	public void zombie_died(ArrayList<Zombie> zombies) {
		for(int i = 0; i < zombies.size(); i++) {
			Zombie zombie =zombies.get(i);
			if(!zombie.is_alive()) {
				zombie.turn_to_die();
				/*
				if (attackSound.isplaying()) {
					attackSound.musicStop();
				}
				*/
				/*
				if (attackClip != null && attackClip.isRunning()) {
					attackClip.stop();
				}*/
			}
		}
	}
	
	public boolean gameover(ArrayList<Zombie> zombies) {
		for (int i=0; i < zombies.size();i++) {
			Zombie zombie = zombies.get(i);
			if (zombie.get_x()<=200) {
				return true;
			}
		}
		return false;
	}
}
