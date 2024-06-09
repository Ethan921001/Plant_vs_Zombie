package model.system;

import java.util.*;

import view.*;
import controller.*;
import controller.card.Card;
import controller.card.PeaShooterCard;
import controller.card.SunFlowerCard;
import controller.card.WallNutCard;
import model.Entity.*;
import model.Entity.plant.Plant;
import model.Entity.zombie.Zombie;


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
	private GameoverWindow gameoverWindow;
	
	private PauseWindow pauseWindow;
	private Judger judger;
	private EconomySystem economySystem;
	private Shovel shovel;
	private Fertilizer fertilizer;
	private GameTimer timer;
	
	
	public GameStage() {
		plants=new ArrayList<Plant>();
		zombies=new ArrayList<Zombie>();
		bullets=new ArrayList<Bullet>();
		entities=new ArrayList<Entity>();
		timer=new GameTimer();
		zombie_factory=new ZombieFactory(timer);
		economySystem=new EconomySystem();
		plant_factory=new PlantFactory(plants,economySystem);
		cards=new ArrayList<Card>();
		initialize_cards();
		judger=new Judger();
		shovel=new Shovel(plant_factory);
		fertilizer = new Fertilizer(plant_factory);
		map_view=new MapView(zombies,plants,bullets,cards,economySystem,judger,shovel,fertilizer,timer);	
		menu_view=new MenuView();
		pauseWindow=new PauseWindow(map_view.getMusicPlayer());
		gameoverWindow=new GameoverWindow();
		
		//map_view.add(new PauseButton());
	
	}
	
	//遊戲主程式迴圈
	public void play_game() {
		
		initialize_cards();
		while(!GameState.gameover) {
			if(GameState.state == 1) {
				menu_view.setVisible(true);
				//menu_view.paint();
				map_view.setVisible(false);
			}
			else if(GameState.state == 2) {
				
				map_view.setVisible(true);
				menu_view.setVisible(false);
				while(!GameState.gameover){
					timer.addTime();
					zombie_factory.summon_zombie(this);			
					judger.plant_shoot(plants, bullets);
					judger.plant_produce_sunshine(plants, economySystem);
					judger.zombie_hit_plant(zombies, plants);
					judger.bullet_hit_zombie(zombies, bullets);
					judger.zombie_died(zombies);
					judger.clean_dead_entities(zombies,plants,bullets);
					economySystem.add_sunshine();
					//更新顯示畫面
					map_view.paint(map_view.getGraphics());
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					
					while(GameState.pause) {
						pauseWindow.setVisible(true);
						System.out.println("");
					}
					pauseWindow.setVisible(false);
					
				}
				
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				GameState.gameover=false;
				while(!GameState.restart&&!GameState.gameover) {
					gameoverWindow.showScore((int)((timer.getTime()-1)*0.6));
					gameoverWindow.setVisible(true);
				}
				gameoverWindow.setVisible(false);
				
			}
		}
		System.out.println("quit");
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
		//cards.add(new Super_PeaShooterCard(plant_factory));
	}
	
	public void reset() {
		plants.clear();
		zombies.clear();
		bullets.clear();
		entities.clear();
		timer.setTimer(0);
		economySystem.set_sunshine(100);
		initialize_cards();
	}
	
	
}