package model.system;

public class EconomySystem {
	private int sunshine;
	private int increasing_rate;
	public EconomySystem() {
		sunshine=0;
		increasing_rate=1;
	}
	
	public int get_sunshine() {
		return this.sunshine;
	}
	
	public void add_sunshine() {
		this.sunshine += increasing_rate;
	}
	
	public void set_sunshine(int x) {
		this.sunshine = x;
	}
	
	public void add_increasing_rate(int rate) {
		increasing_rate+=rate;
	}
}
