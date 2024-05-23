package model.system;

import java.util.*;
import javax.swing.JFrame;

import view.*;
import model.*;
import model.Cards.Card;
import model.Cards.PeaShooterCard;
import model.Cards.WallNutCard;
import model.Entity.*;
import model.Entity.plant.Plant;
import model.Entity.zombie.Zombie;
import model.judger.*;

//遊戲中所有model將在這裡被調用
public class GameStage {
	
	private ArrayList<Card> cards;
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
		cards=new ArrayList<Card>();
		initialize_cards();
		judger=new Judger();
		map_view=new MapView(zombies,plants,bullets,cards,judger);
	}
	
	//遊戲主程式迴圈
	public void play_game() {
		
		initialize_cards();
		while(true){
			zombie_factory.summon_zombie(this);			
			judger.plant_shoot(plants, bullets);
			judger.zombie_hit_plant(zombies, plants);
			judger.bullet_hit_zombie(zombies, bullets);
			judger.zombie_died(zombies);
			judger.clean_dead_entities(zombies,plants,bullets);
			//更新顯示畫面
			map_view.paint();
			map_view.gameover_view();
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
	
	public void initialize_cards() {
		cards.add(new PeaShooterCard(plant_factory));
		cards.add(new WallNutCard(plant_factory));
	}
	
	
}