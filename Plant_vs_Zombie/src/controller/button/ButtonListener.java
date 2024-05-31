package controller.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.GameState;

public class ButtonListener implements ActionListener{
	
	private String action;
	
	public ButtonListener(String action) {
		this.action=action;
	}
	
	public void actionPerformed(ActionEvent e){
		switch (action) {
		case "Start": {
			GameState.state=2;
			break;
		}
		case "Pause":{
			GameState.state=3;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
	}
}
