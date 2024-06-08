package model.Entity.plant;

public class WallNut extends Plant {
	
	private String imgsrc_cracked1="Images/Plants/Wallnut_cracked1.gif";
	private String imgsrc_cracked2="Images/Plants/Wallnut_cracked2.gif";
	
	public WallNut(String name, int row, int col) {
		super(name, row, col);
		set_bounding_box_height(70);
		set_bounding_box_width(65);
		set_speed(0);
		set_imgsrc("Images/Plants/WallNut.gif");
		set_max_health(30);
		set_health(30);
	}
	
	@Override
	public String get_imgsrc() {
		if(get_health()>Math.round(0.66*get_max_health())){
			return super.get_imgsrc();
		}
		if(get_health()>Math.round(0.33*get_max_health())){
			return getImgsrcCracked1();
		}
		return getImgsrcCracked2();
		
	}
	
	public void setImgsrcCracked1(String imgsrc) {
		this.imgsrc_cracked1=imgsrc;
	}
	
	public void setImgsrcCracked2(String imgsrc) {
		this.imgsrc_cracked2=imgsrc;
	}
	
	public String getImgsrcCracked1() {
		return imgsrc_cracked1;
	}
	
	public String getImgsrcCracked2() {
		return imgsrc_cracked2;
	}
	
}
