package test;

import model.system.GameStage;
import Game.Game;
import Game.Game.BackgroundFrame;
import model.system.MusicPlayer;
public class test3 {
	public static void main(String[] args) {
		GameStage stage = new GameStage();
		MusicPlayer player = new MusicPlayer();
		player.music_play();
		stage.play_game();
	}
}
