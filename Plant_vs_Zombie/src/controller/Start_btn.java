package controller;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import model.system.GameStage;

public class Start_btn extends Button{

	public Start_btn(Button button) {
		super(button);
		setBounds(652, 123, button.get_width(), button.get_height());
		setFont(new Font("Arial",Font.PLAIN,30));
		
		addMouseListener((MouseListener) new MouseAdapter() {
	            
	            public void mouseClicked(MouseEvent e) {
	            	stage.stage = 2;
	                System.out.println("Button clicked!");
	            }

	            
	            public void mousePressed(MouseEvent e) {
	                System.out.println("Mouse pressed on button!");
	            }

	            
	            public void mouseReleased(MouseEvent e) {
	                System.out.println("Mouse released from button!");
	            }

	            
	            public void mouseEntered(MouseEvent e) {
	                System.out.println("Mouse entered button!");
	            }

	            
	            public void mouseExited(MouseEvent e) {
	                System.out.println("Mouse exited button!");
	            }
	     });
	}
}
