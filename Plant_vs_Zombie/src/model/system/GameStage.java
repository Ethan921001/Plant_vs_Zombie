package model.system;

import java.util.*;

import javax.swing.JFrame;

import view.*;
import model.*;
import model.Entity.*;
import model.judger.*;

//遊戲中所有model將在這裡被調用
public class GameStage {
	
	private ArrayList<Plant> plants;
	private ArrayList<Zombie> zombies;
	private ArrayList<Bullet> bullets;
	private ArrayList<Entity> entities;
	private ZombieFactory zombie_factory;
	private MapView map_view;
	private Thread thread;
	private Judger judger;
	public GameStage() {
		plants=new ArrayList<Plant>();
		zombies=new ArrayList<Zombie>();
		bullets=new ArrayList<Bullet>();
		entities=new ArrayList<Entity>();	
		zombie_factory=new ZombieFactory();
		thread=new Thread();
		map_view=new MapView(entities);
		judger=new Judger();
	}
	
	//遊戲主程式迴圈
	public void play_game() {
		
		for(int i=0;i<=4;i++) {
			Plant plant = new Plant("p", i, 1);
			plants.add(plant);
			entities.add(plant);
		}
		
		while(true){
			zombie_factory.summon_zombie(this);			
			for(int i=0;i<entities.size();i++) {
				Entity entity=entities.get(i);
				if(entity.get_x()<200) {
					entity.turn_to_die();
				}
				else {
					entity.move();
				}	
			}
			
			for(int i=0;i<plants.size();i++) {
				Plant plant=plants.get(i);
				if(plant.shoot()) {
					Bullet bullet = new Bullet("bullet",plant.get_row(), plant.get_col());
					entities.add(bullet);
					bullets.add(bullet);
				}
				
			}
			
			judger.zombie_hit_plant(zombies, plants);
			judger.bullet_hit_zombie(zombies, bullets);
			judger.dead_judge(entities);
			judger.clean_dead_entities(entities,zombies,plants,bullets);
			//更新顯示畫面
			map_view.paint();
			try {
				thread.sleep(30);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void add_zombie(Zombie zombie) {
		zombies.add(zombie);
	}
	public void add_entity(Entity entity) {
		entities.add(entity);
	}
	
	
	
}
