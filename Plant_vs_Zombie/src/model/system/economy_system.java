package model.system;

public class economy_system {
	private int sunshine;
	
	
	public int get_sun() {
		return this.sunshine;
	}
	
	public void add_sun(int x) {
		this.sunshine += x;
	}
	
	public void set_sun(int x) {
		this.sunshine = x;
	}
}
