package Entities;


//實體抽象類； 實體:有碰撞行為的物件，如:植物、殭屍、子彈
public abstract class Entity {
	
	//xy座標
	private int x, y;
	//生命值
	private int  health;
	//圖像路徑
	private String imgsrc;
	//碰撞箱長、寬
	private int bounding_box_width, boundong_box_height;
	
}
