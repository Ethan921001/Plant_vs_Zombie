package test;

import model.system.GameStage;
import model.system.GameState;
import model.system.MusicPlayer;
public class Test3 {
	public static void main(String[] args) {
		GameStage stage = new GameStage();
		do {
			GameState.gameover=false;
			GameState.restart=false;
			stage.reset();
			stage.play_game();
		}while(GameState.restart);

		System.exit(0);
	}
}
