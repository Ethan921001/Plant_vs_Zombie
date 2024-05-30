package controller;

import java.awt.BorderLayout;import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JWindow;


	    public class StopButton extends Button {
	        public StopButton(Button button) {
	            super(button);
	            setBounds(900, 270, button.getWidth(), button.getHeight());
	            
	            addMouseListener(new MouseAdapter() {
	                public void mouseClicked(MouseEvent e) {
	                    stage.stage = 3;
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
	

