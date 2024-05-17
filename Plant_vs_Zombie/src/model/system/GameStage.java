package model.system;

import java.util.*;

import javax.swing.JFrame;

import view.*;
import model.*;
import model.Entity.*;

//遊戲中所有model將在這裡被調用
public class GameStage {
	
	private ArrayList<Plant> plants;
	private ArrayList<Zombie> zombies;
	private ArrayList<Entity> entities;
	private ZombieFactory zombie_factory;
	private MapView map_view;
	private Thread thread;
	public GameStage() {
		plants=new ArrayList<Plant>();
		zombies=new ArrayList<Zombie>();
		entities=new ArrayList<Entity>();	
		zombie_factory=new ZombieFactory();
		thread=new Thread();
		map_view=new MapView(entities);
	}
	
	//遊戲主程式迴圈
	public void play_game() {
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
