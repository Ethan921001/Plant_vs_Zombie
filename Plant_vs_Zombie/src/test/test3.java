package test;

import model.system.GameStage;
import Game.Game;
import Game.Game.BackgroundFrame;
import controller.GameState;
import model.system.MusicPlayer;
public class test3 {
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
