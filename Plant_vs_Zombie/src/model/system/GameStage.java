package model.system;

import java.util.*;

import javax.swing.JFrame;

import view.*;
import model.*;
import model.Cards.Card;
import model.Entity.*;
import model.Entity.plant.Plant;
import model.Entity.zombie.Zombie;
import model.judger.*;

//遊戲中所有model將在這裡被調用
public class GameStage {
	
	private Card card;
	private ArrayList<Plant> plants;
	private ArrayList<Zombie> zombies;
	private ArrayList<Bullet> bullets;
	private ArrayList<Entity> entities;
	private ZombieFactory zombie_factory;
	private PlantFactory plant_factory;
	private MapView map_view;
	private Thread thread;
	private Judger judger;
	public GameStage() {
		plants=new ArrayList<Plant>();
		zombies=new ArrayList<Zombie>();
		bullets=new ArrayList<Bullet>();
		entities=new ArrayList<Entity>();	
		zombie_factory=new ZombieFactory();
		plant_factory=new PlantFactory(plants);
		thread=new Thread();
		card=new Card(plant_factory);
		map_view=new MapView(zombies,plants,bullets,card);
		judger=new Judger();
	}
	
	//遊戲主程式迴圈
	public void play_game() {

		while(true){
			zombie_factory.summon_zombie(this);			
			judger.plant_shoot(plants, bullets);
			judger.zombie_hit_plant(zombies, plants);
			judger.bullet_hit_zombie(zombies, bullets);
			judger.clean_dead_entities(zombies,plants,bullets);
			//更新顯示畫面
			map_view.paint();
			try {
				thread.sleep(70);
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
