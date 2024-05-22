package test;


import java.awt.Graphics;
import java.awt.Image;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.*;
import model.Entity.*;
import model.Entity.plant.Plant;
import model.Entity.zombie.Zombie;

public class test2 extends JPanel{
	
	Graphics graphics;
	Image img;
	
	public test2() {
	}
	
	
	static public void main(String[] args) {
	
		
		ArrayList<Entity> entities=new ArrayList<Entity>();
		
		for(int i=0; i<=4; i++) {
			Plant p =new Plant("p", i, i);
			Zombie z= new Zombie("z",i,i);
			System.out.printf("x: %d y: %d \n",z.get_x(), z.get_y());
			entities.add(z);
			entities.add(p);
		}
		
		//MapView ev = new MapView(entities);
		//ev.paint();

	}

}
