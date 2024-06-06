package model.system;

public class GameTimer {

	int time;
	
	public GameTimer() {
		time=0;
	}
	
	public void setTimer(int time){
		this.time=time;
	}
	
	public void addTime() {
		this.time++;
		System.out.println("Time:"+this.time);
	}
	
	public int getTime() {
		return time;
	}
}
