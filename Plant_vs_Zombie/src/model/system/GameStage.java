package model.system;

import java.util.*;

import javax.swing.JFrame;

import view.*;
import model.*;
import controller.*;
import controller.card.Card;
import controller.card.PeaShooterCard;
import controller.card.SunFlowerCard;
import controller.card.WallNutCard;
import model.Entity.*;
import model.Entity.plant.Plant;
import model.Entity.zombie.Zombie;
import model.judger.*;
import Game.Game;
import Game.stop_frame;
import Game.Game.BackgroundFrame;

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
	private MenuView menu_view;
	private Thread thread;
	private Judger judger;
	private EconomySystem economySystem;
	private BackgroundFrame surface;
	private Shovel shovel;
	
	public GameStage() {
		plants=new ArrayList<Plant>();
		zombies=new ArrayList<Zombie>();
		bullets=new ArrayList<Bullet>();
		entities=new ArrayList<Entity>();	
		zombie_factory=new ZombieFactory();
		economySystem=new EconomySystem();
		plant_factory=new PlantFactory(plants,economySystem);
		thread=new Thread();
		cards=new ArrayList<Card>();
		initialize_cards();
		judger=new Judger();
		shovel=new Shovel(plant_factory);
		map_view=new MapView(zombies,plants,bullets,cards,economySystem,judger,shovel);	
		menu_view=new MenuView();
		//map_view.add(new PauseButton());
	
	}
	
	//遊戲主程式迴圈
	public void play_game() {
		
		initialize_cards();
		while(true) {
			if(GameState.state == 1) {
				menu_view.setVisible(true);
				//menu_view.paint();
				map_view.setVisible(false);
			}
			else if(GameState.state == 2) {
				map_view.setVisible(true);
				menu_view.setVisible(false);
				while(true){
					zombie_factory.summon_zombie(this);			
					judger.plant_shoot(plants, bullets);
					judger.plant_produce_sunshine(plants, economySystem);
					judger.zombie_hit_plant(zombies, plants);
					judger.bullet_hit_zombie(zombies, bullets);
					judger.zombie_died(zombies);
					judger.clean_dead_entities(zombies,plants,bullets);
					economySystem.add_sunshine();
					//更新顯示畫面
					map_view.paint();
					try {
						thread.sleep(100);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				
			}
			else if(GameState.state == 3) {
				map_view.setVisible(false);
				surface.setVisible(false);
				while(true) {
					System.out.println("");
				}
				
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
		cards.add(new SunFlowerCard(plant_factory));
	}
	
	
}